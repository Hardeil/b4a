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
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
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
vis = vis | (branch.mostCurrent != null);
vis = vis | (device.mostCurrent != null);
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

 {
            Activity __a = null;
            if (branch.previousOne != null) {
				__a = branch.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(branch.mostCurrent == null ? null : branch.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (device.previousOne != null) {
				__a = device.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(device.mostCurrent == null ? null : device.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static String _company = "";
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public static String _phpurl = "";
public anywheresoftware.b4a.objects.collections.List _tabledetails = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _navigate = null;
public static int _titlefontsize = 0;
public static int _primaryfontsize = 0;
public static int _secondaryfontsize = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.bargraph _bargraph = null;
public b4a.example.bargraph _bargraph1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
public static String[] _legend = null;
public anywheresoftware.b4a.objects.PanelWrapper _purchasepanel = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
mostCurrent._label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (225),(int) (218),(int) (218)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (189),(int) (202),(int) (217))});
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="ScrollView1.Background = gradient";
mostCurrent._scrollview1.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
mostCurrent._scrollview1.getPanel().setHeight(mostCurrent._activity.getHeight());
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="LoadCompanyData";
_loadcompanydata();
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="barPanel.Initialize(\"\")";
mostCurrent._barpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="Panel1.AddView(barPanel,25dip,Panel2.Height+20dip";
mostCurrent._panel1.AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (mostCurrent._panel2.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="purchasePanel.Initialize(\"\")";
mostCurrent._purchasepanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="Panel1.AddView(purchasePanel,25dip,barPanel.top+b";
mostCurrent._panel1.AddView((android.view.View)(mostCurrent._purchasepanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),(int) (mostCurrent._barpanel.getTop()+mostCurrent._barpanel.getHeight()+mostCurrent._panel2.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="End Sub";
return "";
}
public static String  _loadcompanydata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadcompanydata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadcompanydata", null));}
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub LoadCompanyData";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Try";
try {RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
_job1._initialize /*String*/ (null,processBA,"GetData",main.getObject());
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Job1.Download(PHPURL)";
_job1._download /*String*/ (null,mostCurrent._phpurl);
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading Data..."));
 } 
       catch (Exception e7) {
			processBA.setLastException(e7);RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("8196615",anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage(),0);
 };
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static Object  _getmapvalueordefault(anywheresoftware.b4a.objects.collections.Map _m,String _key,Object _defaultvalue) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getmapvalueordefault", false))
	 {return ((Object) Debug.delegate(mostCurrent.activityBA, "getmapvalueordefault", new Object[] {_m,_key,_defaultvalue}));}
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="If m.ContainsKey(Key) Then";
if (_m.ContainsKey((Object)(_key))) { 
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="Return m.Get(Key)";
if (true) return _m.Get((Object)(_key));
 }else {
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="End Sub";
return null;
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _salesarray = null;
int _totalcompanies = 0;
int[] _sales = null;
int[] _sales1 = null;
int[] _sales2 = null;
int[] _purchase = null;
int[] _purchase1 = null;
int[] _purchase2 = null;
String[] _product = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
anywheresoftware.b4a.objects.collections.List _branches = null;
int _j = 0;
anywheresoftware.b4a.objects.collections.Map _branchmap = null;
String _branchname = "";
int _branchsales1 = 0;
int _branchsales2 = 0;
int _branchsales3 = 0;
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
 //BA.debugLineNum = 262150;BA.debugLine="Select Case job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,"GetData","UpdateData")) {
case 0: {
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="Dim salesArray As List = parser.NextArray";
_salesarray = new anywheresoftware.b4a.objects.collections.List();
_salesarray = _parser.NextArray();
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="If salesArray.Size = 0 Then";
if (_salesarray.getSize()==0) { 
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="ToastMessageShow(\"No data received\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No data received"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
_totalcompanies = _salesarray.getSize();
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="Dim sales(totalCompanies) As Int";
_sales = new int[_totalcompanies];
;
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="Dim sales1(totalCompanies) As Int";
_sales1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="Dim sales2(totalCompanies) As Int";
_sales2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="Dim purchase(totalCompanies) As Int";
_purchase = new int[_totalcompanies];
;
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="Dim purchase1(totalCompanies) As Int";
_purchase1 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="Dim purchase2(totalCompanies) As Int";
_purchase2 = new int[_totalcompanies];
;
RDebugUtils.currentLine=262169;
 //BA.debugLineNum = 262169;BA.debugLine="Dim product(totalCompanies) As String";
_product = new String[_totalcompanies];
java.util.Arrays.fill(_product,"");
RDebugUtils.currentLine=262174;
 //BA.debugLineNum = 262174;BA.debugLine="For i = 0 To totalCompanies - 1";
{
final int step21 = 1;
final int limit21 = (int) (_totalcompanies-1);
_i = (int) (0) ;
for (;_i <= limit21 ;_i = _i + step21 ) {
RDebugUtils.currentLine=262175;
 //BA.debugLineNum = 262175;BA.debugLine="Dim record As Map = salesArray.Get(i)";
_record = new anywheresoftware.b4a.objects.collections.Map();
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_salesarray.Get(_i)));
RDebugUtils.currentLine=262176;
 //BA.debugLineNum = 262176;BA.debugLine="product(i) = record.GetDefault(\"company_name";
_product[_i] = BA.ObjectToString(_record.GetDefault((Object)("company_name"),(Object)("Unknown")));
RDebugUtils.currentLine=262177;
 //BA.debugLineNum = 262177;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
_sales[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_1"),(Object)(0))));
RDebugUtils.currentLine=262178;
 //BA.debugLineNum = 262178;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
_sales1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_2"),(Object)(0))));
RDebugUtils.currentLine=262179;
 //BA.debugLineNum = 262179;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
_sales2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("sales_3"),(Object)(0))));
RDebugUtils.currentLine=262180;
 //BA.debugLineNum = 262180;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
_purchase[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_1"),(Object)(0))));
RDebugUtils.currentLine=262181;
 //BA.debugLineNum = 262181;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
_purchase1[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_2"),(Object)(0))));
RDebugUtils.currentLine=262182;
 //BA.debugLineNum = 262182;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
_purchase2[_i] = (int)(BA.ObjectToNumber(_record.GetDefault((Object)("purchase_"),(Object)(0))));
RDebugUtils.currentLine=262183;
 //BA.debugLineNum = 262183;BA.debugLine="If record.ContainsKey(\"branches\") Then";
if (_record.ContainsKey((Object)("branches"))) { 
RDebugUtils.currentLine=262184;
 //BA.debugLineNum = 262184;BA.debugLine="Dim branches As List = record.Get(\"branches";
_branches = new anywheresoftware.b4a.objects.collections.List();
_branches = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_record.Get((Object)("branches"))));
RDebugUtils.currentLine=262185;
 //BA.debugLineNum = 262185;BA.debugLine="For j = 0 To branches.Size - 1";
{
final int step32 = 1;
final int limit32 = (int) (_branches.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit32 ;_j = _j + step32 ) {
RDebugUtils.currentLine=262186;
 //BA.debugLineNum = 262186;BA.debugLine="Dim branchMap As Map = branches.Get(j)";
_branchmap = new anywheresoftware.b4a.objects.collections.Map();
_branchmap = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(_branches.Get(_j)));
RDebugUtils.currentLine=262187;
 //BA.debugLineNum = 262187;BA.debugLine="Dim branchName As String = GetMapValueOrDe";
_branchname = BA.ObjectToString(_getmapvalueordefault(_branchmap,"branch_name",(Object)("Unknown Branch")));
RDebugUtils.currentLine=262188;
 //BA.debugLineNum = 262188;BA.debugLine="Dim branchSales1 As Int = GetMapValueOrDef";
_branchsales1 = (int)(BA.ObjectToNumber(_getmapvalueordefault(_branchmap,"sales1",(Object)(0))));
RDebugUtils.currentLine=262189;
 //BA.debugLineNum = 262189;BA.debugLine="Dim branchSales2 As Int = GetMapValueOrDef";
_branchsales2 = (int)(BA.ObjectToNumber(_getmapvalueordefault(_branchmap,"sales2",(Object)(0))));
RDebugUtils.currentLine=262190;
 //BA.debugLineNum = 262190;BA.debugLine="Dim branchSales3 As Int = GetMapValueOrDef";
_branchsales3 = (int)(BA.ObjectToNumber(_getmapvalueordefault(_branchmap,"sales3",(Object)(0))));
RDebugUtils.currentLine=262194;
 //BA.debugLineNum = 262194;BA.debugLine="Log($\"Company: ${product(i)}, Branch: ${br";
anywheresoftware.b4a.keywords.Common.LogImpl("8262194",("Company: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_product[_i]))+", Branch: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_branchname))+", Sales1: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_branchsales1))+", Sales2: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_branchsales2))+", Sales3: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_branchsales3))+""),0);
 }
};
 }else {
RDebugUtils.currentLine=262197;
 //BA.debugLineNum = 262197;BA.debugLine="Log($\"Company: ${product(i)} has no branche";
anywheresoftware.b4a.keywords.Common.LogImpl("8262197",("Company: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_product[_i]))+" has no branches information."),0);
 };
 }
};
RDebugUtils.currentLine=262201;
 //BA.debugLineNum = 262201;BA.debugLine="barPanel.RemoveAllViews";
mostCurrent._barpanel.RemoveAllViews();
RDebugUtils.currentLine=262202;
 //BA.debugLineNum = 262202;BA.debugLine="barPanel.Invalidate ' Force redraw";
mostCurrent._barpanel.Invalidate();
RDebugUtils.currentLine=262204;
 //BA.debugLineNum = 262204;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
mostCurrent._legend = new String[]{"Sales1","Sales2","Sales3"};
RDebugUtils.currentLine=262205;
 //BA.debugLineNum = 262205;BA.debugLine="barGraph.Initialize(Activity, barPanel, sales";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._barpanel,_sales,_sales1,_sales2,_product,mostCurrent._legend,(int) (10000),"Total Sales of the Company");
RDebugUtils.currentLine=262206;
 //BA.debugLineNum = 262206;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purchas";
mostCurrent._legend = new String[]{"Purchase1","Purchase2","Purchase3"};
RDebugUtils.currentLine=262207;
 //BA.debugLineNum = 262207;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
mostCurrent._bargraph1._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,mostCurrent._purchasepanel,_purchase,_purchase1,_purchase2,_product,mostCurrent._legend,(int) (10000),"Total Purchase of the Company");
 break; }
case 1: {
RDebugUtils.currentLine=262210;
 //BA.debugLineNum = 262210;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Data updated successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=262211;
 //BA.debugLineNum = 262211;BA.debugLine="LoadCompanyData";
_loadcompanydata();
 break; }
default: {
RDebugUtils.currentLine=262213;
 //BA.debugLineNum = 262213;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
anywheresoftware.b4a.keywords.Common.LogImpl("8262213","Unknown job: "+_job._jobname /*String*/ ,0);
 break; }
}
;
 } 
       catch (Exception e57) {
			processBA.setLastException(e57);RDebugUtils.currentLine=262216;
 //BA.debugLineNum = 262216;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing sales data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=262219;
 //BA.debugLineNum = 262219;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262221;
 //BA.debugLineNum = 262221;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=262222;
 //BA.debugLineNum = 262222;BA.debugLine="End Sub";
return "";
}
public static String  _label17_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label17_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label17_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _clickedlabel = null;
String _selectedcompany = "";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub Label17_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
_clickedlabel = new anywheresoftware.b4a.objects.LabelWrapper();
_clickedlabel = (anywheresoftware.b4a.objects.LabelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.LabelWrapper(), (android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
_selectedcompany = BA.ObjectToString(_clickedlabel.getTag());
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Starter.company_selected = selectedCompany";
mostCurrent._starter._company_selected /*String*/  = _selectedcompany;
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="StartActivity(\"Branch\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Branch"));
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="End Sub";
return "";
}
}