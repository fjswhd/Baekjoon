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
		
		//ũ�ξ�Ƽ�� ���ĺ� �迭�� ���� �ݺ���
		for (int i = 0; i < words.length; i++) {
			String[] strArr = word.split(words[i]);
			
			//ũ�ξ�Ƽ�� ���ĺ����� �ܾ �������� �� ��������
			if (strArr.length > 1) {
				//���Ե� ���ĺ� ���� ����
				result += strArr.length - 1;
				
				String n = "";
				for (int j = 0; j < strArr.length; j++) {
					
					System.out.println(strArr[j]);
					n += strArr[j];
				}
				//���Ե� ���ĺ��� ������ ������ ���ĺ���� �ܾ� �籸��
				word = n;
			}
		}
		
		//ũ�ξ�Ƽ�� ���ĺ��� �ƴ� �Ϲ� ���ĺ����� ���� ����
		result += word.length();
		
		return result;
	}
}
