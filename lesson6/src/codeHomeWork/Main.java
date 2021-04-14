package codeHomeWork;

import java.util.Scanner;

public class Main {
    public static Object object = new Object();

    public static void main(String[] args) {
        object.setFlag(Object.TH_NUMBERS);
        Thread threadNumbers = new Thread(() -> {
            synchronized (object) {
                while (object.getResult() != Object.TH_STOP) {
                    try {
                        if (object.getFlag() == Object.TH_NUMBERS) {
                            System.out.println("Nhập vào a: ");
                            int a = new Scanner(System.in).nextInt();
                            object.setA(a);
                            System.out.println("Nhập vào b: ");
                            int b = new Scanner(System.in).nextInt();
                            object.setB(b);
                            System.out.println("a = " + object.getA());
                            System.out.println("b = " + object.getB());
                            Thread.sleep(5000);
                            object.setFlag(Object.TH_RESULT);
                            object.notifyAll();
                        } else {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadResult = new Thread(() -> {
            synchronized (object) {
                while (true) {
                    try {
                        if (object.getFlag() == Object.TH_RESULT) {
                            int result = object.getA() + object.getB();
                            object.setResult(result);
                            System.out.println("a + b = " + object.getResult());
                            if (object.getResult() > 1000) {
                                object.setFlag(Object.TH_STOP);
                                object.notifyAll();
                                System.out.println("Chương trình đã dừng");
                                break;
                            }
                            Thread.sleep(100);
                            object.setFlag(Object.TH_NUMBERS);
                            object.notifyAll();
                        } else {
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadNumbers.start();
        threadResult.start();
    }
}
