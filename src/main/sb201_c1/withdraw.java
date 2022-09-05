package sb201_c1;

public class withdraw {

	 public static void main(String[] args) {
		  AccountDao act=new AccountImpl();
			
			System.out.println(act.withdraw(34500, 1));
	}

}
