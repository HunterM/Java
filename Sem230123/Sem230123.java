
import java.io.Console;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

// Найти НОП
public class Sem230123 {

    public static int[] remove(int[] a, int index) {
        if (a == null || index < 0 || index >= a.length) {
            return a;
        }
        int[] b = new int[a.length - 1];
        int remainingElement = a.length - (index + 1);
        System.arraycopy(a, 0, b, 0, index);
        System.arraycopy(a, index + 1, b, index, remainingElement);
        return b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер первой последовательности:");
        int j = in.nextInt();
        int arr1[] = new int[j];
        System.out.println("Введите первую числовую последовательность:");
        for (int i = 0; i < j; i++) {
            arr1[i] = in.nextInt();
        }
        // int arr1[] = {2, 4, 1, 7, 3, 10, 11, 12, 13, 14, 15};
        System.out.println("Введите размер второй последовательности:");
        int k = in.nextInt();
        int arr2[] = new int[j];
        System.out.println("Введите вторую числовую последовательность:");
        for (int i = 0; i < k; i++) {
            arr2[i] = in.nextInt();
        }
        // int arr2[] = {4, 1, 7, 3, 4, 6, 10, 11, 15};
        int x;

        if (arr1.length > arr2.length) {
            x = arr1.length;
        } else {
            x = arr2.length;
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int l = 0; l < arr2.length; l++) {

                int arr3[] = new int[x];
                if (arr1[i] == arr2[l]) {
                    arr3[i] = arr2[l];
                    arr2 = remove(arr2, l);

                    String str = arr3[i].toString(arr3);
                    // int[] numArr = Arrays.stream(arr3[i], int, l).mapToInt(Integer::parseInt).toArray();
                    System.out.print(arr3[i] + " ");

                    // System.out.print(numArr);
                        
                    break;
                }
            }
        }
    }

}
