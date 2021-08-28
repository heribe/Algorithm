package LeetCode;

public class TestThread {
    int g = 0;
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void test(){
        Thread thread = new Thread(){
            public void run(){
                test1();
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        });
        thread1.start();
        thread.start();
//        for (int i = 0; i < 1000000 ; i++) {
//            new Thread(new Thable()).start();
//        }
//        System.out.println(g);

    }

    void test1(){
        synchronized (this){
            System.out.println("thread begin");
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("thread end");
        }

    }

    synchronized void test2(){
        synchronized (lock2){
            System.out.println("thread1 start");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("thread1 end");
        }

    }

}
