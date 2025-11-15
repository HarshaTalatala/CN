import java.util.*;

class CheckSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for(int i = 0; i < n; i++)
            sum += sc.nextInt();

        int checksum = ~sum;   // 1's complement
        System.out.println("Checksum: " + checksum);

        int recvSum = 0;
        for(int i = 0; i < n; i++)
            recvSum += sc.nextInt();

        recvSum += sc.nextInt();   // add checksum

        if(~recvSum == 0)
            System.out.println("No Error");
        else
            System.out.println("Error Found");
    }
}
