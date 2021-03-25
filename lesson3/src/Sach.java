import java.util.Scanner;

public class Sach {
    private int idSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namSB;

    public Sach() {
    }

    public Sach(int idSach, String tenSach, String tacGia, String chuyenNganh, int namSB) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namSB = namSB;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getNamSB() {
        return namSB;
    }

    public void setNamSB(int namSB) {
        this.namSB = namSB;
    }
    public void nhapttS(){
        System.out.println("nhap idSach: ");
        this.idSach = new Scanner(System.in).nextInt();
        System.out.println("nhap tenSach: ");
        this.tenSach = new Scanner(System.in).nextLine();
        System.out.println("nhap tacGia: ");
        this.tacGia = new Scanner(System.in).nextLine();
        System.out.println("nhap chuyenNganh");
        this.chuyenNganh = new Scanner(System.in).nextLine();
        System.out.println("nhap namSB: ");
        this.namSB = new Scanner(System.in).nextInt();
    }

    @Override
    public String toString() {
        return "Sach{" +
                "idSach=" + idSach +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", namSB=" + namSB +
                '}';
    }
}
