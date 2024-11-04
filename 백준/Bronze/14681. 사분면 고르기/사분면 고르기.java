import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value1 = sc.nextInt();
        int value2 = sc.nextInt();
        
        if (value1 > 0 && value2 > 0) {
            System.out.println("1");
        } else if (value1 < 0 && value2 > 0) {
            System.out.println("2");
        } else if (value1 < 0 && value2 < 0) {
            System.out.println("3");
        } else {
            System.out.println("4");
        } 
    }
}