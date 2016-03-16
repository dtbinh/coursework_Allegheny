/*
 * Version info:
 *     $HeadURL: https://cscs-repast-demos.googlecode.com/svn/richard/StupidModel/tags/2011_05_29_model_05/src/stupidmodel/common/SMUtils.java $
 *     $LastChangedDate: 2011-05-29 19:01:44 +0200 (V, 29 máj. 2011) $
 *     $LastChangedRevision: 182 $
 *     $LastChangedBy: richard.legendi@gmail.com $
 */
package stupidmodel.common;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.query.space.grid.GridCell;
import repast.simphony.random.RandomHelper;

/**
 * Dedicated class for declaring utility functions that is uninstantiable.
 * 
 * <p>
 * Final class, cannot be extended.
 * </p>
 * 
 * @author Richard O. Legendi (richard.legendi)
 * @since 2.0-beta, 2011
 * @version $Id: SMUtils.java 174 2011-05-29 06:31:57Z richard.legendi@gmail.com
 *          $
 */
public final strictfp class SMUtils {

	/**
	 * Returns a filtered list of {@link GridCell} instances from the specified
	 * collection which holds no objects.
	 * 
	 * @param neighborhood
	 *            an arbitrary list of <code>GridCell</code> objects; <i>cannot
	 *            be <code>null</code></i>
	 * @return a filtered list of empty <code>GridCell</code> objects, more
	 *         specifically for which <code>size()</code> returns <code>0</code>
	 *         ; if there is no empty cell in the specified list, an empty list
	 *         is returned
	 */
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

	/**
	 * Returns a random element of the specified arbitrary list.
	 * 
	 * @param list
	 *            the list to select a random element from; <i>cannot be
	 *            <code>null</code> or empty</i>
	 * @return a random element of the specified list using the default random
	 *         generator of {@link RandomHelper}
	 */
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

	/**
	 * Hidden constructor to ensure no instances are created.
	 */
	private SMUtils() {
		;
	}

}
