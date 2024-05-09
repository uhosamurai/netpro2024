import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class XmasTreeKadai {
    
    public static void main(String[] args) {
        int height ;
        String file="XmasTreeKadai_Result.txt";
        Scanner sc= new Scanner(System.in);
        System.out.println("木の高さの数値を入力してください");
        height= sc.nextInt();
        sc.close();
        drawtree(height,file);
        System.out.println("木の高さ"+height+"の木です");
    }

    public static void drawtree(int height,String file){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            // 木の葉と雪
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++) {
                System.out.print("!");
                bw.write("!");
            }
            System.out.print(" ");
            bw.write(" ");
            for (int j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
                bw.write("*");
            }
            System.out.print(" ");
            bw.write(" ");
            for (int j = 0; j < height - i; j++) {
                System.out.print("!");
                bw.write("!");
            }
            System.out.println();
            bw.newLine();
        }
        
//    木の幹
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < height - 1; j++) {
                System.out.print(" ");
                bw.write(" ");
            }
            for (int j = 0; j < 3; j++) {
            System.out.print("|");
            bw.write("!");
            }
            System.out.println();
            bw.newLine();
        }
        
    //    木の鉢
        for (int i = 0; i < 3; i++) { 
            for (int j = 0; j < height - 3; j++) { 
                System.out.print(" ");
                bw.write(" ");
            }
            for (int j = 0; j < 7; j++) { 
                System.out.print("=");
                bw.write("=");
            }
            System.out.println();
            bw.newLine();
        }
        bw.close();
    }catch(IOException e){
        System.out.println(e);
      }
 }
}
