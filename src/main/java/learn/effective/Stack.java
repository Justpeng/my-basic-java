package learn.effective;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Description: 对象引用
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 09/30/2017-12:07
 */
public class Stack {
    private Object[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size]=null;//消除对象引用
        return result;
    }

    public Object pop1() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return elements[--size];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++]=e;
    }

    private void ensureCapacity() {
        if(elements.length==size)
            elements = Arrays.copyOf(elements, 2 * size + 1);

    }
}
