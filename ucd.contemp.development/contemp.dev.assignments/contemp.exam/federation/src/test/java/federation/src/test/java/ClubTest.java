package federation.src.test.java;
import static org.junit.Assert.*;

import federation.src.main.java.Club;
import federation.src.main.java.Federation;
import federation.src.main.java.Member;
import org.junit.Test;
public class ClubTest {
	@Test
	public void totalFeesTest0() throws Exception {
		Club club = new Club(); // set up first club
		assertEquals("test for 300 is ", 300, club.totalFees(6));
	}
	@Test
	public void totalFeesTest1() throws Exception {
		Club club = new Club(); // set up first club
		// club.totalFees()
		assertEquals("test for 0 is ", 0, club.totalFees(0));
	}

	@Test
	public void totalFeesTest2() throws Exception {
		Club club = new Club(); // set up first club
		assertEquals("test for adults 95 is ", 95, club.totalFees(95));
	}

	@Test
	public void totalFeesTest3() throws Exception {
		Club club = new Club(); // set up first club
		assertEquals("test for child 50 is ", 50, club.totalFees(50));
	}

	// CHECKING NUMBER OF MEMBERS

	@Test
	public void checkMemberTest() throws Exception { // test for checking if members are null
		Club club = new Club();
		assertTrue("No members: ", club.checkMember(null).equals(""));
	}

	@Test
	public void test() { // test for checking if test has been implimented
		fail("Not yet implemented");
	}
}
