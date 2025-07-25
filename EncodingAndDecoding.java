import java.util.Scanner;

public class EncodingAndDecoding {
    public static String encode(String message, int shift) {
        return shiftMessage(message, shift);
    }

    public static String decode(String message, int shift) {
        return shiftMessage(message, -shift);
    }

    public static String shiftMessage(String message, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26; // Since there are 26 alphabets

        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' + shift + 26) % 26 + 'A');
                result.append(ch);
            } else if (Character.isLowerCase(c)) {
                char ch = (char) ((c - 'a' + shift + 26) % 26 + 'a');
                result.append(ch);
            } else result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = sc.nextLine();
        System.out.print("Enter shift length: ");
        int shift = sc.nextInt();

        String encodedMessage = encode(message, shift);
        String decodedMessage = decode(encodedMessage, shift);

        System.out.println();
        System.out.println("Encoded message : " + encodedMessage);
        System.out.println("Decoded message : " + decodedMessage);

        sc.close();
    }
}