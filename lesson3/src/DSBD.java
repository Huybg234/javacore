import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSBD extends BanDoc implements Controller{
    BanDoc banDoc = new BanDoc();
    Controller2 controller2 = new Controller2();
    Scanner sc = new Scanner(System.in);
    private ArrayList<BanDoc> dsbd;
    public DSBD(){
        this.dsbd = new ArrayList<>();
    }
    public void nhapDS() {
        try {
            Scanner sc = new Scanner(new File("BD.INP"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Nhap so luong ban doc muon nhap: ");
        int t = sc.nextInt();
        System.out.println("Nhap danh sach ban doc");
        while(t-->0) {
            banDoc.nhapTTBD();
            dsbd.add(banDoc);
        }
    }
    public void xuatDS(){
        for(BanDoc banDoc: dsbd){
            System.out.println(banDoc.toString());
        }
    }

    @Override
    public <T> void ghiFile(List<T> list, String filename) {
        controller2.ghiFile(dsbd,"BD.INP");
    }

    @Override
    public <T> void docFile(String filename) {
        controller2.docFile("BD.INP");
    }
}
