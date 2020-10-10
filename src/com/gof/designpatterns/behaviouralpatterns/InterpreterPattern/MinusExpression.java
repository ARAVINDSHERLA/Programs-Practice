package com.gof.designpatterns.behaviouralpatterns.InterpreterPattern;

public class MinusExpression implements IExpression {

	IExpression leftExpression;
	IExpression rightExpresion;

	public MinusExpression(IExpression leftExpression,
			IExpression rightExpresion) {
		this.leftExpression = leftExpression;
		this.rightExpresion = rightExpresion;
	}

	@Override
	public int interpret() {

		return leftExpression.interpret() - rightExpresion.interpret();
	}

}
