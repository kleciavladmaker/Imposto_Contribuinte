package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;
	
	public Individual() {

	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double basicTax;
		if (this.getAnualIncome() < 20000.0) {
			basicTax = this.getAnualIncome() * 15 / 100;
		} else {
			basicTax = this.getAnualIncome() * 25 / 100;
		}
		basicTax -= this.getHealthExpenditures() * 50 / 100;
		if (basicTax < 0.0) {
			basicTax = 0.0;
		}
		return basicTax;
	}

}
