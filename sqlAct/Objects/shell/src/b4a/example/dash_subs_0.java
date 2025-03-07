package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dash_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (dash) ","dash",1,dash.mostCurrent.activityBA,dash.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.dash.remoteMe.runUserSub(false, "dash","activity_create", _firsttime);}
RemoteObject _systemlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"crud\")";
Debug.ShouldStop(536870912);
dash.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("crud")),dash.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="ScrollView1.Width = 100%x";
Debug.ShouldStop(1073741824);
dash.mostCurrent._scrollview1.runMethod(true,"setWidth",dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA));
 BA.debugLineNum = 32;BA.debugLine="ScrollViewPanel.Initialize(\"\")";
Debug.ShouldStop(-2147483648);
dash.mostCurrent._scrollviewpanel.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 33;BA.debugLine="ScrollView1.Panel.AddView(ScrollViewPanel, 0, 0,";
Debug.ShouldStop(1);
dash.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((dash.mostCurrent._scrollviewpanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 35;BA.debugLine="Dim SystemLabel As Label";
Debug.ShouldStop(4);
_systemlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("SystemLabel", _systemlabel);
 BA.debugLineNum = 36;BA.debugLine="SystemLabel.Initialize(\"\")";
Debug.ShouldStop(8);
_systemlabel.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 37;BA.debugLine="SystemLabel.Text = \"ATTENDANCE SYSTEM\"";
Debug.ShouldStop(16);
_systemlabel.runMethod(true,"setText",BA.ObjectToCharSequence("ATTENDANCE SYSTEM"));
 BA.debugLineNum = 38;BA.debugLine="SystemLabel.TextColor= Colors.White";
Debug.ShouldStop(32);
_systemlabel.runMethod(true,"setTextColor",dash.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 39;BA.debugLine="SystemLabel.TextSize = 30";
Debug.ShouldStop(64);
_systemlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 BA.debugLineNum = 40;BA.debugLine="SystemLabel.Typeface = Typeface.CreateNew(Typefac";
Debug.ShouldStop(128);
_systemlabel.runMethod(false,"setTypeface",dash.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"CreateNew",(Object)(dash.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF")),(Object)(dash.mostCurrent.__c.getField(false,"Typeface").getField(true,"STYLE_BOLD"))));
 BA.debugLineNum = 41;BA.debugLine="Panel1.AddView(SystemLabel,20dip,40dip,100%x,70di";
Debug.ShouldStop(256);
dash.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((_systemlabel.getObject())),(Object)(dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 70)))));
 BA.debugLineNum = 42;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(512);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 43;BA.debugLine="cvs.Initialize(Panel1)";
Debug.ShouldStop(1024);
_cvs.runVoidMethod ("Initialize",(Object)((dash.mostCurrent._panel1.getObject())));
 BA.debugLineNum = 46;BA.debugLine="cvs.DrawLine(0, Panel1.Height - 1, Panel1.Width,";
Debug.ShouldStop(8192);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {dash.mostCurrent._panel1.runMethod(true,"getHeight"),RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(BA.numberCast(float.class, dash.mostCurrent._panel1.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {dash.mostCurrent._panel1.runMethod(true,"getHeight"),RemoteObject.createImmutable(1)}, "-",1, 1))),(Object)(dash.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 50)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))),(Object)(BA.numberCast(float.class, 10)));
 BA.debugLineNum = 48;BA.debugLine="LoadMySQLData";
Debug.ShouldStop(32768);
_loadmysqldata();
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createroundbitmap(RemoteObject _input,RemoteObject _size) throws Exception{
try {
		Debug.PushSubsStack("CreateRoundBitmap (dash) ","dash",1,dash.mostCurrent.activityBA,dash.mostCurrent,164);
if (RapidSub.canDelegate("createroundbitmap")) { return b4a.example.dash.remoteMe.runUserSub(false, "dash","createroundbitmap", _input, _size);}
RemoteObject _l = RemoteObject.createImmutable(0);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
RemoteObject _xview = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _path = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
Debug.locals.put("Input", _input);
Debug.locals.put("Size", _size);
 BA.debugLineNum = 164;BA.debugLine="Sub CreateRoundBitmap (Input As B4XBitmap, Size As";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="If Input.Width <> Input.Height Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("!",_input.runMethod(true,"getWidth"),_input.runMethod(true,"getHeight"))) { 
 BA.debugLineNum = 167;BA.debugLine="Dim l As Int = Min(Input.Width, Input.Height)";
Debug.ShouldStop(64);
_l = BA.numberCast(int.class, dash.mostCurrent.__c.runMethod(true,"Min",(Object)(_input.runMethod(true,"getWidth")),(Object)(_input.runMethod(true,"getHeight"))));Debug.locals.put("l", _l);Debug.locals.put("l", _l);
 BA.debugLineNum = 168;BA.debugLine="Input = Input.Crop(Input.Width / 2 - l / 2, Inpu";
Debug.ShouldStop(128);
_input = _input.runMethod(false,"Crop",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_input.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),_l,RemoteObject.createImmutable(2)}, "/-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_input.runMethod(true,"getHeight"),RemoteObject.createImmutable(2),_l,RemoteObject.createImmutable(2)}, "/-/",1, 0))),(Object)(_l),(Object)(_l));Debug.locals.put("Input", _input);
 };
 BA.debugLineNum = 170;BA.debugLine="Dim c As B4XCanvas";
Debug.ShouldStop(512);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("c", _c);
 BA.debugLineNum = 171;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(1024);
_xview = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_xview = dash._xui.runMethod(false,"CreatePanel",dash.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("xview", _xview);Debug.locals.put("xview", _xview);
 BA.debugLineNum = 172;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, Size, Size)";
Debug.ShouldStop(2048);
_xview.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_size),(Object)(_size));
 BA.debugLineNum = 173;BA.debugLine="c.Initialize(xview)";
Debug.ShouldStop(4096);
_c.runVoidMethod ("Initialize",(Object)(_xview));
 BA.debugLineNum = 174;BA.debugLine="Dim path As B4XPath";
Debug.ShouldStop(8192);
_path = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("path", _path);
 BA.debugLineNum = 175;BA.debugLine="path.InitializeOval(c.TargetRect)";
Debug.ShouldStop(16384);
_path.runVoidMethod ("InitializeOval",(Object)(_c.runMethod(false,"getTargetRect")));
 BA.debugLineNum = 176;BA.debugLine="c.ClipPath(path)";
Debug.ShouldStop(32768);
_c.runVoidMethod ("ClipPath",(Object)(_path));
 BA.debugLineNum = 177;BA.debugLine="c.DrawBitmap(Input.Resize(Size, Size, False), c.T";
Debug.ShouldStop(65536);
_c.runVoidMethod ("DrawBitmap",(Object)((_input.runMethod(false,"Resize",(Object)(_size),(Object)(_size),(Object)(dash.mostCurrent.__c.getField(true,"False"))).getObject())),(Object)(_c.runMethod(false,"getTargetRect")));
 BA.debugLineNum = 178;BA.debugLine="c.RemoveClip";
Debug.ShouldStop(131072);
_c.runVoidMethod ("RemoveClip");
 BA.debugLineNum = 179;BA.debugLine="c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.C";
Debug.ShouldStop(262144);
_c.runVoidMethod ("DrawCircle",(Object)(_c.runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(_c.runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_c.runMethod(false,"getTargetRect").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "/-",1, 0))),(Object)(dash.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))),(Object)(dash.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 180;BA.debugLine="c.Invalidate";
Debug.ShouldStop(524288);
_c.runVoidMethod ("Invalidate");
 BA.debugLineNum = 181;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
Debug.ShouldStop(1048576);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_res = _c.runMethod(false,"CreateBitmap");Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 182;BA.debugLine="c.Release";
Debug.ShouldStop(2097152);
_c.runVoidMethod ("Release");
 BA.debugLineNum = 183;BA.debugLine="Return res";
Debug.ShouldStop(4194304);
if (true) return _res;
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.141/sam";
dash.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.141/sample/api.php?action=get_data");
 //BA.debugLineNum = 14;BA.debugLine="Dim TableDetails As List";
dash.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 15;BA.debugLine="Private ScrollView1 As ScrollView";
dash.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollViewPanel As Panel";
dash.mostCurrent._scrollviewpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private homeButn As Label";
dash.mostCurrent._homebutn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private studentListBtn As Label";
dash.mostCurrent._studentlistbtn = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private Panel1 As Panel";
dash.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _homebutn_click() throws Exception{
try {
		Debug.PushSubsStack("homeButn_Click (dash) ","dash",1,dash.mostCurrent.activityBA,dash.mostCurrent,189);
if (RapidSub.canDelegate("homebutn_click")) { return b4a.example.dash.remoteMe.runUserSub(false, "dash","homebutn_click");}
 BA.debugLineNum = 189;BA.debugLine="Private Sub homeButn_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="StartActivity(\"Main\")";
Debug.ShouldStop(536870912);
dash.mostCurrent.__c.runVoidMethod ("StartActivity",dash.processBA,(Object)((RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 191;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1073741824);
dash.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (dash) ","dash",1,dash.mostCurrent.activityBA,dash.mostCurrent,52);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.dash.remoteMe.runUserSub(false, "dash","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _ypos = RemoteObject.createImmutable(0);
RemoteObject _margin = RemoteObject.createImmutable(0);
RemoteObject _totalheight = RemoteObject.createImmutable(0);
RemoteObject _id_display = RemoteObject.createImmutable(0);
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _imagebase64 = RemoteObject.createImmutable("");
RemoteObject _su = RemoteObject.declareNull("anywheresoftware.b4a.objects.StringUtils");
RemoteObject _imagebytes = null;
RemoteObject _imageview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _imagebitmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _inputstream = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
RemoteObject _roundedbitmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
RemoteObject _namelabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _studentidlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _itempanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _id = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _horizontallayout = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
Debug.locals.put("job", _job);
 BA.debugLineNum = 52;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1048576);
dash.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 54;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),dash.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 55;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 56;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8388608);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 57;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(16777216);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 58;BA.debugLine="TableDetails = parser.NextArray";
Debug.ShouldStop(33554432);
dash.mostCurrent._tabledetails = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 60;BA.debugLine="ScrollViewPanel.RemoveAllViews";
Debug.ShouldStop(134217728);
dash.mostCurrent._scrollviewpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 62;BA.debugLine="Dim YPos As Int = 0";
Debug.ShouldStop(536870912);
_ypos = BA.numberCast(int.class, 0);Debug.locals.put("YPos", _ypos);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 63;BA.debugLine="Dim Margin As Int = 10dip";
Debug.ShouldStop(1073741824);
_margin = dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("Margin", _margin);Debug.locals.put("Margin", _margin);
 BA.debugLineNum = 64;BA.debugLine="Dim TotalHeight As Int = 0 ' To calculate total";
Debug.ShouldStop(-2147483648);
_totalheight = BA.numberCast(int.class, 0);Debug.locals.put("TotalHeight", _totalheight);Debug.locals.put("TotalHeight", _totalheight);
 BA.debugLineNum = 66;BA.debugLine="Dim id_display = 1 As Int";
Debug.ShouldStop(2);
_id_display = BA.numberCast(int.class, 1);Debug.locals.put("id_display", _id_display);Debug.locals.put("id_display", _id_display);
 BA.debugLineNum = 67;BA.debugLine="For Each record As Map In TableDetails";
Debug.ShouldStop(4);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group12 = dash.mostCurrent._tabledetails;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group12.runMethod(false,"Get",index12));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 69;BA.debugLine="Dim name As String = record.Get(\"name\")";
Debug.ShouldStop(16);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 70;BA.debugLine="Dim imageBase64 As String = record.Get(\"image\"";
Debug.ShouldStop(32);
_imagebase64 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("image")))));Debug.locals.put("imageBase64", _imagebase64);Debug.locals.put("imageBase64", _imagebase64);
 BA.debugLineNum = 72;BA.debugLine="Dim su As StringUtils";
Debug.ShouldStop(128);
_su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");Debug.locals.put("su", _su);
 BA.debugLineNum = 73;BA.debugLine="Dim ImageBytes() As Byte = su.DecodeBase64(ima";
Debug.ShouldStop(256);
_imagebytes = _su.runMethod(false,"DecodeBase64",(Object)(_imagebase64));Debug.locals.put("ImageBytes", _imagebytes);Debug.locals.put("ImageBytes", _imagebytes);
 BA.debugLineNum = 75;BA.debugLine="Dim ImageView As ImageView";
Debug.ShouldStop(1024);
_imageview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("ImageView", _imageview);
 BA.debugLineNum = 76;BA.debugLine="ImageView.Initialize(\"\")";
Debug.ShouldStop(2048);
_imageview.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 77;BA.debugLine="ImageView.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(4096);
_imageview.runMethod(true,"setGravity",dash.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 79;BA.debugLine="Dim ImageBitmap As Bitmap";
Debug.ShouldStop(16384);
_imagebitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("ImageBitmap", _imagebitmap);
 BA.debugLineNum = 80;BA.debugLine="Dim InputStream As InputStream";
Debug.ShouldStop(32768);
_inputstream = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("InputStream", _inputstream);
 BA.debugLineNum = 81;BA.debugLine="InputStream.InitializeFromBytesArray(ImageByte";
Debug.ShouldStop(65536);
_inputstream.runVoidMethod ("InitializeFromBytesArray",(Object)(_imagebytes),(Object)(BA.numberCast(int.class, 0)),(Object)(_imagebytes.getField(true,"length")));
 BA.debugLineNum = 82;BA.debugLine="ImageBitmap.Initialize2(InputStream)";
Debug.ShouldStop(131072);
_imagebitmap.runVoidMethod ("Initialize2",(Object)((_inputstream.getObject())));
 BA.debugLineNum = 85;BA.debugLine="ImageBitmap = ImageBitmap.Resize(100%x, 100%y,";
Debug.ShouldStop(1048576);
_imagebitmap = _imagebitmap.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA))),(Object)(BA.numberCast(float.class, dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA))),(Object)(dash.mostCurrent.__c.getField(true,"True")));Debug.locals.put("ImageBitmap", _imagebitmap);
 BA.debugLineNum = 88;BA.debugLine="Dim RoundedBitmap As B4XBitmap = CreateRoundBi";
Debug.ShouldStop(8388608);
_roundedbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_roundedbitmap = _createroundbitmap(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper"), _imagebitmap.getObject()),dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),dash.mostCurrent.activityBA));Debug.locals.put("RoundedBitmap", _roundedbitmap);Debug.locals.put("RoundedBitmap", _roundedbitmap);
 BA.debugLineNum = 89;BA.debugLine="ImageView.Bitmap = RoundedBitmap";
Debug.ShouldStop(16777216);
_imageview.runMethod(false,"setBitmap",(_roundedbitmap.getObject()));
 BA.debugLineNum = 91;BA.debugLine="Dim NameLabel As Label";
Debug.ShouldStop(67108864);
_namelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("NameLabel", _namelabel);
 BA.debugLineNum = 92;BA.debugLine="NameLabel.Initialize(\"\")";
Debug.ShouldStop(134217728);
_namelabel.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 93;BA.debugLine="NameLabel.Text = name";
Debug.ShouldStop(268435456);
_namelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 94;BA.debugLine="NameLabel.TextSize = 1%y";
Debug.ShouldStop(536870912);
_namelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 95;BA.debugLine="NameLabel.TextColor = Colors.Black";
Debug.ShouldStop(1073741824);
_namelabel.runMethod(true,"setTextColor",dash.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 96;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
Debug.ShouldStop(-2147483648);
_namelabel.runMethod(false,"setTypeface",dash.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"CreateNew",(Object)(dash.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF")),(Object)(dash.mostCurrent.__c.getField(false,"Typeface").getField(true,"STYLE_BOLD"))));
 BA.debugLineNum = 97;BA.debugLine="NameLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(1);
_namelabel.runMethod(true,"setGravity",dash.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 99;BA.debugLine="Dim StudentIdLabel As Label";
Debug.ShouldStop(4);
_studentidlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("StudentIdLabel", _studentidlabel);
 BA.debugLineNum = 100;BA.debugLine="StudentIdLabel.Initialize(\"\")";
Debug.ShouldStop(8);
_studentidlabel.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 101;BA.debugLine="StudentIdLabel.Text = \"SCC-213123-123123\"";
Debug.ShouldStop(16);
_studentidlabel.runMethod(true,"setText",BA.ObjectToCharSequence("SCC-213123-123123"));
 BA.debugLineNum = 102;BA.debugLine="StudentIdLabel.TextSize = 15";
Debug.ShouldStop(32);
_studentidlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 103;BA.debugLine="StudentIdLabel.TextColor = Colors.ARGB(255, 12";
Debug.ShouldStop(64);
_studentidlabel.runMethod(true,"setTextColor",dash.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128))));
 BA.debugLineNum = 104;BA.debugLine="StudentIdLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(128);
_studentidlabel.runMethod(true,"setGravity",dash.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 105;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
Debug.ShouldStop(256);
_namelabel.runMethod(false,"setTypeface",dash.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"CreateNew",(Object)(dash.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF")),(Object)(dash.mostCurrent.__c.getField(false,"Typeface").getField(true,"STYLE_NORMAL"))));
 BA.debugLineNum = 107;BA.debugLine="NameLabel.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(1024);
_namelabel.runMethod(false,"setTypeface",dash.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 108;BA.debugLine="Dim ItemPanel As Panel";
Debug.ShouldStop(2048);
_itempanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("ItemPanel", _itempanel);
 BA.debugLineNum = 109;BA.debugLine="ItemPanel.Initialize(\"\")";
Debug.ShouldStop(4096);
_itempanel.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 110;BA.debugLine="ItemPanel.SetLayout(0, YPos, ScrollView1.Width";
Debug.ShouldStop(8192);
_itempanel.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(_ypos),(Object)(dash.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 18)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 111;BA.debugLine="ItemPanel.Color = Colors.White";
Debug.ShouldStop(16384);
_itempanel.runVoidMethod ("setColor",dash.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 113;BA.debugLine="Dim id As Label";
Debug.ShouldStop(65536);
_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("id", _id);
 BA.debugLineNum = 114;BA.debugLine="id.Initialize(\"\")";
Debug.ShouldStop(131072);
_id.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 115;BA.debugLine="id.Text = id_display";
Debug.ShouldStop(262144);
_id.runMethod(true,"setText",BA.ObjectToCharSequence(_id_display));
 BA.debugLineNum = 116;BA.debugLine="id.TextSize = 24";
Debug.ShouldStop(524288);
_id.runMethod(true,"setTextSize",BA.numberCast(float.class, 24));
 BA.debugLineNum = 118;BA.debugLine="Dim HorizontalLayout As Panel";
Debug.ShouldStop(2097152);
_horizontallayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("HorizontalLayout", _horizontallayout);
 BA.debugLineNum = 119;BA.debugLine="HorizontalLayout.Initialize(\"\")";
Debug.ShouldStop(4194304);
_horizontallayout.runVoidMethod ("Initialize",dash.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 120;BA.debugLine="HorizontalLayout.SetLayout(0, 0, ItemPanel.Wid";
Debug.ShouldStop(8388608);
_horizontallayout.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_itempanel.runMethod(true,"getWidth")),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 122;BA.debugLine="HorizontalLayout.AddView(ImageView, 5%x, 2%y,";
Debug.ShouldStop(33554432);
_horizontallayout.runVoidMethod ("AddView",(Object)((_imageview.getObject())),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 123;BA.debugLine="HorizontalLayout.AddView(NameLabel, 25%x, 3%y,";
Debug.ShouldStop(67108864);
_horizontallayout.runVoidMethod ("AddView",(Object)((_namelabel.getObject())),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 3)),dash.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_itempanel.runMethod(true,"getWidth"),_imageview.runMethod(true,"getWidth")}, "-",1, 1)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 124;BA.debugLine="HorizontalLayout.AddView(id, 3%x, 2%y, 5%x, 5%";
Debug.ShouldStop(134217728);
_horizontallayout.runVoidMethod ("AddView",(Object)((_id.getObject())),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 3)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 125;BA.debugLine="HorizontalLayout.AddView(StudentIdLabel, 25%x,";
Debug.ShouldStop(268435456);
_horizontallayout.runVoidMethod ("AddView",(Object)((_studentidlabel.getObject())),(Object)(dash.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),dash.mostCurrent.activityBA)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 9)),dash.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_itempanel.runMethod(true,"getWidth"),_imageview.runMethod(true,"getWidth")}, "-",1, 1)),(Object)(dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),dash.mostCurrent.activityBA)));
 BA.debugLineNum = 126;BA.debugLine="HorizontalLayout.Color = Colors.LightGray";
Debug.ShouldStop(536870912);
_horizontallayout.runVoidMethod ("setColor",dash.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 BA.debugLineNum = 128;BA.debugLine="HorizontalLayout.Color = Colors.White";
Debug.ShouldStop(-2147483648);
_horizontallayout.runVoidMethod ("setColor",dash.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 130;BA.debugLine="Log(Panel1.Width & \"this is witdth\")";
Debug.ShouldStop(2);
dash.mostCurrent.__c.runVoidMethod ("LogImpl","01048654",RemoteObject.concat(dash.mostCurrent._panel1.runMethod(true,"getWidth"),RemoteObject.createImmutable("this is witdth")),0);
 BA.debugLineNum = 134;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(32);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 135;BA.debugLine="cvs.Initialize(HorizontalLayout)";
Debug.ShouldStop(64);
_cvs.runVoidMethod ("Initialize",(Object)((_horizontallayout.getObject())));
 BA.debugLineNum = 138;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, 0, Horizo";
Debug.ShouldStop(512);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getHeight"))),(Object)(dash.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 64)),(Object)(BA.numberCast(int.class, 34)))),(Object)(BA.numberCast(float.class, dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 BA.debugLineNum = 139;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, Horizonta";
Debug.ShouldStop(1024);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getHeight"))),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getHeight"))),(Object)(dash.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 64)),(Object)(BA.numberCast(int.class, 34)))),(Object)(BA.numberCast(float.class, dash.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 BA.debugLineNum = 141;BA.debugLine="ItemPanel.AddView(HorizontalLayout, 0, 0, Item";
Debug.ShouldStop(4096);
_itempanel.runVoidMethod ("AddView",(Object)((_horizontallayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_itempanel.runMethod(true,"getWidth")),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 142;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,";
Debug.ShouldStop(8192);
dash.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_itempanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_ypos),(Object)(dash.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 144;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin";
Debug.ShouldStop(32768);
_ypos = RemoteObject.solve(new RemoteObject[] {_ypos,_itempanel.runMethod(true,"getHeight"),_margin}, "++",2, 1);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 145;BA.debugLine="TotalHeight = YPos ' Update total height";
Debug.ShouldStop(65536);
_totalheight = _ypos;Debug.locals.put("TotalHeight", _totalheight);
 BA.debugLineNum = 147;BA.debugLine="id_display = id_display + 1";
Debug.ShouldStop(262144);
_id_display = RemoteObject.solve(new RemoteObject[] {_id_display,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("id_display", _id_display);
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 151;BA.debugLine="ScrollView1.Panel.Height = Max(TotalHeight, 100";
Debug.ShouldStop(4194304);
dash.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, dash.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _totalheight)),(Object)(BA.numberCast(double.class, dash.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),dash.mostCurrent.activityBA))))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e72) {
			BA.rdebugUtils.runVoidMethod("setLastException",dash.processBA, e72.toString()); BA.debugLineNum = 154;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
Debug.ShouldStop(33554432);
dash.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing data")),(Object)(dash.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 157;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(268435456);
dash.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(dash.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 159;BA.debugLine="job.Release";
Debug.ShouldStop(1073741824);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 160;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadmysqldata() throws Exception{
try {
		Debug.PushSubsStack("LoadMySQLData (dash) ","dash",1,dash.mostCurrent.activityBA,dash.mostCurrent,22);
if (RapidSub.canDelegate("loadmysqldata")) { return b4a.example.dash.remoteMe.runUserSub(false, "dash","loadmysqldata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 22;BA.debugLine="Sub LoadMySQLData";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(4194304);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 24;BA.debugLine="Job1.Initialize(\"LoadData\", Me)";
Debug.ShouldStop(8388608);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,dash.processBA,(Object)(BA.ObjectToString("LoadData")),(Object)(dash.getObject()));
 BA.debugLineNum = 25;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(16777216);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(dash.mostCurrent._phpurl));
 BA.debugLineNum = 26;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(33554432);
dash.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",dash.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private xui As XUI";
dash._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _studentlistbtn_click() throws Exception{
try {
		Debug.PushSubsStack("studentListBtn_Click (dash) ","dash",1,dash.mostCurrent.activityBA,dash.mostCurrent,194);
if (RapidSub.canDelegate("studentlistbtn_click")) { return b4a.example.dash.remoteMe.runUserSub(false, "dash","studentlistbtn_click");}
 BA.debugLineNum = 194;BA.debugLine="Private Sub studentListBtn_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="StartActivity(\"Dash\")";
Debug.ShouldStop(4);
dash.mostCurrent.__c.runVoidMethod ("StartActivity",dash.processBA,(Object)((RemoteObject.createImmutable("Dash"))));
 BA.debugLineNum = 196;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
dash.mostCurrent._activity.runVoidMethod ("Finish");
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
}