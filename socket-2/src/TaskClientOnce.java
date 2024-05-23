import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientOnce {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("数字を送ります");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("数宇を入力してください ↓");
            int num = scanner.nextInt();
            scanner.close();

            TaskObject task = new TaskObject();
            task.setExecNumber(num);

            oos.writeObject(task);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject kotae = (TaskObject) ois.readObject();

            int replayMsg = kotae.getResult();
            System.out.println("最大素数は" + replayMsg);

            ois.close();
            oos.close();
            socket.close();

        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
