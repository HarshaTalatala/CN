import java.util.*;

class GoBackN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        System.out.print("Enter window size: ");
        int windowSize = sc.nextInt();

        int sent = 0;

        while (sent < totalFrames) {
            for (int i = 0; i < windowSize && sent < totalFrames; i++) {
                System.out.println("Sent frame: " + (sent + 1));
                sent++;
            }

            System.out.print("Enter last ACK received (-1 for error): ");
            int ack = sc.nextInt();

            if (ack == -1) {
                System.out.println("Error: Resending from frame " + sent);
            } else {
                sent = ack;
            }
        }

        System.out.println("All frames sent successfully.");
        sc.close();
    }
}