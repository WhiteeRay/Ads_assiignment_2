import models.MyArrayList;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> ages = new MyArrayList<>();
        MyArrayList<String> names = new MyArrayList<>();
        names.add("hewrr");
        names.add("srtttr");
        ages.add("asas");
        ages.add("hii");
//        long start = System.nanoTime();
//        for(String age : ages){
//            System.out.println(age);
//        }
//        long end =System.nanoTime();
//        System.out.println(end - start);
//        System.out.println(ages.getLast());
//        System.out.println(names.exists("srtttr"));
        ages.sort();
        System.out.println(ages);

    }
}