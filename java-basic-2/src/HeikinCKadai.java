import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
    public static final int N = 100;
    public static final int PASSSCORE = 80;
    Kamoku[] kamoku = new Kamoku[N];

    public static void main(String[] args) {
        HeikinCKadai kadai = new HeikinCKadai();
        kadai.randomscore();
        kadai.sortScores();
        kadai.show();
    }

    public void randomscore() {
        Random r = new Random();
        for (int i = 0; i < kamoku.length; i++) {
            int score = r.nextInt(N + 1);
            kamoku[i] = new Kamoku(score, i + 1);
        }
    }

    public void sortScores() {
        Arrays.sort(kamoku); 
    }

    public void show() {
        int sum = 0;
        for (int i = 0; i < kamoku.length; i++) {
            sum += kamoku[i].getScore();
        }
        double average = (double) sum / kamoku.length;

        System.out.println("平均点は" + average);
        System.out.println("以下昇順に並べた合格者の点数です。");

        for (Kamoku k : kamoku) {
            if (k.getScore() >= PASSSCORE) {
                System.out.println(k.TOString());
            }
        }
    }

}
