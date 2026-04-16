#include <bits/stdc++.h>
using namespace std;
// Struct to represent an item with profit and weight
struct Item
{
    int profit;
    int weight;
};
class Solution
{
public:
    // Comparator function to sort items by profit/weight ratio
    bool static comp(Item a, Item b)
    {
        double r1 = (double)a.profit / (double)a.weight;
        double r2 = (double)b.profit / (double)b.weight;
        return r1 > r2; // Return true if the ratio of item a is greater than item b
    }
    // Function to calculate the maximum profit we can get with fractional knapsack
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Sort items based on the profit/weight ratio
        sort(arr, arr + n, comp);
        int curWeight = 0;        // Current weight of knapsack
        double finalprofit = 0.0; // Final profit we can achieve
        // Iterate through the sorted items
        for (int i = 0; i < n; i++)
        {
            // If the current item can be fully added to the knapsack
            if (curWeight + arr[i].weight <= W)
            {
                curWeight = curWeight + arr[i].weight;
                finalprofit = finalprofit + arr[i].profit; // Add the full profit of the item
            }
            else
            {
                // If the current item can't be fully added, take the fractional part
                int remain = W - curWeight;
                finalprofit = finalprofit + (arr[i].profit / (double)arr[i].weight) * (double)remain;
                break; // Brea
            }
        }
        return finalprofit; // Return the maximum profit that can be carried
    }
};
int main()
{
    int n = 3, weight = 50; // Number of items and capacity of knapsack
    // Item profits and weights
    Item arr[n] = {{100, 20}, {60, 10}, {120, 30}};
    Solution obj;
    // Calculate the maximum profit we can get with the fractional knapsack
    double ans = obj.fractionalKnapsack(weight, arr, n);
    // Output the result
    cout << "The maximum profit is " << setprecision(2) << fixed << ans;
    return 0;
}
