import java.util.Scanner;

public class KnapsackDP {

    public static int knapsack(int[] weight, int[] value, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];
        // Build table dp[][] in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: no items or no capacity
                } else if (weight[i - 1] <= w) {
                    // Include item or exclude it, choose max value
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w]; // Item can't be included
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of items
        System.out.println("Enter the number of items:");
        int n = sc.nextInt();

        // Input values of the items
        int[] value = new int[n];
        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        // Input weights of the items
        int[] weight = new int[n];
        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        // Input the knapsack capacity
        System.out.println("Enter the capacity of the knapsack:");
        int W = sc.nextInt();

        // Calculate the maximum value that can be obtained
        int maxValue = knapsack(weight, value, W, n);

        // Output the result
        System.out.println("The maximum value that can be obtained is: " + maxValue);

        sc.close(); // Close the scanner to avoid resource leaks
    }
}
