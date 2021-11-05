package application;

public class Loan {
	private static double annualInterestRate;
	private static int numberOfYears;
	private static double loanAmount;
	
	public Loan(double annualInterestRate,int numberOfYears, double loanAmount){
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
	}
	public Loan(){
		this(annualInterestRate, numberOfYears, loanAmount);
	}
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	public void setNumberOfYears(int numberOfYears){
		this.numberOfYears = numberOfYears;
	}
	public void setLoanAmount(double loanAmount){
		this.loanAmount = loanAmount;
	}
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	public int getNumberOfYears(){
		return numberOfYears;
	}
	public double getLoanAmount(){
		return loanAmount;
	}
	public double getTotalPayment(){
		return loanAmount * Math.pow((1 + annualInterestRate), numberOfYears * 12);
	}
}
