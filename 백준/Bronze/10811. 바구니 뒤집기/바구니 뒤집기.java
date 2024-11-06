import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputSplit = input.split(" ");
        int arrLength = Integer.parseInt(inputSplit[0]);
        int forCount = Integer.parseInt(inputSplit[1]);

        // 초기값 셋팅
        int[] result = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            result[i] = i + 1;
        }

        for (int i = 0; i < forCount; i++) {
            String line = sc.nextLine();
            String[] lineSplit = line.split(" ");
            int firstIndex = Integer.parseInt(lineSplit[0]) - 1;
            int secondIndex = Integer.parseInt(lineSplit[1]) - 1;

            for (int j = firstIndex; j <= secondIndex; j++) {
                int temp = result[j];
                result[j] = result[secondIndex];
                result[secondIndex] = temp;
                secondIndex--;
            }
        }
        sc.close();

        for (int m : result) {
            System.out.print(m + " ");
        }
    }
}