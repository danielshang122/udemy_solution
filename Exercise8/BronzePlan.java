package Exercise8;

public class BronzePlan extends HealthInsurancePlan {

	public BronzePlan() {
		super.setCoverage(0.6);;
	}

	@Override
	public double computeMonthlyPremium(double salary) {
		// TODO Auto-generated method stub
		return salary*0.05;
	}

	
}
