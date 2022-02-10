package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class BOJ_tree_S3_20920 {
	
	static class Word implements Comparable<Word> {
		String word;
		int cnt;
		
		public Word(String word, int cnt) {
			super();
			this.word = word;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Word o) {
			if(this.cnt == o.cnt) {
				if(this.word.length() == o.word.length()) {
					return this.word.compareTo(o.word);
				}
				return o.word.length() - word.length();
			}
			else return Integer.compare(o.cnt, this.cnt);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<String, Word> hs = new HashMap<>();
		TreeSet<Word> ts = new TreeSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() >= M) {
				if(hs.containsKey(word)) {
					hs.get(word).cnt++;
				}
				else {
					hs.put(word, new Word(word, 0));
				}
			}
		}
		Iterator<Entry<String, Word>> iterator = hs.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry entry = iterator.next();
			Word W = (Word) entry.getValue();
			ts.add(W);			
		}
		for(Word w : ts) {
			sb.append(w.word + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}