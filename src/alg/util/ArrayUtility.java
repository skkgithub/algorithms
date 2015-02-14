package alg.util;

import java.util.Random;

public class ArrayUtility 
{
	public static int[] getRandomArray(int size) 
	{
		int a[] = new int[size];

		for (int i = 0; i < size; i++) 
		{
			a[i] = i;
		}

		shuffleArray(a);

		return a;
	}

	private static void shuffleArray(int[] a) 
	{
		int n = a.length;
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) 
		{
			int change = i + random.nextInt(n - i);
			swap(a, i, change);
		}
	}

	private static void swap(int[] a, int i, int change) 
	{
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}

	public static void printArray(int[] c) 
	{
		for (int i = 0; i < c.length; i++) 
		{
			System.out.print(c[i] + " ");
		}
		System.out.println();
	}
}
