import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSSM extends Sach implements Controller {
    Sach sach = new Sach();
    Controller2 controller2 = new Controller2();
    Scanner sc = new Scanner(System.in);
    private ArrayList<Sach> dssm;

    public DSSM() {
        this.dssm = new ArrayList<>();
    }

    public void nhapDS() {
        try {
            Scanner sc = new Scanner(new File("SM.INP"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Nhap so luong sach muon nhap: ");
        int t = sc.nextInt();
        System.out.println("Nhap danh sach sach");
        while (t-- > 0) {
            sach.nhapttS();
            dssm.add(sach);
        }
    }

    public void xuatDS() {
        for (Sach sach : dssm) {
            System.out.println(sach.toString());
            dssm.add(sach);
        }
    }

    @Override
    public <T> void ghiFile(List<T> list, String filename) {
        controller2.ghiFile(dssm, "SM.INP");
    }

    @Override
    public <T> void docFile(String filename) {
        controller2.docFile("SM.INP");
    }
}
