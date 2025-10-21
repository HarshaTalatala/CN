public class CheckSum {
    public static void main(String[] args) {
        String b1 = "10101010";
        String b2 = "11110000";

        int sum = Integer.parseInt(b1, 2) + Integer.parseInt(b2, 2);

        // Handle carry for 8-bit addition
         sum = (sum & 0xFF) + (sum >> 8);

        // One's complement
         int checksum = ~sum & 0xFF;

        // Convert to binary string
        String checksumBin = String.format("%8s", Integer.toBinaryString(checksum)).replace(' ', '0');

        System.out.println("CheckSum: " + checksumBin);
    }
}
