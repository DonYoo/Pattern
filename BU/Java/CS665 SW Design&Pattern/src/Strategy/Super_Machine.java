package Strategy;

public class Super_Machine {
	public static void main(String[] args) {
		Machine Machine = new Machine();
		Machine.Setrecipe(new Espresso());
		Machine.run();
		
		Coffee coffee = new Americano();
		Machine.Setrecipe(coffee);
		Machine.addmilk(1);
		Machine.run();
      
		coffee = new Latte_Marcchiato();
		Machine.Setrecipe(coffee);
      	Machine.run();
      	
      	Machine.Setrecipe(new BlackTee());
      	Machine.addsugar(2);
      	Machine.addmilk(3);
      	Machine.run();
      	
      	Tee GT = new GreenTee();
      	Machine.Setrecipe(GT);
      	Machine.run();
   }

}
