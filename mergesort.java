import java.util.ArrayList;

public class mergesort {

    // Function to merge two sorted halves of the array
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary list to store merged elements
        int left = low;  // Starting index of the left half
        int right = mid + 1; // Starting index of the right half

        // Compare elements from both halves and add the smaller one to the temp list
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Add remaining elements from the left half (if any)
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements from the right half (if any)
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy the merged elements back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Function to perform merge sort on the array
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return; // Base case: single element is already sorted

        int mid = (low + high) / 2; // Find the middle index

        // Recursively sort the left half
        mergeSort(arr, low, mid);

        // Recursively sort the right half
        mergeSort(arr, mid + 1, high);

        // Merge the two sorted halves
        merge(arr, low, mid, high);
    }

    // Main function to test the merge sort
    public static void main(String args[]) {
        int n = 7; // Number of elements in the array
        int arr[] = {9, 4, 7, 6, 3, 1, 5}; // Array to be sorted

        // Print the array before sorting
        System.out.println("Before sorting array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call mergeSort to sort the array
        mergeSort(arr, 0, n - 1);

        // Print the array after sorting
        System.out.println("After sorting array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
