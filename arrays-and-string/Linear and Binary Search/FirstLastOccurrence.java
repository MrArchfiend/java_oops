public class FirstLastOccurrence {

    static int first(int[] arr, int target) {
        int left = 0, right = arr.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return ans;
    }

    static int last(int[] arr, int target) {
        int left = 0, right = arr.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 7};
        System.out.println(first(arr, 4));
        System.out.println(last(arr, 4));
    }
}
