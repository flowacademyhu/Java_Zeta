package hu.flowacademy;

public class MyStack<E> {

    private int pointer;
    private E[] arr;

    public MyStack(int length) {
        pointer = 0;
        arr = (E[]) new Object[length];
    }

    public void push(E value) throws OverflowException {
        if (pointer == arr.length) throw new OverflowException("Overflow");
        arr[pointer] = value;
        pointer++;
    }

    public E pop() throws UnderflowException {
        if (pointer == 0) throw new UnderflowException("Underflow");
        pointer--;
        return arr[pointer];
    }

    public E peek() throws UnderflowException {
        if (pointer == 0) throw new UnderflowException("Underflow");
        return arr[pointer - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: [ ");
        for (int i = 0; i < pointer; i++) {
            sb.append(arr[i]);
            sb.append(' ');
        }
        sb.append(']');
        return sb.toString();
    }
}

class UnderflowException extends RuntimeException {

    public UnderflowException(String message) {
        super(message);
    }

}
