package test.mypac;

public class Member {
	public int num;
	public String name;
	public String addr;
	
	//기본 생성자
	public Member() {
		
	}
	
	//값을 3개 전달 받는 생성자(Constructor)
	public Member(int num, String name, String addr) {
		//매개 변수에 전달된 값을 필드에 저장하기 
		this.num=num;
		this.name=name;
		this.addr=addr;
	}
	//필드에 저장된 정보를 콘솔창에 출력하는 메소드
	public void showInfo() {
		//필드에 저장된 회원 정보를 1줄로 이쁘게 콘솔창에 출력하는 코드를 작성해 보세요.
		String info = "번호:"+this.num+" 이름:"+this.name+" 주소:"+addr;
		System.out.println(info);
	}
	
	//매개변수에 전달된 번호를 필드에 저장하고 자신의 참조값을 리턴하는 메소드 
	public Member num(int num) {
		this.num=num;
		return this;
	}
	
	//매개변수에 전달된 이름을 필드에 저장하고 자신의 참조값을 리턴하는 메소드 
	public Member name(String name) {
		this.name=name;
		return this;
	}
	
	//매개변수에 전달된 주소 필드에 저장하고 자신의 참조값을 리턴하는 메소드 
	public Member addr(String addr) {
		this.addr=addr;
		return this;
	}
}






