package practice.JavaBasic.Lab07;
import java.util.Vector;

interface IStack<T> {
    T pop();
    boolean push(T ob);
}

class MyStack<T> implements IStack<T> {
    Object[] stck = new Object[10];
    Vector<T> v; // = new Vector<T>(); // 이게 되나..? 생성자에 넣기!

    MyStack() {
        v = new Vector<T>();
    }
    public T pop() {
        int size = v.size();
        if (size > 0) {
            T get = v.get(size-1);
            v.remove(size -1);
            return get;
        }
        else
            return null;
    }

    public boolean push(T ob){
        if (v.size()==10) {
            return false;
        }
        else {
            v.add(ob);
            return true;
        }
    }
}

public class StackManager {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();

        for (int i=0; i<10; i++) {
            myStack.push(i);
        }

        for (int i=0; i<10; i++){
            System.out.print(myStack.pop()+" ");
        }
    }
}
