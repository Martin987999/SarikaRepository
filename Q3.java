package assignment1209;

//3.Write an algorithm to implement bubble sort?
public class Q3 {
	public static void bubble(int[] input) {
		int temp;

		for (int i = 0; i < input.length - 1; i++) {

			for (int j = 0; j < input.length - 1; j++) {
				if (input[j] > input[j + 1]) {
					// System.out.println(j);
					temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}
		for(int i:input) { System.out.println(i); }
	}

	public static void main(String[] args) {
		int[] input = { 5, 5, 6, 8, 7, 2, 2, 3, 5, 1 };
		bubble(input);
	}

}
