package test.mypac;

public class MelonBox {
	
	private Melon item;
		
	public void pack(Melon item) {
		this.item = item;
	}
		
	public Melon unPack() {
		return item;
	}
}
