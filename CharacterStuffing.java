import java.util.*;

class CharacterStuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String:");
        String input = sc.next();

        System.out.println("Original data: " + input);

        StringBuilder stuffedData = new StringBuilder();
        char ESC = (char) 0x7D;   // }
        char FLAG = (char) 0x7E;  // ~

        for (char ch : input.toCharArray()) {
            if (ch == FLAG || ch == ESC) {
                stuffedData.append(ESC);   // add ESC before special char
            }
            stuffedData.append(ch);
        }

        System.out.println("Stuffed Data: " + stuffedData);
        sc.close();
    }
}
