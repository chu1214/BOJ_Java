package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_math_P5_1708 {

	static class Dot implements Comparable<Dot> {
		long x, y;
		double angle, distance;

		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot o) {
			if (this.angle == o.angle) {
				return Double.compare(this.distance, o.distance);
			}
			return Double.compare(this.angle, o.angle);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Dot[] dots = new Dot[N + 1];
		Dot standard = new Dot(Long.MAX_VALUE, Long.MAX_VALUE);

		// 점 입력 받으면서 기준점 찾기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i] = new Dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			if (dots[i].y < standard.y) {
				standard = dots[i];
			} else if (dots[i].y == standard.y && dots[i].x < standard.x) {
				standard = dots[i];
			}
		}

		// 기준점 대비 각도와 거리 계산
		for (int i = 0; i < N; i++) {
			dots[i].angle = Math.atan2(dots[i].y - standard.y, dots[i].x - standard.x);
			dots[i].distance = Math.sqrt(Math.pow((dots[i].y - standard.y), 2) + Math.pow((dots[i].x - standard.x), 2));
		}

		// 각도와 거리를 통해 배열 재 정렬하기
		Arrays.sort(dots, 0, N);
		dots[N] = standard;

		// 시뮬레이션
		Stack<Dot> s = new Stack<>();
		s.push(dots[0]);

		int idx = 1;

		while (idx < N) {
			while (s.size() >= 2) {
				Dot dot1 = s.pop();
				Dot dot0 = s.pop();
				long calc = ((dots[idx].y - dot1.y) * (dot1.x - dot0.x)) - ((dots[idx].x - dot1.x) * (dot1.y - dot0.y));
				s.push(dot0);
				if (calc > 0) {
					s.push(dot1);
					break;
				}
			}
			s.push(dots[idx++]);
		}
		System.out.println(s.size());
	}
}