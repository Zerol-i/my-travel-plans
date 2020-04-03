package test;
import java.util.*;

import imple.*;
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        timu a =new timu();
        System.out.println("Ŀ:");
        Scanner scan = new Scanner(System.in);
        int num=scan.nextInt();
        a.setN(num);
        a.setRange(10);
        a.generate(a.getN(), a.getRange());
	}

}