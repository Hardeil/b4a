package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,39);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(256);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="idleScreen.Initialize(Activity,10000) ' Set 10 se";
Debug.ShouldStop(512);
main.mostCurrent._idlescreen.runClassMethod (b4a.example.idlescreensaver.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(BA.numberCast(int.class, 10000)));
 BA.debugLineNum = 45;BA.debugLine="Images.Initialize";
Debug.ShouldStop(4096);
main.mostCurrent._images.runVoidMethod ("Initialize");
 BA.debugLineNum = 46;BA.debugLine="Images.Add(LoadBitmap(File.DirAssets, \"cyduck.jpg";
Debug.ShouldStop(8192);
main.mostCurrent._images.runVoidMethod ("Add",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("cyduck.jpg"))).getObject())));
 BA.debugLineNum = 47;BA.debugLine="Images.Add(LoadBitmap(File.DirAssets, \"pokemon.pn";
Debug.ShouldStop(16384);
main.mostCurrent._images.runVoidMethod ("Add",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("pokemon.png"))).getObject())));
 BA.debugLineNum = 48;BA.debugLine="Images.Add(LoadBitmap(File.DirAssets, \"profile.jp";
Debug.ShouldStop(32768);
main.mostCurrent._images.runVoidMethod ("Add",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("profile.jpg"))).getObject())));
 BA.debugLineNum = 51;BA.debugLine="imgSlide.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._imgslide.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 52;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(524288);
_loadcompanydata();
 BA.debugLineNum = 53;BA.debugLine="ScrollView1.Width = Activity.Width";
Debug.ShouldStop(1048576);
main.mostCurrent._scrollview1.runMethod(true,"setWidth",main.mostCurrent._activity.runMethod(true,"getWidth"));
 BA.debugLineNum = 54;BA.debugLine="ScrollView1.Height = Activity.Height";
Debug.ShouldStop(2097152);
main.mostCurrent._scrollview1.runMethod(true,"setHeight",main.mostCurrent._activity.runMethod(true,"getHeight"));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,208);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 208;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,205);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 205;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,211);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 211;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 212;BA.debugLine="xui.MsgboxAsync(\"Hello world!\", \"B4X\")";
Debug.ShouldStop(524288);
main._xui.runVoidMethod ("MsgboxAsync",main.processBA,(Object)(BA.ObjectToCharSequence("Hello world!")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("B4X"))));
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("CreateRoundBitmap (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,156);
if (RapidSub.canDelegate("createroundbitmap")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createroundbitmap", _input, _size);}
RemoteObject _l = RemoteObject.createImmutable(0);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
RemoteObject _xview = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _path = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
Debug.locals.put("Input", _input);
Debug.locals.put("Size", _size);
 BA.debugLineNum = 156;BA.debugLine="Sub CreateRoundBitmap (Input As B4XBitmap, Size As";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="If Input.Width <> Input.Height Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("!",_input.runMethod(true,"getWidth"),_input.runMethod(true,"getHeight"))) { 
 BA.debugLineNum = 159;BA.debugLine="Dim l As Int = Min(Input.Width, Input.Height)";
Debug.ShouldStop(1073741824);
_l = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Min",(Object)(_input.runMethod(true,"getWidth")),(Object)(_input.runMethod(true,"getHeight"))));Debug.locals.put("l", _l);Debug.locals.put("l", _l);
 BA.debugLineNum = 160;BA.debugLine="Input = Input.Crop(Input.Width / 2 - l / 2, Inpu";
Debug.ShouldStop(-2147483648);
_input = _input.runMethod(false,"Crop",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_input.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),_l,RemoteObject.createImmutable(2)}, "/-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_input.runMethod(true,"getHeight"),RemoteObject.createImmutable(2),_l,RemoteObject.createImmutable(2)}, "/-/",1, 0))),(Object)(_l),(Object)(_l));Debug.locals.put("Input", _input);
 };
 BA.debugLineNum = 162;BA.debugLine="Dim c As B4XCanvas";
Debug.ShouldStop(2);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("c", _c);
 BA.debugLineNum = 163;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(4);
_xview = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_xview = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("xview", _xview);Debug.locals.put("xview", _xview);
 BA.debugLineNum = 164;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, Size, Size)";
Debug.ShouldStop(8);
_xview.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_size),(Object)(_size));
 BA.debugLineNum = 165;BA.debugLine="c.Initialize(xview)";
Debug.ShouldStop(16);
_c.runVoidMethod ("Initialize",(Object)(_xview));
 BA.debugLineNum = 166;BA.debugLine="Dim path As B4XPath";
Debug.ShouldStop(32);
_path = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("path", _path);
 BA.debugLineNum = 167;BA.debugLine="path.InitializeOval(c.TargetRect)";
Debug.ShouldStop(64);
_path.runVoidMethod ("InitializeOval",(Object)(_c.runMethod(false,"getTargetRect")));
 BA.debugLineNum = 168;BA.debugLine="c.ClipPath(path)";
Debug.ShouldStop(128);
_c.runVoidMethod ("ClipPath",(Object)(_path));
 BA.debugLineNum = 169;BA.debugLine="c.DrawBitmap(Input.Resize(Size, Size, False), c.T";
Debug.ShouldStop(256);
_c.runVoidMethod ("DrawBitmap",(Object)((_input.runMethod(false,"Resize",(Object)(_size),(Object)(_size),(Object)(main.mostCurrent.__c.getField(true,"False"))).getObject())),(Object)(_c.runMethod(false,"getTargetRect")));
 BA.debugLineNum = 170;BA.debugLine="c.RemoveClip";
Debug.ShouldStop(512);
_c.runVoidMethod ("RemoveClip");
 BA.debugLineNum = 171;BA.debugLine="c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.C";
Debug.ShouldStop(1024);
_c.runVoidMethod ("DrawCircle",(Object)(_c.runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(_c.runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_c.runMethod(false,"getTargetRect").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "/-",1, 0))),(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 172;BA.debugLine="c.Invalidate";
Debug.ShouldStop(2048);
_c.runVoidMethod ("Invalidate");
 BA.debugLineNum = 173;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
Debug.ShouldStop(4096);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_res = _c.runMethod(false,"CreateBitmap");Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 174;BA.debugLine="c.Release";
Debug.ShouldStop(8192);
_c.runVoidMethod ("Release");
 BA.debugLineNum = 175;BA.debugLine="Return res";
Debug.ShouldStop(16384);
if (true) return _res;
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private imgSlide As ImageView ' Use the ImageView";
main.mostCurrent._imgslide = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Images As List";
main.mostCurrent._images = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 24;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.142/sam";
main.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.142/sample/api.php?action=get_data");
 //BA.debugLineNum = 25;BA.debugLine="Dim TableDetails As List";
main.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 26;BA.debugLine="Private ScrollView1 As ScrollView";
main.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private idleScreen As idlescreensaver";
main.mostCurrent._idlescreen = RemoteObject.createNew ("b4a.example.idlescreensaver");
 //BA.debugLineNum = 28;BA.debugLine="Private On As Button";
main.mostCurrent._on = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim show As Boolean = False";
main._show = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _itempanel_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("ItemPanel_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,178);
if (RapidSub.canDelegate("itempanel_touch")) { return b4a.example.main.remoteMe.runUserSub(false, "main","itempanel_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 178;BA.debugLine="Sub ItemPanel_Touch (Action As Int, X As Float, Y";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="Log(\"User is Active Now (ItemPanel Touched)\")";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4393217",RemoteObject.createImmutable("User is Active Now (ItemPanel Touched)"),0);
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
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,57);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
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
 BA.debugLineNum = 57;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 59;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 60;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 61;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(268435456);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 62;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(536870912);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 63;BA.debugLine="TableDetails = parser.NextArray";
Debug.ShouldStop(1073741824);
main.mostCurrent._tabledetails = _parser.runMethod(false,"NextArray");
 BA.debugLineNum = 65;BA.debugLine="Dim YPos As Int = 0";
Debug.ShouldStop(1);
_ypos = BA.numberCast(int.class, 0);Debug.locals.put("YPos", _ypos);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 66;BA.debugLine="Dim Margin As Int = 10dip";
Debug.ShouldStop(2);
_margin = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)));Debug.locals.put("Margin", _margin);Debug.locals.put("Margin", _margin);
 BA.debugLineNum = 67;BA.debugLine="Dim TotalHeight As Int = 0 ' To calculate total";
Debug.ShouldStop(4);
_totalheight = BA.numberCast(int.class, 0);Debug.locals.put("TotalHeight", _totalheight);Debug.locals.put("TotalHeight", _totalheight);
 BA.debugLineNum = 68;BA.debugLine="Dim id_display = 1 As Int";
Debug.ShouldStop(8);
_id_display = BA.numberCast(int.class, 1);Debug.locals.put("id_display", _id_display);Debug.locals.put("id_display", _id_display);
 BA.debugLineNum = 70;BA.debugLine="For Each record As Map In TableDetails";
Debug.ShouldStop(32);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group11 = main.mostCurrent._tabledetails;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), group11.runMethod(false,"Get",index11));Debug.locals.put("record", _record);
Debug.locals.put("record", _record);
 BA.debugLineNum = 71;BA.debugLine="Dim name As String = record.Get(\"name\")";
Debug.ShouldStop(64);
_name = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 72;BA.debugLine="Dim imageBase64 As String = record.Get(\"image\"";
Debug.ShouldStop(128);
_imagebase64 = BA.ObjectToString(_record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("image")))));Debug.locals.put("imageBase64", _imagebase64);Debug.locals.put("imageBase64", _imagebase64);
 BA.debugLineNum = 74;BA.debugLine="Dim su As StringUtils";
Debug.ShouldStop(512);
_su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");Debug.locals.put("su", _su);
 BA.debugLineNum = 75;BA.debugLine="Dim ImageBytes() As Byte = su.DecodeBase64(ima";
Debug.ShouldStop(1024);
_imagebytes = _su.runMethod(false,"DecodeBase64",(Object)(_imagebase64));Debug.locals.put("ImageBytes", _imagebytes);Debug.locals.put("ImageBytes", _imagebytes);
 BA.debugLineNum = 77;BA.debugLine="Dim ImageView As ImageView";
Debug.ShouldStop(4096);
_imageview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("ImageView", _imageview);
 BA.debugLineNum = 78;BA.debugLine="ImageView.Initialize(\"\")";
Debug.ShouldStop(8192);
_imageview.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 79;BA.debugLine="ImageView.Gravity = Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(16384);
_imageview.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 81;BA.debugLine="Dim ImageBitmap As Bitmap";
Debug.ShouldStop(65536);
_imagebitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("ImageBitmap", _imagebitmap);
 BA.debugLineNum = 82;BA.debugLine="Dim InputStream As InputStream";
Debug.ShouldStop(131072);
_inputstream = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("InputStream", _inputstream);
 BA.debugLineNum = 83;BA.debugLine="InputStream.InitializeFromBytesArray(ImageByte";
Debug.ShouldStop(262144);
_inputstream.runVoidMethod ("InitializeFromBytesArray",(Object)(_imagebytes),(Object)(BA.numberCast(int.class, 0)),(Object)(_imagebytes.getField(true,"length")));
 BA.debugLineNum = 84;BA.debugLine="ImageBitmap.Initialize2(InputStream)";
Debug.ShouldStop(524288);
_imagebitmap.runVoidMethod ("Initialize2",(Object)((_inputstream.getObject())));
 BA.debugLineNum = 87;BA.debugLine="ImageBitmap = ImageBitmap.Resize(100%x, 100%y,";
Debug.ShouldStop(4194304);
_imagebitmap = _imagebitmap.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA))),(Object)(main.mostCurrent.__c.getField(true,"True")));Debug.locals.put("ImageBitmap", _imagebitmap);
 BA.debugLineNum = 90;BA.debugLine="Dim RoundedBitmap As B4XBitmap = CreateRoundBi";
Debug.ShouldStop(33554432);
_roundedbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_roundedbitmap = _createroundbitmap(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper"), _imagebitmap.getObject()),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA));Debug.locals.put("RoundedBitmap", _roundedbitmap);Debug.locals.put("RoundedBitmap", _roundedbitmap);
 BA.debugLineNum = 91;BA.debugLine="ImageView.Bitmap = RoundedBitmap";
Debug.ShouldStop(67108864);
_imageview.runMethod(false,"setBitmap",(_roundedbitmap.getObject()));
 BA.debugLineNum = 93;BA.debugLine="Dim NameLabel As Label";
Debug.ShouldStop(268435456);
_namelabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("NameLabel", _namelabel);
 BA.debugLineNum = 94;BA.debugLine="NameLabel.Initialize(\"\")";
Debug.ShouldStop(536870912);
_namelabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 95;BA.debugLine="NameLabel.Text = name";
Debug.ShouldStop(1073741824);
_namelabel.runMethod(true,"setText",BA.ObjectToCharSequence(_name));
 BA.debugLineNum = 96;BA.debugLine="NameLabel.TextSize = 1%y";
Debug.ShouldStop(-2147483648);
_namelabel.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 97;BA.debugLine="NameLabel.TextColor = Colors.Black";
Debug.ShouldStop(1);
_namelabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 98;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
Debug.ShouldStop(2);
_namelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"CreateNew",(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF")),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(true,"STYLE_BOLD"))));
 BA.debugLineNum = 99;BA.debugLine="NameLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(4);
_namelabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 101;BA.debugLine="Dim StudentIdLabel As Label";
Debug.ShouldStop(16);
_studentidlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("StudentIdLabel", _studentidlabel);
 BA.debugLineNum = 102;BA.debugLine="StudentIdLabel.Initialize(\"\")";
Debug.ShouldStop(32);
_studentidlabel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 103;BA.debugLine="StudentIdLabel.Text = \"SCC-213123-123123\"";
Debug.ShouldStop(64);
_studentidlabel.runMethod(true,"setText",BA.ObjectToCharSequence("SCC-213123-123123"));
 BA.debugLineNum = 104;BA.debugLine="StudentIdLabel.TextSize = 15";
Debug.ShouldStop(128);
_studentidlabel.runMethod(true,"setTextSize",BA.numberCast(float.class, 15));
 BA.debugLineNum = 105;BA.debugLine="StudentIdLabel.TextColor = Colors.ARGB(255, 12";
Debug.ShouldStop(256);
_studentidlabel.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 128))));
 BA.debugLineNum = 106;BA.debugLine="StudentIdLabel.Gravity = Gravity.CENTER";
Debug.ShouldStop(512);
_studentidlabel.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 107;BA.debugLine="NameLabel.Typeface = Typeface.CreateNew(Typefa";
Debug.ShouldStop(1024);
_namelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"CreateNew",(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF")),(Object)(main.mostCurrent.__c.getField(false,"Typeface").getField(true,"STYLE_NORMAL"))));
 BA.debugLineNum = 109;BA.debugLine="NameLabel.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(4096);
_namelabel.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 110;BA.debugLine="Dim ItemPanel As Panel";
Debug.ShouldStop(8192);
_itempanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("ItemPanel", _itempanel);
 BA.debugLineNum = 111;BA.debugLine="ItemPanel.Initialize(\"ItemPanel\")";
Debug.ShouldStop(16384);
_itempanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ItemPanel")));
 BA.debugLineNum = 112;BA.debugLine="ItemPanel.SetLayout(0, YPos, 100%x, 18%y)";
Debug.ShouldStop(32768);
_itempanel.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(_ypos),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 18)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 113;BA.debugLine="ItemPanel.Color = Colors.White";
Debug.ShouldStop(65536);
_itempanel.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 115;BA.debugLine="Dim id As Label";
Debug.ShouldStop(262144);
_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("id", _id);
 BA.debugLineNum = 116;BA.debugLine="id.Initialize(\"\")";
Debug.ShouldStop(524288);
_id.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 117;BA.debugLine="id.Text = id_display";
Debug.ShouldStop(1048576);
_id.runMethod(true,"setText",BA.ObjectToCharSequence(_id_display));
 BA.debugLineNum = 118;BA.debugLine="id.TextSize = 24";
Debug.ShouldStop(2097152);
_id.runMethod(true,"setTextSize",BA.numberCast(float.class, 24));
 BA.debugLineNum = 120;BA.debugLine="Dim HorizontalLayout As Panel";
Debug.ShouldStop(8388608);
_horizontallayout = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("HorizontalLayout", _horizontallayout);
 BA.debugLineNum = 121;BA.debugLine="HorizontalLayout.Initialize(\"\")";
Debug.ShouldStop(16777216);
_horizontallayout.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 122;BA.debugLine="HorizontalLayout.SetLayout(0, 0, ItemPanel.Wid";
Debug.ShouldStop(33554432);
_horizontallayout.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_itempanel.runMethod(true,"getWidth")),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 124;BA.debugLine="HorizontalLayout.AddView(ImageView, 5%x, 2%y,";
Debug.ShouldStop(134217728);
_horizontallayout.runVoidMethod ("AddView",(Object)((_imageview.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 125;BA.debugLine="HorizontalLayout.AddView(NameLabel, 25%x, 3%y,";
Debug.ShouldStop(268435456);
_horizontallayout.runVoidMethod ("AddView",(Object)((_namelabel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 3)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_itempanel.runMethod(true,"getWidth"),_imageview.runMethod(true,"getWidth")}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 126;BA.debugLine="HorizontalLayout.AddView(id, 3%x, 2%y, 5%x, 5%";
Debug.ShouldStop(536870912);
_horizontallayout.runVoidMethod ("AddView",(Object)((_id.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 3)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 127;BA.debugLine="HorizontalLayout.AddView(StudentIdLabel, 25%x,";
Debug.ShouldStop(1073741824);
_horizontallayout.runVoidMethod ("AddView",(Object)((_studentidlabel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 25)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 9)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_itempanel.runMethod(true,"getWidth"),_imageview.runMethod(true,"getWidth")}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 128;BA.debugLine="HorizontalLayout.Color = Colors.LightGray";
Debug.ShouldStop(-2147483648);
_horizontallayout.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 BA.debugLineNum = 129;BA.debugLine="HorizontalLayout.Color = Colors.White";
Debug.ShouldStop(1);
_horizontallayout.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 131;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(4);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 132;BA.debugLine="cvs.Initialize(HorizontalLayout)";
Debug.ShouldStop(8);
_cvs.runVoidMethod ("Initialize",(Object)((_horizontallayout.getObject())));
 BA.debugLineNum = 135;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, 0, Horizo";
Debug.ShouldStop(64);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getHeight"))),(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 64)),(Object)(BA.numberCast(int.class, 34)))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 BA.debugLineNum = 136;BA.debugLine="cvs.DrawLine(HorizontalLayout.Width, Horizonta";
Debug.ShouldStop(128);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getHeight"))),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _horizontallayout.runMethod(true,"getHeight"))),(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 16)),(Object)(BA.numberCast(int.class, 64)),(Object)(BA.numberCast(int.class, 34)))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 BA.debugLineNum = 138;BA.debugLine="ItemPanel.AddView(HorizontalLayout, 0, 0, Item";
Debug.ShouldStop(512);
_itempanel.runVoidMethod ("AddView",(Object)((_horizontallayout.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_itempanel.runMethod(true,"getWidth")),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 139;BA.debugLine="ScrollView1.Panel.AddView(ItemPanel, 0, YPos,S";
Debug.ShouldStop(1024);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_itempanel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_ypos),(Object)(main.mostCurrent._scrollview1.runMethod(true,"getWidth")),(Object)(_itempanel.runMethod(true,"getHeight")));
 BA.debugLineNum = 140;BA.debugLine="YPos = YPos + ItemPanel.Height + Margin";
Debug.ShouldStop(2048);
_ypos = RemoteObject.solve(new RemoteObject[] {_ypos,_itempanel.runMethod(true,"getHeight"),_margin}, "++",2, 1);Debug.locals.put("YPos", _ypos);
 BA.debugLineNum = 141;BA.debugLine="TotalHeight = YPos ' Update total height";
Debug.ShouldStop(4096);
_totalheight = _ypos;Debug.locals.put("TotalHeight", _totalheight);
 BA.debugLineNum = 142;BA.debugLine="id_display = id_display + 1";
Debug.ShouldStop(8192);
_id_display = RemoteObject.solve(new RemoteObject[] {_id_display,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("id_display", _id_display);
 }
}Debug.locals.put("record", _record);
;
 BA.debugLineNum = 146;BA.debugLine="ScrollView1.Panel.Height = Max(TotalHeight, 100";
Debug.ShouldStop(131072);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _totalheight)),(Object)(BA.numberCast(double.class, main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA))))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e70) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e70.toString()); BA.debugLineNum = 148;BA.debugLine="ToastMessageShow(\"Error parsing data\", True)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing data")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 151;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 153;BA.debugLine="job.Release";
Debug.ShouldStop(16777216);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadcompanydata() throws Exception{
try {
		Debug.PushSubsStack("LoadCompanyData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 32;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(1);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 34;BA.debugLine="Job1.Initialize(\"LoadData\", Me)";
Debug.ShouldStop(2);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("LoadData")),(Object)(main.getObject()));
 BA.debugLineNum = 35;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(4);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurl));
 BA.debugLineNum = 36;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
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
public static RemoteObject  _off_click() throws Exception{
try {
		Debug.PushSubsStack("Off_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,215);
if (RapidSub.canDelegate("off_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","off_click");}
 BA.debugLineNum = 215;BA.debugLine="Private Sub Off_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _on_click() throws Exception{
try {
		Debug.PushSubsStack("On_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,188);
if (RapidSub.canDelegate("on_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","on_click");}
 BA.debugLineNum = 188;BA.debugLine="Private Sub On_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="If show = False Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main._show,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 190;BA.debugLine="Log(\"on\")";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524290",RemoteObject.createImmutable("on"),0);
 BA.debugLineNum = 191;BA.debugLine="idleScreen.ShowScreenSaver(True)";
Debug.ShouldStop(1073741824);
main.mostCurrent._idlescreen.runClassMethod (b4a.example.idlescreensaver.class, "_showscreensaver" /*RemoteObject*/ ,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 192;BA.debugLine="ScrollView1.Visible = False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._scrollview1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 193;BA.debugLine="show = True";
Debug.ShouldStop(1);
main._show = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 194;BA.debugLine="On.Text = \"Off\"";
Debug.ShouldStop(2);
main.mostCurrent._on.runMethod(true,"setText",BA.ObjectToCharSequence("Off"));
 }else {
 BA.debugLineNum = 196;BA.debugLine="ScrollView1.Visible = True";
Debug.ShouldStop(8);
main.mostCurrent._scrollview1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 197;BA.debugLine="idleScreen.ShowScreenSaver(False)";
Debug.ShouldStop(16);
main.mostCurrent._idlescreen.runClassMethod (b4a.example.idlescreensaver.class, "_showscreensaver" /*RemoteObject*/ ,(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 198;BA.debugLine="Log(\"off\")";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524298",RemoteObject.createImmutable("off"),0);
 BA.debugLineNum = 199;BA.debugLine="show = False";
Debug.ShouldStop(64);
main._show = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 200;BA.debugLine="On.Text = \"On\"";
Debug.ShouldStop(128);
main.mostCurrent._on.runMethod(true,"setText",BA.ObjectToCharSequence("On"));
 };
 BA.debugLineNum = 202;BA.debugLine="Log(show)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4524302",BA.ObjectToString(main._show),0);
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
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
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
idlescreensaver.myClass = BA.getDeviceClass ("b4a.example.idlescreensaver");
saver_screen.myClass = BA.getDeviceClass ("b4a.example.saver_screen");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _scrollview1_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("ScrollView1_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,182);
if (RapidSub.canDelegate("scrollview1_touch")) { return b4a.example.main.remoteMe.runUserSub(false, "main","scrollview1_touch", _action, _x, _y);}
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 182;BA.debugLine="Sub ScrollView1_Touch (Action As Int, X As Float,";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="If Action = 0 Then ' ACTION_DOWN event";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 184;BA.debugLine="Log(\"User is Active (ScrollView Touched)\")";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4458754",RemoteObject.createImmutable("User is Active (ScrollView Touched)"),0);
 };
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}