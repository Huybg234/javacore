package reFlectionAndAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Annotation;

public class Main {
    /*
     * Reflection là một cách truy cập khác vào đối tượng nếu biết tên đối tượng
     * truy cập, thay đổi thuộc tính, phương thức nếu biết tên chúng
     * có thể truy cập được dữ liệu kiểu private
     *
     * Annotation là ghi chú chỉ dẫn khi code chạy
     * để ghi đè
     * Annotation có 2 loại: có sẵn và tự định nghĩa
     * có sẵn: @override
     * tự tạo @DoSomething
     * @param
     */
    public static void main(String[] args) {
        @HereIsNewStudent(name ="Hải", score=10.15f)
        ISinhVien sv3;

        SinhVien sinhVien = new SinhVien(1000, "Hải", 3.55f);
        //VD không biết sinhVien thuộc class nào
        //coi như sinhVien được lấy về từ mạng, từ đâu đó,..
        //làm thế nào để biết sinhVien thuộc class nào?

        Class svClass = sinhVien.getClass();
        //Tên bình thường
        System.out.println("Tên : " + svClass.getName());
        //Tên đơn giản
        System.out.println("Tên: " + svClass.getSimpleName());
        //Tên packet
        System.out.println("Tên: " + svClass.getCanonicalName());

        //tạo object mà không cần new
        Object sinhVien2 = null;
        try {
            sinhVien2 = Class.forName("reFlectionAndAnnotation.SinhVien").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sinhVien2 instanceof SinhVien);
        //Danh sách hàm
        Method[] methods = svClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            //Ta có thể sử dụng method của đối tượng nếu biết tên của đối tượng
            if (method.getName().equals("printInfo")) {
                try {
                    //invoke để truyền vào object được gọi
                    method.invoke(sinhVien);
                    method.invoke(sinhVien2);

                    Field[] fields = svClass.getDeclaredFields();
                    for (Field f : fields) {
                        //lấy về tên các biến được khai báo trong class
                        System.out.println(f.getName());
                        if (f.getName().equals("score")) {
                            //cấp quyền sửa
                            f.setAccessible(true);
                            f.setFloat(sinhVien, 10.33f);
                            Annotation[] annotations= (Annotation[]) f.getAnnotations();
                            annotations[0].getValue();
                        }
                    }
                    System.out.println("Điểm của sinh viên: " + sinhVien.getScore());
//                    sinhVien.printInfo();
                    //khác nhau: 1 cái gọi gián tiếp, tên hàm dạng chuỗi nhập từ bàn phím, từ đâu đó
                    //1 cái gọi thông thường.
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
