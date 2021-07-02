package Exercise8;

public class PlatinumPlan extends HealthInsurancePlan {

	public PlatinumPlan() {
		super.setCoverage(0.9);
	}

	@Override
	public double computeMonthlyPremium(double salary) {
		// TODO Auto-generated method stub
		return salary*0.08;
	}
}
