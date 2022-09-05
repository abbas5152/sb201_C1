package sb201_c1;

public class update {

	
	  public static void main(String[] args) {
		  AccountDao act=new AccountImpl();
			Account a=new Account(3,"ayw@gmail.com","Rew",51000);
			System.out.println(act.update(a));
	}
}
