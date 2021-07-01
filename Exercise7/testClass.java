package Exercise7;

public class testClass {
public static void main (String args[]) {
	HealthInsurancePlan insurancePlan =new GoldPlan();
	Patient patient= new Patient();
	patient.setInsurancePlan(insurancePlan);
	double[] payments = Billing.computePaymentAmount(patient, 1000.0);
	for (double d : payments) {
		System.out.println(d);
	}
}
}
