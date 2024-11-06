import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int forCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < forCount; i++) {
            String inputStr = sc.nextLine();
            String first = inputStr.substring(0, 1);
            String second = inputStr.substring(inputStr.length() - 1);
            System.out.println(first + second);
        }
    }
}