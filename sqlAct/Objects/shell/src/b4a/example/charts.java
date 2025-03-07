
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class charts implements IRemote{
	public static charts mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public charts() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, charts.class);
    static {
		mostCurrent = new charts();
        remoteMe = RemoteObject.declareNull("b4a.example.charts");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("charts"), "b4a.example.charts");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.example.charts"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4a.example.main _main = null;
public static b4a.example.dash _dash = null;
public static b4a.example.graph _graph = null;
public static b4a.example.schedule _schedule = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Dash",Debug.moduleToString(b4a.example.dash.class),"graph",Debug.moduleToString(b4a.example.graph.class),"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"Main",Debug.moduleToString(b4a.example.main.class),"Schedule",Debug.moduleToString(b4a.example.schedule.class),"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}