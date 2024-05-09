import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MayExceptionTest {
    public static void main(String[] args) {
        new MayExceptionTest();
    }

    MayExceptionTest() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("何日ですか?");
            String line = reader.readLine();
            int theday = Integer.parseInt(line);
            System.out.println("日付" + theday + "日ですね。");

            test(theday);
        } catch(IOException e) {
            System.out.println("入出力エラーが発生しました: " + e.getMessage());
        } catch (NoHolidayException e) {
            e.printStackTrace();
        }
    }

    void test(int theday) throws NoHolidayException {
        if(theday==3 || theday==4 || theday==5 || theday==6){
			throw new NoHolidayException();
		}
    }

}


