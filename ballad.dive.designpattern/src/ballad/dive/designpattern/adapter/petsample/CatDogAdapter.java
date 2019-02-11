package ballad.dive.designpattern.adapter.petsample;

public class CatDogAdapter {
	private Pet pet;

	public CatDogAdapter(Pet pet) {
		this.pet = pet;
	}
	

	public void pretendCatRun() {
		System.out.println("CAT RUNNING");
	}
	
	public void pretendDogRun(){
		System.out.println("DOG RUNNNG");
	}
}
