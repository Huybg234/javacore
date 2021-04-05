package demoSet;

import java.util.HashSet;
/*
Cơ chế lấy phần tử kiểu băng đạn
 */

public class DemoHashSet {
    public static void main(String[] args) {
        HashSet<Student>old = new HashSet<>();
        HashSet<Student>young = new HashSet<>();
        Student student1 = new Student("Lưu Bị", "bg",20);
        old.add(student1);
        Student student2 = new Student("Tào Tháo","hn",21);
        old.add(student2);
        Student student3 = new Student("Tôn Quyền","hd",22);
        old.add(student3);
        Student student4 = new Student("Phượng Sồ","hn",23);
        young.add(student4);
        System.out.println(old);

        System.out.println(old.size());

        young.addAll(old);
        System.out.println(young);

        System.out.println(old.contains(student4));
        System.out.println(young.containsAll(old));

        System.out.println(old.isEmpty());

        young.remove(student4);
        System.out.println(young);
        System.out.println(young.equals(old));

        System.out.println(young.hashCode());

        old.remove(student1);
        young.retainAll(old);
        System.out.println(young);

//        young.clear();
        young.removeAll(old);
        System.out.println(young);

       young = (HashSet<Student>) old.clone();
        System.out.println(young);
    }
}
