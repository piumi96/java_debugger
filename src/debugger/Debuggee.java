package debugger;

public class Debuggee {

    public static void debuggee(){
        String jpda = "Java Platform Debugger Architecture";
        System.out.println("Welcome to Java Platform debugger");

        String jdi = "Java Debug Interface";
        String text = "Today we will dive into " + jdi;
        System.out.println(text);
    }
}
