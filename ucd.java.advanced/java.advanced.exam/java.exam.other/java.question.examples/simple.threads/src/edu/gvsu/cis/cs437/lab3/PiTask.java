package edu.gvsu.cis.cs437.lab3;

import java.math.BigDecimal;

/**
 * Runnable that invokes our compute intensive task.
 * 
 * @author Jonathan Engelsma (http://www.cis.gvsu.edu/~engelsma)
 *
 */
public class PiTask implements Runnable {

	Pi theTask;
	
	public PiTask(Pi theTask) {
		super();
		this.theTask = theTask;
	}

	public void run() {
		System.out.println("Computing Pi...");
		BigDecimal result = this.theTask.execute();
		System.out.println("The result is " + result + ".");
	}

}
