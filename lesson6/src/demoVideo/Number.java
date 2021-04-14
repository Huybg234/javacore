package demoVideo;

public class Number {
    //lá cờ
    public final static int TH_A = 1;
    public final static int TH_B = 2;
    public final static int TH_C = 3;

    int a;
    int b;
    int c;
    int flag;

    public Number() {
    }

    public Number(int a, int b, int c, int laco) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.flag = laco;
    }

    public static int getThA() {
        return TH_A;
    }

    public static int getThB() {
        return TH_B;
    }

    public static int getThC() {
        return TH_C;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
