package federation.src.main.java;

public class Member {
	public Member(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	

	public int annualFee() {
		if (type.equals("adult"))
			return 95; // adult fee
		else
			return 50; // child fee
	}

	public String getName() { return name; }
	public String getType() { return type; }

	public boolean checkName(Object other) { // equals is a bad name for it - java lang
		if (other.getClass() != this.getClass()) return false;
		return name.equals(((Member)other).getName());
	}

	public String toString() {
		if (type.equals("adult"))
			return name + " ("
				+ "adult"
				+ ") "
				+ "€" + 95;
		else
			return name + " ("
				+ "child"
				+ ") "
				+ "€" + 50;
	}

	private String name; // member name
	private String type; // type, i.e. "adult" or "child"
}