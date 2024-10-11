package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 10;
	
	
	public static int Search(Integer[] list, int target)
	{
		int l = 0;
		int r = list.length - 1;
		
		while(l<=r)
		{
			int mid= l + (r- l)/2;
			
			if(list[mid] == target)
			{
				return mid;
			}
			 
			if(list[mid] < target)
			{
				l = mid + 1;
			}
			
			else
			{
				r = mid -1;
			}
			
		}
		
		return -1;
		
	}
	
	
	public static int getTargetValue(String message)
	{
		System.out.println(message);
		Scanner keyboardInput = new Scanner( System.in );
		int value = keyboardInput.nextInt();
		
		return value;
	}
	

	public static void main( String[] args )
	{

		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();
		int randnum = rand.nextInt( UPPER_BOUND );
		nums[0] = randnum;

		for( int i = 1; i < SIZE; i++ )
		{
			randnum = rand.nextInt( UPPER_BOUND );
			nums[i] = nums[i - 1] + randnum;
			//System.out.println( nums[i] );
		}
		
		System.out.println("Sorted array:");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int target = getTargetValue("What number are you searching for?");
        
        int index = Search(nums, target);
        
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the list.");
        }
	}
}
