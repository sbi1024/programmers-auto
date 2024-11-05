import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputSplit = input.split(" ");
        int arrLength = Integer.parseInt(inputSplit[0]);
        int forCount = Integer.parseInt(inputSplit[1]);

        int[] result = new int[arrLength];
        for (int i = 0; i < forCount; i++) {
            input = sc.nextLine();
            inputSplit = input.split(" ");
            int value1 = Integer.parseInt(inputSplit[0]);
            int value2 = Integer.parseInt(inputSplit[1]);
            int value3 = Integer.parseInt(inputSplit[2]);

            for (int j = value1 - 1; j < value2; j++) {
                result[j] = value3;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if (!(i == (result.length - 1))) {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}