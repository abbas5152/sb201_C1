package sb201_c1;

public class save {
  public static void main(String[] args) {
	  AccountDao act=new AccountImpl();
		Account a=new Account(2,"ayw@gmail.com","Raj",56000);
		System.out.println(act.save(a));
}
}
