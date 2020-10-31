package debugger;

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

}
