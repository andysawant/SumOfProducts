package com.sawant;

import java.math.BigInteger;
import java.util.Date;
import java.util.Scanner;

import com.google.common.collect.EvictingQueue;

public class SumOfProducts2 {
	static BigInteger sum;

	public static void main(String[] args) {
		BigInteger productElements = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		long firstProductElement = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("n = ");
		Integer n = scanner.nextInt();
		System.out.print("c = ");
		Integer c = scanner.nextInt();
		//System.out.println(new Date());
		for (int i = 1; i <= c; i++) {
			productElements = productElements.multiply(BigInteger.valueOf(i));
			sum = sum.add(productElements);
		}

		for (long i = ++c; i < n; i++) {
			productElements = productElements.divide(BigInteger.valueOf(firstProductElement))
					.multiply(BigInteger.valueOf(i));
			sum = sum.add(productElements);
			firstProductElement += 1;
		}

		String sumStr = sum.toString();
		sum = sumStr.length() > 10 ? BigInteger.valueOf(Long.valueOf(sumStr.substring(0, 10))) : sum;
		//System.out.println(new Date());
		System.out.println(sum);
	}
}
