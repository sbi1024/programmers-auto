//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//
//        List<int[]> list = new ArrayList<>();
//        int forCount = Integer.parseInt(br.readLine());
//        for (int i = 0; i < forCount; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int[] tempArray = new int[2];
//            tempArray[0] = Integer.parseInt(st.nextToken());
//            tempArray[1] = Integer.parseInt(st.nextToken());
//            list.add(tempArray);
//        }
//
//        list.sort((o1, o2) -> {
//            if (o1[0] < o2[0]) {
//                return -1;
//            } else if (o1[0] == o2[0]) {
//                if (o1[1] < o2[1]) {
//                    return -1;
//                } else if (o1[1] == o2[1]) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            } else {
//                return 1;
//            }
//        });
//
//        for (int[] intArray : list) {
//            sb.append(intArray[0])
//                    .append(" ")
//                    .append(intArray[1])
//                    .append("\n");
//        }
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<int[]> list = new ArrayList<>();
        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tempArray = new int[2];
            tempArray[0] = Integer.parseInt(st.nextToken());
            tempArray[1] = Integer.parseInt(st.nextToken());
            list.add(tempArray);
        }

        list.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] intArray : list) {
            sb.append(intArray[0])
                    .append(" ")
                    .append(intArray[1])
                    .append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}