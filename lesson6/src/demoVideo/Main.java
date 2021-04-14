package demoVideo;

import java.util.Random;

public class Main {
    public static Number number = new Number();

    public static void main(String[] args) {
        //gán cờ A chạy trước
        number.setFlag(Number.TH_A);
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (number){
                   for (int i = 0; i <  10;) {
                       try {
                           if (number.getFlag() == Number.TH_A) {
                               int a = new Random().nextInt(10);
                               number.setA(a);
                               System.out.println("a = " + number.getA());
                               Thread.sleep(1000);
                               //sau khi thực hiện xong thì phải chuyển cờ
                               number.setFlag(Number.TH_B);
                               //đánh thức các luồng khác dậy
                               number.notifyAll();
                               i++;
                           } else {
                               //Nếu không phải cờ đấy thì phải đợi
                               number.wait();
                               //khi đợi thì i vẫn tăng
                           }
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //đánh dấu object number là đồng bộ,cấp quyền hạn cho object được gọi
               synchronized (number){
                   for (int i = 0; i < 10;) {
                       try {
                           if (number.getFlag() == Number.TH_B) {
                               int b = new Random().nextInt(10);
                               number.setB(b);
                               System.out.println("b = " + number.getB());
                               Thread.sleep(1000);
                               number.setFlag(Number.TH_C);
                               number.notifyAll();
                               i++;
                           } else {
                               number.wait();
                           }
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (number){
                    for (int i = 0; i < 10;) {
                        try {
                            if (number.getFlag() == Number.TH_C) {
                                number.c = number.a + number.b;
                                System.out.println("a + b = " + number.c);
                                Thread.sleep(1000);
                                number.setFlag(Number.TH_A);
                                number.notifyAll();
                                i++;
                            }
                            else {
                                number.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
    //xử lý deadlock: nhận ra được thời điểm dừng
    //notify():tất cả các thread đang chờ sẽ được đánh thức bất kỳ 1 cái
    //notifyAll():tất cả các thread đang chờ đều sẽ được đánh thức
}
