import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        sc.nextLine();
        int count = sc.nextInt();
        sc.nextLine();
           
        int checkSum = 0;
        for (int i = 0 ; i < count; i++) {
            String input = sc.nextLine();
            String[] splitInput = input.split(" ");
            checkSum += (Integer.parseInt(splitInput[0]) * Integer.parseInt(splitInput[1]));
        } 
        
        if (total == checkSum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}