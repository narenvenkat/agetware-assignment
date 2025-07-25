import java.math.BigInteger;
import java.util.Scanner;

public class IndianCurrencyFormatter {

    public static String formatIndianCurrency(String number) {
        String[] parts = number.split("\\.");
        BigInteger integerPart = new BigInteger(parts[0]);
        String integerStr = integerPart.toString();
        String decimalPart = parts.length > 1 ? "." + parts[1] : "";

        StringBuilder result = new StringBuilder();
        int len = integerStr.length();

        if (len > 3) {
            result.insert(0, "," + integerStr.substring(len - 3));
            len -= 3;

            while (len > 2) {
                result.insert(0, "," + integerStr.substring(len - 2, len));
                len -= 2;
            }
            result.insert(0, integerStr.substring(0, len));
        } else {
            result.append(integerStr);
        }

        result.append(decimalPart);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a floating-point number: ");
        String input = sc.nextLine();
        sc.close();

        String formatted = formatIndianCurrency(input);
        System.out.println("Formatted (Indian style): " + formatted);
    }
}
