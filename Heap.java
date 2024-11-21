import java.util.Scanner;

class Heap {
    int[] arr = new int[100]; // Array to store heap elements
    int size = 0; // Current size of the heap

    public Heap() {
        arr[0] = -1; // Initializing the first element (not used)
    }

    // Function to insert a new value into the heap
    public void insert(int val) {
        size += 1; // Increment size
        int index = size; // Start at the last position
        arr[index] = val; // Place the value at the last position

        // Adjust the heap property
        while (index > 1) {
            int parent = index / 2; // Parent index
            if (arr[parent] < arr[index]) { // Max-heap: parent should be greater than child
                swap(arr, parent, index); // Swap with the parent
                index = parent; // Move up to the parent
            } else {
                return; // Heap property is satisfied
            }
        }
    }

    // Function to print the heap elements
    public void print() {
        for (int i = 1; i <= size; i++) { // Start from 1 since 0 is unused
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Utility function to swap two elements in the array
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Function to delete the root element from the heap
    public void deleteFromHeap() {
        if (size == 0) {
            System.out.println("Nothing to delete");
            return;
        }

        // Replace the root with the last element and reduce heap size
        arr[1] = arr[size];
        size--;

        int i = 1; // Start at the root
        while (i < size) {
            int leftIndex = 2 * i; // Left child
            int rightIndex = 2 * i + 1; // Right child

            // Check if left child exists and is greater than the current element
            if (leftIndex <= size && arr[i] < arr[leftIndex]) {
                swap(arr, i, leftIndex); // Swap with left child
                i = leftIndex; // Move down to the left child
            } 
            // Check if right child exists and is greater than the current element
            else if (rightIndex <= size && arr[i] < arr[rightIndex]) {
                swap(arr, i, rightIndex); // Swap with right child
                i = rightIndex; // Move down to the right child
            } else {
                return; // Heap property is restored
            }
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap(); // Create a heap instance
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display options
            System.out.println("\nHeap Operations Menu:");
            System.out.println("1. Insert into Heap");
            System.out.println("2. Delete from Heap");
            System.out.println("3. Print Heap");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt(); // Read user choice

            switch (choice) {
                case 1:
                    // Insert into heap
                    System.out.print("Enter the value to insert: ");
                    int value = sc.nextInt();
                    h.insert(value);
                    System.out.println("Inserted new element. Current heap:");
                    h.print();
                    break;

                case 2:
                    // Delete from heap
                    System.out.println("Deleting root element...");
                    h.deleteFromHeap();
                    System.out.println("After deletion, current heap:");
                    h.print();
                    break;

                case 3:
                    // Print the heap
                    System.out.println("Current Heap:");
                    h.print();
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    // Invalid input
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
