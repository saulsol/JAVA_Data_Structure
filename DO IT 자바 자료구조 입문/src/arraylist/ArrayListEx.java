package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListEx {

	public static void main(String[] args) {


		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		// 값 추가 
		arrayList.add(1);
		arrayList.add(0); 
		
		
		// ArrayList 값 삭제
		arrayList.remove(1); // index 1 제거 
		arrayList.clear(); // 모든 값 제거 
		
		// ArrayList 사이즈 구하기 
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println(arrayList2.size());
		
		
		//for 문을 통한 전체 출력 
		for(int s : arrayList2 ) {
			System.out.println(s);
		}
		// 0번째 index 출력 
		System.out.println(arrayList2.get(0));
		
		
		// ArrayList 값 검색 
		System.out.println(arrayList2.contains(1)); // 있으면 true 없으면 false
		
		// 
		System.out.println(arrayList2.indexOf(1)); // 1이 있는 index 반환 없으면 -1 
		
	}

}
