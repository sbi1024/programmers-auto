import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        
        String[] split = input.split(" ");
        if (input.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(split.length);
        }
        
        sc.close();
    }
}