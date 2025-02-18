package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class bargraph_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Dim ActivityContext As Activity";
bargraph._activitycontext = RemoteObject.createNew ("anywheresoftware.b4a.objects.ActivityWrapper");__ref.setField("_activitycontext",bargraph._activitycontext);
 //BA.debugLineNum = 3;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _drawgraph(RemoteObject __ref,RemoteObject _activity,RemoteObject _barpanel,RemoteObject _sales,RemoteObject _maxsale) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (bargraph) ","bargraph",4,__ref.getField(false, "ba"),__ref,95);
if (RapidSub.canDelegate("drawgraph")) { return __ref.runUserSub(false, "bargraph","drawgraph", __ref, _activity, _barpanel, _sales, _maxsale);}
RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _graphcanvas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _endpadding = RemoteObject.createImmutable(0);
RemoteObject _barwidth = RemoteObject.createImmutable(0);
RemoteObject _cv = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
int _i = 0;
RemoteObject _sale = RemoteObject.createImmutable(0);
RemoteObject _barheight = RemoteObject.createImmutable(0);
RemoteObject _xpos = RemoteObject.createImmutable(0);
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _shadowoffset = RemoteObject.createImmutable(0);
RemoteObject _labelypos = RemoteObject.createImmutable(0);
RemoteObject _productlabely = RemoteObject.createImmutable(0);
RemoteObject _maxwidth = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelvalue = RemoteObject.createImmutable(0);
Debug.locals.put("Activity", _activity);
Debug.locals.put("barPanel", _barpanel);
 BA.debugLineNum = 95;BA.debugLine="Sub DrawGraph(Activity As Activity,barPanel As Pan";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
_barpanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 98;BA.debugLine="barPanel.Height = 380dip";
Debug.ShouldStop(2);
_barpanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 380))));
 BA.debugLineNum = 100;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(8);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 101;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(16);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 103;BA.debugLine="activityPanel.Width = 400dip";
Debug.ShouldStop(64);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400))));
 BA.debugLineNum = 104;BA.debugLine="activityPanel.Height = 200dip";
Debug.ShouldStop(128);
_activitypanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))));
 BA.debugLineNum = 105;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(256);
_activitypanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 107;BA.debugLine="Dim alignLeftCenter As Int = (Activity.Width - ac";
Debug.ShouldStop(1024);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_activity.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 108;BA.debugLine="Dim alignTopCenter As Int = (barPanel.Height - ac";
Debug.ShouldStop(2048);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_barpanel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 110;BA.debugLine="Dim title As Label";
Debug.ShouldStop(8192);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("title", _title);
 BA.debugLineNum = 111;BA.debugLine="title.Initialize(\"\")";
Debug.ShouldStop(16384);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 112;BA.debugLine="title.Text = \"Total Sales For Companies\"";
Debug.ShouldStop(32768);
_title.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales For Companies"));
 BA.debugLineNum = 113;BA.debugLine="title.TextSize = 20";
Debug.ShouldStop(65536);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 114;BA.debugLine="title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(131072);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 115;BA.debugLine="title.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 116;BA.debugLine="title.TextColor = Colors.Black";
Debug.ShouldStop(524288);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 117;BA.debugLine="barPanel.AddView(title,0,alignTopCenter/2,barPane";
Debug.ShouldStop(1048576);
_barpanel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_barpanel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 120;BA.debugLine="barPanel.AddView(activityPanel, alignLeftCenter,";
Debug.ShouldStop(8388608);
_barpanel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 123;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(67108864);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 124;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(134217728);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 127;BA.debugLine="Dim sales() As Int";
Debug.ShouldStop(1073741824);
_sales = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 128;BA.debugLine="sales = Array As Int(1000, 200000, 150000, 300000";
Debug.ShouldStop(-2147483648);
_sales = RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 1000),BA.numberCast(int.class, 200000),BA.numberCast(int.class, 150000),BA.numberCast(int.class, 300000)});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 131;BA.debugLine="Dim maxSale As Int = 400000";
Debug.ShouldStop(4);
_maxsale = BA.numberCast(int.class, 400000);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 133;BA.debugLine="Dim gap As Int = 10dip";
Debug.ShouldStop(16);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 134;BA.debugLine="If sales.Length < 5 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("<",_sales.getField(true,"length"),BA.numberCast(double.class, 5))) { 
 BA.debugLineNum = 135;BA.debugLine="Dim gap As Int = 50dip";
Debug.ShouldStop(64);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 };
 BA.debugLineNum = 138;BA.debugLine="Dim endPadding As Int = 7dip";
Debug.ShouldStop(512);
_endpadding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7)));Debug.locals.put("endPadding", _endpadding);Debug.locals.put("endPadding", _endpadding);
 BA.debugLineNum = 140;BA.debugLine="Dim barWidth As Int = (activityPanel.Width - (sal";
Debug.ShouldStop(2048);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_sales.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)),_gap,_endpadding}, "-*-",2, 1)),_sales.getField(true,"length")}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 142;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(8192);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 143;BA.debugLine="For i = 0 To sales.Length - 1";
Debug.ShouldStop(16384);
{
final int step31 = 1;
final int limit31 = RemoteObject.solve(new RemoteObject[] {_sales.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step31 > 0 && _i <= limit31) || (step31 < 0 && _i >= limit31) ;_i = ((int)(0 + _i + step31))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 144;BA.debugLine="Dim sale As Int = sales(i)";
Debug.ShouldStop(32768);
_sale = _sales.getArrayElement(true,BA.numberCast(int.class, _i));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 147;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * activi";
Debug.ShouldStop(262144);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 150;BA.debugLine="Dim xPos As Int = i * (barWidth + gap)";
Debug.ShouldStop(2097152);
_xpos = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1))}, "*",0, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 151;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(4194304);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 154;BA.debugLine="Dim shadowOffset As Int = 5dip ' Set the offset";
Debug.ShouldStop(33554432);
_shadowoffset = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("shadowOffset", _shadowoffset);Debug.locals.put("shadowOffset", _shadowoffset);
 BA.debugLineNum = 155;BA.debugLine="r.Initialize(xPos + shadowOffset, activityPanel.";
Debug.ShouldStop(67108864);
_r.runVoidMethod ("Initialize",(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_shadowoffset}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,_shadowoffset}, "-+",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_barwidth,_shadowoffset}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_shadowoffset}, "+",1, 1)));
 BA.debugLineNum = 156;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(100, 100, 100";
Debug.ShouldStop(134217728);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 159;BA.debugLine="r.Initialize(xPos, activityPanel.Height - barHei";
Debug.ShouldStop(1073741824);
_r.runVoidMethod ("Initialize",(Object)(_xpos),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 160;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(156, 0, 0), T";
Debug.ShouldStop(-2147483648);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 163;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ba";
Debug.ShouldStop(4);
_labelypos = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1);Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 164;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sale";
Debug.ShouldStop(8);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xpos,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, _labelypos)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 14)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 167;BA.debugLine="cv.Initialize(barPanel)";
Debug.ShouldStop(64);
_cv.runVoidMethod ("Initialize",(Object)((_barpanel.getObject())));
 BA.debugLineNum = 169;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(256);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 171;BA.debugLine="Dim maxWidth As Int = 80dip ' Set max width for";
Debug.ShouldStop(1024);
_maxwidth = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));Debug.locals.put("maxWidth", _maxwidth);Debug.locals.put("maxWidth", _maxwidth);
 BA.debugLineNum = 172;BA.debugLine="DrawWrappedTextRotated(cv, \"Prince Warehouse\" &";
Debug.ShouldStop(2048);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawwrappedtextrotated" /*RemoteObject*/ ,(Object)(_cv),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Prince Warehouse"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(RemoteObject.solve(new RemoteObject[] {(_alignleftcenter),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),_xpos}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {(_productlabely),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(_maxwidth),(Object)(BA.numberCast(float.class, 12)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Red")),(Object)(BA.ObjectToString("CENTER")),(Object)(BA.numberCast(float.class, -(double) (0 + 45))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 174;BA.debugLine="Dim numLabels As Int = 5";
Debug.ShouldStop(8192);
_numlabels = BA.numberCast(int.class, 5);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 175;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(16384);
{
final int step49 = 1;
final int limit49 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step49 > 0 && _i <= limit49) || (step49 < 0 && _i >= limit49) ;_i = ((int)(0 + _i + step49))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 176;BA.debugLine="Dim labelValue As Int = (maxSale / numLabels) *";
Debug.ShouldStop(32768);
_labelvalue = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 177;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
Debug.ShouldStop(65536);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 179;BA.debugLine="cv.DrawText(FormatNumberWithSuffix(labelValue),";
Debug.ShouldStop(262144);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_labelvalue))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 12)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("LEFT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawwrappedtextrotated(RemoteObject __ref,RemoteObject _canvas,RemoteObject _text,RemoteObject _x,RemoteObject _y,RemoteObject _maxwidth,RemoteObject _fontsize,RemoteObject _color,RemoteObject _alignment,RemoteObject _angle) throws Exception{
try {
		Debug.PushSubsStack("DrawWrappedTextRotated (bargraph) ","bargraph",4,__ref.getField(false, "ba"),__ref,193);
if (RapidSub.canDelegate("drawwrappedtextrotated")) { return __ref.runUserSub(false, "bargraph","drawwrappedtextrotated", __ref, _canvas, _text, _x, _y, _maxwidth, _fontsize, _color, _alignment, _angle);}
RemoteObject _words = null;
RemoteObject _line = RemoteObject.createImmutable("");
RemoteObject _lineheight = RemoteObject.createImmutable(0);
RemoteObject _originaly = RemoteObject.createImmutable(0);
RemoteObject _word = RemoteObject.createImmutable("");
RemoteObject _testline = RemoteObject.createImmutable("");
RemoteObject _textwidth = RemoteObject.createImmutable(0);
Debug.locals.put("canvas", _canvas);
Debug.locals.put("text", _text);
Debug.locals.put("x", _x);
Debug.locals.put("y", _y);
Debug.locals.put("maxWidth", _maxwidth);
Debug.locals.put("fontSize", _fontsize);
Debug.locals.put("color", _color);
Debug.locals.put("alignment", _alignment);
Debug.locals.put("angle", _angle);
 BA.debugLineNum = 193;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
Debug.ShouldStop(2);
_words = bargraph.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(" ")),(Object)(_text));Debug.locals.put("words", _words);Debug.locals.put("words", _words);
 BA.debugLineNum = 195;BA.debugLine="Dim line As String = \"\"";
Debug.ShouldStop(4);
_line = BA.ObjectToString("");Debug.locals.put("line", _line);Debug.locals.put("line", _line);
 BA.debugLineNum = 196;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
Debug.ShouldStop(8);
_lineheight = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("lineHeight", _lineheight);Debug.locals.put("lineHeight", _lineheight);
 BA.debugLineNum = 197;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
Debug.ShouldStop(16);
_originaly = _y;Debug.locals.put("originalY", _originaly);Debug.locals.put("originalY", _originaly);
 BA.debugLineNum = 199;BA.debugLine="For Each word As String In words";
Debug.ShouldStop(64);
{
final RemoteObject group5 = _words;
final int groupLen5 = group5.getField(true,"length").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5.getArrayElement(true,RemoteObject.createImmutable(index5));Debug.locals.put("word", _word);
Debug.locals.put("word", _word);
 BA.debugLineNum = 200;BA.debugLine="Dim testLine As String = line & word & \" \"";
Debug.ShouldStop(128);
_testline = RemoteObject.concat(_line,_word,RemoteObject.createImmutable(" "));Debug.locals.put("testLine", _testline);Debug.locals.put("testLine", _testline);
 BA.debugLineNum = 201;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
Debug.ShouldStop(256);
_textwidth = BA.numberCast(int.class, _canvas.runMethod(true,"MeasureStringWidth",(Object)(_testline),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(_fontsize)));Debug.locals.put("textWidth", _textwidth);Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 203;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",_textwidth,BA.numberCast(double.class, _maxwidth)) && RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 205;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
Debug.ShouldStop(4096);
_canvas.runVoidMethod ("DrawTextRotated",__ref.getField(false, "ba"),(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 206;BA.debugLine="y = y + lineHeight ' Move to next line";
Debug.ShouldStop(8192);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 BA.debugLineNum = 207;BA.debugLine="line = word & \" \" ' Start new line";
Debug.ShouldStop(16384);
_line = RemoteObject.concat(_word,RemoteObject.createImmutable(" "));Debug.locals.put("line", _line);
 }else {
 BA.debugLineNum = 209;BA.debugLine="line = testLine ' Add word to current line";
Debug.ShouldStop(65536);
_line = _testline;Debug.locals.put("line", _line);
 };
 }
}Debug.locals.put("word", _word);
;
 BA.debugLineNum = 214;BA.debugLine="If line <> \"\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 215;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
Debug.ShouldStop(4194304);
_canvas.runVoidMethod ("DrawTextRotated",__ref.getField(false, "ba"),(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 216;BA.debugLine="y = y + lineHeight ' Move final Y position";
Debug.ShouldStop(8388608);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 };
 BA.debugLineNum = 220;BA.debugLine="Return y - originalY";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.solve(new RemoteObject[] {_y,_originaly}, "-",1, 1);
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatnumberwithsuffix(RemoteObject __ref,RemoteObject _number) throws Exception{
try {
		Debug.PushSubsStack("FormatNumberWithSuffix (bargraph) ","bargraph",4,__ref.getField(false, "ba"),__ref,183);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return __ref.runUserSub(false, "bargraph","formatnumberwithsuffix", __ref, _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 183;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 185;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 186;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 187;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.concat(bargraph.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 189;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(268435456);
if (true) return bargraph.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _activity,RemoteObject _barpanel,RemoteObject _sales,RemoteObject _maxsale) throws Exception{
try {
		Debug.PushSubsStack("Initialize (bargraph) ","bargraph",4,__ref.getField(false, "ba"),__ref,5);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "bargraph","initialize", __ref, _ba, _activity, _barpanel, _sales, _maxsale);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _graphcanvas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _endpadding = RemoteObject.createImmutable(0);
RemoteObject _barwidth = RemoteObject.createImmutable(0);
RemoteObject _cv = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
int _i = 0;
RemoteObject _sale = RemoteObject.createImmutable(0);
RemoteObject _barheight = RemoteObject.createImmutable(0);
RemoteObject _xpos = RemoteObject.createImmutable(0);
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _shadowoffset = RemoteObject.createImmutable(0);
RemoteObject _labelypos = RemoteObject.createImmutable(0);
RemoteObject _productlabely = RemoteObject.createImmutable(0);
RemoteObject _maxwidth = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelvalue = RemoteObject.createImmutable(0);
Debug.locals.put("ba", _ba);
Debug.locals.put("Activity", _activity);
Debug.locals.put("barPanel", _barpanel);
Debug.locals.put("sales", _sales);
 BA.debugLineNum = 5;BA.debugLine="Public Sub Initialize(Activity As Activity,barPane";
Debug.ShouldStop(16);
 BA.debugLineNum = 7;BA.debugLine="barPanel.Height = 380dip";
Debug.ShouldStop(64);
_barpanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 380))));
 BA.debugLineNum = 9;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(256);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 10;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(512);
_activitypanel.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 12;BA.debugLine="activityPanel.Width = 1000dip";
Debug.ShouldStop(2048);
_activitypanel.runMethod(true,"setWidth",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1000))));
 BA.debugLineNum = 13;BA.debugLine="activityPanel.Height = 200dip";
Debug.ShouldStop(4096);
_activitypanel.runMethod(true,"setHeight",bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200))));
 BA.debugLineNum = 14;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(8192);
_activitypanel.runVoidMethod ("setColor",bargraph.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 16;BA.debugLine="Dim alignLeftCenter As Int = (Activity.Width - ac";
Debug.ShouldStop(32768);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_activity.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 17;BA.debugLine="Dim alignTopCenter As Int = (barPanel.Height - ac";
Debug.ShouldStop(65536);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_barpanel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 19;BA.debugLine="Dim title As Label";
Debug.ShouldStop(262144);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("title", _title);
 BA.debugLineNum = 20;BA.debugLine="title.Initialize(\"\")";
Debug.ShouldStop(524288);
_title.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 21;BA.debugLine="title.Text = \"Total Sales For Companies\"";
Debug.ShouldStop(1048576);
_title.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales For Companies"));
 BA.debugLineNum = 22;BA.debugLine="title.TextSize = 20";
Debug.ShouldStop(2097152);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 23;BA.debugLine="title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(4194304);
_title.runMethod(false,"setTypeface",bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 24;BA.debugLine="title.Gravity = Gravity.CENTER";
Debug.ShouldStop(8388608);
_title.runMethod(true,"setGravity",bargraph.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 25;BA.debugLine="title.TextColor = Colors.Black";
Debug.ShouldStop(16777216);
_title.runMethod(true,"setTextColor",bargraph.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 26;BA.debugLine="barPanel.AddView(title,0,alignTopCenter/2,barPane";
Debug.ShouldStop(33554432);
_barpanel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_barpanel.runMethod(true,"getWidth")),(Object)(bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 29;BA.debugLine="barPanel.AddView(activityPanel, alignLeftCenter,";
Debug.ShouldStop(268435456);
_barpanel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 32;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(-2147483648);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 33;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(1);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 38;BA.debugLine="Dim maxSale As Int = 400000";
Debug.ShouldStop(32);
_maxsale = BA.numberCast(int.class, 400000);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 40;BA.debugLine="Dim gap As Int = 10dip";
Debug.ShouldStop(128);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 41;BA.debugLine="If sales.Length < 5 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("<",_sales.getField(true,"length"),BA.numberCast(double.class, 5))) { 
 BA.debugLineNum = 42;BA.debugLine="Dim gap As Int = 50dip";
Debug.ShouldStop(512);
_gap = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 };
 BA.debugLineNum = 45;BA.debugLine="Dim endPadding As Int = 7dip";
Debug.ShouldStop(4096);
_endpadding = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7)));Debug.locals.put("endPadding", _endpadding);Debug.locals.put("endPadding", _endpadding);
 BA.debugLineNum = 47;BA.debugLine="Dim barWidth As Int = (activityPanel.Width - (sal";
Debug.ShouldStop(16384);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_sales.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)),_gap,_endpadding}, "-*-",2, 1)),_sales.getField(true,"length")}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 49;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(65536);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 50;BA.debugLine="For i = 0 To sales.Length - 1";
Debug.ShouldStop(131072);
{
final int step28 = 1;
final int limit28 = RemoteObject.solve(new RemoteObject[] {_sales.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step28 > 0 && _i <= limit28) || (step28 < 0 && _i >= limit28) ;_i = ((int)(0 + _i + step28))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 51;BA.debugLine="Dim sale As Int = sales(i)";
Debug.ShouldStop(262144);
_sale = _sales.getArrayElement(true,BA.numberCast(int.class, _i));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 54;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * activi";
Debug.ShouldStop(2097152);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 57;BA.debugLine="Dim xPos As Int = i * (barWidth + gap)";
Debug.ShouldStop(16777216);
_xpos = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1))}, "*",0, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 58;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(33554432);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 61;BA.debugLine="Dim shadowOffset As Int = 5dip ' Set the offset";
Debug.ShouldStop(268435456);
_shadowoffset = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("shadowOffset", _shadowoffset);Debug.locals.put("shadowOffset", _shadowoffset);
 BA.debugLineNum = 62;BA.debugLine="r.Initialize(xPos + shadowOffset, activityPanel.";
Debug.ShouldStop(536870912);
_r.runVoidMethod ("Initialize",(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_shadowoffset}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,_shadowoffset}, "-+",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_barwidth,_shadowoffset}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_shadowoffset}, "+",1, 1)));
 BA.debugLineNum = 63;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(100, 100, 100";
Debug.ShouldStop(1073741824);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 100)))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 66;BA.debugLine="r.Initialize(xPos, activityPanel.Height - barHei";
Debug.ShouldStop(2);
_r.runVoidMethod ("Initialize",(Object)(_xpos),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 67;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(156, 0, 0), T";
Debug.ShouldStop(4);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(bargraph.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 156)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 69;BA.debugLine="r.Initialize(xPos + 200, activityPanel.Height -";
Debug.ShouldStop(16);
_r.runVoidMethod ("Initialize",(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,RemoteObject.createImmutable(200)}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(_xpos),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 70;BA.debugLine="graphCanvas.DrawRect(r, Colors.Blue, True, 2dip)";
Debug.ShouldStop(32);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Blue")),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 72;BA.debugLine="r.Initialize(xPos + 400, activityPanel.Height ,";
Debug.ShouldStop(128);
_r.runVoidMethod ("Initialize",(Object)(RemoteObject.solve(new RemoteObject[] {_xpos,RemoteObject.createImmutable(400)}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")),(Object)(_xpos),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 73;BA.debugLine="graphCanvas.DrawRect(r, Colors.Green, True, 2dip";
Debug.ShouldStop(256);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Green")),(Object)(bargraph.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 76;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ba";
Debug.ShouldStop(2048);
_labelypos = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1);Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 77;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sale";
Debug.ShouldStop(4096);
_graphcanvas.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_sale))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xpos,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, _labelypos)),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 14)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 BA.debugLineNum = 80;BA.debugLine="cv.Initialize(barPanel)";
Debug.ShouldStop(32768);
_cv.runVoidMethod ("Initialize",(Object)((_barpanel.getObject())));
 BA.debugLineNum = 82;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(131072);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 84;BA.debugLine="Dim maxWidth As Int = 80dip ' Set max width for";
Debug.ShouldStop(524288);
_maxwidth = bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)));Debug.locals.put("maxWidth", _maxwidth);Debug.locals.put("maxWidth", _maxwidth);
 BA.debugLineNum = 85;BA.debugLine="DrawWrappedTextRotated(cv, \"Prince Warehouse\" &";
Debug.ShouldStop(1048576);
__ref.runClassMethod (b4a.example.bargraph.class, "_drawwrappedtextrotated" /*RemoteObject*/ ,(Object)(_cv),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Prince Warehouse"),(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)))),(Object)(RemoteObject.solve(new RemoteObject[] {(_alignleftcenter),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),_xpos}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {(_productlabely),bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "+",1, 1)),(Object)(_maxwidth),(Object)(BA.numberCast(float.class, 12)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Red")),(Object)(BA.ObjectToString("CENTER")),(Object)(BA.numberCast(float.class, -(double) (0 + 45))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 87;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(4194304);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 88;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(8388608);
{
final int step50 = 1;
final int limit50 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step50 > 0 && _i <= limit50) || (step50 < 0 && _i >= limit50) ;_i = ((int)(0 + _i + step50))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 89;BA.debugLine="Dim labelValue As Int = (maxSale / numLabels) *";
Debug.ShouldStop(16777216);
_labelvalue = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 90;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
Debug.ShouldStop(33554432);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 92;BA.debugLine="cv.DrawText(FormatNumberWithSuffix(labelValue),";
Debug.ShouldStop(134217728);
_cv.runVoidMethod ("DrawText",__ref.getField(false, "ba"),(Object)(__ref.runClassMethod (b4a.example.bargraph.class, "_formatnumberwithsuffix" /*RemoteObject*/ ,(Object)(_labelvalue))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,bargraph.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1))),(Object)(bargraph.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 12)),(Object)(bargraph.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("LEFT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}