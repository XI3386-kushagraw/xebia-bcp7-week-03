import java.util.Scanner;

public class MergeSortEx {

	// Divide and merge array
	void mergeArray(int a[], int s, int m, int e) {
		int n1 = m - s + 1;
		int n2 = e - m;

		int[] a1 = new int[n1];
		int[] a2 = new int[n2];

		for (int i = 0; i < n1; ++i) {
			a1[i] = a[s + i];
		}
		for (int i = 0; i < n2; ++i) {
			a2[i] = a[m + i + 1];
		}

//		Merge arrays
		int i = 0, j = 0;

		int k = s;

		// Copying elements to main array
		while (i < n1 && j < n2) {
			if (a1[i] <= a2[j]) {
				a[k] = a1[i];
				i++;
			} else {
				a[k] = a2[j];
				j++;
			}
			k++;
		}

		// copying remaining elements if any
		while (i < n1) {
			a[k] = a1[i];
			i++;
			k++;
		}
		while (j < n2) {
			a[k] = a2[j];
			j++;
			k++;
		}
	}

	void sortArray(int a[], int s, int e) {
		if (s < e) {
			int m = s + (e - s) / 2;

			sortArray(a, s, m);
			sortArray(a, m + 1, e);

			mergeArray(a, s, m, e);
		}
	}

	void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// Enter the number of elements in array
		System.out.println("Enter the number of elements you want to enter");
		int n = sc.nextInt();

		// Initializing the array
		int[] ar = new int[n];

		// Entering the elements
		System.out.println("Enter the elements you want");
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		MergeSortEx m = new MergeSortEx();

		m.sortArray(ar, 0, n - 1);

		m.printArray(ar);

		sc.close();

	}

}
