import java.util.Scanner;

public class QuickSort {

    // Function to swap two elements (C++: void swap(int &a, int &b))
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }

    // Partition function (identical logic to C++)
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // Quick Sort function
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Sort elements before partition
            quickSort(arr, pi + 1, high); // Sort elements after partition
        }
    }

    // Function to display the array
    static void displayArray(int arr[], int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Equivalent to cin

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];  // Equivalent to int arr[n]

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        quickSort(arr, 0, n - 1);

        System.out.print("Sorted array: ");
        displayArray(arr, n);

        sc.close();
    }
}