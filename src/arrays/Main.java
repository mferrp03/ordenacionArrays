package arrays;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	ArrayList<ArrayList<Integer>>solutions = new ArrayList<ArrayList<Integer>>();
	private int numlines = 0;
	public Main(int n) {
		this.numlines = n;
	}
	public static void main (String args[]) {
		String print;
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]>nums = new ArrayList<int[]>();
		do {
		String line = sc.nextLine();	
		String lineArray[] = line.split(" ");
		int size =Integer.parseInt(lineArray[0]);
		int array[] = new int[size];
		for (int i = 1;i <lineArray.length;i++) {
			array[i-1] = Integer.parseInt(lineArray[i]);		
		}
		nums.add(array);
		}while(!sc.hasNext("0"));
		sc.close();
		Main main = new Main(nums.size());
		for (int i=0;i<nums.size();i++) {
			int[] aux =nums.get(i);
			ArrayList<Integer>solution = new ArrayList<Integer>();
			main.solve(aux,solution,0);
			print = main.exit(i+1);
			System.out.println(print);
		}
		
	}
	public void solve(int[] original,ArrayList<Integer>sol, int n) {
		int aux; 
		int [] num = new int[original.length];
		for(int j = 0; j < original.length;j++) {
			num[j] = original [j];
		}
		ArrayList<Integer>solution = new ArrayList<Integer>();
		for(int j = 0; j < sol.size();j++) {
			solution.add(sol.get(j));
		}
		if(lastNotReady(num)!=-1) {
			if(n<num.length-1) {
				if(num[n]>num[n+1]) {
					solve(num,solution,n+1);
					aux = num[n];
					num[n]=num[n+1];
					num[n+1] = aux;
					solution.add(n);
					if(lastNotReady(num)!=-1) 
						solve(num,solution,0);
					else {
						solutions.add(solution);
						solution = new ArrayList<Integer>();
					}
				}
				else {
					solve(num,solution,n+1);
				}
			}
		}
	}
	public int lastNotReady(int[]num) {
		int last = -1;
		for(int i = 0; i<num.length-1;i++) {
			if(num[i]>num[i+1]) {
				last = i;
			}
		}
		
		
		return last;
	}
	public String exit(int n) {
		String exit = new String(); 
		if (solutions.size()!= 1)
			exit += "Hay " + solutions.size() + " formas de ordenar el array "+ n +".";
		else {
			exit += "Hay " + solutions.size() + " forma de ordenar el array "+ n + ".";
		}
		solutions.clear();
		return exit;
	}
}
