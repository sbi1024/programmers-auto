import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splitStr = str.split(" ");
        String splitStr1 = splitStr[0];
        String splitStr2 = splitStr[1];
        String splitStr3 = splitStr[2];

        int sum = 0;
        if (splitStr1.equals(splitStr2) &&
                splitStr2.equals(splitStr3) &&
                splitStr1.equals(splitStr3)) {
            sum = 10000 + Integer.parseInt(splitStr1) * 1000;
            System.out.println(sum);
        } else if (!splitStr1.equals(splitStr2) &&
                !splitStr2.equals(splitStr3) &&
                !splitStr1.equals(splitStr3)) {
            int maxValue = findMaxValue(splitStr);
            sum = maxValue * 100;
            System.out.println(sum);
        } else {
            int sameValue = findSameValue(splitStr);
            sum = 1000 + sameValue * 100;
            System.out.println(sum);
        }

    }

    public static int findMaxValue(String[] strArr) {
        int maxValue = Integer.MIN_VALUE;
        for (String str : strArr) {
            int intStr = Integer.parseInt(str);
            if (intStr > maxValue) {
                maxValue = intStr;
            }
        }
        return maxValue;
    }

    public static int findSameValue(String[] strArr) {
        HashSet<String> set = new HashSet<>();
        for (String str : strArr) {
            boolean result = set.add(str);
            if (!result) {
                return Integer.parseInt(str);
            }
        }
        return 0;
    }
}