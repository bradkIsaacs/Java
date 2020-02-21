public class Account {
	private double savings;
	private double checking;

	public Account(double ch, double sa) {
		this.checking = ch;
		this.savings = sa;
	}
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	public double getChecking() {
		return checking;
	}
	public void setChecking(double checking) {
		this.checking = checking;
	}
}