import java.util.List;
import java.util.ArrayList;

public abstract class Account implements Valuable {
	
	private double balance;
	
	public Account(double balance){
		if(balance>0)
		{
			this.balance = balance;
		}
	}
	public void credit(double deposit){
		balance = balance + deposit;
	}
	
	public double getBalance(){
		return balance;
	}
	protected void setbalance(double change){
		balance = change;
	}
	
	public void debit(double amount) throws Exception{
		balance -=amount;
	}
	
	public abstract double getWithdrawableAccount();
	public abstract void passTime(int time);
	
	public static double sumForAccount(ArrayList<? extends Account> list){
		double sum = 0;
		for(Account account : list){
			sum +=account.getBalance();
		}
		return sum;
	}
	
	public static void passTimeForList(ArrayList<? extends Account> list,int month){
		for(Account account : list){
			account.passTime(month);
		}
	}
		
}