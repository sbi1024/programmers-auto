import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] flags = br.readLine().split(" ");
        String[] nums = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] C = br.readLine().split(" ");

        Deque<Integer> qs = new ArrayDeque<>();  

        for (int i = 0; i < N; i++) {
            if (flags[i].equals("0")) {  
                qs.addLast(Integer.parseInt(nums[i])); 
            }
        }

        for (int i = 0; i < M; i++) {  
            int c = Integer.parseInt(C[i]);
            qs.addFirst(c);  
            sb.append(qs.pollLast()).append(" ");  
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}

