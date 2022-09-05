package sb201_c1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccountImpl implements AccountDao{

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		Account a=new Account();
		
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("accountUnit");
		EntityManager em= emf.createEntityManager();
		
		a=em.find(Account.class, id);
		
		return a;
		
	}

	@Override
	public String save(Account account) {
		// TODO Auto-generated method stub
		String ans=null;
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("accountUnit");
			EntityManager em= emf.createEntityManager();
			
			
			em.getTransaction().begin();
			em.persist(account);
			ans="Added succesfully";
			em.getTransaction().commit();
			
		    
		
		return ans;
	}

	@Override
	public String update(Account account) {
		// TODO Auto-generated method stub
		String ans=null;
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("accountUnit");
			EntityManager em= emf.createEntityManager();
			
			Account ac= em.find(Account.class, account.getId());
			if(ac!=null) {
			em.getTransaction().begin();
			ac.setEmail(account.getEmail());
			ac.setAddress(account.getAddress());
			ac.setBalance(account.getBalance());
			ans="Updated ";
			em.getTransaction().commit();
			
			
			
			}
			else {
				ans="Account not found";
			}
			
			return ans;
	}

	@Override
	public String remove(int id) {
		// TODO Auto-generated method stub
		String ans=null;
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("accountUnit");
			EntityManager em= emf.createEntityManager();
			
			Account ac= em.find(Account.class, id);
			if(ac!=null) {
			em.getTransaction().begin();
			em.remove(ac);
			ans="deleted";
			em.getTransaction().commit();
			
			
			
			}
			else {
				ans="Account not found";
			}
			
			return ans;
	}

	@Override
	public String withdraw(double amount, int accountId) {
		// TODO Auto-generated method stub
		String ans=null;
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("accountUnit");
			EntityManager em= emf.createEntityManager();
			
			Account ac= em.find(Account.class, accountId);
			if(ac!=null) {
				
				if(ac.getBalance()>=amount) {
			em.getTransaction().begin();
			
			
			ac.setBalance((int)ac.getBalance()-amount);
			ans="withdraw";
			
			em.getTransaction().commit();
				}
				else {
					ans="not sufficient balance";
				}
			
			
			
			}
			else {
				ans="Account not found";
			}
			
			return ans;
	}

	@Override
	public String deposit(double amount, int accountId) {
		// TODO Auto-generated method stub
		String ans=null;
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("accountUnit");
			EntityManager em= emf.createEntityManager();
			
			Account ac= em.find(Account.class, accountId);
			if(ac!=null) {
			em.getTransaction().begin();
			
			ac.setBalance((int)ac.getBalance()+amount);
			ans="deposited";
			em.getTransaction().commit();
			
			
			
			}
			else {
				ans="Account not found";
			}
			
			return ans;
	}

}
