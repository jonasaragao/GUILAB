
public class CollegeImplement {
	
	public CollegeImplement(){
		College col = new College();
		Thread col2 = new Thread(col);
		col2.start();		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CollegeImplement();
	}
}
