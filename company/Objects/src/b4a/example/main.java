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

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
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
public b4a.example.starter _starter = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _gradient = null;
anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
int[] _sales = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
mostCurrent._label1.setText(BA.ObjectToCharSequence(mostCurrent._label1.getText().toUpperCase()));
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
mostCurrent._label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
mostCurrent._scrollview1.getPanel().setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (251),(int) (251),(int) (251)));
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (225),(int) (218),(int) (218)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (189),(int) (202),(int) (217))});
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="ScrollView1.Background = gradient";
mostCurrent._scrollview1.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="Dim gradient As GradientDrawable";
_gradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
_gradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"RIGHT_LEFT"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (185),(int) (46),(int) (52)),anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (61),(int) (12),(int) (2))});
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="Panel2.Background = gradient";
mostCurrent._panel2.setBackground((android.graphics.drawable.Drawable)(_gradient.getObject()));
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="Log(Activity.Width)";
anywheresoftware.b4a.keywords.Common.LogImpl("0262161",BA.NumberToString(mostCurrent._activity.getWidth()),0);
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="Dim barPanel As Panel";
_barpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="barPanel.Initialize(\"\")";
_barpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="Dim sales() As Int";
_sales = new int[(int) (0)];
;
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="sales = Array As Int(100, 2000, 1500, 3000, 4000,";
_sales = new int[]{(int) (100),(int) (2000),(int) (1500),(int) (3000),(int) (4000),(int) (50000),(int) (60000)};
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="Panel1.AddView(barPanel,25dip,Panel2.Height,Activ";
mostCurrent._panel1.AddView((android.view.View)(_barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),mostCurrent._panel2.getHeight(),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)));
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="barGraph.Initialize(Activity,barPanel,sales,10000";
mostCurrent._bargraph._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._activity,_barpanel,_sales,(int) (100000));
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="End Sub";
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
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
int _scrollheight = 0;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
int _numcolumns = 0;
int _pnlwidth = 0;
int _pnlheight = 0;
int _padding = 0;
int _leftposition = 0;
int _topposition = 0;
int _count = 0;
anywheresoftware.b4a.objects.collections.Map _record = null;
String _name = "";
int _company_id = 0;
int _total_count = 0;
int _total_pos = 0;
String _totalpur1 = "";
String _totalpur2 = "";
String _totalpur3 = "";
String _totalsales1 = "";
String _totalsales2 = "";
String _totalsales3 = "";
anywheresoftware.b4a.objects.PanelWrapper _panel = null;
anywheresoftware.b4a.objects.LabelWrapper _label17 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _myimage = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _resizedimage = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgview = null;
int _panelwidth = 0;
int _labelheight = 0;
anywheresoftware.b4a.objects.LabelWrapper _purchase1 = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase1label = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase2 = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase2label = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase3 = null;
anywheresoftware.b4a.objects.LabelWrapper _purchase3label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale1label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale2label = null;
anywheresoftware.b4a.objects.LabelWrapper _sale3 = null;
anywheresoftware.b4a.objects.LabelWrapper _sale3label = null;
anywheresoftware.b4a.objects.LabelWrapper _totalstore = null;
anywheresoftware.b4a.objects.LabelWrapper _totalstorelabel = null;
anywheresoftware.b4a.objects.LabelWrapper _totalpos = null;
anywheresoftware.b4a.objects.LabelWrapper _totalposlabel = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub JobDone(job As HttpJob)";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Dim scrollHeight As Int = 0";
_scrollheight = (int) (0);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="If job.Success = True Then";
if (_job._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Try";
try {RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="parser.Initialize(job.GetString)";
_parser.Initialize(_job._getstring /*String*/ (null));
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="TableDetails = parser.NextArray";
mostCurrent._tabledetails = _parser.NextArray();
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="Dim numColumns As Int = 2 ' Adjust based on pre";
_numcolumns = (int) (2);
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="Dim pnlWidth As Int = Activity.Width - 100dip";
_pnlwidth = (int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=196620;
 //BA.debugLineNum = 196620;BA.debugLine="Dim pnlHeight As Int = 280dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (280));
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="Dim leftPosition As Int = 50dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=196623;
 //BA.debugLineNum = 196623;BA.debugLine="Dim topPosition As Int = 77dip";
_topposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (77));
RDebugUtils.currentLine=196624;
 //BA.debugLineNum = 196624;BA.debugLine="Dim count As Int = 0 ' Track panel count";
_count = (int) (0);
RDebugUtils.currentLine=196625;
 //BA.debugLineNum = 196625;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=196626;
 //BA.debugLineNum = 196626;BA.debugLine="pnlWidth = 490dip";
_pnlwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (490));
RDebugUtils.currentLine=196627;
 //BA.debugLineNum = 196627;BA.debugLine="pnlHeight = 300dip";
_pnlheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300));
RDebugUtils.currentLine=196628;
 //BA.debugLineNum = 196628;BA.debugLine="padding = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=196629;
 //BA.debugLineNum = 196629;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 };
RDebugUtils.currentLine=196632;
 //BA.debugLineNum = 196632;BA.debugLine="For Each record As Map In TableDetails";
_record = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group21 = mostCurrent._tabledetails;
final int groupLen21 = group21.getSize()
;int index21 = 0;
;
for (; index21 < groupLen21;index21++){
_record = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group21.Get(index21)));
RDebugUtils.currentLine=196633;
 //BA.debugLineNum = 196633;BA.debugLine="Dim name As String = record.Get(\"company_name\"";
_name = BA.ObjectToString(_record.Get((Object)("company_name")));
RDebugUtils.currentLine=196634;
 //BA.debugLineNum = 196634;BA.debugLine="Dim company_id As Int = record.Get(\"comId\")";
_company_id = (int)(BA.ObjectToNumber(_record.Get((Object)("comId"))));
RDebugUtils.currentLine=196635;
 //BA.debugLineNum = 196635;BA.debugLine="Dim total_count As Int = record.Get(\"total_cou";
_total_count = (int)(BA.ObjectToNumber(_record.Get((Object)("total_count"))));
RDebugUtils.currentLine=196636;
 //BA.debugLineNum = 196636;BA.debugLine="Dim total_pos As Int = record.Get(\"totalDevice";
_total_pos = (int)(BA.ObjectToNumber(_record.Get((Object)("totalDevices"))));
RDebugUtils.currentLine=196637;
 //BA.debugLineNum = 196637;BA.debugLine="Dim totalPur1 As String = record.Get(\"purchase";
_totalpur1 = BA.ObjectToString(_record.Get((Object)("purchase_1")));
RDebugUtils.currentLine=196638;
 //BA.debugLineNum = 196638;BA.debugLine="Dim totalPur2 As String = record.Get(\"purchase";
_totalpur2 = BA.ObjectToString(_record.Get((Object)("purchase_2")));
RDebugUtils.currentLine=196639;
 //BA.debugLineNum = 196639;BA.debugLine="Dim totalPur3 As String = record.Get(\"purchase";
_totalpur3 = BA.ObjectToString(_record.Get((Object)("purchase_3")));
RDebugUtils.currentLine=196640;
 //BA.debugLineNum = 196640;BA.debugLine="Dim totalSales1 As String = record.Get(\"sales_";
_totalsales1 = BA.ObjectToString(_record.Get((Object)("sales_1")));
RDebugUtils.currentLine=196641;
 //BA.debugLineNum = 196641;BA.debugLine="Dim totalSales2 As String = record.Get(\"sales_";
_totalsales2 = BA.ObjectToString(_record.Get((Object)("sales_2")));
RDebugUtils.currentLine=196642;
 //BA.debugLineNum = 196642;BA.debugLine="Dim totalSales3 As String = record.Get(\"sales_";
_totalsales3 = BA.ObjectToString(_record.Get((Object)("sales_3")));
RDebugUtils.currentLine=196645;
 //BA.debugLineNum = 196645;BA.debugLine="Dim Panel As Panel";
_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=196646;
 //BA.debugLineNum = 196646;BA.debugLine="Panel.Initialize(\"Panel\")";
_panel.Initialize(mostCurrent.activityBA,"Panel");
RDebugUtils.currentLine=196647;
 //BA.debugLineNum = 196647;BA.debugLine="ScrollView1.Panel.AddView(Panel, leftPosition,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_panel.getObject()),_leftposition,_topposition,_pnlwidth,_pnlheight);
RDebugUtils.currentLine=196648;
 //BA.debugLineNum = 196648;BA.debugLine="Panel.Color = Colors.Black";
_panel.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196651;
 //BA.debugLineNum = 196651;BA.debugLine="Dim Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=196652;
 //BA.debugLineNum = 196652;BA.debugLine="Panel2.Initialize(\"Panel2\")";
mostCurrent._panel2.Initialize(mostCurrent.activityBA,"Panel2");
RDebugUtils.currentLine=196653;
 //BA.debugLineNum = 196653;BA.debugLine="Panel2.Color = Colors.Black";
mostCurrent._panel2.setColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196654;
 //BA.debugLineNum = 196654;BA.debugLine="Panel2.Tag = name";
mostCurrent._panel2.setTag((Object)(_name));
RDebugUtils.currentLine=196655;
 //BA.debugLineNum = 196655;BA.debugLine="Panel2.SendToBack";
mostCurrent._panel2.SendToBack();
RDebugUtils.currentLine=196656;
 //BA.debugLineNum = 196656;BA.debugLine="Panel.AddView(Panel2, 0, 0, Panel.Width, 6%y)";
_panel.AddView((android.view.View)(mostCurrent._panel2.getObject()),(int) (0),(int) (0),_panel.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=196659;
 //BA.debugLineNum = 196659;BA.debugLine="Dim Label17 As Label";
_label17 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196660;
 //BA.debugLineNum = 196660;BA.debugLine="Label17.Initialize(\"Label17\")";
_label17.Initialize(mostCurrent.activityBA,"Label17");
RDebugUtils.currentLine=196661;
 //BA.debugLineNum = 196661;BA.debugLine="Label17.Text = name";
_label17.setText(BA.ObjectToCharSequence(_name));
RDebugUtils.currentLine=196662;
 //BA.debugLineNum = 196662;BA.debugLine="Label17.Tag = company_id";
_label17.setTag((Object)(_company_id));
RDebugUtils.currentLine=196663;
 //BA.debugLineNum = 196663;BA.debugLine="Label17.TextSize = 18";
_label17.setTextSize((float) (18));
RDebugUtils.currentLine=196664;
 //BA.debugLineNum = 196664;BA.debugLine="Label17.TextColor = Colors.White";
_label17.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=196665;
 //BA.debugLineNum = 196665;BA.debugLine="Label17.Gravity = Gravity.CENTER_VERTICAL";
_label17.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL);
RDebugUtils.currentLine=196666;
 //BA.debugLineNum = 196666;BA.debugLine="Label17.Typeface = Typeface.MONOSPACE";
_label17.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196667;
 //BA.debugLineNum = 196667;BA.debugLine="Panel2.AddView(Label17, 10dip, 0dip, Panel2.Wi";
mostCurrent._panel2.AddView((android.view.View)(_label17.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),mostCurrent._panel2.getWidth(),mostCurrent._panel2.getHeight());
RDebugUtils.currentLine=196669;
 //BA.debugLineNum = 196669;BA.debugLine="Dim myImage As Bitmap";
_myimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=196670;
 //BA.debugLineNum = 196670;BA.debugLine="myImage = LoadBitmap(File.DirAssets, \"arrows-r";
_myimage = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"arrows-removebg-preview.png");
RDebugUtils.currentLine=196671;
 //BA.debugLineNum = 196671;BA.debugLine="If myImage.IsInitialized Then";
if (_myimage.IsInitialized()) { 
RDebugUtils.currentLine=196672;
 //BA.debugLineNum = 196672;BA.debugLine="Dim resizedImage As Bitmap = myImage.Resize(D";
_resizedimage = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_resizedimage = _myimage.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (4.5),mostCurrent.activityBA))),(float) (_myimage.getHeight()*anywheresoftware.b4a.keywords.Common.DipToCurrent(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA))/(double)_myimage.getWidth()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=196673;
 //BA.debugLineNum = 196673;BA.debugLine="Dim imgView As ImageView";
_imgview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=196674;
 //BA.debugLineNum = 196674;BA.debugLine="imgView.Initialize(\"\")";
_imgview.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196675;
 //BA.debugLineNum = 196675;BA.debugLine="imgView.Bitmap = resizedImage";
_imgview.setBitmap((android.graphics.Bitmap)(_resizedimage.getObject()));
RDebugUtils.currentLine=196676;
 //BA.debugLineNum = 196676;BA.debugLine="Panel2.AddView(imgView, Panel2.Width - 8%x, 0";
mostCurrent._panel2.AddView((android.view.View)(_imgview.getObject()),(int) (mostCurrent._panel2.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),mostCurrent._panel2.getHeight());
 }else {
RDebugUtils.currentLine=196678;
 //BA.debugLineNum = 196678;BA.debugLine="Log(\"Error loading image\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0196678","Error loading image",0);
 };
RDebugUtils.currentLine=196681;
 //BA.debugLineNum = 196681;BA.debugLine="Dim panelWidth As Int = Panel.Width /3";
_panelwidth = (int) (_panel.getWidth()/(double)3);
RDebugUtils.currentLine=196682;
 //BA.debugLineNum = 196682;BA.debugLine="Dim padding As Int = 10dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=196683;
 //BA.debugLineNum = 196683;BA.debugLine="Dim labelheight As Int = 35dip";
_labelheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35));
RDebugUtils.currentLine=196685;
 //BA.debugLineNum = 196685;BA.debugLine="Dim purchase1 As Label";
_purchase1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196686;
 //BA.debugLineNum = 196686;BA.debugLine="purchase1.Initialize(\"\")";
_purchase1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196687;
 //BA.debugLineNum = 196687;BA.debugLine="purchase1.Text = totalPur1";
_purchase1.setText(BA.ObjectToCharSequence(_totalpur1));
RDebugUtils.currentLine=196688;
 //BA.debugLineNum = 196688;BA.debugLine="purchase1.TextColor = Colors.Black";
_purchase1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196689;
 //BA.debugLineNum = 196689;BA.debugLine="purchase1.TextSize = primaryFontSize";
_purchase1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196690;
 //BA.debugLineNum = 196690;BA.debugLine="purchase1.Gravity = Gravity.CENTER";
_purchase1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196691;
 //BA.debugLineNum = 196691;BA.debugLine="purchase1.Typeface = Typeface.SERIF";
_purchase1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196692;
 //BA.debugLineNum = 196692;BA.debugLine="Panel.AddView(purchase1,0,Panel2.Height+paddin";
_panel.AddView((android.view.View)(_purchase1.getObject()),(int) (0),(int) (mostCurrent._panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=196694;
 //BA.debugLineNum = 196694;BA.debugLine="Dim purchase1Label As Label";
_purchase1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196695;
 //BA.debugLineNum = 196695;BA.debugLine="purchase1Label.Initialize(\"\")";
_purchase1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196696;
 //BA.debugLineNum = 196696;BA.debugLine="purchase1Label.Text = \"First Purchase\"";
_purchase1label.setText(BA.ObjectToCharSequence("First Purchase"));
RDebugUtils.currentLine=196697;
 //BA.debugLineNum = 196697;BA.debugLine="purchase1Label.TextColor = Colors.Gray";
_purchase1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196698;
 //BA.debugLineNum = 196698;BA.debugLine="purchase1Label.TextSize = secondaryFontSize";
_purchase1label.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196699;
 //BA.debugLineNum = 196699;BA.debugLine="purchase1Label.Gravity = Gravity.CENTER";
_purchase1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196700;
 //BA.debugLineNum = 196700;BA.debugLine="purchase1Label.Typeface = Typeface.MONOSPACE";
_purchase1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196701;
 //BA.debugLineNum = 196701;BA.debugLine="purchase1Label.Text = purchase1Label.Text.ToUp";
_purchase1label.setText(BA.ObjectToCharSequence(_purchase1label.getText().toUpperCase()));
RDebugUtils.currentLine=196702;
 //BA.debugLineNum = 196702;BA.debugLine="Panel.AddView(purchase1Label,0,purchase1.top+p";
_panel.AddView((android.view.View)(_purchase1label.getObject()),(int) (0),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196704;
 //BA.debugLineNum = 196704;BA.debugLine="Dim purchase2 As Label";
_purchase2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196705;
 //BA.debugLineNum = 196705;BA.debugLine="purchase2.Initialize(\"\")";
_purchase2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196706;
 //BA.debugLineNum = 196706;BA.debugLine="purchase2.Text = totalPur2";
_purchase2.setText(BA.ObjectToCharSequence(_totalpur2));
RDebugUtils.currentLine=196707;
 //BA.debugLineNum = 196707;BA.debugLine="purchase2.TextColor = Colors.Black";
_purchase2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196708;
 //BA.debugLineNum = 196708;BA.debugLine="purchase2.TextSize = primaryFontSize";
_purchase2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196709;
 //BA.debugLineNum = 196709;BA.debugLine="purchase2.Gravity = Gravity.CENTER";
_purchase2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196710;
 //BA.debugLineNum = 196710;BA.debugLine="purchase2.Typeface = Typeface.SERIF";
_purchase2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196711;
 //BA.debugLineNum = 196711;BA.debugLine="Panel.AddView(purchase2,panelWidth,Panel2.Heig";
_panel.AddView((android.view.View)(_purchase2.getObject()),_panelwidth,(int) (mostCurrent._panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=196713;
 //BA.debugLineNum = 196713;BA.debugLine="Dim purchase2Label As Label";
_purchase2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196714;
 //BA.debugLineNum = 196714;BA.debugLine="purchase2Label.Initialize(\"\")";
_purchase2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196715;
 //BA.debugLineNum = 196715;BA.debugLine="purchase2Label.Text = \"Second Purchase\"";
_purchase2label.setText(BA.ObjectToCharSequence("Second Purchase"));
RDebugUtils.currentLine=196716;
 //BA.debugLineNum = 196716;BA.debugLine="purchase2Label.TextColor = Colors.Gray";
_purchase2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196717;
 //BA.debugLineNum = 196717;BA.debugLine="purchase2Label.TextSize = secondaryFontSize";
_purchase2label.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196718;
 //BA.debugLineNum = 196718;BA.debugLine="purchase2Label.Gravity = Gravity.CENTER";
_purchase2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196719;
 //BA.debugLineNum = 196719;BA.debugLine="purchase2Label.Typeface = Typeface.MONOSPACE";
_purchase2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196720;
 //BA.debugLineNum = 196720;BA.debugLine="purchase2Label.Text = purchase2Label.Text.ToUp";
_purchase2label.setText(BA.ObjectToCharSequence(_purchase2label.getText().toUpperCase()));
RDebugUtils.currentLine=196721;
 //BA.debugLineNum = 196721;BA.debugLine="Panel.AddView(purchase2Label,panelWidth,purcha";
_panel.AddView((android.view.View)(_purchase2label.getObject()),_panelwidth,(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196723;
 //BA.debugLineNum = 196723;BA.debugLine="Dim purchase3 As Label";
_purchase3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196724;
 //BA.debugLineNum = 196724;BA.debugLine="purchase3.Initialize(\"\")";
_purchase3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196725;
 //BA.debugLineNum = 196725;BA.debugLine="purchase3.Text = totalPur3";
_purchase3.setText(BA.ObjectToCharSequence(_totalpur3));
RDebugUtils.currentLine=196726;
 //BA.debugLineNum = 196726;BA.debugLine="purchase3.TextColor = Colors.Black";
_purchase3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196727;
 //BA.debugLineNum = 196727;BA.debugLine="purchase3.TextSize = primaryFontSize";
_purchase3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196728;
 //BA.debugLineNum = 196728;BA.debugLine="purchase3.Gravity = Gravity.CENTER";
_purchase3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196729;
 //BA.debugLineNum = 196729;BA.debugLine="purchase3.Typeface = Typeface.SERIF";
_purchase3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196730;
 //BA.debugLineNum = 196730;BA.debugLine="Panel.AddView(purchase3,panelWidth*2,Panel2.He";
_panel.AddView((android.view.View)(_purchase3.getObject()),(int) (_panelwidth*2),(int) (mostCurrent._panel2.getHeight()+_padding),_panelwidth,_labelheight);
RDebugUtils.currentLine=196732;
 //BA.debugLineNum = 196732;BA.debugLine="Dim purchase3Label As Label";
_purchase3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196733;
 //BA.debugLineNum = 196733;BA.debugLine="purchase3Label.Initialize(\"\")";
_purchase3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196734;
 //BA.debugLineNum = 196734;BA.debugLine="purchase3Label.Text = \"Third Purchase\"";
_purchase3label.setText(BA.ObjectToCharSequence("Third Purchase"));
RDebugUtils.currentLine=196735;
 //BA.debugLineNum = 196735;BA.debugLine="purchase3Label.TextColor = Colors.Gray";
_purchase3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196736;
 //BA.debugLineNum = 196736;BA.debugLine="purchase3Label.TextSize = secondaryFontSize";
_purchase3label.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196737;
 //BA.debugLineNum = 196737;BA.debugLine="purchase3Label.Gravity = Gravity.CENTER";
_purchase3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196738;
 //BA.debugLineNum = 196738;BA.debugLine="purchase3Label.Typeface = Typeface.MONOSPACE";
_purchase3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196739;
 //BA.debugLineNum = 196739;BA.debugLine="purchase3Label.Text = purchase3Label.Text.ToUp";
_purchase3label.setText(BA.ObjectToCharSequence(_purchase3label.getText().toUpperCase()));
RDebugUtils.currentLine=196740;
 //BA.debugLineNum = 196740;BA.debugLine="Panel.AddView(purchase3Label,panelWidth*2,purc";
_panel.AddView((android.view.View)(_purchase3label.getObject()),(int) (_panelwidth*2),(int) (_purchase1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196742;
 //BA.debugLineNum = 196742;BA.debugLine="Dim sale1 As Label";
_sale1 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196743;
 //BA.debugLineNum = 196743;BA.debugLine="sale1.Initialize(\"\")";
_sale1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196744;
 //BA.debugLineNum = 196744;BA.debugLine="sale1.Text = totalSales1";
_sale1.setText(BA.ObjectToCharSequence(_totalsales1));
RDebugUtils.currentLine=196745;
 //BA.debugLineNum = 196745;BA.debugLine="sale1.TextColor = Colors.Black";
_sale1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196746;
 //BA.debugLineNum = 196746;BA.debugLine="sale1.TextSize = primaryFontSize";
_sale1.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196747;
 //BA.debugLineNum = 196747;BA.debugLine="sale1.Gravity = Gravity.CENTER";
_sale1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196748;
 //BA.debugLineNum = 196748;BA.debugLine="sale1.Typeface = Typeface.SERIF";
_sale1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196749;
 //BA.debugLineNum = 196749;BA.debugLine="Panel.AddView(sale1,0,purchase3Label.Height+pa";
_panel.AddView((android.view.View)(_sale1.getObject()),(int) (0),(int) (_purchase3label.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196751;
 //BA.debugLineNum = 196751;BA.debugLine="Dim sale1Label As Label";
_sale1label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196752;
 //BA.debugLineNum = 196752;BA.debugLine="sale1Label.Initialize(\"\")";
_sale1label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196753;
 //BA.debugLineNum = 196753;BA.debugLine="sale1Label.Text = \"First Sale\"";
_sale1label.setText(BA.ObjectToCharSequence("First Sale"));
RDebugUtils.currentLine=196754;
 //BA.debugLineNum = 196754;BA.debugLine="sale1Label.TextColor = Colors.Gray";
_sale1label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196755;
 //BA.debugLineNum = 196755;BA.debugLine="sale1Label.TextSize = secondaryFontSize";
_sale1label.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196756;
 //BA.debugLineNum = 196756;BA.debugLine="sale1Label.Gravity = Gravity.CENTER";
_sale1label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196757;
 //BA.debugLineNum = 196757;BA.debugLine="sale1Label.Typeface = Typeface.MONOSPACE";
_sale1label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196758;
 //BA.debugLineNum = 196758;BA.debugLine="sale1Label.Text = sale1Label.Text.ToUpperCase";
_sale1label.setText(BA.ObjectToCharSequence(_sale1label.getText().toUpperCase()));
RDebugUtils.currentLine=196759;
 //BA.debugLineNum = 196759;BA.debugLine="Panel.AddView(sale1Label,0,sale1.top+padding+2";
_panel.AddView((android.view.View)(_sale1label.getObject()),(int) (0),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196761;
 //BA.debugLineNum = 196761;BA.debugLine="Dim sale2 As Label";
_sale2 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196762;
 //BA.debugLineNum = 196762;BA.debugLine="sale2.Initialize(\"\")";
_sale2.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196763;
 //BA.debugLineNum = 196763;BA.debugLine="sale2.Text = totalSales2";
_sale2.setText(BA.ObjectToCharSequence(_totalsales2));
RDebugUtils.currentLine=196764;
 //BA.debugLineNum = 196764;BA.debugLine="sale2.TextColor = Colors.Black";
_sale2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196765;
 //BA.debugLineNum = 196765;BA.debugLine="sale2.TextSize = primaryFontSize";
_sale2.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196766;
 //BA.debugLineNum = 196766;BA.debugLine="sale2.Gravity = Gravity.CENTER";
_sale2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196767;
 //BA.debugLineNum = 196767;BA.debugLine="sale2.Typeface = Typeface.SERIF";
_sale2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196768;
 //BA.debugLineNum = 196768;BA.debugLine="Panel.AddView(sale2,panelWidth,purchase3Label.";
_panel.AddView((android.view.View)(_sale2.getObject()),_panelwidth,(int) (_purchase3label.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196770;
 //BA.debugLineNum = 196770;BA.debugLine="Dim sale2Label As Label";
_sale2label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196771;
 //BA.debugLineNum = 196771;BA.debugLine="sale2Label.Initialize(\"\")";
_sale2label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196772;
 //BA.debugLineNum = 196772;BA.debugLine="sale2Label.Text = \" Second Sale\"";
_sale2label.setText(BA.ObjectToCharSequence(" Second Sale"));
RDebugUtils.currentLine=196773;
 //BA.debugLineNum = 196773;BA.debugLine="sale2Label.TextColor = Colors.Gray";
_sale2label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196774;
 //BA.debugLineNum = 196774;BA.debugLine="sale2Label.TextSize = secondaryFontSize";
_sale2label.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196775;
 //BA.debugLineNum = 196775;BA.debugLine="sale2Label.Gravity = Gravity.CENTER";
_sale2label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196776;
 //BA.debugLineNum = 196776;BA.debugLine="sale2Label.Typeface = Typeface.MONOSPACE";
_sale2label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196777;
 //BA.debugLineNum = 196777;BA.debugLine="sale2Label.Text = sale2Label.Text.ToUpperCase";
_sale2label.setText(BA.ObjectToCharSequence(_sale2label.getText().toUpperCase()));
RDebugUtils.currentLine=196778;
 //BA.debugLineNum = 196778;BA.debugLine="Panel.AddView(sale2Label,panelWidth,sale2.top+";
_panel.AddView((android.view.View)(_sale2label.getObject()),_panelwidth,(int) (_sale2.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196780;
 //BA.debugLineNum = 196780;BA.debugLine="Dim sale3 As Label";
_sale3 = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196781;
 //BA.debugLineNum = 196781;BA.debugLine="sale3.Initialize(\"\")";
_sale3.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196782;
 //BA.debugLineNum = 196782;BA.debugLine="sale3.Text = totalSales3";
_sale3.setText(BA.ObjectToCharSequence(_totalsales3));
RDebugUtils.currentLine=196783;
 //BA.debugLineNum = 196783;BA.debugLine="sale3.TextColor = Colors.Black";
_sale3.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196784;
 //BA.debugLineNum = 196784;BA.debugLine="sale3.TextSize = primaryFontSize";
_sale3.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196785;
 //BA.debugLineNum = 196785;BA.debugLine="sale3.Gravity = Gravity.CENTER";
_sale3.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196786;
 //BA.debugLineNum = 196786;BA.debugLine="sale3.Typeface = Typeface.SERIF";
_sale3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196787;
 //BA.debugLineNum = 196787;BA.debugLine="Panel.AddView(sale3,panelWidth*2,sale2Label.He";
_panel.AddView((android.view.View)(_sale3.getObject()),(int) (_panelwidth*2),(int) (_sale2label.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (90))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196789;
 //BA.debugLineNum = 196789;BA.debugLine="Dim sale3Label As Label";
_sale3label = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196790;
 //BA.debugLineNum = 196790;BA.debugLine="sale3Label.Initialize(\"\")";
_sale3label.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196791;
 //BA.debugLineNum = 196791;BA.debugLine="sale3Label.Text = \" Third Sale\"";
_sale3label.setText(BA.ObjectToCharSequence(" Third Sale"));
RDebugUtils.currentLine=196792;
 //BA.debugLineNum = 196792;BA.debugLine="sale3Label.TextColor = Colors.Gray";
_sale3label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196793;
 //BA.debugLineNum = 196793;BA.debugLine="sale3Label.TextSize = secondaryFontSize";
_sale3label.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196794;
 //BA.debugLineNum = 196794;BA.debugLine="sale3Label.Gravity = Gravity.CENTER";
_sale3label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196795;
 //BA.debugLineNum = 196795;BA.debugLine="sale3Label.Typeface = Typeface.MONOSPACE";
_sale3label.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196796;
 //BA.debugLineNum = 196796;BA.debugLine="sale3Label.Text = sale3Label.Text.ToUpperCase";
_sale3label.setText(BA.ObjectToCharSequence(_sale3label.getText().toUpperCase()));
RDebugUtils.currentLine=196797;
 //BA.debugLineNum = 196797;BA.debugLine="Panel.AddView(sale3Label,panelWidth*2,sale1.to";
_panel.AddView((android.view.View)(_sale3label.getObject()),(int) (_panelwidth*2),(int) (_sale1.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196799;
 //BA.debugLineNum = 196799;BA.debugLine="panelWidth = Panel.Width /2";
_panelwidth = (int) (_panel.getWidth()/(double)2);
RDebugUtils.currentLine=196801;
 //BA.debugLineNum = 196801;BA.debugLine="Dim totalStore As Label";
_totalstore = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196802;
 //BA.debugLineNum = 196802;BA.debugLine="totalStore.Initialize(\"\")";
_totalstore.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196803;
 //BA.debugLineNum = 196803;BA.debugLine="totalStore.Text = total_count";
_totalstore.setText(BA.ObjectToCharSequence(_total_count));
RDebugUtils.currentLine=196804;
 //BA.debugLineNum = 196804;BA.debugLine="totalStore.TextColor = Colors.Black";
_totalstore.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196805;
 //BA.debugLineNum = 196805;BA.debugLine="totalStore.TextSize = primaryFontSize";
_totalstore.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196806;
 //BA.debugLineNum = 196806;BA.debugLine="totalStore.Gravity = Gravity.CENTER";
_totalstore.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196807;
 //BA.debugLineNum = 196807;BA.debugLine="totalStore.Typeface = Typeface.SERIF";
_totalstore.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196808;
 //BA.debugLineNum = 196808;BA.debugLine="Panel.AddView(totalStore,0,sale3Label.Height+p";
_panel.AddView((android.view.View)(_totalstore.getObject()),(int) (0),(int) (_sale3label.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196810;
 //BA.debugLineNum = 196810;BA.debugLine="Dim totalStoreLabel As Label";
_totalstorelabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196811;
 //BA.debugLineNum = 196811;BA.debugLine="totalStoreLabel.Initialize(\"\")";
_totalstorelabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196812;
 //BA.debugLineNum = 196812;BA.debugLine="totalStoreLabel.Text = \" Total Store\"";
_totalstorelabel.setText(BA.ObjectToCharSequence(" Total Store"));
RDebugUtils.currentLine=196813;
 //BA.debugLineNum = 196813;BA.debugLine="totalStoreLabel.TextColor = Colors.Gray";
_totalstorelabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196814;
 //BA.debugLineNum = 196814;BA.debugLine="totalStoreLabel.TextSize = secondaryFontSize";
_totalstorelabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196815;
 //BA.debugLineNum = 196815;BA.debugLine="totalStoreLabel.Gravity = Gravity.CENTER";
_totalstorelabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196816;
 //BA.debugLineNum = 196816;BA.debugLine="totalStoreLabel.Typeface = Typeface.MONOSPACE";
_totalstorelabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196817;
 //BA.debugLineNum = 196817;BA.debugLine="totalStoreLabel.Text = totalStoreLabel.Text.To";
_totalstorelabel.setText(BA.ObjectToCharSequence(_totalstorelabel.getText().toUpperCase()));
RDebugUtils.currentLine=196818;
 //BA.debugLineNum = 196818;BA.debugLine="Panel.AddView(totalStoreLabel,0,totalStore.top";
_panel.AddView((android.view.View)(_totalstorelabel.getObject()),(int) (0),(int) (_totalstore.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196820;
 //BA.debugLineNum = 196820;BA.debugLine="Dim totalPos As Label";
_totalpos = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196821;
 //BA.debugLineNum = 196821;BA.debugLine="totalPos.Initialize(\"\")";
_totalpos.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196822;
 //BA.debugLineNum = 196822;BA.debugLine="totalPos.Text = total_pos";
_totalpos.setText(BA.ObjectToCharSequence(_total_pos));
RDebugUtils.currentLine=196823;
 //BA.debugLineNum = 196823;BA.debugLine="totalPos.TextColor = Colors.Black";
_totalpos.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196824;
 //BA.debugLineNum = 196824;BA.debugLine="totalPos.TextSize = primaryFontSize";
_totalpos.setTextSize((float) (_primaryfontsize));
RDebugUtils.currentLine=196825;
 //BA.debugLineNum = 196825;BA.debugLine="totalPos.Gravity = Gravity.CENTER";
_totalpos.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196826;
 //BA.debugLineNum = 196826;BA.debugLine="totalPos.Typeface = Typeface.SERIF";
_totalpos.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=196827;
 //BA.debugLineNum = 196827;BA.debugLine="Panel.AddView(totalPos,panelWidth,totalStoreLa";
_panel.AddView((android.view.View)(_totalpos.getObject()),_panelwidth,(int) (_totalstorelabel.getHeight()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196829;
 //BA.debugLineNum = 196829;BA.debugLine="Dim totalPosLabel As Label";
_totalposlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=196830;
 //BA.debugLineNum = 196830;BA.debugLine="totalPosLabel.Initialize(\"\")";
_totalposlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=196831;
 //BA.debugLineNum = 196831;BA.debugLine="totalPosLabel.Text = \" Total Pos\"";
_totalposlabel.setText(BA.ObjectToCharSequence(" Total Pos"));
RDebugUtils.currentLine=196832;
 //BA.debugLineNum = 196832;BA.debugLine="totalPosLabel.TextColor = Colors.Gray";
_totalposlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
RDebugUtils.currentLine=196833;
 //BA.debugLineNum = 196833;BA.debugLine="totalPosLabel.TextSize = secondaryFontSize";
_totalposlabel.setTextSize((float) (_secondaryfontsize));
RDebugUtils.currentLine=196834;
 //BA.debugLineNum = 196834;BA.debugLine="totalPosLabel.Gravity = Gravity.CENTER";
_totalposlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=196835;
 //BA.debugLineNum = 196835;BA.debugLine="totalPosLabel.Typeface = Typeface.MONOSPACE";
_totalposlabel.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=196836;
 //BA.debugLineNum = 196836;BA.debugLine="totalPosLabel.Text = totalPosLabel.Text.ToUppe";
_totalposlabel.setText(BA.ObjectToCharSequence(_totalposlabel.getText().toUpperCase()));
RDebugUtils.currentLine=196837;
 //BA.debugLineNum = 196837;BA.debugLine="Panel.AddView(totalPosLabel,panelWidth,totalPo";
_panel.AddView((android.view.View)(_totalposlabel.getObject()),_panelwidth,(int) (_totalpos.getTop()+_padding+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),_panelwidth,_labelheight);
RDebugUtils.currentLine=196841;
 //BA.debugLineNum = 196841;BA.debugLine="If Activity.Width >= 1340 Then";
if (mostCurrent._activity.getWidth()>=1340) { 
RDebugUtils.currentLine=196842;
 //BA.debugLineNum = 196842;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
RDebugUtils.currentLine=196843;
 //BA.debugLineNum = 196843;BA.debugLine="If count Mod numColumns = 0 Then";
if (_count%_numcolumns==0) { 
RDebugUtils.currentLine=196845;
 //BA.debugLineNum = 196845;BA.debugLine="leftPosition = 10dip";
_leftposition = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
RDebugUtils.currentLine=196846;
 //BA.debugLineNum = 196846;BA.debugLine="topPosition = topPosition + pnlHeight + padd";
_topposition = (int) (_topposition+_pnlheight+_padding);
 }else {
RDebugUtils.currentLine=196849;
 //BA.debugLineNum = 196849;BA.debugLine="leftPosition = leftPosition + pnlWidth + pad";
_leftposition = (int) (_leftposition+_pnlwidth+_padding);
 };
RDebugUtils.currentLine=196851;
 //BA.debugLineNum = 196851;BA.debugLine="scrollHeight = scrollHeight + 175dip";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (175)));
 }else {
RDebugUtils.currentLine=196853;
 //BA.debugLineNum = 196853;BA.debugLine="topPosition = topPosition + pnlHeight + paddi";
_topposition = (int) (_topposition+_pnlheight+_padding);
RDebugUtils.currentLine=196854;
 //BA.debugLineNum = 196854;BA.debugLine="scrollHeight = scrollHeight + 300dip + paddin";
_scrollheight = (int) (_scrollheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300))+_padding);
 };
RDebugUtils.currentLine=196858;
 //BA.debugLineNum = 196858;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=196859;
 //BA.debugLineNum = 196859;BA.debugLine="cd.Initialize2(Colors.White, 0dip, 1dip, Color";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)),anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=196860;
 //BA.debugLineNum = 196860;BA.debugLine="Panel.Background = cd";
_panel.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 }
};
RDebugUtils.currentLine=196864;
 //BA.debugLineNum = 196864;BA.debugLine="ScrollView1.Panel.Height = scrollHeight";
mostCurrent._scrollview1.getPanel().setHeight(_scrollheight);
 } 
       catch (Exception e221) {
			processBA.setLastException(e221);RDebugUtils.currentLine=196867;
 //BA.debugLineNum = 196867;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error parsing data"),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
RDebugUtils.currentLine=196870;
 //BA.debugLineNum = 196870;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=196873;
 //BA.debugLineNum = 196873;BA.debugLine="job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=196874;
 //BA.debugLineNum = 196874;BA.debugLine="End Sub";
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
}