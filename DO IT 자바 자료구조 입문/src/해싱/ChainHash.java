package 해싱;

public class ChainHash<K,V> {
		
	
	class Node<K,V>{
		
		private K key; // 회원 번호
		private V data; // 회원 정보(이름, 키, 몸무게)
		
		private Node<K,V> next; // 다음 노드에 대한 참조
	
		
		public Node(K key, V data, Node<K,V> next) {
			
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		K getKey() { return key; }
		
		V getValue() { return data; }
		
		public int hashCode() {
			return key.hashCode();
					
		}
		

	}
	
	private int size; // 해시 테이블의 크기 
	private Node<K,V> [] table; // 해시 테이블
	
	
	// 생성자
	public ChainHash(int capacity) {
		table = new Node[capacity];
		this.size = capacity;
	}	
	
	
	// 해시 값을 구함
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	
	public V search(K key) {
		
		int hash = hashValue(key); // 검색할 데이터의 해시 값
		Node<K,V> p = table[hash]; // 선택 노드
		
		while(p != null) {
			if(p.getKey().equals(key))
				return p.getValue(); // 검색 성공
			p = p.next;
		}
		
		return null; // 검색 실패
	}
	
	
	public int add(K key, V data) {
		
		int hash = hashValue(key);
		Node<K,V> p = table[hash]; // 선택 노드
		
		while(p != null) {
			if(p.getKey().equals(key)) // 이 키 값은 이미 등록됨
				return 1; 
			p = p.next;
		}
		
		Node<K, V> temp = new Node<K,V>(key, data, table[hash]); // 리스트의 맨 앞에 삽입
		table[hash] = temp;
		return 0;
	}
	
	
	
	public int remove(K key) {
		
		int hash = hashValue(key);
		
		Node<K,V> p = table[hash];
		Node<K,V> pp = table[hash]; // 바로 앞의 선택노드
		
		while(p != null) {
			if(p.getKey().equals(key)) { // 찾으면 
				
				if(pp == null)
					table[hash] = p.next; // 처음에 바로 찾으면
				else
					pp.next = p.next; // 중간에 있으면 
				
				return 0;
			}
				
			pp = p; // pp 따라오게 하고 
			p = p.next; // p 전진
			
		}
		
		return 1;
		
	}
	
	
	public void dump() {
		
		for(int i=0; i<size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d ", i);
			
			while(p != null) {
				System.out.printf("-> %s (%s) ", p.getKey(), p.getValue());
				p = p.next;
			}
			
			System.out.println("");
		}
		
		
	}
	

}
