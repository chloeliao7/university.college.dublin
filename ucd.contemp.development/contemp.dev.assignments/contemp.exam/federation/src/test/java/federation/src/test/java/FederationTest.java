package federation.src.test.java;

import static org.junit.Assert.*;

import federation.src.main.java.Club;
import federation.src.main.java.Federation;
import federation.src.main.java.Member;
import org.junit.Before;
import org.junit.Test;

public class FederationTest {
	@Before
	public void setUp() throws Exception {
		myFederation = new Federation();

		// Set up first club
		Club club1 = new Club();
		club1.addMember(new Member("Jack", "adult"));
		club1.addMember(new Member("Aoife", "child"));
		club1.addMember(new Member("Greta", "adult"));
		myFederation.addClub(club1);

		// Set up second club
		Club club2 = new Club();
		club2.addMember(new Member("Greta", "adult"));
		myFederation.addClub(club2);

		// Set up third club
		Club club3 = new Club();
		club3.addMember(new Member("Luke", "child"));
		club3.addMember(new Member("Eimear", "child"));
		myFederation.addClub(club3);

		// Set up fourth club
		Club club4 = new Club();
		myFederation.addClub(club4);
	}

	@Test
	public void testFees() {
		assertEquals(435, myFederation.totalFees());
	}

	@Test
	public void testReport() {
		String desiredReport = "Club 1: Jack (adult) €95, Aoife (child) €50, Greta (adult) €95\n"
													 + "Club 2: Greta (adult) €95\n"
													 + "Club 3: Luke (child) €50, Eimear (child) €50\n"
													 + "Club 4: No members\n"
													 + "Total fees due: €435";
		assertEquals(desiredReport, myFederation.generateReport());
	}

	private Federation myFederation;
}
