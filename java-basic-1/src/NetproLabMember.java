import java.util.Random;

public class NetproLabMember {
    private static final int years = 15;
    private static final int tdumenbers = 110;
    private static final int maxmenbers = 10; 

    public static void main(String[] args) {
        Random r = new Random();
        double totalProbabilityOfNoFemale = 1.0; // 女性が一人も配属されない確率の初期値

        for (int i = 0; i < years; i++) {
            int totalStudents = tdumenbers + (r.nextInt(21) - 10); 
            int womenRatioPercent = 20 + i; // 女子学生の割合
            int labMembers = maxmenbers + (r.nextInt(7) - 3); 

            int womenStudents = (int) (totalStudents * (womenRatioPercent / 100.0)); // 女子学生の数

            if (womenStudents > 0 && womenStudents <= totalStudents) {
                long totalWays = combination(totalStudents, labMembers);
                long noFemaleWays = combination(totalStudents - womenStudents, labMembers);
                double probOfNoFemale = (double) noFemaleWays / totalWays; // 女子学生が一人も配属されない確率
                totalProbabilityOfNoFemale *= probOfNoFemale;
            }
        }

        System.out.println("15年間岩井研に女性の学生が来ない確率は" + totalProbabilityOfNoFemale);
    }

    public static final long combination(final int n, final int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}
