package ja.qb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JA_1828_냉장고 {
	
	public static class Material implements Comparable<Material>{
		int minTemp, maxTemp;

		public Material(int minTemp, int maxTemp) {
			super();
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}

		@Override
		public int compareTo(Material o) {
			if(this.maxTemp == o.maxTemp)
				return Integer.compare(this.minTemp, o.minTemp);
			return Integer.compare(this.maxTemp, o.maxTemp);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		ArrayList<Material> refrigerator = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			refrigerator.add(new Material(min, max));
		}
		
		Collections.sort(refrigerator);
		
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				if(refrigerator.get(i).maxTemp < refrigerator.get(j).minTemp) {
					ans++;
					i = j - 1;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}