package assignment1209;
//to find a pair whose sum is closed to Zero in Array s
public class Q1 {
	public static void findzero(int[] input) {
		int result=input[0]+input[1];
		int a=input[0];
		int b=input[1];
		for(int i=0;i<input.length-1;i++) {
			//System.out.println(input[i]);
			for(int j=i+1;j<input.length;j++) {
				if (Math.abs(input[i]+input[j])<Math.abs(result)) {
					result=input[i]+input[j];
					a=input[i];
					b=input[j];
				}
			}
		}
		System.out.println(a+" "+b+" "+result);
	}
	public static void main(String[] args) {
		int[] input= {1,2,3,6,-5};
		findzero(input);
		
	}
}
