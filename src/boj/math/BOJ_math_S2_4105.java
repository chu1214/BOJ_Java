package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_math_S2_4105 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;

		while (!(str = br.readLine()).equals("0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0")) {
			st = new StringTokenizer(str);
			double AX = Double.parseDouble(st.nextToken());
			double AY = Double.parseDouble(st.nextToken());
			double BX = Double.parseDouble(st.nextToken());
			double BY = Double.parseDouble(st.nextToken());
			double CX = Double.parseDouble(st.nextToken());
			double CY = Double.parseDouble(st.nextToken());
			double DX = Double.parseDouble(st.nextToken());
			double DY = Double.parseDouble(st.nextToken());
			double EX = Double.parseDouble(st.nextToken());
			double EY = Double.parseDouble(st.nextToken());
			double FX = Double.parseDouble(st.nextToken());
			double FY = Double.parseDouble(st.nextToken());

			double target = Math.abs(((DX * EY + EX * FY + FX * DY) - (DY * EX + EY * FX + FY * DX)) / 2);

			double left = -100000.0;
			double right = 100000.0;
			double mid = (left + right) / 2.0;

			double HX = 0.0;
			double HY = 0.0;
			while (true) {
				HX = AX - mid * (AX - CX);
				HY = AY - mid * (AY - CY);
				double square = Math.abs((AX * BY + BX * HY + HX * AY) - (AY * BX + BY * HX + HY * AX));
				if (Math.abs(square - target) <= 1.0E-7)
					break;
				if (target - square > 0) {
					left = mid;
					mid = (left + right) / 2.0;
				} else {
					right = mid;
					mid = (left + right) / 2.0;
				}
			}
			double GX = BX + (HX - AX);
			double GY = BY + (HY - AY);

			sb.append(String.format("%.3f", GX) + " " + String.format("%.3f", GY) + " " + String.format("%.3f", HX)
					+ " " + String.format("%.3f", HY) + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}