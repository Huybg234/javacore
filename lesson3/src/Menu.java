import javax.jnlp.ClipboardService;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("---1.danh sach ban doc------------");
        System.out.println("----2.danh sach cac dau sach------");
        System.out.println("-----3.bang ql muon sach---------");
        System.out.println("------4.Sap xep theo ten----------");
        System.out.println("-------5.sap xep theo so luong cuon sach duoc muon-------");
        System.out.println("-------6.tim kiem va hien thi ds muon sach theo ten--------");
        System.out.println("-----Chon chuc nang: ");
        Scanner sc = new Scanner(System.in);
        int chon = sc.nextInt();
        switch (chon){
            case 1:
                DSBD dsbd = new DSBD();
                Controller2 controller2 = new Controller2();
                dsbd.nhapDS();
                dsbd.xuatDS();
                break;
            case 2:
                DSSM dssm = new DSSM();
                Controller2 controller21 = new Controller2();
                dssm.nhapDS();
                dssm.xuatDS();
                break;
        }
    }
}
