package imple;

import java.io.*;
import java.util.*;

public class timu {
	private int n;
	private int range;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void generate(int n, int range) {
		char[] symbol = { '+', '-', '*', '/', '(' };
		int op; // 操作数
		try { 
			 File writename = new File("E:\\Java_szys\\szys.txt"); 
	            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
		for (int i = 0; i < n; i++) {

			String eHead = "" + (i + 1) + ". ";
			String e ="";
			int exlength = (int) (Math.random() * 4 + 2);
			int lbracket = 0;
			int rbracket = 0;
			int[] whe = new int[exlength]; 
			for (int j = 0; j < exlength; j++) {
				char s = symbol[(int) (Math.random() * 5)];
				if (j == exlength - 1 && s == '(') { 
					int count1 = lbracket;
					if (lbracket == 0) {
						e += "" + (int) (Math.random() * range) + "";
					} else {
						e += "" + (int) (Math.random() * range) + "";
						for (int q = 0; q < count1; q++) {
							e += ")";
							lbracket--;
						}
					}
					e += "=";
					continue;
				}
				if (lbracket == 0) { 
					if (s == '(') {
						e = e + "" + s + "" + (int) (Math.random() * range)
								+ "" + symbol[(int) (Math.random() * 4)] + "";

						whe[rbracket] = (int) (Math.random()
								* (exlength - j - 1) + j + 1);

						lbracket++;
						rbracket++;
					} else {
						e = e + "" + (int) (Math.random() * range) + "" + s
								+ "";
					}
				} else if (s != '(') {
					int count2 = lbracket;
					int count_match = 0;
					for (int l = 0; l < count2; l++) {
						if (whe[(rbracket-count2) + l ] == j) {
							if (count_match == 0) {
								e = e + "" + (int) (Math.random() * range)
										+ ")";
								count_match++;
								lbracket--;
							} else {
								e += ')';
								lbracket--;
							}
						}
					}
					if (count_match == 0) {
						e = e + "" + (int) (Math.random() * range) + "" + s
								+ "";
					} else {
						e += "" + s + "";
					}
				} else {
					int count3 = lbracket;
					int count = 0;
					for (int m = 0; m < count3; m++) {

						if (whe[rbracket-count3 + m] == j) {
							if (count == 0) {
								e = e + "" + (int) (Math.random() * range)
										+ ")";
								count++;
								lbracket--;

							} else {
								e += ')';
								lbracket--;

							}

						}

					}
					if (count == 0) {
						e = e + "(" + (int) (Math.random() * range) + ""
								+ symbol[(int) (Math.random() * 4)] + "";
						whe[rbracket] = (int) (Math.random()
								* (exlength - j - 1) + j + 1);
						lbracket++;
						rbracket++;
					} else {
						e += "" + symbol[(int) (Math.random() * 4)] + "("
								+ (int) (Math.random() * range) + ""
								+ symbol[(int) (Math.random() * 4)] + "";
						whe[rbracket] = (int) (Math.random()
								* (exlength - j - 1) + j + 1);
						rbracket++;
						lbracket++;
					}
				}

			}
			char[] strChar = e.toCharArray();
			strChar[strChar.length - 1] = '=';
			for(int g=0 ;g<strChar.length;g++){
				if(strChar[g]=='/'){
					if(strChar[g+1]=='0'){
					    i=i-1;
					    System.out.print("非法表达式");
					}
				    
				}
			}
			System.out.print(eHead);
			System.out.println(strChar);
			calculate ee = new calculate();
			double result = ee.calcualte(e);
	        out.write(eHead+"答案："+result+"\r\n"); 
	        out.flush(); 

		}
        out.close(); 
		  } catch (Exception e1) {  
	            e1.printStackTrace();  
	        }  
	}

}