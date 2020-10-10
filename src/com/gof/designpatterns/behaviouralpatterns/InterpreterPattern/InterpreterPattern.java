package com.gof.designpatterns.behaviouralpatterns.InterpreterPattern;

/*
 Interpretation Parser

Algorithm for postfix expression parser implementation is simpler than for infix.

Read token one by one and loop till end of expression
Is read element a number 
true then, push it to a stack
false then,
pop two elements from stack
apply the operator
push the result to stack
 */
import java.util.Stack;

public class InterpreterPattern {
	public static void main(String args[]) {
		String tokenString = "4 3 2 - 1 + *";
		Stack stack = new Stack();

		String[] tokenList = tokenString.split(" ");
		for (String s : tokenList) {
			if (isOperator(s)) {
				IExpression rightExpression = (IExpression) stack.pop();
				IExpression leftExpression = (IExpression) stack.pop();
				IExpression operator = getOperatorInstance(s, leftExpression,
						rightExpression);
				int result = operator.interpret();
				stack.push(new NumberExpression(result));
			} else {
				IExpression i = new NumberExpression(s);
				stack.push(i);
			}
		}
		System.out.println("Result: "+((IExpression) stack.pop()).interpret());
	}

	public static boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*"))
			return true;
		else
			return false;
	}
	

	public static IExpression getOperatorInstance(String s, IExpression left,
			IExpression right) {
		if("+".equals(s))
			return new PlusExpression(left, right);
		else if("-".equals(s))
			return new MinusExpression(left, right);
		else if("*".equals(s))
			return new MultiplyExpression(left, right);
		/*switch (s) {
		case "+":
			return new PlusExpression(left, right);
		case "-":
			return new MinusExpression(left, right);
		case "*":
			return new MultiplyExpression(left, right);
		}*/
		return null;
	}
}