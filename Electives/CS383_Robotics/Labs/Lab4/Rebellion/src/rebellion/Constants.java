package rebellion;

/**
 * @author grace
 * Constants for model and rebellion calculations
 */
public class Constants {

	// model constants
	public static final String CONTEXT_ID = "Rebellion";
	public static final String SPACE_ID = "space";
	public static final String GRID_ID = "grid";

	// rebellion calculation constants
	public static final double K = 2.3; // for arrest probability
	public static final double THRESHOLD = 0.1; // how much before rebel?
	public static final double RISK_AVERSION = 1.0; // for Person
	public static final double PERCEIVED_HARDSHIP = 1.0; // for Person
	
	public static final boolean DEBUG = false;
	
	private Constants() {
		;
	}
}
