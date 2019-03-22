import java.util.Arrays;
public class ArrayStack<T> implements Stack<T> {
    protected int size = 10; //size of array
    protected Object[] tempArr;
    protected T[] arr;
    protected int top;

    public ArrayStack(){
        tempArr = new Object[size];
        arr = (T[])tempArr;
        top = -1;
    }


    public void push(T item){ //pushes element onto the stack & returns the element

        if (top == arr.length-1){ //if array is full, double the array size
            grow_array();
        }
        top++;
        arr[top] = item;

    }

    public T pop(){ //returns the top element of the stack & removes it
        if (empty()){
            return null;
        }
        return arr[top--];

    }

    public T peek(){ //returns the element at top of the stack without removing it
        if (empty()){
            return null;
        }
        return arr[top];

    }

    public boolean empty(){ //tests if this stack is empty
        if (top == -1){
            return true; //stack is empty
        }
        return false; //stack isn't empty

    }

    protected void grow_array(){ //doubles size of the array
        //System.out.println("Old array length: " + arr.length);
        T[] temp = (T[]) (new Object[arr.length * 2]);
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
        //System.out.println("New array length: " + arr.length);
        //System.out.println(Arrays.toString(arr));
    }

}
