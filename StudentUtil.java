public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
    	double[] studentGPA = new double[studentIdList.length];
    	int index=0;
        	for(char[] innerArray: studentsGrades) {
        		double sum=0;
        		for(char j : innerArray) {
        			switch(j){
        				case 'A':
        					sum+=4;
        				break;
        				case 'B':
        					sum+=3;
        				break;
        				case 'C':
        					sum+=2;
        				break;
        					}
        		}
        		studentGPA[index]=sum/innerArray.length;
        		index++;
        }
        return studentGPA;
    }
    
    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if(studentIdList==null ||studentsGrades==null||lower>higher||lower<0||higher<0) {
        	return null;
        }
        // invoke calculateGPA
        double[] studentGPA =calculateGPA( studentIdList, studentsGrades);
        int count=0;
        for(int i=0;i<studentGPA.length;i++) {
        	if(studentGPA[i]>=lower&&studentGPA[i]<=higher) {
        	count++;
        	}
        }
        int[] studentGPAList =new int[count];
        for(int i=0,j=0;i<studentGPA.length;i++) {
        	if(studentGPA[i]>=lower&&studentGPA[i]<=higher) {
        		studentGPAList[j]=studentIdList[i];
        		j++;
        	}
        }
        return studentGPAList;
        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
    }
    public static void main(String[] args) {
    	int studentIdList[]= {1001,1002};
    	char studentsGrades[][]= {{'A','B','C','A'},{'A','C','C','B'}};
    	
    	for(double i:calculateGPA(studentIdList, studentsGrades)) {
    		System.out.println(i);
    	}
    	for(int i:getStudentsByGPA(2.6,4.0,studentIdList, studentsGrades)) {
    		System.out.println(i);
    	}
    }
    
}