package boj.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BOJ_linkedlist_S3_1406 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Character> editor = new LinkedList<>();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			editor.add(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		ListIterator<Character> iter = editor.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
		}
		
		for(int i = 0; i < M; i++) {
			String orders = br.readLine();
			char ord = orders.charAt(0);
			
			if(ord == 'L') {
				if(iter.hasPrevious()) iter.previous();
			}
			
			else if(ord == 'D') {
				if(iter.hasNext()) iter.next();
			}
			
			else if(ord == 'B') {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
			
			else {
					iter.add(orders.charAt(2));
				}
			}
		for(Character c : editor) {
			bw.write(c);
		}
		bw.flush();
		bw.close();
	}
}