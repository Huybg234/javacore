package stringType;

public class StringBuilderInJava {
    public static void main(String[] args) {

        StringBuilder s1 = new StringBuilder("Hello");
        s1.append("Java");
        s1.append(12);
        s1.append(1.465);
        System.out.println(s1);
        s1.delete(5, 9);
        System.out.println(s1);

        StringBuilder s2 = new StringBuilder("King");
        char[] c = {'s', 'a', 'd', 'c'};
        //chèn chuỗi mới và vị trí chỉ định
        s2.insert(1, "eep");
        s2.insert(6, "G");
        s2.insert(0, 2.001);
        s2.append(c);
        System.out.println(s2);
        //thay thế chuỗi con bằng chuỗi khác
        s2.replace(0, 1, "Sl");
        System.out.println(s2);
        //đảo ngược chuỗi hiện tại
        System.out.println(s2.reverse());

        StringBuilder s3 = new StringBuilder();
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
