package federation.src.main.java;

public class GenerateMain {
	private Strategy strategy;

	// strat constructor
	public GenerateMain(Strategy strategy) { this.strategy = strategy; }
	public String execReport() { return strategy.generateReport(); }
}
