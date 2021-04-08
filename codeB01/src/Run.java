/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 *
 * @author Truong
 */
public class Run {

    private ArrayList<BanDoc> dsBanDoc = new ArrayList<>();
    ArrayList<Sach> dsSach = new ArrayList<>();
    ArrayList<BangQLMuonSach> dsBang = new ArrayList<>();

    int choice = 0;

    boolean check1 = false, check2 = false, check3 = false;

    private void menu() {
        while (true) {
            System.out.println("\t\tCHUONG TRINH QUAN LY MUON SACH THU VIEN");
            System.out.println("\t1. Nhap danh sach ban doc va in ra man hinh.");
            System.out.println("\t2. Nhap danh sach sach va in ra man hinh.");
            System.out.println("\t3. Lap bang quan ly muon sach cho tung ban doc.");
            System.out.println("\t4. Sap xep danh sach bang muon sach theo: ");
            System.out.println("\t\t1. Ten ban doc.");
            System.out.println("\t\t2. So luong cuon sach duoc muon (giam dan).");
            System.out.println("\t5. Tim kiem theo ten ban doc.");
            System.out.println("\t6. Thoat chuong trinh.");
            System.out.println("---------------------------------------------");
            System.out.println("Chon chuc nang: ");
            do {
                int temp = new Scanner(System.in).nextInt();
                if (temp < 7 && temp > 0) {
                    choice = temp;
                    break;
                }
                System.out.println("Chuc nang chon sai, yeu cau chon lai: ");
            } while (true);
            switch (choice) {
                case 1:
                    nhapDSBanDoc();
                    check1 = true;
                    System.out.println("Nhap danh sach thanh cong, sau day la danh sach: ");
                    inDSBanDoc();
                    break;
                case 2:
                    nhapDSSach();
                    check2 = true;
                    System.out.println("Nhap danh sach thanh cong, sau day la danh sach: ");
                    inDSSach();
                    break;
                case 3:
                    if (check1 && check2) {
                        lapBangMuonSach();
                        check3 = true;
                        System.out.println("Lap bang thanh cong, sau day la danh sach bang: ");
                        inDSBang();
                    } else {
                        System.out.println("Ban can nhap danh sach ban doc va sach truoc.");
                    }
                    break;
                case 4:
                    if (check3) {
                        menuJunior();
                    } else {
                        System.out.println("Ban can lap bang quan ly muon sach truoc.");
                    }
                    break;
                case 5:
                    if (check3) {
                        timKiem();
                    } else {
                        System.out.println("Ban can lap bang quan ly muon sach truoc.");
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private void nhapDSBanDoc() {
        System.out.println("Nhap so luong ban doc muon them: ");
        int soBD = new Scanner(System.in).nextInt();
        for (int i = 0; i < soBD; i++) {
            System.out.println("Nhap thong tin cho ban doc thu " + (i + 1) + ": ");
            BanDoc banDoc = new BanDoc();
            banDoc.nhapThongTin();
            dsBanDoc.add(banDoc);
            banDoc.ghiFile();
        }
    }

    private void inDSBanDoc() {
        dsBanDoc.forEach(new Consumer<BanDoc>() {
            @Override
            public void accept(BanDoc t) {
                t.inThongTin();
            }
        });
    }

    private void nhapDSSach() {
        System.out.println("Nhap so luong sach muon them: ");
        int soSach = new Scanner(System.in).nextInt();
        for (int i = 0; i < soSach; i++) {
            System.out.println("Nhap thong tin cho cuon sach thu " + (i + 1) + ": ");
            Sach s = new Sach();
            s.nhapThongTin();
            dsSach.add(s);
            s.ghiFile();
        }
    }

    private void inDSSach() {
        dsSach.forEach(new Consumer<Sach>() {
            @Override
            public void accept(Sach t) {
                t.inThongTin();
            }
        });
    }

    private void lapBangMuonSach() {
        for (int i = 0; i < dsBanDoc.size(); i++) {
            BangQLMuonSach bangQLMuonSach = new BangQLMuonSach();
            bangQLMuonSach.setBanDoc(dsBanDoc.get(i));
            System.out.println("Nhap so luong sach ma ban doc mang ma so " + dsBanDoc.get(i).getMaBD() + " da muon: ");
            int soDauSach;
            do {
                int temp = new Scanner(System.in).nextInt();
                if (temp > 0 && temp < 6) {
                    soDauSach = temp;
                    break;
                }
                System.out.println("So dau sach phai la so duong va khong vuot qua  5.");
            } while (true);
            int t = 1;
            for (int j = 0; j < soDauSach; j++) {
                System.out.println("Nhap ma sach thu " + t + " ma ban doc nay muon: ");
                boolean duplicate = false, timThay = false;
                int maSachTemp = 0, mTemp;
                do {
                    do {
                        mTemp = new Scanner(System.in).nextInt();
                        for (int k = 0; k < bangQLMuonSach.getDsSach().size(); k++) {
                            if (mTemp == bangQLMuonSach.getDsSach().get(k).getMaSach()) {
                                timThay = true;
                                System.out.println("Cuon sach nay da duoc chinh ban doc nay muon, yeu cau nhap lai: ");
                                break;
                            }
                        }
                    } while (duplicate);
                    maSachTemp = mTemp;
                    for (int k = 0; k < dsSach.size(); k++) {
                        if (maSachTemp == dsSach.get(k).getMaSach()) {
                            timThay = true;
                            bangQLMuonSach.addSach(dsSach.get(k));
                            System.out.println("Nhap so luong sach ma ban doc muon o dau sach nay: ");
                            int soLuong;
                            do {
                                int temp = new Scanner(System.in).nextInt();
                                if (temp > 0 && temp < 4) {
                                    soLuong = temp;
                                    break;
                                }
                                System.out.println("So luong sach o 1 dau sach la so duong va khong vuot qua 3.");
                            } while (true);
                            bangQLMuonSach.addSoLuong(soLuong);
                            t++;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Khong tim thay cuon sach yeu cau, yeu cau nhap lai: ");
                    }
                } while (!timThay);

            }
            dsBang.add(bangQLMuonSach);
            bangQLMuonSach.ghiFile();
        }
    }

    private void inDSBang() {
        dsBang.forEach(new Consumer<BangQLMuonSach>() {
            @Override
            public void accept(BangQLMuonSach t) {
                t.inThongTin();
            }
        });
    }

    private void menuJunior() {
        System.out.println("Sap xep danh sach bang quan ly theo: ");
        System.out.println("\t1. Ten ban doc.");
        System.out.println("\t2. So luong cuon sach duoc muon (giam dan)");
        System.out.println("Chon chuc nang: ");
        int choice1 = 0;
        do {
            int temp = new Scanner(System.in).nextInt();
            if (temp == 1 || temp == 2) {
                choice1 = temp;
                break;
            }
            System.out.println("Chuc nang chon sai, yeu cau chon lai: ");
        } while (true);
        switch (choice1) {
            case 1:
                sapXepTheoTen();
                break;
            case 2:
                sapXepTheoSoLuong();
                break;
        }
    }

    private void sapXepTheoTen() {
        Collections.sort(dsBang, new Comparator<BangQLMuonSach>() {
            @Override
            public int compare(BangQLMuonSach o1, BangQLMuonSach o2) {
                if (o1.getBanDoc().getTenBD().compareTo(o2.getBanDoc().getTenBD()) < 0) {
                    return -1;
                } else {
                    if (o1.getBanDoc().getTenBD().equals(o2.getBanDoc().getTenBD())) {
                        return 0;
                    }
                }
                return 1;
            }
        });
        inDSBang();
    }

    private void sapXepTheoSoLuong() {
        ArrayList<Integer> dsSoLuonng = new ArrayList<>();
        ArrayList<Pair<BangQLMuonSach, Integer>> dsKetHop = new ArrayList<>();
        for (int i = 0; i < dsBang.size(); i++) {
            int tong = 0;
            for (int j = 0; j < dsBang.get(i).getDsSoLuong().size(); j++) {
                tong += dsBang.get(i).getDsSoLuong().get(j);
            }
            dsSoLuonng.add(tong);
            Pair<BangQLMuonSach, Integer> tempPair = new Pair<>(dsBang.get(i), dsSoLuonng.get(i));
            dsKetHop.add(tempPair);
        }
        Collections.sort(dsKetHop, new Comparator<Pair<BangQLMuonSach, Integer>>() {
            @Override
            public int compare(Pair<BangQLMuonSach, Integer> o1, Pair<BangQLMuonSach, Integer> o2) {
                if (o1.getSoLuong() < o2.getSoLuong()) {
                    return -1;
                } else {
                    if (o1.getSoLuong() == o2.getSoLuong()) {
                        return 0;
                    }
                }
                return 1;
            }
        });
        dsKetHop.forEach(new Consumer<Pair<BangQLMuonSach, Integer>>() {
            @Override
            public void accept(Pair<BangQLMuonSach, Integer> t) {
                t.getBangQuanLy().inThongTin();
            }
        });
    }

    private void timKiem() {
        System.out.println("Nhap ten muon tim kiem: ");
        String ten = new Scanner(System.in).nextLine();
        boolean timThay = false;
        for (int i = 0; i < dsBang.size(); i++) {
            if (dsBang.get(i).getBanDoc().getTenBD().equals(ten)) {
                timThay = true;
                dsBang.get(i).inThongTin();
                System.out.println("-------------------------------------");
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay ban doc yeu cau.");
        }
    }

    public static void main(String[] args) {
        Run r = new Run();
        r.menu();
    }
}
