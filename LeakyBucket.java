import java.util.*;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of queries: ");
        int n = sc.nextInt();

        System.out.println("Enter bucket size, input packet size, output packet size:");
        int bucket = sc.nextInt();
        int input = sc.nextInt();
        int output = sc.nextInt();

        int storage = 0;

        System.out.println("\nLeaky Bucket :\n");

        for (int i = 1; i <= n; i++) {
            System.out.println("Query " + i + ":");

            int space = bucket - storage;

            if (input <= space)
                storage += input;
            else
                System.out.println("Packet loss = " + input);

            System.out.println("Buffer size = " + storage +
                    " out of bucket size = " + bucket);

            storage -= output;
            System.out.println();
        }
        sc.close();
    }
}
