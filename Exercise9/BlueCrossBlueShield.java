package Exercise9;

public class BlueCrossBlueShield implements InsuranceBrand {

	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
		double premium=0;
		if (insurancePlan instanceof PlatinumPlan) {
			if(age>55) {
				premium+=200;
				System.out.println(premium);
			}
			if(smoking) {
				premium+=100;
				System.out.println(premium);
			}
		}
		
		if (insurancePlan instanceof GoldPlan) {
			if(age>55) {
				premium+=150;
			}
			if(smoking) {
				premium+=90;
			}
		}
		
		if (insurancePlan instanceof SilverPlan) {
			if(age>55) {
				premium+=100;
			}
		    if(smoking) {
				premium+=80;
			}
		}
		
		if (insurancePlan instanceof BronzePlan) {
			if(age>55) {
				premium+=50;
			}
		    if(smoking) {
				premium+=70;
			}
		}
		return premium;
	}

}
