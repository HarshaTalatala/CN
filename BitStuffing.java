import java.util.*;

class BitStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bits: ");
        String bits = sc.next();

        System.out.println("Original Data: " + bits);

        StringBuilder stuffedData = new StringBuilder();
        int count = 0;

        for (char bit : bits.toCharArray()) {
            stuffedData.append(bit);
            if (bit == '1') {
                count++;
                if (count == 5) {
                    stuffedData.append('0');
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Stuffed Data: " + stuffedData);

        sc.close();
    }
}