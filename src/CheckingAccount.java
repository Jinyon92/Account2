
public class CheckingAccount extends Account {
	
	private double credit_limit;
	private double interest;
	private double loan_interest;
	
	public CheckingAccount(double balance,double credit_limit,double interest,double loan_interest) {
		super(balance);
		this.credit_limit=-(credit_limit);	
		this.interest = interest;
		this.loan_interest=loan_interest;
	}

	@Override
	public void debit(double amount)throws Exception{
		if(amount<0){
			throw new Exception("음수입력!");
		}
		
		if(getBalance()-amount<credit_limit)
		{
			throw new Exception("Debit amout exceeded account balance.\n");
		}
		else
		{
			setbalance(getBalance()-amount);
		}
	}
	
	public void nextMonth(){
		if(getBalance()>0)
		{
			setbalance(getBalance()+getBalance()*interest);
		}
		else if(getBalance()<0)
		{
			setbalance(getBalance()+getBalance()*loan_interest);
		}
	}
	
	public double getWithdrawableAccount(){
		if(getBalance()-credit_limit>=0){
		return (getBalance()-credit_limit);
		}else{
			return 0;
		}
	}
	
	public boolean isBankrupted(){
		if(getBalance()<credit_limit)
			return true;
		else
			return false;	
		
	}
	
	public void passTime(){
		passTime(1);
	}
	
	
	public void passTime(int time){
		if(getBalance()>0){
			setbalance(getBalance()+time*(getBalance()*interest));
		}else{
			setbalance(getBalance()+time*(getBalance()*loan_interest));
		}
	}
	

	
	public double estimateValue(int month){
		passTime(month);
		return getBalance();
	}
	
	public double estimateValue(){
		return estimateValue(1);
	}
	
	public String toString(){
		return String.format("CheckingAccount_Balance: %f",getBalance());
	}
	
} 