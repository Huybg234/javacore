package demo;

import java.util.HashMap;
import java.util.Map;

public class DemoMap {
    public static void main(String[] args) {
        Map<Integer,Student>bigmap = new HashMap();
        //<Key,Value>
        Student student1 = new Student("Huy",21,270,"BG");
        bigmap.putIfAbsent(1,student1);
        //nếu key chưa tồn tại thì thêm như bt
        //nếu key đã tồn tại thì lấy Value mới hơn
        Student student2 = new Student("Hai", 21,280,"HN");
        bigmap.put(2,student2);
        Student student3 = new Student("Ba",22,300,"HD");
        bigmap.put(1,student3);
        //Lưu trữ Value chỉ định và liên kết nó với một Key chỉ định
        System.out.println(bigmap);
        System.out.println("--------------------------");
        System.out.println(bigmap.get(1));
        //Trả về Value được liên kết một Key chỉ định
        System.out.println(bigmap.containsKey(2));
        System.out.println(bigmap.containsValue(student3));
        //Contains tìm kiếm
        bigmap.replace(1,student1);
        //thay thế value của Key chỉ định thành Value chỉ định
        System.out.println(bigmap);
        System.out.println(bigmap.entrySet());
        //taoh một tập hợp phần tử giống với hashmap
        System.out.println(bigmap.keySet());
        //keyset trả về tất cả các key
        bigmap.remove(1);
        System.out.println(bigmap);
        System.out.println(bigmap.values());
        //trả về Value

        System.out.println("---------------------------");
        Map<Integer,Student>smallmap = new HashMap();
        smallmap.put(3,student3);
        System.out.println(smallmap);
        System.out.println(smallmap.equals(bigmap));
    }
}
