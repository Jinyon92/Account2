
public class Car implements Valuable{
	private String name;
	private double price;
	
	int retry=0;
	
	public Car(String name,double price){
		this.name=name;
		this.price=price;
	}
	
	public double estimateValue(int month){
		if(retry==0){
		this.price=(this.price*0.8);
		retry=1;
		}
		for(int i=0;i<month;i++){
			this.price = this.price*0.99;
		}
			return this.price;
	}
	
	public double estimateValue(){
		return estimateValue(1);
	}
	
	public String toString(){
		return String.format("car name:%s \n initial price:%f",name,price);
	}
}
