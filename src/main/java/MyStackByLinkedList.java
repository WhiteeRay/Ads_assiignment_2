public class MyStackByLinkedList {
    private MyLinkedList<String> stack;

    public MyStackByLinkedList(){
        stack = new MyLinkedList<>();
    }

    public String push(String newItem){
        stack.addFirst(newItem);
        return newItem;
    }

    public String peek(){
        return stack.get(0);
    }

    public String pop(){
        String removingitem  = peek();
        stack.removeLast();
        return removingitem;
    }
}
