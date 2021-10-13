import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private int minStack;

    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void pushToStack(int numberToPush) {

        updateMinStack(numberToPush);
        stack.push((Integer) numberToPush);

    }

    public int popToStack() {
        int popNumber;

        if (stack.empty()) {
            throw new NullPointerException("you cant pop from an empty stack");
        }

        popNumber = stack.pop();

        if (minStack == popNumber) {
            RemoveMinStack();
        }

        return popNumber;
    }

    private void RemoveMinStack() {

        int min = stack.peek();
        minStack = min;

        for (Integer e : stack) {
            if (e < min) {
                minStack = e;
                min = e;
            }
        }
    }

    public void updateMinStack(int number) {

        if (stack.empty()) {
            minStack = number;
        }
        else {
            if (minStack > number) {
                minStack = number;
            }
        }

    }
    public int getMinStack(){
        
        return minStack;
    }

}
