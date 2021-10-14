public class Main {
    public static void main(String[] args){

        MinStack m=new MinStack();
        m.pushToStack(5);
        m.pushToStack(1);
        m.pushToStack(10);
        m.pushToStack(2);
        m.pushToStack(3);
        m.pushToStack(1);
        m.popFromStack();
        m.popFromStack();
        m.popFromStack();

    }
}
