package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class bargraph extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.bargraph");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.bargraph.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.ActivityWrapper _activitycontext = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.branch _branch = null;
public b4a.example.device _device = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.bargraph __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,anywheresoftware.b4a.objects.PanelWrapper _barpanel,int[] _sales,int _maxsale) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_activity,_barpanel,_sales,_maxsale}));}
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
anywheresoftware.b4a.objects.LabelWrapper _title = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _gap = 0;
int _endpadding = 0;
int _barwidth = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cv = null;
int _i = 0;
int _sale = 0;
int _barheight = 0;
int _xpos = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
int _shadowoffset = 0;
int _labelypos = 0;
int _productlabely = 0;
int _maxwidth = 0;
int _numlabels = 0;
int _labelvalue = 0;
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Public Sub Initialize(Activity As Activity,barPane";
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="barPanel.Height = 380dip";
_barpanel.setHeight(__c.DipToCurrent((int) (380)));
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="activityPanel.Width = 1000dip";
_activitypanel.setWidth(__c.DipToCurrent((int) (1000)));
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="activityPanel.Height = 200dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (200)));
RDebugUtils.currentLine=5832713;
 //BA.debugLineNum = 5832713;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=5832715;
 //BA.debugLineNum = 5832715;BA.debugLine="Dim alignLeftCenter As Int = (Activity.Width - ac";
_alignleftcenter = (int) ((_activity.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=5832716;
 //BA.debugLineNum = 5832716;BA.debugLine="Dim alignTopCenter As Int = (barPanel.Height - ac";
_aligntopcenter = (int) ((_barpanel.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=5832718;
 //BA.debugLineNum = 5832718;BA.debugLine="Dim title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5832719;
 //BA.debugLineNum = 5832719;BA.debugLine="title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=5832720;
 //BA.debugLineNum = 5832720;BA.debugLine="title.Text = \"Total Sales For Companies\"";
_title.setText(BA.ObjectToCharSequence("Total Sales For Companies"));
RDebugUtils.currentLine=5832721;
 //BA.debugLineNum = 5832721;BA.debugLine="title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=5832722;
 //BA.debugLineNum = 5832722;BA.debugLine="title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=5832723;
 //BA.debugLineNum = 5832723;BA.debugLine="title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=5832724;
 //BA.debugLineNum = 5832724;BA.debugLine="title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=5832725;
 //BA.debugLineNum = 5832725;BA.debugLine="barPanel.AddView(title,0,alignTopCenter/2,barPane";
_barpanel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_barpanel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=5832728;
 //BA.debugLineNum = 5832728;BA.debugLine="barPanel.AddView(activityPanel, alignLeftCenter,";
_barpanel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=5832731;
 //BA.debugLineNum = 5832731;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=5832732;
 //BA.debugLineNum = 5832732;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=5832737;
 //BA.debugLineNum = 5832737;BA.debugLine="Dim maxSale As Int = 400000";
_maxsale = (int) (400000);
RDebugUtils.currentLine=5832739;
 //BA.debugLineNum = 5832739;BA.debugLine="Dim gap As Int = 10dip";
_gap = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=5832740;
 //BA.debugLineNum = 5832740;BA.debugLine="If sales.Length < 5 Then";
if (_sales.length<5) { 
RDebugUtils.currentLine=5832741;
 //BA.debugLineNum = 5832741;BA.debugLine="Dim gap As Int = 50dip";
_gap = __c.DipToCurrent((int) (50));
 };
RDebugUtils.currentLine=5832744;
 //BA.debugLineNum = 5832744;BA.debugLine="Dim endPadding As Int = 7dip";
_endpadding = __c.DipToCurrent((int) (7));
RDebugUtils.currentLine=5832746;
 //BA.debugLineNum = 5832746;BA.debugLine="Dim barWidth As Int = (activityPanel.Width - (sal";
_barwidth = (int) ((_activitypanel.getWidth()-(_sales.length-1)*_gap-_endpadding)/(double)_sales.length);
RDebugUtils.currentLine=5832748;
 //BA.debugLineNum = 5832748;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=5832749;
 //BA.debugLineNum = 5832749;BA.debugLine="For i = 0 To sales.Length - 1";
{
final int step28 = 1;
final int limit28 = (int) (_sales.length-1);
_i = (int) (0) ;
for (;_i <= limit28 ;_i = _i + step28 ) {
RDebugUtils.currentLine=5832750;
 //BA.debugLineNum = 5832750;BA.debugLine="Dim sale As Int = sales(i)";
_sale = _sales[_i];
RDebugUtils.currentLine=5832753;
 //BA.debugLineNum = 5832753;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * activi";
_barheight = (int) ((_sale/(double)_maxsale)*_activitypanel.getHeight());
RDebugUtils.currentLine=5832756;
 //BA.debugLineNum = 5832756;BA.debugLine="Dim xPos As Int = i * (barWidth + gap)";
_xpos = (int) (_i*(_barwidth+_gap));
RDebugUtils.currentLine=5832757;
 //BA.debugLineNum = 5832757;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=5832760;
 //BA.debugLineNum = 5832760;BA.debugLine="Dim shadowOffset As Int = 5dip ' Set the offset";
_shadowoffset = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=5832761;
 //BA.debugLineNum = 5832761;BA.debugLine="r.Initialize(xPos + shadowOffset, activityPanel.";
_r.Initialize((int) (_xpos+_shadowoffset),(int) (_activitypanel.getHeight()-_barheight+_shadowoffset),(int) (_xpos+_barwidth+_shadowoffset),(int) (_activitypanel.getHeight()+_shadowoffset));
RDebugUtils.currentLine=5832762;
 //BA.debugLineNum = 5832762;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(100, 100, 100";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.RGB((int) (100),(int) (100),(int) (100)),__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5832765;
 //BA.debugLineNum = 5832765;BA.debugLine="r.Initialize(xPos, activityPanel.Height - barHei";
_r.Initialize(_xpos,(int) (_activitypanel.getHeight()-_barheight),(int) (_xpos+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=5832766;
 //BA.debugLineNum = 5832766;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(156, 0, 0), T";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.RGB((int) (156),(int) (0),(int) (0)),__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5832768;
 //BA.debugLineNum = 5832768;BA.debugLine="r.Initialize(xPos + 200, activityPanel.Height -";
_r.Initialize((int) (_xpos+200),(int) (_activitypanel.getHeight()-_barheight),_xpos,_activitypanel.getHeight());
RDebugUtils.currentLine=5832769;
 //BA.debugLineNum = 5832769;BA.debugLine="graphCanvas.DrawRect(r, Colors.Blue, True, 2dip)";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.Blue,__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5832771;
 //BA.debugLineNum = 5832771;BA.debugLine="r.Initialize(xPos + 400, activityPanel.Height ,";
_r.Initialize((int) (_xpos+400),_activitypanel.getHeight(),_xpos,_activitypanel.getHeight());
RDebugUtils.currentLine=5832772;
 //BA.debugLineNum = 5832772;BA.debugLine="graphCanvas.DrawRect(r, Colors.Green, True, 2dip";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.Green,__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5832775;
 //BA.debugLineNum = 5832775;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ba";
_labelypos = (int) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=5832776;
 //BA.debugLineNum = 5832776;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sale";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xpos+(_barwidth/(double)2)),(float) (_labelypos),__c.Typeface.MONOSPACE,(float) (14),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=5832779;
 //BA.debugLineNum = 5832779;BA.debugLine="cv.Initialize(barPanel)";
_cv.Initialize((android.view.View)(_barpanel.getObject()));
RDebugUtils.currentLine=5832781;
 //BA.debugLineNum = 5832781;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=5832783;
 //BA.debugLineNum = 5832783;BA.debugLine="Dim maxWidth As Int = 80dip ' Set max width for";
_maxwidth = __c.DipToCurrent((int) (80));
RDebugUtils.currentLine=5832784;
 //BA.debugLineNum = 5832784;BA.debugLine="DrawWrappedTextRotated(cv, \"Prince Warehouse\" &";
__ref._drawwrappedtextrotated /*int*/ (null,_cv,"Prince Warehouse"+BA.NumberToString((_i+1)),(int) ((_alignleftcenter)+__c.DipToCurrent((int) (10))+_xpos),(int) ((_productlabely)+__c.DipToCurrent((int) (5))),_maxwidth,(float) (12),__c.Colors.Red,"CENTER",(float) (-45));
 }
};
RDebugUtils.currentLine=5832786;
 //BA.debugLineNum = 5832786;BA.debugLine="Dim numLabels As Int = 10";
_numlabels = (int) (10);
RDebugUtils.currentLine=5832787;
 //BA.debugLineNum = 5832787;BA.debugLine="For i = 0 To numLabels";
{
final int step50 = 1;
final int limit50 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit50 ;_i = _i + step50 ) {
RDebugUtils.currentLine=5832788;
 //BA.debugLineNum = 5832788;BA.debugLine="Dim labelValue As Int = (maxSale / numLabels) *";
_labelvalue = (int) ((_maxsale/(double)_numlabels)*_i);
RDebugUtils.currentLine=5832789;
 //BA.debugLineNum = 5832789;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=5832791;
 //BA.debugLineNum = 5832791;BA.debugLine="cv.DrawText(FormatNumberWithSuffix(labelValue),";
_cv.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_labelvalue),(float) (_alignleftcenter-__c.DipToCurrent((int) (35))),(float) (_labelypos+_aligntopcenter+__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (12),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 }
};
RDebugUtils.currentLine=5832793;
 //BA.debugLineNum = 5832793;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.bargraph __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Dim ActivityContext As Activity";
_activitycontext = new anywheresoftware.b4a.objects.ActivityWrapper();
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="End Sub";
return "";
}
public String  _drawgraph(b4a.example.bargraph __ref,anywheresoftware.b4a.objects.ActivityWrapper _activity,anywheresoftware.b4a.objects.PanelWrapper _barpanel,int[] _sales,int _maxsale) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "drawgraph", false))
	 {return ((String) Debug.delegate(ba, "drawgraph", new Object[] {_activity,_barpanel,_sales,_maxsale}));}
anywheresoftware.b4a.objects.PanelWrapper _activitypanel = null;
int _alignleftcenter = 0;
int _aligntopcenter = 0;
anywheresoftware.b4a.objects.LabelWrapper _title = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _graphcanvas = null;
int _gap = 0;
int _endpadding = 0;
int _barwidth = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cv = null;
int _i = 0;
int _sale = 0;
int _barheight = 0;
int _xpos = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
int _shadowoffset = 0;
int _labelypos = 0;
int _productlabely = 0;
int _maxwidth = 0;
int _numlabels = 0;
int _labelvalue = 0;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub DrawGraph(Activity As Activity,barPanel As Pan";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="barPanel.Initialize(\"\")";
_barpanel.Initialize(ba,"");
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="barPanel.Height = 380dip";
_barpanel.setHeight(__c.DipToCurrent((int) (380)));
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="Dim activityPanel As Panel";
_activitypanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="activityPanel.Initialize(\"activityPanel\")";
_activitypanel.Initialize(ba,"activityPanel");
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="activityPanel.Width = 400dip";
_activitypanel.setWidth(__c.DipToCurrent((int) (400)));
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="activityPanel.Height = 200dip";
_activitypanel.setHeight(__c.DipToCurrent((int) (200)));
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="activityPanel.Color = Colors.ARGB(70, 211, 211, 2";
_activitypanel.setColor(__c.Colors.ARGB((int) (70),(int) (211),(int) (211),(int) (211)));
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="Dim alignLeftCenter As Int = (Activity.Width - ac";
_alignleftcenter = (int) ((_activity.getWidth()-_activitypanel.getWidth())/(double)2);
RDebugUtils.currentLine=5898253;
 //BA.debugLineNum = 5898253;BA.debugLine="Dim alignTopCenter As Int = (barPanel.Height - ac";
_aligntopcenter = (int) ((_barpanel.getHeight()-_activitypanel.getHeight())/(double)2);
RDebugUtils.currentLine=5898255;
 //BA.debugLineNum = 5898255;BA.debugLine="Dim title As Label";
_title = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5898256;
 //BA.debugLineNum = 5898256;BA.debugLine="title.Initialize(\"\")";
_title.Initialize(ba,"");
RDebugUtils.currentLine=5898257;
 //BA.debugLineNum = 5898257;BA.debugLine="title.Text = \"Total Sales For Companies\"";
_title.setText(BA.ObjectToCharSequence("Total Sales For Companies"));
RDebugUtils.currentLine=5898258;
 //BA.debugLineNum = 5898258;BA.debugLine="title.TextSize = 20";
_title.setTextSize((float) (20));
RDebugUtils.currentLine=5898259;
 //BA.debugLineNum = 5898259;BA.debugLine="title.Typeface = Typeface.MONOSPACE";
_title.setTypeface(__c.Typeface.MONOSPACE);
RDebugUtils.currentLine=5898260;
 //BA.debugLineNum = 5898260;BA.debugLine="title.Gravity = Gravity.CENTER";
_title.setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=5898261;
 //BA.debugLineNum = 5898261;BA.debugLine="title.TextColor = Colors.Black";
_title.setTextColor(__c.Colors.Black);
RDebugUtils.currentLine=5898262;
 //BA.debugLineNum = 5898262;BA.debugLine="barPanel.AddView(title,0,alignTopCenter/2,barPane";
_barpanel.AddView((android.view.View)(_title.getObject()),(int) (0),(int) (_aligntopcenter/(double)2),_barpanel.getWidth(),__c.DipToCurrent((int) (30)));
RDebugUtils.currentLine=5898265;
 //BA.debugLineNum = 5898265;BA.debugLine="barPanel.AddView(activityPanel, alignLeftCenter,";
_barpanel.AddView((android.view.View)(_activitypanel.getObject()),_alignleftcenter,_aligntopcenter,_activitypanel.getWidth(),_activitypanel.getHeight());
RDebugUtils.currentLine=5898268;
 //BA.debugLineNum = 5898268;BA.debugLine="Dim graphCanvas As Canvas";
_graphcanvas = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=5898269;
 //BA.debugLineNum = 5898269;BA.debugLine="graphCanvas.Initialize(activityPanel)";
_graphcanvas.Initialize((android.view.View)(_activitypanel.getObject()));
RDebugUtils.currentLine=5898272;
 //BA.debugLineNum = 5898272;BA.debugLine="Dim sales() As Int";
_sales = new int[(int) (0)];
;
RDebugUtils.currentLine=5898273;
 //BA.debugLineNum = 5898273;BA.debugLine="sales = Array As Int(1000, 200000, 150000, 300000";
_sales = new int[]{(int) (1000),(int) (200000),(int) (150000),(int) (300000)};
RDebugUtils.currentLine=5898276;
 //BA.debugLineNum = 5898276;BA.debugLine="Dim maxSale As Int = 400000";
_maxsale = (int) (400000);
RDebugUtils.currentLine=5898278;
 //BA.debugLineNum = 5898278;BA.debugLine="Dim gap As Int = 10dip";
_gap = __c.DipToCurrent((int) (10));
RDebugUtils.currentLine=5898279;
 //BA.debugLineNum = 5898279;BA.debugLine="If sales.Length < 5 Then";
if (_sales.length<5) { 
RDebugUtils.currentLine=5898280;
 //BA.debugLineNum = 5898280;BA.debugLine="Dim gap As Int = 50dip";
_gap = __c.DipToCurrent((int) (50));
 };
RDebugUtils.currentLine=5898283;
 //BA.debugLineNum = 5898283;BA.debugLine="Dim endPadding As Int = 7dip";
_endpadding = __c.DipToCurrent((int) (7));
RDebugUtils.currentLine=5898285;
 //BA.debugLineNum = 5898285;BA.debugLine="Dim barWidth As Int = (activityPanel.Width - (sal";
_barwidth = (int) ((_activitypanel.getWidth()-(_sales.length-1)*_gap-_endpadding)/(double)_sales.length);
RDebugUtils.currentLine=5898287;
 //BA.debugLineNum = 5898287;BA.debugLine="Dim cv As Canvas";
_cv = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=5898288;
 //BA.debugLineNum = 5898288;BA.debugLine="For i = 0 To sales.Length - 1";
{
final int step31 = 1;
final int limit31 = (int) (_sales.length-1);
_i = (int) (0) ;
for (;_i <= limit31 ;_i = _i + step31 ) {
RDebugUtils.currentLine=5898289;
 //BA.debugLineNum = 5898289;BA.debugLine="Dim sale As Int = sales(i)";
_sale = _sales[_i];
RDebugUtils.currentLine=5898292;
 //BA.debugLineNum = 5898292;BA.debugLine="Dim barHeight As Int = (sale / maxSale) * activi";
_barheight = (int) ((_sale/(double)_maxsale)*_activitypanel.getHeight());
RDebugUtils.currentLine=5898295;
 //BA.debugLineNum = 5898295;BA.debugLine="Dim xPos As Int = i * (barWidth + gap)";
_xpos = (int) (_i*(_barwidth+_gap));
RDebugUtils.currentLine=5898296;
 //BA.debugLineNum = 5898296;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=5898299;
 //BA.debugLineNum = 5898299;BA.debugLine="Dim shadowOffset As Int = 5dip ' Set the offset";
_shadowoffset = __c.DipToCurrent((int) (5));
RDebugUtils.currentLine=5898300;
 //BA.debugLineNum = 5898300;BA.debugLine="r.Initialize(xPos + shadowOffset, activityPanel.";
_r.Initialize((int) (_xpos+_shadowoffset),(int) (_activitypanel.getHeight()-_barheight+_shadowoffset),(int) (_xpos+_barwidth+_shadowoffset),(int) (_activitypanel.getHeight()+_shadowoffset));
RDebugUtils.currentLine=5898301;
 //BA.debugLineNum = 5898301;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(100, 100, 100";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.RGB((int) (100),(int) (100),(int) (100)),__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5898304;
 //BA.debugLineNum = 5898304;BA.debugLine="r.Initialize(xPos, activityPanel.Height - barHei";
_r.Initialize(_xpos,(int) (_activitypanel.getHeight()-_barheight),(int) (_xpos+_barwidth),_activitypanel.getHeight());
RDebugUtils.currentLine=5898305;
 //BA.debugLineNum = 5898305;BA.debugLine="graphCanvas.DrawRect(r, Colors.RGB(156, 0, 0), T";
_graphcanvas.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.RGB((int) (156),(int) (0),(int) (0)),__c.True,(float) (__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=5898308;
 //BA.debugLineNum = 5898308;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ba";
_labelypos = (int) (_activitypanel.getHeight()-_barheight-__c.DipToCurrent((int) (5)));
RDebugUtils.currentLine=5898309;
 //BA.debugLineNum = 5898309;BA.debugLine="graphCanvas.DrawText(FormatNumberWithSuffix(sale";
_graphcanvas.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_sale),(float) (_xpos+(_barwidth/(double)2)),(float) (_labelypos),__c.Typeface.MONOSPACE,(float) (14),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
RDebugUtils.currentLine=5898312;
 //BA.debugLineNum = 5898312;BA.debugLine="cv.Initialize(barPanel)";
_cv.Initialize((android.view.View)(_barpanel.getObject()));
RDebugUtils.currentLine=5898314;
 //BA.debugLineNum = 5898314;BA.debugLine="Dim productLabelY As Int = activityPanel.Height";
_productlabely = (int) (_activitypanel.getHeight()+_aligntopcenter+__c.DipToCurrent((int) (20)));
RDebugUtils.currentLine=5898316;
 //BA.debugLineNum = 5898316;BA.debugLine="Dim maxWidth As Int = 80dip ' Set max width for";
_maxwidth = __c.DipToCurrent((int) (80));
RDebugUtils.currentLine=5898317;
 //BA.debugLineNum = 5898317;BA.debugLine="DrawWrappedTextRotated(cv, \"Prince Warehouse\" &";
__ref._drawwrappedtextrotated /*int*/ (null,_cv,"Prince Warehouse"+BA.NumberToString((_i+1)),(int) ((_alignleftcenter)+__c.DipToCurrent((int) (10))+_xpos),(int) ((_productlabely)+__c.DipToCurrent((int) (5))),_maxwidth,(float) (12),__c.Colors.Red,"CENTER",(float) (-45));
 }
};
RDebugUtils.currentLine=5898319;
 //BA.debugLineNum = 5898319;BA.debugLine="Dim numLabels As Int = 5";
_numlabels = (int) (5);
RDebugUtils.currentLine=5898320;
 //BA.debugLineNum = 5898320;BA.debugLine="For i = 0 To numLabels";
{
final int step49 = 1;
final int limit49 = _numlabels;
_i = (int) (0) ;
for (;_i <= limit49 ;_i = _i + step49 ) {
RDebugUtils.currentLine=5898321;
 //BA.debugLineNum = 5898321;BA.debugLine="Dim labelValue As Int = (maxSale / numLabels) *";
_labelvalue = (int) ((_maxsale/(double)_numlabels)*_i);
RDebugUtils.currentLine=5898322;
 //BA.debugLineNum = 5898322;BA.debugLine="Dim labelYPos As Int = activityPanel.Height - ((";
_labelypos = (int) (_activitypanel.getHeight()-((_labelvalue/(double)_maxsale)*_activitypanel.getHeight()));
RDebugUtils.currentLine=5898324;
 //BA.debugLineNum = 5898324;BA.debugLine="cv.DrawText(FormatNumberWithSuffix(labelValue),";
_cv.DrawText(ba,__ref._formatnumberwithsuffix /*String*/ (null,_labelvalue),(float) (_alignleftcenter-__c.DipToCurrent((int) (35))),(float) (_labelypos+_aligntopcenter+__c.DipToCurrent((int) (5))),__c.Typeface.MONOSPACE,(float) (12),__c.Colors.Black,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 }
};
RDebugUtils.currentLine=5898326;
 //BA.debugLineNum = 5898326;BA.debugLine="End Sub";
return "";
}
public String  _formatnumberwithsuffix(b4a.example.bargraph __ref,int _number) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "formatnumberwithsuffix", false))
	 {return ((String) Debug.delegate(ba, "formatnumberwithsuffix", new Object[] {_number}));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub FormatNumberWithSuffix(number As Int) As Strin";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="If number >= 1000000 Then";
if (_number>=1000000) { 
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Return NumberFormat(number / 1000000, 1, 1) & \"M";
if (true) return __c.NumberFormat(_number/(double)1000000,(int) (1),(int) (1))+"M";
 }else 
{RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="Else If number >= 1000 Then";
if (_number>=1000) { 
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="Return NumberFormat(number / 1000, 1, 1) & \"k\"";
if (true) return __c.NumberFormat(_number/(double)1000,(int) (1),(int) (1))+"k";
 }else {
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="Return NumberFormat(number, 1, 0)";
if (true) return __c.NumberFormat(_number,(int) (1),(int) (0));
 }}
;
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="End Sub";
return "";
}
public int  _drawwrappedtextrotated(b4a.example.bargraph __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper _canvas,String _text,int _x,int _y,int _maxwidth,float _fontsize,int _color,String _alignment,float _angle) throws Exception{
__ref = this;
RDebugUtils.currentModule="bargraph";
if (Debug.shouldDelegate(ba, "drawwrappedtextrotated", false))
	 {return ((Integer) Debug.delegate(ba, "drawwrappedtextrotated", new Object[] {_canvas,_text,_x,_y,_maxwidth,_fontsize,_color,_alignment,_angle}));}
String[] _words = null;
String _line = "";
int _lineheight = 0;
int _originaly = 0;
String _word = "";
String _testline = "";
int _textwidth = 0;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub DrawWrappedTextRotated(canvas As Canvas, text";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Dim words() As String = Regex.Split(\" \", text)";
_words = __c.Regex.Split(" ",_text);
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="Dim line As String = \"\"";
_line = "";
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="Dim lineHeight As Int = 20dip ' Space between lin";
_lineheight = __c.DipToCurrent((int) (20));
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="Dim originalY As Int = y ' Store original Y posit";
_originaly = _y;
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="For Each word As String In words";
{
final String[] group5 = _words;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_word = group5[index5];
RDebugUtils.currentLine=6029319;
 //BA.debugLineNum = 6029319;BA.debugLine="Dim testLine As String = line & word & \" \"";
_testline = _line+_word+" ";
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="Dim textWidth As Int = canvas.MeasureStringWidth";
_textwidth = (int) (_canvas.MeasureStringWidth(_testline,__c.Typeface.MONOSPACE,_fontsize));
RDebugUtils.currentLine=6029322;
 //BA.debugLineNum = 6029322;BA.debugLine="If textWidth > maxWidth And line <> \"\" Then";
if (_textwidth>_maxwidth && (_line).equals("") == false) { 
RDebugUtils.currentLine=6029324;
 //BA.debugLineNum = 6029324;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEF";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=6029325;
 //BA.debugLineNum = 6029325;BA.debugLine="y = y + lineHeight ' Move to next line";
_y = (int) (_y+_lineheight);
RDebugUtils.currentLine=6029326;
 //BA.debugLineNum = 6029326;BA.debugLine="line = word & \" \" ' Start new line";
_line = _word+" ";
 }else {
RDebugUtils.currentLine=6029328;
 //BA.debugLineNum = 6029328;BA.debugLine="line = testLine ' Add word to current line";
_line = _testline;
 };
 }
};
RDebugUtils.currentLine=6029333;
 //BA.debugLineNum = 6029333;BA.debugLine="If line <> \"\" Then";
if ((_line).equals("") == false) { 
RDebugUtils.currentLine=6029334;
 //BA.debugLineNum = 6029334;BA.debugLine="canvas.DrawTextRotated(line, x, y, Typeface.DEFA";
_canvas.DrawTextRotated(ba,_line,(float) (_x),(float) (_y),__c.Typeface.DEFAULT_BOLD,_fontsize,_color,BA.getEnumFromString(android.graphics.Paint.Align.class,_alignment),_angle);
RDebugUtils.currentLine=6029335;
 //BA.debugLineNum = 6029335;BA.debugLine="y = y + lineHeight ' Move final Y position";
_y = (int) (_y+_lineheight);
 };
RDebugUtils.currentLine=6029339;
 //BA.debugLineNum = 6029339;BA.debugLine="Return y - originalY";
if (true) return (int) (_y-_originaly);
RDebugUtils.currentLine=6029340;
 //BA.debugLineNum = 6029340;BA.debugLine="End Sub";
return 0;
}
}