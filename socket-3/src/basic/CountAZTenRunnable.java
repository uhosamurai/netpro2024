package basic;


public class CountAZTenRunnable implements Runnable {
    private char character;

    public void setChar(char c) {
        this.character = c;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(character + String.valueOf(i));
                Thread.sleep(100); // 100ミリ秒間隔でカウント
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[26];
        for (int i = 0; i < 26; i++) {
            char c = (char) (97 + i); // 'a' to 'z'
            CountAZTenRunnable ct = new CountAZTenRunnable();
            ct.setChar(c);
            threads[i] = new Thread(ct, "th-" + c);
            threads[i].start();
        }

        // メインスレッドでカウントアップの進行を表示
        try {
            for (int i = 1; i <= 10; i++) {
                for (int j = 0; j < 26; j++) {
                    System.out.print((char) (97 + j) + String.valueOf(i) + " ");
                }
                System.out.println();
                Thread.sleep(1000); // 1秒間隔でカウント
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}

