package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_dfs_G4_17281 {

   static int I, max = Integer.MIN_VALUE;
   static int[][] hitter;
   static int[] rotation = new int[10];
   static boolean[] selected = new boolean[10];

   public static void game() {
      int inn = 1;
      int out = 0;
      boolean[] runners = new boolean[4];
      int num = 1;
      int sum = 0;
      
      while(inn <= I) {
         while(out < 3) {
            int result = hitter[inn][rotation[num]];
            switch(result) {
            case 4:
               for(int i = 3;  i >= 1; i--) {
                  if(runners[i]) {
                     sum++;
                     runners[i] = false;
                  }
               }
               sum++;
               break;
            case 3:
               for(int i = 3;  i >= 1; i--) {
                  if(runners[i]) {
                     sum++;
                     runners[i] = false;
                  }
               }
               runners[3] = true;
               break;
            case 2:
               for(int i = 3;  i >= 1; i--) {
                  if(runners[i] && i >= 2) {
                     sum++;
                     runners[i] = false;
                  } else if(runners[i] && i == 1) {
                     runners[i] = false;
                     runners[i+2] = true;
                  }
               }
               runners[2] = true;
               break;
            case 1:
               for(int i = 3;  i >= 1; i--) {
                  if(runners[i] && i == 3) {
                     sum++;
                     runners[i] = false;
                  } else if(runners[i] && i <= 2) {
                     runners[i] = false;
                     runners[i+1] = true;
                  }
               }
               runners[1] = true;
               break;
            case 0:
               out++;
               break;
            }
            num++;
            if(num == 10) num = 1;
         }
         if(out == 3) {
            inn++;
            out = 0;
            for(int i = 1; i <= 3; i++) {
               runners[i] = false;
            }
         }
      }   
      if(sum > max) {
         max = sum;
      }
   }
   
   public static void select(int cnt) {
      if(cnt > 9) {
         game();
         return;
      }
      
      if (cnt == 4) {
         rotation[cnt] = 1;
         selected[1] = true;
         select(cnt + 1);
         selected[1] = false;
      } else {
         for (int i = 2; i <= 9; i++) {
            if (!selected[i]) {
               rotation[cnt] = i;
               selected[i] = true;
               select(cnt + 1);
               selected[i] = false;
            }
         }
      }
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      I = Integer.parseInt(br.readLine());
      
      hitter = new int[I + 1][10];

      for (int i = 1; i <= I; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 1; j <= 9; j++) {
            hitter[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      select(1);
      
      System.out.println(max);
   }
}