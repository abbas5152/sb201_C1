package sb201_c1;

public class delete {

	
	 public static void main(String[] args) {
		  AccountDao act=new AccountImpl();
			
			System.out.println(act.remove(2));
	}
}
