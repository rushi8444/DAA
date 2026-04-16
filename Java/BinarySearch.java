public class BinarySearch {

    static int binarySearch(int arr[], int low, int high, int x) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        int result = binarySearch(arr, 0, arr.length - 1, x);

        if (result != -1)
            System.out.println("Element is present at index " + result);
        else
            System.out.println("Element is not present in array");
    }
}