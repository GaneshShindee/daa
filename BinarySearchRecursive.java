import java.util.Scanner;

public class BinarySearchRecursive {

    // Recursive method for binary search
    public int binarySearch(int[] a, int key, int first, int last) {
        if (first > last) {
            return -1; // Key not found
        }

        int mid = first + (last - first) / 2;

        if (a[mid] == key) {
            return mid; // Key found
        } else if (key < a[mid]) {
            return binarySearch(a, key, first, mid - 1); // Search in the left half
        } else {
            return binarySearch(a, key, mid + 1, last); // Search in the right half
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        // Input array elements
        int[] a = new int[n];
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input the key to search for
        System.out.println("Enter the key to search:");
        int key = sc.nextInt();

        // Perform recursive binary search
        BinarySearchRecursive binarySearch = new BinarySearchRecursive();
        int result = binarySearch.binarySearch(a, key, 0, n - 1);

        // Output the result
        if (result == -1) {
            System.out.println("Key not found");
        } else {
            System.out.println("Key found at index = " + result);
        }

        sc.close(); // Close the scanner to avoid resource leaks
    }
}
