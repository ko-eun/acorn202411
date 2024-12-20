package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	
	static class SeaWeapon extends Weapon{
		@Override
		public void attack() {
			System.out.println("바다에 있는 적들을 공격합니다.");
		}	
	}
	
	public static void main(String[] args) {
		
		//아래의 useWeapon() 메소드를 호출하려면 Weapon type 의 참조값이 필요하다 
		//아래의 메소드를 호출했을때 "바다에 있는 적들을 공격" 하려면 여기에서 어떻게 코딩해야 할까?
		Weapon w1 = new SeaWeapon();
		MainClass04.useWeapon(w1);
		
		class SpaceWeapon extends Weapon{
			@Override
			public void attack() {
				System.out.println("우주를 공격해요~");
			}
		}
		
		useWeapon(new SpaceWeapon());
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}













