package Strategy;

public class Machine {

	Recipe recipe;
	private int milk;
	private int sugar;
	
	public Machine() {
	}
	
	public void Setrecipe(Recipe recipe) {
		this.milk =0;
		this.sugar =0;
		this.recipe = recipe;
	}

	public void run() {
		this.recipe.brew();
		if(this.milk !=0 || this.sugar !=0){
			System.out.println(" add milk "+ this.milk + " sugar "+ this.sugar);
		}
		else{
			System.out.println();
		}
	}
	
	public void addmilk(int level) {
		this.milk = level;
	}

	public void addsugar(int level) {
		this.sugar = level;
	}

}
