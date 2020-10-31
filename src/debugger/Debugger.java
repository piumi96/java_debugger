package debugger;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.LaunchingConnector;

import java.util.Map;

public class Debugger {
    private Class debugClass;
    private int[] breakPointLines;

    public void setDebugClass(Class debugClass){
        this.debugClass = debugClass;
    }

    public Class getDebugClass(){
        return this.debugClass;
    }

    public void setBreakPointLines(int[] breakPointLines){
        this.breakPointLines = breakPointLines;
    }

    public int[] getBreakPointLines(){
        return this.breakPointLines;
    }

    public VirtualMachine connectAndLaunchVM() throws Exception {

        LaunchingConnector launchingConnector = Bootstrap.virtualMachineManager().defaultConnector();
        Map<String, Connector.Argument> arguments = launchingConnector.defaultArguments();
        arguments.get("main").setValue(debugClass.getName());
        return launchingConnector.launch(arguments);
    }



    public static void main (String[] args) throws  Exception{
        Debugger debuggerInstance = new Debugger();

        debuggerInstance.setDebugClass(Debuggee.class);
        int[] breakPoints = {6, 9};
        debuggerInstance.setBreakPointLines(breakPoints);
        VirtualMachine vm = null;
        try {
            vm = debuggerInstance.connectAndLaunchVM();
            vm.resume();
        }catch(Exception e ){
            e.printStackTrace();
        }
    }

}
