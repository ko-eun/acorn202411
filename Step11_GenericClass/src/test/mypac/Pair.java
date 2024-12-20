package test.mypac;

// Generic 클래스는 복수 개 일 수도 있다.
public class Pair <K, V> {
	// 필드
	private K key;
	private V value;
	
	// 생성자
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	// 메소드
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
