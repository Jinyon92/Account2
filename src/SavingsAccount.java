
public class SavingsAccount extends Account {

	private double interest;
	private double time;
	
	
	public SavingsAccount(double balance,double interest) {
		super(balance);
		this.interest=interest;
	}
	
	@Override
	public void debit(double amount)throws Exception{
		if(amount<0){
			throw new Exception("음수입력!");
		}
		
		if(time<=12){
			throw new Exception("아직 출금할 수 없습니다");
		}else{
			setbalance(getBalance()-amount);
		}
	}
	
	public double getWithdrawableAccount(){
		if(time<12){
			return 0;
		}else{
			return getBalance();
		}
	}
	
	public void passTime (int time){
	      if((this.time < 12)&&(this.time+time >= 12)){
	          setbalance(getBalance()*Math.pow((1+interest), 12));   
	       }
	       this.time = this.time + time;
	}
	
	public void passTime(){
		passTime(1);
	}
	
	public double estimateValue(int month){
		passTime(month);
		return getBalance()*Math.pow(1+interest,this.time);
	}
	
	public double estimateValue(){
		return estimateValue(1);
	}
	
	
	public String toString(){
		return String.format("SavingAccount_Balance: %f",getBalance());
	}
	
}