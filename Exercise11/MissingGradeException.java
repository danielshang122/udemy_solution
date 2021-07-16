package Exercise11;

public class MissingGradeException extends Exception {
	private int studentId;

	public MissingGradeException(int studentId) {
		super("studentId: " + studentId);
		this.studentId = studentId;
	}

	public int getStudentId() {
		return studentId;
	}

}
