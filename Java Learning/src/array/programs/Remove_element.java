package array.programs;

import java.util.Scanner;

public class Remove_element {
	public static void main(String args[]) {
		
		int arr[]= {5,7,3,9,20,-1,1};
		int removeindex=0;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("Enter the element to remove:");
		int input= sc.nextInt();
		for(int i=0;i<arr.length;i++) {
			if(input == arr[i]) {
				
				removeindex=i;
			}
		}
		System.out.println("Index is" +removeindex);
		
		for(int i=0;i<arr.length;i++) {
			if(i==removeindex) {
				System.out.println(arr[i+1]);
			}
			else {
				System.out.println(arr[i]);
			}
		}
	}
}