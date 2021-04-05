package demo;

import java.util.Stack;

/*
first in last out : FILO
 */
public class DemoStack {
    public static void main(String[] args) {
        Stack<Student> old = new Stack<>();
        Student student1 = new Student("Kim", "bg", 18);
        Student student2 = new Student("Mộc", "hn", 19);
        old.add(student1);
        old.add(student2);
        System.out.println(old);

        Stack<Student> young = new Stack<>();
        Student student3 = new Student("Thủy", "cm", 20);
        young.add(student3);
        System.out.println(young);

        System.out.println(young.empty());
        //kiểm tra xem stack có trống không
        System.out.println(old.peek());
        //trả về phần tử trên cùng, không gỡ bỏ
        System.out.println(old);
        System.out.println("--------------------------");
        System.out.println(old.pop());
        // trả về phần tử trên cùng, gỡ bỏ luôn
        System.out.println(old);
        System.out.println("--------------------------- ");
        System.out.println(old.push(student3));
        //đẩy phần tử lên trên cùng stack, đồng thời trả về phần tử đó
        System.out.println(old);
        System.out.println("-----------------------------");
        System.out.println(old.search(student2));
        System.out.println(old.search(student3));
        //tìm kiếm phần tử trong stack, trả về vị trí đếm từ trên cùng
        //không thấy trả về -1
    }
}
