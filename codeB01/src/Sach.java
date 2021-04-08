/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Truong
 */
public class Sach implements Serializable {

    private static int maSachTemp = 10000;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namXB;

    private final String KHTT = "Khoa hoc tu nhien";
    private final String VHNT = "Van hoc nghe thuat";
    private final String DTVT = "Dien tu vien thong";
    private final String CNTT = "Cong nghe thong tin";

    public Sach() {
        maSach = maSachTemp;
        maSachTemp++;
    }

    public Sach(int maSach, String tenSach, String tacGia, String chuyenNganh, int namXB) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXB = namXB;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNamXB() {
        return namXB;
    }

    public void nhapThongTin() {
        System.out.println("Nhap ten sach: ");
        tenSach = new Scanner(System.in).nextLine();
        System.out.println("Nhap tac gia cua cuon sach: ");
        tacGia = new Scanner(System.in).nextLine();
        System.out.println("Nhap chuyen nganh cua sach: ");
        boolean check = true;
        do {
            String temp = new Scanner(System.in).nextLine();
            switch (temp) {
                case "Khoa hoc tu nhien":
                    chuyenNganh = temp;
                    check = false;
                    break;
                case "Van hoc nghe thuat":
                    chuyenNganh = temp;
                    check = false;
                    break;
                case "Dien tu vien thong":
                    chuyenNganh = temp;
                    check = false;
                    break;
                case "Cong nghe thong tin":
                    chuyenNganh = temp;
                    check = false;
                    break;
            }
            if (check) {
                System.out.println("Chuyen nganh chi co the la '" + KHTT + "', hoac '"
                        + VHNT + ",' hoac '" + DTVT + "', hoac '" + CNTT + "'. Yeu cau nhap lai: ");
            }
        } while (check);
        System.out.println("Nhap nam xuat ban cua sach: ");
        namXB = new Scanner(System.in).nextInt();
    }

    public void inThongTin() {
        System.out.println(this.maSach + ", " + this.tenSach + ", cua tac gia " + this.tacGia
                + ", thuoc chuyen nganh " + this.chuyenNganh + ", xuat ban nam " + this.namXB);
    }

    public void ghiFile() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("DSSach.dat", true));
            outputStream.writeObject(this);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception: Khong tim thay file.");
        } catch (IOException ex) {
            System.out.println("Exception: Su co ghi file.");
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                System.out.println("Exception: SU co dong file.");
            }
        }
    }

}
