package codeHomeWork;

public class Object {
    public final static int TH_NUMBERS = 1;
    public final static int TH_RESULT = 2;
    public final static int TH_STOP = 3;

    private int a;
    private int b;
    private int result;
    private int flag;

    public Object() {
    }

    public Object(int a, int b, int result, int flag) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.flag = flag;
    }

    public static int getThNumbers() {
        return TH_NUMBERS;
    }

    public static int getThResult() {
        return TH_RESULT;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
