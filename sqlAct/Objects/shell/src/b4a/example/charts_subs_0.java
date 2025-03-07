package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class charts_subs_0 {


public static RemoteObject  _addbarcolor(RemoteObject _ba,RemoteObject _bd,RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("AddBarColor (charts) ","charts",2,_ba,charts.mostCurrent,34);
if (RapidSub.canDelegate("addbarcolor")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","addbarcolor", _ba, _bd, _color);}
;
Debug.locals.put("BD", _bd);
Debug.locals.put("Color", _color);
 BA.debugLineNum = 34;BA.debugLine="Sub AddBarColor(BD As BarData, Color As Int)";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="If BD.BarsColors.IsInitialized = False Then BD.Ba";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_bd.getField(false,"BarsColors" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),charts.mostCurrent.__c.getField(true,"False"))) { 
_bd.getField(false,"BarsColors" /*RemoteObject*/ ).runVoidMethod ("Initialize");};
 BA.debugLineNum = 36;BA.debugLine="BD.BarsColors.Add(Color)";
Debug.ShouldStop(8);
_bd.getField(false,"BarsColors" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_color)));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addbarpoint(RemoteObject _ba,RemoteObject _bd,RemoteObject _x,RemoteObject _yarray) throws Exception{
try {
		Debug.PushSubsStack("AddBarPoint (charts) ","charts",2,_ba,charts.mostCurrent,16);
if (RapidSub.canDelegate("addbarpoint")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","addbarpoint", _ba, _bd, _x, _yarray);}
RemoteObject _b = RemoteObject.declareNull("b4a.example.charts._linepoint");
;
Debug.locals.put("BD", _bd);
Debug.locals.put("X", _x);
Debug.locals.put("YArray", _yarray);
 BA.debugLineNum = 16;BA.debugLine="Sub AddBarPoint (BD As BarData, X As String, YArra";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="If BD.Points.IsInitialized = False Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_bd.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),charts.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 18;BA.debugLine="BD.Points.Initialize";
Debug.ShouldStop(131072);
_bd.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Initialize");
 BA.debugLineNum = 20;BA.debugLine="Dim b As LinePoint";
Debug.ShouldStop(524288);
_b = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("b", _b);
 BA.debugLineNum = 21;BA.debugLine="b.Initialize";
Debug.ShouldStop(1048576);
_b.runVoidMethod ("Initialize");
 BA.debugLineNum = 22;BA.debugLine="b.X = \"\"";
Debug.ShouldStop(2097152);
_b.setField ("X" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 23;BA.debugLine="b.ShowTick = False";
Debug.ShouldStop(4194304);
_b.setField ("ShowTick" /*RemoteObject*/ ,charts.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 24;BA.debugLine="BD.Points.Add(b)";
Debug.ShouldStop(8388608);
_bd.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_b)));
 };
 BA.debugLineNum = 26;BA.debugLine="Dim b As LinePoint 'using the same structure of L";
Debug.ShouldStop(33554432);
_b = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("b", _b);
 BA.debugLineNum = 27;BA.debugLine="b.Initialize";
Debug.ShouldStop(67108864);
_b.runVoidMethod ("Initialize");
 BA.debugLineNum = 28;BA.debugLine="b.X = X";
Debug.ShouldStop(134217728);
_b.setField ("X" /*RemoteObject*/ ,_x);
 BA.debugLineNum = 29;BA.debugLine="b.YArray = YArray";
Debug.ShouldStop(268435456);
_b.setField ("YArray" /*RemoteObject*/ ,_yarray);
 BA.debugLineNum = 30;BA.debugLine="b.ShowTick = True";
Debug.ShouldStop(536870912);
_b.setField ("ShowTick" /*RemoteObject*/ ,charts.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 31;BA.debugLine="BD.Points.Add(b)";
Debug.ShouldStop(1073741824);
_bd.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_b)));
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addlinecolor(RemoteObject _ba,RemoteObject _ld,RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("AddLineColor (charts) ","charts",2,_ba,charts.mostCurrent,182);
if (RapidSub.canDelegate("addlinecolor")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","addlinecolor", _ba, _ld, _color);}
;
Debug.locals.put("LD", _ld);
Debug.locals.put("Color", _color);
 BA.debugLineNum = 182;BA.debugLine="Sub AddLineColor(LD As LineData, Color As Int)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="If LD.LinesColors.IsInitialized = False Then LD.L";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_ld.getField(false,"LinesColors" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),charts.mostCurrent.__c.getField(true,"False"))) { 
_ld.getField(false,"LinesColors" /*RemoteObject*/ ).runVoidMethod ("Initialize");};
 BA.debugLineNum = 184;BA.debugLine="LD.LinesColors.Add(Color)";
Debug.ShouldStop(8388608);
_ld.getField(false,"LinesColors" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_color)));
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addlinemultiplepoints(RemoteObject _ba,RemoteObject _ld,RemoteObject _x,RemoteObject _yarray,RemoteObject _showtick) throws Exception{
try {
		Debug.PushSubsStack("AddLineMultiplePoints (charts) ","charts",2,_ba,charts.mostCurrent,172);
if (RapidSub.canDelegate("addlinemultiplepoints")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","addlinemultiplepoints", _ba, _ld, _x, _yarray, _showtick);}
RemoteObject _p = RemoteObject.declareNull("b4a.example.charts._linepoint");
;
Debug.locals.put("LD", _ld);
Debug.locals.put("X", _x);
Debug.locals.put("YArray", _yarray);
Debug.locals.put("ShowTick", _showtick);
 BA.debugLineNum = 172;BA.debugLine="Sub AddLineMultiplePoints(LD As LineData, X As Str";
Debug.ShouldStop(2048);
 BA.debugLineNum = 173;BA.debugLine="If LD.Points.IsInitialized = False Then LD.Points";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),charts.mostCurrent.__c.getField(true,"False"))) { 
_ld.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Initialize");};
 BA.debugLineNum = 174;BA.debugLine="Dim p As LinePoint";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("p", _p);
 BA.debugLineNum = 175;BA.debugLine="p.Initialize";
Debug.ShouldStop(16384);
_p.runVoidMethod ("Initialize");
 BA.debugLineNum = 176;BA.debugLine="p.X = X";
Debug.ShouldStop(32768);
_p.setField ("X" /*RemoteObject*/ ,_x);
 BA.debugLineNum = 177;BA.debugLine="p.YArray = YArray";
Debug.ShouldStop(65536);
_p.setField ("YArray" /*RemoteObject*/ ,_yarray);
 BA.debugLineNum = 178;BA.debugLine="p.ShowTick = ShowTick";
Debug.ShouldStop(131072);
_p.setField ("ShowTick" /*RemoteObject*/ ,_showtick);
 BA.debugLineNum = 179;BA.debugLine="LD.Points.Add(p)";
Debug.ShouldStop(262144);
_ld.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_p)));
 BA.debugLineNum = 180;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addlinepoint(RemoteObject _ba,RemoteObject _ld,RemoteObject _x,RemoteObject _y,RemoteObject _showtick) throws Exception{
try {
		Debug.PushSubsStack("AddLinePoint (charts) ","charts",2,_ba,charts.mostCurrent,162);
if (RapidSub.canDelegate("addlinepoint")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","addlinepoint", _ba, _ld, _x, _y, _showtick);}
RemoteObject _p = RemoteObject.declareNull("b4a.example.charts._linepoint");
;
Debug.locals.put("LD", _ld);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
Debug.locals.put("ShowTick", _showtick);
 BA.debugLineNum = 162;BA.debugLine="Sub AddLinePoint (LD As LineData, X As String, Y A";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="If LD.Points.IsInitialized = False Then LD.Points";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),charts.mostCurrent.__c.getField(true,"False"))) { 
_ld.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Initialize");};
 BA.debugLineNum = 164;BA.debugLine="Dim p As LinePoint";
Debug.ShouldStop(8);
_p = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("p", _p);
 BA.debugLineNum = 165;BA.debugLine="p.Initialize";
Debug.ShouldStop(16);
_p.runVoidMethod ("Initialize");
 BA.debugLineNum = 166;BA.debugLine="p.X = X";
Debug.ShouldStop(32);
_p.setField ("X" /*RemoteObject*/ ,_x);
 BA.debugLineNum = 167;BA.debugLine="p.Y = Y";
Debug.ShouldStop(64);
_p.setField ("Y" /*RemoteObject*/ ,_y);
 BA.debugLineNum = 168;BA.debugLine="p.ShowTick = ShowTick";
Debug.ShouldStop(128);
_p.setField ("ShowTick" /*RemoteObject*/ ,_showtick);
 BA.debugLineNum = 169;BA.debugLine="LD.Points.Add(p)";
Debug.ShouldStop(256);
_ld.getField(false,"Points" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_p)));
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addpieitem(RemoteObject _ba,RemoteObject _pd,RemoteObject _name,RemoteObject _value,RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("AddPieItem (charts) ","charts",2,_ba,charts.mostCurrent,237);
if (RapidSub.canDelegate("addpieitem")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","addpieitem", _ba, _pd, _name, _value, _color);}
RemoteObject _i = RemoteObject.declareNull("b4a.example.charts._pieitem");
;
Debug.locals.put("PD", _pd);
Debug.locals.put("Name", _name);
Debug.locals.put("Value", _value);
Debug.locals.put("Color", _color);
 BA.debugLineNum = 237;BA.debugLine="Sub AddPieItem(PD As PieData, Name As String, Valu";
Debug.ShouldStop(4096);
 BA.debugLineNum = 238;BA.debugLine="If PD.Items.IsInitialized = False Then PD.Items.I";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),charts.mostCurrent.__c.getField(true,"False"))) { 
_pd.getField(false,"Items" /*RemoteObject*/ ).runVoidMethod ("Initialize");};
 BA.debugLineNum = 239;BA.debugLine="If Color = 0 Then Color = Colors.RGB(Rnd(0, 255),";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_color,BA.numberCast(double.class, 0))) { 
_color = charts.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(charts.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)))),(Object)(charts.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)))),(Object)(charts.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255)))));Debug.locals.put("Color", _color);};
 BA.debugLineNum = 240;BA.debugLine="Dim i As PieItem";
Debug.ShouldStop(32768);
_i = RemoteObject.createNew ("b4a.example.charts._pieitem");Debug.locals.put("i", _i);
 BA.debugLineNum = 241;BA.debugLine="i.Initialize";
Debug.ShouldStop(65536);
_i.runVoidMethod ("Initialize");
 BA.debugLineNum = 242;BA.debugLine="i.Name = Name";
Debug.ShouldStop(131072);
_i.setField ("Name" /*RemoteObject*/ ,_name);
 BA.debugLineNum = 243;BA.debugLine="i.Value = Value";
Debug.ShouldStop(262144);
_i.setField ("Value" /*RemoteObject*/ ,_value);
 BA.debugLineNum = 244;BA.debugLine="i.Color = Color";
Debug.ShouldStop(524288);
_i.setField ("Color" /*RemoteObject*/ ,_color);
 BA.debugLineNum = 245;BA.debugLine="PD.Items.Add(i)";
Debug.ShouldStop(1048576);
_pd.getField(false,"Items" /*RemoteObject*/ ).runVoidMethod ("Add",(Object)((_i)));
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calcpointtopixel(RemoteObject _ba,RemoteObject _py,RemoteObject _g) throws Exception{
try {
		Debug.PushSubsStack("calcPointToPixel (charts) ","charts",2,_ba,charts.mostCurrent,227);
if (RapidSub.canDelegate("calcpointtopixel")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","calcpointtopixel", _ba, _py, _g);}
;
Debug.locals.put("py", _py);
Debug.locals.put("G", _g);
 BA.debugLineNum = 227;BA.debugLine="Sub calcPointToPixel(py As Float, G As graph) As I";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="If G.YStart < 0 And G.YEnd > 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",_g.getField(true,"YStart" /*RemoteObject*/ ),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",_g.getField(true,"YEnd" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 229;BA.debugLine="Return G.GI.zeroY - (G.GI.originY - G.GI.maxY) *";
Debug.ShouldStop(16);
if (true) return BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"zeroY" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originY" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"maxY" /*RemoteObject*/ )}, "-",1, 1)),_py,(RemoteObject.solve(new RemoteObject[] {_g.getField(true,"YEnd" /*RemoteObject*/ ),_g.getField(true,"YStart" /*RemoteObject*/ )}, "-",1, 0))}, "-*/",1, 0));
 }else {
 BA.debugLineNum = 231;BA.debugLine="Return G.GI.originY - (G.GI.originY - G.GI.maxY)";
Debug.ShouldStop(64);
if (true) return BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originY" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originY" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"maxY" /*RemoteObject*/ )}, "-",1, 1)),(RemoteObject.solve(new RemoteObject[] {_py,_g.getField(true,"YStart" /*RemoteObject*/ )}, "-",1, 0)),(RemoteObject.solve(new RemoteObject[] {_g.getField(true,"YEnd" /*RemoteObject*/ ),_g.getField(true,"YStart" /*RemoteObject*/ )}, "-",1, 0))}, "-*/",1, 0));
 };
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _calcslice(RemoteObject _ba,RemoteObject _canvas,RemoteObject _radius,RemoteObject _startingdegree,RemoteObject _percent,RemoteObject _color,RemoteObject _gapdegrees) throws Exception{
try {
		Debug.PushSubsStack("calcSlice (charts) ","charts",2,_ba,charts.mostCurrent,282);
if (RapidSub.canDelegate("calcslice")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","calcslice", _ba, _canvas, _radius, _startingdegree, _percent, _color, _gapdegrees);}
RemoteObject _b = RemoteObject.createImmutable(0f);
RemoteObject _cx = RemoteObject.createImmutable(0);
RemoteObject _cy = RemoteObject.createImmutable(0);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");
RemoteObject _gap = RemoteObject.createImmutable(0f);
int _i = 0;
;
Debug.locals.put("Canvas", _canvas);
Debug.locals.put("Radius", _radius);
Debug.locals.put("StartingDegree", _startingdegree);
Debug.locals.put("Percent", _percent);
Debug.locals.put("Color", _color);
Debug.locals.put("GapDegrees", _gapdegrees);
 BA.debugLineNum = 282;BA.debugLine="Sub calcSlice(Canvas As Canvas, Radius As Int, _";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 284;BA.debugLine="Dim b As Float";
Debug.ShouldStop(134217728);
_b = RemoteObject.createImmutable(0f);Debug.locals.put("b", _b);
 BA.debugLineNum = 285;BA.debugLine="b = 360 * Percent";
Debug.ShouldStop(268435456);
_b = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(360),_percent}, "*",0, 0));Debug.locals.put("b", _b);
 BA.debugLineNum = 287;BA.debugLine="Dim cx, cy As Int";
Debug.ShouldStop(1073741824);
_cx = RemoteObject.createImmutable(0);Debug.locals.put("cx", _cx);
_cy = RemoteObject.createImmutable(0);Debug.locals.put("cy", _cy);
 BA.debugLineNum = 288;BA.debugLine="cx = Canvas.Bitmap.Width / 2";
Debug.ShouldStop(-2147483648);
_cx = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_canvas.runMethod(false,"getBitmap").runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("cx", _cx);
 BA.debugLineNum = 289;BA.debugLine="cy = Canvas.Bitmap.Height / 2";
Debug.ShouldStop(1);
_cy = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_canvas.runMethod(false,"getBitmap").runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("cy", _cy);
 BA.debugLineNum = 290;BA.debugLine="Dim p As Path";
Debug.ShouldStop(2);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 291;BA.debugLine="p.Initialize(cx, cy)";
Debug.ShouldStop(4);
_p.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)));
 BA.debugLineNum = 292;BA.debugLine="Dim gap As Float";
Debug.ShouldStop(8);
_gap = RemoteObject.createImmutable(0f);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 293;BA.debugLine="gap = Percent * GapDegrees / 2";
Debug.ShouldStop(16);
_gap = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_percent,_gapdegrees,RemoteObject.createImmutable(2)}, "*/",0, 0));Debug.locals.put("gap", _gap);
 BA.debugLineNum = 294;BA.debugLine="For i = StartingDegree + gap To StartingDegree +";
Debug.ShouldStop(32);
{
final int step10 = 10;
final int limit10 = (int) (0 + RemoteObject.solve(new RemoteObject[] {_startingdegree,_b,_gap}, "+-",2, 0).<Double>get().doubleValue());
_i = (int) (0 + RemoteObject.solve(new RemoteObject[] {_startingdegree,_gap}, "+",1, 0).<Double>get().doubleValue()) ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 295;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Rad";
Debug.ShouldStop(64);
_p.runVoidMethod ("LineTo",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cx,RemoteObject.createImmutable(2),_radius,charts.mostCurrent.__c.runMethod(true,"SinD",(Object)(BA.numberCast(double.class, _i)))}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cy,RemoteObject.createImmutable(2),_radius,charts.mostCurrent.__c.runMethod(true,"CosD",(Object)(BA.numberCast(double.class, _i)))}, "+**",1, 0))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 297;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(StartingDegree +";
Debug.ShouldStop(256);
_p.runVoidMethod ("LineTo",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cx,RemoteObject.createImmutable(2),_radius,charts.mostCurrent.__c.runMethod(true,"SinD",(Object)(RemoteObject.solve(new RemoteObject[] {_startingdegree,_b,_gap}, "+-",2, 0)))}, "+**",1, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_cy,RemoteObject.createImmutable(2),_radius,charts.mostCurrent.__c.runMethod(true,"CosD",(Object)(RemoteObject.solve(new RemoteObject[] {_startingdegree,_b,_gap}, "+-",2, 0)))}, "+**",1, 0))));
 BA.debugLineNum = 298;BA.debugLine="p.LineTo(cx, cy)";
Debug.ShouldStop(512);
_p.runVoidMethod ("LineTo",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)));
 BA.debugLineNum = 299;BA.debugLine="Canvas.ClipPath(p) 'We are limiting the drawings";
Debug.ShouldStop(1024);
_canvas.runVoidMethod ("ClipPath",(Object)((_p.getObject())));
 BA.debugLineNum = 300;BA.debugLine="Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)";
Debug.ShouldStop(2048);
_canvas.runVoidMethod ("DrawCircle",(Object)(BA.numberCast(float.class, _cx)),(Object)(BA.numberCast(float.class, _cy)),(Object)(BA.numberCast(float.class, _radius)),(Object)(_color),(Object)(charts.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 301;BA.debugLine="Canvas.RemoveClip";
Debug.ShouldStop(4096);
_canvas.runVoidMethod ("RemoveClip");
 BA.debugLineNum = 302;BA.debugLine="Return b";
Debug.ShouldStop(8192);
if (true) return _b;
 BA.debugLineNum = 303;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createlegend(RemoteObject _ba,RemoteObject _pd) throws Exception{
try {
		Debug.PushSubsStack("createLegend (charts) ","charts",2,_ba,charts.mostCurrent,305);
if (RapidSub.canDelegate("createlegend")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","createlegend", _ba, _pd);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _textheight = RemoteObject.createImmutable(0f);
RemoteObject _textwidth = RemoteObject.createImmutable(0f);
int _i = 0;
RemoteObject _it = RemoteObject.declareNull("b4a.example.charts._pieitem");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
;
Debug.locals.put("PD", _pd);
 BA.debugLineNum = 305;BA.debugLine="Sub createLegend(PD As PieData) As Bitmap";
Debug.ShouldStop(65536);
 BA.debugLineNum = 306;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(131072);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 307;BA.debugLine="If PD.LegendTextSize = 0 Then PD.LegendTextSize =";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_pd.getField(true,"LegendTextSize" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
_pd.setField ("LegendTextSize" /*RemoteObject*/ ,BA.numberCast(float.class, 15));};
 BA.debugLineNum = 308;BA.debugLine="Dim textHeight, textWidth As Float";
Debug.ShouldStop(524288);
_textheight = RemoteObject.createImmutable(0f);Debug.locals.put("textHeight", _textheight);
_textwidth = RemoteObject.createImmutable(0f);Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 309;BA.debugLine="textHeight = PD.Canvas.MeasureStringHeight(\"M\", T";
Debug.ShouldStop(1048576);
_textheight = _pd.getField(false,"Canvas" /*RemoteObject*/ ).runMethod(true,"MeasureStringHeight",(Object)(BA.ObjectToString("M")),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_pd.getField(true,"LegendTextSize" /*RemoteObject*/ )));Debug.locals.put("textHeight", _textheight);
 BA.debugLineNum = 310;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(2097152);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 311;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(4194304);
_it = RemoteObject.createNew ("b4a.example.charts._pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 312;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(8388608);
_it = (_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 313;BA.debugLine="textWidth = Max(textWidth, PD.Canvas.MeasureStri";
Debug.ShouldStop(16777216);
_textwidth = BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _textwidth)),(Object)(BA.numberCast(double.class, _pd.getField(false,"Canvas" /*RemoteObject*/ ).runMethod(true,"MeasureStringWidth",(Object)(_it.getField(true,"Name" /*RemoteObject*/ )),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_pd.getField(true,"LegendTextSize" /*RemoteObject*/ )))))));Debug.locals.put("textWidth", _textwidth);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 315;BA.debugLine="bmp.InitializeMutable(textWidth + 20dip, 10dip +(";
Debug.ShouldStop(67108864);
_bmp.runVoidMethod ("InitializeMutable",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_textwidth,charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),(RemoteObject.solve(new RemoteObject[] {_textheight,charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 0)),_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize")}, "+*",1, 0))));
 BA.debugLineNum = 316;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(134217728);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 317;BA.debugLine="c.Initialize2(bmp)";
Debug.ShouldStop(268435456);
_c.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 318;BA.debugLine="c.DrawColor(PD.LegendBackColor)";
Debug.ShouldStop(536870912);
_c.runVoidMethod ("DrawColor",(Object)(_pd.getField(true,"LegendBackColor" /*RemoteObject*/ )));
 BA.debugLineNum = 319;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(1073741824);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 320;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(-2147483648);
_it = RemoteObject.createNew ("b4a.example.charts._pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 321;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(1);
_it = (_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 322;BA.debugLine="c.DrawText(it.Name, 10dip, (i + 1) * (textHeight";
Debug.ShouldStop(2);
_c.runVoidMethod ("DrawText",_ba,(Object)(_it.getField(true,"Name" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {_textheight,charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "+",1, 0))}, "*",0, 0))),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_pd.getField(true,"LegendTextSize" /*RemoteObject*/ )),(Object)(_it.getField(true,"Color" /*RemoteObject*/ )),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("LEFT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 325;BA.debugLine="Return bmp";
Debug.ShouldStop(16);
if (true) return _bmp;
 BA.debugLineNum = 326;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawbarschart(RemoteObject _ba,RemoteObject _g,RemoteObject _bd,RemoteObject _backcolor) throws Exception{
try {
		Debug.PushSubsStack("DrawBarsChart (charts) ","charts",2,_ba,charts.mostCurrent,39);
if (RapidSub.canDelegate("drawbarschart")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","drawbarschart", _ba, _g, _bd, _backcolor);}
RemoteObject _point = RemoteObject.declareNull("b4a.example.charts._linepoint");
RemoteObject _rect = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _numberofbars = RemoteObject.createImmutable(0);
int _i = 0;
int _a = 0;
;
Debug.locals.put("G", _g);
Debug.locals.put("BD", _bd);
Debug.locals.put("BackColor", _backcolor);
 BA.debugLineNum = 39;BA.debugLine="Sub DrawBarsChart(G As graph, BD As BarData, BackC";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="If BD.Points.Size = 0 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_bd.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 41;BA.debugLine="ToastMessageShow(\"Missing bars points.\", True)";
Debug.ShouldStop(256);
charts.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Missing bars points.")),(Object)(charts.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 42;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 44;BA.debugLine="BD.Canvas.Initialize(BD.Target)";
Debug.ShouldStop(2048);
_bd.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)((_bd.getField(false,"Target" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 45;BA.debugLine="BD.Canvas.DrawColor(BackColor)";
Debug.ShouldStop(4096);
_bd.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("DrawColor",(Object)(_backcolor));
 BA.debugLineNum = 46;BA.debugLine="Dim point As LinePoint";
Debug.ShouldStop(8192);
_point = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("point", _point);
 BA.debugLineNum = 47;BA.debugLine="point = BD.Points.Get(1)";
Debug.ShouldStop(16384);
_point = (_bd.getField(false,"Points" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("point", _point);
 BA.debugLineNum = 48;BA.debugLine="If BD.Stacked = False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_bd.getField(true,"Stacked" /*RemoteObject*/ ),charts.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 49;BA.debugLine="drawGraph(G, BD.Canvas, BD.Target, BD.Points, Tr";
Debug.ShouldStop(65536);
_drawgraph(_ba,_g,_bd.getField(false,"Canvas" /*RemoteObject*/ ),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _bd.getField(false,"Target" /*RemoteObject*/ ).getObject()),_bd.getField(false,"Points" /*RemoteObject*/ ),charts.mostCurrent.__c.getField(true,"True"),_bd.getField(true,"BarsWidth" /*RemoteObject*/ ));
 }else {
 BA.debugLineNum = 52;BA.debugLine="drawGraph(G, BD.Canvas, BD.Target, BD.Points, Tr";
Debug.ShouldStop(524288);
_drawgraph(_ba,_g,_bd.getField(false,"Canvas" /*RemoteObject*/ ),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _bd.getField(false,"Target" /*RemoteObject*/ ).getObject()),_bd.getField(false,"Points" /*RemoteObject*/ ),charts.mostCurrent.__c.getField(true,"True"),BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_bd.getField(true,"BarsWidth" /*RemoteObject*/ ),_point.getField(false,"YArray" /*RemoteObject*/ ).getField(true,"length")}, "/",0, 0)));
 };
 BA.debugLineNum = 56;BA.debugLine="Dim Rect As Rect";
Debug.ShouldStop(8388608);
_rect = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("Rect", _rect);
 BA.debugLineNum = 57;BA.debugLine="Rect.Initialize(0, 0, 0, G.GI.originY)";
Debug.ShouldStop(16777216);
_rect.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originY" /*RemoteObject*/ )));
 BA.debugLineNum = 58;BA.debugLine="Dim numberOfBars As Int";
Debug.ShouldStop(33554432);
_numberofbars = RemoteObject.createImmutable(0);Debug.locals.put("numberOfBars", _numberofbars);
 BA.debugLineNum = 59;BA.debugLine="numberOfBars = point.YArray.Length";
Debug.ShouldStop(67108864);
_numberofbars = _point.getField(false,"YArray" /*RemoteObject*/ ).getField(true,"length");Debug.locals.put("numberOfBars", _numberofbars);
 BA.debugLineNum = 61;BA.debugLine="For i = 1 To BD.Points.Size - 1";
Debug.ShouldStop(268435456);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {_bd.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 1 ;
for (;(step18 > 0 && _i <= limit18) || (step18 < 0 && _i >= limit18) ;_i = ((int)(0 + _i + step18))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 62;BA.debugLine="point = BD.Points.Get(i)";
Debug.ShouldStop(536870912);
_point = (_bd.getField(false,"Points" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("point", _point);
 BA.debugLineNum = 63;BA.debugLine="For a = 0 To numberOfBars - 1";
Debug.ShouldStop(1073741824);
{
final int step20 = 1;
final int limit20 = RemoteObject.solve(new RemoteObject[] {_numberofbars,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step20 > 0 && _a <= limit20) || (step20 < 0 && _a >= limit20) ;_a = ((int)(0 + _a + step20))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 64;BA.debugLine="If BD.Stacked = False Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_bd.getField(true,"Stacked" /*RemoteObject*/ ),charts.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 65;BA.debugLine="Rect.Left = G.GI.originX + G.GI.intervalX * i";
Debug.ShouldStop(1);
_rect.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originX" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"intervalX" /*RemoteObject*/ ),RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_a),_numberofbars,RemoteObject.createImmutable(2)}, "-/",1, 0)),_bd.getField(true,"BarsWidth" /*RemoteObject*/ )}, "+*+*",2, 0)));
 BA.debugLineNum = 66;BA.debugLine="Rect.Right = Rect.Left + BD.BarsWidth";
Debug.ShouldStop(2);
_rect.runMethod(true,"setRight",RemoteObject.solve(new RemoteObject[] {_rect.runMethod(true,"getLeft"),_bd.getField(true,"BarsWidth" /*RemoteObject*/ )}, "+",1, 1));
 BA.debugLineNum = 67;BA.debugLine="If G.YStart < 0 And G.YEnd > 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("<",_g.getField(true,"YStart" /*RemoteObject*/ ),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",_g.getField(true,"YEnd" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 68;BA.debugLine="If point.YArray(a) > 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 69;BA.debugLine="Rect.Top = calcPointToPixel(point.YArray(a),";
Debug.ShouldStop(16);
_rect.runMethod(true,"setTop",_calcpointtopixel(_ba,_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),_g));
 BA.debugLineNum = 70;BA.debugLine="Rect.Bottom = G.GI.zeroY";
Debug.ShouldStop(32);
_rect.runMethod(true,"setBottom",_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"zeroY" /*RemoteObject*/ ));
 }else {
 BA.debugLineNum = 72;BA.debugLine="Rect.Bottom = calcPointToPixel(point.YArray(";
Debug.ShouldStop(128);
_rect.runMethod(true,"setBottom",_calcpointtopixel(_ba,_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),_g));
 BA.debugLineNum = 73;BA.debugLine="Rect.Top = G.GI.zeroY";
Debug.ShouldStop(256);
_rect.runMethod(true,"setTop",_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"zeroY" /*RemoteObject*/ ));
 };
 }else {
 BA.debugLineNum = 76;BA.debugLine="Rect.Top = calcPointToPixel(point.YArray(a),";
Debug.ShouldStop(2048);
_rect.runMethod(true,"setTop",_calcpointtopixel(_ba,_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),_g));
 BA.debugLineNum = 77;BA.debugLine="Rect.Bottom = G.GI.originY";
Debug.ShouldStop(4096);
_rect.runMethod(true,"setBottom",_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originY" /*RemoteObject*/ ));
 };
 }else {
 BA.debugLineNum = 80;BA.debugLine="Rect.Left = G.GI.originX + G.GI.intervalX * i";
Debug.ShouldStop(32768);
_rect.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originX" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"intervalX" /*RemoteObject*/ ),RemoteObject.createImmutable(_i),_bd.getField(true,"BarsWidth" /*RemoteObject*/ ),RemoteObject.createImmutable(2)}, "+*-/",2, 0)));
 BA.debugLineNum = 81;BA.debugLine="Rect.Right = Rect.Left + BD.BarsWidth";
Debug.ShouldStop(65536);
_rect.runMethod(true,"setRight",RemoteObject.solve(new RemoteObject[] {_rect.runMethod(true,"getLeft"),_bd.getField(true,"BarsWidth" /*RemoteObject*/ )}, "+",1, 1));
 BA.debugLineNum = 82;BA.debugLine="If a = 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_a),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 83;BA.debugLine="Rect.Top = calcPointToPixel(0, G)";
Debug.ShouldStop(262144);
_rect.runMethod(true,"setTop",_calcpointtopixel(_ba,BA.numberCast(float.class, 0),_g));
 };
 BA.debugLineNum = 85;BA.debugLine="Rect.Bottom = Rect.Top";
Debug.ShouldStop(1048576);
_rect.runMethod(true,"setBottom",_rect.runMethod(true,"getTop"));
 BA.debugLineNum = 86;BA.debugLine="Rect.Top = Rect.Bottom + calcPointToPixel(poin";
Debug.ShouldStop(2097152);
_rect.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_rect.runMethod(true,"getBottom"),_calcpointtopixel(_ba,_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),_g),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originY" /*RemoteObject*/ )}, "+-",2, 1));
 };
 BA.debugLineNum = 88;BA.debugLine="BD.Canvas.DrawRect(Rect, BD.BarsColors.Get(a),";
Debug.ShouldStop(8388608);
_bd.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("DrawRect",(Object)((_rect.getObject())),(Object)(BA.numberCast(int.class, _bd.getField(false,"BarsColors" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a))))),(Object)(charts.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }
}Debug.locals.put("a", _a);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 91;BA.debugLine="BD.Target.Invalidate";
Debug.ShouldStop(67108864);
_bd.getField(false,"Target" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawgraph(RemoteObject _ba,RemoteObject _g,RemoteObject _canvas,RemoteObject _target,RemoteObject _points,RemoteObject _bars,RemoteObject _barswidth) throws Exception{
try {
		Debug.PushSubsStack("drawGraph (charts) ","charts",2,_ba,charts.mostCurrent,96);
if (RapidSub.canDelegate("drawgraph")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","drawgraph", _ba, _g, _canvas, _target, _points, _bars, _barswidth);}
RemoteObject _gi = RemoteObject.declareNull("b4a.example.charts._graphinternal");
RemoteObject _p = RemoteObject.declareNull("b4a.example.charts._linepoint");
int _i = 0;
RemoteObject _y = RemoteObject.createImmutable(0);
RemoteObject _yvalue = RemoteObject.createImmutable(0f);
RemoteObject _x = RemoteObject.createImmutable(0);
;
Debug.locals.put("G", _g);
Debug.locals.put("Canvas", _canvas);
Debug.locals.put("Target", _target);
Debug.locals.put("Points", _points);
Debug.locals.put("Bars", _bars);
Debug.locals.put("BarsWidth", _barswidth);
 BA.debugLineNum = 96;BA.debugLine="Sub drawGraph (G As graph, Canvas As Canvas, Targe";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim GI As GraphInternal";
Debug.ShouldStop(1);
_gi = RemoteObject.createNew ("b4a.example.charts._graphinternal");Debug.locals.put("GI", _gi);
 BA.debugLineNum = 98;BA.debugLine="G.GI = GI";
Debug.ShouldStop(2);
_g.setField ("GI" /*RemoteObject*/ ,_gi);
 BA.debugLineNum = 99;BA.debugLine="GI.Initialize";
Debug.ShouldStop(4);
_gi.runVoidMethod ("Initialize");
 BA.debugLineNum = 100;BA.debugLine="GI.maxY = 40dip";
Debug.ShouldStop(8);
_gi.setField ("maxY" /*RemoteObject*/ ,charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40))));
 BA.debugLineNum = 101;BA.debugLine="GI.originX = 50dip";
Debug.ShouldStop(16);
_gi.setField ("originX" /*RemoteObject*/ ,charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 102;BA.debugLine="GI.originY = Target.Height - 60dip";
Debug.ShouldStop(32);
_gi.setField ("originY" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {_target.runMethod(true,"getHeight"),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))}, "-",1, 1));
 BA.debugLineNum = 103;BA.debugLine="GI.gw = Target.Width - 70dip 'graph width";
Debug.ShouldStop(64);
_gi.setField ("gw" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {_target.runMethod(true,"getWidth"),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))}, "-",1, 1));
 BA.debugLineNum = 104;BA.debugLine="GI.gh = GI.originY - GI.maxY 'graph height";
Debug.ShouldStop(128);
_gi.setField ("gh" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originY" /*RemoteObject*/ ),_gi.getField(true,"maxY" /*RemoteObject*/ )}, "-",1, 1));
 BA.debugLineNum = 105;BA.debugLine="If G.YStart < 0 And G.YEnd > 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("<",_g.getField(true,"YStart" /*RemoteObject*/ ),BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean(">",_g.getField(true,"YEnd" /*RemoteObject*/ ),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 106;BA.debugLine="GI.zeroY = GI.maxY + GI.gh * G.YEnd / (G.YEnd -";
Debug.ShouldStop(512);
_gi.setField ("zeroY" /*RemoteObject*/ ,BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"maxY" /*RemoteObject*/ ),_gi.getField(true,"gh" /*RemoteObject*/ ),_g.getField(true,"YEnd" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {_g.getField(true,"YEnd" /*RemoteObject*/ ),_g.getField(true,"YStart" /*RemoteObject*/ )}, "-",1, 0))}, "+*/",1, 0)));
 }else {
 BA.debugLineNum = 108;BA.debugLine="GI.zeroY = GI.originY";
Debug.ShouldStop(2048);
_gi.setField ("zeroY" /*RemoteObject*/ ,_gi.getField(true,"originY" /*RemoteObject*/ ));
 };
 BA.debugLineNum = 110;BA.debugLine="If Bars Then";
Debug.ShouldStop(8192);
if (_bars.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 111;BA.debugLine="Dim p As LinePoint";
Debug.ShouldStop(16384);
_p = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("p", _p);
 BA.debugLineNum = 112;BA.debugLine="p = Points.Get(1)";
Debug.ShouldStop(32768);
_p = (_points.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("p", _p);
 BA.debugLineNum = 113;BA.debugLine="GI.intervalX = (GI.gw - p.YArray.Length / 2 * Ba";
Debug.ShouldStop(65536);
_gi.setField ("intervalX" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"gw" /*RemoteObject*/ ),_p.getField(false,"YArray" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(2),_barswidth}, "-/*",1, 0)),(RemoteObject.solve(new RemoteObject[] {_points.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))}, "/",0, 0)));
 }else {
 BA.debugLineNum = 115;BA.debugLine="GI.intervalX = GI.gw / (Points.Size - 1)";
Debug.ShouldStop(262144);
_gi.setField ("intervalX" /*RemoteObject*/ ,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"gw" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {_points.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1))}, "/",0, 0)));
 };
 BA.debugLineNum = 118;BA.debugLine="Canvas.DrawLine(GI.originX, GI.originY + 2dip, GI";
Debug.ShouldStop(2097152);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _gi.getField(true,"originX" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originY" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "+",1, 1))),(Object)(BA.numberCast(float.class, _gi.getField(true,"originX" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"maxY" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1))),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 119;BA.debugLine="For i = 0 To (G.YEnd - G.YStart) / G.Yinterval +";
Debug.ShouldStop(4194304);
{
final int step22 = 1;
final int limit22 = (int) (0 + RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_g.getField(true,"YEnd" /*RemoteObject*/ ),_g.getField(true,"YStart" /*RemoteObject*/ )}, "-",1, 0)),_g.getField(true,"YInterval" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "/+",1, 0).<Double>get().doubleValue());
_i = 0 ;
for (;(step22 > 0 && _i <= limit22) || (step22 < 0 && _i >= limit22) ;_i = ((int)(0 + _i + step22))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 120;BA.debugLine="Dim y As Int";
Debug.ShouldStop(8388608);
_y = RemoteObject.createImmutable(0);Debug.locals.put("y", _y);
 BA.debugLineNum = 121;BA.debugLine="Dim yValue As Float";
Debug.ShouldStop(16777216);
_yvalue = RemoteObject.createImmutable(0f);Debug.locals.put("yValue", _yvalue);
 BA.debugLineNum = 122;BA.debugLine="yValue = G.YStart + G.YInterval * i";
Debug.ShouldStop(33554432);
_yvalue = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_g.getField(true,"YStart" /*RemoteObject*/ ),_g.getField(true,"YInterval" /*RemoteObject*/ ),RemoteObject.createImmutable(_i)}, "+*",1, 0));Debug.locals.put("yValue", _yvalue);
 BA.debugLineNum = 123;BA.debugLine="If yValue > G.YEnd Then Continue";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",_yvalue,BA.numberCast(double.class, _g.getField(true,"YEnd" /*RemoteObject*/ )))) { 
if (true) continue;};
 BA.debugLineNum = 124;BA.debugLine="y = calcPointToPixel(yValue, G)";
Debug.ShouldStop(134217728);
_y = _calcpointtopixel(_ba,_yvalue,_g);Debug.locals.put("y", _y);
 BA.debugLineNum = 125;BA.debugLine="Canvas.DrawLine(GI.originX, y, GI.originX - 5dip";
Debug.ShouldStop(268435456);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _gi.getField(true,"originX" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _y)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originX" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, _y)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 126;BA.debugLine="If i < (G.YEnd - G.YStart) / G.Yinterval Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_i),RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_g.getField(true,"YEnd" /*RemoteObject*/ ),_g.getField(true,"YStart" /*RemoteObject*/ )}, "-",1, 0)),_g.getField(true,"YInterval" /*RemoteObject*/ )}, "/",0, 0))) { 
 BA.debugLineNum = 127;BA.debugLine="Canvas.DrawLine(GI.originX, y, GI.originX + GI.";
Debug.ShouldStop(1073741824);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _gi.getField(true,"originX" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _y)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originX" /*RemoteObject*/ ),_gi.getField(true,"gw" /*RemoteObject*/ )}, "+",1, 1))),(Object)(BA.numberCast(float.class, _y)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }else {
 BA.debugLineNum = 129;BA.debugLine="Canvas.DrawLine(GI.originX, y, GI.originX + GI.";
Debug.ShouldStop(1);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _gi.getField(true,"originX" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _y)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originX" /*RemoteObject*/ ),_gi.getField(true,"gw" /*RemoteObject*/ )}, "+",1, 1))),(Object)(BA.numberCast(float.class, _y)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 };
 BA.debugLineNum = 131;BA.debugLine="Canvas.DrawText(NumberFormat(yValue, 1, 2), GI.o";
Debug.ShouldStop(4);
_canvas.runVoidMethod ("DrawText",_ba,(Object)(charts.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _yvalue)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2)))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originX" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_y,charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1))),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT")),(Object)(BA.numberCast(float.class, 12)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("RIGHT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 134;BA.debugLine="Canvas.DrawText(G.Title, Target.Width / 2, 30dip,";
Debug.ShouldStop(32);
_canvas.runVoidMethod ("DrawText",_ba,(Object)(_g.getField(true,"Title" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_target.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))))),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(BA.numberCast(float.class, 15)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 135;BA.debugLine="Canvas.DrawText(G.XAxis, Target.Width / 2, GI.ori";
Debug.ShouldStop(64);
_canvas.runVoidMethod ("DrawText",_ba,(Object)(_g.getField(true,"XAxis" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_target.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originY" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45)))}, "+",1, 1))),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT")),(Object)(BA.numberCast(float.class, 14)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 136;BA.debugLine="Canvas.DrawTextRotated(G.YAxis, 15dip, Target.Hei";
Debug.ShouldStop(128);
_canvas.runVoidMethod ("DrawTextRotated",_ba,(Object)(_g.getField(true,"YAxis" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15))))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_target.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT")),(Object)(BA.numberCast(float.class, 14)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),"CENTER")),(Object)(BA.numberCast(float.class, -(double) (0 + 90))));
 BA.debugLineNum = 138;BA.debugLine="Canvas.DrawLine(GI.originX, GI.originY, GI.origin";
Debug.ShouldStop(512);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _gi.getField(true,"originX" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _gi.getField(true,"originY" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originX" /*RemoteObject*/ ),_gi.getField(true,"gw" /*RemoteObject*/ )}, "+",1, 1))),(Object)(BA.numberCast(float.class, _gi.getField(true,"originY" /*RemoteObject*/ ))),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 139;BA.debugLine="For i = 0 To Points.Size - 1";
Debug.ShouldStop(1024);
{
final int step40 = 1;
final int limit40 = RemoteObject.solve(new RemoteObject[] {_points.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step40 > 0 && _i <= limit40) || (step40 < 0 && _i >= limit40) ;_i = ((int)(0 + _i + step40))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 140;BA.debugLine="Dim p As LinePoint";
Debug.ShouldStop(2048);
_p = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("p", _p);
 BA.debugLineNum = 141;BA.debugLine="p = Points.Get(i)";
Debug.ShouldStop(4096);
_p = (_points.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("p", _p);
 BA.debugLineNum = 142;BA.debugLine="If p.ShowTick Then";
Debug.ShouldStop(8192);
if (_p.getField(true,"ShowTick" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 143;BA.debugLine="Dim x As Int";
Debug.ShouldStop(16384);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
 BA.debugLineNum = 144;BA.debugLine="x = GI.originX + i * GI.intervalX";
Debug.ShouldStop(32768);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originX" /*RemoteObject*/ ),RemoteObject.createImmutable(_i),_gi.getField(true,"intervalX" /*RemoteObject*/ )}, "+*",1, 0));Debug.locals.put("x", _x);
 BA.debugLineNum = 145;BA.debugLine="Canvas.DrawLine(x, GI.originY, x, GI.originY +";
Debug.ShouldStop(65536);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _gi.getField(true,"originY" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originY" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1))),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 146;BA.debugLine="If Bars = False Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_bars,charts.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 147;BA.debugLine="If i < Points.Size - 1 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_i),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_points.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 148;BA.debugLine="Canvas.DrawLine(x, GI.originY, x, GI.maxY, G.";
Debug.ShouldStop(524288);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _gi.getField(true,"originY" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _gi.getField(true,"maxY" /*RemoteObject*/ ))),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 }else {
 BA.debugLineNum = 150;BA.debugLine="Canvas.DrawLine(x, GI.originY, x, GI.maxY, G.";
Debug.ShouldStop(2097152);
_canvas.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _gi.getField(true,"originY" /*RemoteObject*/ ))),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _gi.getField(true,"maxY" /*RemoteObject*/ ))),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 };
 };
 BA.debugLineNum = 153;BA.debugLine="If p.x.Length > 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean(">",_p.getField(true,"X" /*RemoteObject*/ ).runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 154;BA.debugLine="Canvas.DrawTextRotated(p.x, x, GI.originY + 12";
Debug.ShouldStop(33554432);
_canvas.runVoidMethod ("DrawTextRotated",_ba,(Object)(_p.getField(true,"X" /*RemoteObject*/ )),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_gi.getField(true,"originY" /*RemoteObject*/ ),charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+",1, 1))),(Object)(charts.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT")),(Object)(BA.numberCast(float.class, 12)),(Object)(_g.getField(true,"AxisColor" /*RemoteObject*/ )),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),"RIGHT")),(Object)(BA.numberCast(float.class, -(double) (0 + 45))));
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawlinechart(RemoteObject _ba,RemoteObject _g,RemoteObject _ld,RemoteObject _backcolor) throws Exception{
try {
		Debug.PushSubsStack("DrawLineChart (charts) ","charts",2,_ba,charts.mostCurrent,187);
if (RapidSub.canDelegate("drawlinechart")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","drawlinechart", _ba, _g, _ld, _backcolor);}
RemoteObject _point = RemoteObject.declareNull("b4a.example.charts._linepoint");
RemoteObject _py2 = null;
int _i = 0;
int _a = 0;
RemoteObject _py = RemoteObject.createImmutable(0f);
;
Debug.locals.put("G", _g);
Debug.locals.put("LD", _ld);
Debug.locals.put("BackColor", _backcolor);
 BA.debugLineNum = 187;BA.debugLine="Sub DrawLineChart(G As graph, LD As LineData, Back";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="If LD.Points.Size = 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 189;BA.debugLine="ToastMessageShow(\"Missing line points.\", True)";
Debug.ShouldStop(268435456);
charts.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Missing line points.")),(Object)(charts.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 190;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 192;BA.debugLine="LD.Canvas.Initialize(LD.Target)";
Debug.ShouldStop(-2147483648);
_ld.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)((_ld.getField(false,"Target" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 193;BA.debugLine="LD.Canvas.DrawColor(BackColor)";
Debug.ShouldStop(1);
_ld.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("DrawColor",(Object)(_backcolor));
 BA.debugLineNum = 194;BA.debugLine="drawGraph(G, LD.Canvas, LD.Target, LD.Points, Fal";
Debug.ShouldStop(2);
_drawgraph(_ba,_g,_ld.getField(false,"Canvas" /*RemoteObject*/ ),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ld.getField(false,"Target" /*RemoteObject*/ ).getObject()),_ld.getField(false,"Points" /*RemoteObject*/ ),charts.mostCurrent.__c.getField(true,"False"),BA.numberCast(int.class, 0));
 BA.debugLineNum = 196;BA.debugLine="Dim point As LinePoint";
Debug.ShouldStop(8);
_point = RemoteObject.createNew ("b4a.example.charts._linepoint");Debug.locals.put("point", _point);
 BA.debugLineNum = 197;BA.debugLine="point = LD.Points.Get(0)";
Debug.ShouldStop(16);
_point = (_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("point", _point);
 BA.debugLineNum = 198;BA.debugLine="If point.YArray.Length > 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",_point.getField(false,"YArray" /*RemoteObject*/ ).getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 200;BA.debugLine="Dim py2(point.YArray.Length) As Float";
Debug.ShouldStop(128);
_py2 = RemoteObject.createNewArray ("float", new int[] {_point.getField(false,"YArray" /*RemoteObject*/ ).getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("py2", _py2);
 BA.debugLineNum = 202;BA.debugLine="For i = 0 To py2.Length - 1";
Debug.ShouldStop(512);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_py2.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 203;BA.debugLine="py2(i) = point.YArray(i)";
Debug.ShouldStop(1024);
_py2.setArrayElement (_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 206;BA.debugLine="For i = 1 To LD.Points.Size - 1";
Debug.ShouldStop(8192);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 1 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 207;BA.debugLine="point = LD.Points.Get(i)";
Debug.ShouldStop(16384);
_point = (_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("point", _point);
 BA.debugLineNum = 208;BA.debugLine="For a = 0 To py2.Length - 1";
Debug.ShouldStop(32768);
{
final int step17 = 1;
final int limit17 = RemoteObject.solve(new RemoteObject[] {_py2.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_a = 0 ;
for (;(step17 > 0 && _a <= limit17) || (step17 < 0 && _a >= limit17) ;_a = ((int)(0 + _a + step17))  ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 209;BA.debugLine="LD.Canvas.DrawLine(G.GI.originX + G.GI.interva";
Debug.ShouldStop(65536);
_ld.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originX" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"intervalX" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, _calcpointtopixel(_ba,_py2.getArrayElement(true,BA.numberCast(int.class, _a)),_g))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originX" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"intervalX" /*RemoteObject*/ ),RemoteObject.createImmutable(_i)}, "+*",1, 0))),(Object)(BA.numberCast(float.class, _calcpointtopixel(_ba,_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),_g))),(Object)(BA.numberCast(int.class, _ld.getField(false,"LinesColors" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _a))))),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 210;BA.debugLine="py2(a) = point.YArray(a)";
Debug.ShouldStop(131072);
_py2.setArrayElement (_point.getField(false,"YArray" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _a)),BA.numberCast(int.class, _a));
 }
}Debug.locals.put("a", _a);
;
 }
}Debug.locals.put("i", _i);
;
 }else {
 BA.debugLineNum = 215;BA.debugLine="Dim py As Float";
Debug.ShouldStop(4194304);
_py = RemoteObject.createImmutable(0f);Debug.locals.put("py", _py);
 BA.debugLineNum = 216;BA.debugLine="py = point.Y";
Debug.ShouldStop(8388608);
_py = _point.getField(true,"Y" /*RemoteObject*/ );Debug.locals.put("py", _py);
 BA.debugLineNum = 217;BA.debugLine="For i = 1 To LD.Points.Size - 1";
Debug.ShouldStop(16777216);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 1 ;
for (;(step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25) ;_i = ((int)(0 + _i + step25))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 218;BA.debugLine="point = LD.Points.Get(i)";
Debug.ShouldStop(33554432);
_point = (_ld.getField(false,"Points" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("point", _point);
 BA.debugLineNum = 219;BA.debugLine="LD.Canvas.DrawLine(G.GI.originX + G.GI.interval";
Debug.ShouldStop(67108864);
_ld.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originX" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"intervalX" /*RemoteObject*/ ),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1))}, "+*",1, 0))),(Object)(BA.numberCast(float.class, _calcpointtopixel(_ba,_py,_g))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"originX" /*RemoteObject*/ ),_g.getField(false,"GI" /*RemoteObject*/ ).getField(true,"intervalX" /*RemoteObject*/ ),RemoteObject.createImmutable(_i)}, "+*",1, 0))),(Object)(BA.numberCast(float.class, _calcpointtopixel(_ba,_point.getField(true,"Y" /*RemoteObject*/ ),_g))),(Object)(BA.numberCast(int.class, _ld.getField(false,"LinesColors" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))))),(Object)(BA.numberCast(float.class, charts.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 221;BA.debugLine="py = point.Y";
Debug.ShouldStop(268435456);
_py = _point.getField(true,"Y" /*RemoteObject*/ );Debug.locals.put("py", _py);
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 224;BA.debugLine="LD.Target.Invalidate";
Debug.ShouldStop(-2147483648);
_ld.getField(false,"Target" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawpie(RemoteObject _ba,RemoteObject _pd,RemoteObject _backcolor,RemoteObject _createlegendbitmap) throws Exception{
try {
		Debug.PushSubsStack("DrawPie (charts) ","charts",2,_ba,charts.mostCurrent,248);
if (RapidSub.canDelegate("drawpie")) { return b4a.example.charts.remoteMe.runUserSub(false, "charts","drawpie", _ba, _pd, _backcolor, _createlegendbitmap);}
RemoteObject _radius = RemoteObject.createImmutable(0);
RemoteObject _total = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _it = RemoteObject.declareNull("b4a.example.charts._pieitem");
RemoteObject _startingangle = RemoteObject.createImmutable(0f);
RemoteObject _gapdegrees = RemoteObject.createImmutable(0);
;
Debug.locals.put("PD", _pd);
Debug.locals.put("BackColor", _backcolor);
Debug.locals.put("CreateLegendBitmap", _createlegendbitmap);
 BA.debugLineNum = 248;BA.debugLine="Sub DrawPie (PD As PieData, BackColor As Int, Crea";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="If PD.Items.Size = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 250;BA.debugLine="ToastMessageShow(\"Missing pie values.\", True)";
Debug.ShouldStop(33554432);
charts.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Missing pie values.")),(Object)(charts.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 251;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable(null);
 };
 BA.debugLineNum = 253;BA.debugLine="PD.Canvas.Initialize(PD.Target)";
Debug.ShouldStop(268435456);
_pd.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)((_pd.getField(false,"Target" /*RemoteObject*/ ).getObject())));
 BA.debugLineNum = 254;BA.debugLine="PD.Canvas.DrawColor(BackColor)";
Debug.ShouldStop(536870912);
_pd.getField(false,"Canvas" /*RemoteObject*/ ).runVoidMethod ("DrawColor",(Object)(_backcolor));
 BA.debugLineNum = 255;BA.debugLine="Dim Radius As Int";
Debug.ShouldStop(1073741824);
_radius = RemoteObject.createImmutable(0);Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 256;BA.debugLine="Radius = Min(PD.Canvas.Bitmap.Width, PD.Canvas.Bi";
Debug.ShouldStop(-2147483648);
_radius = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {charts.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _pd.getField(false,"Canvas" /*RemoteObject*/ ).runMethod(false,"getBitmap").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, _pd.getField(false,"Canvas" /*RemoteObject*/ ).runMethod(false,"getBitmap").runMethod(true,"getHeight")))),RemoteObject.createImmutable(0.8),RemoteObject.createImmutable(2)}, "*/",0, 0));Debug.locals.put("Radius", _radius);
 BA.debugLineNum = 257;BA.debugLine="Dim total As Int";
Debug.ShouldStop(1);
_total = RemoteObject.createImmutable(0);Debug.locals.put("total", _total);
 BA.debugLineNum = 258;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(2);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 259;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(4);
_it = RemoteObject.createNew ("b4a.example.charts._pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 260;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(8);
_it = (_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 261;BA.debugLine="total = total + it.Value";
Debug.ShouldStop(16);
_total = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_total,_it.getField(true,"Value" /*RemoteObject*/ )}, "+",1, 0));Debug.locals.put("total", _total);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 263;BA.debugLine="Dim startingAngle As Float";
Debug.ShouldStop(64);
_startingangle = RemoteObject.createImmutable(0f);Debug.locals.put("startingAngle", _startingangle);
 BA.debugLineNum = 264;BA.debugLine="startingAngle = 0";
Debug.ShouldStop(128);
_startingangle = BA.numberCast(float.class, 0);Debug.locals.put("startingAngle", _startingangle);
 BA.debugLineNum = 265;BA.debugLine="Dim GapDegrees As Int";
Debug.ShouldStop(256);
_gapdegrees = RemoteObject.createImmutable(0);Debug.locals.put("GapDegrees", _gapdegrees);
 BA.debugLineNum = 266;BA.debugLine="If PD.Items.Size = 1 Then GapDegrees = 0 Else Gap";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize"),BA.numberCast(double.class, 1))) { 
_gapdegrees = BA.numberCast(int.class, 0);Debug.locals.put("GapDegrees", _gapdegrees);}
else {
_gapdegrees = _pd.getField(true,"GapDegrees" /*RemoteObject*/ );Debug.locals.put("GapDegrees", _gapdegrees);};
 BA.debugLineNum = 267;BA.debugLine="For i = 0 To PD.Items.Size - 1";
Debug.ShouldStop(1024);
{
final int step19 = 1;
final int limit19 = RemoteObject.solve(new RemoteObject[] {_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step19 > 0 && _i <= limit19) || (step19 < 0 && _i >= limit19) ;_i = ((int)(0 + _i + step19))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 268;BA.debugLine="Dim it As PieItem";
Debug.ShouldStop(2048);
_it = RemoteObject.createNew ("b4a.example.charts._pieitem");Debug.locals.put("it", _it);
 BA.debugLineNum = 269;BA.debugLine="it = PD.Items.Get(i)";
Debug.ShouldStop(4096);
_it = (_pd.getField(false,"Items" /*RemoteObject*/ ).runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("it", _it);
 BA.debugLineNum = 270;BA.debugLine="startingAngle = startingAngle + _  			calcSlice(";
Debug.ShouldStop(8192);
_startingangle = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_startingangle,_calcslice(_ba,_pd.getField(false,"Canvas" /*RemoteObject*/ ),_radius,_startingangle,BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_it.getField(true,"Value" /*RemoteObject*/ ),_total}, "/",0, 0)),_it.getField(true,"Color" /*RemoteObject*/ ),_gapdegrees)}, "+",1, 0));Debug.locals.put("startingAngle", _startingangle);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 273;BA.debugLine="PD.Target.Invalidate";
Debug.ShouldStop(65536);
_pd.getField(false,"Target" /*RemoteObject*/ ).runVoidMethod ("Invalidate");
 BA.debugLineNum = 274;BA.debugLine="If CreateLegendBitmap Then";
Debug.ShouldStop(131072);
if (_createlegendbitmap.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 275;BA.debugLine="Return createLegend(PD)";
Debug.ShouldStop(262144);
if (true) return _createlegend(_ba,_pd);
 }else {
 BA.debugLineNum = 277;BA.debugLine="Return Null";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), charts.mostCurrent.__c.getField(false,"Null"));
 };
 BA.debugLineNum = 279;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Type PieItem (Name As String, Value As Float, Col";
;
 //BA.debugLineNum = 5;BA.debugLine="Type PieData (Items As List, Target As Panel, Can";
;
 //BA.debugLineNum = 7;BA.debugLine="Type GraphInternal (originX As Int, zeroY As Int,";
;
 //BA.debugLineNum = 8;BA.debugLine="Type graph (GI As GraphInternal, Title As String,";
;
 //BA.debugLineNum = 10;BA.debugLine="Type LinePoint (X As String, Y As Float, YArray()";
;
 //BA.debugLineNum = 11;BA.debugLine="Type LineData (Points As List, LinesColors As Lis";
;
 //BA.debugLineNum = 12;BA.debugLine="Type BarData (Points As List, BarsColors As List,";
;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}