package demoSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("AAAAAA","bg",20);
        list.add(student1);
        Student student3 = new Student("A","HN",15);
        list.add(student3);
        Student student2 = new Student("AAA","HD",30);
        list.add(student2);

        System.out.println("SortName: ");
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        list.sort((Student o1, Student o2) -> o1.getName().compareTo(o2.getName()));
        for (Student student : list) {
            System.out.println(student.toString());
        }

        System.out.println("SortAge: ");
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        list.sort((Student o1, Student o2) -> o1.getAge() - o2.getAge() );
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}
