package Exercise9;

public class PlatinumPlan extends HealthInsurancePlan {

	public PlatinumPlan() {
		super.setCoverage(0.9);
	}

	@Override
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return salary*0.08+ getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
