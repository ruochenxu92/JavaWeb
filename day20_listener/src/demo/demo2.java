package demo;

public class demo2 {

	public static void main(String[] args){
		
	}

}

class Person{
	private PersonListener listener;
	
	public void eat(){
		
	}
	
	public void run(){
		
	}
	
	public void registerListener(PersonListener listener){
		this.listener = listener;
	}
}

interface PersonListener{
	
	public void doeat();
	public void dorun();
	
	
}

