import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int index = sc.nextInt() - 1;
        char ch = input.charAt(index);

        sc.close();
        System.out.println(ch);
    }
}