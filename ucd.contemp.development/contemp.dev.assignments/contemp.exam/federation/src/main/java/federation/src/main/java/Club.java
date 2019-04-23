package federation.src.main.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Club {
	public Club() { members = new ArrayList<Member>(); }

	public void addMember(Member newMember) {
		if (!members.contains(newMember)) { members.add(newMember); }
	}

	public ArrayList<Member> getMembers() { return members; }

	public String checkMember(String n) {
		if (members.isEmpty()) return "No members";
		String str = "";
		// Iterator<Member> iterMember = members.iterator();
		while (iterMember.hasNext()) {
			str += iterMember.next().toString();
			if (iterMember.hasNext()) str += ", ";
		}
		return str;
	}

	public int totalFees(int i) {

		int totalFee = 0;
		
		if (iterMember.hasNext()) {
			member = iterMember.next();
			totalFee += member.getType().equals("adult") ? 95 : 50;
		}
		
		while (iterMember.hasNext()) {
			member = iterMember.next();
			totalFee += member.getType().equals("adult") ? 95 : 50;
		}
		return totalFee;
	}
	private ArrayList<Member> members;
	Iterator<Member> iterMember = members.iterator();

	Member member;
}
