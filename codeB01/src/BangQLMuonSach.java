/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Truong
 */
public class BangQLMuonSach {

    private BanDoc banDoc = new BanDoc();
    ArrayList<Sach> dsSach = new ArrayList<>();
    ArrayList<Integer> dsSoLuong = new ArrayList<>();

    public BangQLMuonSach() {
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public ArrayList<Sach> getDsSach() {
        return dsSach;
    }

    public ArrayList<Integer> getDsSoLuong() {
        return dsSoLuong;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public void addSach(Sach s) {
        this.dsSach.add(s);
    }

    public void addSoLuong(int soLuong) {
        this.dsSoLuong.add(soLuong);
    }

    public void inThongTin() {
        System.out.println("Ban doc " + this.banDoc.getTenBD() + " da muon cac cuon sach: ");
        for (int i = 0; i < dsSach.size(); i++) {
            System.out.println("\t" + this.dsSach.get(i).getTenSach() + ", voi so luong " + this.dsSoLuong.get(i));
        }
    }

    public void ghiFile() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("DSBangQLMuonSach.txt", true));
            writer.write("Ban doc " + this.banDoc.getTenBD() + " da muon cac cuon sach: \r\n");
            for (int i = 0; i < dsSach.size(); i++) {
                writer.write("\t" + this.dsSach.get(i).getTenSach() + ", voi so luong " + this.dsSoLuong.get(i) + "\r\n");
            }
        } catch (IOException ex) {
            System.out.println("Exception: Su co ghi file.");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.out.println("Exception: Su co dong file.");
            }
        }
    }
}
