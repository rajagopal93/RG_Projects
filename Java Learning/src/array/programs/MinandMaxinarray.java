package array.programs;

public class MinandMaxinarray {

	public static void main(String args[]) {
		
	int arr[]= {5,7,3,9,20,-1,1};
	
	int i=0,j=0,temp=0;
	
	for(i=0;i<arr.length; i++) {
		for(j=i+1;j<arr.length;j++) {
			if(arr[i]>arr[j]) {
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	for(i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]);
	}
	System.out.println("Minimum element" +arr[0]);
	System.out.println("Maximum element" +arr[arr.length-1]);
	}
	
}
