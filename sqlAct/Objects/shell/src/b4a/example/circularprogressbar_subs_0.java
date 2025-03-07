package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class circularprogressbar_subs_0 {


public static void  _animatevalueto(RemoteObject __ref,RemoteObject _newvalue) throws Exception{
try {
		Debug.PushSubsStack("AnimateValueTo (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,66);
if (RapidSub.canDelegate("animatevalueto")) { __ref.runUserSub(false, "circularprogressbar","animatevalueto", __ref, _newvalue); return;}
ResumableSub_AnimateValueTo rsub = new ResumableSub_AnimateValueTo(null,__ref,_newvalue);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_AnimateValueTo extends BA.ResumableSub {
public ResumableSub_AnimateValueTo(b4a.example.circularprogressbar parent,RemoteObject __ref,RemoteObject _newvalue) {
this.parent = parent;
this.__ref = __ref;
this._newvalue = _newvalue;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
b4a.example.circularprogressbar parent;
RemoteObject _newvalue;
RemoteObject _n = RemoteObject.createImmutable(0L);
RemoteObject _duration = RemoteObject.createImmutable(0);
RemoteObject _start = RemoteObject.createImmutable(0f);
RemoteObject _tempvalue = RemoteObject.createImmutable(0f);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("AnimateValueTo (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,66);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
Debug.locals.put("NewValue", _newvalue);
 BA.debugLineNum = 67;BA.debugLine="Dim n As Long = DateTime.Now";
Debug.ShouldStop(4);
_n = parent.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("n", _n);Debug.locals.put("n", _n);
 BA.debugLineNum = 68;BA.debugLine="Dim duration As Int = Abs(currentValue - NewValue";
Debug.ShouldStop(8);
_duration = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.__c.runMethod(true,"Abs",(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_currentvalue" /*RemoteObject*/ ),_newvalue}, "-",1, 0))),RemoteObject.createImmutable(100),__ref.getField(true,"_durationfromzeroto100" /*RemoteObject*/ ),RemoteObject.createImmutable(1000)}, "/*+",1, 0));Debug.locals.put("duration", _duration);Debug.locals.put("duration", _duration);
 BA.debugLineNum = 69;BA.debugLine="Dim start As Float = currentValue";
Debug.ShouldStop(16);
_start = __ref.getField(true,"_currentvalue" /*RemoteObject*/ );Debug.locals.put("start", _start);Debug.locals.put("start", _start);
 BA.debugLineNum = 70;BA.debugLine="currentValue = NewValue";
Debug.ShouldStop(32);
__ref.setField ("_currentvalue" /*RemoteObject*/ ,_newvalue);
 BA.debugLineNum = 71;BA.debugLine="Dim tempValue As Float";
Debug.ShouldStop(64);
_tempvalue = RemoteObject.createImmutable(0f);Debug.locals.put("tempValue", _tempvalue);
 BA.debugLineNum = 72;BA.debugLine="Do While DateTime.Now < n + duration";
Debug.ShouldStop(128);
if (true) break;

case 1:
//do while
this.state = 10;
while (RemoteObject.solveBoolean("<",parent.__c.getField(false,"DateTime").runMethod(true,"getNow"),RemoteObject.solve(new RemoteObject[] {_n,_duration}, "+",1, 2))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 73;BA.debugLine="tempValue = ValueFromTimeEaseInOut(DateTime.Now";
Debug.ShouldStop(256);
_tempvalue = __ref.runClassMethod (b4a.example.circularprogressbar.class, "_valuefromtimeeaseinout" /*RemoteObject*/ ,(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {parent.__c.getField(false,"DateTime").runMethod(true,"getNow"),_n}, "-",1, 2))),(Object)(_start),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_newvalue,_start}, "-",1, 0))),(Object)(_duration));Debug.locals.put("tempValue", _tempvalue);
 BA.debugLineNum = 74;BA.debugLine="DrawValue(tempValue)";
Debug.ShouldStop(512);
__ref.runClassMethod (b4a.example.circularprogressbar.class, "_drawvalue" /*RemoteObject*/ ,(Object)(_tempvalue));
 BA.debugLineNum = 75;BA.debugLine="Sleep(10)";
Debug.ShouldStop(1024);
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "circularprogressbar", "animatevalueto"),BA.numberCast(int.class, 10));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
 BA.debugLineNum = 76;BA.debugLine="If NewValue <> currentValue Then Return 'will ha";
Debug.ShouldStop(2048);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("!",_newvalue,BA.numberCast(double.class, __ref.getField(true,"_currentvalue" /*RemoteObject*/ )))) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
if (true) return ;
if (true) break;

case 9:
//C
this.state = 1;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
 BA.debugLineNum = 78;BA.debugLine="DrawValue(currentValue)";
Debug.ShouldStop(8192);
__ref.runClassMethod (b4a.example.circularprogressbar.class, "_drawvalue" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_currentvalue" /*RemoteObject*/ )));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _base_resize(RemoteObject __ref,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Base_Resize (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,48);
if (RapidSub.canDelegate("base_resize")) { return __ref.runUserSub(false, "circularprogressbar","base_resize", __ref, _width, _height);}
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 48;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="cx = Width / 2";
Debug.ShouldStop(65536);
__ref.setField ("_cx" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_width,RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 50;BA.debugLine="cy = Height / 2";
Debug.ShouldStop(131072);
__ref.setField ("_cy" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_height,RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 51;BA.debugLine="radius = cx - 10dip";
Debug.ShouldStop(262144);
__ref.setField ("_radius" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_cx" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 0)));
 BA.debugLineNum = 52;BA.debugLine="mBase.SetLayoutAnimated(0, mBase.Left, mBase.Top,";
Debug.ShouldStop(524288);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getLeft")),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getTop")),(Object)(BA.numberCast(int.class, circularprogressbar.__c.runMethod(true,"Min",(Object)(_width),(Object)(_height)))),(Object)(BA.numberCast(int.class, circularprogressbar.__c.runMethod(true,"Min",(Object)(_width),(Object)(_height)))));
 BA.debugLineNum = 53;BA.debugLine="cvs.Resize(Width, Height)";
Debug.ShouldStop(1048576);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Resize",(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, _height)));
 BA.debugLineNum = 54;BA.debugLine="mLbl.SetLayoutAnimated(0, 0, cy - 20dip, Width, 4";
Debug.ShouldStop(2097152);
__ref.getField(false,"_mlbl" /*RemoteObject*/ ).runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_cy" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 0))),(Object)(BA.numberCast(int.class, _width)),(Object)(circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 55;BA.debugLine="DrawValue(currentValue)";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4a.example.circularprogressbar.class, "_drawvalue" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_currentvalue" /*RemoteObject*/ )));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private mEventName As String 'ignore";
circularprogressbar._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",circularprogressbar._meventname);
 //BA.debugLineNum = 10;BA.debugLine="Private mCallBack As Object 'ignore";
circularprogressbar._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",circularprogressbar._mcallback);
 //BA.debugLineNum = 11;BA.debugLine="Private cvs As B4XCanvas";
circularprogressbar._cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");__ref.setField("_cvs",circularprogressbar._cvs);
 //BA.debugLineNum = 12;BA.debugLine="Private xui As XUI";
circularprogressbar._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");__ref.setField("_xui",circularprogressbar._xui);
 //BA.debugLineNum = 13;BA.debugLine="Private mLbl As B4XView";
circularprogressbar._mlbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_mlbl",circularprogressbar._mlbl);
 //BA.debugLineNum = 14;BA.debugLine="Private cx, cy, radius As Float";
circularprogressbar._cx = RemoteObject.createImmutable(0f);__ref.setField("_cx",circularprogressbar._cx);
circularprogressbar._cy = RemoteObject.createImmutable(0f);__ref.setField("_cy",circularprogressbar._cy);
circularprogressbar._radius = RemoteObject.createImmutable(0f);__ref.setField("_radius",circularprogressbar._radius);
 //BA.debugLineNum = 15;BA.debugLine="Private stroke As Float";
circularprogressbar._stroke = RemoteObject.createImmutable(0f);__ref.setField("_stroke",circularprogressbar._stroke);
 //BA.debugLineNum = 16;BA.debugLine="Private clrFull, clrEmpty As Int";
circularprogressbar._clrfull = RemoteObject.createImmutable(0);__ref.setField("_clrfull",circularprogressbar._clrfull);
circularprogressbar._clrempty = RemoteObject.createImmutable(0);__ref.setField("_clrempty",circularprogressbar._clrempty);
 //BA.debugLineNum = 17;BA.debugLine="Private mBase As B4XView";
circularprogressbar._mbase = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_mbase",circularprogressbar._mbase);
 //BA.debugLineNum = 18;BA.debugLine="Private currentValue As Float";
circularprogressbar._currentvalue = RemoteObject.createImmutable(0f);__ref.setField("_currentvalue",circularprogressbar._currentvalue);
 //BA.debugLineNum = 19;BA.debugLine="Private DurationFromZeroTo100 As Int";
circularprogressbar._durationfromzeroto100 = RemoteObject.createImmutable(0);__ref.setField("_durationfromzeroto100",circularprogressbar._durationfromzeroto100);
 //BA.debugLineNum = 20;BA.debugLine="Public totalValue As Float";
circularprogressbar._totalvalue = RemoteObject.createImmutable(0f);__ref.setField("_totalvalue",circularprogressbar._totalvalue);
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _designercreateview(RemoteObject __ref,RemoteObject _base,RemoteObject _lbl,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("DesignerCreateView (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,28);
if (RapidSub.canDelegate("designercreateview")) { return __ref.runUserSub(false, "circularprogressbar","designercreateview", __ref, _base, _lbl, _props);}
Debug.locals.put("Base", _base);
Debug.locals.put("Lbl", _lbl);
Debug.locals.put("Props", _props);
 BA.debugLineNum = 28;BA.debugLine="Private Sub DesignerCreateView (Base As Object, Lb";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="mBase = Base";
Debug.ShouldStop(268435456);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).setObject (_base);
 BA.debugLineNum = 30;BA.debugLine="mBase.SetLayoutAnimated(0, mBase.Left, mBase.Top,";
Debug.ShouldStop(536870912);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getLeft")),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getTop")),(Object)(BA.numberCast(int.class, circularprogressbar.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")))))),(Object)(BA.numberCast(int.class, circularprogressbar.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight")))))));
 BA.debugLineNum = 31;BA.debugLine="clrFull = xui.PaintOrColorToColor(Colors.ARGB(255";
Debug.ShouldStop(1073741824);
__ref.setField ("_clrfull" /*RemoteObject*/ ,__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(true,"PaintOrColorToColor",(Object)((circularprogressbar.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 64)),(Object)(BA.numberCast(int.class, 34)))))));
 BA.debugLineNum = 32;BA.debugLine="clrEmpty = xui.PaintOrColorToColor(Colors.ARGB(25";
Debug.ShouldStop(-2147483648);
__ref.setField ("_clrempty" /*RemoteObject*/ ,__ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(true,"PaintOrColorToColor",(Object)((circularprogressbar.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 242)),(Object)(BA.numberCast(int.class, 178)))))));
 BA.debugLineNum = 33;BA.debugLine="stroke = DipToCurrent(Props.Get(\"StrokeWidth\")) '";
Debug.ShouldStop(1);
__ref.setField ("_stroke" /*RemoteObject*/ ,BA.numberCast(float.class, circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, _props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("StrokeWidth")))))))));
 BA.debugLineNum = 35;BA.debugLine="stroke = 20dip  ' Set to 20dip dynamically";
Debug.ShouldStop(4);
__ref.setField ("_stroke" /*RemoteObject*/ ,BA.numberCast(float.class, circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 36;BA.debugLine="DurationFromZeroTo100 = Props.Get(\"Duration\")";
Debug.ShouldStop(8);
__ref.setField ("_durationfromzeroto100" /*RemoteObject*/ ,BA.numberCast(int.class, _props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("Duration"))))));
 BA.debugLineNum = 37;BA.debugLine="mLbl = Lbl";
Debug.ShouldStop(16);
__ref.getField(false,"_mlbl" /*RemoteObject*/ ).setObject (_lbl.getObject());
 BA.debugLineNum = 38;BA.debugLine="cx = mBase.Width / 2";
Debug.ShouldStop(32);
__ref.setField ("_cx" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 39;BA.debugLine="cy = mBase.Height / 2";
Debug.ShouldStop(64);
__ref.setField ("_cy" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 40;BA.debugLine="radius = cx - 10dip";
Debug.ShouldStop(128);
__ref.setField ("_radius" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_cx" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 0)));
 BA.debugLineNum = 41;BA.debugLine="cvs.Initialize(mBase)";
Debug.ShouldStop(256);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ )));
 BA.debugLineNum = 42;BA.debugLine="mLbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
Debug.ShouldStop(512);
__ref.getField(false,"_mlbl" /*RemoteObject*/ ).runVoidMethod ("SetTextAlignment",(Object)(BA.ObjectToString("CENTER")),(Object)(RemoteObject.createImmutable("CENTER")));
 BA.debugLineNum = 43;BA.debugLine="mBase.AddView(mLbl, 0, cy - 20dip, mBase.Width, 4";
Debug.ShouldStop(1024);
__ref.getField(false,"_mbase" /*RemoteObject*/ ).runVoidMethod ("AddView",(Object)((__ref.getField(false,"_mlbl" /*RemoteObject*/ ).getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_cy" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 0))),(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ ).runMethod(true,"getWidth")),(Object)(circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 44;BA.debugLine="cvs.Initialize(mBase)";
Debug.ShouldStop(2048);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_mbase" /*RemoteObject*/ )));
 BA.debugLineNum = 45;BA.debugLine="DrawValue(currentValue)";
Debug.ShouldStop(4096);
__ref.runClassMethod (b4a.example.circularprogressbar.class, "_drawvalue" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_currentvalue" /*RemoteObject*/ )));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawvalue(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("DrawValue (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,92);
if (RapidSub.canDelegate("drawvalue")) { return __ref.runUserSub(false, "circularprogressbar","drawvalue", __ref, _value);}
RemoteObject _startangle = RemoteObject.createImmutable(0f);
RemoteObject _sweepangle = RemoteObject.createImmutable(0f);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
Debug.locals.put("Value", _value);
 BA.debugLineNum = 92;BA.debugLine="Private Sub DrawValue(Value As Float)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
Debug.ShouldStop(268435456);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("ClearRect",(Object)(__ref.getField(false,"_cvs" /*RemoteObject*/ ).runMethod(false,"getTargetRect")));
 BA.debugLineNum = 94;BA.debugLine="cvs.DrawCircle(cx, cy, radius, clrEmpty, False, s";
Debug.ShouldStop(536870912);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(true,"_cx" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_cy" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_radius" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_clrempty" /*RemoteObject*/ )),(Object)(circularprogressbar.__c.getField(true,"False")),(Object)(__ref.getField(true,"_stroke" /*RemoteObject*/ )));
 BA.debugLineNum = 95;BA.debugLine="mLbl.Text = $\"$1.0{Value}\"$";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_mlbl" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable(""),circularprogressbar.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("1.0")),(Object)((_value))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 96;BA.debugLine="Dim startAngle = -90, sweepAngle = Value / (total";
Debug.ShouldStop(-2147483648);
_startangle = BA.numberCast(float.class, -(double) (0 + 90));Debug.locals.put("startAngle", _startangle);Debug.locals.put("startAngle", _startangle);
_sweepangle = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_value,(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_totalvalue" /*RemoteObject*/ ),RemoteObject.createImmutable(.01)}, "+",1, 0)),RemoteObject.createImmutable(360)}, "/*",0, 0));Debug.locals.put("sweepAngle", _sweepangle);Debug.locals.put("sweepAngle", _sweepangle);
 BA.debugLineNum = 97;BA.debugLine="If Value < 100 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("<",_value,BA.numberCast(double.class, 100))) { 
 BA.debugLineNum = 98;BA.debugLine="Dim p As B4XPath";
Debug.ShouldStop(2);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("p", _p);
 BA.debugLineNum = 99;BA.debugLine="p.InitializeArc(cx, cy, radius + stroke + 1dip,";
Debug.ShouldStop(4);
_p.runVoidMethod ("InitializeArc",(Object)(__ref.getField(true,"_cx" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_cy" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_radius" /*RemoteObject*/ ),__ref.getField(true,"_stroke" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "++",2, 0))),(Object)(_startangle),(Object)(_sweepangle));
 BA.debugLineNum = 100;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(8);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("ClipPath",(Object)(_p));
 BA.debugLineNum = 101;BA.debugLine="cvs.DrawCircle(cx, cy, radius - 0.5dip, clrFull,";
Debug.ShouldStop(16);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(true,"_cx" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_cy" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_radius" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0.5)))}, "-",1, 0))),(Object)(__ref.getField(true,"_clrfull" /*RemoteObject*/ )),(Object)(circularprogressbar.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_stroke" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 0))));
 BA.debugLineNum = 102;BA.debugLine="cvs.RemoveClip";
Debug.ShouldStop(32);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("RemoveClip");
 }else {
 BA.debugLineNum = 104;BA.debugLine="cvs.DrawCircle(cx, cy, radius - 0.5dip, clrFull,";
Debug.ShouldStop(128);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("DrawCircle",(Object)(__ref.getField(true,"_cx" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_cy" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_radius" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0.5)))}, "-",1, 0))),(Object)(__ref.getField(true,"_clrfull" /*RemoteObject*/ )),(Object)(circularprogressbar.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_stroke" /*RemoteObject*/ ),circularprogressbar.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 0))));
 };
 BA.debugLineNum = 106;BA.debugLine="cvs.Invalidate";
Debug.ShouldStop(512);
__ref.getField(false,"_cvs" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getvalue(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getValue (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("getvalue")) { return __ref.runUserSub(false, "circularprogressbar","getvalue", __ref);}
 BA.debugLineNum = 62;BA.debugLine="Public Sub getValue As Float";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Return currentValue";
Debug.ShouldStop(1073741824);
if (true) return __ref.getField(true,"_currentvalue" /*RemoteObject*/ );
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,23);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "circularprogressbar","initialize", __ref, _ba, _callback, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 23;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 24;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(8388608);
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 25;BA.debugLine="mCallBack = Callback";
Debug.ShouldStop(16777216);
__ref.setField ("_mcallback" /*RemoteObject*/ ,_callback);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setvalue(RemoteObject __ref,RemoteObject _newvalue) throws Exception{
try {
		Debug.PushSubsStack("setValue (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,58);
if (RapidSub.canDelegate("setvalue")) { return __ref.runUserSub(false, "circularprogressbar","setvalue", __ref, _newvalue);}
Debug.locals.put("NewValue", _newvalue);
 BA.debugLineNum = 58;BA.debugLine="Public Sub setValue(NewValue As Float)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="AnimateValueTo(NewValue)";
Debug.ShouldStop(67108864);
__ref.runClassMethod (b4a.example.circularprogressbar.class, "_animatevalueto" /*void*/ ,(Object)(_newvalue));
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
public static RemoteObject  _valuefromtimeeaseinout(RemoteObject __ref,RemoteObject _time,RemoteObject _start,RemoteObject _changeinvalue,RemoteObject _duration) throws Exception{
try {
		Debug.PushSubsStack("ValueFromTimeEaseInOut (circularprogressbar) ","circularprogressbar",3,__ref.getField(false, "ba"),__ref,82);
if (RapidSub.canDelegate("valuefromtimeeaseinout")) { return __ref.runUserSub(false, "circularprogressbar","valuefromtimeeaseinout", __ref, _time, _start, _changeinvalue, _duration);}
Debug.locals.put("Time", _time);
Debug.locals.put("Start", _start);
Debug.locals.put("ChangeInValue", _changeinvalue);
Debug.locals.put("Duration", _duration);
 BA.debugLineNum = 82;BA.debugLine="Private Sub ValueFromTimeEaseInOut(Time As Float,";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="Time = Time / (Duration / 2)";
Debug.ShouldStop(262144);
_time = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_time,(RemoteObject.solve(new RemoteObject[] {_duration,RemoteObject.createImmutable(2)}, "/",0, 0))}, "/",0, 0));Debug.locals.put("Time", _time);
 BA.debugLineNum = 84;BA.debugLine="If Time < 1 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("<",_time,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 85;BA.debugLine="Return ChangeInValue / 2 * Time * Time * Time *";
Debug.ShouldStop(1048576);
if (true) return BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_changeinvalue,RemoteObject.createImmutable(2),_time,_time,_time,_time,_start}, "/****+",1, 0));
 }else {
 BA.debugLineNum = 87;BA.debugLine="Time = Time - 2";
Debug.ShouldStop(4194304);
_time = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_time,RemoteObject.createImmutable(2)}, "-",1, 0));Debug.locals.put("Time", _time);
 BA.debugLineNum = 88;BA.debugLine="Return -ChangeInValue / 2 * (Time * Time * Time";
Debug.ShouldStop(8388608);
if (true) return BA.numberCast(float.class, -(double) (0 + _changeinvalue.<Float>get().floatValue())/(double)(double) (0 + 2)*(RemoteObject.solve(new RemoteObject[] {_time,_time,_time,_time,RemoteObject.createImmutable(2)}, "***-",1, 0)).<Double>get().doubleValue()+(double) (0 + _start.<Float>get().floatValue()));
 };
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}