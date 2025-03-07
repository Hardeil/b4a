
package b4a.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class circularprogressbar {
    public static RemoteObject myClass;
	public circularprogressbar() {
	}
    public static PCBA staticBA = new PCBA(null, circularprogressbar.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XCanvas");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _mlbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _cx = RemoteObject.createImmutable(0f);
public static RemoteObject _cy = RemoteObject.createImmutable(0f);
public static RemoteObject _radius = RemoteObject.createImmutable(0f);
public static RemoteObject _stroke = RemoteObject.createImmutable(0f);
public static RemoteObject _clrfull = RemoteObject.createImmutable(0);
public static RemoteObject _clrempty = RemoteObject.createImmutable(0);
public static RemoteObject _mbase = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _currentvalue = RemoteObject.createImmutable(0f);
public static RemoteObject _durationfromzeroto100 = RemoteObject.createImmutable(0);
public static RemoteObject _totalvalue = RemoteObject.createImmutable(0f);
public static b4a.example.main _main = null;
public static b4a.example.dash _dash = null;
public static b4a.example.charts _charts = null;
public static b4a.example.graph _graph = null;
public static b4a.example.schedule _schedule = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"clrEmpty",_ref.getField(false, "_clrempty"),"clrFull",_ref.getField(false, "_clrfull"),"currentValue",_ref.getField(false, "_currentvalue"),"cvs",_ref.getField(false, "_cvs"),"cx",_ref.getField(false, "_cx"),"cy",_ref.getField(false, "_cy"),"DurationFromZeroTo100",_ref.getField(false, "_durationfromzeroto100"),"mBase",_ref.getField(false, "_mbase"),"mCallBack",_ref.getField(false, "_mcallback"),"mEventName",_ref.getField(false, "_meventname"),"mLbl",_ref.getField(false, "_mlbl"),"radius",_ref.getField(false, "_radius"),"stroke",_ref.getField(false, "_stroke"),"totalValue",_ref.getField(false, "_totalvalue"),"xui",_ref.getField(false, "_xui")};
}
}