
public class College implements Runnable {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
			for (;;){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i = 0; i < 1000;i++){
					System.out.println(i);
				}
				System.out.println("Hello");
				
			}		
	}

}
