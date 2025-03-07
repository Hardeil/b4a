package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _bordercolor = RemoteObject.createImmutable(0);
RemoteObject _borderwidth = RemoteObject.createImmutable(0);
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _roomno = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _status = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _teacherdetail = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _profile = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _originalbitmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
RemoteObject _circularbitmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
RemoteObject _teachername = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _teachertitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _subject = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _totalstudents = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _activestudents = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"dash\")";
Debug.ShouldStop(134217728);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("dash")),main.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="Dim borderColor As Int = Colors.Black";
Debug.ShouldStop(268435456);
_bordercolor = main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");Debug.locals.put("borderColor", _bordercolor);Debug.locals.put("borderColor", _bordercolor);
 BA.debugLineNum = 30;BA.debugLine="Dim borderWidth As Int = 2dip";
Debug.ShouldStop(536870912);
_borderwidth = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)));Debug.locals.put("borderWidth", _borderwidth);Debug.locals.put("borderWidth", _borderwidth);
 BA.debugLineNum = 31;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(1073741824);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 32;BA.debugLine="Panel2.SetLayout(28%x,50%y,250dip,250dip)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel2.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 28)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))));
 BA.debugLineNum = 35;BA.debugLine="Dim roomNo As Label";
Debug.ShouldStop(4);
_roomno = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("roomNo", _roomno);
 BA.debugLineNum = 36;BA.debugLine="roomNo.Initialize(\"\")";
Debug.ShouldStop(8);
_roomno.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 37;BA.debugLine="roomNo.Text = \"Room No.\"";
Debug.ShouldStop(16);
_roomno.runMethod(true,"setText",BA.ObjectToCharSequence("Room No."));
 BA.debugLineNum = 38;BA.debugLine="roomNo.TextSize = 16";
Debug.ShouldStop(32);
_roomno.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 39;BA.debugLine="roomNo.TextColor = Colors.Black";
Debug.ShouldStop(64);
_roomno.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 40;BA.debugLine="roomNo.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(128);
_roomno.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 41;BA.debugLine="roomNo.Gravity = Gravity.CENTER";
Debug.ShouldStop(256);
_roomno.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 42;BA.debugLine="Panel3.AddView(roomNo, 2.6%x, 20dip, 120dip, 35di";
Debug.ShouldStop(512);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_roomno.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2.6)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 44;BA.debugLine="cvs.Initialize(roomNo)";
Debug.ShouldStop(2048);
_cvs.runVoidMethod ("Initialize",(Object)((_roomno.getObject())));
 BA.debugLineNum = 45;BA.debugLine="DrawBorder(cvs, roomNo.Width, roomNo.Height, bord";
Debug.ShouldStop(4096);
_drawborder(_cvs,_roomno.runMethod(true,"getWidth"),_roomno.runMethod(true,"getHeight"),_bordercolor,_borderwidth);
 BA.debugLineNum = 47;BA.debugLine="Dim status As Label";
Debug.ShouldStop(16384);
_status = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("status", _status);
 BA.debugLineNum = 48;BA.debugLine="status.Initialize(\"\")";
Debug.ShouldStop(32768);
_status.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 49;BA.debugLine="status.Text = \"Status\"";
Debug.ShouldStop(65536);
_status.runMethod(true,"setText",BA.ObjectToCharSequence("Status"));
 BA.debugLineNum = 50;BA.debugLine="status.TextSize = 16";
Debug.ShouldStop(131072);
_status.runMethod(true,"setTextSize",BA.numberCast(float.class, 16));
 BA.debugLineNum = 51;BA.debugLine="status.TextColor = Colors.Black";
Debug.ShouldStop(262144);
_status.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 52;BA.debugLine="status.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(524288);
_status.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 53;BA.debugLine="status.Gravity = Gravity.CENTER";
Debug.ShouldStop(1048576);
_status.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 54;BA.debugLine="Panel3.AddView(status, Activity.Width-24%x, 20dip";
Debug.ShouldStop(2097152);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_status.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 24)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 35)))));
 BA.debugLineNum = 56;BA.debugLine="cvs.Initialize(status)";
Debug.ShouldStop(8388608);
_cvs.runVoidMethod ("Initialize",(Object)((_status.getObject())));
 BA.debugLineNum = 57;BA.debugLine="DrawBorder(cvs, status.Width, status.Height, bord";
Debug.ShouldStop(16777216);
_drawborder(_cvs,_status.runMethod(true,"getWidth"),_status.runMethod(true,"getHeight"),_bordercolor,_borderwidth);
 BA.debugLineNum = 59;BA.debugLine="Dim teacherDetail As Panel";
Debug.ShouldStop(67108864);
_teacherdetail = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("teacherDetail", _teacherdetail);
 BA.debugLineNum = 60;BA.debugLine="teacherDetail .Initialize(\"\")";
Debug.ShouldStop(134217728);
_teacherdetail.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 61;BA.debugLine="teacherDetail.Color = Colors.RGB(18,66,36)";
Debug.ShouldStop(268435456);
_teacherdetail.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 66)),(Object)(BA.numberCast(int.class, 36))));
 BA.debugLineNum = 62;BA.debugLine="Panel3.AddView(teacherDetail , 2.5%x, 80dip, Acti";
Debug.ShouldStop(536870912);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_teacherdetail.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2.5)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 32)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 63;BA.debugLine="CreateRadius(teacherDetail)";
Debug.ShouldStop(1073741824);
_createradius(_teacherdetail);
 BA.debugLineNum = 65;BA.debugLine="Dim profile As ImageView";
Debug.ShouldStop(1);
_profile = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("profile", _profile);
 BA.debugLineNum = 66;BA.debugLine="profile.Initialize(\"\")";
Debug.ShouldStop(2);
_profile.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 67;BA.debugLine="profile.BringToFront";
Debug.ShouldStop(4);
_profile.runVoidMethod ("BringToFront");
 BA.debugLineNum = 68;BA.debugLine="Panel3.AddView(profile , Activity.Width-68%x, -30";
Debug.ShouldStop(8);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_profile.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 68)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(BA.numberCast(int.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))).<Integer>get().intValue()))),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 37)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 37)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 70;BA.debugLine="Dim originalBitmap As B4XBitmap = xui.LoadBitmapR";
Debug.ShouldStop(32);
_originalbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_originalbitmap = main._xui.runMethod(false,"LoadBitmapResize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("profile.jpg")),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.getField(true,"False")));Debug.locals.put("originalBitmap", _originalbitmap);Debug.locals.put("originalBitmap", _originalbitmap);
 BA.debugLineNum = 71;BA.debugLine="Dim circularBitmap As B4XBitmap = CreateRoundBitm";
Debug.ShouldStop(64);
_circularbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_circularbitmap = _createroundbitmap(_originalbitmap,main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 14)),main.mostCurrent.activityBA));Debug.locals.put("circularBitmap", _circularbitmap);Debug.locals.put("circularBitmap", _circularbitmap);
 BA.debugLineNum = 72;BA.debugLine="profile .Bitmap = circularBitmap";
Debug.ShouldStop(128);
_profile.runMethod(false,"setBitmap",(_circularbitmap.getObject()));
 BA.debugLineNum = 75;BA.debugLine="Dim teacherName As Label";
Debug.ShouldStop(1024);
_teachername = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("teacherName", _teachername);
 BA.debugLineNum = 76;BA.debugLine="teacherName.Initialize(\"\")";
Debug.ShouldStop(2048);
_teachername.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 77;BA.debugLine="teacherName.Gravity = Gravity.CENTER";
Debug.ShouldStop(4096);
_teachername.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 78;BA.debugLine="teacherName.Text = \"Angel Santos\"";
Debug.ShouldStop(8192);
_teachername.runMethod(true,"setText",BA.ObjectToCharSequence("Angel Santos"));
 BA.debugLineNum = 79;BA.debugLine="teacherName.TextSize = 5%x";
Debug.ShouldStop(16384);
_teachername.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 80;BA.debugLine="teacherName.TextColor = Colors.White";
Debug.ShouldStop(32768);
_teachername.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 81;BA.debugLine="teacherName.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(65536);
_teachername.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 82;BA.debugLine="teacherName.Typeface = Typeface.SERIF";
Debug.ShouldStop(131072);
_teachername.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").getField(false,"SERIF"));
 BA.debugLineNum = 83;BA.debugLine="teacherDetail.AddView(teacherName , 0, 8%y, teach";
Debug.ShouldStop(262144);
_teacherdetail.runVoidMethod ("AddView",(Object)((_teachername.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 8)),main.mostCurrent.activityBA)),(Object)(_teacherdetail.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 85;BA.debugLine="Dim teacherTitle As Label";
Debug.ShouldStop(1048576);
_teachertitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("teacherTitle", _teachertitle);
 BA.debugLineNum = 86;BA.debugLine="teacherTitle.Initialize(\"\")";
Debug.ShouldStop(2097152);
_teachertitle.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 87;BA.debugLine="teacherTitle.Gravity = Gravity.CENTER";
Debug.ShouldStop(4194304);
_teachertitle.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 88;BA.debugLine="teacherTitle.Text = \"Teacher Name\"";
Debug.ShouldStop(8388608);
_teachertitle.runMethod(true,"setText",BA.ObjectToCharSequence("Teacher Name"));
 BA.debugLineNum = 89;BA.debugLine="teacherTitle.TextSize = 2.5%x";
Debug.ShouldStop(16777216);
_teachertitle.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2.5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 90;BA.debugLine="teacherTitle.TextColor = Colors.ARGB(128, 255, 25";
Debug.ShouldStop(33554432);
_teachertitle.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 91;BA.debugLine="teacherDetail.AddView(teacherTitle , 0, teacherNa";
Debug.ShouldStop(67108864);
_teacherdetail.runVoidMethod ("AddView",(Object)((_teachertitle.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_teachername.runMethod(true,"getTop"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4.2)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(_teacherdetail.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 93;BA.debugLine="Dim subject As Panel";
Debug.ShouldStop(268435456);
_subject = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("subject", _subject);
 BA.debugLineNum = 94;BA.debugLine="subject.Initialize(\"\")";
Debug.ShouldStop(536870912);
_subject.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 95;BA.debugLine="subject.Color = Colors.RGB(18,66,36)";
Debug.ShouldStop(1073741824);
_subject.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 66)),(Object)(BA.numberCast(int.class, 36))));
 BA.debugLineNum = 96;BA.debugLine="Panel3.AddView(subject, 1.6%y ,teacherDetail.Top";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_subject.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 1.6)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getTop"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 21.5)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 55)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))));
 BA.debugLineNum = 97;BA.debugLine="CreateRadius(subject)";
Debug.ShouldStop(1);
_createradius(_subject);
 BA.debugLineNum = 100;BA.debugLine="Dim totalStudents As Panel";
Debug.ShouldStop(8);
_totalstudents = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("totalStudents", _totalstudents);
 BA.debugLineNum = 101;BA.debugLine="totalStudents.Initialize(\"\")";
Debug.ShouldStop(16);
_totalstudents.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 102;BA.debugLine="totalStudents.Color = Colors.Transparent ' Set tr";
Debug.ShouldStop(32);
_totalstudents.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 103;BA.debugLine="Panel3.AddView(totalStudents, 60%x ,teacherDetail";
Debug.ShouldStop(64);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_totalstudents.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 60)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getTop"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 21.5)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 37.5)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 110)))));
 BA.debugLineNum = 104;BA.debugLine="CreateRadius(totalStudents)";
Debug.ShouldStop(128);
_createradius(_totalstudents);
 BA.debugLineNum = 106;BA.debugLine="Dim activeStudents As Label";
Debug.ShouldStop(512);
_activestudents = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("activeStudents", _activestudents);
 BA.debugLineNum = 107;BA.debugLine="activeStudents.Initialize(\"\")";
Debug.ShouldStop(1024);
_activestudents.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 108;BA.debugLine="activeStudents.Text = \"No. of Student in the Clas";
Debug.ShouldStop(2048);
_activestudents.runMethod(true,"setText",BA.ObjectToCharSequence("No. of Student in the Classroom"));
 BA.debugLineNum = 109;BA.debugLine="activeStudents.Gravity = Gravity.CENTER";
Debug.ShouldStop(4096);
_activestudents.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 110;BA.debugLine="activeStudents.TextSize = 15dip";
Debug.ShouldStop(8192);
_activestudents.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))));
 BA.debugLineNum = 111;BA.debugLine="Panel3.AddView(activeStudents, 0 ,Panel2.Top + 20";
Debug.ShouldStop(16384);
main.mostCurrent._panel3.runVoidMethod ("AddView",(Object)((_activestudents.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getTop"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(main.mostCurrent._panel3.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 113;BA.debugLine="Log(Activity.Width & \"this is widht\")";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0262230",RemoteObject.concat(main.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable("this is widht")),0);
 BA.debugLineNum = 114;BA.debugLine="Log(Activity.Height & \"this is Height\")";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0262231",RemoteObject.concat(main.mostCurrent._activity.runMethod(true,"getHeight"),RemoteObject.createImmutable("this is Height")),0);
 BA.debugLineNum = 116;BA.debugLine="If Activity.Width > 800 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",main.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, 800))) { 
 BA.debugLineNum = 117;BA.debugLine="teacherDetail.SetLayout(10dip,12%y,Activity.Widt";
Debug.ShouldStop(1048576);
_teacherdetail.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 12)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 90)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220)))));
 BA.debugLineNum = 118;BA.debugLine="profile.SetLayout(2.5%x,teacherDetail.Top + 3%y,";
Debug.ShouldStop(2097152);
_profile.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2.5)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getTop"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 3)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 32)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 32)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 119;BA.debugLine="Dim circularBitmap As B4XBitmap = CreateRoundBit";
Debug.ShouldStop(4194304);
_circularbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_circularbitmap = _createroundbitmap(_originalbitmap,main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 28)),main.mostCurrent.activityBA));Debug.locals.put("circularBitmap", _circularbitmap);Debug.locals.put("circularBitmap", _circularbitmap);
 BA.debugLineNum = 120;BA.debugLine="profile .Bitmap = circularBitmap";
Debug.ShouldStop(8388608);
_profile.runMethod(false,"setBitmap",(_circularbitmap.getObject()));
 BA.debugLineNum = 121;BA.debugLine="teacherName.SetLayout(16%x,10%y,teacherDetail.Wi";
Debug.ShouldStop(16777216);
_teachername.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 16)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 17)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 122;BA.debugLine="teacherName.TextSize = 3.5%y";
Debug.ShouldStop(33554432);
_teachername.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 3.5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 123;BA.debugLine="teacherTitle.SetLayout(16%x,teacherName.Top+5%y,";
Debug.ShouldStop(67108864);
_teachertitle.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 16)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_teachername.runMethod(true,"getTop"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)}, "+",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 17)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 124;BA.debugLine="teacherTitle.TextSize = 2.5%y";
Debug.ShouldStop(134217728);
_teachertitle.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2.5)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 125;BA.debugLine="teacherDetail.SendToBack";
Debug.ShouldStop(268435456);
_teacherdetail.runVoidMethod ("SendToBack");
 BA.debugLineNum = 126;BA.debugLine="subject.SetLayout(1%x,teacherDetail.Top + teache";
Debug.ShouldStop(536870912);
_subject.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getTop"),_teacherdetail.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2.5)),main.mostCurrent.activityBA)}, "++",2, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 127;BA.debugLine="totalStudents.SetLayout(subject.Left+subject.Wid";
Debug.ShouldStop(1073741824);
_totalstudents.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {_subject.runMethod(true,"getLeft"),_subject.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA)}, "++",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_teacherdetail.runMethod(true,"getTop"),_teacherdetail.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 2.5)),main.mostCurrent.activityBA)}, "++",2, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 192)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100)))));
 BA.debugLineNum = 128;BA.debugLine="Panel2.SetLayout(62%x,20%y,250dip,250dip)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._panel2.runVoidMethod ("SetLayout",(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 62)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 20)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 250)))));
 BA.debugLineNum = 129;BA.debugLine="activeStudents.SetLayout(Panel2.Left-2%x,Panel2.";
Debug.ShouldStop(1);
_activestudents.runVoidMethod ("SetLayout",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getLeft"),main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 2)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getTop"),main.mostCurrent._panel2.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "+-",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._panel2.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "+",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))));
 BA.debugLineNum = 130;BA.debugLine="roomNo.Left = 1%x";
Debug.ShouldStop(2);
_roomno.runMethod(true,"setLeft",main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 1)),main.mostCurrent.activityBA));
 BA.debugLineNum = 131;BA.debugLine="status.Left = 39%x";
Debug.ShouldStop(4);
_status.runMethod(true,"setLeft",main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 39)),main.mostCurrent.activityBA));
 };
 BA.debugLineNum = 134;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,190);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 190;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,186);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 186;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btngotosecond_click() throws Exception{
try {
		Debug.PushSubsStack("btnGoToSecond_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,194);
if (RapidSub.canDelegate("btngotosecond_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btngotosecond_click");}
 BA.debugLineNum = 194;BA.debugLine="Sub btnGoToSecond_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="StartActivity(\"Schedule\") ' Navigate to SecondAct";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Schedule"))));
 BA.debugLineNum = 196;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _createradius(RemoteObject _totalstudents) throws Exception{
try {
		Debug.PushSubsStack("CreateRadius (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,136);
if (RapidSub.canDelegate("createradius")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createradius", _totalstudents);}
RemoteObject _bg = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.GradientDrawable");
Debug.locals.put("totalStudents", _totalstudents);
 BA.debugLineNum = 136;BA.debugLine="Sub CreateRadius(totalStudents As Panel)";
Debug.ShouldStop(128);
 BA.debugLineNum = 138;BA.debugLine="Dim bg As GradientDrawable";
Debug.ShouldStop(512);
_bg = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.GradientDrawable");Debug.locals.put("bg", _bg);
 BA.debugLineNum = 139;BA.debugLine="bg.Initialize(\"TOP_BOTTOM\", Array As Int(Colors.R";
Debug.ShouldStop(1024);
_bg.runVoidMethod ("Initialize",(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.drawable.GradientDrawable.Orientation"),"TOP_BOTTOM")),(Object)(RemoteObject.createNewArray("int",new int[] {2},new Object[] {main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 66)),(Object)(BA.numberCast(int.class, 36))),main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 18)),(Object)(BA.numberCast(int.class, 66)),(Object)(BA.numberCast(int.class, 36)))})));
 BA.debugLineNum = 140;BA.debugLine="bg.CornerRadius = 7dip  ' Half of height to make";
Debug.ShouldStop(2048);
_bg.runVoidMethod ("setCornerRadius",BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 7)))));
 BA.debugLineNum = 143;BA.debugLine="totalStudents.Background = bg";
Debug.ShouldStop(16384);
_totalstudents.runMethod(false,"setBackground",(_bg.getObject()));
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("CreateRoundBitmap (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,146);
if (RapidSub.canDelegate("createroundbitmap")) { return b4a.example.main.remoteMe.runUserSub(false, "main","createroundbitmap", _input, _size);}
RemoteObject _l = RemoteObject.createImmutable(0);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
RemoteObject _xview = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _path = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");
RemoteObject _resizedbitmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
Debug.locals.put("Input", _input);
Debug.locals.put("Size", _size);
 BA.debugLineNum = 146;BA.debugLine="Sub CreateRoundBitmap (Input As B4XBitmap, Size As";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="If Input.Width <= 0 Or Input.Height <= 0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("k",_input.runMethod(true,"getWidth"),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("k",_input.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 148;BA.debugLine="Log(\"Error: Invalid bitmap dimensions.\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0393218",RemoteObject.createImmutable("Error: Invalid bitmap dimensions."),0);
 BA.debugLineNum = 149;BA.debugLine="Return Null";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper"), main.mostCurrent.__c.getField(false,"Null"));
 };
 BA.debugLineNum = 154;BA.debugLine="If Input.Width <> Input.Height Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("!",_input.runMethod(true,"getWidth"),_input.runMethod(true,"getHeight"))) { 
 BA.debugLineNum = 155;BA.debugLine="Dim l As Int = Min(Input.Width, Input.Height)";
Debug.ShouldStop(67108864);
_l = BA.numberCast(int.class, main.mostCurrent.__c.runMethod(true,"Min",(Object)(_input.runMethod(true,"getWidth")),(Object)(_input.runMethod(true,"getHeight"))));Debug.locals.put("l", _l);Debug.locals.put("l", _l);
 BA.debugLineNum = 156;BA.debugLine="Input = Input.Crop(Input.Width / 2 - l / 2, Inpu";
Debug.ShouldStop(134217728);
_input = _input.runMethod(false,"Crop",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_input.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),_l,RemoteObject.createImmutable(2)}, "/-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_input.runMethod(true,"getHeight"),RemoteObject.createImmutable(2),_l,RemoteObject.createImmutable(2)}, "/-/",1, 0))),(Object)(_l),(Object)(_l));Debug.locals.put("Input", _input);
 };
 BA.debugLineNum = 159;BA.debugLine="Dim c As B4XCanvas";
Debug.ShouldStop(1073741824);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas");Debug.locals.put("c", _c);
 BA.debugLineNum = 160;BA.debugLine="Dim xview As B4XView = xui.CreatePanel(\"\")";
Debug.ShouldStop(-2147483648);
_xview = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_xview = main._xui.runMethod(false,"CreatePanel",main.processBA,(Object)(RemoteObject.createImmutable("")));Debug.locals.put("xview", _xview);Debug.locals.put("xview", _xview);
 BA.debugLineNum = 161;BA.debugLine="xview.SetLayoutAnimated(0, 0, 0, Size, Size)";
Debug.ShouldStop(1);
_xview.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_size),(Object)(_size));
 BA.debugLineNum = 162;BA.debugLine="c.Initialize(xview)";
Debug.ShouldStop(2);
_c.runVoidMethod ("Initialize",(Object)(_xview));
 BA.debugLineNum = 164;BA.debugLine="Dim path As B4XPath";
Debug.ShouldStop(8);
_path = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XCanvas.B4XPath");Debug.locals.put("path", _path);
 BA.debugLineNum = 165;BA.debugLine="path.InitializeOval(c.TargetRect)";
Debug.ShouldStop(16);
_path.runVoidMethod ("InitializeOval",(Object)(_c.runMethod(false,"getTargetRect")));
 BA.debugLineNum = 166;BA.debugLine="c.ClipPath(path)";
Debug.ShouldStop(32);
_c.runVoidMethod ("ClipPath",(Object)(_path));
 BA.debugLineNum = 169;BA.debugLine="Dim resizedBitmap As B4XBitmap = Input.Resize(Siz";
Debug.ShouldStop(256);
_resizedbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_resizedbitmap = _input.runMethod(false,"Resize",(Object)(_size),(Object)(_size),(Object)(main.mostCurrent.__c.getField(true,"False")));Debug.locals.put("resizedBitmap", _resizedbitmap);Debug.locals.put("resizedBitmap", _resizedbitmap);
 BA.debugLineNum = 170;BA.debugLine="c.DrawBitmap(resizedBitmap, c.TargetRect)";
Debug.ShouldStop(512);
_c.runVoidMethod ("DrawBitmap",(Object)((_resizedbitmap.getObject())),(Object)(_c.runMethod(false,"getTargetRect")));
 BA.debugLineNum = 172;BA.debugLine="c.RemoveClip";
Debug.ShouldStop(2048);
_c.runVoidMethod ("RemoveClip");
 BA.debugLineNum = 175;BA.debugLine="c.DrawCircle(c.TargetRect.CenterX, c.TargetRect.C";
Debug.ShouldStop(16384);
_c.runVoidMethod ("DrawCircle",(Object)(_c.runMethod(false,"getTargetRect").runMethod(true,"getCenterX")),(Object)(_c.runMethod(false,"getTargetRect").runMethod(true,"getCenterY")),(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_c.runMethod(false,"getTargetRect").runMethod(true,"getWidth"),RemoteObject.createImmutable(2),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "/-",1, 0))),(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"White")),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5))))));
 BA.debugLineNum = 176;BA.debugLine="c.Invalidate";
Debug.ShouldStop(32768);
_c.runVoidMethod ("Invalidate");
 BA.debugLineNum = 179;BA.debugLine="Dim res As B4XBitmap = c.CreateBitmap";
Debug.ShouldStop(262144);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper");
_res = _c.runMethod(false,"CreateBitmap");Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 180;BA.debugLine="c.Release";
Debug.ShouldStop(524288);
_c.runVoidMethod ("Release");
 BA.debugLineNum = 181;BA.debugLine="Return res";
Debug.ShouldStop(1048576);
if (true) return _res;
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawborder(RemoteObject _cvs,RemoteObject _width,RemoteObject _height,RemoteObject _bordercolor,RemoteObject _borderwidth) throws Exception{
try {
		Debug.PushSubsStack("DrawBorder (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,20);
if (RapidSub.canDelegate("drawborder")) { return b4a.example.main.remoteMe.runUserSub(false, "main","drawborder", _cvs, _width, _height, _bordercolor, _borderwidth);}
Debug.locals.put("cvs", _cvs);
Debug.locals.put("width", _width);
Debug.locals.put("height", _height);
Debug.locals.put("borderColor", _bordercolor);
Debug.locals.put("borderWidth", _borderwidth);
 BA.debugLineNum = 20;BA.debugLine="Sub DrawBorder(cvs As Canvas, width As Int, height";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="cvs.DrawLine(0, 0, width, 0, borderColor, borderW";
Debug.ShouldStop(1048576);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, 0)),(Object)(_bordercolor),(Object)(BA.numberCast(float.class, _borderwidth)));
 BA.debugLineNum = 22;BA.debugLine="cvs.DrawLine(width, 0, width, height, borderColor";
Debug.ShouldStop(2097152);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, _height)),(Object)(_bordercolor),(Object)(BA.numberCast(float.class, _borderwidth)));
 BA.debugLineNum = 23;BA.debugLine="cvs.DrawLine(width, height, 0, height, borderColo";
Debug.ShouldStop(4194304);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, _width)),(Object)(BA.numberCast(float.class, _height)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _height)),(Object)(_bordercolor),(Object)(BA.numberCast(float.class, _borderwidth)));
 BA.debugLineNum = 24;BA.debugLine="cvs.DrawLine(0, height, 0, 0, borderColor, border";
Debug.ShouldStop(8388608);
_cvs.runVoidMethod ("DrawLine",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, _height)),(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)),(Object)(_bordercolor),(Object)(BA.numberCast(float.class, _borderwidth)));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private Panel3 As Panel";
main.mostCurrent._panel3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private Panel2 As Panel";
main.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _label5_click() throws Exception{
try {
		Debug.PushSubsStack("Label5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,204);
if (RapidSub.canDelegate("label5_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","label5_click");}
 BA.debugLineNum = 204;BA.debugLine="Private Sub Label5_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 205;BA.debugLine="StartActivity(\"Dash\")";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Dash"))));
 BA.debugLineNum = 206;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 207;BA.debugLine="Log(\"yoww\")";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0720899",RemoteObject.createImmutable("yoww"),0);
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label6_click() throws Exception{
try {
		Debug.PushSubsStack("Label6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,198);
if (RapidSub.canDelegate("label6_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","label6_click");}
 BA.debugLineNum = 198;BA.debugLine="Private Sub Label6_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 199;BA.debugLine="StartActivity(\"Dash\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Dash"))));
 BA.debugLineNum = 200;BA.debugLine="Activity.Finish";
Debug.ShouldStop(128);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 201;BA.debugLine="Log(\"yoww\")";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("LogImpl","0655363",RemoteObject.createImmutable("yoww"),0);
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("LoadMySQLData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,16);
if (RapidSub.canDelegate("loadmysqldata")) { return b4a.example.main.remoteMe.runUserSub(false, "main","loadmysqldata");}
 BA.debugLineNum = 16;BA.debugLine="Sub LoadMySQLData";
Debug.ShouldStop(32768);
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
dash_subs_0._process_globals();
charts_subs_0._process_globals();
graph_subs_0._process_globals();
schedule_subs_0._process_globals();
starter_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
dash.myClass = BA.getDeviceClass ("b4a.example.dash");
charts.myClass = BA.getDeviceClass ("b4a.example.charts");
circularprogressbar.myClass = BA.getDeviceClass ("b4a.example.circularprogressbar");
graph.myClass = BA.getDeviceClass ("b4a.example.graph");
schedule.myClass = BA.getDeviceClass ("b4a.example.schedule");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}