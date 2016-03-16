package rebellion;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.query.space.grid.GridCell;
import repast.simphony.random.RandomHelper;

public class SMUtils {

	// get free grid cells
	public static <T> List<GridCell<T>> getFreeGridCells(
			final List<GridCell<T>> neighborhood) {
		if (null == neighborhood) {
			throw new IllegalArgumentException(
					"Parameter neighborhood cannot be null.");
		}

		final ArrayList<GridCell<T>> ret = new ArrayList<GridCell<T>>();

		for (final GridCell<T> act : neighborhood) {
			if (0 == act.size()) {
				ret.add(act);
			}
		}
		return ret;
	}
	
	// pick random element
	public static <T> T randomElementOf(final List<T> list) {
		if (null == list) {
			throw new IllegalArgumentException("Parameter list cannot be null.");
		}
		if (list.isEmpty()) {
			throw new IllegalArgumentException(
					"Cannot return a random element from an empty list.");
		}
		return list.get(RandomHelper.nextIntFromTo(0, list.size() - 1));
	}

	private SMUtils() {
		;
	}
}
