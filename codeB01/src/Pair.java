/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Truong
 */
public class Pair<T, S> {

    private T bangQuanLy;
    private S soLuong;

    public Pair() {
    }

    public Pair(T bangQuanLy, S soLuong) {
        this.bangQuanLy = bangQuanLy;
        this.soLuong = soLuong;
    }

    public T getBangQuanLy() {
        return bangQuanLy;
    }

    public S getSoLuong() {
        return soLuong;
    }

}
