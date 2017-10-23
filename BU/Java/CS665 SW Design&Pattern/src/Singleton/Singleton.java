package Singleton;



/**
 * 
 * @author DonYoo
 *
 *
 * Singleton pattern used when you have several computer but one printer.
 * 
 * when multiple computers try to print pages at the same time, single printer should wait for the previous work before 
 * 
 * it start print out the next work.
 * 
 * 
 */
public class Singleton {

	private volatile static Singleton uniqueInstance;
	
	private Singleton(){}
	
	public static synchronized Singleton getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	public String getDescription (){
		return "this is thread";
	}
}
