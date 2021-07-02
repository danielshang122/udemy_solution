package Exercise8;

public class GoldPlan extends HealthInsurancePlan{
	
	public GoldPlan(){
		super.setCoverage(0.8);
	}

	@Override
	public double computeMonthlyPremium(double salary) {
		// TODO Auto-generated method stub
		return salary*0.07;
	}

}
