import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            int value1 = Integer.parseInt(st.nextToken());
            int value2 = Integer.parseInt(st.nextToken());
            int value3 = Integer.parseInt(st.nextToken());

            if (isTriangleCheck(value1, value2, value3)) {
                if ((value1 == value2) && (value2 == value3)) {
                    System.out.println("Equilateral");
                } else if ((value1 != value2) && (value1 != value3) && (value2 != value3)) {
                    System.out.println("Scalene");
                } else {
                    System.out.println("Isosceles");
                }
            }
        }
    }

    public static boolean isTriangleCheck(int value1, int value2, int value3) {
        int[] arr = new int[]{value1, value2, value3};
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }

        int remainSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != maxIndex) {
                remainSum += arr[i];
            }
        }

        if (arr[maxIndex] < remainSum) {
            return true;
        } else {
            System.out.println("Invalid");
            return false;
        }
    }
}