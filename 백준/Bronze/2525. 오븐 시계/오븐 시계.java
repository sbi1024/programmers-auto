import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] splitStr = str1.split(" ");
        int value1 = Integer.parseInt(splitStr[0]);
        int value2 = Integer.parseInt(splitStr[1]);
        
        LocalTime now = LocalTime.of(value1,value2,0);
        LocalTime resultTime = now.plusMinutes(Integer.parseInt(str2));
        int hour = resultTime.getHour();
        int minute = resultTime.getMinute();

        System.out.println(hour + " " + minute);
    }
}