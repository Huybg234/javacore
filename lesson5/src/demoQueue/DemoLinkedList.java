package demoQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DemoLinkedList {
    public static void main(String[] args) {
        LinkedList<Student> old = new LinkedList<>();
        Student student1 = new Student("Kim long","warcraft",3000);
        Student student2 = new Student("Hồng Long","warcraft",2500);
        old.add(student1);
        old.add(student2);
        System.out.println(old);
        LinkedList<Student> young = new LinkedList<>();
        Student student3 = new Student("Hắc Long","warcraft",2000);
        young.add(student3);

        old.addLast(student3);
        System.out.println(old);

        System.out.println(old.element());
        //element trả về phần tử đầu tiên trong list

        System.out.println(old.contains(student3));

        System.out.println(old.peek());
        //trả về phần tử đầu(trên cùng)

        System.out.println(old.get(1));

        System.out.println(old.getFirst());
        System.out.println(old.getLast());

        System.out.println(old.indexOf(student1));
        //indexOf trả về vị trí phần tử

        System.out.println(old.poll());
        //trả về phần tử đầu và xóa luôn
        System.out.println(old);

        System.out.println(old.removeLast());
    }
}
