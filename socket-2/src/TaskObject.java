import java.io.Serializable;

public class TaskObject implements ITask, Serializable {
    private int num;
    private int maxPrime;

    public void setExecNumber(int x) { // クライアントで最初に計算させる数字を入力しておく関数
        this.num = x;
    }

    public int getNum() {
        return num;
    }

    public void exec() { // サーバで計算を実行をさせる関数...計算アルゴリズムが記載される。
        if (num < 2) {
            System.out.println("2以上の整数を入力してください。");
            return;
        }

        maxPrime = 2;

        for (int i = 3; i <= num; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                maxPrime = i;
            }
        }

        System.out.println("最大素数は " + maxPrime + " です。");
    }

    public int getResult() {// クライアントで結果を取り出す関数
        return maxPrime;
    }
}
