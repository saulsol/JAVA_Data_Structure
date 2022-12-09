package 스택;


public class IntStack {

	
	// 자료구조와 함꼐 배우는 알고리즘 입문 p.136
	
	private int max; // 스택 용량 
	private int ptr; // 스택 포인터 
	private int [] stk;// 스택 본체 
	
	// 생성자 
	public IntStack(int capacity) {
		
		ptr = 0;
		max = capacity;		
		
		try {
			stk = new int [max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
		
	}
	
	
	// push 메서드, 스택에 x를 푸시 
	
	public int push(int x) {
		
		if (ptr>=max) {
			// 에러 
		}
		
		return stk[ptr++] = x; // 식이 전부 실행되고 ptr 값 증가
		
		// 대입 후에 왼쪽 피연산자의 형(Type)과 값을 얻을 수 있다.
	}
	
	// ptr 값은 항상 max 값보다 작아야 하는데 
	// 프로그래밍 실수와 같은 원인으로 ptr 값이 잘못 입력되면 max를 초과할 수 있다. 
	// 하자민 위와 같이 부등호로 판단하면 스택 본체 배열의 상한과 하한을 벗어나서 접근하는 것을 막을 수 있다. 
	// 간단한 코드 수정이지만 이런 노력으로 프로그램의 안정성을 높일 수 있다. 
	
	
	// pop 메서드 스택의 꼭대기에서 데이터를 팝(제거)하고 그 값을 반환하는 메서드  
	public int pop() {
		
		if(ptr<=0) {
			// 에러 
		}
			
		return stk[--ptr];
	}
	
	
	// peek 피크 메서드, 스택의 꼭대기에 있는 데이터를 '몰래 엿보는' 메서드
	
	public int peek() {
		
		if(ptr<=0) {
			// 에러 
		}
		
		return stk[ptr-1]; // 포인터 하나 전에 있는 값을 리턴 
		
	}
	

	// indexOf 검색 메서드 
	// 검섹 메서드는 꼭대기 쪽에서 바닥 쪽으로 선형 검색을 수행. 
	// 검색에 성공하면 찾아낸 요소의 인덱스를 반환, 실패하면 -1을 반환 
	// 꼭대기 쪽에서 스캔하는 이유는 "먼저 팝이 되는 데이터를 찾기위해서이다" 
	
	public int indexOf(int x) {
		for (int i=ptr-1; i<=0; i--) {
			
			if(stk[i] == x)
				return i;
		}
		
		return -1;
	}
	
	
	// clear 메서드, 스택을 비움 
	
	public void clear() {
		ptr = 0;
	}
	
	// capacity 메서드, 스택의 용량을 반환 
	
	public int capacity() {
		return max;
	}
	
	// size 메서드, 스택에 쌓여 있는 데이터 수를 반환
	
	public int size() {
		return ptr;
	}
	
	// 스택이 비어 있는가?
	
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	
	// 스택이 가득 찼는가?
	
	public boolean isFull() {
		return ptr >= max; 
	}
	
	// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순으로 출력 
	public void dump() {
		
		if(ptr <=0 ) {
			System.out.println("스택이 비어있습니다.");
		
		}else {
			for(int i=0; i<ptr; i++) 
				System.out.println( stk[i]+ " ");
			System.out.println();
		}
		
		
	}
	
	
}
