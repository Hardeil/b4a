package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgslide = null;
public anywheresoftware.b4a.objects.collections.List _images = null;
public static String _phpurl = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public b4a.example.idlescreensaver _idlescreen = null;
public anywheresoftware.b4a.objects.ButtonWrapper _on = null;
public static boolean _show = false;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="idleScreen.Initialize(Activity,10000) ' Set 10 se";
mostCurrent._idlescreen._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,(int) (10000));
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="Images.Initialize";
mostCurrent._images.Initialize();
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Images.Add(LoadBitmap(File.DirAssets, \"cyduck.jpg";
mostCurrent._images.Add((Object)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"cyduck.jpg").getObject()));
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="Images.Add(LoadBitmap(File.DirAssets, \"pokemon.pn";
mostCurrent._images.Add((Object)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pokemon.png").getObject()));
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="Images.Add(LoadBitmap(File.DirAssets, \"profile.jp";
mostCurrent._images.Add((Object)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"profile.jpg").getObject()));
RDebugUtils.currentLine=196620;
 //BA.debugLineNum = 196620;BA.debugLine="imgSlide.Visible = False";
mostCurrent._imgslide.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="ScrollView1.Width = Activity.Width";
mostCurrent._scrollview1.setWidth(mostCurrent._activity.getWidth());
RDebugUtils.currentLine=196623;
 //BA.debugLineNum = 196623;BA.debugLine="ScrollView1.Height = Activity.Height";
mostCurrent._scrollview1.setHeight(mostCurrent._activity.getHeight());
RDebugUtils.currentLine=196624;
 //BA.debugLineNum = 196624;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Job1.Initialize(\"LoadData\", Me)";
_job1._initialize /*String*/ (null,processBA,"LoadData",main.getObject());
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
_xui.MsgboxAsync(processBA,BA.ObjectToCharSequence("Hello world!"),BA.ObjectToCharSequence("B4X"));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _createroundbitmap(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _input,int _size) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createroundbitmap", false))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) Debug.delegate(mostCurrent.activityBA, "createroundbitmap", new Object[] {_input,_size}));}
int _l = 0;
anywheresoftware.b4a.objects.B4XCanvas _c = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xview = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _path = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _res = null;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub CreateRoundBitmap (Input As B4XBitmap, Size As";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="If Input.Width <> Input.Height Then";
if (_input.getWidth()!=_input.getHeight()) { 
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim l As Int = Min(Input.Width, Input.Height)";
_l = (int) (anywheresoftware.b4a.keywords.Common.Min(_input.getWidth(),_input.getHeight()));
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Input = Input.Crop(Input.Width / 2 - l / 2, Inpu";
_input = _input.Crop((int) (_input.getWidth()/(double)2-_l/(double)2),(int) (_input.getHeight()/(double)2-_l/(double)2),_l,_l);
 };
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="Dim c As B4XCanvas";
_c = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
_xview = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xview = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, Size, Size)";
_xview.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_size,_size);
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="c.Initialize(xview)";
_c.Initialize(_xview);
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="path.InitializeOval(c.TargetRect)";
_path.InitializeOval(_c.getTargetRect());
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="c.ClipPath(path)";
_c.ClipPath(_path);
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="c.DrawBitmap(Input.Resize(Size, Size, False), c.T";
_c.DrawBitmap((android.graphics.Bitmap)(_input.Resize(_size,_size,anywheresoftware.b4a.keywords.Common.False).getObject()),_c.getTargetRect());
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="c.RemoveClip";
_c.RemoveClip();
RDebugUtils.currentLine=327695;
 //BA.debugLineNum = 327695;BA.debugLine="c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.C";
_c.DrawCircle(_c.getTargetRect().getCenterX(),_c.getTargetRect().getCenterY(),(float) (_c.getTargetRect().getWidth()/(double)2-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (0),(int) (0)),anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="c.Invalidate";
_c.Invalidate();
RDebugUtils.currentLine=327697;
 //BA.debugLineNum = 327697;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
_res = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_res = _c.CreateBitmap();
RDebugUtils.currentLine=327698;
 //BA.debugLineNum = 327698;BA.debugLine="c.Release";
_c.Release();
RDebugUtils.currentLine=327699;
 //BA.debugLineNum = 327699;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=327700;
 //BA.debugLineNum = 327700;BA.debugLine="End Sub";
return null;
}
public static String  _itempanel_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "itempanel_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "itempanel_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub ItemPanel_Touch (Action As Int, X As Float, Y";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Log(\"User is Active Now (ItemPanel Touched)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("4393217","User is Active Now (ItemPanel Touched)",0);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _ypos = 0;
int _margin = 0;
int _totalheight = 0;
int _id_display = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
String _name = "";
String _imagebase64 = "";
anywheresoftware.b4a.objects.StringUtils _su = null;
byte[] _imagebytes = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imageview = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _imagebitmap = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _inputstream = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _roundedbitmap = null;
anywheresoftware.b4a.objects.LabelWrapper _namelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _studentidlabel = null;
anywheresoftware.b4a.objects.PanelWrapper _itempanel = null;
anywheresoftware.b4a.objects.LabelWrapper _id = null;
anywheresoftware.b4a.objects.PanelWrapper _horizontallayout = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Try";
try {RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="Dim Margin As Int = 10dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="Dim TotalHeight As Int = 0 ' To calculate total";
_totalheight = (int) (0);
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="Dim id_display = 1 As Int";
_id_display = (int) (1);
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group11 = mostCurrent._tabledetails;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group11.Get(index11)));
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="Dim name As String = record.Get(\"name\")";
_name = BA.ObjectToString(_record.Get((Object)("name")));
RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="Dim imageBase64 As String = record.Get(\"image\"";
_imagebase64 = BA.ObjectToString(_record.Get((Object)("image")));
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="Dim ImageBytes() As Byte = su.DecodeBase64(ima";
_imagebytes = _su.DecodeBase64(_imagebase64);
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="Dim ImageView As ImageView";
_imageview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="ImageView.Initialize(\"\")";
_imageview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="ImageView.Gravity = Gravity.CENTER_HORIZONTAL";
_imageview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="Dim ImageBitmap As Bitmap";
_imagebitmap = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=262169;
 //BA.debugLineNum = 262169;BA.debugLine="Dim InputStream As InputStream";
_inputstream = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=262170;
 //BA.debugLineNum = 262170;BA.debugLine="InputStream.InitializeFromBytesArray(ImageByte";
_inputstream.InitializeFromBytesArray(_imagebytes,(int) (0),_imagebytes.length);
RDebugUtils.currentLine=262171;
 //BA.debugLineNum = 262171;BA.debugLine="ImageBitmap.Initialize2(InputStream)";
_imagebitmap.Initialize2((java.io.InputStream)(_inputstream.getObject()));
RDebugUtils.currentLine=262174;
 //BA.debugLineNum = 262174;BA.debugLine="ImageBitmap = ImageBitmap.Resize(100%x, 100%y,";
_imagebitmap = _imagebitmap.Resize((float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)),(float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=262177;
 //BA.debugLineNum = 262177;BA.debugLine="Dim RoundedBitmap As B4XBitmap = CreateRoundBi";
_roundedbitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_roundedbitmap = _createroundbitmap((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(_imagebitmap.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
RDebugUtils.currentLine=262178;
 //BA.debugLineNum = 262178;BA.debugLine="ImageView.Bitmap = RoundedBitmap";
_imageview.setBitmap((android.graphics.Bitmap)(_roundedbitmap.getObject()));
RDebugUtils.currentLine=262180;
 //BA.debugLineNum = 262180;BA.debugLine="Dim NameLabel As Label";
_namelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262181;
 //BA.debugLineNum = 262181;BA.debugLine="NameLabel.Initialize(\"\")";
_namelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262182;
 //BA.debugLineNum = 262182;BA.debugLine="NameLabel.Text = name";
_namelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=262183;
 //BA.debugLineNum = 262183;BA.debugLine="NameLabel.TextSize = 1%y";
_namelabel.setTextSize((float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=262184;
 //BA.debugLineNum = 262184;BA.debugLine="NameLabel.TextColor = Colors.Black";
_namelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262185;
 //BA.debugLineNum = 262185;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
_namelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew(anywheresoftware.b4a.keywords.Common.Typeface.SERIF,anywheresoftware.b4a.keywords.Common.Typeface.STYLE_BOLD));
RDebugUtils.currentLine=262186;
 //BA.debugLineNum = 262186;BA.debugLine="NameLabel.Gravity = Gravity.CENTER";
_namelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262188;
 //BA.debugLineNum = 262188;BA.debugLine="Dim StudentIdLabel As Label";
_studentidlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262189;
 //BA.debugLineNum = 262189;BA.debugLine="StudentIdLabel.Initialize(\"\")";
_studentidlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262190;
 //BA.debugLineNum = 262190;BA.debugLine="StudentIdLabel.Text = \"SCC-213123-123123\"";
_studentidlabel.setText(BA.ObjectToCharSequence("SCC-213123-123123"));
RDebugUtils.currentLine=262191;
 //BA.debugLineNum = 262191;BA.debugLine="StudentIdLabel.TextSize = 15";
_studentidlabel.setTextSize((float) (15));
RDebugUtils.currentLine=262192;
 //BA.debugLineNum = 262192;BA.debugLine="StudentIdLabel.TextColor = Colors.ARGB(255, 12";
_studentidlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (128),(int) (128),(int) (128)));
RDebugUtils.currentLine=262193;
 //BA.debugLineNum = 262193;BA.debugLine="StudentIdLabel.Gravity = Gravity.CENTER";
_studentidlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262194;
 //BA.debugLineNum = 262194;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
_namelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew(anywheresoftware.b4a.keywords.Common.Typeface.SERIF,anywheresoftware.b4a.keywords.Common.Typeface.STYLE_NORMAL));
RDebugUtils.currentLine=262196;
 //BA.debugLineNum = 262196;BA.debugLine="NameLabel.Typeface = Typeface.DEFAULT_BOLD";
_namelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=262197;
 //BA.debugLineNum = 262197;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262198;
 //BA.debugLineNum = 262198;BA.debugLine="ItemPanel.Initialize(\"ItemPanel\")";
_itempanel.Initialize(mostCurrent.activityBA,"ItemPanel");
RDebugUtils.currentLine=262199;
 //BA.debugLineNum = 262199;BA.debugLine="ItemPanel.SetLayout(0, YPos, 100%x, 18%y)";
_itempanel.SetLayout((int) (0),_ypos,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=262200;
 //BA.debugLineNum = 262200;BA.debugLine="ItemPanel.Color = Colors.White";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=262202;
 //BA.debugLineNum = 262202;BA.debugLine="Dim id As Label";
_id = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262203;
 //BA.debugLineNum = 262203;BA.debugLine="id.Initialize(\"\")";
_id.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262204;
 //BA.debugLineNum = 262204;BA.debugLine="id.Text = id_display";
_id.setText(BA.ObjectToCharSequence(_id_display));
RDebugUtils.currentLine=262205;
 //BA.debugLineNum = 262205;BA.debugLine="id.TextSize = 24";
_id.setTextSize((float) (24));
RDebugUtils.currentLine=262207;
 //BA.debugLineNum = 262207;BA.debugLine="Dim HorizontalLayout As Panel";
_horizontallayout = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262208;
 //BA.debugLineNum = 262208;BA.debugLine="HorizontalLayout.Initialize(\"\")";
_horizontallayout.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262209;
 //BA.debugLineNum = 262209;BA.debugLine="HorizontalLayout.SetLayout(0, 0, ItemPanel.Wid";
_horizontallayout.SetLayout((int) (0),(int) (0),_itempanel.getWidth(),_itempanel.getHeight());
RDebugUtils.currentLine=262211;
 //BA.debugLineNum = 262211;BA.debugLine="HorizontalLayout.AddView(ImageView, 5%x, 2%y,";
_horizontallayout.AddView((android.view.View)(_imageview.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
RDebugUtils.currentLine=262212;
 //BA.debugLineNum = 262212;BA.debugLine="HorizontalLayout.AddView(NameLabel, 25%x, 3%y,";
_horizontallayout.AddView((android.view.View)(_namelabel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA),(int) (_itempanel.getWidth()-_imageview.getWidth()),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA));
RDebugUtils.currentLine=262213;
 //BA.debugLineNum = 262213;BA.debugLine="HorizontalLayout.AddView(id, 3%x, 2%y, 5%x, 5%";
_horizontallayout.AddView((android.view.View)(_id.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA));
RDebugUtils.currentLine=262214;
 //BA.debugLineNum = 262214;BA.debugLine="HorizontalLayout.AddView(StudentIdLabel, 25%x,";
_horizontallayout.AddView((android.view.View)(_studentidlabel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9),mostCurrent.activityBA),(int) (_itempanel.getWidth()-_imageview.getWidth()),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA));
RDebugUtils.currentLine=262215;
 //BA.debugLineNum = 262215;BA.debugLine="HorizontalLayout.Color = Colors.LightGray";
_horizontallayout.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=262216;
 //BA.debugLineNum = 262216;BA.debugLine="HorizontalLayout.Color = Colors.White";
_horizontallayout.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=262218;
 //BA.debugLineNum = 262218;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=262219;
 //BA.debugLineNum = 262219;BA.debugLine="cvs.Initialize(HorizontalLayout)";
_cvs.Initialize((android.view.View)(_horizontallayout.getObject()));
RDebugUtils.currentLine=262222;
 //BA.debugLineNum = 262222;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, 0, Horizo";
_cvs.DrawLine((float) (_horizontallayout.getWidth()),(float) (0),(float) (_horizontallayout.getWidth()),(float) (_horizontallayout.getHeight()),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (16),(int) (64),(int) (34)),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=262223;
 //BA.debugLineNum = 262223;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, Horizonta";
_cvs.DrawLine((float) (_horizontallayout.getWidth()),(float) (_horizontallayout.getHeight()),(float) (0),(float) (_horizontallayout.getHeight()),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (16),(int) (64),(int) (34)),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=262225;
 //BA.debugLineNum = 262225;BA.debugLine="ItemPanel.AddView(HorizontalLayout, 0, 0, Item";
_itempanel.AddView((android.view.View)(_horizontallayout.getObject()),(int) (0),(int) (0),_itempanel.getWidth(),_itempanel.getHeight());
RDebugUtils.currentLine=262226;
 //BA.debugLineNum = 262226;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,S";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),_itempanel.getHeight());
RDebugUtils.currentLine=262227;
 //BA.debugLineNum = 262227;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=262228;
 //BA.debugLineNum = 262228;BA.debugLine="TotalHeight = YPos ' Update total height";
_totalheight = _ypos;
RDebugUtils.currentLine=262229;
 //BA.debugLineNum = 262229;BA.debugLine="id_display = id_display + 1";
_id_display = (int) (_id_display+1);
 }
};
RDebugUtils.currentLine=262233;
 //BA.debugLineNum = 262233;BA.debugLine="ScrollView1.Panel.Height = Max(TotalHeight, 100";
mostCurrent._scrollview1.getPanel().setHeight((int) (anywheresoftware.b4a.keywords.Common.Max(_totalheight,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA))));
 } 
       catch (Exception e70) {
			processBA.setLastException(e70);RDebugUtils.currentLine=262235;
 //BA.debugLineNum = 262235;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=262238;
 //BA.debugLineNum = 262238;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262240;
 //BA.debugLineNum = 262240;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=262241;
 //BA.debugLineNum = 262241;BA.debugLine="End Sub";
return "";
}
public static String  _off_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "off_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "off_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub Off_Click";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _on_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "on_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "on_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub On_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="If show = False Then";
if (_show==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Log(\"on\")";
anywheresoftware.b4a.keywords.Common.LogImpl("4524290","on",0);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="idleScreen.ShowScreenSaver(True)";
mostCurrent._idlescreen._showscreensaver /*String*/ (null,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="ScrollView1.Visible = False";
mostCurrent._scrollview1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="show = True";
_show = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="On.Text = \"Off\"";
mostCurrent._on.setText(BA.ObjectToCharSequence("Off"));
 }else {
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="ScrollView1.Visible = True";
mostCurrent._scrollview1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="idleScreen.ShowScreenSaver(False)";
mostCurrent._idlescreen._showscreensaver /*String*/ (null,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="Log(\"off\")";
anywheresoftware.b4a.keywords.Common.LogImpl("4524298","off",0);
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="show = False";
_show = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="On.Text = \"On\"";
mostCurrent._on.setText(BA.ObjectToCharSequence("On"));
 };
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="Log(show)";
anywheresoftware.b4a.keywords.Common.LogImpl("4524302",BA.ObjectToString(_show),0);
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="End Sub";
return "";
}
public static String  _scrollview1_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "scrollview1_touch", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "scrollview1_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub ScrollView1_Touch (Action As Int, X As Float,";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="If Action = 0 Then ' ACTION_DOWN event";
if (_action==0) { 
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Log(\"User is Active (ScrollView Touched)\")";
anywheresoftware.b4a.keywords.Common.LogImpl("4458754","User is Active (ScrollView Touched)",0);
 };
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="End Sub";
return "";
}
}