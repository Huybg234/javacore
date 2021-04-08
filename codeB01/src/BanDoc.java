/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Truong
 */
public class BanDoc implements Serializable {

    private static int maBDTemp = 10000;
    private int maBD;
    private String tenBD;
    private String diaChi;
    private String SDT;
    private String loaiBD;

    private final String sinhVien = "Sinh vien";
    private final String hocVienCaoHoc = "Hoc vien cao hoc";
    private final String giaoVien = "Giao vien";

    public BanDoc() {
        maBD = maBDTemp;
        maBDTemp++;
    }

    public BanDoc(int maBD, String tenBD, String diaChi, String SDT, String loaiBD) {
        this.maBD = maBD;
        this.tenBD = tenBD;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.loaiBD = loaiBD;
    }

    public int getMaBD() {
        return maBD;
    }

    public String getTenBD() {
        return tenBD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getLoaiBD() {
        return loaiBD;
    }

    public void nhapThongTin() {
        System.out.println("Nhap ten ban doc: ");
        tenBD = new Scanner(System.in).nextLine();
        System.out.println("Nhap dia chi ban doc: ");
        diaChi = new Scanner(System.in).nextLine();
        System.out.println("Nhap so dien thoai ban doc: ");
        SDT = new Scanner(System.in).nextLine();
        System.out.println("Nhap loai ban doc: ");
        boolean check = true;
        do {
            String temp = new Scanner(System.in).nextLine();
            switch (temp) {
                case "Sinh vien":
                    loaiBD = temp;
                    check = false;
                    break;
                case "Hoc vien cao hoc":
                    loaiBD = temp;
                    check = false;
                    break;
                case "Giao vien":
                    loaiBD = temp;
                    check = false;
                    break;
            }
            if (check) {
                System.out.println("Loai ban doc chi co the la '" + sinhVien + "', hoac '"
                        + hocVienCaoHoc + "', hoac '" + giaoVien + "'. Yeu cau nhap lai: ");
            }
        } while (check);
    }

    public void inThongTin() {
        System.out.println(this.maBD + ", " + this.tenBD + ", dia chi: " + this.diaChi + ". SDT: " + this.SDT + ", la " + this.loaiBD);
    }

    public void ghiFile() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("DSBanDoc.dat", true));
            outputStream.writeObject(this);
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
