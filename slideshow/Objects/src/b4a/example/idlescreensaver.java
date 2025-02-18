package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class idlescreensaver extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.idlescreensaver");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.idlescreensaver.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.Timer _mtimer = null;
public anywheresoftware.b4a.objects.Timer _mtimetimer = null;
public anywheresoftware.b4a.objects.PanelWrapper _mpanel = null;
public anywheresoftware.b4a.objects.collections.List _mimages = null;
public anywheresoftware.b4a.objects.LabelWrapper _mlabel = null;
public int _mcurrentindex = 0;
public int _minterval = 0;
public boolean _misvisible = false;
public int _melapsedtime = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public String  _initialize(b4a.example.idlescreensaver __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,int _insterval) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="idlescreensaver";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_activity,_insterval}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Public Sub Initialize(Activity As Activity,insterv";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="mTimer.Initialize(\"timer\",10000)";
__ref._mtimer /*anywheresoftware.b4a.objects.Timer*/ .Initialize(ba,"timer",(long) (10000));
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="mTimer.Interval = insterval";
__ref._mtimer /*anywheresoftware.b4a.objects.Timer*/ .setInterval((long) (_insterval));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="mTimer.Enabled = True";
__ref._mtimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="mPanel.Initialize(\"\")";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="mPanel.Color = Colors.Black";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setColor(__c.Colors.Black);
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Activity.AddView(mPanel, 0, 0, 100%x, 100%y)";
_activity.AddView((android.view.View)(__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getObject()),(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="mLabel.Initialize(\"\")";
__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .Initialize(ba,"");
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="mLabel.TextSize = 6%y";
__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .setTextSize((float) (__c.PerYToCurrent((float) (6),ba)));
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="mLabel.TextColor = Colors.White";
__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .setTextColor(__c.Colors.White);
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="mLabel.Typeface = Typeface.SERIF";
__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .setTypeface(__c.Typeface.SERIF);
RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="mLabel.Typeface = Typeface.DEFAULT_BOLD";
__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .setTypeface(__c.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="mLabel.Gravity = Gravity.CENTER";
__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .setGravity(__c.Gravity.CENTER);
RDebugUtils.currentLine=1310735;
 //BA.debugLineNum = 1310735;BA.debugLine="mPanel.AddView(mLabel, 0, 0, 100%x, 30%y) ' Set w";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._mlabel /*anywheresoftware.b4a.objects.LabelWrapper*/ .getObject()),(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (30),ba));
RDebugUtils.currentLine=1310738;
 //BA.debugLineNum = 1310738;BA.debugLine="mImages.Initialize";
__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="mImages.Add(\"cyduck.jpg\")";
__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)("cyduck.jpg"));
RDebugUtils.currentLine=1310740;
 //BA.debugLineNum = 1310740;BA.debugLine="mImages.Add(\"pokemon.png\")";
__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)("pokemon.png"));
RDebugUtils.currentLine=1310741;
 //BA.debugLineNum = 1310741;BA.debugLine="mImages.Add(\"profile.jpg\")";
__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)("profile.jpg"));
RDebugUtils.currentLine=1310743;
 //BA.debugLineNum = 1310743;BA.debugLine="mTimeTimer.Initialize(\"TimeTick\", 1000)";
__ref._mtimetimer /*anywheresoftware.b4a.objects.Timer*/ .Initialize(ba,"TimeTick",(long) (1000));
RDebugUtils.currentLine=1310744;
 //BA.debugLineNum = 1310744;BA.debugLine="mTimeTimer.Interval = mInterval";
__ref._mtimetimer /*anywheresoftware.b4a.objects.Timer*/ .setInterval((long) (__ref._minterval /*int*/ ));
RDebugUtils.currentLine=1310745;
 //BA.debugLineNum = 1310745;BA.debugLine="mTimeTimer.Enabled = True";
__ref._mtimetimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1310747;
 //BA.debugLineNum = 1310747;BA.debugLine="mPanel.Visible = False";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(__c.False);
RDebugUtils.currentLine=1310748;
 //BA.debugLineNum = 1310748;BA.debugLine="End Sub";
return "";
}
public String  _showscreensaver(b4a.example.idlescreensaver __ref,boolean _show) throws Exception{
__ref = this;
RDebugUtils.currentModule="idlescreensaver";
if (Debug.shouldDelegate(ba, "showscreensaver", false))
	 {return ((String) Debug.delegate(ba, "showscreensaver", new Object[] {_show}));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Public Sub ShowScreenSaver(Show As Boolean)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="If Show Then";
if (_show) { 
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="If mImages.Size <= 0 Then Return";
if (__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .getSize()<=0) { 
if (true) return "";};
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="mPanel.Visible = True";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(__c.True);
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="mIsVisible = True";
__ref._misvisible /*boolean*/  = __c.True;
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="ShowNextImage";
__ref._shownextimage /*String*/ (null);
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="mTimer.Enabled = False";
__ref._mtimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="mTimeTimer.Enabled = True ' Start time update";
__ref._mtimetimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
 }else {
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="mTimer.Enabled = True";
__ref._mtimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="mTimeTimer.Enabled = False ' Stop time update";
__ref._mtimetimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="mPanel.Visible = False";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .setVisible(__c.False);
RDebugUtils.currentLine=1441804;
 //BA.debugLineNum = 1441804;BA.debugLine="mIsVisible = False";
__ref._misvisible /*boolean*/  = __c.False;
 };
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.idlescreensaver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="idlescreensaver";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Private mTimer As Timer";
_mtimer = new anywheresoftware.b4a.objects.Timer();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Private mTimeTimer As Timer ' Timer for updating";
_mtimetimer = new anywheresoftware.b4a.objects.Timer();
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Private mPanel As Panel";
_mpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Private mImages As List";
_mimages = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Private mLabel As Label";
_mlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Private mCurrentIndex As Int = 0";
_mcurrentindex = (int) (0);
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Public mInterval As Int = 5000 ' Default: 5 secon";
_minterval = (int) (5000);
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="Private mIsVisible As Boolean = False";
_misvisible = __c.False;
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="Private mElapsedTime As Int = 0 ' Track elapsed t";
_melapsedtime = (int) (0);
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="End Sub";
return "";
}
public String  _shownextimage(b4a.example.idlescreensaver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="idlescreensaver";
if (Debug.shouldDelegate(ba, "shownextimage", false))
	 {return ((String) Debug.delegate(ba, "shownextimage", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _img = null;
int _i = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub ShowNextImage";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If mImages.Size = 0 Then Return";
if (__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .getSize()==0) { 
if (true) return "";};
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Dim img As ImageView";
_img = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="img.Initialize(\"\")";
_img.Initialize(ba,"");
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="img.Gravity = Gravity.FILL";
_img.setGravity(__c.Gravity.FILL);
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="img.Bitmap = LoadBitmap(File.DirAssets, mImages.G";
_img.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),BA.ObjectToString(__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .Get(__ref._mcurrentindex /*int*/ ))).getObject()));
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="For i = mPanel.NumberOfViews - 1 To 0 Step -1";
{
final int step6 = -1;
final int limit6 = (int) (0);
_i = (int) (__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getNumberOfViews()-1) ;
for (;_i >= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="If mPanel.GetView(i) Is ImageView Then";
if (__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .GetView(_i).getObjectOrNull() instanceof android.widget.ImageView) { 
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="mPanel.RemoveViewAt(i)";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .RemoveViewAt(_i);
 };
 }
};
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="mPanel.AddView(img, 0, 30%y, 100%x, 70%y)";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(_img.getObject()),(int) (0),__c.PerYToCurrent((float) (30),ba),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (70),ba));
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="mCurrentIndex = (mCurrentIndex + 1) Mod mImages.S";
__ref._mcurrentindex /*int*/  = (int) ((__ref._mcurrentindex /*int*/ +1)%__ref._mimages /*anywheresoftware.b4a.objects.collections.List*/ .getSize());
RDebugUtils.currentLine=1376273;
 //BA.debugLineNum = 1376273;BA.debugLine="End Sub";
return "";
}
public String  _timer_tick(b4a.example.idlescreensaver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="idlescreensaver";
if (Debug.shouldDelegate(ba, "timer_tick", false))
	 {return ((String) Debug.delegate(ba, "timer_tick", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub timer_tick";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="ShowScreenSaver(True)";
__ref._showscreensaver /*String*/ (null,__c.True);
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="mTimer.Enabled = False";
__ref._mtimer /*anywheresoftware.b4a.objects.Timer*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="End Sub";
return "";
}
public String  _timetick_tick(b4a.example.idlescreensaver __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="idlescreensaver";
if (Debug.shouldDelegate(ba, "timetick_tick", false))
	 {return ((String) Debug.delegate(ba, "timetick_tick", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub TimeTick_Tick";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="mElapsedTime = mElapsedTime + 1";
__ref._melapsedtime /*int*/  = (int) (__ref._melapsedtime /*int*/ +1);
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="If mElapsedTime >= 10 Then";
if (__ref._melapsedtime /*int*/ >=10) { 
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="ShowScreenSaver(True)";
__ref._showscreensaver /*String*/ (null,__c.True);
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="mElapsedTime = 0";
__ref._melapsedtime /*int*/  = (int) (0);
 };
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="If mIsVisible Then ShowNextImage";
if (__ref._misvisible /*boolean*/ ) { 
__ref._shownextimage /*String*/ (null);};
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="End Sub";
return "";
}
}