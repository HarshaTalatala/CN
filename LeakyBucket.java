import java.util.*;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queries: ");
        int noOfQueries = sc.nextInt();
        System.out.println("Enter bucket size, input packet size, output packet size:");
        int bucketSize = sc.nextInt();
        int inputPacketSize = sc.nextInt();
        int outputPacketSize = sc.nextInt();
        int storage = 0;

        System.out.println("Leaky Bucket Simulation\n");

        for (int i = 1; i <= noOfQueries; i++) {
            System.out.println("Query " + i + ":");

            int sizeLeft = bucketSize - storage; // Remaining space

            if (inputPacketSize <= sizeLeft) {
                storage += inputPacketSize;
            } else {
                System.out.println("Packet loss = " + inputPacketSize);
            }

            System.out.println("Buffer size = " + storage +
                    " out of bucket size = " + bucketSize);

            // Leak out packets
            storage -= outputPacketSize;

            System.out.println();
            sc.close();
        }
    }
}