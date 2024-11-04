import java.util.*;
public class Main {
    public static void main(String[] args){
        long sum = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splitStr = str.split(" ");
        for (String s : splitStr) {
            sum += Long.parseLong(s);
        }
        System.out.println(sum);
    }
}