package federation.src.test.java;

import static org.junit.Assert.*;

import federation.src.main.java.Member;
import org.junit.Test;

public class MemberTest {
	@Test
	public void TestCreation() {
		Member adultMember = new Member("Jack", "adult");
		assert (adultMember.getName().equals("Jack"));
		assertEquals(95, adultMember.annualFee());
		assertEquals("Jack (adult) €95", adultMember.toString());
		Member childMember = new Member("Aoife", "child");
		assert (childMember.getName().equals("Aoife"));
		assertEquals(50, childMember.annualFee());
		assertEquals("Aoife (child) €50", childMember.toString());
	}
}