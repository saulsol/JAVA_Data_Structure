package 해싱;

public class Ex {

	public static void main(String[] args) {

		Custom a = new Custom("aaa");
		Custom b = new Custom("aaa");	// 내용이 같음
		Custom c = a;					// 주소 복사 (shallow copy)

		System.out.println("a객체 : " + a.hashCode());
		System.out.println("b객체 : " + b.hashCode());
		System.out.println("c객체 : " + c.hashCode());
	}
	
	
	

	static class Custom {
		String str;

		public Custom(String str) {
			this.str = str;
		}
		
		
		public int hashCode() {
			return str.hashCode();
		}
		
	}

}
