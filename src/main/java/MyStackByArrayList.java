public class MyStackByArrayList {
     MyArrayList<String> stack;

     public MyStackByArrayList(){
         stack  = new MyArrayList();
     }

    public Object push(String newItem){
        stack.addLast(newItem);
        return newItem;
    }

    public String peek(){
         return stack.get(stack.size()-1);
    }

    public String pop(){
         String removingItem = peek();
         stack.removeLast();
         return removingItem;
    }

}
