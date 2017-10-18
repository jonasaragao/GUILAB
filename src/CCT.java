
public class CCT extends Thread {

	public void run(){
		System.out.println("The thread is running...");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CCT cct = new CCT();
		cct.start();
	}

}
