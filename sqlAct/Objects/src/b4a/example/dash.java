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

public class dash extends Activity implements B4AActivity{
	public static dash mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.dash");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (dash).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.dash");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.dash", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (dash) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (dash) Resume **");
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
		return dash.class;
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
            BA.LogInfo("** Activity (dash) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (dash) Pause event (activity is not paused). **");
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
            dash mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (dash) Resume **");
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
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static String _phpurl = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _scrollviewpanel = null;
public anywheresoftware.b4a.objects.LabelWrapper _homebutn = null;
public anywheresoftware.b4a.objects.LabelWrapper _studentlistbtn = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public b4a.example.main _main = null;
public b4a.example.charts _charts = null;
public b4a.example.graph _graph = null;
public b4a.example.schedule _schedule = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="dash";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.LabelWrapper _systemlabel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Activity.LoadLayout(\"crud\")";
mostCurrent._activity.LoadLayout("crud",mostCurrent.activityBA);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="ScrollView1.Width = 100%x";
mostCurrent._scrollview1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
mostCurrent._scrollviewpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(mostCurrent._scrollviewpanel.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Dim SystemLabel As Label";
_systemlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="SystemLabel.Initialize(\"\")";
_systemlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="SystemLabel.Text = \"ATTENDANCE SYSTEM\"";
_systemlabel.setText(BA.ObjectToCharSequence("ATTENDANCE SYSTEM"));
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="SystemLabel.TextColor= Colors.White";
_systemlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="SystemLabel.TextSize = 30";
_systemlabel.setTextSize((float) (30));
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="SystemLabel.Typeface = Typeface.CreateNew(Typefac";
_systemlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew(anywheresoftware.b4a.keywords.Common.Typeface.SERIF,anywheresoftware.b4a.keywords.Common.Typeface.STYLE_BOLD));
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="Panel1.AddView(SystemLabel,20dip,40dip,100%x,70di";
mostCurrent._panel1.AddView((android.view.View)(_systemlabel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="cvs.Initialize(Panel1)";
_cvs.Initialize((android.view.View)(mostCurrent._panel1.getObject()));
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="cvs.DrawLine(0, Panel1.Height - 1, Panel1.Width,";
_cvs.DrawLine((float) (0),(float) (mostCurrent._panel1.getHeight()-1),(float) (mostCurrent._panel1.getWidth()),(float) (mostCurrent._panel1.getHeight()-1),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (50),(int) (0),(int) (0),(int) (0)),(float) (10));
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="LoadMySQLData";
_loadmysqldata();
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="End Sub";
return "";
}
public static String  _loadmysqldata() throws Exception{
RDebugUtils.currentModule="dash";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadmysqldata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadmysqldata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub LoadMySQLData";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Job1.Initialize(\"LoadData\", Me)";
_job1._initialize /*String*/ (null,processBA,"LoadData",dash.getObject());
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _createroundbitmap(anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _input,int _size) throws Exception{
RDebugUtils.currentModule="dash";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createroundbitmap", false))
	 {return ((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) Debug.delegate(mostCurrent.activityBA, "createroundbitmap", new Object[] {_input,_size}));}
int _l = 0;
anywheresoftware.b4a.objects.B4XCanvas _c = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xview = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _path = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _res = null;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub CreateRoundBitmap (Input As B4XBitmap, Size As";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="If Input.Width <> Input.Height Then";
if (_input.getWidth()!=_input.getHeight()) { 
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="Dim l As Int = Min(Input.Width, Input.Height)";
_l = (int) (anywheresoftware.b4a.keywords.Common.Min(_input.getWidth(),_input.getHeight()));
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Input = Input.Crop(Input.Width / 2 - l / 2, Inpu";
_input = _input.Crop((int) (_input.getWidth()/(double)2-_l/(double)2),(int) (_input.getHeight()/(double)2-_l/(double)2),_l,_l);
 };
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Dim c As B4XCanvas";
_c = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
_xview = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xview = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=1114120;
 //BA.debugLineNum = 1114120;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, Size, Size)";
_xview.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_size,_size);
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="c.Initialize(xview)";
_c.Initialize(_xview);
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=1114123;
 //BA.debugLineNum = 1114123;BA.debugLine="path.InitializeOval(c.TargetRect)";
_path.InitializeOval(_c.getTargetRect());
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="c.ClipPath(path)";
_c.ClipPath(_path);
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="c.DrawBitmap(Input.Resize(Size, Size, False), c.T";
_c.DrawBitmap((android.graphics.Bitmap)(_input.Resize(_size,_size,anywheresoftware.b4a.keywords.Common.False).getObject()),_c.getTargetRect());
RDebugUtils.currentLine=1114126;
 //BA.debugLineNum = 1114126;BA.debugLine="c.RemoveClip";
_c.RemoveClip();
RDebugUtils.currentLine=1114127;
 //BA.debugLineNum = 1114127;BA.debugLine="c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.C";
_c.DrawCircle(_c.getTargetRect().getCenterX(),_c.getTargetRect().getCenterY(),(float) (_c.getTargetRect().getWidth()/(double)2-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (0),(int) (0)),anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=1114128;
 //BA.debugLineNum = 1114128;BA.debugLine="c.Invalidate";
_c.Invalidate();
RDebugUtils.currentLine=1114129;
 //BA.debugLineNum = 1114129;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
_res = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_res = _c.CreateBitmap();
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="c.Release";
_c.Release();
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=1114132;
 //BA.debugLineNum = 1114132;BA.debugLine="End Sub";
return null;
}
public static String  _homebutn_click() throws Exception{
RDebugUtils.currentModule="dash";
if (Debug.shouldDelegate(mostCurrent.activityBA, "homebutn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "homebutn_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub homeButn_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="StartActivity(\"Main\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Main"));
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="dash";
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
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="Try";
try {RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="ScrollViewPanel.RemoveAllViews";
mostCurrent._scrollviewpanel.RemoveAllViews();
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="Dim YPos As Int = 0";
_ypos = (int) (0);
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="Dim Margin As Int = 10dip";
_margin = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="Dim TotalHeight As Int = 0 ' To calculate total";
_totalheight = (int) (0);
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="Dim id_display = 1 As Int";
_id_display = (int) (1);
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group12 = mostCurrent._tabledetails;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group12.Get(index12)));
RDebugUtils.currentLine=1048593;
 //BA.debugLineNum = 1048593;BA.debugLine="Dim name As String = record.Get(\"name\")";
_name = BA.ObjectToString(_record.Get((Object)("name")));
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="Dim imageBase64 As String = record.Get(\"image\"";
_imagebase64 = BA.ObjectToString(_record.Get((Object)("image")));
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=1048597;
 //BA.debugLineNum = 1048597;BA.debugLine="Dim ImageBytes() As Byte = su.DecodeBase64(ima";
_imagebytes = _su.DecodeBase64(_imagebase64);
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="Dim ImageView As ImageView";
_imageview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1048600;
 //BA.debugLineNum = 1048600;BA.debugLine="ImageView.Initialize(\"\")";
_imageview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048601;
 //BA.debugLineNum = 1048601;BA.debugLine="ImageView.Gravity = Gravity.CENTER_HORIZONTAL";
_imageview.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
RDebugUtils.currentLine=1048603;
 //BA.debugLineNum = 1048603;BA.debugLine="Dim ImageBitmap As Bitmap";
_imagebitmap = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1048604;
 //BA.debugLineNum = 1048604;BA.debugLine="Dim InputStream As InputStream";
_inputstream = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=1048605;
 //BA.debugLineNum = 1048605;BA.debugLine="InputStream.InitializeFromBytesArray(ImageByte";
_inputstream.InitializeFromBytesArray(_imagebytes,(int) (0),_imagebytes.length);
RDebugUtils.currentLine=1048606;
 //BA.debugLineNum = 1048606;BA.debugLine="ImageBitmap.Initialize2(InputStream)";
_imagebitmap.Initialize2((java.io.InputStream)(_inputstream.getObject()));
RDebugUtils.currentLine=1048609;
 //BA.debugLineNum = 1048609;BA.debugLine="ImageBitmap = ImageBitmap.Resize(100%x, 100%y,";
_imagebitmap = _imagebitmap.Resize((float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)),(float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048612;
 //BA.debugLineNum = 1048612;BA.debugLine="Dim RoundedBitmap As B4XBitmap = CreateRoundBi";
_roundedbitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_roundedbitmap = _createroundbitmap((anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(_imagebitmap.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
RDebugUtils.currentLine=1048613;
 //BA.debugLineNum = 1048613;BA.debugLine="ImageView.Bitmap = RoundedBitmap";
_imageview.setBitmap((android.graphics.Bitmap)(_roundedbitmap.getObject()));
RDebugUtils.currentLine=1048615;
 //BA.debugLineNum = 1048615;BA.debugLine="Dim NameLabel As Label";
_namelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1048616;
 //BA.debugLineNum = 1048616;BA.debugLine="NameLabel.Initialize(\"\")";
_namelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048617;
 //BA.debugLineNum = 1048617;BA.debugLine="NameLabel.Text = name";
_namelabel.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=1048618;
 //BA.debugLineNum = 1048618;BA.debugLine="NameLabel.TextSize = 1%y";
_namelabel.setTextSize((float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA)));
RDebugUtils.currentLine=1048619;
 //BA.debugLineNum = 1048619;BA.debugLine="NameLabel.TextColor = Colors.Black";
_namelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1048620;
 //BA.debugLineNum = 1048620;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
_namelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew(anywheresoftware.b4a.keywords.Common.Typeface.SERIF,anywheresoftware.b4a.keywords.Common.Typeface.STYLE_BOLD));
RDebugUtils.currentLine=1048621;
 //BA.debugLineNum = 1048621;BA.debugLine="NameLabel.Gravity = Gravity.CENTER";
_namelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1048623;
 //BA.debugLineNum = 1048623;BA.debugLine="Dim StudentIdLabel As Label";
_studentidlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1048624;
 //BA.debugLineNum = 1048624;BA.debugLine="StudentIdLabel.Initialize(\"\")";
_studentidlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048625;
 //BA.debugLineNum = 1048625;BA.debugLine="StudentIdLabel.Text = \"SCC-213123-123123\"";
_studentidlabel.setText(BA.ObjectToCharSequence("SCC-213123-123123"));
RDebugUtils.currentLine=1048626;
 //BA.debugLineNum = 1048626;BA.debugLine="StudentIdLabel.TextSize = 15";
_studentidlabel.setTextSize((float) (15));
RDebugUtils.currentLine=1048627;
 //BA.debugLineNum = 1048627;BA.debugLine="StudentIdLabel.TextColor = Colors.ARGB(255, 12";
_studentidlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (128),(int) (128),(int) (128)));
RDebugUtils.currentLine=1048628;
 //BA.debugLineNum = 1048628;BA.debugLine="StudentIdLabel.Gravity = Gravity.CENTER";
_studentidlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1048629;
 //BA.debugLineNum = 1048629;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
_namelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.CreateNew(anywheresoftware.b4a.keywords.Common.Typeface.SERIF,anywheresoftware.b4a.keywords.Common.Typeface.STYLE_NORMAL));
RDebugUtils.currentLine=1048631;
 //BA.debugLineNum = 1048631;BA.debugLine="NameLabel.Typeface = Typeface.DEFAULT_BOLD";
_namelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1048632;
 //BA.debugLineNum = 1048632;BA.debugLine="Dim ItemPanel As Panel";
_itempanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1048633;
 //BA.debugLineNum = 1048633;BA.debugLine="ItemPanel.Initialize(\"\")";
_itempanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048634;
 //BA.debugLineNum = 1048634;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
_itempanel.SetLayout((int) (0),_ypos,mostCurrent._scrollview1.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA));
RDebugUtils.currentLine=1048635;
 //BA.debugLineNum = 1048635;BA.debugLine="ItemPanel.Color = Colors.White";
_itempanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1048637;
 //BA.debugLineNum = 1048637;BA.debugLine="Dim id As Label";
_id = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1048638;
 //BA.debugLineNum = 1048638;BA.debugLine="id.Initialize(\"\")";
_id.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048639;
 //BA.debugLineNum = 1048639;BA.debugLine="id.Text = id_display";
_id.setText(BA.ObjectToCharSequence(_id_display));
RDebugUtils.currentLine=1048640;
 //BA.debugLineNum = 1048640;BA.debugLine="id.TextSize = 24";
_id.setTextSize((float) (24));
RDebugUtils.currentLine=1048642;
 //BA.debugLineNum = 1048642;BA.debugLine="Dim HorizontalLayout As Panel";
_horizontallayout = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1048643;
 //BA.debugLineNum = 1048643;BA.debugLine="HorizontalLayout.Initialize(\"\")";
_horizontallayout.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1048644;
 //BA.debugLineNum = 1048644;BA.debugLine="HorizontalLayout.SetLayout(0, 0, ItemPanel.Wid";
_horizontallayout.SetLayout((int) (0),(int) (0),_itempanel.getWidth(),_itempanel.getHeight());
RDebugUtils.currentLine=1048646;
 //BA.debugLineNum = 1048646;BA.debugLine="HorizontalLayout.AddView(ImageView, 5%x, 2%y,";
_horizontallayout.AddView((android.view.View)(_imageview.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA));
RDebugUtils.currentLine=1048647;
 //BA.debugLineNum = 1048647;BA.debugLine="HorizontalLayout.AddView(NameLabel, 25%x, 3%y,";
_horizontallayout.AddView((android.view.View)(_namelabel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA),(int) (_itempanel.getWidth()-_imageview.getWidth()),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA));
RDebugUtils.currentLine=1048648;
 //BA.debugLineNum = 1048648;BA.debugLine="HorizontalLayout.AddView(id, 3%x, 2%y, 5%x, 5%";
_horizontallayout.AddView((android.view.View)(_id.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (3),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA));
RDebugUtils.currentLine=1048649;
 //BA.debugLineNum = 1048649;BA.debugLine="HorizontalLayout.AddView(StudentIdLabel, 25%x,";
_horizontallayout.AddView((android.view.View)(_studentidlabel.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (25),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (9),mostCurrent.activityBA),(int) (_itempanel.getWidth()-_imageview.getWidth()),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA));
RDebugUtils.currentLine=1048650;
 //BA.debugLineNum = 1048650;BA.debugLine="HorizontalLayout.Color = Colors.LightGray";
_horizontallayout.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=1048652;
 //BA.debugLineNum = 1048652;BA.debugLine="HorizontalLayout.Color = Colors.White";
_horizontallayout.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1048654;
 //BA.debugLineNum = 1048654;BA.debugLine="Log(Panel1.Width & \"this is witdth\")";
anywheresoftware.b4a.keywords.Common.LogImpl("01048654",BA.NumberToString(mostCurrent._panel1.getWidth())+"this is witdth",0);
RDebugUtils.currentLine=1048658;
 //BA.debugLineNum = 1048658;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1048659;
 //BA.debugLineNum = 1048659;BA.debugLine="cvs.Initialize(HorizontalLayout)";
_cvs.Initialize((android.view.View)(_horizontallayout.getObject()));
RDebugUtils.currentLine=1048662;
 //BA.debugLineNum = 1048662;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, 0, Horizo";
_cvs.DrawLine((float) (_horizontallayout.getWidth()),(float) (0),(float) (_horizontallayout.getWidth()),(float) (_horizontallayout.getHeight()),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (16),(int) (64),(int) (34)),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=1048663;
 //BA.debugLineNum = 1048663;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, Horizonta";
_cvs.DrawLine((float) (_horizontallayout.getWidth()),(float) (_horizontallayout.getHeight()),(float) (0),(float) (_horizontallayout.getHeight()),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (16),(int) (64),(int) (34)),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=1048665;
 //BA.debugLineNum = 1048665;BA.debugLine="ItemPanel.AddView(HorizontalLayout, 0, 0, Item";
_itempanel.AddView((android.view.View)(_horizontallayout.getObject()),(int) (0),(int) (0),_itempanel.getWidth(),_itempanel.getHeight());
RDebugUtils.currentLine=1048666;
 //BA.debugLineNum = 1048666;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_itempanel.getObject()),(int) (0),_ypos,mostCurrent._scrollview1.getWidth(),_itempanel.getHeight());
RDebugUtils.currentLine=1048668;
 //BA.debugLineNum = 1048668;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin";
_ypos = (int) (_ypos+_itempanel.getHeight()+_margin);
RDebugUtils.currentLine=1048669;
 //BA.debugLineNum = 1048669;BA.debugLine="TotalHeight = YPos ' Update total height";
_totalheight = _ypos;
RDebugUtils.currentLine=1048671;
 //BA.debugLineNum = 1048671;BA.debugLine="id_display = id_display + 1";
_id_display = (int) (_id_display+1);
 }
};
RDebugUtils.currentLine=1048675;
 //BA.debugLineNum = 1048675;BA.debugLine="ScrollView1.Panel.Height = Max(TotalHeight, 100";
mostCurrent._scrollview1.getPanel().setHeight((int) (anywheresoftware.b4a.keywords.Common.Max(_totalheight,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA))));
 } 
       catch (Exception e72) {
			processBA.setLastException(e72);RDebugUtils.currentLine=1048678;
 //BA.debugLineNum = 1048678;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=1048681;
 //BA.debugLineNum = 1048681;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1048683;
 //BA.debugLineNum = 1048683;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=1048684;
 //BA.debugLineNum = 1048684;BA.debugLine="End Sub";
return "";
}
public static String  _studentlistbtn_click() throws Exception{
RDebugUtils.currentModule="dash";
if (Debug.shouldDelegate(mostCurrent.activityBA, "studentlistbtn_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "studentlistbtn_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub studentListBtn_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="StartActivity(\"Dash\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Dash"));
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="End Sub";
return "";
}
}