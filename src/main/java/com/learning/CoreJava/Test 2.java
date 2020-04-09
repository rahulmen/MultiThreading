package com.learning.CoreJava;

import java.util.Scanner;

public class Test {
	

	
	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number");
		int num = scan.nextInt();
		scan.close();

		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				if(j>=i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}

	}

}
