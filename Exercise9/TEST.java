package Exercise9;

public class TEST {
public static void main(String[] args) {
	User staff = new User();
	InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
	HealthInsurancePlan insurancePlan = new PlatinumPlan();

	insurancePlan.setOfferedBy(insuranceBrand);
	staff.setInsurancePlan(insurancePlan);
	//insurancePlan.computeMonthlyPremium(5000,56,true);
	System.out.println(insurancePlan.computeMonthlyPremium(8000,56,true));
}
}
