import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeDP {

    // Function to calculate the minimum number of coins needed to make up a given amount
    public static int coinChange(int[] coins, int amount) {
        // Initialize DP array to store the minimum number of coins required for each amount
        int[] dp = new int[amount + 1];
        // Fill the DP array with a large value to represent an unreachable state
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // Base case: 0 coins are needed to make up amount 0

        // Iterate through each coin denomination
        for (int coin : coins) {
            // Update the DP array for amounts that can include the current coin
            for (int i = coin; i <= amount; i++) {
                // Choose the minimum between the current value and the value if this coin is included
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If the value at dp[amount] is still greater than the amount, it's not possible to form the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input

        // Prompt user for the number of coin denominations
        System.out.println("Enter the number of coin denominations:");
        int n = sc.nextInt(); // Read the number of denominations

        // Create an array to store the coin denominations
        int[] coins = new int[n];
        System.out.println("Enter the coin denominations:"); // Prompt user to enter denominations
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt(); // Read each coin denomination
        }

        // Prompt user for the amount to form
        System.out.println("Enter the amount:");
        int amount = sc.nextInt(); // Read the target amount

        // Calculate the minimum number of coins required to form the given amount
        int result = coinChange(coins, amount);

        // Output the result to the user
        if (result == -1) {
            // If result is -1, it's not possible to form the amount with the given coins
            System.out.println("It's impossible to make up the amount with the given denominations.");
        } else {
            // Otherwise, print the minimum number of coins needed
            System.out.println("The fewest number of coins needed: " + result);
        }

        sc.close(); // Close the Scanner to free system resources
    }
}
