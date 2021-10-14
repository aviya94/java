import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();
    private int minStack;

    public void pushToStack(int numberToPush) {

        stack.push(numberToPush);
        updateMin(numberToPush);
    }

    public void updateMin(int numberToPush) {

        if (stack.empty()) {
            stackMin.push(numberToPush);
        }
        else if (stackMin.peek() >= numberToPush) {
            stackMin.push(numberToPush);
        }

        minStack = stackMin.peek();
    }

    public int popFromStack() {

        int popNumber;

        if (stack.empty()) {
            throw new NullPointerException("you cant pop from an empty stack");
        }

        popNumber = stack.pop();
        RemoveFromMinStack(popNumber);
        return popNumber;
    }

    private void RemoveFromMinStack(int popNumber) {

        if (popNumber == stackMin.peek()) {
            stackMin.pop();
            minStack = stackMin.peek();
        }
    }

    public int getMinStack() {

        return minStack;
    }

}
