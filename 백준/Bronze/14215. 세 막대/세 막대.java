import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());
        int value3 = Integer.parseInt(st.nextToken());
        int[] arr = new int[]{value1, value2, value3};
        if (isTriangleCheck(arr)) {
            System.out.println(value1 + value2 + value3);
        } else {
            int maxIndex = findMaxIndex(arr);
            for (int i = arr[maxIndex] - 1; i >= 0; i--) {
                arr[maxIndex] = i;
                if (isTriangleCheck(arr, maxIndex)) {
                    System.out.println(arr[0] + arr[1] + arr[2]);
                    return;
                }
            }
        }
    }

    public static boolean isTriangleCheck(int[] arr, int maxIndex) {
        int remainSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != maxIndex) {
                remainSum += arr[i];
            }
        }
        return arr[maxIndex] < remainSum;
    }

    public static boolean isTriangleCheck(int[] arr) {
        int maxIndex = findMaxIndex(arr);
        return isTriangleCheck(arr, maxIndex);
    }

    public static int findMaxIndex(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}