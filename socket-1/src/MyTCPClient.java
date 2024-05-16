import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class MyTCPClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("メッセージを入力してください(例:メリークリスマス、終了するには'quit'または'exit') ↓");
                String message = scanner.next();
                if (message.equalsIgnoreCase("exit") || message.equalsIgnoreCase("quit")) {
                    Gift gift = new Gift();
                    gift.setMessage(message);
                    gift.setContent("");
                    oos.writeObject(gift);
                    oos.flush();
                    break;
                }
                System.out.println("プレゼントの内容を入力してください(例:お菓子) ↓");
                String content = scanner.next();

                Gift gift = new Gift();
                gift.setMessage(message);
                gift.setContent(content);

                oos.writeObject(gift);
                oos.flush();

                Gift response = (Gift) ois.readObject();
                String replayMsg = response.getMessage();
                System.out.println("サーバからのメッセージは" + replayMsg);
                String replayContent = response.getContent();
                System.out.println(replayContent + "をもらいました！");
            }

            ois.close();
            oos.close();
            socket.close();
            scanner.close();
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

