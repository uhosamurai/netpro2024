
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
			System.out.println("何歳ですか?");
			String line = reader.readLine();
			
				if (line.equals("q") || line.equals("e")) {
					break;
				}
				int age = 0;
				try {
					age = Integer.parseInt(line);
				} catch (NumberFormatException e) {
					System.out.println("数字を入力してください。");
					continue;
				}
				if (age >= 120 || age < 0) {
					System.out.println("再入力してください");
					continue;
				}
				System.out.println("2030年のあなたの年齢は" + (age + 7) + "です。");
				System.out.println("あなたが誕生した年の元号は" + years(2023-age));
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static String years(int year) {
		if (year >= 2019) {
			return "令和" + (year - 2018) + "年です";
		} else if (year >= 1989) {
			return "平成" + (year - 1988) + "年です";
		} else if (year >= 1926) {
			return "昭和" + (year - 1925) + "年です。";
		} else if (year >= 1912) {
			return "大正" + (year - 1911) + "年です";
		} else {
			return "明治" + (year - 1866) + "年です";
		}
	}
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
