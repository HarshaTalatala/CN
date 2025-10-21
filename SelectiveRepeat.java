import java.util.Scanner;

public class SelectiveRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();
        int[] frames = new int[n];

        System.out.println("Enter frame data: ");
        for (int i = 0; i < n; i++) {
            frames[i] = sc.nextInt();
        }

        System.out.println("\nSending frames...\n");

        for (int i = 0; i < n; i++) {
            System.out.println("Sending frame " + i + ": " + frames[i]);

            if (i == 1 || i == 3) { // mark frames 1 and 3 as lost
                System.out.println("Frame " + i + " lost! Retransmitting...");
                System.out.println("Retransmitting frame " + i + ": " + frames[i]);
                System.out.println();
            } else {
                System.out.println("Frame " + i + " sent successfully.\n");
            }
        }

        System.out.println("All frames sent successfully!");
        sc.close();
    }
}