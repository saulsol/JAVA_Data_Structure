package 트리;
import java.util.*;

public class BinTree <K, V>{
		
	
	static class Node<K, V>{
			
		private K key;
		private V data;
		private Node<K,V> left;
		private Node<K,V> right;
		
		public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			super();
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		
		// 키 값을 반환 
		K getKey() {
			return key;
		}
		
		// 데이터를 반환 
		V getValue() {
			return data;
		}
		
		// 데이터를 출력 
		void print() {
			System.out.println(data);
		}
		
		
	}
	
	private Node<K, V> root; // 루트 노드 
	private Comparator<? super K> comparator = null; // 비교자 
	
	
	//기본 생성자, 자연 순서에 따라 키 값을 비교 
	public BinTree() {
		root = null;
	}
	
	//비교자로 키 값을 비교 
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	// 두 값을 비교 
	private int comp(K key1, K key2) {
		
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2); 
	}
	
	
	// 키에 대한 검색 
	public V search(K key) {
			
		Node<K,V> p = root;
		
		while(true) {
			
			if(p == null)
				return null;
			
			int cond = comp(key, p.getKey());
			
			if(cond == 0)
				return p.getValue();
			else if(cond < 0)
				p = p.left;
			else
				p = p.right;
				
			
		}
		
	}
	
	// node를 루트로 하는 서브 트리에 노드<K,V>를 삽입 
	private void addNode(Node<K,V> node, K key, V data) {
		
		int cond = comp(key, node.getKey());
		
		if(cond == 0)
			return; //key가 이미 이진트리에 있음  
		
		else if(cond < 0) {
			
			if(node.left == null)
				node.left = new Node<K,V>(key, data, null, null);
			else
				addNode(node.left, key, data);
			
		} else {
			
			if(node.right == null)
				node.right = new Node<K,V>(key, data, null, null);
			else
				addNode(node.right, key, data);
		}
	}
	
	
	// 노드를 삽입 
	public void add(K key, V data) {
		
		if(root == null)
			root = new Node<K, V>(key, data, null, null);
		else
			addNode(root, key, data);
		
	}
	
	
	// 키 값이 key인 노드를 삭제 
	public boolean remove(K key) {
		
		Node<K,V> p = root;
		Node<K,V> parent = null;
		boolean isLeftChild = true; // p는 부모의 왼쪽 자식 노드인가? 
		
		
		while(true) {
			
			if(p == null)
				return false;
			
			int cond = comp(key, p.getKey());
			
			if(cond == 0) {
				break;
			}else {
				
				parent = p;
				if(cond < 0) {
					isLeftChild = true;
					p = p.left;
				}else {
					isLeftChild = false;
					p = p.right;
				}
				
				
			}
			
		}
		
		
		if(p.left == null) { //p 에는 왼쪽 자식이 없음 
			
			if(p == root)
				root = p.right;
			else if(isLeftChild) 
				parent.left = p.right;
			else
				parent.right = p.right;
			
		}else if (p.right == null) { // p 에는 오른쪽 자식이 없는 경우 
			
			if(p == root) 
				root = p.left;
			else if (isLeftChild)
				parent.left = p.left;
			else
				parent.right = p.left;
			
		}else { // p에 양쪽으로 자식이 있는 경우 
			
			Node<K, V> left = p.left; // 서브 트리 가운데 가장 큰 노드 
			isLeftChild = true;
			
			while(left.right != null) { // 가장 큰 노드 left를 검색 
				
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			
			p.key = left.key;
			p.data = left.data;
			if(isLeftChild)
				parent.left = left.left;
			else
				parent.right = left.left;
			
			
		}
		
		
		
		return true;
		
	}
	
	
	private void printSubTree(Node node) {
		
		if(node != null) {
			
			printSubTree(node.left);
			System.out.println(node.key + " " + node.data );
			printSubTree(node.right);
			
		}
		
		
	}
	
	
	public void print() {
		printSubTree(root);
	}
	
	
	
	
	
	
	
	
	
	
	

}
