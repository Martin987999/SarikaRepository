package assignment1209;
//Find minimum number of platforms required for railway station
//You are given arrival and departure time of trains reaching to a particular station.
//You need to find minimum number of platforms required to accommodate the trains at any point of time.
/*ex: arrival[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00} 
departure[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}
No. of platforms required in above scenario = 4*/
public class Q2 {
	public static void platform(int[]l1,int[]l2) {
		int[][] time=new int[l1.length][2];
		int count=0;
		for(int i=0;i<time.length;i++) {
			time[i][0]=l1[i];
			time[i][1]=l2[i];
		}
		for(int i=0;i<time.length;i++) {
			for(int j=i+1;j<time.length;j++) {
				if((l1[i]>=l1[j]&&l1[i]<=l2[j])||(l2[i]>=l1[j]&&l2[i]<=l2[j]))
					count++;
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		int[] l1= {100,140,150,200,215,400};
		int[] l2= {110,300,220,230,315,600};
		platform(l1, l2);
	}
}
