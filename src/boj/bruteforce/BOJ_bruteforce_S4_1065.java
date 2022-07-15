package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_bruteforce_S4_1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int i = 1; i <= N; i++) {
            if(i < 100) cnt++;
            else {
                int hundred = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if(hundred - ten == ten - one) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
