package demoSort;

import java.util.*;

/**
 * @author truongbb
 */
public class LambdaSort {

    private static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {

        initiateData();

        Student student1 = list.get(0);
        student1.showInfo();
        student1.setName("agrtsh");

        Date birthday = new Date();
        student1.setBirthday(birthday);
        // tương tự với
        student1.setBirthday(new Date());


        // đây là cách bình thường
        SubComparator subComparator = new SubComparator();
        list.sort(subComparator);
//        Collections.sort(list, subComparator);


        // thao tác dưới đây tương tự với việc:
        // 1. tạo 1 class implement Comparator
        // 2. tạo 1 đối tượng của class vừa mới tạo ở bước 1
        // --> thao tác này gọi là tạo một class vô danh (anonymous class) có từ java 7
        Comparator comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        list.sort(comparator);
//        Collections.sort(list, comparator);

        // một cách ngắn gọn hơn nữa là không cần khởi tạo 1 object comparator mà truyền trực tiếp luôn vào hàm sort
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                System.out.println("235358");
                return o1.getName().compareTo(o2.getName());
            }
        });
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                System.out.println("235358");
                return o1.getName().compareTo(o2.getName());
            }
        });

        // đây là cách viết theo kiểu lambda
        list.sort((abc, o2) -> {
            System.out.println("235358");
            return abc.getName().compareTo(o2.getName());
        });


        Collections.sort(list, (o1, o2) -> {
            System.out.println("235358");
            return o1.getName().compareTo(o2.getName());
        });


        list.sort((o1, o2) -> o1.getName().compareTo(o2.getName())); // đẹp???


        list.sort(Comparator.comparing(Student::getName));// đẹp nhất --> method reference --> học sau!!!

    }

    private static void initiateData() {
        Student student1 = new Student("AAAAAA", "bg", 20);
        list.add(student1);
        Student student3 = new Student("A", "HN", 15);
        list.add(student3);
        Student student2 = new Student("AAA", "HD", 30);
        list.add(student2);
    }

}
