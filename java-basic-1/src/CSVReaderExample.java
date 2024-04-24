import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReaderExample {
public static void main(String[] args) {
String csvFile = "C:/Users/hodak/Downloads/jusho.csv"; // ファイルのパスを指定してください
String line = "";
String csvSplitBy = ","; // CSVファイルの区切り文字を指定してください

Pattern pattern = Pattern.compile(".*?([^\s]+区).*");

  try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((line = br.readLine()) != null) {
            // 1行をカンマで分割して単語の配列を取得
            String[] words = line.split(csvSplitBy);

            for (String word : words) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.matches()) {
                    System.out.println(matcher.group(1));
            }
        }//while end
    }
    } catch (IOException e) {
        e.printStackTrace();
    }
  }//main end
}//class end

