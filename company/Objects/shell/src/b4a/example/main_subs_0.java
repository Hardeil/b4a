package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _gradient = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="Label1.Text = Label1.Text.ToUpperCase";
Debug.ShouldStop(65536);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent._label1.runMethod(true,"getText").runMethod(true,"toUpperCase")));
 BA.debugLineNum = 50;BA.debugLine="Label1.Typeface = Typeface.MONOSPACE";
Debug.ShouldStop(131072);
main.mostCurrent._label1.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"MONOSPACE"));
 BA.debugLineNum = 51;BA.debugLine="ScrollView1.Panel.Color = Colors.ARGB(255, 251, 2";
Debug.ShouldStop(262144);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251)),(Object)(BA.numberCast(int.class, 251))));
 BA.debugLineNum = 52;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(524288);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 53;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(1048576);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 225)),(Object)(BA.numberCast(int.class, 218)),(Object)(BA.numberCast(int.class, 218))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 189)),(Object)(BA.numberCast(int.class, 202)),(Object)(BA.numberCast(int.class, 217)))})));
 BA.debugLineNum = 55;BA.debugLine="ScrollView1.Background = gradient";
Debug.ShouldStop(4194304);
main.mostCurrent._scrollview1.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 56;BA.debugLine="ScrollView1.Panel.Height = Activity.Height";
Debug.ShouldStop(8388608);
main.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",main.mostCurrent._activity.runMethod(true,"getHeight"));
 BA.debugLineNum = 57;BA.debugLine="Dim gradient As GradientDrawable";
Debug.ShouldStop(16777216);
_gradient = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("gradient", _gradient);
 BA.debugLineNum = 58;BA.debugLine="gradient.Initialize(\"RIGHT_LEFT\", Array As Int(Co";
Debug.ShouldStop(33554432);
_gradient.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"RIGHT_LEFT")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 185)),(Object)(BA.numberCast(int.class, 46)),(Object)(BA.numberCast(int.class, 52))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 61)),(Object)(BA.numberCast(int.class, 12)),(Object)(BA.numberCast(int.class, 2)))})));
 BA.debugLineNum = 60;BA.debugLine="Panel2.Background = gradient";
Debug.ShouldStop(134217728);
main.mostCurrent._panel2.runMethod(false,"setBackground",(_gradient.getObject()));
 BA.debugLineNum = 61;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(268435456);
_loadcompanydata();
 BA.debugLineNum = 63;BA.debugLine="barPanel.Initialize(\"\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._barpanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 64;BA.debugLine="Panel1.AddView(barPanel,25dip,Panel2.Height+20dip";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((main.mostCurrent._barpanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
 BA.debugLineNum = 66;BA.debugLine="purchasePanel.Initialize(\"\")";
Debug.ShouldStop(2);
main.mostCurrent._purchasepanel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 67;BA.debugLine="Panel1.AddView(purchasePanel,25dip,barPanel.top+b";
Debug.ShouldStop(4);
main.mostCurrent._panel1.runVoidMethod ("AddView",(Object)((main.mostCurrent._purchasepanel.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 25)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._barpanel.runMethod(true,"getTop"),main.mostCurrent._barpanel.runMethod(true,"getHeight"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "+++",3, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,169);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 169;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,165);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 165;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16);
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmapvalueordefault(RemoteObject _m,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetMapValueOrDefault (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,158);
if (RapidSub.canDelegate("getmapvalueordefault")) { return b4a.example.main.remoteMe.runUserSub(false, "main","getmapvalueordefault", _m, _key, _defaultvalue);}
Debug.locals.put("m", _m);
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 158;BA.debugLine="Sub GetMapValueOrDefault(m As Map, Key As String,";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 159;BA.debugLine="If m.ContainsKey(Key) Then";
Debug.ShouldStop(1073741824);
if (_m.runMethod(true,"ContainsKey",(Object)((_key))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 160;BA.debugLine="Return m.Get(Key)";
Debug.ShouldStop(-2147483648);
Debug.CheckDeviceExceptions();if (true) return _m.runMethod(false,"Get",(Object)((_key)));
 }else {
 BA.debugLineNum = 162;BA.debugLine="Return DefaultValue";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return _defaultvalue;
 };
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private ScrollView1 As ScrollView";
main.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim PHPURL As String = \"https://192.168.8.117/Com";
main.mostCurrent._phpurl = BA.ObjectToString("https://192.168.8.117/Company/fetch.php?action=get_company_list");
 //BA.debugLineNum = 27;BA.debugLine="Dim TableDetails As List";
main.mostCurrent._tabledetails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 29;BA.debugLine="Private Button1 As Button";
main.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private navigate As Label";
main.mostCurrent._navigate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim titleFontSize As Int = 4.5%y";
main._titlefontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4.5)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 32;BA.debugLine="Dim primaryFontSize As Int = 1.6%y";
main._primaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.6)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 33;BA.debugLine="Dim secondaryFontSize As Int = 1%y";
main._secondaryfontsize = main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Panel2 As Panel";
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Dim barGraph As barGraph";
main.mostCurrent._bargraph = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 38;BA.debugLine="Dim barGraph1 As barGraph";
main.mostCurrent._bargraph1 = RemoteObject.createNew ("b4a.example.bargraph");
 //BA.debugLineNum = 39;BA.debugLine="Dim barPanel As Panel";
main.mostCurrent._barpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Dim activityPanel As Panel";
main.mostCurrent._activitypanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Public legend() As String = Array As String(\"Sale";
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 //BA.debugLineNum = 43;BA.debugLine="Dim purchasePanel As Panel";
main.mostCurrent._purchasepanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.main.remoteMe.runUserSub(false, "main","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _salesarray = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _totalcompanies = RemoteObject.createImmutable(0);
RemoteObject _sales = null;
RemoteObject _sales1 = null;
RemoteObject _sales2 = null;
RemoteObject _purchase = null;
RemoteObject _purchase1 = null;
RemoteObject _purchase2 = null;
RemoteObject _product = null;
int _i = 0;
RemoteObject _record = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _branches = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _j = 0;
RemoteObject _branchmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _branchname = RemoteObject.createImmutable("");
RemoteObject _branchsales1 = RemoteObject.createImmutable(0);
RemoteObject _branchsales2 = RemoteObject.createImmutable(0);
RemoteObject _branchsales3 = RemoteObject.createImmutable(0);
Debug.locals.put("job", _job);
 BA.debugLineNum = 79;BA.debugLine="Sub JobDone(job As HttpJob)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 81;BA.debugLine="If job.Success = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success" /*RemoteObject*/ ),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 82;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 83;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(262144);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 84;BA.debugLine="parser.Initialize(job.GetString)";
Debug.ShouldStop(524288);
_parser.runVoidMethod ("Initialize",(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ )));
 BA.debugLineNum = 85;BA.debugLine="Select Case job.JobName";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("GetData"),BA.ObjectToString("UpdateData"))) {
case 0: {
 BA.debugLineNum = 87;BA.debugLine="Dim salesArray As List = parser.NextArray";
Debug.ShouldStop(4194304);
_salesarray = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_salesarray = _parser.runMethod(false,"NextArray");Debug.locals.put("salesArray", _salesarray);Debug.locals.put("salesArray", _salesarray);
 BA.debugLineNum = 91;BA.debugLine="If salesArray.Size = 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_salesarray.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(\"No data received\", True)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No data received")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 93;BA.debugLine="Return";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 97;BA.debugLine="Dim totalCompanies As Int = salesArray.Size";
Debug.ShouldStop(1);
_totalcompanies = _salesarray.runMethod(true,"getSize");Debug.locals.put("totalCompanies", _totalcompanies);Debug.locals.put("totalCompanies", _totalcompanies);
 BA.debugLineNum = 98;BA.debugLine="Dim sales(totalCompanies) As Int";
Debug.ShouldStop(2);
_sales = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales", _sales);
 BA.debugLineNum = 99;BA.debugLine="Dim sales1(totalCompanies) As Int";
Debug.ShouldStop(4);
_sales1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales1", _sales1);
 BA.debugLineNum = 100;BA.debugLine="Dim sales2(totalCompanies) As Int";
Debug.ShouldStop(8);
_sales2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("sales2", _sales2);
 BA.debugLineNum = 101;BA.debugLine="Dim purchase(totalCompanies) As Int";
Debug.ShouldStop(16);
_purchase = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase", _purchase);
 BA.debugLineNum = 102;BA.debugLine="Dim purchase1(totalCompanies) As Int";
Debug.ShouldStop(32);
_purchase1 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase1", _purchase1);
 BA.debugLineNum = 103;BA.debugLine="Dim purchase2(totalCompanies) As Int";
Debug.ShouldStop(64);
_purchase2 = RemoteObject.createNewArray ("int", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("purchase2", _purchase2);
 BA.debugLineNum = 104;BA.debugLine="Dim product(totalCompanies) As String";
Debug.ShouldStop(128);
_product = RemoteObject.createNewArray ("String", new int[] {_totalcompanies.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("product", _product);
 BA.debugLineNum = 109;BA.debugLine="For i = 0 To totalCompanies - 1";
Debug.ShouldStop(4096);
{
final int step21 = 1;
final int limit21 = RemoteObject.solve(new RemoteObject[] {_totalcompanies,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step21 > 0 && _i <= limit21) || (step21 < 0 && _i >= limit21) ;_i = ((int)(0 + _i + step21))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 110;BA.debugLine="Dim record As Map = salesArray.Get(i)";
Debug.ShouldStop(8192);
_record = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_record = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _salesarray.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("record", _record);Debug.locals.put("record", _record);
 BA.debugLineNum = 111;BA.debugLine="product(i) = record.GetDefault(\"company_name";
Debug.ShouldStop(16384);
_product.setArrayElement (BA.ObjectToString(_record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("company_name"))),(Object)((RemoteObject.createImmutable("Unknown"))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 112;BA.debugLine="sales(i) = record.GetDefault(\"sales_1\", 0)";
Debug.ShouldStop(32768);
_sales.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 113;BA.debugLine="sales1(i) = record.GetDefault(\"sales_2\", 0)";
Debug.ShouldStop(65536);
_sales1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 114;BA.debugLine="sales2(i) = record.GetDefault(\"sales_3\", 0)";
Debug.ShouldStop(131072);
_sales2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("sales_3"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 115;BA.debugLine="purchase(i) = record.GetDefault(\"purchase_1\"";
Debug.ShouldStop(262144);
_purchase.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_1"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 116;BA.debugLine="purchase1(i) = record.GetDefault(\"purchase_2";
Debug.ShouldStop(524288);
_purchase1.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_2"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 117;BA.debugLine="purchase2(i) = record.GetDefault(\"purchase_\"";
Debug.ShouldStop(1048576);
_purchase2.setArrayElement (BA.numberCast(int.class, _record.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("purchase_"))),(Object)(RemoteObject.createImmutable((0))))),BA.numberCast(int.class, _i));
 BA.debugLineNum = 118;BA.debugLine="If record.ContainsKey(\"branches\") Then";
Debug.ShouldStop(2097152);
if (_record.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("branches")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 119;BA.debugLine="Dim branches As List = record.Get(\"branches";
Debug.ShouldStop(4194304);
_branches = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_branches = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), _record.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("branches")))));Debug.locals.put("branches", _branches);Debug.locals.put("branches", _branches);
 BA.debugLineNum = 120;BA.debugLine="For j = 0 To branches.Size - 1";
Debug.ShouldStop(8388608);
{
final int step32 = 1;
final int limit32 = RemoteObject.solve(new RemoteObject[] {_branches.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step32 > 0 && _j <= limit32) || (step32 < 0 && _j >= limit32) ;_j = ((int)(0 + _j + step32))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 121;BA.debugLine="Dim branchMap As Map = branches.Get(j)";
Debug.ShouldStop(16777216);
_branchmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_branchmap = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _branches.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _j))));Debug.locals.put("branchMap", _branchmap);Debug.locals.put("branchMap", _branchmap);
 BA.debugLineNum = 122;BA.debugLine="Dim branchName As String = GetMapValueOrDe";
Debug.ShouldStop(33554432);
_branchname = BA.ObjectToString(_getmapvalueordefault(_branchmap,BA.ObjectToString("branch_name"),(RemoteObject.createImmutable("Unknown Branch"))));Debug.locals.put("branchName", _branchname);Debug.locals.put("branchName", _branchname);
 BA.debugLineNum = 123;BA.debugLine="Dim branchSales1 As Int = GetMapValueOrDef";
Debug.ShouldStop(67108864);
_branchsales1 = BA.numberCast(int.class, _getmapvalueordefault(_branchmap,BA.ObjectToString("sales1"),RemoteObject.createImmutable((0))));Debug.locals.put("branchSales1", _branchsales1);Debug.locals.put("branchSales1", _branchsales1);
 BA.debugLineNum = 124;BA.debugLine="Dim branchSales2 As Int = GetMapValueOrDef";
Debug.ShouldStop(134217728);
_branchsales2 = BA.numberCast(int.class, _getmapvalueordefault(_branchmap,BA.ObjectToString("sales2"),RemoteObject.createImmutable((0))));Debug.locals.put("branchSales2", _branchsales2);Debug.locals.put("branchSales2", _branchsales2);
 BA.debugLineNum = 125;BA.debugLine="Dim branchSales3 As Int = GetMapValueOrDef";
Debug.ShouldStop(268435456);
_branchsales3 = BA.numberCast(int.class, _getmapvalueordefault(_branchmap,BA.ObjectToString("sales3"),RemoteObject.createImmutable((0))));Debug.locals.put("branchSales3", _branchsales3);Debug.locals.put("branchSales3", _branchsales3);
 BA.debugLineNum = 129;BA.debugLine="Log($\"Company: ${product(i)}, Branch: ${br";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8262194",(RemoteObject.concat(RemoteObject.createImmutable("Company: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_product.getArrayElement(true,BA.numberCast(int.class, _i))))),RemoteObject.createImmutable(", Branch: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_branchname))),RemoteObject.createImmutable(", Sales1: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_branchsales1))),RemoteObject.createImmutable(", Sales2: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_branchsales2))),RemoteObject.createImmutable(", Sales3: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_branchsales3))),RemoteObject.createImmutable(""))),0);
 }
}Debug.locals.put("j", _j);
;
 }else {
 BA.debugLineNum = 132;BA.debugLine="Log($\"Company: ${product(i)} has no branche";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8262197",(RemoteObject.concat(RemoteObject.createImmutable("Company: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_product.getArrayElement(true,BA.numberCast(int.class, _i))))),RemoteObject.createImmutable(" has no branches information."))),0);
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 136;BA.debugLine="barPanel.RemoveAllViews";
Debug.ShouldStop(128);
main.mostCurrent._barpanel.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 137;BA.debugLine="barPanel.Invalidate ' Force redraw";
Debug.ShouldStop(256);
main.mostCurrent._barpanel.runVoidMethod ("Invalidate");
 BA.debugLineNum = 139;BA.debugLine="Dim legend() As String = Array As String(\"Sal";
Debug.ShouldStop(1024);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Sales1"),BA.ObjectToString("Sales2"),RemoteObject.createImmutable("Sales3")});
 BA.debugLineNum = 140;BA.debugLine="barGraph.Initialize(Activity, barPanel, sales";
Debug.ShouldStop(2048);
main.mostCurrent._bargraph.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._barpanel),(Object)(_sales),(Object)(_sales1),(Object)(_sales2),(Object)(_product),(Object)(main.mostCurrent._legend),(Object)(BA.numberCast(int.class, 10000)),(Object)(RemoteObject.createImmutable("Total Sales of the Company")));
 BA.debugLineNum = 141;BA.debugLine="legend = Array As String(\"Purchase1\",\"Purchas";
Debug.ShouldStop(4096);
main.mostCurrent._legend = RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Purchase1"),BA.ObjectToString("Purchase2"),RemoteObject.createImmutable("Purchase3")});
 BA.debugLineNum = 142;BA.debugLine="barGraph1.Initialize(Activity, purchasePanel,";
Debug.ShouldStop(8192);
main.mostCurrent._bargraph1.runClassMethod (b4a.example.bargraph.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._activity),(Object)(main.mostCurrent._purchasepanel),(Object)(_purchase),(Object)(_purchase1),(Object)(_purchase2),(Object)(_product),(Object)(main.mostCurrent._legend),(Object)(BA.numberCast(int.class, 10000)),(Object)(RemoteObject.createImmutable("Total Purchase of the Company")));
 break; }
case 1: {
 BA.debugLineNum = 145;BA.debugLine="ToastMessageShow(\"Data updated successfully\",";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Data updated successfully")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 146;BA.debugLine="LoadCompanyData";
Debug.ShouldStop(131072);
_loadcompanydata();
 break; }
default: {
 BA.debugLineNum = 148;BA.debugLine="Log(\"Unknown job: \" & job.JobName)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8262213",RemoteObject.concat(RemoteObject.createImmutable("Unknown job: "),_job.getField(true,"_jobname" /*RemoteObject*/ )),0);
 break; }
}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e57) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e57.toString()); BA.debugLineNum = 151;BA.debugLine="ToastMessageShow(\"Error parsing sales data\", Tr";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Error parsing sales data")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 }else {
 BA.debugLineNum = 154;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 156;BA.debugLine="job.Release";
Debug.ShouldStop(134217728);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label17_click() throws Exception{
try {
		Debug.PushSubsStack("Label17_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,174);
if (RapidSub.canDelegate("label17_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","label17_click");}
RemoteObject _clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _selectedcompany = RemoteObject.createImmutable("");
 BA.debugLineNum = 174;BA.debugLine="Private Sub Label17_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="Dim clickedLabel As Label = Sender ' Get the clic";
Debug.ShouldStop(16384);
_clickedlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_clickedlabel = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.LabelWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("clickedLabel", _clickedlabel);Debug.locals.put("clickedLabel", _clickedlabel);
 BA.debugLineNum = 176;BA.debugLine="Dim selectedCompany As String = clickedLabel.Tag";
Debug.ShouldStop(32768);
_selectedcompany = BA.ObjectToString(_clickedlabel.runMethod(false,"getTag"));Debug.locals.put("selectedCompany", _selectedcompany);Debug.locals.put("selectedCompany", _selectedcompany);
 BA.debugLineNum = 178;BA.debugLine="Starter.company_selected = selectedCompany";
Debug.ShouldStop(131072);
main.mostCurrent._starter._company_selected /*RemoteObject*/  = _selectedcompany;
 BA.debugLineNum = 181;BA.debugLine="StartActivity(\"Branch\")";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Branch"))));
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("LoadCompanyData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("loadcompanydata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadcompanydata");}
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 69;BA.debugLine="Sub LoadCompanyData";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 71;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(64);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 72;BA.debugLine="Job1.Initialize(\"GetData\", Me)";
Debug.ShouldStop(128);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(BA.ObjectToString("GetData")),(Object)(main.getObject()));
 BA.debugLineNum = 73;BA.debugLine="Job1.Download(PHPURL)";
Debug.ShouldStop(256);
_job1.runClassMethod (b4a.example.httpjob.class, "_download" /*RemoteObject*/ ,(Object)(main.mostCurrent._phpurl));
 BA.debugLineNum = 74;BA.debugLine="ProgressDialogShow(\"Loading Data...\")";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading Data..."))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e7.toString()); BA.debugLineNum = 76;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("LogImpl","8196615",main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),0);
 };
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
branch_subs_0._process_globals();
device_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
branch.myClass = BA.getDeviceClass ("b4a.example.branch");
device.myClass = BA.getDeviceClass ("b4a.example.device");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
bargraph.myClass = BA.getDeviceClass ("b4a.example.bargraph");
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
 //BA.debugLineNum = 19;BA.debugLine="Public company As String";
main._company = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}