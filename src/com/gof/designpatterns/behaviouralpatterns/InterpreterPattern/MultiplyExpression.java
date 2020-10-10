package com.gof.designpatterns.behaviouralpatterns.InterpreterPattern;

public class MultiplyExpression implements IExpression {

	IExpression leftExpression;
	IExpression rightExpresion;

	public MultiplyExpression(IExpression leftExpression,
			IExpression rightExpresion) {
		this.leftExpression = leftExpression;
		this.rightExpresion = rightExpresion;
	}

	@Override
	public int interpret() {

		return leftExpression.interpret() * rightExpresion.interpret();
	}

}
