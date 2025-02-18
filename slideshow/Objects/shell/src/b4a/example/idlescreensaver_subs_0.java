package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class idlescreensaver_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private mTimer As Timer";
idlescreensaver._mtimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");__ref.setField("_mtimer",idlescreensaver._mtimer);
 //BA.debugLineNum = 3;BA.debugLine="Private mTimeTimer As Timer ' Timer for updating";
idlescreensaver._mtimetimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");__ref.setField("_mtimetimer",idlescreensaver._mtimetimer);
 //BA.debugLineNum = 4;BA.debugLine="Private mPanel As Panel";
idlescreensaver._mpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_mpanel",idlescreensaver._mpanel);
 //BA.debugLineNum = 5;BA.debugLine="Private mImages As List";
idlescreensaver._mimages = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_mimages",idlescreensaver._mimages);
 //BA.debugLineNum = 6;BA.debugLine="Private mLabel As Label";
idlescreensaver._mlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_mlabel",idlescreensaver._mlabel);
 //BA.debugLineNum = 7;BA.debugLine="Private mCurrentIndex As Int = 0";
idlescreensaver._mcurrentindex = BA.numberCast(int.class, 0);__ref.setField("_mcurrentindex",idlescreensaver._mcurrentindex);
 //BA.debugLineNum = 8;BA.debugLine="Public mInterval As Int = 5000 ' Default: 5 secon";
idlescreensaver._minterval = BA.numberCast(int.class, 5000);__ref.setField("_minterval",idlescreensaver._minterval);
 //BA.debugLineNum = 9;BA.debugLine="Private mIsVisible As Boolean = False";
idlescreensaver._misvisible = idlescreensaver.__c.getField(true,"False");__ref.setField("_misvisible",idlescreensaver._misvisible);
 //BA.debugLineNum = 10;BA.debugLine="Private mElapsedTime As Int = 0 ' Track elapsed t";
idlescreensaver._melapsedtime = BA.numberCast(int.class, 0);__ref.setField("_melapsedtime",idlescreensaver._melapsedtime);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _activity,RemoteObject _insterval) throws Exception{
try {
		Debug.PushSubsStack("Initialize (idlescreensaver) ","idlescreensaver",2,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "idlescreensaver","initialize", __ref, _ba, _activity, _insterval);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Activity", _activity);
Debug.locals.put("insterval", _insterval);
 BA.debugLineNum = 13;BA.debugLine="Public Sub Initialize(Activity As Activity,insterv";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="mTimer.Initialize(\"timer\",10000)";
Debug.ShouldStop(8192);
__ref.getField(false,"_mtimer" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("timer")),(Object)(BA.numberCast(long.class, 10000)));
 BA.debugLineNum = 15;BA.debugLine="mTimer.Interval = insterval";
Debug.ShouldStop(16384);
__ref.getField(false,"_mtimer" /*RemoteObject*/ ).runMethod(true,"setInterval",BA.numberCast(long.class, _insterval));
 BA.debugLineNum = 16;BA.debugLine="mTimer.Enabled = True";
Debug.ShouldStop(32768);
__ref.getField(false,"_mtimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"True"));
 BA.debugLineNum = 18;BA.debugLine="mPanel.Initialize(\"\")";
Debug.ShouldStop(131072);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 19;BA.debugLine="mPanel.Color = Colors.Black";
Debug.ShouldStop(262144);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runVoidMethod ("setColor",idlescreensaver.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 20;BA.debugLine="Activity.AddView(mPanel, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(524288);
_activity.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mpanel" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(idlescreensaver.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))),(Object)(idlescreensaver.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 22;BA.debugLine="mLabel.Initialize(\"\")";
Debug.ShouldStop(2097152);
__ref.getField(false,"_mlabel" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 23;BA.debugLine="mLabel.TextSize = 6%y";
Debug.ShouldStop(4194304);
__ref.getField(false,"_mlabel" /*RemoteObject*/ ).runMethod(true,"setTextSize",BA.numberCast(float.class, idlescreensaver.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 24;BA.debugLine="mLabel.TextColor = Colors.White";
Debug.ShouldStop(8388608);
__ref.getField(false,"_mlabel" /*RemoteObject*/ ).runMethod(true,"setTextColor",idlescreensaver.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 25;BA.debugLine="mLabel.Typeface = Typeface.SERIF";
Debug.ShouldStop(16777216);
__ref.getField(false,"_mlabel" /*RemoteObject*/ ).runMethod(false,"setTypeface",idlescreensaver.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 26;BA.debugLine="mLabel.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(33554432);
__ref.getField(false,"_mlabel" /*RemoteObject*/ ).runMethod(false,"setTypeface",idlescreensaver.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 27;BA.debugLine="mLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(67108864);
__ref.getField(false,"_mlabel" /*RemoteObject*/ ).runMethod(true,"setGravity",idlescreensaver.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 28;BA.debugLine="mPanel.AddView(mLabel, 0, 0, 100%x, 30%y) ' Set w";
Debug.ShouldStop(134217728);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mlabel" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(idlescreensaver.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))),(Object)(idlescreensaver.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 30)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 31;BA.debugLine="mImages.Initialize";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_mimages" /*RemoteObject*/ ).runVoidMethod ("Initialize");
 BA.debugLineNum = 32;BA.debugLine="mImages.Add(\"cyduck.jpg\")";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_mimages" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("cyduck.jpg"))));
 BA.debugLineNum = 33;BA.debugLine="mImages.Add(\"pokemon.png\")";
Debug.ShouldStop(1);
__ref.getField(false,"_mimages" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("pokemon.png"))));
 BA.debugLineNum = 34;BA.debugLine="mImages.Add(\"profile.jpg\")";
Debug.ShouldStop(2);
__ref.getField(false,"_mimages" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((RemoteObject.createImmutable("profile.jpg"))));
 BA.debugLineNum = 36;BA.debugLine="mTimeTimer.Initialize(\"TimeTick\", 1000)";
Debug.ShouldStop(8);
__ref.getField(false,"_mtimetimer" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("TimeTick")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 37;BA.debugLine="mTimeTimer.Interval = mInterval";
Debug.ShouldStop(16);
__ref.getField(false,"_mtimetimer" /*RemoteObject*/ ).runMethod(true,"setInterval",BA.numberCast(long.class, __ref.getField(true,"_minterval" /*RemoteObject*/ )));
 BA.debugLineNum = 38;BA.debugLine="mTimeTimer.Enabled = True";
Debug.ShouldStop(32);
__ref.getField(false,"_mtimetimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"True"));
 BA.debugLineNum = 40;BA.debugLine="mPanel.Visible = False";
Debug.ShouldStop(128);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runMethod(true,"setVisible",idlescreensaver.__c.getField(true,"False"));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _shownextimage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ShowNextImage (idlescreensaver) ","idlescreensaver",2,__ref.getField(false, "ba"),__ref,43);
if (RapidSub.canDelegate("shownextimage")) { return __ref.runUserSub(false, "idlescreensaver","shownextimage", __ref);}
RemoteObject _img = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
int _i = 0;
 BA.debugLineNum = 43;BA.debugLine="Private Sub ShowNextImage";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="If mImages.Size = 0 Then Return";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_mimages" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 46;BA.debugLine="Dim img As ImageView";
Debug.ShouldStop(8192);
_img = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("img", _img);
 BA.debugLineNum = 47;BA.debugLine="img.Initialize(\"\")";
Debug.ShouldStop(16384);
_img.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 48;BA.debugLine="img.Gravity = Gravity.FILL";
Debug.ShouldStop(32768);
_img.runMethod(true,"setGravity",idlescreensaver.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 49;BA.debugLine="img.Bitmap = LoadBitmap(File.DirAssets, mImages.G";
Debug.ShouldStop(65536);
_img.runMethod(false,"setBitmap",(idlescreensaver.__c.runMethod(false,"LoadBitmap",(Object)(idlescreensaver.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString(__ref.getField(false,"_mimages" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(__ref.getField(true,"_mcurrentindex" /*RemoteObject*/ )))))).getObject()));
 BA.debugLineNum = 52;BA.debugLine="For i = mPanel.NumberOfViews - 1 To 0 Step -1";
Debug.ShouldStop(524288);
{
final int step6 = -1;
final int limit6 = 0;
_i = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="If mPanel.GetView(i) Is ImageView Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("i",__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))).getObjectOrNull(), RemoteObject.createImmutable("android.widget.ImageView"))) { 
 BA.debugLineNum = 54;BA.debugLine="mPanel.RemoveViewAt(i)";
Debug.ShouldStop(2097152);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 58;BA.debugLine="mPanel.AddView(img, 0, 30%y, 100%x, 70%y)";
Debug.ShouldStop(33554432);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((_img.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(idlescreensaver.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 30)),__ref.getField(false, "ba"))),(Object)(idlescreensaver.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),__ref.getField(false, "ba"))),(Object)(idlescreensaver.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 70)),__ref.getField(false, "ba"))));
 BA.debugLineNum = 59;BA.debugLine="mCurrentIndex = (mCurrentIndex + 1) Mod mImages.S";
Debug.ShouldStop(67108864);
__ref.setField ("_mcurrentindex" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_mcurrentindex" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1)),__ref.getField(false,"_mimages" /*RemoteObject*/ ).runMethod(true,"getSize")}, "%",0, 1));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showscreensaver(RemoteObject __ref,RemoteObject _show) throws Exception{
try {
		Debug.PushSubsStack("ShowScreenSaver (idlescreensaver) ","idlescreensaver",2,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("showscreensaver")) { return __ref.runUserSub(false, "idlescreensaver","showscreensaver", __ref, _show);}
Debug.locals.put("Show", _show);
 BA.debugLineNum = 62;BA.debugLine="Public Sub ShowScreenSaver(Show As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="If Show Then";
Debug.ShouldStop(1073741824);
if (_show.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 64;BA.debugLine="If mImages.Size <= 0 Then Return";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("k",__ref.getField(false,"_mimages" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 65;BA.debugLine="mPanel.Visible = True";
Debug.ShouldStop(1);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runMethod(true,"setVisible",idlescreensaver.__c.getField(true,"True"));
 BA.debugLineNum = 66;BA.debugLine="mIsVisible = True";
Debug.ShouldStop(2);
__ref.setField ("_misvisible" /*RemoteObject*/ ,idlescreensaver.__c.getField(true,"True"));
 BA.debugLineNum = 67;BA.debugLine="ShowNextImage";
Debug.ShouldStop(4);
__ref.runClassMethod (b4a.example.idlescreensaver.class, "_shownextimage" /*RemoteObject*/ );
 BA.debugLineNum = 68;BA.debugLine="mTimer.Enabled = False";
Debug.ShouldStop(8);
__ref.getField(false,"_mtimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"False"));
 BA.debugLineNum = 69;BA.debugLine="mTimeTimer.Enabled = True ' Start time update";
Debug.ShouldStop(16);
__ref.getField(false,"_mtimetimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 71;BA.debugLine="mTimer.Enabled = True";
Debug.ShouldStop(64);
__ref.getField(false,"_mtimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"True"));
 BA.debugLineNum = 72;BA.debugLine="mTimeTimer.Enabled = False ' Stop time update";
Debug.ShouldStop(128);
__ref.getField(false,"_mtimetimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"False"));
 BA.debugLineNum = 73;BA.debugLine="mPanel.Visible = False";
Debug.ShouldStop(256);
__ref.getField(false,"_mpanel" /*RemoteObject*/ ).runMethod(true,"setVisible",idlescreensaver.__c.getField(true,"False"));
 BA.debugLineNum = 74;BA.debugLine="mIsVisible = False";
Debug.ShouldStop(512);
__ref.setField ("_misvisible" /*RemoteObject*/ ,idlescreensaver.__c.getField(true,"False"));
 };
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer_tick(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("timer_tick (idlescreensaver) ","idlescreensaver",2,__ref.getField(false, "ba"),__ref,87);
if (RapidSub.canDelegate("timer_tick")) { return __ref.runUserSub(false, "idlescreensaver","timer_tick", __ref);}
 BA.debugLineNum = 87;BA.debugLine="Sub timer_tick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="ShowScreenSaver(True)";
Debug.ShouldStop(8388608);
__ref.runClassMethod (b4a.example.idlescreensaver.class, "_showscreensaver" /*RemoteObject*/ ,(Object)(idlescreensaver.__c.getField(true,"True")));
 BA.debugLineNum = 89;BA.debugLine="mTimer.Enabled = False";
Debug.ShouldStop(16777216);
__ref.getField(false,"_mtimer" /*RemoteObject*/ ).runMethod(true,"setEnabled",idlescreensaver.__c.getField(true,"False"));
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timetick_tick(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("TimeTick_Tick (idlescreensaver) ","idlescreensaver",2,__ref.getField(false, "ba"),__ref,77);
if (RapidSub.canDelegate("timetick_tick")) { return __ref.runUserSub(false, "idlescreensaver","timetick_tick", __ref);}
 BA.debugLineNum = 77;BA.debugLine="Private Sub TimeTick_Tick";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="mElapsedTime = mElapsedTime + 1";
Debug.ShouldStop(8192);
__ref.setField ("_melapsedtime" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_melapsedtime" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 80;BA.debugLine="If mElapsedTime >= 10 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("g",__ref.getField(true,"_melapsedtime" /*RemoteObject*/ ),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 81;BA.debugLine="ShowScreenSaver(True)";
Debug.ShouldStop(65536);
__ref.runClassMethod (b4a.example.idlescreensaver.class, "_showscreensaver" /*RemoteObject*/ ,(Object)(idlescreensaver.__c.getField(true,"True")));
 BA.debugLineNum = 82;BA.debugLine="mElapsedTime = 0";
Debug.ShouldStop(131072);
__ref.setField ("_melapsedtime" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 85;BA.debugLine="If mIsVisible Then ShowNextImage";
Debug.ShouldStop(1048576);
if (__ref.getField(true,"_misvisible" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
__ref.runClassMethod (b4a.example.idlescreensaver.class, "_shownextimage" /*RemoteObject*/ );};
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}