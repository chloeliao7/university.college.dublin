package federation.src.main.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Federation implements Strategy {
	public Federation() { clubs = new ArrayList<Club>(); }

	// club constructor
	public void addClub(Club newClub) { clubs.add(newClub); }

	// report
	public String generateReport() {
		// initialization
		String str = "";
		int count = 0;
		Iterator<Club> iterClub = clubs.iterator();
		while (iterClub.hasNext()) {
			count++;
			str += "Club " + count + ": " + iterClub.next().toString() + "\n";
		}
		return str += "Total fees due: €" + totalFees();
	}

	// fees
	public int totalFees() {
		Iterator<Club> clubIter = clubs.iterator();
		int totalFee = 0;
		while (clubIter.hasNext()) {
			Club club = clubIter.next();
			Iterator<Member> memberIter = club.getMembers().iterator();
			while (memberIter.hasNext()) {
				member = memberIter.next();
				totalFee += member.annualFee();
			}
		}
		return totalFee;
	}

	private ArrayList<Club> clubs;
	private Member member;
}
