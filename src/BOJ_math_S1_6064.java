import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_S1_6064 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken()) - 1;
			int Y = Integer.parseInt(st.nextToken()) - 1;
			
			int a = Math.max(M, N);
			int b = Math.min(M, N);
			while(a % b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			}
			
			int GCD = b;
			int LCM = M * N / GCD;
			boolean isFound = false;
			
	        for(int i = X; i <= LCM; i += M) {
				if(i % N == Y) {
					sb.append((i + 1) + "\n");
					isFound = true;
					break;
				}
			}
			if(!isFound) sb.append(-1 + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}