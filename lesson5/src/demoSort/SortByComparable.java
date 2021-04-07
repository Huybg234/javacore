package demoSort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortByComparable {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        Student student1 = new Student("AAAAAA","bg",20);
        list.add(student1);
        Student student3 = new Student("A","HN",15);
        list.add(student3);
        Student student2 = new Student("AAA","HD",30);
        list.add(student2);

        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}
