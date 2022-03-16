package implementation;

import java.util.Scanner;

public class I_2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//String word = sc.nextLine();
		
		System.out.println(count("ddz=z="));
		
		sc.close();
	}
	
	private static int count(String word) {
		int result = 0;
		
		String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		//크로아티아 알파벳 배열에 대한 반복문
		for (int i = 0; i < words.length; i++) {
			String[] strArr = word.split(words[i]);
			
			//크로아티아 알파벳으로 단어를 나누었을 때 나눠지면
			if (strArr.length > 1) {
				//포함된 알파벳 개수 세기
				result += strArr.length - 1;
				
				String n = "";
				for (int j = 0; j < strArr.length; j++) {
					
					System.out.println(strArr[j]);
					n += strArr[j];
				}
				//포함된 알파벳을 제외한 나머지 알파벳들로 단어 재구성
				word = n;
			}
		}
		
		//크로아티아 알파벳이 아닌 일반 알파벳들의 개수 세기
		result += word.length();
		
		return result;
	}
}
