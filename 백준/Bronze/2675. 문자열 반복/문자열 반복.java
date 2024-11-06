import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int forCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < forCount; i++) {
            StringBuilder sb = new StringBuilder();
            String input = sc.nextLine();
            String[] split = input.split(" ");
            int repeatCount = Integer.parseInt(split[0]);
            String[] splitStr = split[1].split("");
            for (String s : splitStr) {
                for (int j = 0; j < repeatCount; j++) {
                    sb.append(s);
                }
            }
            System.out.println(sb);
        }
        
        sc.close();
    }
}