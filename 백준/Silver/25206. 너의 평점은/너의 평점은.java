import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double specificCredit = 0;
        double totalCredit = 0;
        for (int i = 0; i < 20; i++) {
            String[] splitStr = br.readLine().split(" ");
            double credit = Double.parseDouble(splitStr[1]);
            String grade = splitStr[2];
            if (!grade.equals("P")) {
                totalCredit += credit;
                specificCredit += (gradeMap.get(grade) * credit);
            }

        }
        System.out.println(specificCredit / totalCredit);
    }
}