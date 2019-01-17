package subframe;

 class sort {
	
	
public static void sor( int arr[]) {
	for(int i=0;i<arr.length-1;i++) {
	int index =i;
	for(int j=i+1;j<arr.length;j++) {
		if(arr[j]<arr[index]) {
			index=j;
		}}
	int smallnumber= arr[index];
	arr[index]=arr[i];
	arr[i]=smallnumber;
	}
	}
	
	public static void main(String args[]) {
	int array[]= {11,4,5,2,3};
	System.out.println("before sorting");
	for(int i=0;i<array.length;i++) {
		System.out.println(array[i]);
		
	}
	sor(array);
	System.out.println("Sorted array"+" ");
	for(int j=0;j<array.length;j++) {
		System.out.println(array[j]);
	}
		
	}
	
	
}


