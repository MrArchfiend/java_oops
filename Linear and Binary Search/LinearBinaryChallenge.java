import java.util.Arrays;

public class LinearBinaryChallenge {

    static int firstMissingPositive(int[] arr) {
        boolean[] seen = new boolean[arr.length + 1];

        for (int n : arr)
            if (n > 0 && n <= arr.length)
                seen[n] = true;

        for (int i = 1; i <= arr.length; i++)
            if (!seen[i])
                return i;

        return arr.length + 1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(arr));

        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 4));
    }
}
