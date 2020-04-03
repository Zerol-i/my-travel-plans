package imple;

import java.util.*;

public class calculate<optStack> {
	 private Map<String, Map<String, String>> priorityMap = new HashMap<String, Map<String, String>>();
	 private Stack<String> optStack = new Stack<String>();
	 private Stack<Double> numStack = new Stack<Double>();
	 
	 public double calcualte1(String exp) {
	  StringTokenizer vn = new StringTokenizer(exp);
	  while (vn.hasMoreTokens()) {
	   String token = vn.nextToken();
	   transversion(token);
	  }
	  return numStack.pop();
	 }
	 public double calcualte(String exp) {
		 char[] strExp = exp.toCharArray();
		 for(char a: strExp){
			 transversion(""+a+"");
		 }
		  return numStack.pop();
		 }

	 private void  transversion(String token) {
	  while (false == "=".equals(optStack.peek()) || false == token.equals("=")) {
	   if (true == judgenum(token)) {
	        numStack.push(Double.parseDouble(token));
	        break;
	        
	   } else {
	        String priority = priority(optStack.peek(), token);
	        if ("<".equals(priority)) {
	         optStack.push(token);
	         break;
	        } else if ("=".equals(priority)) {
	         optStack.pop();
	         break;
	        } else {
	          double res = calculate(optStack.pop(), numStack.pop(), numStack.pop());
	          numStack.push(res);
	        }
	   }
	  }
	 }

	 private double calculate(String opt, double a1, double a2) {
	  if ("+".equals(opt)) {
	   return a2 + a1;
	  } else if ("-".equals(opt)) {
	   return a2 - a1;
	  } else if ("*".equals(opt)) {
	   return a2 * a1;
	  } else if ("/".equals(opt)) {
	   return a2 / a1;
	  } else {
	   throw new RuntimeException("unsupported operator:" + opt);
	  }
	 }

	 private boolean judgenum(String token) {
	  int LEN = token.length();
	  for (int ix = 0 ; ix < LEN ; ++ix) {
	   char ch = token.charAt(ix);
	   if (ch == '.') {
	    continue;
	   }
	   if (false == judgenum(ch)) {
	    return false;
	   }
	  }
	  return true;
	 }

	 private boolean judgenum(char ch) {
	  if (ch >= '0' && ch <= '9') {
	   return true;
	  }
	  return false;
	 }

	 public String priority(String op1, String op2) {
	  return priorityMap.get(op1).get(op2);
	 }

	 public calculate() {

	  optStack.push("=");
	  Map<String, String> subMap = new HashMap<String, String>();
	  subMap.put("+", ">");
	  subMap.put("-", ">");
	  subMap.put("*", "<");
	  subMap.put("/", "<");
	  subMap.put("(", "<");
	  subMap.put(")", ">");
	  subMap.put("=", ">");
	  priorityMap.put("+", subMap);
	  // -
	  subMap = new HashMap<String, String>();
	  subMap.put("+", ">");
	  subMap.put("-", ">");
	  subMap.put("*", "<");
	  subMap.put("/", "<");
	  subMap.put("(", "<");
	  subMap.put(")", ">");
	  subMap.put("=", ">");
	  priorityMap.put("-", subMap);
	  // *
	  subMap = new HashMap<String, String>();
	  subMap.put("+", ">");
	  subMap.put("-", ">");
	  subMap.put("*", ">");
	  subMap.put("/", ">");
	  subMap.put("(", "<");
	  subMap.put(")", ">");
	  subMap.put("=", ">");
	  priorityMap.put("*", subMap);
	  // /
	  subMap = new HashMap<String, String>();
	  subMap.put("+", ">");
	  subMap.put("-", ">");
	  subMap.put("*", ">");
	  subMap.put("/", ">");
	  subMap.put("(", "<");
	  subMap.put(")", ">");
	  subMap.put("=", ">");
	  priorityMap.put("/", subMap);
	  // (
	  subMap = new HashMap<String, String>();
	  subMap.put("+", "<");
	  subMap.put("-", "<");
	  subMap.put("*", "<");
	  subMap.put("/", "<");
	  subMap.put("(", "<");
	  subMap.put(")", "=");
	  //subMap.put("#", ">");
	  priorityMap.put("(", subMap);
	  // )
	  subMap = new HashMap<String, String>();
	  subMap.put("+", ">");
	  subMap.put("-", ">");
	  subMap.put("*", ">");
	  subMap.put("/", ">");
	  //subMap.put("(", "<");
	  subMap.put(")", ">");
	  subMap.put("=", ">");
	  priorityMap.put(")", subMap);
	  // #
	  subMap = new HashMap<String, String>();
	  subMap.put("+", "<");
	  subMap.put("-", "<");
	  subMap.put("*", "<");
	  subMap.put("/", "<");
	  subMap.put("(", "<");
	  //subMap.put(")", ">");
	  subMap.put("=", "=");
	  priorityMap.put("=", subMap);
	 }
	}