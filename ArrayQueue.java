public class ArrayQueue<T> implements Queue<T> {
    protected int head;
    protected int tail;
    protected int size = 10; //size of array
    protected int count = 0; //keeps track of number of elements
    protected Object[] tempArr;
    protected T[] arr;

    public ArrayQueue(){
        tempArr = new Object[size];
        arr = (T[]) tempArr;

    }

    public T dequeue(){ //remove an element from front of queue
        if (empty()){
            //throw new IllegalArgumentException("ERROR! Queue is empty.");
            return null;
        }
        T temp = arr[head];
        head = (head + 1) % arr.length;
        count--; //decrement every time an element is removed
        return temp;

    }
    public void enqueue(T item){ //adds an element to the queue from the end
        if ((tail + 1) % arr.length == head){ //if array is full already, tail circles back to first index of the array (head)
            grow_array();
        }

        arr[tail++] = item;
        tail = tail % arr.length;
        count++; //increment every time an element is added
    }

    protected void grow_array() { //doubles size of the array
        Object[] temp = new Object[arr.length * 2];
        T[] grownArr = (T[]) temp;
        if (head < tail) {
            System.arraycopy(arr, head, grownArr, 0, tail-head);
            //reset head and tail
            head = 0;
            tail = count;

        }
        if (head >= tail) {
            //copy [head to end]
            System.arraycopy(arr, head, grownArr, 0, arr.length - head);

            //copy [0 to tail]
            System.arraycopy(arr, 0, grownArr, arr.length - head, tail);
            //reset head and tail
            head = 0;
            tail = count;
        }
        arr = grownArr;
    }


    public boolean empty(){ //tests if queue is empty
        if (head == tail){
            return true;
        }
        return false;

    }


}

