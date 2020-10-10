package com.gof.designpatterns.behaviouralpatterns.VisitorPattern.Example;

public class ShoppingCartClient {
	 
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"),new Book(100, "5678"),
                new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};
         
        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);
    }
 
    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum=0;
        for(ItemElement item : items){
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
 
}
//Refernces:

//http://sourcemaking.com/design_patterns/visitor/java/3
//http://www.journaldev.com/1769/visitor-design-pattern-in-java-example-tutorial
//http://javapapers.com/category/design-patterns/behavioral-design-patterns/
//http://www.oodesign.com/visitor-pattern.html