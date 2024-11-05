import java.util.*;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        
        int numCount = sc.nextInt();
        sc.nextLine();
        
        String str = sc.nextLine();
        int findNum = sc.nextInt();
        sc.nextLine();
        
        String[] splitStr = str.split(" ");
        for (int i = 0 ; i < splitStr.length; i ++) {
            if (Integer.parseInt(splitStr[i]) == findNum) {
                result ++;
            } 
        }
        System.out.println(result);
    }
}