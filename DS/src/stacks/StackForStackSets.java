


package stacks;

class StackForStackSets {
    
    private int top = -1;   
    private int[] arr;
    // Maximum size of stack
    private int capacity;
     
    StackForStackSets(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }
     
    public void push(int v){
        arr[++top] = v;
    }
     
    public int pop(){
         
        return arr[top--];
    }
    
    // if the stack is at capacity
    public Boolean isAtCapacity(){
        return capacity == top + 1;
    }
    
    //return the size of the stack
    public int size(){
        return top+1;
    }
     
    public String toString(){
        String s = "";
        int index = top;
        while(index >= 0){
            s += "[" + arr[index--] + "]"+ " --> ";
        }
        return s;
         
    }
}
