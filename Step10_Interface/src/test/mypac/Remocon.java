package test.mypac;
/*
 *  [ interface ]
 *  
 *  - 생성자가 없다 (단독 객체 생성 불가)
 *  - 추상 메소드 혹은 default 메소드를 가질수 있다.
 *  - 필드는 static final 상수만 가질수 있다.
 *  - data type  의 역활을 할수 있다.
 *  - interface type 의 참조값이 필요하면 구현(implements) 클래스를 만들어서
 *    객체를 생성해야 한다.
 *  - 클래스 상속은 단일 상속이지만, 인터페이스는 다중 구현이 가능하다 
 */
public interface Remocon {
	/*
	 *  필드도 가질수 있지만 static final 만 가능하다 
	 *  static : static 영역에 Remocon 인터페이스와 같이 만들어 진다
	 *  final : 값이 결정된 이후에 변경 불가능(상수화 시킨다)
	 *  생략가능 
	 */
	public String COMPANY="LG"; // final 상수는 관례상 필드명을 모두 대문자로 
	
	//미완성의 추상 메소드를 맴버로 가질수 있다.
	public void up();
	public void down();	
}



