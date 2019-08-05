package hu.flowacademy;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<String> list = Arrays.asList("a", "b", "c");
        HideValue<String> val1 = new HideValue<>("Cica");
        System.out.println(val1);
        HideValue<Integer> val2 = new HideValue<>(200);
        System.out.println(val2);
        MyStack<String> stack = new MyStack<>(10);
        stack.push("cica");
        stack.push("kutya");
        System.out.println(stack.toString());
        String s = stack.pop();
        System.out.println("POP: " + s);
        System.out.println(stack.toString());
        System.out.println(stack.peek());


    }
}
