
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class idlescreensaver {
    public static RemoteObject myClass;
	public idlescreensaver() {
	}
    public static PCBA staticBA = new PCBA(null, idlescreensaver.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mtimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _mtimetimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _mpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _mimages = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _mlabel = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _mcurrentindex = RemoteObject.createImmutable(0);
public static RemoteObject _minterval = RemoteObject.createImmutable(0);
public static RemoteObject _misvisible = RemoteObject.createImmutable(false);
public static RemoteObject _melapsedtime = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"mCurrentIndex",_ref.getField(false, "_mcurrentindex"),"mElapsedTime",_ref.getField(false, "_melapsedtime"),"mImages",_ref.getField(false, "_mimages"),"mInterval",_ref.getField(false, "_minterval"),"mIsVisible",_ref.getField(false, "_misvisible"),"mLabel",_ref.getField(false, "_mlabel"),"mPanel",_ref.getField(false, "_mpanel"),"mTimer",_ref.getField(false, "_mtimer"),"mTimeTimer",_ref.getField(false, "_mtimetimer")};
}
}