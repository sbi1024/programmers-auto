import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splitStr = str.split(" ");
        
        LocalTime now = LocalTime.of(Integer.parseInt(splitStr[0]),Integer.parseInt(splitStr[1]), 0);
        LocalTime resultTime = now.minusMinutes(45);
        int hour = resultTime.getHour();
        int minute = resultTime.getMinute();
        
        System.out.println(hour + " " + minute);
    }
}