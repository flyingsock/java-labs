package lebedeva;

public class Main {

    public static void main(String[] args) {
	    final SymStats stats = new SymStats("Абырвалг");
	    stats.calculate();

	    stats.writeStats();
    }
}
