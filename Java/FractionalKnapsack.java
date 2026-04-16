import java.util.Arrays;
import java.util.Comparator;

// Equivalent to C++ struct Item
class Item {
    int profit;
    int weight;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

class Solution {

    // Comparator to sort items by profit/weight ratio (descending)
    static Comparator<Item> comp = (a, b) -> {
        double r1 = (double) a.profit / (double) a.weight;
        double r2 = (double) b.profit / (double) b.weight;
        return Double.compare(r2, r1);
    };

    // Function to calculate maximum profit with fractional knapsack
    double fractionalKnapsack(int W, Item arr[], int n) {

        Arrays.sort(arr, comp); // Sort by profit/weight ratio

        int curWeight      = 0;
        double finalprofit = 0.0;

        for (int i = 0; i < n; i++) {
            if (curWeight + arr[i].weight <= W) {
                curWeight   += arr[i].weight;
                finalprofit += arr[i].profit;
            } else {
                int remain   = W - curWeight;
                finalprofit += (arr[i].profit / (double) arr[i].weight) * (double) remain;
                break;
            }
        }
        return finalprofit;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        int n = 3, weight = 50;

        Item arr[] = {
            new Item(100, 20),
            new Item(60,  10),
            new Item(120, 30)
        };

        Solution obj = new Solution();
        double ans = obj.fractionalKnapsack(weight, arr, n);

        // Equivalent to cout << setprecision(2) << fixed << ans
        System.out.printf("The maximum profit is %.2f%n", ans);
    }
}