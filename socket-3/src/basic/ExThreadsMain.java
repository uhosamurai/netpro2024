package basic;


public class ExThreadsMain {
    public static void main(String[] args) {
        // 3つの異なるタスクを作成します
        SumTask sumTask = new SumTask(1, 100, "SumTask");
        SquareSumTask squareSumTask = new SquareSumTask(1, 100, "SquareSumTask");
        CubeSumTask cubeSumTask = new CubeSumTask(1, 100, "CubeSumTask");

        // 各タスクを実行するスレッドを作成します
        Thread thread1 = new Thread(sumTask);
        Thread thread2 = new Thread(squareSumTask);
        Thread thread3 = new Thread(cubeSumTask);

        // スレッドを開始します
        thread1.start();
        thread2.start();
        thread3.start();

        // メインスレッドの処理
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks are completed.");
    }
}

