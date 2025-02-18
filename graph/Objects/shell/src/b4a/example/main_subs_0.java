package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(1);
main.mostCurrent._barpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 35;BA.debugLine="Activity.AddView(barPanel, 25dip, 30dip, Activity";
Debug.ShouldStop(4);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._barpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1000)))));
 BA.debugLineNum = 36;BA.debugLine="DrawGraph(Activity,barPanel)";
Debug.ShouldStop(8);
_drawgraph(main.mostCurrent._activity,main.mostCurrent._barpanel);
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,199);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 199;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,196);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 196;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8);
 BA.debugLineNum = 197;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawgraph(RemoteObject _active,RemoteObject _panel) throws Exception{
try {
		Debug.PushSubsStack("DrawGraph (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("drawgraph")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawgraph", _active, _panel);}
RemoteObject _activitypanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _alignleftcenter = RemoteObject.createImmutable(0);
RemoteObject _aligntopcenter = RemoteObject.createImmutable(0);
RemoteObject _title = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _legendpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _color = null;
RemoteObject _legendwidth = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _colorlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _legendlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _graphcanvas = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _maxsale = RemoteObject.createImmutable(0);
RemoteObject _cv = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _totalproducts = RemoteObject.createImmutable(0);
RemoteObject _barsperproduct = RemoteObject.createImmutable(0);
RemoteObject _totalbars = RemoteObject.createImmutable(0);
RemoteObject _gap = RemoteObject.createImmutable(0);
RemoteObject _productgap = RemoteObject.createImmutable(0);
RemoteObject _padding = RemoteObject.createImmutable(0);
RemoteObject _availablewidth = RemoteObject.createImmutable(0);
RemoteObject _barwidth = RemoteObject.createImmutable(0);
RemoteObject _xstart = RemoteObject.createImmutable(0);
RemoteObject _xpos = RemoteObject.createImmutable(0);
RemoteObject _salevalues = null;
int _j = 0;
RemoteObject _sale = RemoteObject.createImmutable(0);
RemoteObject _barheight = RemoteObject.createImmutable(0);
RemoteObject _xbar = RemoteObject.createImmutable(0);
RemoteObject _shadowcolor = RemoteObject.createImmutable(0);
RemoteObject _shadowoffset = RemoteObject.createImmutable(0);
RemoteObject _shadowrect = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _labelypos = RemoteObject.createImmutable(0);
RemoteObject _productlabely = RemoteObject.createImmutable(0);
RemoteObject _productlabelx = RemoteObject.createImmutable(0);
RemoteObject _numlabels = RemoteObject.createImmutable(0);
RemoteObject _labelvalue = RemoteObject.createImmutable(0);
Debug.locals.put("Active", _active);
Debug.locals.put("panel", _panel);
 BA.debugLineNum = 40;BA.debugLine="Sub DrawGraph(Active As Activity,panel As Panel)";
Debug.ShouldStop(128);
 BA.debugLineNum = 43;BA.debugLine="panel.Height = 400dip";
Debug.ShouldStop(1024);
_panel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 400))));
 BA.debugLineNum = 45;BA.debugLine="Dim activityPanel As Panel";
Debug.ShouldStop(4096);
_activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("activityPanel", _activitypanel);
 BA.debugLineNum = 46;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
Debug.ShouldStop(8192);
_activitypanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("activityPanel")));
 BA.debugLineNum = 48;BA.debugLine="activityPanel.Width = 80%x";
Debug.ShouldStop(32768);
_activitypanel.runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),main.mostCurrent.activityBA));
 BA.debugLineNum = 49;BA.debugLine="activityPanel.Height = 250dip";
Debug.ShouldStop(65536);
_activitypanel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 50;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
Debug.ShouldStop(131072);
_activitypanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 70)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211))));
 BA.debugLineNum = 52;BA.debugLine="Dim alignLeftCenter As Int = (Active.Width - acti";
Debug.ShouldStop(524288);
_alignleftcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_active.runMethod(true,"getWidth"),_activitypanel.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignLeftCenter", _alignleftcenter);Debug.locals.put("alignLeftCenter", _alignleftcenter);
 BA.debugLineNum = 53;BA.debugLine="Dim alignTopCenter As Int = (panel.Height - activ";
Debug.ShouldStop(1048576);
_aligntopcenter = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getHeight"),_activitypanel.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("alignTopCenter", _aligntopcenter);Debug.locals.put("alignTopCenter", _aligntopcenter);
 BA.debugLineNum = 55;BA.debugLine="Dim title As Label";
Debug.ShouldStop(4194304);
_title = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("title", _title);
 BA.debugLineNum = 56;BA.debugLine="title.Initialize(\"\")";
Debug.ShouldStop(8388608);
_title.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 57;BA.debugLine="title.Text = \"Total Sales For Companies\"";
Debug.ShouldStop(16777216);
_title.runMethod(true,"setText",BA.ObjectToCharSequence("Total Sales For Companies"));
 BA.debugLineNum = 58;BA.debugLine="title.TextSize = 20";
Debug.ShouldStop(33554432);
_title.runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 59;BA.debugLine="title.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(67108864);
_title.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 60;BA.debugLine="title.Gravity = Gravity.CENTER";
Debug.ShouldStop(134217728);
_title.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 61;BA.debugLine="title.TextColor = Colors.Black";
Debug.ShouldStop(268435456);
_title.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 64;BA.debugLine="Dim legendPanel As Panel";
Debug.ShouldStop(-2147483648);
_legendpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("legendPanel", _legendpanel);
 BA.debugLineNum = 65;BA.debugLine="legendPanel.Initialize(\"\")";
Debug.ShouldStop(1);
_legendpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 66;BA.debugLine="legendPanel.Width = panel.Width";
Debug.ShouldStop(2);
_legendpanel.runMethod(true,"setWidth",_panel.runMethod(true,"getWidth"));
 BA.debugLineNum = 67;BA.debugLine="legendPanel.Height = 30dip";
Debug.ShouldStop(4);
_legendpanel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 68;BA.debugLine="panel.AddView(legendPanel, panel.Width/2, 0, pane";
Debug.ShouldStop(8);
_panel.runVoidMethod ("AddView",(Object)((_legendpanel.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_panel.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 71;BA.debugLine="Dim color() As Int = Array As Int(Colors.Red, Col";
Debug.ShouldStop(64);
_color = RemoteObject.createNewArray("int",new int[] {3},new Object[] {main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"),main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue")});Debug.locals.put("color", _color);Debug.locals.put("color", _color);
 BA.debugLineNum = 72;BA.debugLine="Dim legendWidth As Int = legendPanel.Width / lege";
Debug.ShouldStop(128);
_legendwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_legendpanel.runMethod(true,"getWidth"),main.mostCurrent._legend.getField(true,"length")}, "/",0, 0));Debug.locals.put("legendWidth", _legendwidth);Debug.locals.put("legendWidth", _legendwidth);
 BA.debugLineNum = 74;BA.debugLine="For i = 0 To legend.Length - 1";
Debug.ShouldStop(512);
{
final int step23 = 1;
final int limit23 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._legend.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step23 > 0 && _i <= limit23) || (step23 < 0 && _i >= limit23) ;_i = ((int)(0 + _i + step23))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 75;BA.debugLine="Dim colorLabel As Label";
Debug.ShouldStop(1024);
_colorlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("colorLabel", _colorlabel);
 BA.debugLineNum = 76;BA.debugLine="colorLabel.Initialize(\"\")";
Debug.ShouldStop(2048);
_colorlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 77;BA.debugLine="colorLabel.Color = color(i)";
Debug.ShouldStop(4096);
_colorlabel.runVoidMethod ("setColor",_color.getArrayElement(true,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 78;BA.debugLine="legendPanel.AddView(colorLabel, (legendWidth * i";
Debug.ShouldStop(8192);
_legendpanel.runVoidMethod ("AddView",(Object)((_colorlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendpanel.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 18)))}, "-",1, 1)));
 BA.debugLineNum = 80;BA.debugLine="Dim legendLabel As Label";
Debug.ShouldStop(32768);
_legendlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("legendLabel", _legendlabel);
 BA.debugLineNum = 81;BA.debugLine="legendLabel.Initialize(\"\")";
Debug.ShouldStop(65536);
_legendlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 82;BA.debugLine="legendLabel.Text = legend(i)";
Debug.ShouldStop(131072);
_legendlabel.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._legend.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 83;BA.debugLine="legendLabel.TextColor = Colors.black  ' Set text";
Debug.ShouldStop(262144);
_legendlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 84;BA.debugLine="legendLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(524288);
_legendlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 85;BA.debugLine="legendPanel.AddView(legendLabel, (legendWidth *";
Debug.ShouldStop(1048576);
_legendpanel.runVoidMethod ("AddView",(Object)((_legendlabel.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_legendwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {_legendwidth,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(_legendpanel.runMethod(true,"getHeight")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 89;BA.debugLine="panel.AddView(title, 0, alignTopCenter / 2, panel";
Debug.ShouldStop(16777216);
_panel.runVoidMethod ("AddView",(Object)((_title.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_aligntopcenter,RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(_panel.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 92;BA.debugLine="panel.AddView(activityPanel, alignLeftCenter, ali";
Debug.ShouldStop(134217728);
_panel.runVoidMethod ("AddView",(Object)((_activitypanel.getObject())),(Object)(_alignleftcenter),(Object)(_aligntopcenter),(Object)(_activitypanel.runMethod(true,"getWidth")),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 95;BA.debugLine="Dim graphCanvas As Canvas";
Debug.ShouldStop(1073741824);
_graphcanvas = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("graphCanvas", _graphcanvas);
 BA.debugLineNum = 96;BA.debugLine="graphCanvas.Initialize(activityPanel)";
Debug.ShouldStop(-2147483648);
_graphcanvas.runVoidMethod ("Initialize",(Object)((_activitypanel.getObject())));
 BA.debugLineNum = 99;BA.debugLine="Dim maxSale As Int = 400000";
Debug.ShouldStop(4);
_maxsale = BA.numberCast(int.class, 400000);Debug.locals.put("maxSale", _maxsale);Debug.locals.put("maxSale", _maxsale);
 BA.debugLineNum = 101;BA.debugLine="Dim cv As Canvas";
Debug.ShouldStop(16);
_cv = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cv", _cv);
 BA.debugLineNum = 102;BA.debugLine="cv.Initialize(panel)";
Debug.ShouldStop(32);
_cv.runVoidMethod ("Initialize",(Object)((_panel.getObject())));
 BA.debugLineNum = 104;BA.debugLine="Dim totalProducts As Int = sales.Length";
Debug.ShouldStop(128);
_totalproducts = main._sales.getField(true,"length");Debug.locals.put("totalProducts", _totalproducts);Debug.locals.put("totalProducts", _totalproducts);
 BA.debugLineNum = 105;BA.debugLine="Dim barsPerProduct As Int = 3 ' Since there are 3";
Debug.ShouldStop(256);
_barsperproduct = BA.numberCast(int.class, 3);Debug.locals.put("barsPerProduct", _barsperproduct);Debug.locals.put("barsPerProduct", _barsperproduct);
 BA.debugLineNum = 106;BA.debugLine="Dim totalBars As Int = totalProducts * barsPerPro";
Debug.ShouldStop(512);
_totalbars = RemoteObject.solve(new RemoteObject[] {_totalproducts,_barsperproduct}, "*",0, 1);Debug.locals.put("totalBars", _totalbars);Debug.locals.put("totalBars", _totalbars);
 BA.debugLineNum = 107;BA.debugLine="Dim gap As Int = 5dip";
Debug.ShouldStop(1024);
_gap = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)));Debug.locals.put("gap", _gap);Debug.locals.put("gap", _gap);
 BA.debugLineNum = 108;BA.debugLine="Dim productGap As Int = 15dip";
Debug.ShouldStop(2048);
_productgap = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)));Debug.locals.put("productGap", _productgap);Debug.locals.put("productGap", _productgap);
 BA.debugLineNum = 109;BA.debugLine="Dim padding As Int = 20dip";
Debug.ShouldStop(4096);
_padding = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("padding", _padding);Debug.locals.put("padding", _padding);
 BA.debugLineNum = 110;BA.debugLine="Dim availableWidth As Int = activityPanel.Width -";
Debug.ShouldStop(8192);
_availablewidth = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_padding,RemoteObject.createImmutable(2)}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1)),_productgap}, "*",0, 1)),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_totalbars,_totalproducts}, "-",1, 1)),_gap}, "*",0, 1))}, "---",3, 1);Debug.locals.put("availableWidth", _availablewidth);Debug.locals.put("availableWidth", _availablewidth);
 BA.debugLineNum = 112;BA.debugLine="Dim barWidth As Int = availableWidth / totalBars";
Debug.ShouldStop(32768);
_barwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_availablewidth,_totalbars}, "/",0, 0));Debug.locals.put("barWidth", _barwidth);Debug.locals.put("barWidth", _barwidth);
 BA.debugLineNum = 114;BA.debugLine="Dim xStart As Int = padding ' Start position afte";
Debug.ShouldStop(131072);
_xstart = _padding;Debug.locals.put("xStart", _xstart);Debug.locals.put("xStart", _xstart);
 BA.debugLineNum = 116;BA.debugLine="For i = 0 To totalProducts - 1";
Debug.ShouldStop(524288);
{
final int step51 = 1;
final int limit51 = RemoteObject.solve(new RemoteObject[] {_totalproducts,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step51 > 0 && _i <= limit51) || (step51 < 0 && _i >= limit51) ;_i = ((int)(0 + _i + step51))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 117;BA.debugLine="Dim xPos As Int = xStart + i * (barsPerProduct *";
Debug.ShouldStop(1048576);
_xpos = RemoteObject.solve(new RemoteObject[] {_xstart,RemoteObject.createImmutable(_i),(RemoteObject.solve(new RemoteObject[] {_barsperproduct,(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1)),_productgap}, "*+",1, 1))}, "+*",1, 1);Debug.locals.put("xPos", _xpos);Debug.locals.put("xPos", _xpos);
 BA.debugLineNum = 119;BA.debugLine="Dim saleValues() As Int = Array As Int(sales(i),";
Debug.ShouldStop(4194304);
_salevalues = RemoteObject.createNewArray("int",new int[] {3},new Object[] {main._sales.getArrayElement(true,BA.numberCast(int.class, _i)),main._sales1.getArrayElement(true,BA.numberCast(int.class, _i)),main._sales2.getArrayElement(true,BA.numberCast(int.class, _i))});Debug.locals.put("saleValues", _salevalues);Debug.locals.put("saleValues", _salevalues);
 BA.debugLineNum = 121;BA.debugLine="For j = 0 To barsPerProduct - 1";
Debug.ShouldStop(16777216);
{
final int step54 = 1;
final int limit54 = RemoteObject.solve(new RemoteObject[] {_barsperproduct,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step54 > 0 && _j <= limit54) || (step54 < 0 && _j >= limit54) ;_j = ((int)(0 + _j + step54))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 122;BA.debugLine="Dim sale As Int = saleValues(j)";
Debug.ShouldStop(33554432);
_sale = _salevalues.getArrayElement(true,BA.numberCast(int.class, _j));Debug.locals.put("sale", _sale);Debug.locals.put("sale", _sale);
 BA.debugLineNum = 123;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * activ";
Debug.ShouldStop(67108864);
_barheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_sale,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0));Debug.locals.put("barHeight", _barheight);Debug.locals.put("barHeight", _barheight);
 BA.debugLineNum = 124;BA.debugLine="Dim xBar As Int = xPos + j * (barWidth + gap)";
Debug.ShouldStop(134217728);
_xbar = RemoteObject.solve(new RemoteObject[] {_xpos,RemoteObject.createImmutable(_j),(RemoteObject.solve(new RemoteObject[] {_barwidth,_gap}, "+",1, 1))}, "+*",1, 1);Debug.locals.put("xBar", _xbar);Debug.locals.put("xBar", _xbar);
 BA.debugLineNum = 126;BA.debugLine="Dim shadowColor As Int = Colors.ARGB(100, 50, 5";
Debug.ShouldStop(536870912);
_shadowcolor = main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 50)));Debug.locals.put("shadowColor", _shadowcolor);Debug.locals.put("shadowColor", _shadowcolor);
 BA.debugLineNum = 127;BA.debugLine="Dim shadowOffset As Int = 3dip";
Debug.ShouldStop(1073741824);
_shadowoffset = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3)));Debug.locals.put("shadowOffset", _shadowoffset);Debug.locals.put("shadowOffset", _shadowoffset);
 BA.debugLineNum = 128;BA.debugLine="Dim shadowRect As Rect";
Debug.ShouldStop(-2147483648);
_shadowrect = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("shadowRect", _shadowrect);
 BA.debugLineNum = 129;BA.debugLine="shadowRect.Initialize(xBar + shadowOffset, acti";
Debug.ShouldStop(1);
_shadowrect.runVoidMethod ("Initialize",(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_shadowoffset}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,_shadowoffset}, "-+",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth,_shadowoffset}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_shadowoffset}, "+",1, 1)));
 BA.debugLineNum = 130;BA.debugLine="graphCanvas.DrawRect(shadowRect, shadowColor, T";
Debug.ShouldStop(2);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_shadowrect.getObject())),(Object)(_shadowcolor),(Object)(main.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 133;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(16);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 134;BA.debugLine="r.Initialize(xBar, activityPanel.Height - barHe";
Debug.ShouldStop(32);
_r.runVoidMethod ("Initialize",(Object)(_xbar),(Object)(RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_xbar,_barwidth}, "+",1, 1)),(Object)(_activitypanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 135;BA.debugLine="graphCanvas.DrawRect(r, color(j), True, 2dip)";
Debug.ShouldStop(64);
_graphcanvas.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(_color.getArrayElement(true,BA.numberCast(int.class, _j))),(Object)(main.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2))))));
 BA.debugLineNum = 138;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - b";
Debug.ShouldStop(512);
_labelypos = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_barheight,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "--",2, 1);Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 139;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sal";
Debug.ShouldStop(1024);
_graphcanvas.runVoidMethod ("DrawText",main.mostCurrent.activityBA,(Object)(_formatnumberwithsuffix(_sale)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xbar,(RemoteObject.solve(new RemoteObject[] {_barwidth,RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(BA.numberCast(float.class, _labelypos)),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 10)),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 141;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
Debug.ShouldStop(4096);
_productlabely = RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),_aligntopcenter,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "++",2, 1);Debug.locals.put("productLabelY", _productlabely);Debug.locals.put("productLabelY", _productlabely);
 BA.debugLineNum = 142;BA.debugLine="Dim productLabelX As Int = alignLeftCenter + 50d";
Debug.ShouldStop(8192);
_productlabelx = RemoteObject.solve(new RemoteObject[] {_alignleftcenter,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "+",1, 1);Debug.locals.put("productLabelX", _productlabelx);Debug.locals.put("productLabelX", _productlabelx);
 BA.debugLineNum = 143;BA.debugLine="cv.DrawText(product(i), xPos + productLabelX, pr";
Debug.ShouldStop(16384);
_cv.runVoidMethod ("DrawText",main.mostCurrent.activityBA,(Object)(main.mostCurrent._product.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_xpos,_productlabelx}, "+",1, 1))),(Object)(BA.numberCast(float.class, _productlabely)),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 12)),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("CENTER"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 146;BA.debugLine="Dim numLabels As Int = 10";
Debug.ShouldStop(131072);
_numlabels = BA.numberCast(int.class, 10);Debug.locals.put("numLabels", _numlabels);Debug.locals.put("numLabels", _numlabels);
 BA.debugLineNum = 147;BA.debugLine="For i = 0 To numLabels";
Debug.ShouldStop(262144);
{
final int step74 = 1;
final int limit74 = _numlabels.<Integer>get().intValue();
_i = 0 ;
for (;(step74 > 0 && _i <= limit74) || (step74 < 0 && _i >= limit74) ;_i = ((int)(0 + _i + step74))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 148;BA.debugLine="Dim labelValue As Int = (maxSale / numLabels) *";
Debug.ShouldStop(524288);
_labelvalue = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_maxsale,_numlabels}, "/",0, 0)),RemoteObject.createImmutable(_i)}, "*",0, 0));Debug.locals.put("labelValue", _labelvalue);Debug.locals.put("labelValue", _labelvalue);
 BA.debugLineNum = 149;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
Debug.ShouldStop(1048576);
_labelypos = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_activitypanel.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_labelvalue,_maxsale}, "/",0, 0)),_activitypanel.runMethod(true,"getHeight")}, "*",0, 0))}, "-",1, 0));Debug.locals.put("labelYPos", _labelypos);Debug.locals.put("labelYPos", _labelypos);
 BA.debugLineNum = 151;BA.debugLine="cv.DrawText(FormatNumberWithSuffix(labelValue),";
Debug.ShouldStop(4194304);
_cv.runVoidMethod ("DrawText",main.mostCurrent.activityBA,(Object)(_formatnumberwithsuffix(_labelvalue)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_alignleftcenter,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))}, "-",1, 1))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_labelypos,_aligntopcenter,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "++",2, 1))),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(BA.numberCast(float.class, 10)),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black")),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),RemoteObject.createImmutable("LEFT"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawwrappedtextrotated(RemoteObject _canvas,RemoteObject _text,RemoteObject _x,RemoteObject _y,RemoteObject _maxwidth,RemoteObject _fontsize,RemoteObject _color,RemoteObject _alignment,RemoteObject _angle) throws Exception{
try {
		Debug.PushSubsStack("DrawWrappedTextRotated (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,155);
if (RapidSub.canDelegate("drawwrappedtextrotated")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawwrappedtextrotated", _canvas, _text, _x, _y, _maxwidth, _fontsize, _color, _alignment, _angle);}
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
 BA.debugLineNum = 155;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 156;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
Debug.ShouldStop(134217728);
_words = main.mostCurrent.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(" ")),(Object)(_text));Debug.locals.put("words", _words);Debug.locals.put("words", _words);
 BA.debugLineNum = 157;BA.debugLine="Dim line As String = \"\"";
Debug.ShouldStop(268435456);
_line = BA.ObjectToString("");Debug.locals.put("line", _line);Debug.locals.put("line", _line);
 BA.debugLineNum = 158;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
Debug.ShouldStop(536870912);
_lineheight = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)));Debug.locals.put("lineHeight", _lineheight);Debug.locals.put("lineHeight", _lineheight);
 BA.debugLineNum = 159;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
Debug.ShouldStop(1073741824);
_originaly = _y;Debug.locals.put("originalY", _originaly);Debug.locals.put("originalY", _originaly);
 BA.debugLineNum = 161;BA.debugLine="For Each word As String In words";
Debug.ShouldStop(1);
{
final RemoteObject group5 = _words;
final int groupLen5 = group5.getField(true,"length").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5.getArrayElement(true,RemoteObject.createImmutable(index5));Debug.locals.put("word", _word);
Debug.locals.put("word", _word);
 BA.debugLineNum = 162;BA.debugLine="Dim testLine As String = line & word & \" \"";
Debug.ShouldStop(2);
_testline = RemoteObject.concat(_line,_word,RemoteObject.createImmutable(" "));Debug.locals.put("testLine", _testline);Debug.locals.put("testLine", _testline);
 BA.debugLineNum = 163;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
Debug.ShouldStop(4);
_textwidth = BA.numberCast(int.class, _canvas.runMethod(true,"MeasureStringWidth",(Object)(_testline),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE")),(Object)(_fontsize)));Debug.locals.put("textWidth", _textwidth);Debug.locals.put("textWidth", _textwidth);
 BA.debugLineNum = 165;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",_textwidth,BA.numberCast(double.class, _maxwidth)) && RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 167;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
Debug.ShouldStop(64);
_canvas.runVoidMethod ("DrawTextRotated",main.mostCurrent.activityBA,(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 168;BA.debugLine="y = y + lineHeight ' Move to next line";
Debug.ShouldStop(128);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 BA.debugLineNum = 169;BA.debugLine="line = word & \" \" ' Start new line";
Debug.ShouldStop(256);
_line = RemoteObject.concat(_word,RemoteObject.createImmutable(" "));Debug.locals.put("line", _line);
 }else {
 BA.debugLineNum = 171;BA.debugLine="line = testLine ' Add word to current line";
Debug.ShouldStop(1024);
_line = _testline;Debug.locals.put("line", _line);
 };
 }
}Debug.locals.put("word", _word);
;
 BA.debugLineNum = 176;BA.debugLine="If line <> \"\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("!",_line,BA.ObjectToString(""))) { 
 BA.debugLineNum = 177;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
Debug.ShouldStop(65536);
_canvas.runVoidMethod ("DrawTextRotated",main.mostCurrent.activityBA,(Object)(_line),(Object)(BA.numberCast(float.class, _x)),(Object)(BA.numberCast(float.class, _y)),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD")),(Object)(_fontsize),(Object)(_color),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Paint.Align"),_alignment)),(Object)(_angle));
 BA.debugLineNum = 178;BA.debugLine="y = y + lineHeight ' Move final Y position";
Debug.ShouldStop(131072);
_y = RemoteObject.solve(new RemoteObject[] {_y,_lineheight}, "+",1, 1);Debug.locals.put("y", _y);
 };
 BA.debugLineNum = 182;BA.debugLine="Return y - originalY";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.solve(new RemoteObject[] {_y,_originaly}, "-",1, 1);
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _formatnumberwithsuffix(RemoteObject _number) throws Exception{
try {
		Debug.PushSubsStack("FormatNumberWithSuffix (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,185);
if (RapidSub.canDelegate("formatnumberwithsuffix")) { return b4a.example.main.remoteMe.runUserSub(false, "main","formatnumberwithsuffix", _number);}
Debug.locals.put("number", _number);
 BA.debugLineNum = 185;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="If number >= 1000000 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000000))) { 
 BA.debugLineNum = 187;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.concat(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("M"));
 }else 
{ BA.debugLineNum = 188;BA.debugLine="Else If number >= 1000 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",_number,BA.numberCast(double.class, 1000))) { 
 BA.debugLineNum = 189;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
Debug.ShouldStop(268435456);
if (true) return RemoteObject.concat(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(RemoteObject.solve(new RemoteObject[] {_number,RemoteObject.createImmutable(1000)}, "/",0, 0)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))),RemoteObject.createImmutable("k"));
 }else {
 BA.debugLineNum = 191;BA.debugLine="Return NumberFormat(number, 1, 0)";
Debug.ShouldStop(1073741824);
if (true) return main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _number)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 0)));
 }}
;
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim barPanel As Panel";
main.mostCurrent._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim legend() As String = Array As String(\"Sales1\"";
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 //BA.debugLineNum = 17;BA.debugLine="Dim sales() As Int";
main._sales = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 18;BA.debugLine="sales = Array As Int(100000, 120000, 100000, 1200";
main._sales = RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 100000),BA.numberCast(int.class, 120000),BA.numberCast(int.class, 100000),BA.numberCast(int.class, 120000)});
 //BA.debugLineNum = 19;BA.debugLine="Dim sales1() As Int";
main._sales1 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 20;BA.debugLine="sales1 = Array As Int(200000, 130000, 100000, 120";
main._sales1 = RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 200000),BA.numberCast(int.class, 130000),BA.numberCast(int.class, 100000),BA.numberCast(int.class, 120000)});
 //BA.debugLineNum = 21;BA.debugLine="Dim sales2() As Int";
main._sales2 = RemoteObject.createNewArray ("int", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 22;BA.debugLine="sales2 = Array As Int(300000, 320000, 100000, 120";
main._sales2 = RemoteObject.createNewArray("int",new int[] {4},new Object[] {BA.numberCast(int.class, 300000),BA.numberCast(int.class, 320000),BA.numberCast(int.class, 100000),BA.numberCast(int.class, 120000)});
 //BA.debugLineNum = 23;BA.debugLine="Dim product() As String";
main.mostCurrent._product = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});
 //BA.debugLineNum = 24;BA.debugLine="product = Array As String(\"ezware\", \"atlantic\", \"";
main.mostCurrent._product = RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("ezware"),BA.ObjectToString("atlantic"),BA.ObjectToString("gaisano"),RemoteObject.createImmutable("lanueva")});
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}