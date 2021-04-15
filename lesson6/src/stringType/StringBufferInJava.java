package stringType;

public class StringBufferInJava {

    public static void main(String[] args) {

//        String s1 = "Huy";
//        String s2 = "Nguyễn";
//        s1 += s2;
//        //String là một class của java
//        //s1, s2 là một object
//        //khi lấy s1 + s2 hệ thống sẽ tạo ra 1 vùng nhớ mới
//        System.out.println(s1);

        //nối chuỗi mới vào sau chuỗi cũ
        StringBuffer s1 = new StringBuffer("Huy");
        s1.append("Nguyen").append("Quang");
        System.out.println(s1);
        //xóa chuỗi trong khoảng chỉ định
        s1.delete(9, 14);
        System.out.println(s1);

        StringBuffer s2 = new StringBuffer("King");
        //chèn chuỗi mới và vị trí chỉ định
        s2.insert(1, "eep");
        System.out.println(s2);
        //thay thế chuỗi con bằng chuỗi khác
        s2.replace(0, 1, "Sl");
        System.out.println(s2);
        //đảo ngược chuỗi hiện tại
        System.out.println(s2.reverse());

        StringBuffer s3 = new StringBuffer();
        //trả về dung lượng bộ nhớ
        //mặc định 16
        System.out.println(s3.capacity());
        s3.append("The");
        System.out.println(s3.capacity());
        //16
        //dung lượng vẫn chưa tăng vì lượng ký tự trong chuỗi ko thay đổi
        s3.append("Queen");
        System.out.println(s3.capacity());
        //16
        //dung lượng tăng vì lượng ký tự trong chuỗi tăng(ở đây tăng từ 1 lên 3)
        s3.append("Sleeping In Rungle");
        System.out.println(s3.capacity());
        System.out.println(s3);
        //34
        System.out.println(s3.charAt(1));
        System.out.println(s3.indexOf("Queen"));
        //in ra chuỗi con trong khoảng chỉ định và không là biến mất trong chuỗi cha
        System.out.println(s3.subSequence(0, 3));
        System.out.println(s3);
        //Thay thế từ mới vào từ cũ chỉ định
        s3.setCharAt(0, 't');
        System.out.println(s3);
        //trả về mã Unicode
        int code = s3.codePointAt(1);
        System.out.println(code);
    }
}
