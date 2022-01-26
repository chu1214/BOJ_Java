package boj.simul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_simul_B1_2456 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Candidate[] candidate = {new Candidate(), new Candidate(), new Candidate()};
		int score;

		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				score = Integer.parseInt(st.nextToken());
				candidate[i].sum += score;
				candidate[i].num = i + 1;
				if (score == 3)
					candidate[i].cnt3++;
				else if (score == 2)
					candidate[i].cnt2++;
			}
		}
		Arrays.sort(candidate);
		if(candidate[2].compareTo(candidate[1]) != 0) {
			System.out.println(candidate[2].num + " " + candidate[2].sum);
		}
		else {
			System.out.println(0 + " " + candidate[2].sum);
		}
	}
}

class Candidate implements Comparable<Candidate> {
	int sum;
	int cnt3;
	int cnt2;
	int num;

	public Candidate() {
		this.sum = 0;
		this.cnt3 = 0;
		this.cnt2 = 0;
	}

	@Override
	public int compareTo(Candidate o) {
		if (this.sum != o.sum)
			return Integer.compare(this.sum, o.sum);
		else {
			if (this.cnt3 != o.cnt3)
				return Integer.compare(this.cnt3, o.cnt3);
			else {
				if (this.cnt2 != o.cnt2)
					return Integer.compare(this.cnt2, this.cnt2);
				else {
					return 0;
				}
			}
		}
	}
}