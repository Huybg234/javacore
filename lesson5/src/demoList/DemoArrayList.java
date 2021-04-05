package demoList;

import java.util.*;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new java.util.ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
//        list.add(100000);
//        list.add(200000);
        for (int i = 0; i < 20; i += 2) {
            list.add(i);
            list2.add(i);
            //add dùng để thêm phần tử vào trong danh sách
        }
        System.out.println(list);
        System.out.println("-------------------------------");
        System.out.println(list.get(5));
        //get dùng để trả về phần tử tại vị trí chỉ định
        System.out.println("-------------------------------");
        System.out.println(list.set(6, 6));
        //set dùng để thay thế phần tử mới cho phần tử cũ chỉ định
        System.out.println("-------------------------------");
        System.out.println(list.indexOf(18));
        //indexof dùng để trả về vị trí của phần tử chỉ định trong danh sách
        System.out.println("-------------------------------");
        list2.sort(Comparator.reverseOrder());
        System.out.println(list2);
        //sort dùng để sắp xếp các phần tử trong mảng theo một thứ tự nhất định.
        //Comparator.reverseOrder(): sắp xếp các số theo thứ tự giảm dần.
        //Comparator.naturalOrder(): sắp xếp các số theo thứ tự tăng dần.
        System.out.println("-------------------------------");
        System.out.println(list.size());
        //size trả về số lượng phần tử
        System.out.println("-------------------------------");
        list.add(2, 5);
        // thêm số 5 vào danh sách tại vị trí 2
        System.out.println(list);
        System.out.println("-------------------------------");
        System.out.println(list.containsAll(list2));
        //containsAll kiểm tra xem list có chứa tất cả các phần tử của list2 hay không
        System.out.println("-------------------------------");
        list.retainAll(list2);
        System.out.println(list);
        //retainAll giúp giữ lại những phần tử trong mảng có trong mảng khác chứa nó.
        System.out.println("-------------------------------");
        System.out.println(list.contains(500));
        //contains dùng để kiểm tra một phần tử có nằm trong danh sách không
        System.out.println(list.contains(6));
        System.out.println("-------------------------------");
        System.out.println(list.equals(list2));
        //equals so sánh về mặt ngữ nghĩa.
        //== so sánh địa chỉ ô nhớ.
        System.out.println("-------------------------------");
        list.remove(2);
        //remove dùng để xóa một phần tử khỏi danh sách
        System.out.println(list);
        System.out.println("-------------------------------");
        System.out.println(list.subList(4, 9));
        //sublist dùng để trích suất các phần tử chỉ định trong danh sách
        System.out.println("-------------------------------");
        System.out.println(list.hashCode());
        System.out.println("-------------------------------");
        list.addAll(list2);
        System.out.println(list);
        System.out.println("-------------------------------");
        System.out.println(list.isEmpty());
        //isEmpty dùng để kiểm tra dach sách có rỗng không
        System.out.println("-------------------------------");
//        list2.removeAll(list2);
        list.removeAll(list);
        //removeAll dùng để xóa tất cả các phần tử trong danh sách
        System.out.println(list2.equals(list));
        System.out.println("-------------------------------");


        List<String> stringList = new ArrayList<>();
        stringList.add("I am IronMan");
        stringList.add("I am King");
        String s = "you are real man";
        System.out.println(s.indexOf("a"));
        System.out.println(stringList);
        System.out.println(s.lastIndexOf("e"));
        //lastIndexOf trả về vị trí xuất hiện cuối cùng của một một phần tử trong mảng.

        System.out.println("-------------------------------");
        ArrayList<Student> listSV = new java.util.ArrayList<>();

        Student student1 = new Student("Lưu Bị", 21, 10000, "bg");
        listSV.add(student1);
        Student student2 = new Student("Tôn Quyền", 23, 500, "bg");
        listSV.add(student2);
        Student student3 = new Student("Tào Tháo", 20, 5200, "bg");
        listSV.add(student3);
//        System.out.println(listSV);
//        System.out.println(sinhVien1.equals(sinhVien2));
//        System.out.println(sinhVien1 == sinhVien2);
//        System.out.println(sinhVien2.equals(sinhVien3));
        System.out.println("---------------------------");
        System.out.println(listSV.get(0));
        System.out.println("---------------------------");
        Student student4 = new Student("Phượng Sồ", 24, 456123, "HN");
        System.out.println(listSV.set(1, student4));
        System.out.println("------------------------------");
        System.out.println(listSV.indexOf(student4));
        System.out.println("------------------------------");
        System.out.println(listSV.size());
        System.out.println("------------------------------");
        System.out.println(listSV.contains(student1));
        System.out.println("------------------------------");
        System.out.println(listSV.subList(0, 2));
        System.out.println("------------------------------");
        System.out.println(student1.equals(student2));
        System.out.println("------------------------------");
        for (int i = 0; i < listSV.size(); i++) {
//            Object getSV = listSV.get(i);
//            System.out.println(getSV);
            System.out.println(listSV.get(i));
        }
        ArrayList<Integer>Clone = new ArrayList<>();
        Clone = (ArrayList<Integer>) list2.clone();
        System.out.println(Clone);
    }
}
