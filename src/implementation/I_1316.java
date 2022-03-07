package implementation;

import java.util.Scanner;

public class I_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			String word = sc.nextLine();
			answer += isGroupWord(word) ? 1 : 0;
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	private static boolean isGroupWord(String word) {
		boolean result = true;
		
		char[] cWord = word.toCharArray();
		
		//n번째 알파벳이 이미 나왔는지 확인
		boolean[] alphabet = new boolean[26]; 
		
		int firstChar = cWord[0] - 'a';
		alphabet[firstChar] = true;
		
		for (int i = 1; i < cWord.length; i++) {
			int n = cWord[i] - 'a';
			
			if (alphabet[n] && cWord[i-1] != cWord[i]) {
				result = false;
			}
			
			alphabet[n] = true;
		}
		
		return result;
	}
	
	/*
	 * 이 방식은 시간복잡도가 제곱에 비례
	private static boolean isGroupWord(String word) {
		boolean result = true;
		
		char[] cWord = word.toCharArray();
		
		for (int i = 0; i < cWord.length; i++) {
			for (int j = 0; j < i; j++) {
				if (cWord[i-1] != cWord[i] && cWord[j] == cWord[i]) {
					result = false;
				}
			}
		}
		
		return result;
	}
	*/
}
