package lab4;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.*;

public class Lab4Test {
	@Test
	public void processNumber1() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 1", lab.processNumber(1).equals("1"));
	} // this method works since its returning 1

	@Test
	public void processNumber2() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 2", lab.processNumber(2).equals("2"));
	} // this method DOES NOT WORK since its returning 1

	@Test
	public void processNumber3() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 3 - RETURNS BEE", lab.processNumber(3).equals("Bee"));
	} // this methodis suppose to return Bee ---- >   assertTrue("number is : 3 - RETURNS BEE", lab.processNumber(3).equals("Boop"));} // this methodis DOES NOT WORK and will fail

	@Test
	public void processNumber4() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 4", lab.processNumber(4).equals("4"));
	} // this methodis suppose to return 4 if you add 4
	
	@Test
	public void processNumber5() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 5", lab.processNumber(5).equals("Bop"));
	} // this method is suppose to return bop if number % 5 == 0
	
	@Test
	public void processNumber6() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 6", lab.processNumber(6).equals("Bee"));
	} // this method is suppose to return bee
	
	@Test
	public void processNumber7() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 7", lab.processNumber(7).equals("7"));
	} // this method is suppose to return 7 since it is not devisible by 3 || 5
	
	@Test
	public void processNumber8() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 8", lab.processNumber(8).equals("8"));
	} // this method is suppose to return 8 since it is not devisible by 3 || 5
	
	@Test
	public void processNumber9() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 9", lab.processNumber(9).equals("Bee"));
	} // not needed to change the lab4 file since devisible by 3
	
	@Test
	public void processNumber10() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 10", lab.processNumber(10).equals("Bop"));
	} // not needed to change the lab4 file since devisible by 5
	
	@Test
	public void processNumber12() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 12", lab.processNumber(12).equals("Bee"));
	} // not needed to change the lab4 file since devisible by 3
	
	@Test
	public void processNumber15() {
		Lab4 lab = new Lab4();
		assertTrue("number is : 15", lab.processNumber(15).equals("BeeBop"));
	} // not needed to change the lab4 file since devisible by 3 and 5
	
	@Test
	public void mutationCoverage() {
		Lab4 lab = new Lab4();
		assertTrue("mutations covers: ", lab.processNumber(2323).equals("Mutation"));
	} // not needed to change the lab4 file since devisible by 3 and 5
}
