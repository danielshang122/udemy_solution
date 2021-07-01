package Exercise_6;

public class Staff extends User {
	private long staffId;
	private int yearsOfExperience;
	private String description;
	private double salary;
	
	
	//getter and setter
	public long getStaffId() {
		return staffId;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
