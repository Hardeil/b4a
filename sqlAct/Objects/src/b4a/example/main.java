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
vis = vis | (dash.mostCurrent != null);
vis = vis | (graph.mostCurrent != null);
vis = vis | (schedule.mostCurrent != null);
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
            if (dash.previousOne != null) {
				__a = dash.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(dash.mostCurrent == null ? null : dash.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (graph.previousOne != null) {
				__a = graph.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(graph.mostCurrent == null ? null : graph.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (schedule.previousOne != null) {
				__a = schedule.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(schedule.mostCurrent == null ? null : schedule.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.dash _dash = null;
public b4a.example.charts _charts = null;
public b4a.example.graph _graph = null;
public b4a.example.schedule _schedule = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
int _bordercolor = 0;
int _borderwidth = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
anywheresoftware.b4a.objects.LabelWrapper _roomno = null;
anywheresoftware.b4a.objects.LabelWrapper _status = null;
anywheresoftware.b4a.objects.PanelWrapper _teacherdetail = null;
anywheresoftware.b4a.objects.ImageViewWrapper _profile = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _originalbitmap = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _circularbitmap = null;
anywheresoftware.b4a.objects.LabelWrapper _teachername = null;
anywheresoftware.b4a.objects.LabelWrapper _teachertitle = null;
anywheresoftware.b4a.objects.PanelWrapper _subject = null;
anywheresoftware.b4a.objects.PanelWrapper _totalstudents = null;
anywheresoftware.b4a.objects.LabelWrapper _activestudents = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Activity.LoadLayout(\"dash\")";
mostCurrent._activity.LoadLayout("dash",mostCurrent.activityBA);
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Dim borderColor As Int = Colors.Black";
_bordercolor = anywheresoftware.b4a.keywords.Common.Colors.Black;
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Dim borderWidth As Int = 2dip";
_borderwidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2));
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Panel2.SetLayout(28%x,50%y,250dip,250dip)";
mostCurrent._panel2.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (28),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (50),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)));
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="Dim roomNo As Label";
_roomno = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="roomNo.Initialize(\"\")";
_roomno.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="roomNo.Text = \"Room No.\"";
_roomno.setText(BA.ObjectToCharSequence("Room No."));
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="roomNo.TextSize = 16";
_roomno.setTextSize((float) (16));
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="roomNo.TextColor = Colors.Black";
_roomno.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="roomNo.Typeface = Typeface.DEFAULT_BOLD";
_roomno.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="roomNo.Gravity = Gravity.CENTER";
_roomno.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="Panel3.AddView(roomNo, 2.6%x, 20dip, 120dip, 35di";
mostCurrent._panel3.AddView((android.view.View)(_roomno.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2.6),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="cvs.Initialize(roomNo)";
_cvs.Initialize((android.view.View)(_roomno.getObject()));
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="DrawBorder(cvs, roomNo.Width, roomNo.Height, bord";
_drawborder(_cvs,_roomno.getWidth(),_roomno.getHeight(),_bordercolor,_borderwidth);
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="Dim status As Label";
_status = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="status.Initialize(\"\")";
_status.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="status.Text = \"Status\"";
_status.setText(BA.ObjectToCharSequence("Status"));
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="status.TextSize = 16";
_status.setTextSize((float) (16));
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="status.TextColor = Colors.Black";
_status.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=262169;
 //BA.debugLineNum = 262169;BA.debugLine="status.Typeface = Typeface.DEFAULT_BOLD";
_status.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=262170;
 //BA.debugLineNum = 262170;BA.debugLine="status.Gravity = Gravity.CENTER";
_status.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262171;
 //BA.debugLineNum = 262171;BA.debugLine="Panel3.AddView(status, Activity.Width-24%x, 20dip";
mostCurrent._panel3.AddView((android.view.View)(_status.getObject()),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (24),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35)));
RDebugUtils.currentLine=262173;
 //BA.debugLineNum = 262173;BA.debugLine="cvs.Initialize(status)";
_cvs.Initialize((android.view.View)(_status.getObject()));
RDebugUtils.currentLine=262174;
 //BA.debugLineNum = 262174;BA.debugLine="DrawBorder(cvs, status.Width, status.Height, bord";
_drawborder(_cvs,_status.getWidth(),_status.getHeight(),_bordercolor,_borderwidth);
RDebugUtils.currentLine=262176;
 //BA.debugLineNum = 262176;BA.debugLine="Dim teacherDetail As Panel";
_teacherdetail = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262177;
 //BA.debugLineNum = 262177;BA.debugLine="teacherDetail .Initialize(\"\")";
_teacherdetail.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262178;
 //BA.debugLineNum = 262178;BA.debugLine="teacherDetail.Color = Colors.RGB(18,66,36)";
_teacherdetail.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (66),(int) (36)));
RDebugUtils.currentLine=262179;
 //BA.debugLineNum = 262179;BA.debugLine="Panel3.AddView(teacherDetail , 2.5%x, 80dip, Acti";
mostCurrent._panel3.AddView((android.view.View)(_teacherdetail.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2.5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80)),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (32),mostCurrent.activityBA));
RDebugUtils.currentLine=262180;
 //BA.debugLineNum = 262180;BA.debugLine="CreateRadius(teacherDetail)";
_createradius(_teacherdetail);
RDebugUtils.currentLine=262182;
 //BA.debugLineNum = 262182;BA.debugLine="Dim profile As ImageView";
_profile = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=262183;
 //BA.debugLineNum = 262183;BA.debugLine="profile.Initialize(\"\")";
_profile.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262184;
 //BA.debugLineNum = 262184;BA.debugLine="profile.BringToFront";
_profile.BringToFront();
RDebugUtils.currentLine=262185;
 //BA.debugLineNum = 262185;BA.debugLine="Panel3.AddView(profile , Activity.Width-68%x, -30";
mostCurrent._panel3.AddView((android.view.View)(_profile.getObject()),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (68),mostCurrent.activityBA)),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (37),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (37),mostCurrent.activityBA));
RDebugUtils.currentLine=262187;
 //BA.debugLineNum = 262187;BA.debugLine="Dim originalBitmap As B4XBitmap = xui.LoadBitmapR";
_originalbitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_originalbitmap = _xui.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"profile.jpg",anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=262188;
 //BA.debugLineNum = 262188;BA.debugLine="Dim circularBitmap As B4XBitmap = CreateRoundBitm";
_circularbitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_circularbitmap = _createroundbitmap(_originalbitmap,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA));
RDebugUtils.currentLine=262189;
 //BA.debugLineNum = 262189;BA.debugLine="profile .Bitmap = circularBitmap";
_profile.setBitmap((android.graphics.Bitmap)(_circularbitmap.getObject()));
RDebugUtils.currentLine=262192;
 //BA.debugLineNum = 262192;BA.debugLine="Dim teacherName As Label";
_teachername = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262193;
 //BA.debugLineNum = 262193;BA.debugLine="teacherName.Initialize(\"\")";
_teachername.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262194;
 //BA.debugLineNum = 262194;BA.debugLine="teacherName.Gravity = Gravity.CENTER";
_teachername.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262195;
 //BA.debugLineNum = 262195;BA.debugLine="teacherName.Text = \"Angel Santos\"";
_teachername.setText(BA.ObjectToCharSequence("Angel Santos"));
RDebugUtils.currentLine=262196;
 //BA.debugLineNum = 262196;BA.debugLine="teacherName.TextSize = 5%x";
_teachername.setTextSize((float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA)));
RDebugUtils.currentLine=262197;
 //BA.debugLineNum = 262197;BA.debugLine="teacherName.TextColor = Colors.White";
_teachername.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=262198;
 //BA.debugLineNum = 262198;BA.debugLine="teacherName.Typeface = Typeface.DEFAULT_BOLD";
_teachername.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=262199;
 //BA.debugLineNum = 262199;BA.debugLine="teacherName.Typeface = Typeface.SERIF";
_teachername.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.SERIF);
RDebugUtils.currentLine=262200;
 //BA.debugLineNum = 262200;BA.debugLine="teacherDetail.AddView(teacherName , 0, 8%y, teach";
_teacherdetail.AddView((android.view.View)(_teachername.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (8),mostCurrent.activityBA),_teacherdetail.getWidth(),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=262202;
 //BA.debugLineNum = 262202;BA.debugLine="Dim teacherTitle As Label";
_teachertitle = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262203;
 //BA.debugLineNum = 262203;BA.debugLine="teacherTitle.Initialize(\"\")";
_teachertitle.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262204;
 //BA.debugLineNum = 262204;BA.debugLine="teacherTitle.Gravity = Gravity.CENTER";
_teachertitle.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262205;
 //BA.debugLineNum = 262205;BA.debugLine="teacherTitle.Text = \"Teacher Name\"";
_teachertitle.setText(BA.ObjectToCharSequence("Teacher Name"));
RDebugUtils.currentLine=262206;
 //BA.debugLineNum = 262206;BA.debugLine="teacherTitle.TextSize = 2.5%x";
_teachertitle.setTextSize((float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2.5),mostCurrent.activityBA)));
RDebugUtils.currentLine=262207;
 //BA.debugLineNum = 262207;BA.debugLine="teacherTitle.TextColor = Colors.ARGB(128, 255, 25";
_teachertitle.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (255),(int) (255),(int) (255)));
RDebugUtils.currentLine=262208;
 //BA.debugLineNum = 262208;BA.debugLine="teacherDetail.AddView(teacherTitle , 0, teacherNa";
_teacherdetail.AddView((android.view.View)(_teachertitle.getObject()),(int) (0),(int) (_teachername.getTop()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (4.2),mostCurrent.activityBA)),_teacherdetail.getWidth(),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=262210;
 //BA.debugLineNum = 262210;BA.debugLine="Dim subject As Panel";
_subject = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262211;
 //BA.debugLineNum = 262211;BA.debugLine="subject.Initialize(\"\")";
_subject.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262212;
 //BA.debugLineNum = 262212;BA.debugLine="subject.Color = Colors.RGB(18,66,36)";
_subject.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (66),(int) (36)));
RDebugUtils.currentLine=262213;
 //BA.debugLineNum = 262213;BA.debugLine="Panel3.AddView(subject, 1.6%y ,teacherDetail.Top";
mostCurrent._panel3.AddView((android.view.View)(_subject.getObject()),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1.6),mostCurrent.activityBA),(int) (_teacherdetail.getTop()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (21.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (55),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)));
RDebugUtils.currentLine=262214;
 //BA.debugLineNum = 262214;BA.debugLine="CreateRadius(subject)";
_createradius(_subject);
RDebugUtils.currentLine=262217;
 //BA.debugLineNum = 262217;BA.debugLine="Dim totalStudents As Panel";
_totalstudents = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=262218;
 //BA.debugLineNum = 262218;BA.debugLine="totalStudents.Initialize(\"\")";
_totalstudents.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262219;
 //BA.debugLineNum = 262219;BA.debugLine="totalStudents.Color = Colors.Transparent ' Set tr";
_totalstudents.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=262220;
 //BA.debugLineNum = 262220;BA.debugLine="Panel3.AddView(totalStudents, 60%x ,teacherDetail";
mostCurrent._panel3.AddView((android.view.View)(_totalstudents.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA),(int) (_teacherdetail.getTop()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (21.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (37.5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (110)));
RDebugUtils.currentLine=262221;
 //BA.debugLineNum = 262221;BA.debugLine="CreateRadius(totalStudents)";
_createradius(_totalstudents);
RDebugUtils.currentLine=262223;
 //BA.debugLineNum = 262223;BA.debugLine="Dim activeStudents As Label";
_activestudents = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=262224;
 //BA.debugLineNum = 262224;BA.debugLine="activeStudents.Initialize(\"\")";
_activestudents.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=262225;
 //BA.debugLineNum = 262225;BA.debugLine="activeStudents.Text = \"No. of Student in the Clas";
_activestudents.setText(BA.ObjectToCharSequence("No. of Student in the Classroom"));
RDebugUtils.currentLine=262226;
 //BA.debugLineNum = 262226;BA.debugLine="activeStudents.Gravity = Gravity.CENTER";
_activestudents.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=262227;
 //BA.debugLineNum = 262227;BA.debugLine="activeStudents.TextSize = 15dip";
_activestudents.setTextSize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))));
RDebugUtils.currentLine=262228;
 //BA.debugLineNum = 262228;BA.debugLine="Panel3.AddView(activeStudents, 0 ,Panel2.Top + 20";
mostCurrent._panel3.AddView((android.view.View)(_activestudents.getObject()),(int) (0),(int) (mostCurrent._panel2.getTop()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA)),mostCurrent._panel3.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=262230;
 //BA.debugLineNum = 262230;BA.debugLine="Log(Activity.Width & \"this is widht\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0262230",BA.NumberToString(mostCurrent._activity.getWidth())+"this is widht",0);
RDebugUtils.currentLine=262231;
 //BA.debugLineNum = 262231;BA.debugLine="Log(Activity.Height & \"this is Height\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0262231",BA.NumberToString(mostCurrent._activity.getHeight())+"this is Height",0);
RDebugUtils.currentLine=262233;
 //BA.debugLineNum = 262233;BA.debugLine="If Activity.Width > 800 Then";
if (mostCurrent._activity.getWidth()>800) { 
RDebugUtils.currentLine=262234;
 //BA.debugLineNum = 262234;BA.debugLine="teacherDetail.SetLayout(10dip,12%y,Activity.Widt";
_teacherdetail.SetLayout(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (12),mostCurrent.activityBA),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
RDebugUtils.currentLine=262235;
 //BA.debugLineNum = 262235;BA.debugLine="profile.SetLayout(2.5%x,teacherDetail.Top + 3%y,";
_profile.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2.5),mostCurrent.activityBA),(int) (_teacherdetail.getTop()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (32),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (32),mostCurrent.activityBA));
RDebugUtils.currentLine=262236;
 //BA.debugLineNum = 262236;BA.debugLine="Dim circularBitmap As B4XBitmap = CreateRoundBit";
_circularbitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_circularbitmap = _createroundbitmap(_originalbitmap,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (28),mostCurrent.activityBA));
RDebugUtils.currentLine=262237;
 //BA.debugLineNum = 262237;BA.debugLine="profile .Bitmap = circularBitmap";
_profile.setBitmap((android.graphics.Bitmap)(_circularbitmap.getObject()));
RDebugUtils.currentLine=262238;
 //BA.debugLineNum = 262238;BA.debugLine="teacherName.SetLayout(16%x,10%y,teacherDetail.Wi";
_teachername.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (16),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),(int) (_teacherdetail.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (17),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=262239;
 //BA.debugLineNum = 262239;BA.debugLine="teacherName.TextSize = 3.5%y";
_teachername.setTextSize((float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (3.5),mostCurrent.activityBA)));
RDebugUtils.currentLine=262240;
 //BA.debugLineNum = 262240;BA.debugLine="teacherTitle.SetLayout(16%x,teacherName.Top+5%y,";
_teachertitle.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (16),mostCurrent.activityBA),(int) (_teachername.getTop()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA)),(int) (_teacherdetail.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (17),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=262241;
 //BA.debugLineNum = 262241;BA.debugLine="teacherTitle.TextSize = 2.5%y";
_teachertitle.setTextSize((float) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2.5),mostCurrent.activityBA)));
RDebugUtils.currentLine=262242;
 //BA.debugLineNum = 262242;BA.debugLine="teacherDetail.SendToBack";
_teacherdetail.SendToBack();
RDebugUtils.currentLine=262243;
 //BA.debugLineNum = 262243;BA.debugLine="subject.SetLayout(1%x,teacherDetail.Top + teache";
_subject.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),(int) (_teacherdetail.getTop()+_teacherdetail.getHeight()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=262244;
 //BA.debugLineNum = 262244;BA.debugLine="totalStudents.SetLayout(subject.Left+subject.Wid";
_totalstudents.SetLayout((int) (_subject.getLeft()+_subject.getWidth()+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA)),(int) (_teacherdetail.getTop()+_teacherdetail.getHeight()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2.5),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (192)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
RDebugUtils.currentLine=262245;
 //BA.debugLineNum = 262245;BA.debugLine="Panel2.SetLayout(62%x,20%y,250dip,250dip)";
mostCurrent._panel2.SetLayout(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (62),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)));
RDebugUtils.currentLine=262246;
 //BA.debugLineNum = 262246;BA.debugLine="activeStudents.SetLayout(Panel2.Left-2%x,Panel2.";
_activestudents.SetLayout((int) (mostCurrent._panel2.getLeft()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA)),(int) (mostCurrent._panel2.getTop()+mostCurrent._panel2.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),(int) (mostCurrent._panel2.getWidth()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=262247;
 //BA.debugLineNum = 262247;BA.debugLine="roomNo.Left = 1%x";
_roomno.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA));
RDebugUtils.currentLine=262248;
 //BA.debugLineNum = 262248;BA.debugLine="status.Left = 39%x";
_status.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (39),mostCurrent.activityBA));
 };
RDebugUtils.currentLine=262251;
 //BA.debugLineNum = 262251;BA.debugLine="End Sub";
return "";
}
public static String  _drawborder(anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs,int _width,int _height,int _bordercolor,int _borderwidth) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawborder", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawborder", new Object[] {_cvs,_width,_height,_bordercolor,_borderwidth}));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub DrawBorder(cvs As Canvas, width As Int, height";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="cvs.DrawLine(0, 0, width, 0, borderColor, borderW";
_cvs.DrawLine((float) (0),(float) (0),(float) (_width),(float) (0),_bordercolor,(float) (_borderwidth));
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="cvs.DrawLine(width, 0, width, height, borderColor";
_cvs.DrawLine((float) (_width),(float) (0),(float) (_width),(float) (_height),_bordercolor,(float) (_borderwidth));
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="cvs.DrawLine(width, height, 0, height, borderColo";
_cvs.DrawLine((float) (_width),(float) (_height),(float) (0),(float) (_height),_bordercolor,(float) (_borderwidth));
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="cvs.DrawLine(0, height, 0, 0, borderColor, border";
_cvs.DrawLine((float) (0),(float) (_height),(float) (0),(float) (0),_bordercolor,(float) (_borderwidth));
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="End Sub";
return "";
}
public static String  _createradius(anywheresoftware.b4a.objects.PanelWrapper _totalstudents) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createradius", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createradius", new Object[] {_totalstudents}));}
anywheresoftware.b4a.objects.drawable.GradientDrawable _bg = null;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub CreateRadius(totalStudents As Panel)";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Dim bg As GradientDrawable";
_bg = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="bg.Initialize(\"TOP_BOTTOM\", Array As Int(Colors.R";
_bg.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TOP_BOTTOM"),new int[]{anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (66),(int) (36)),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (18),(int) (66),(int) (36))});
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="bg.CornerRadius = 7dip  ' Half of height to make";
_bg.setCornerRadius((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (7))));
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="totalStudents.Background = bg";
_totalstudents.setBackground((android.graphics.drawable.Drawable)(_bg.getObject()));
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _resizedbitmap = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _res = null;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub CreateRoundBitmap (Input As B4XBitmap, Size As";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If Input.Width <= 0 Or Input.Height <= 0 Then";
if (_input.getWidth()<=0 || _input.getHeight()<=0) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Log(\"Error: Invalid bitmap dimensions.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0393218","Error: Invalid bitmap dimensions.",0);
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Return Null";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 };
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="If Input.Width <> Input.Height Then";
if (_input.getWidth()!=_input.getHeight()) { 
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="Dim l As Int = Min(Input.Width, Input.Height)";
_l = (int) (anywheresoftware.b4a.keywords.Common.Min(_input.getWidth(),_input.getHeight()));
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Input = Input.Crop(Input.Width / 2 - l / 2, Inpu";
_input = _input.Crop((int) (_input.getWidth()/(double)2-_l/(double)2),(int) (_input.getHeight()/(double)2-_l/(double)2),_l,_l);
 };
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="Dim c As B4XCanvas";
_c = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
_xview = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xview = _xui.CreatePanel(processBA,"");
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, Size, Size)";
_xview.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_size,_size);
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="c.Initialize(xview)";
_c.Initialize(_xview);
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="Dim path As B4XPath";
_path = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="path.InitializeOval(c.TargetRect)";
_path.InitializeOval(_c.getTargetRect());
RDebugUtils.currentLine=393236;
 //BA.debugLineNum = 393236;BA.debugLine="c.ClipPath(path)";
_c.ClipPath(_path);
RDebugUtils.currentLine=393239;
 //BA.debugLineNum = 393239;BA.debugLine="Dim resizedBitmap As B4XBitmap = Input.Resize(Siz";
_resizedbitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_resizedbitmap = _input.Resize(_size,_size,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393240;
 //BA.debugLineNum = 393240;BA.debugLine="c.DrawBitmap(resizedBitmap, c.TargetRect)";
_c.DrawBitmap((android.graphics.Bitmap)(_resizedbitmap.getObject()),_c.getTargetRect());
RDebugUtils.currentLine=393242;
 //BA.debugLineNum = 393242;BA.debugLine="c.RemoveClip";
_c.RemoveClip();
RDebugUtils.currentLine=393245;
 //BA.debugLineNum = 393245;BA.debugLine="c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.C";
_c.DrawCircle(_c.getTargetRect().getCenterX(),_c.getTargetRect().getCenterY(),(float) (_c.getTargetRect().getWidth()/(double)2-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.False,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))));
RDebugUtils.currentLine=393246;
 //BA.debugLineNum = 393246;BA.debugLine="c.Invalidate";
_c.Invalidate();
RDebugUtils.currentLine=393249;
 //BA.debugLineNum = 393249;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
_res = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_res = _c.CreateBitmap();
RDebugUtils.currentLine=393250;
 //BA.debugLineNum = 393250;BA.debugLine="c.Release";
_c.Release();
RDebugUtils.currentLine=393251;
 //BA.debugLineNum = 393251;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=393252;
 //BA.debugLineNum = 393252;BA.debugLine="End Sub";
return null;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _btngotosecond_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btngotosecond_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btngotosecond_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub btnGoToSecond_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="StartActivity(\"Schedule\") ' Navigate to SecondAct";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Schedule"));
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="End Sub";
return "";
}
public static String  _label5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label5_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub Label5_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="StartActivity(\"Dash\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Dash"));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Log(\"yoww\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0720899","yoww",0);
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="End Sub";
return "";
}
public static String  _label6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label6_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub Label6_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="StartActivity(\"Dash\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Dash"));
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Log(\"yoww\")";
anywheresoftware.b4a.keywords.Common.LogImpl("0655363","yoww",0);
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="End Sub";
return "";
}
public static String  _loadmysqldata() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "loadmysqldata", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "loadmysqldata", null));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub LoadMySQLData";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="End Sub";
return "";
}
}