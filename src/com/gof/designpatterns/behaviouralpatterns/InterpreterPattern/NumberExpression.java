package com.gof.designpatterns.behaviouralpatterns.InterpreterPattern;

public class NumberExpression implements IExpression {
	int number;

	public NumberExpression(int i) {
		number = i;
	}

	public NumberExpression(String s) {
		number = Integer.parseInt(s);
	}

	@Override
	public int interpret() {
		return number;
	}

}