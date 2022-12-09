package 큐;

public class IntQueue {

	
	private int max; // 큐의 용량 
	private int front; // 첫 번째 요소 커서 
	private int rear; // 마지막 요소 커서 
	
	private int num; // 현재 데이터 수 
	private int [] que; // 큐 본체 
	
	public IntQueue(int capacity) { // 생성자 
		num = front = rear = 0;
		max = capacity;
		
		try {
			
			que = new int[max];
			
		} catch (Exception e) {
			
		}
	}
	
	
	// 큐에 데이터를 인큐 
	public int enque(int x) {
		
		if(num >= max) {
			throw null;
		}
		
		que[rear++] = x; // 배열의 0 번째 요소부터 인큐  
		num++;
		
		if(rear == max) { // rear가 배열의 맨 끝에 있는 상황 
			rear = 0; 
		}
		
		return x;
	}
	
	
	// 큐에서 데이터를 디큐 
	public int dequeue() {
		
		if(num <= 0) {
			throw null;
		}
		
		int x = que[front++]; // 배열 맨 첫 번째 요소부터 디큐 
		num --; 
		
		if(front == max) {
			front = 0;
		}
		
		return x;
	}
	
	
	
	// 큐에서 데이터를 피크(프런트 데이터를 들여다 봄)
	public int peek() {
		return que[front];
	}
	
	
	// 큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
	public int indexOf(int x) {
		for(int i=0; i<num; i++) {
			int idx = (i + front) % max;
			if(que[idx] == x)
				return idx;
		}
		return -1;
	}
	
	
	public void dump() {
		if(num <=0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for(int i=0; i<num; i++) {
				System.out.print(que[(i+front) % max] + " ");
			}
			System.out.println();
		}
	}
	
}
