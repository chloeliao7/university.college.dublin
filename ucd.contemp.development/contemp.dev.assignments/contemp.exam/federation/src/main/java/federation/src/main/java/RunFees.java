package federation.src.main.java;

public class RunFees {
	public static void main(String[] args) {
		Federation fed = new Federation();
		GenerateMain generateMain = new GenerateMain(fed);
		System.out.println("<html> Total fees: " + generateMain.execReport() + "<html>");
	}
}
