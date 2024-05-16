import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyTCPServer {

    private static final int times = 2;

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("🎁");
        for (int i = 0; i < times; i++) {
            sb.append(content);
        }
        sb.append("🎁");
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("接続しました。相手の入力を待っています......");

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    Gift gift = (Gift) ois.readObject();
                    if (gift.getMessage().equalsIgnoreCase("exit") || gift.getMessage().equalsIgnoreCase("quit")) {
                        break;
                    }
                    String msgGift = gift.getMessage();
                    System.out.println("メッセージは" + msgGift);
                    String giftFromClient = gift.getContent();
                    System.out.println("プレゼントの内容は" + giftFromClient);

                    Gift response = new Gift();
                    response.setMessage("サーバーです。メリークリスマス！\n" + giftFromClient + "ありがとう。\nプレゼントのお返しは" + times + "倍です");
                    response.setContent(serverProcess(giftFromClient));

                    oos.writeObject(response);
                    oos.flush();
                }

                ois.close();
                oos.close();
                socket.close();
            }
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}

