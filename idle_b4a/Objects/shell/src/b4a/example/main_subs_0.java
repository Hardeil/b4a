package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,14);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 14;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="PE.Initialize(\"PE\")";
Debug.ShouldStop(16384);
main._pe.runVoidMethod ("Initialize",main.processBA,(Object)(RemoteObject.createImmutable("PE")));
 BA.debugLineNum = 16;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 17;BA.debugLine="LastActiveTime = DateTime.Now";
Debug.ShouldStop(65536);
main._lastactivetime = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");
 BA.debugLineNum = 19;BA.debugLine="TimerCheck.Initialize(\"TimerCheck\", 1000) ' Check";
Debug.ShouldStop(262144);
main._timercheck.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("TimerCheck")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 20;BA.debugLine="TimerCheck.Enabled = True";
Debug.ShouldStop(524288);
main._timercheck.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 23;BA.debugLine="vv.Initialize(\"vv\")";
Debug.ShouldStop(4194304);
main.mostCurrent._vv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("vv")));
 BA.debugLineNum = 24;BA.debugLine="Panel1.AddView(vv, 0dip, 0dip, Activity.Width, Pa";
Debug.ShouldStop(8388608);
main.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((main.mostCurrent._vv.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent._panel1.runMethod(true,"getHeight")));
 BA.debugLineNum = 27;BA.debugLine="If File.Exists(File.DirInternal, videoFile) = Fal";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._videofile)),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 28;BA.debugLine="File.Copy(File.DirAssets, videoFile, File.DirInt";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(main.mostCurrent._videofile),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._videofile));
 };
 BA.debugLineNum = 31;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(1073741824);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 32;BA.debugLine="vv.LoadVideo(File.DirInternal, videoFile)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._vv.runVoidMethod ("LoadVideo",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._videofile));
 BA.debugLineNum = 33;BA.debugLine="vv.MediaControllerEnabled = False";
Debug.ShouldStop(1);
main.mostCurrent._vv.runVoidMethod ("setMediaControllerEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("Activity_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_touch")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Touch (Action As Int, X As Float, Y A";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="LastActiveTime = DateTime.Now";
Debug.ShouldStop(4096);
main._lastactivetime = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");
 BA.debugLineNum = 46;BA.debugLine="Log(\"User is Active (Screen Touched)\")";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","122020098",RemoteObject.createImmutable("User is Active (Screen Touched)"),0);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim vv As VideoView";
main.mostCurrent._vv = RemoteObject.createNew ("anywheresoftware.b4a.audio.VideoViewWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Dim Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 11;BA.debugLine="Dim videoFile As String = \"backg.mp4\"";
main.mostCurrent._videofile = BA.ObjectToString("backg.mp4");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _pe_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("PE_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,37);
if (RapidSub.canDelegate("pe_keypress")) { return b4a.example.main.remoteMe.runUserSub(false, "main","pe_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 37;BA.debugLine="Sub PE_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="LastActiveTime = DateTime.Now";
Debug.ShouldStop(32);
main._lastactivetime = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");
 BA.debugLineNum = 39;BA.debugLine="Log(\"User is Active (Key Pressed)\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("LogImpl","121954562",RemoteObject.createImmutable("User is Active (Key Pressed)"),0);
 BA.debugLineNum = 40;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
xuiviewsutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
fileprovider.myClass = BA.getDeviceClass ("b4a.example.fileprovider");
animatedcounter.myClass = BA.getDeviceClass ("b4a.example.animatedcounter");
anotherprogressbar.myClass = BA.getDeviceClass ("b4a.example.anotherprogressbar");
b4xbreadcrumb.myClass = BA.getDeviceClass ("b4a.example.b4xbreadcrumb");
b4xcolortemplate.myClass = BA.getDeviceClass ("b4a.example.b4xcolortemplate");
b4xcombobox.myClass = BA.getDeviceClass ("b4a.example.b4xcombobox");
b4xdatetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xdatetemplate");
b4xdialog.myClass = BA.getDeviceClass ("b4a.example.b4xdialog");
b4xfloattextfield.myClass = BA.getDeviceClass ("b4a.example.b4xfloattextfield");
b4ximageview.myClass = BA.getDeviceClass ("b4a.example.b4ximageview");
b4xinputtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xinputtemplate");
b4xlisttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlisttemplate");
b4xloadingindicator.myClass = BA.getDeviceClass ("b4a.example.b4xloadingindicator");
b4xlongtexttemplate.myClass = BA.getDeviceClass ("b4a.example.b4xlongtexttemplate");
b4xplusminus.myClass = BA.getDeviceClass ("b4a.example.b4xplusminus");
b4xradiobutton.myClass = BA.getDeviceClass ("b4a.example.b4xradiobutton");
b4xsearchtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsearchtemplate");
b4xseekbar.myClass = BA.getDeviceClass ("b4a.example.b4xseekbar");
b4xsignaturetemplate.myClass = BA.getDeviceClass ("b4a.example.b4xsignaturetemplate");
b4xswitch.myClass = BA.getDeviceClass ("b4a.example.b4xswitch");
b4xtimedtemplate.myClass = BA.getDeviceClass ("b4a.example.b4xtimedtemplate");
madewithlove.myClass = BA.getDeviceClass ("b4a.example.madewithlove");
b4xformatter.myClass = BA.getDeviceClass ("b4a.example.b4xformatter");
roundslider.myClass = BA.getDeviceClass ("b4a.example.roundslider");
scrollinglabel.myClass = BA.getDeviceClass ("b4a.example.scrollinglabel");
swiftbutton.myClass = BA.getDeviceClass ("b4a.example.swiftbutton");
xuiviewsutils.myClass = BA.getDeviceClass ("b4a.example.xuiviewsutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Dim PE As PhoneEvents";
main._pe = RemoteObject.createNew ("anywheresoftware.b4a.phone.PhoneEvents");
 //BA.debugLineNum = 3;BA.debugLine="Dim LastActiveTime As Long";
main._lastactivetime = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 4;BA.debugLine="Dim IdleThreshold As Long = 7000 ' 7 seconds";
main._idlethreshold = BA.numberCast(long.class, 7000);
 //BA.debugLineNum = 5;BA.debugLine="Dim TimerCheck As Timer";
main._timercheck = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _timercheck_tick() throws Exception{
try {
		Debug.PushSubsStack("TimerCheck_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("timercheck_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","timercheck_tick");}
 BA.debugLineNum = 50;BA.debugLine="Sub TimerCheck_Tick";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="If (DateTime.Now - LastActiveTime) > IdleThreshol";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"),main._lastactivetime}, "-",1, 2)),main._idlethreshold)) { 
 BA.debugLineNum = 52;BA.debugLine="Log(\"Phone is Idle - Playing Video\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","122085634",RemoteObject.createImmutable("Phone is Idle - Playing Video"),0);
 BA.debugLineNum = 53;BA.debugLine="If vv.IsPlaying = False Then vv.Play ' Only play";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main.mostCurrent._vv.runMethod(true,"IsPlaying"),main.mostCurrent.__c.getField(true,"False"))) { 
main.mostCurrent._vv.runVoidMethod ("Play");};
 BA.debugLineNum = 54;BA.debugLine="vv.LoadVideo(File.DirInternal, videoFile)";
Debug.ShouldStop(2097152);
main.mostCurrent._vv.runVoidMethod ("LoadVideo",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(main.mostCurrent._videofile));
 BA.debugLineNum = 55;BA.debugLine="Panel1.Visible = True";
Debug.ShouldStop(4194304);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 57;BA.debugLine="Log(\"Phone is Active - Stopping Video\")";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("LogImpl","122085639",RemoteObject.createImmutable("Phone is Active - Stopping Video"),0);
 BA.debugLineNum = 58;BA.debugLine="If vv.IsPlaying Then vv.Stop";
Debug.ShouldStop(33554432);
if (main.mostCurrent._vv.runMethod(true,"IsPlaying").<Boolean>get().booleanValue()) { 
main.mostCurrent._vv.runVoidMethod ("Stop");};
 BA.debugLineNum = 59;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(67108864);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _vv_complete() throws Exception{
try {
		Debug.PushSubsStack("vv_Complete (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,65);
if (RapidSub.canDelegate("vv_complete")) { return b4a.example.main.remoteMe.runUserSub(false, "main","vv_complete");}
 BA.debugLineNum = 65;BA.debugLine="Sub vv_Complete";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="Log(\"Video Complete - Restarting\")";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("LogImpl","1196609",RemoteObject.createImmutable("Video Complete - Restarting"),0);
 BA.debugLineNum = 67;BA.debugLine="If vv.IsPlaying = False Then vv.Play ' Ensures th";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent._vv.runMethod(true,"IsPlaying"),main.mostCurrent.__c.getField(true,"False"))) { 
main.mostCurrent._vv.runVoidMethod ("Play");};
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}