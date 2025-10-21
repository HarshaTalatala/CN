import java.util.Scanner;

public class HammingCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] d = new int[4];
        System.out.println("Enter 4 data bits: ");

        for (int i = 0; i < 4; i++)
            d[i] = sc.nextInt();

        int p1 = d[0] ^ d[1] ^ d[3];
        int p2 = d[0] ^ d[2] ^ d[3];
        int p3 = d[1] ^ d[2] ^ d[3];

        System.out.println("Hamming code: " + p1 + p2 + d[0] + p3 + d[1] + d[2] + d[3]);
        sc.close();
    }
}