package boj.recursive;

import java.io.*;

public class BOJ_recursive_S5_17478 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] story = { "\"재귀함수가 뭔가요?\"\n", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" };
	static String[] storyAnswer = { "\"재귀함수가 뭔가요?\"\n", "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"};
	static String end = "라고 답변하였지.\n";
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(N);
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

	public static void recursive(int n) {
		for (int i = 0; i <= story.length; i++) {
			if(i == story.length) recursive(n - 1);
			
			for (int j = n; j < N; j++) {
				sb.append("____");
			}
			if(n == 0) {
				if(i <= 1) {
					sb.append(storyAnswer[i]);
				}
				else {
					sb.append(end);
					return;
				}
			}else {
				if(i < story.length) {
					sb.append(story[i]);
				}
				else {
					sb.append(end);
				}
			}
		}
	}
}