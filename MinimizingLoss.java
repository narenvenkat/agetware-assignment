import java.util.*;

public class MinimizingLoss {

    static class PriceEntry {
        int price;
        int year;

        PriceEntry(int price, int year) {
            this.price = price;
            this.year = year;
        }
    }

    public static void findMinimumLoss(int[] prices) {
        int n = prices.length;
        List<PriceEntry> entries = new ArrayList<>();

        for (int i = 0; i < n; i++) entries.add(new PriceEntry(prices[i], i));

        entries.sort((a, b) -> Integer.compare(b.price, a.price));

        int minLoss = Integer.MAX_VALUE;
        int buyYear = -1, sellYear = -1;

        TreeMap<Integer, Integer> seenYears = new TreeMap<>();

        for (PriceEntry entry : entries) {
            Map.Entry<Integer, Integer> lower = seenYears.lowerEntry(entry.year);
            if (lower != null) {
                int loss = entry.price - prices[lower.getValue()];
                if (loss < minLoss) {
                    minLoss = loss;
                    buyYear = entry.year + 1;
                    sellYear = lower.getValue() + 1;
                }
            }
            seenYears.put(entry.year, entry.year);
        }

        if (buyYear != -1) {
            System.out.println("Buy in year: " + buyYear);
            System.out.println("Sell in year: " + sellYear);
            System.out.println("Minimum Loss: " + minLoss);
        } else System.out.println("No valid loss scenario found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of years: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter prices for each year:");

        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();
        
        sc.close();

        findMinimumLoss(prices);
    }
}
