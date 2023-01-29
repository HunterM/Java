import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class secondTaskNew {

    public class main {

        public static double degree(int a, int b) {
            
            double c = 1;

            if (b > 0) {
                for (int i = 1; i <= b; i++) {
                    c = c * a;
                }
            } else if (b == 0) {
                c = 1;
            } else if (b < 0) {
                for (int i = 1; i <= b * (-1); i++) {
                    c = c * a;
                }
                c = 1 / c;
            }
            return c;
        }

        public static void main(String[] args) throws IOException {
            Scanner in = new Scanner(new File("D:/JavaV01/Java/Sem230123/input.txt"));
            PrintWriter out = new PrintWriter(new File("D:/JavaV01/Java/Sem230123/output.txt"));
            int a, b;
            a= in.nextInt();
            b = in.nextInt();
            
            double z = degree(a, b);
            String str = Double.toString(z);
            out.println(str);
            out.close();
            in.close();
            // Scanner in = new Scanner(System.in);
            // System.out.println("Введите исходное число:");
            // int a = in.nextInt();
            // // int a = 5;
            // System.out.println("Введите степень в которую хотите возвести число:");
            // int b = in.nextInt();
            // // int b = 5;

            System.out.println("Число " + a + " в степени " + b + " будет равно: " + degree(a, b));
        }
    }
}
