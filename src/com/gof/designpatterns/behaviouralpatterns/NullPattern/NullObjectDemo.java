package com.gof.designpatterns.behaviouralpatterns.NullPattern;

import java.io.OutputStream;
import java.io.PrintStream;


/*
Intent

The intent of a Null Object is to encapsulate the absence of an object by providing a substitutable alternative that offers suitable default do nothing behavior. In short, a design where "nothing will come of nothing"

Use the Null Object pattern when

an object requires a collaborator. The Null Object pattern does not introduce this collaboration--it makes use of a collaboration that already exists
some collaborator instances should do nothing
you want to abstract the handling of null away from the client


 */

/*
 Client -
requires a collaborator.
AbstractObject -
declares the interface for Client's collaborator
implements default behavior for the interface common to all classes, as appropriate
RealObject -
defines a concrete subclass of AbstractObject whose instances provide useful behavior that Client expects
NullObject -
provides an interface identical to AbstractObject's so that a null object can be substituted for a real object
implements its interface to do nothing. What exactly it means to do nothing depends on what sort of behavior Client is expecting
when there is more than one way to do nothing, more than one NullObject class may be required
 */




class NullOutputStream extends OutputStream {
    public void write(int b) {
        // Do nothing
    }
}

class NullPrintStream extends PrintStream {
    public NullPrintStream() {
        super(new NullOutputStream());
    }
}

public class NullObjectDemo {
    private PrintStream debugout;
    public NullObjectDemo(PrintStream debugout) {
        this.debugout = debugout;
    }

    public void go() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            debugout.println("i = " + i);
        }
        System.out.println("sum = " + sum);
    }
}