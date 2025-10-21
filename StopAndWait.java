import java.util.Scanner;

public class StopAndWait {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Sender: Sending frame " + i);

            if (i == 1 || i == 3) {
                System.out.println("Frame " + i + " lost! Retransmitting...");
                System.out.println("Sender: Retransmitting frame " + i);
            }

            System.out.println("Receiver: Frame " + i + " received");
            System.out.println("Receiver: Sending ACK for frame " + i);
            System.out.println("Sender: ACK for frame " + i + " received\n");
        }

        System.out.println("All frames sent successfully!");
        sc.close();
    }
}
