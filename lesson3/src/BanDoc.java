import java.util.Scanner;

public class BanDoc { // Reader
    private int idbanDoc; // id
    private String hoTen; // fullName
    private String diaChi; // address
    private String sDT; // phoneNumber
    private int loaiBD; // type

    public BanDoc() {
    }

    public BanDoc(int idbanDoc, String hoTen, String diaChi, String sDT, String loaiBD) {
        this.idbanDoc = idbanDoc;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDT = sDT;
    }

    public int getIdbanDoc() {
        return idbanDoc;
    }

    public void setIdbanDoc(int idbanDoc) {
        this.idbanDoc = idbanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public int getLoaiBD() {
        return loaiBD;
    }

    public void setLoaiBD(int loaiBD) {
        this.loaiBD = loaiBD;
    }

    public void nhapTTBD() {
        System.out.println("nhap id :");
        this.idbanDoc = new Scanner(System.in).nextInt();
        System.out.println("nhap hoTen :");
        this.hoTen = new Scanner(System.in).nextLine();
        System.out.println("nhap diaChi :");
        this.diaChi = new Scanner(System.in).nextLine();
        System.out.println("nhap sDT :");
        this.sDT = new Scanner(System.in).nextLine();
        System.out.println("Chon loaiBD :");
        System.out.println("1.Sinh Vien");
        System.out.println("2.Hoc Vien Cao Hoc");
        System.out.println("3.Giao Vien");
        int chon = new Scanner(System.in).nextInt();
        switch (chon) {
            case 1:
                System.out.println("Sinh Vien");
                break;
            case 2:
                System.out.println("Hoc Vien Cao Hoc");
                break;
            case 3:
                System.out.println("Giao Vien");
                break;
        }
        this.loaiBD = chon;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "idbanDoc=" + idbanDoc +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sDT='" + sDT + '\'' +
                ", loaiBD='" + loaiBD + '\'' +
                '}';
    }
}
