package Exercise6;

public class Doctor extends Staff {
	private long doctorId;
	private String specializaiton;
	
	//getter and setter
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getSpecializaiton() {
		return specializaiton;
	}
	public void setSpecializaiton(String specializaiton) {
		this.specializaiton = specializaiton;
	}

}
