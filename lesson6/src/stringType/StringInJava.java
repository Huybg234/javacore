package stringType;

import java.util.Arrays;

public class StringInJava {
    public static void main(String[] args) {
        String one = "YaSuo";
        String two = "MalPhinel";

        System.out.println(one.length());
        //Nối hai chuỗi
        System.out.println(one.concat(two));
        //So sánh 2 chuỗi
        System.out.println(one.equals(two));
        //thay thế ký tự cũ bằng ký tự mới
        System.out.println(two.replace("N", "l"));
        //trả về ký tự hiện tại ở vị trí chỉ định
        System.out.println(one.charAt(0));
        //chuyển chuỗi thành một mảng byte
        System.out.println(Arrays.toString(two.getBytes()));
        //chuyển đổi chuỗi thành mảng ký tự
        char[] s1 = one.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
        //chuyển đổi chuỗi thành dạng chữ thường
        System.out.println(one.toLowerCase());
        //chuyển đổi chuỗi thành dạng chữ hoa
        System.out.println(two.toUpperCase());

        //trả về vị trí ký tự được chỉ định
        System.out.println(two.indexOf("l"));
        //so sánh 2 chuỗi theo thứ tự từ điển
        System.out.println(one.compareTo(two));
        //tìm kiếm ký tự trong chuỗi
        System.out.println(one.contains("su"));
        //kiểm tra tiền tố có đúng không
        System.out.println(one.startsWith("ya"));
        //trả về chuỗi con của một chuỗi
        System.out.println(two.substring(1, 6));

        String three = "  Garen Lux   ";
        //xóa khoảng trắng ở đầu và cuối
        System.out.println(three.trim());
        //ngắt chuỗi thành một mảng chuỗi
        String[] words = three.split("\\s");
        for (String w : words) {
            System.out.println(w);
        }
    }
}
