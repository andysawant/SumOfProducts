package com.sawant;
import java.math.BigInteger;
import java.util.Scanner;

import com.google.common.collect.EvictingQueue;

public class SumOfProducts {
	static BigInteger sum;

	public static void main(String[] args) {
		sum = BigInteger.valueOf(0);
		Scanner scanner = new Scanner(System.in);
		System.out.println("n = ");
		Integer n = scanner.nextInt();
		System.out.print("c = ");
		Integer c = scanner.nextInt();
		EvictingQueue<Integer> fifo = EvictingQueue.create(c);
		for (Integer i = 0; i < n; i++) {
			fifo.add(i);
			sum = sum.add(products(fifo));
			//System.out.println(i+"------"+sum);
		}
		if(sum.toString().length()>10)
		{
			System.out.println(sum.toString().substring(0,10));
		}else{
			System.out.println(sum);
		}
	}

	static BigInteger products(EvictingQueue<Integer> fifo) {
		BigInteger product = BigInteger.valueOf(1);
		if (fifo.size() == 1) {
			return BigInteger.valueOf(0);
		} else {
			for (Integer i : fifo) {
				if(i!=0){
					product =  product.multiply(BigInteger.valueOf(i));
				}
			}
		}
		System.out.println(fifo+" === "+product);
		return product;
	}
}
