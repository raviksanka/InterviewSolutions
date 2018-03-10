package com.self;

import java.util.concurrent.atomic.AtomicInteger;

public class GCDLCM {

	public static void main(String[] args) {

	}

	public static int gcd(int a, int b) {
		if (b == 0)	return a;
		else return (gcd(b, a % b));
	}

	public static int lcm(int a, int b) {
//		return (a*b/gcd(a,b));
		int lcm = 1, min, max, x;
		if (a > b) {
			max = a; min = b;
		} else {
			max = b; min = a;
		}
		for (int i = 1; i <= min; i++) {
			x = max * i;
			if (x % min == 0) {
				lcm = x;
				break;
			}
		}
		return lcm;
	}
	
	public static void swapAtomic(AtomicInteger a, AtomicInteger b) {
		a.set(b.getAndSet(a.get()));
	}

}
