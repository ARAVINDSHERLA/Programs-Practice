package com.gof.designpatterns.behaviouralpatterns.VisitorPattern.Example;

public interface ShoppingCartVisitor {
	 
    int visit(Book book);
    int visit(Fruit fruit);
}
