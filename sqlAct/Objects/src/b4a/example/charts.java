package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class charts {
private static charts mostCurrent = new charts();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public static class _pieitem{
public boolean IsInitialized;
public String Name;
public float Value;
public int Color;
public void Initialize() {
IsInitialized = true;
Name = "";
Value = 0f;
Color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _piedata{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.List Items;
public anywheresoftware.b4a.objects.PanelWrapper Target;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper Canvas;
public int GapDegrees;
public float LegendTextSize;
public int LegendBackColor;
public void Initialize() {
IsInitialized = true;
Items = new anywheresoftware.b4a.objects.collections.List();
Target = new anywheresoftware.b4a.objects.PanelWrapper();
Canvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
GapDegrees = 0;
LegendTextSize = 0f;
LegendBackColor = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _graphinternal{
public boolean IsInitialized;
public int originX;
public int zeroY;
public int originY;
public int maxY;
public float intervalX;
public int gw;
public int gh;
public void Initialize() {
IsInitialized = true;
originX = 0;
zeroY = 0;
originY = 0;
maxY = 0;
intervalX = 0f;
gw = 0;
gh = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _graph{
public boolean IsInitialized;
public b4a.example.charts._graphinternal GI;
public String Title;
public String YAxis;
public String XAxis;
public float YStart;
public float YEnd;
public float YInterval;
public int AxisColor;
public void Initialize() {
IsInitialized = true;
GI = new b4a.example.charts._graphinternal();
Title = "";
YAxis = "";
XAxis = "";
YStart = 0f;
YEnd = 0f;
YInterval = 0f;
AxisColor = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _linepoint{
public boolean IsInitialized;
public String X;
public float Y;
public float[] YArray;
public boolean ShowTick;
public void Initialize() {
IsInitialized = true;
X = "";
Y = 0f;
YArray = new float[0];
;
ShowTick = false;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _linedata{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.List Points;
public anywheresoftware.b4a.objects.collections.List LinesColors;
public anywheresoftware.b4a.objects.PanelWrapper Target;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper Canvas;
public void Initialize() {
IsInitialized = true;
Points = new anywheresoftware.b4a.objects.collections.List();
LinesColors = new anywheresoftware.b4a.objects.collections.List();
Target = new anywheresoftware.b4a.objects.PanelWrapper();
Canvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _bardata{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.List Points;
public anywheresoftware.b4a.objects.collections.List BarsColors;
public anywheresoftware.b4a.objects.PanelWrapper Target;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper Canvas;
public boolean Stacked;
public int BarsWidth;
public void Initialize() {
IsInitialized = true;
Points = new anywheresoftware.b4a.objects.collections.List();
BarsColors = new anywheresoftware.b4a.objects.collections.List();
Target = new anywheresoftware.b4a.objects.PanelWrapper();
Canvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
Stacked = false;
BarsWidth = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example.main _main = null;
public b4a.example.dash _dash = null;
public b4a.example.graph _graph = null;
public b4a.example.schedule _schedule = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _addbarcolor(anywheresoftware.b4a.BA _ba,b4a.example.charts._bardata _bd,int _color) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "addbarcolor", false))
	 {return ((String) Debug.delegate(null, "addbarcolor", new Object[] {_ba,_bd,_color}));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub AddBarColor(BD As BarData, Color As Int)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="If BD.BarsColors.IsInitialized = False Then BD.Ba";
if (_bd.BarsColors /*anywheresoftware.b4a.objects.collections.List*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_bd.BarsColors /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();};
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="BD.BarsColors.Add(Color)";
_bd.BarsColors /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_color));
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _addbarpoint(anywheresoftware.b4a.BA _ba,b4a.example.charts._bardata _bd,String _x,float[] _yarray) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "addbarpoint", false))
	 {return ((String) Debug.delegate(null, "addbarpoint", new Object[] {_ba,_bd,_x,_yarray}));}
b4a.example.charts._linepoint _b = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub AddBarPoint (BD As BarData, X As String, YArra";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If BD.Points.IsInitialized = False Then";
if (_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="BD.Points.Initialize";
_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Dim b As LinePoint";
_b = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="b.Initialize";
_b.Initialize();
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="b.X = \"\"";
_b.X /*String*/  = "";
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="b.ShowTick = False";
_b.ShowTick /*boolean*/  = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="BD.Points.Add(b)";
_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_b));
 };
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="Dim b As LinePoint 'using the same structure of L";
_b = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="b.Initialize";
_b.Initialize();
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="b.X = X";
_b.X /*String*/  = _x;
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="b.YArray = YArray";
_b.YArray /*float[]*/  = _yarray;
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="b.ShowTick = True";
_b.ShowTick /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="BD.Points.Add(b)";
_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_b));
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="End Sub";
return "";
}
public static String  _addlinecolor(anywheresoftware.b4a.BA _ba,b4a.example.charts._linedata _ld,int _color) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "addlinecolor", false))
	 {return ((String) Debug.delegate(null, "addlinecolor", new Object[] {_ba,_ld,_color}));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub AddLineColor(LD As LineData, Color As Int)";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="If LD.LinesColors.IsInitialized = False Then LD.L";
if (_ld.LinesColors /*anywheresoftware.b4a.objects.collections.List*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_ld.LinesColors /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();};
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="LD.LinesColors.Add(Color)";
_ld.LinesColors /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_color));
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="End Sub";
return "";
}
public static String  _addlinemultiplepoints(anywheresoftware.b4a.BA _ba,b4a.example.charts._linedata _ld,String _x,float[] _yarray,boolean _showtick) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "addlinemultiplepoints", false))
	 {return ((String) Debug.delegate(null, "addlinemultiplepoints", new Object[] {_ba,_ld,_x,_yarray,_showtick}));}
b4a.example.charts._linepoint _p = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub AddLineMultiplePoints(LD As LineData, X As Str";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="If LD.Points.IsInitialized = False Then LD.Points";
if (_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();};
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Dim p As LinePoint";
_p = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="p.Initialize";
_p.Initialize();
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="p.X = X";
_p.X /*String*/  = _x;
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="p.YArray = YArray";
_p.YArray /*float[]*/  = _yarray;
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="p.ShowTick = ShowTick";
_p.ShowTick /*boolean*/  = _showtick;
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="LD.Points.Add(p)";
_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_p));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="End Sub";
return "";
}
public static String  _addlinepoint(anywheresoftware.b4a.BA _ba,b4a.example.charts._linedata _ld,String _x,float _y,boolean _showtick) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "addlinepoint", false))
	 {return ((String) Debug.delegate(null, "addlinepoint", new Object[] {_ba,_ld,_x,_y,_showtick}));}
b4a.example.charts._linepoint _p = null;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub AddLinePoint (LD As LineData, X As String, Y A";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="If LD.Points.IsInitialized = False Then LD.Points";
if (_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();};
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Dim p As LinePoint";
_p = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="p.Initialize";
_p.Initialize();
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="p.X = X";
_p.X /*String*/  = _x;
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="p.Y = Y";
_p.Y /*float*/  = _y;
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="p.ShowTick = ShowTick";
_p.ShowTick /*boolean*/  = _showtick;
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="LD.Points.Add(p)";
_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_p));
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="End Sub";
return "";
}
public static String  _addpieitem(anywheresoftware.b4a.BA _ba,b4a.example.charts._piedata _pd,String _name,float _value,int _color) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "addpieitem", false))
	 {return ((String) Debug.delegate(null, "addpieitem", new Object[] {_ba,_pd,_name,_value,_color}));}
b4a.example.charts._pieitem _i = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub AddPieItem(PD As PieData, Name As String, Valu";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If PD.Items.IsInitialized = False Then PD.Items.I";
if (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();};
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="If Color = 0 Then Color = Colors.RGB(Rnd(0, 255),";
if (_color==0) { 
_color = anywheresoftware.b4a.keywords.Common.Colors.RGB(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255)),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255)),anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (255)));};
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="Dim i As PieItem";
_i = new b4a.example.charts._pieitem();
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="i.Initialize";
_i.Initialize();
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="i.Name = Name";
_i.Name /*String*/  = _name;
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="i.Value = Value";
_i.Value /*float*/  = _value;
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="i.Color = Color";
_i.Color /*int*/  = _color;
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="PD.Items.Add(i)";
_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_i));
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="End Sub";
return "";
}
public static int  _calcpointtopixel(anywheresoftware.b4a.BA _ba,float _py,b4a.example.charts._graph _g) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "calcpointtopixel", false))
	 {return ((Integer) Debug.delegate(null, "calcpointtopixel", new Object[] {_ba,_py,_g}));}
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub calcPointToPixel(py As Float, G As graph) As I";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="If G.YStart < 0 And G.YEnd > 0 Then";
if (_g.YStart /*float*/ <0 && _g.YEnd /*float*/ >0) { 
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Return G.GI.zeroY - (G.GI.originY - G.GI.maxY) *";
if (true) return (int) (_g.GI /*b4a.example.charts._graphinternal*/ .zeroY /*int*/ -(_g.GI /*b4a.example.charts._graphinternal*/ .originY /*int*/ -_g.GI /*b4a.example.charts._graphinternal*/ .maxY /*int*/ )*_py/(double)(_g.YEnd /*float*/ -_g.YStart /*float*/ ));
 }else {
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Return G.GI.originY - (G.GI.originY - G.GI.maxY)";
if (true) return (int) (_g.GI /*b4a.example.charts._graphinternal*/ .originY /*int*/ -(_g.GI /*b4a.example.charts._graphinternal*/ .originY /*int*/ -_g.GI /*b4a.example.charts._graphinternal*/ .maxY /*int*/ )*(_py-_g.YStart /*float*/ )/(double)(_g.YEnd /*float*/ -_g.YStart /*float*/ ));
 };
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="End Sub";
return 0;
}
public static float  _calcslice(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,int _radius,float _startingdegree,float _percent,int _color,int _gapdegrees) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "calcslice", false))
	 {return ((Float) Debug.delegate(null, "calcslice", new Object[] {_ba,_canvas,_radius,_startingdegree,_percent,_color,_gapdegrees}));}
float _b = 0f;
int _cx = 0;
int _cy = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _p = null;
float _gap = 0f;
int _i = 0;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub calcSlice(Canvas As Canvas, Radius As Int, _";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Dim b As Float";
_b = 0f;
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="b = 360 * Percent";
_b = (float) (360*_percent);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Dim cx, cy As Int";
_cx = 0;
_cy = 0;
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="cx = Canvas.Bitmap.Width / 2";
_cx = (int) (_canvas.getBitmap().getWidth()/(double)2);
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="cy = Canvas.Bitmap.Height / 2";
_cy = (int) (_canvas.getBitmap().getHeight()/(double)2);
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="p.Initialize(cx, cy)";
_p.Initialize((float) (_cx),(float) (_cy));
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="Dim gap As Float";
_gap = 0f;
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="gap = Percent * GapDegrees / 2";
_gap = (float) (_percent*_gapdegrees/(double)2);
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="For i = StartingDegree + gap To StartingDegree +";
{
final int step10 = 10;
final int limit10 = (int) (_startingdegree+_b-_gap);
_i = (int) (_startingdegree+_gap) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(i), cy + 2 * Rad";
_p.LineTo((float) (_cx+2*_radius*anywheresoftware.b4a.keywords.Common.SinD(_i)),(float) (_cy+2*_radius*anywheresoftware.b4a.keywords.Common.CosD(_i)));
 }
};
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="p.LineTo(cx + 2 * Radius * SinD(StartingDegree +";
_p.LineTo((float) (_cx+2*_radius*anywheresoftware.b4a.keywords.Common.SinD(_startingdegree+_b-_gap)),(float) (_cy+2*_radius*anywheresoftware.b4a.keywords.Common.CosD(_startingdegree+_b-_gap)));
RDebugUtils.currentLine=2097168;
 //BA.debugLineNum = 2097168;BA.debugLine="p.LineTo(cx, cy)";
_p.LineTo((float) (_cx),(float) (_cy));
RDebugUtils.currentLine=2097169;
 //BA.debugLineNum = 2097169;BA.debugLine="Canvas.ClipPath(p) 'We are limiting the drawings";
_canvas.ClipPath((android.graphics.Path)(_p.getObject()));
RDebugUtils.currentLine=2097170;
 //BA.debugLineNum = 2097170;BA.debugLine="Canvas.DrawCircle(cx, cy, Radius, Color, True, 0)";
_canvas.DrawCircle((float) (_cx),(float) (_cy),(float) (_radius),_color,anywheresoftware.b4a.keywords.Common.True,(float) (0));
RDebugUtils.currentLine=2097171;
 //BA.debugLineNum = 2097171;BA.debugLine="Canvas.RemoveClip";
_canvas.RemoveClip();
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="Return b";
if (true) return _b;
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="End Sub";
return 0f;
}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _createlegend(anywheresoftware.b4a.BA _ba,b4a.example.charts._piedata _pd) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "createlegend", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(null, "createlegend", new Object[] {_ba,_pd}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
float _textheight = 0f;
float _textwidth = 0f;
int _i = 0;
b4a.example.charts._pieitem _it = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub createLegend(PD As PieData) As Bitmap";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="If PD.LegendTextSize = 0 Then PD.LegendTextSize =";
if (_pd.LegendTextSize /*float*/ ==0) { 
_pd.LegendTextSize /*float*/  = (float) (15);};
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Dim textHeight, textWidth As Float";
_textheight = 0f;
_textwidth = 0f;
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="textHeight = PD.Canvas.MeasureStringHeight(\"M\", T";
_textheight = _pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .MeasureStringHeight("M",anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_pd.LegendTextSize /*float*/ );
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="Dim it As PieItem";
_it = new b4a.example.charts._pieitem();
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="it = PD.Items.Get(i)";
_it = (b4a.example.charts._pieitem)(_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="textWidth = Max(textWidth, PD.Canvas.MeasureStri";
_textwidth = (float) (anywheresoftware.b4a.keywords.Common.Max(_textwidth,_pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .MeasureStringWidth(_it.Name /*String*/ ,anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_pd.LegendTextSize /*float*/ )));
 }
};
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="bmp.InitializeMutable(textWidth + 20dip, 10dip +(";
_bmp.InitializeMutable((int) (_textwidth+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),(int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+(_textheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))*_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()));
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="c.Initialize2(bmp)";
_c.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="c.DrawColor(PD.LegendBackColor)";
_c.DrawColor(_pd.LegendBackColor /*int*/ );
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
final int step14 = 1;
final int limit14 = (int) (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="Dim it As PieItem";
_it = new b4a.example.charts._pieitem();
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="it = PD.Items.Get(i)";
_it = (b4a.example.charts._pieitem)(_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="c.DrawText(it.Name, 10dip, (i + 1) * (textHeight";
_c.DrawText(_ba,_it.Name /*String*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),(float) ((_i+1)*(_textheight+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)))),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,_pd.LegendTextSize /*float*/ ,_it.Color /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 }
};
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="Return bmp";
if (true) return _bmp;
RDebugUtils.currentLine=2162709;
 //BA.debugLineNum = 2162709;BA.debugLine="End Sub";
return null;
}
public static String  _drawbarschart(anywheresoftware.b4a.BA _ba,b4a.example.charts._graph _g,b4a.example.charts._bardata _bd,int _backcolor) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "drawbarschart", false))
	 {return ((String) Debug.delegate(null, "drawbarschart", new Object[] {_ba,_g,_bd,_backcolor}));}
b4a.example.charts._linepoint _point = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect = null;
int _numberofbars = 0;
int _i = 0;
int _a = 0;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub DrawBarsChart(G As graph, BD As BarData, BackC";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="If BD.Points.Size = 0 Then";
if (_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .getSize()==0) { 
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="ToastMessageShow(\"Missing bars points.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Missing bars points."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="BD.Canvas.Initialize(BD.Target)";
_bd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .Initialize((android.view.View)(_bd.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="BD.Canvas.DrawColor(BackColor)";
_bd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .DrawColor(_backcolor);
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="Dim point As LinePoint";
_point = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="point = BD.Points.Get(1)";
_point = (b4a.example.charts._linepoint)(_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (1)));
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="If BD.Stacked = False Then";
if (_bd.Stacked /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="drawGraph(G, BD.Canvas, BD.Target, BD.Points, Tr";
_drawgraph(_ba,_g,_bd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ ,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_bd.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject())),_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ ,anywheresoftware.b4a.keywords.Common.True,_bd.BarsWidth /*int*/ );
 }else {
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="drawGraph(G, BD.Canvas, BD.Target, BD.Points, Tr";
_drawgraph(_ba,_g,_bd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ ,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_bd.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject())),_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ ,anywheresoftware.b4a.keywords.Common.True,(int) (_bd.BarsWidth /*int*/ /(double)_point.YArray /*float[]*/ .length));
 };
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="Dim Rect As Rect";
_rect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="Rect.Initialize(0, 0, 0, G.GI.originY)";
_rect.Initialize((int) (0),(int) (0),(int) (0),_g.GI /*b4a.example.charts._graphinternal*/ .originY /*int*/ );
RDebugUtils.currentLine=1507347;
 //BA.debugLineNum = 1507347;BA.debugLine="Dim numberOfBars As Int";
_numberofbars = 0;
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="numberOfBars = point.YArray.Length";
_numberofbars = _point.YArray /*float[]*/ .length;
RDebugUtils.currentLine=1507350;
 //BA.debugLineNum = 1507350;BA.debugLine="For i = 1 To BD.Points.Size - 1";
{
final int step18 = 1;
final int limit18 = (int) (_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (1) ;
for (;_i <= limit18 ;_i = _i + step18 ) {
RDebugUtils.currentLine=1507351;
 //BA.debugLineNum = 1507351;BA.debugLine="point = BD.Points.Get(i)";
_point = (b4a.example.charts._linepoint)(_bd.Points /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=1507352;
 //BA.debugLineNum = 1507352;BA.debugLine="For a = 0 To numberOfBars - 1";
{
final int step20 = 1;
final int limit20 = (int) (_numberofbars-1);
_a = (int) (0) ;
for (;_a <= limit20 ;_a = _a + step20 ) {
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="If BD.Stacked = False Then";
if (_bd.Stacked /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="Rect.Left = G.GI.originX + G.GI.intervalX * i";
_rect.setLeft((int) (_g.GI /*b4a.example.charts._graphinternal*/ .originX /*int*/ +_g.GI /*b4a.example.charts._graphinternal*/ .intervalX /*float*/ *_i+(_a-_numberofbars/(double)2)*_bd.BarsWidth /*int*/ ));
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="Rect.Right = Rect.Left + BD.BarsWidth";
_rect.setRight((int) (_rect.getLeft()+_bd.BarsWidth /*int*/ ));
RDebugUtils.currentLine=1507356;
 //BA.debugLineNum = 1507356;BA.debugLine="If G.YStart < 0 And G.YEnd > 0 Then";
if (_g.YStart /*float*/ <0 && _g.YEnd /*float*/ >0) { 
RDebugUtils.currentLine=1507357;
 //BA.debugLineNum = 1507357;BA.debugLine="If point.YArray(a) > 0 Then";
if (_point.YArray /*float[]*/ [_a]>0) { 
RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="Rect.Top = calcPointToPixel(point.YArray(a),";
_rect.setTop(_calcpointtopixel(_ba,_point.YArray /*float[]*/ [_a],_g));
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="Rect.Bottom = G.GI.zeroY";
_rect.setBottom(_g.GI /*b4a.example.charts._graphinternal*/ .zeroY /*int*/ );
 }else {
RDebugUtils.currentLine=1507361;
 //BA.debugLineNum = 1507361;BA.debugLine="Rect.Bottom = calcPointToPixel(point.YArray(";
_rect.setBottom(_calcpointtopixel(_ba,_point.YArray /*float[]*/ [_a],_g));
RDebugUtils.currentLine=1507362;
 //BA.debugLineNum = 1507362;BA.debugLine="Rect.Top = G.GI.zeroY";
_rect.setTop(_g.GI /*b4a.example.charts._graphinternal*/ .zeroY /*int*/ );
 };
 }else {
RDebugUtils.currentLine=1507365;
 //BA.debugLineNum = 1507365;BA.debugLine="Rect.Top = calcPointToPixel(point.YArray(a),";
_rect.setTop(_calcpointtopixel(_ba,_point.YArray /*float[]*/ [_a],_g));
RDebugUtils.currentLine=1507366;
 //BA.debugLineNum = 1507366;BA.debugLine="Rect.Bottom = G.GI.originY";
_rect.setBottom(_g.GI /*b4a.example.charts._graphinternal*/ .originY /*int*/ );
 };
 }else {
RDebugUtils.currentLine=1507369;
 //BA.debugLineNum = 1507369;BA.debugLine="Rect.Left = G.GI.originX + G.GI.intervalX * i";
_rect.setLeft((int) (_g.GI /*b4a.example.charts._graphinternal*/ .originX /*int*/ +_g.GI /*b4a.example.charts._graphinternal*/ .intervalX /*float*/ *_i-_bd.BarsWidth /*int*/ /(double)2));
RDebugUtils.currentLine=1507370;
 //BA.debugLineNum = 1507370;BA.debugLine="Rect.Right = Rect.Left + BD.BarsWidth";
_rect.setRight((int) (_rect.getLeft()+_bd.BarsWidth /*int*/ ));
RDebugUtils.currentLine=1507371;
 //BA.debugLineNum = 1507371;BA.debugLine="If a = 0 Then";
if (_a==0) { 
RDebugUtils.currentLine=1507372;
 //BA.debugLineNum = 1507372;BA.debugLine="Rect.Top = calcPointToPixel(0, G)";
_rect.setTop(_calcpointtopixel(_ba,(float) (0),_g));
 };
RDebugUtils.currentLine=1507374;
 //BA.debugLineNum = 1507374;BA.debugLine="Rect.Bottom = Rect.Top";
_rect.setBottom(_rect.getTop());
RDebugUtils.currentLine=1507375;
 //BA.debugLineNum = 1507375;BA.debugLine="Rect.Top = Rect.Bottom + calcPointToPixel(poin";
_rect.setTop((int) (_rect.getBottom()+_calcpointtopixel(_ba,_point.YArray /*float[]*/ [_a],_g)-_g.GI /*b4a.example.charts._graphinternal*/ .originY /*int*/ ));
 };
RDebugUtils.currentLine=1507377;
 //BA.debugLineNum = 1507377;BA.debugLine="BD.Canvas.DrawRect(Rect, BD.BarsColors.Get(a),";
_bd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .DrawRect((android.graphics.Rect)(_rect.getObject()),(int)(BA.ObjectToNumber(_bd.BarsColors /*anywheresoftware.b4a.objects.collections.List*/ .Get(_a))),anywheresoftware.b4a.keywords.Common.True,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 }
};
 }
};
RDebugUtils.currentLine=1507380;
 //BA.debugLineNum = 1507380;BA.debugLine="BD.Target.Invalidate";
_bd.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .Invalidate();
RDebugUtils.currentLine=1507381;
 //BA.debugLineNum = 1507381;BA.debugLine="End Sub";
return "";
}
public static String  _drawgraph(anywheresoftware.b4a.BA _ba,b4a.example.charts._graph _g,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,anywheresoftware.b4a.objects.ConcreteViewWrapper _target,anywheresoftware.b4a.objects.collections.List _points,boolean _bars,int _barswidth) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "drawgraph", false))
	 {return ((String) Debug.delegate(null, "drawgraph", new Object[] {_ba,_g,_canvas,_target,_points,_bars,_barswidth}));}
b4a.example.charts._graphinternal _gi = null;
b4a.example.charts._linepoint _p = null;
int _i = 0;
int _y = 0;
float _yvalue = 0f;
int _x = 0;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub drawGraph (G As graph, Canvas As Canvas, Targe";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim GI As GraphInternal";
_gi = new b4a.example.charts._graphinternal();
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="G.GI = GI";
_g.GI /*b4a.example.charts._graphinternal*/  = _gi;
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="GI.Initialize";
_gi.Initialize();
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="GI.maxY = 40dip";
_gi.maxY /*int*/  = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40));
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="GI.originX = 50dip";
_gi.originX /*int*/  = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50));
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="GI.originY = Target.Height - 60dip";
_gi.originY /*int*/  = (int) (_target.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="GI.gw = Target.Width - 70dip 'graph width";
_gi.gw /*int*/  = (int) (_target.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (70)));
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="GI.gh = GI.originY - GI.maxY 'graph height";
_gi.gh /*int*/  = (int) (_gi.originY /*int*/ -_gi.maxY /*int*/ );
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="If G.YStart < 0 And G.YEnd > 0 Then";
if (_g.YStart /*float*/ <0 && _g.YEnd /*float*/ >0) { 
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="GI.zeroY = GI.maxY + GI.gh * G.YEnd / (G.YEnd -";
_gi.zeroY /*int*/  = (int) (_gi.maxY /*int*/ +_gi.gh /*int*/ *_g.YEnd /*float*/ /(double)(_g.YEnd /*float*/ -_g.YStart /*float*/ ));
 }else {
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="GI.zeroY = GI.originY";
_gi.zeroY /*int*/  = _gi.originY /*int*/ ;
 };
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="If Bars Then";
if (_bars) { 
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="Dim p As LinePoint";
_p = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1572880;
 //BA.debugLineNum = 1572880;BA.debugLine="p = Points.Get(1)";
_p = (b4a.example.charts._linepoint)(_points.Get((int) (1)));
RDebugUtils.currentLine=1572881;
 //BA.debugLineNum = 1572881;BA.debugLine="GI.intervalX = (GI.gw - p.YArray.Length / 2 * Ba";
_gi.intervalX /*float*/  = (float) ((_gi.gw /*int*/ -_p.YArray /*float[]*/ .length/(double)2*_barswidth)/(double)(_points.getSize()-1));
 }else {
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="GI.intervalX = GI.gw / (Points.Size - 1)";
_gi.intervalX /*float*/  = (float) (_gi.gw /*int*/ /(double)(_points.getSize()-1));
 };
RDebugUtils.currentLine=1572886;
 //BA.debugLineNum = 1572886;BA.debugLine="Canvas.DrawLine(GI.originX, GI.originY + 2dip, GI";
_canvas.DrawLine((float) (_gi.originX /*int*/ ),(float) (_gi.originY /*int*/ +anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(float) (_gi.originX /*int*/ ),(float) (_gi.maxY /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="For i = 0 To (G.YEnd - G.YStart) / G.Yinterval +";
{
final int step22 = 1;
final int limit22 = (int) ((_g.YEnd /*float*/ -_g.YStart /*float*/ )/(double)_g.YInterval /*float*/ +1);
_i = (int) (0) ;
for (;_i <= limit22 ;_i = _i + step22 ) {
RDebugUtils.currentLine=1572888;
 //BA.debugLineNum = 1572888;BA.debugLine="Dim y As Int";
_y = 0;
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="Dim yValue As Float";
_yvalue = 0f;
RDebugUtils.currentLine=1572890;
 //BA.debugLineNum = 1572890;BA.debugLine="yValue = G.YStart + G.YInterval * i";
_yvalue = (float) (_g.YStart /*float*/ +_g.YInterval /*float*/ *_i);
RDebugUtils.currentLine=1572891;
 //BA.debugLineNum = 1572891;BA.debugLine="If yValue > G.YEnd Then Continue";
if (_yvalue>_g.YEnd /*float*/ ) { 
if (true) continue;};
RDebugUtils.currentLine=1572892;
 //BA.debugLineNum = 1572892;BA.debugLine="y = calcPointToPixel(yValue, G)";
_y = _calcpointtopixel(_ba,_yvalue,_g);
RDebugUtils.currentLine=1572893;
 //BA.debugLineNum = 1572893;BA.debugLine="Canvas.DrawLine(GI.originX, y, GI.originX - 5dip";
_canvas.DrawLine((float) (_gi.originX /*int*/ ),(float) (_y),(float) (_gi.originX /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),(float) (_y),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1572894;
 //BA.debugLineNum = 1572894;BA.debugLine="If i < (G.YEnd - G.YStart) / G.Yinterval Then";
if (_i<(_g.YEnd /*float*/ -_g.YStart /*float*/ )/(double)_g.YInterval /*float*/ ) { 
RDebugUtils.currentLine=1572895;
 //BA.debugLineNum = 1572895;BA.debugLine="Canvas.DrawLine(GI.originX, y, GI.originX + GI.";
_canvas.DrawLine((float) (_gi.originX /*int*/ ),(float) (_y),(float) (_gi.originX /*int*/ +_gi.gw /*int*/ ),(float) (_y),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 }else {
RDebugUtils.currentLine=1572897;
 //BA.debugLineNum = 1572897;BA.debugLine="Canvas.DrawLine(GI.originX, y, GI.originX + GI.";
_canvas.DrawLine((float) (_gi.originX /*int*/ ),(float) (_y),(float) (_gi.originX /*int*/ +_gi.gw /*int*/ ),(float) (_y),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 };
RDebugUtils.currentLine=1572899;
 //BA.debugLineNum = 1572899;BA.debugLine="Canvas.DrawText(NumberFormat(yValue, 1, 2), GI.o";
_canvas.DrawText(_ba,anywheresoftware.b4a.keywords.Common.NumberFormat(_yvalue,(int) (1),(int) (2)),(float) (_gi.originX /*int*/ -anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8))),(float) (_y+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,(float) (12),_g.AxisColor /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"));
 }
};
RDebugUtils.currentLine=1572902;
 //BA.debugLineNum = 1572902;BA.debugLine="Canvas.DrawText(G.Title, Target.Width / 2, 30dip,";
_canvas.DrawText(_ba,_g.Title /*String*/ ,(float) (_target.getWidth()/(double)2),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD,(float) (15),_g.AxisColor /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=1572903;
 //BA.debugLineNum = 1572903;BA.debugLine="Canvas.DrawText(G.XAxis, Target.Width / 2, GI.ori";
_canvas.DrawText(_ba,_g.XAxis /*String*/ ,(float) (_target.getWidth()/(double)2),(float) (_gi.originY /*int*/ +anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (45))),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,(float) (14),_g.AxisColor /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=1572904;
 //BA.debugLineNum = 1572904;BA.debugLine="Canvas.DrawTextRotated(G.YAxis, 15dip, Target.Hei";
_canvas.DrawTextRotated(_ba,_g.YAxis /*String*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15))),(float) (_target.getHeight()/(double)2),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,(float) (14),_g.AxisColor /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"),(float) (-90));
RDebugUtils.currentLine=1572906;
 //BA.debugLineNum = 1572906;BA.debugLine="Canvas.DrawLine(GI.originX, GI.originY, GI.origin";
_canvas.DrawLine((float) (_gi.originX /*int*/ ),(float) (_gi.originY /*int*/ ),(float) (_gi.originX /*int*/ +_gi.gw /*int*/ ),(float) (_gi.originY /*int*/ ),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1572907;
 //BA.debugLineNum = 1572907;BA.debugLine="For i = 0 To Points.Size - 1";
{
final int step40 = 1;
final int limit40 = (int) (_points.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit40 ;_i = _i + step40 ) {
RDebugUtils.currentLine=1572908;
 //BA.debugLineNum = 1572908;BA.debugLine="Dim p As LinePoint";
_p = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1572909;
 //BA.debugLineNum = 1572909;BA.debugLine="p = Points.Get(i)";
_p = (b4a.example.charts._linepoint)(_points.Get(_i));
RDebugUtils.currentLine=1572910;
 //BA.debugLineNum = 1572910;BA.debugLine="If p.ShowTick Then";
if (_p.ShowTick /*boolean*/ ) { 
RDebugUtils.currentLine=1572911;
 //BA.debugLineNum = 1572911;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=1572912;
 //BA.debugLineNum = 1572912;BA.debugLine="x = GI.originX + i * GI.intervalX";
_x = (int) (_gi.originX /*int*/ +_i*_gi.intervalX /*float*/ );
RDebugUtils.currentLine=1572913;
 //BA.debugLineNum = 1572913;BA.debugLine="Canvas.DrawLine(x, GI.originY, x, GI.originY +";
_canvas.DrawLine((float) (_x),(float) (_gi.originY /*int*/ ),(float) (_x),(float) (_gi.originY /*int*/ +anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5))),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1572914;
 //BA.debugLineNum = 1572914;BA.debugLine="If Bars = False Then";
if (_bars==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1572915;
 //BA.debugLineNum = 1572915;BA.debugLine="If i < Points.Size - 1 Then";
if (_i<_points.getSize()-1) { 
RDebugUtils.currentLine=1572916;
 //BA.debugLineNum = 1572916;BA.debugLine="Canvas.DrawLine(x, GI.originY, x, GI.maxY, G.";
_canvas.DrawLine((float) (_x),(float) (_gi.originY /*int*/ ),(float) (_x),(float) (_gi.maxY /*int*/ ),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 }else {
RDebugUtils.currentLine=1572918;
 //BA.debugLineNum = 1572918;BA.debugLine="Canvas.DrawLine(x, GI.originY, x, GI.maxY, G.";
_canvas.DrawLine((float) (_x),(float) (_gi.originY /*int*/ ),(float) (_x),(float) (_gi.maxY /*int*/ ),_g.AxisColor /*int*/ ,(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 };
 };
RDebugUtils.currentLine=1572921;
 //BA.debugLineNum = 1572921;BA.debugLine="If p.x.Length > 0 Then";
if (_p.X /*String*/ .length()>0) { 
RDebugUtils.currentLine=1572922;
 //BA.debugLineNum = 1572922;BA.debugLine="Canvas.DrawTextRotated(p.x, x, GI.originY + 12";
_canvas.DrawTextRotated(_ba,_p.X /*String*/ ,(float) (_x),(float) (_gi.originY /*int*/ +anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12))),anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT,(float) (12),_g.AxisColor /*int*/ ,BA.getEnumFromString(android.graphics.Paint.Align.class,"RIGHT"),(float) (-45));
 };
 };
 }
};
RDebugUtils.currentLine=1572926;
 //BA.debugLineNum = 1572926;BA.debugLine="End Sub";
return "";
}
public static String  _drawlinechart(anywheresoftware.b4a.BA _ba,b4a.example.charts._graph _g,b4a.example.charts._linedata _ld,int _backcolor) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "drawlinechart", false))
	 {return ((String) Debug.delegate(null, "drawlinechart", new Object[] {_ba,_g,_ld,_backcolor}));}
b4a.example.charts._linepoint _point = null;
float[] _py2 = null;
int _i = 0;
int _a = 0;
float _py = 0f;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub DrawLineChart(G As graph, LD As LineData, Back";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="If LD.Points.Size = 0 Then";
if (_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .getSize()==0) { 
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="ToastMessageShow(\"Missing line points.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Missing line points."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="LD.Canvas.Initialize(LD.Target)";
_ld.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .Initialize((android.view.View)(_ld.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="LD.Canvas.DrawColor(BackColor)";
_ld.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .DrawColor(_backcolor);
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="drawGraph(G, LD.Canvas, LD.Target, LD.Points, Fal";
_drawgraph(_ba,_g,_ld.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ ,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ld.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject())),_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ ,anywheresoftware.b4a.keywords.Common.False,(int) (0));
RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="Dim point As LinePoint";
_point = new b4a.example.charts._linepoint();
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="point = LD.Points.Get(0)";
_point = (b4a.example.charts._linepoint)(_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (0)));
RDebugUtils.currentLine=1835019;
 //BA.debugLineNum = 1835019;BA.debugLine="If point.YArray.Length > 0 Then";
if (_point.YArray /*float[]*/ .length>0) { 
RDebugUtils.currentLine=1835021;
 //BA.debugLineNum = 1835021;BA.debugLine="Dim py2(point.YArray.Length) As Float";
_py2 = new float[_point.YArray /*float[]*/ .length];
;
RDebugUtils.currentLine=1835023;
 //BA.debugLineNum = 1835023;BA.debugLine="For i = 0 To py2.Length - 1";
{
final int step12 = 1;
final int limit12 = (int) (_py2.length-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
RDebugUtils.currentLine=1835024;
 //BA.debugLineNum = 1835024;BA.debugLine="py2(i) = point.YArray(i)";
_py2[_i] = _point.YArray /*float[]*/ [_i];
 }
};
RDebugUtils.currentLine=1835027;
 //BA.debugLineNum = 1835027;BA.debugLine="For i = 1 To LD.Points.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (1) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=1835028;
 //BA.debugLineNum = 1835028;BA.debugLine="point = LD.Points.Get(i)";
_point = (b4a.example.charts._linepoint)(_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=1835029;
 //BA.debugLineNum = 1835029;BA.debugLine="For a = 0 To py2.Length - 1";
{
final int step17 = 1;
final int limit17 = (int) (_py2.length-1);
_a = (int) (0) ;
for (;_a <= limit17 ;_a = _a + step17 ) {
RDebugUtils.currentLine=1835030;
 //BA.debugLineNum = 1835030;BA.debugLine="LD.Canvas.DrawLine(G.GI.originX + G.GI.interva";
_ld.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .DrawLine((float) (_g.GI /*b4a.example.charts._graphinternal*/ .originX /*int*/ +_g.GI /*b4a.example.charts._graphinternal*/ .intervalX /*float*/ *(_i-1)),(float) (_calcpointtopixel(_ba,_py2[_a],_g)),(float) (_g.GI /*b4a.example.charts._graphinternal*/ .originX /*int*/ +_g.GI /*b4a.example.charts._graphinternal*/ .intervalX /*float*/ *_i),(float) (_calcpointtopixel(_ba,_point.YArray /*float[]*/ [_a],_g)),(int)(BA.ObjectToNumber(_ld.LinesColors /*anywheresoftware.b4a.objects.collections.List*/ .Get(_a))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1835031;
 //BA.debugLineNum = 1835031;BA.debugLine="py2(a) = point.YArray(a)";
_py2[_a] = _point.YArray /*float[]*/ [_a];
 }
};
 }
};
 }else {
RDebugUtils.currentLine=1835036;
 //BA.debugLineNum = 1835036;BA.debugLine="Dim py As Float";
_py = 0f;
RDebugUtils.currentLine=1835037;
 //BA.debugLineNum = 1835037;BA.debugLine="py = point.Y";
_py = _point.Y /*float*/ ;
RDebugUtils.currentLine=1835038;
 //BA.debugLineNum = 1835038;BA.debugLine="For i = 1 To LD.Points.Size - 1";
{
final int step25 = 1;
final int limit25 = (int) (_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (1) ;
for (;_i <= limit25 ;_i = _i + step25 ) {
RDebugUtils.currentLine=1835039;
 //BA.debugLineNum = 1835039;BA.debugLine="point = LD.Points.Get(i)";
_point = (b4a.example.charts._linepoint)(_ld.Points /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=1835040;
 //BA.debugLineNum = 1835040;BA.debugLine="LD.Canvas.DrawLine(G.GI.originX + G.GI.interval";
_ld.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .DrawLine((float) (_g.GI /*b4a.example.charts._graphinternal*/ .originX /*int*/ +_g.GI /*b4a.example.charts._graphinternal*/ .intervalX /*float*/ *(_i-1)),(float) (_calcpointtopixel(_ba,_py,_g)),(float) (_g.GI /*b4a.example.charts._graphinternal*/ .originX /*int*/ +_g.GI /*b4a.example.charts._graphinternal*/ .intervalX /*float*/ *_i),(float) (_calcpointtopixel(_ba,_point.Y /*float*/ ,_g)),(int)(BA.ObjectToNumber(_ld.LinesColors /*anywheresoftware.b4a.objects.collections.List*/ .Get((int) (0)))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1835042;
 //BA.debugLineNum = 1835042;BA.debugLine="py = point.Y";
_py = _point.Y /*float*/ ;
 }
};
 };
RDebugUtils.currentLine=1835045;
 //BA.debugLineNum = 1835045;BA.debugLine="LD.Target.Invalidate";
_ld.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .Invalidate();
RDebugUtils.currentLine=1835046;
 //BA.debugLineNum = 1835046;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _drawpie(anywheresoftware.b4a.BA _ba,b4a.example.charts._piedata _pd,int _backcolor,boolean _createlegendbitmap) throws Exception{
RDebugUtils.currentModule="charts";
if (Debug.shouldDelegate(null, "drawpie", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(null, "drawpie", new Object[] {_ba,_pd,_backcolor,_createlegendbitmap}));}
int _radius = 0;
int _total = 0;
int _i = 0;
b4a.example.charts._pieitem _it = null;
float _startingangle = 0f;
int _gapdegrees = 0;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub DrawPie (PD As PieData, BackColor As Int, Crea";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="If PD.Items.Size = 0 Then";
if (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()==0) { 
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="ToastMessageShow(\"Missing pie values.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Missing pie values."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Return";
if (true) return null;
 };
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="PD.Canvas.Initialize(PD.Target)";
_pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .Initialize((android.view.View)(_pd.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()));
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="PD.Canvas.DrawColor(BackColor)";
_pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .DrawColor(_backcolor);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="Dim Radius As Int";
_radius = 0;
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="Radius = Min(PD.Canvas.Bitmap.Width, PD.Canvas.Bi";
_radius = (int) (anywheresoftware.b4a.keywords.Common.Min(_pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .getBitmap().getWidth(),_pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ .getBitmap().getHeight())*0.8/(double)2);
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Dim total As Int";
_total = 0;
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="Dim it As PieItem";
_it = new b4a.example.charts._pieitem();
RDebugUtils.currentLine=2031628;
 //BA.debugLineNum = 2031628;BA.debugLine="it = PD.Items.Get(i)";
_it = (b4a.example.charts._pieitem)(_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="total = total + it.Value";
_total = (int) (_total+_it.Value /*float*/ );
 }
};
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="Dim startingAngle As Float";
_startingangle = 0f;
RDebugUtils.currentLine=2031632;
 //BA.debugLineNum = 2031632;BA.debugLine="startingAngle = 0";
_startingangle = (float) (0);
RDebugUtils.currentLine=2031633;
 //BA.debugLineNum = 2031633;BA.debugLine="Dim GapDegrees As Int";
_gapdegrees = 0;
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="If PD.Items.Size = 1 Then GapDegrees = 0 Else Gap";
if (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()==1) { 
_gapdegrees = (int) (0);}
else {
_gapdegrees = _pd.GapDegrees /*int*/ ;};
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="For i = 0 To PD.Items.Size - 1";
{
final int step19 = 1;
final int limit19 = (int) (_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .getSize()-1);
_i = (int) (0) ;
for (;_i <= limit19 ;_i = _i + step19 ) {
RDebugUtils.currentLine=2031636;
 //BA.debugLineNum = 2031636;BA.debugLine="Dim it As PieItem";
_it = new b4a.example.charts._pieitem();
RDebugUtils.currentLine=2031637;
 //BA.debugLineNum = 2031637;BA.debugLine="it = PD.Items.Get(i)";
_it = (b4a.example.charts._pieitem)(_pd.Items /*anywheresoftware.b4a.objects.collections.List*/ .Get(_i));
RDebugUtils.currentLine=2031638;
 //BA.debugLineNum = 2031638;BA.debugLine="startingAngle = startingAngle + _  			calcSlice(";
_startingangle = (float) (_startingangle+_calcslice(_ba,_pd.Canvas /*anywheresoftware.b4a.objects.drawable.CanvasWrapper*/ ,_radius,_startingangle,(float) (_it.Value /*float*/ /(double)_total),_it.Color /*int*/ ,_gapdegrees));
 }
};
RDebugUtils.currentLine=2031641;
 //BA.debugLineNum = 2031641;BA.debugLine="PD.Target.Invalidate";
_pd.Target /*anywheresoftware.b4a.objects.PanelWrapper*/ .Invalidate();
RDebugUtils.currentLine=2031642;
 //BA.debugLineNum = 2031642;BA.debugLine="If CreateLegendBitmap Then";
if (_createlegendbitmap) { 
RDebugUtils.currentLine=2031643;
 //BA.debugLineNum = 2031643;BA.debugLine="Return createLegend(PD)";
if (true) return _createlegend(_ba,_pd);
 }else {
RDebugUtils.currentLine=2031645;
 //BA.debugLineNum = 2031645;BA.debugLine="Return Null";
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 };
RDebugUtils.currentLine=2031647;
 //BA.debugLineNum = 2031647;BA.debugLine="End Sub";
return null;
}
}