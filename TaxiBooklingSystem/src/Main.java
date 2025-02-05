import InpProcessor.ProcessInp;

public class Main {
    public static void main(String[] args) {
        ProcessInp processor = ProcessInp.getInstance();
        processor.start();
    }
}