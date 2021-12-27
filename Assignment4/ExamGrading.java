

import java.util.Arrays;

public class ExamGrading {

	public static void main(String[] args) {
				
	}
	
	//write a method that gives students averages after a test
	public static double[] gradeAllStudents(char[][] r, char[] a) {
		
		//check if all students answered all the questions
		for(int i =0;i<r.length;i++) {
			if(r[i].length != a.length ) {
				throw new IllegalArgumentException("student " + i +" answered " + r[i].length + " questions instead of " + a.length);
			}
		}
		//create double array that is the same length as the amount of students taking the test
		double[] grades = new double[r.length];
		//iterate through the students and then their responses and compare the responses to the answer key
		//give each student max points and subtract every wrong answer from their score
		//once all answers have been compared, take the student's score divide it by the total amount of questions and 
		//multiply by 100 to get the %score, then store it in the double[].
		for(int i = 0; i<r.length;i++) {
			//make a variable that will keep track of the score of the student that the loop is iterating through
			double score = a.length;
			for(int j = 0;j<a.length;j++) {
				if(r[i][j] != a[j]) {
					score--;
				}
			}
			grades[i] = ((score/a.length)*100);
		}
		return grades;
	}
	
	public static int numWrongSimilar(char[] s1, char[] s2, char[] a) {
		//check if amount of answers in student1(s1) and Student2(s2) are the same
		if(s1.length != s2.length) {
			throw new IllegalArgumentException("Student arrays don't have the same length");
		}
		//if they are the same, check if they match the answer-key length
		else if(s1.length != a.length) {
			throw new IllegalArgumentException("Student arrays don't match answer-key length");		
		}
		//make a variable that will keep track of the amount of answers that are wrong and same
		int numWrong = 0;
		//iterate through both arrays and compare the answers they have at each index
		//to eachother and to the answer key
		//if they are both wrong and have the same answer increase the variable numWrong
		for(int i = 0;i<a.length;i++) {
			if((s1[i] == s2[i]) && s1[i] != a[i]) {
				numWrong++;
			}
			
		}
		return numWrong;
	}
	//compare the student at index i from the 2D array s to all the other students in array s 
	//if the student at i has greater than or equal to wrong answers as the threshold number t with another student
	//then the variable numMatches is increased by one
	public static int numMatches(char[][] s, char[] a, int i, int t) {
		int numMatches = 0;
		for(int j = 0;j<s.length;j++) {
			//check if j is not equal to the student we are inspecting(i) to make sure we do not check a student with himself
			if(j != i) {
				if(numWrongSimilar(s[j],s[i],a) >= t) {
					numMatches++;
				}
			}
		}
		return numMatches;
	}
	
	//method takes in array s of students' test answers and array a(answer-key) and an integer m
	//m is the minimum amount of same-wrong-answers required to have the return array(similarWrongAnswers) be populated with
	//an indices of the students, a student(i) shares m amount of wrong answers with
	//example there are 4 students and m=2 student 1 and 3 share 2 wrong answers the array would look like
	//[[],[3],[],[1]]
	public static int[][] findSimilarAnswers(char[][] s, char[] a, int m){
		//the return array needs to be of length (amount of students = s.length)
		int[][] similarWrongAnswers = new int[s.length][];
		
		//create new arrays for every students of length m and assign the address to the similarWrongAnswers array sub-arrays
		for(int i =0;i<s.length;i++) {
			//variable that will assign the similar student's index to the right index in sub-array
			int k = 0;
			//sub-arrays of length numMatches where t(numMathes) is m(findSimilarAnswers)
			int[] subarray = new int[numMatches(s,a,i,m)];
			
			//populate the sub-array with indices of the students the student(i) has similar wrong answers with.
			for(int j = 0;j<s.length;j++) {
				//check if j is not equal to the student we are inspecting(i) to make sure we do not check a student with himself
				if(j!=i) {
					//if the amount of wrong is >= m populate sub-array with index of this j student, if not go next
					if(numWrongSimilar(s[i],s[j],a) >= m) {
						subarray[k] = j;
						k++;
					}
				}
			}
			similarWrongAnswers[i] = subarray;
		}
		return similarWrongAnswers;
	}
	
}




























