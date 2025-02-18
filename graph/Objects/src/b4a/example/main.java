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
public anywheresoftware.b4a.objects.PanelWrapper _barpanel = null;
public static String[] _legend = null;
public static int[] _sales = null;
public static int[] _sales1 = null;
public static int[] _sales2 = null;
public static String[] _product = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="barPanel.Initialize(\"\")";
mostCurrent._barpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.AddView(barPanel, 25dip, 30dip, Activity";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._barpanel.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (25)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1000)));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="DrawGraph(Activity,barPanel)";
_drawgraph(mostCurrent._activity,mostCurrent._barpanel);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="End Sub";
return "";
}
public static String  _drawgraph(anywheresoftware.b4a.objects.ActivityWrapper _active,anywheresoftware.b4a.objects.PanelWrapper _panel) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawgraph", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "drawgraph", new Object[] {_active,_panel}));}
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
anywheresoftware.b4a.objects.LabelWrapper _title = null;
anywheresoftware.b4a.objects.PanelWrapper _legendpanel = null;
int[] _color = null;
int _legendwidth = 0;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _colorlabel = null;
anywheresoftware.b4a.objects.LabelWrapper _legendlabel = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _maxsale = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cv = null;
int _totalproducts = 0;
int _barsperproduct = 0;
int _totalbars = 0;
int _gap = 0;
int _productgap = 0;
int _padding = 0;
int _availablewidth = 0;
int _barwidth = 0;
int _xstart = 0;
int _xpos = 0;
int[] _salevalues = null;
int _j = 0;
int _sale = 0;
int _barheight = 0;
int _xbar = 0;
int _shadowcolor = 0;
int _shadowoffset = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _shadowrect = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
int _labelypos = 0;
int _productlabely = 0;
int _productlabelx = 0;
int _numlabels = 0;
int _labelvalue = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub DrawGraph(Active As Activity,panel As Panel)";
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="panel.Height = 400dip";
_panel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (400)));
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(mostCurrent.activityBA,"activityPanel");
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="activityPanel.Width = 80%x";
_activitypanel.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA));
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="activityPanel.Height = 250dip";
_activitypanel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (250)));
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
_alignleftcenter = (int) ((_active.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
_aligntopcenter = (int) ((_panel.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="Dim title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="title.Initialize(\"\")";
_title.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376273;
 //BA.debugLineNum = 1376273;BA.debugLine="title.Text = \"Total Sales For Companies\"";
_title.setText(BA.ObjectToCharSequence("Total Sales For Companies"));
RDebugUtils.currentLine=1376274;
 //BA.debugLineNum = 1376274;BA.debugLine="title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE);
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="title.Gravity = Gravity.CENTER";
_title.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376277;
 //BA.debugLineNum = 1376277;BA.debugLine="title.TextColor = Colors.Black";
_title.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="Dim legendPanel As Panel";
_legendpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="legendPanel.Initialize(\"\")";
_legendpanel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376282;
 //BA.debugLineNum = 1376282;BA.debugLine="legendPanel.Width = panel.Width";
_legendpanel.setWidth(_panel.getWidth());
RDebugUtils.currentLine=1376283;
 //BA.debugLineNum = 1376283;BA.debugLine="legendPanel.Height = 30dip";
_legendpanel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1376284;
 //BA.debugLineNum = 1376284;BA.debugLine="panel.AddView(legendPanel, panel.Width/2, 0, pane";
_panel.AddView((android.view.View)(_legendpanel.getObject()),(int) (_panel.getWidth()/(double)2),(int) (0),(int) (_panel.getWidth()/(double)2),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1376287;
 //BA.debugLineNum = 1376287;BA.debugLine="Dim color() As Int = Array As Int(Colors.Red, Col";
_color = new int[]{anywheresoftware.b4a.keywords.Common.Colors.Red,anywheresoftware.b4a.keywords.Common.Colors.Green,anywheresoftware.b4a.keywords.Common.Colors.Blue};
RDebugUtils.currentLine=1376288;
 //BA.debugLineNum = 1376288;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
_legendwidth = (int) (_legendpanel.getWidth()/(double)mostCurrent._legend.length);
RDebugUtils.currentLine=1376290;
 //BA.debugLineNum = 1376290;BA.debugLine="For i = 0 To legend.Length - 1";
{
final int step23 = 1;
final int limit23 = (int) (mostCurrent._legend.length-1);
_i = (int) (0) ;
for (;_i <= limit23 ;_i = _i + step23 ) {
RDebugUtils.currentLine=1376291;
 //BA.debugLineNum = 1376291;BA.debugLine="Dim colorLabel As Label";
_colorlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376292;
 //BA.debugLineNum = 1376292;BA.debugLine="colorLabel.Initialize(\"\")";
_colorlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376293;
 //BA.debugLineNum = 1376293;BA.debugLine="colorLabel.Color = color(i)";
_colorlabel.setColor(_color[_i]);
RDebugUtils.currentLine=1376294;
 //BA.debugLineNum = 1376294;BA.debugLine="legendPanel.AddView(colorLabel, (legendWidth * i";
_legendpanel.AddView((android.view.View)(_colorlabel.getObject()),(int) ((_legendwidth*_i)+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),(int) (_legendpanel.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (18))));
RDebugUtils.currentLine=1376296;
 //BA.debugLineNum = 1376296;BA.debugLine="Dim legendLabel As Label";
_legendlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1376297;
 //BA.debugLineNum = 1376297;BA.debugLine="legendLabel.Initialize(\"\")";
_legendlabel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1376298;
 //BA.debugLineNum = 1376298;BA.debugLine="legendLabel.Text = legend(i)";
_legendlabel.setText(BA.ObjectToCharSequence(mostCurrent._legend[_i]));
RDebugUtils.currentLine=1376299;
 //BA.debugLineNum = 1376299;BA.debugLine="legendLabel.TextColor = Colors.black  ' Set text";
_legendlabel.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1376300;
 //BA.debugLineNum = 1376300;BA.debugLine="legendLabel.Gravity = Gravity.CENTER";
_legendlabel.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=1376301;
 //BA.debugLineNum = 1376301;BA.debugLine="legendPanel.AddView(legendLabel, (legendWidth *";
_legendpanel.AddView((android.view.View)(_legendlabel.getObject()),(int) ((_legendwidth*_i)+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),(int) (_legendwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_legendpanel.getHeight());
 }
};
RDebugUtils.currentLine=1376305;
 //BA.debugLineNum = 1376305;BA.debugLine="panel.AddView(title, 0, alignTopCenter / 2, panel";
_panel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_panel.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=1376308;
 //BA.debugLineNum = 1376308;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
_panel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=1376311;
 //BA.debugLineNum = 1376311;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1376312;
 //BA.debugLineNum = 1376312;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=1376315;
 //BA.debugLineNum = 1376315;BA.debugLine="Dim maxSale As Int = 400000";
_maxsale = (int) (400000);
RDebugUtils.currentLine=1376317;
 //BA.debugLineNum = 1376317;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=1376318;
 //BA.debugLineNum = 1376318;BA.debugLine="cv.Initialize(panel)";
_cv.Initialize((android.view.View)(_panel.getObject()));
RDebugUtils.currentLine=1376320;
 //BA.debugLineNum = 1376320;BA.debugLine="Dim totalProducts As Int = sales.Length";
_totalproducts = _sales.length;
RDebugUtils.currentLine=1376321;
 //BA.debugLineNum = 1376321;BA.debugLine="Dim barsPerProduct As Int = 3 ' Since there are 3";
_barsperproduct = (int) (3);
RDebugUtils.currentLine=1376322;
 //BA.debugLineNum = 1376322;BA.debugLine="Dim totalBars As Int = totalProducts * barsPerPro";
_totalbars = (int) (_totalproducts*_barsperproduct);
RDebugUtils.currentLine=1376323;
 //BA.debugLineNum = 1376323;BA.debugLine="Dim gap As Int = 5dip";
_gap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5));
RDebugUtils.currentLine=1376324;
 //BA.debugLineNum = 1376324;BA.debugLine="Dim productGap As Int = 15dip";
_productgap = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15));
RDebugUtils.currentLine=1376325;
 //BA.debugLineNum = 1376325;BA.debugLine="Dim padding As Int = 20dip";
_padding = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20));
RDebugUtils.currentLine=1376326;
 //BA.debugLineNum = 1376326;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
_availablewidth = (int) (_activitypanel.getWidth()-(_padding*2)-((_totalproducts-1)*_productgap)-((_totalbars-_totalproducts)*_gap));
RDebugUtils.currentLine=1376328;
 //BA.debugLineNum = 1376328;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
_barwidth = (int) (_availablewidth/(double)_totalbars);
RDebugUtils.currentLine=1376330;
 //BA.debugLineNum = 1376330;BA.debugLine="Dim xStart As Int = padding ' Start position afte";
_xstart = _padding;
RDebugUtils.currentLine=1376332;
 //BA.debugLineNum = 1376332;BA.debugLine="For i = 0 To totalProducts - 1";
{
final int step51 = 1;
final int limit51 = (int) (_totalproducts-1);
_i = (int) (0) ;
for (;_i <= limit51 ;_i = _i + step51 ) {
RDebugUtils.currentLine=1376333;
 //BA.debugLineNum = 1376333;BA.debugLine="Dim xPos As Int = xStart + i * (barsPerProduct *";
_xpos = (int) (_xstart+_i*(_barsperproduct*(_barwidth+_gap)+_productgap));
RDebugUtils.currentLine=1376335;
 //BA.debugLineNum = 1376335;BA.debugLine="Dim saleValues() As Int = Array As Int(sales(i),";
_salevalues = new int[]{_sales[_i],_sales1[_i],_sales2[_i]};
RDebugUtils.currentLine=1376337;
 //BA.debugLineNum = 1376337;BA.debugLine="For j = 0 To barsPerProduct - 1";
{
final int step54 = 1;
final int limit54 = (int) (_barsperproduct-1);
_j = (int) (0) ;
for (;_j <= limit54 ;_j = _j + step54 ) {
RDebugUtils.currentLine=1376338;
 //BA.debugLineNum = 1376338;BA.debugLine="Dim sale As Int = saleValues(j)";
_sale = _salevalues[_j];
RDebugUtils.currentLine=1376339;
 //BA.debugLineNum = 1376339;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * activ";
_barheight = (int) ((_sale/(double)_maxsale)*_activitypanel.getHeight());
RDebugUtils.currentLine=1376340;
 //BA.debugLineNum = 1376340;BA.debugLine="Dim xBar As Int = xPos + j * (barWidth + gap)";
_xbar = (int) (_xpos+_j*(_barwidth+_gap));
RDebugUtils.currentLine=1376342;
 //BA.debugLineNum = 1376342;BA.debugLine="Dim shadowColor As Int = Colors.ARGB(100, 50, 5";
_shadowcolor = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (100),(int) (50),(int) (50),(int) (50));
RDebugUtils.currentLine=1376343;
 //BA.debugLineNum = 1376343;BA.debugLine="Dim shadowOffset As Int = 3dip";
_shadowoffset = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (3));
RDebugUtils.currentLine=1376344;
 //BA.debugLineNum = 1376344;BA.debugLine="Dim shadowRect As Rect";
_shadowrect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1376345;
 //BA.debugLineNum = 1376345;BA.debugLine="shadowRect.Initialize(xBar + shadowOffset, acti";
_shadowrect.Initialize((int) (_xbar+_shadowoffset),(int) (_activitypanel.getHeight()-_barheight+_shadowoffset),(int) (_xbar+_barwidth+_shadowoffset),(int) (_activitypanel.getHeight()+_shadowoffset));
RDebugUtils.currentLine=1376346;
 //BA.debugLineNum = 1376346;BA.debugLine="graphCanvas.DrawRect(shadowRect, shadowColor, T";
_graphcanvas.DrawRect((android.graphics.Rect)(_shadowrect.getObject()),_shadowcolor,anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1376349;
 //BA.debugLineNum = 1376349;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1376350;
 //BA.debugLineNum = 1376350;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barHe";
_r.Initialize(_xbar,(int) (_activitypanel.getHeight()-_barheight),(int) (_xbar+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=1376351;
 //BA.debugLineNum = 1376351;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),_color[_j],anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1376354;
 //BA.debugLineNum = 1376354;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - b";
_labelypos = (int) (_activitypanel.getHeight()-_barheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)));
RDebugUtils.currentLine=1376355;
 //BA.debugLineNum = 1376355;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sal";
_graphcanvas.DrawText(mostCurrent.activityBA,_formatnumberwithsuffix(_sale),(float) (_xbar+(_barwidth/(double)2)),(float) (_labelypos),anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE,(float) (10),anywheresoftware.b4a.keywords.Common.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
RDebugUtils.currentLine=1376357;
 //BA.debugLineNum = 1376357;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=1376358;
 //BA.debugLineNum = 1376358;BA.debugLine="Dim productLabelX As Int = alignLeftCenter + 50d";
_productlabelx = (int) (_alignleftcenter+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=1376359;
 //BA.debugLineNum = 1376359;BA.debugLine="cv.DrawText(product(i), xPos + productLabelX, pr";
_cv.DrawText(mostCurrent.activityBA,mostCurrent._product[_i],(float) (_xpos+_productlabelx),(float) (_productlabely),anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE,(float) (12),anywheresoftware.b4a.keywords.Common.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
RDebugUtils.currentLine=1376362;
 //BA.debugLineNum = 1376362;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=1376363;
 //BA.debugLineNum = 1376363;BA.debugLine="For i = 0 To numLabels";
{
final int step74 = 1;
final int limit74 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit74 ;_i = _i + step74 ) {
RDebugUtils.currentLine=1376364;
 //BA.debugLineNum = 1376364;BA.debugLine="Dim labelValue As Int = (maxSale / numLabels) *";
_labelvalue = (int) ((_maxsale/(double)_numlabels)*_i);
RDebugUtils.currentLine=1376365;
 //BA.debugLineNum = 1376365;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=1376367;
 //BA.debugLineNum = 1376367;BA.debugLine="cv.DrawText(FormatNumberWithSuffix(labelValue),";
_cv.DrawText(mostCurrent.activityBA,_formatnumberwithsuffix(_labelvalue),(float) (_alignleftcenter-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (35))),(float) (_labelypos+_aligntopcenter+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE,(float) (10),anywheresoftware.b4a.keywords.Common.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 }
};
RDebugUtils.currentLine=1376369;
 //BA.debugLineNum = 1376369;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="End Sub";
return "";
}
public static String  _formatnumberwithsuffix(int _number) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="End Sub";
return "";
}
public static int  _drawwrappedtextrotated(anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,String _text,int _x,int _y,int _maxwidth,float _fontsize,int _color,String _alignment,float _angle) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "drawwrappedtextrotated", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "drawwrappedtextrotated", new Object[] {_canvas,_text,_x,_y,_maxwidth,_fontsize,_color,_alignment,_angle}));}
String[] _words = null;
String _line = "";
int _lineheight = 0;
int _originaly = 0;
String _word = "";
String _testline = "";
int _textwidth = 0;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = anywheresoftware.b4a.keywords.Common.Regex.Split(" ",_text);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20));
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,anywheresoftware.b4a.keywords.Common.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=196620;
 //BA.debugLineNum = 196620;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(mostCurrent.activityBA,_line,(float) (_x),(float) (_y),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=196624;
 //BA.debugLineNum = 196624;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=196629;
 //BA.debugLineNum = 196629;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=196630;
 //BA.debugLineNum = 196630;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(mostCurrent.activityBA,_line,(float) (_x),(float) (_y),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=196631;
 //BA.debugLineNum = 196631;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=196635;
 //BA.debugLineNum = 196635;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=196636;
 //BA.debugLineNum = 196636;BA.debugLine="End Sub";
return 0;
}
}