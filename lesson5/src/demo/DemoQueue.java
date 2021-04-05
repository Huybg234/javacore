package demo;

import java.util.PriorityQueue;
import java.util.Queue;

public class DemoQueue {

    public static void main(String[] args) {
        Queue<Student> stringQueue = new PriorityQueue<>();

        for (int i = 0; i < 10; i++) {
            Student student = new Student("Nguyễn Văn " + i, i, i, "TP" + i);
            stringQueue.add(student);
        }

        System.out.println(stringQueue);
    }

}
