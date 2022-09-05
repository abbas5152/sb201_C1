package sb201_c1;

public class findbyid {
	

  public static void main(String[] args) {
	 AccountDao act=new AccountImpl();
	 System.out.println(act.findById(1));;
}

}
