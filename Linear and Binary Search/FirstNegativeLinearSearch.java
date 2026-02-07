public class FirstNegativeLinearSearch {

    static int firstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 0, -2, 8, -7};
        System.out.println(firstNegative(arr));
    }
}
