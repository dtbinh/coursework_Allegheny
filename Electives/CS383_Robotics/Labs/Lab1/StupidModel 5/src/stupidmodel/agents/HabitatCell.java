/*
 * Version info:
 *     $HeadURL: https://cscs-repast-demos.googlecode.com/svn/richard/StupidModel/tags/2011_05_29_model_05/src/stupidmodel/agents/HabitatCell.java $
 *     $LastChangedDate: 2011-07-15 11:28:54 +0200 (P, 15 júl. 2011) $
 *     $LastChangedRevision: 700 $
 *     $LastChangedBy: richard.legendi@gmail.com $
 */
package stupidmodel.agents;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameter;
import repast.simphony.random.RandomHelper;
import repast.simphony.util.ContextUtils;
import repast.simphony.valueLayer.GridValueLayer;
import stupidmodel.StupidModelContextBuilder;
import stupidmodel.common.Constants;
import repast.simphony.space.grid.Grid;
import java.util.Collections;
import java.util.Comparator;
import repast.simphony.query.space.grid.GridCell;



/**
 * Habitat cell objects have instance variables for their food availability and
 * maximum food production rate.
 * 
 * @author Richard O. Legendi (richard.legendi)
 * @since 2.0-beta, 2011
 * @since Model 3
 * @version $Id: HabitatCell.java 183 2011-05-29 17:09:27Z
 *          richard.legendi@gmail.com $
 */
public class HabitatCell {

	/** Maximum food production rate is initialized to <code>0.01</code>. */
	private double maximumFoodProductionRate = 0.01;

	/**
	 * Represents the actual food availability at this cell, initialized to
	 * <code>0.0</code>.
	 */
	private double foodAvailability = 0.0;

	/** Location of this cell at the grid. */
	private final int x, y;

	/**
	 * Creates a new instance of <code>HabitatCell</code>.
	 * 
	 * @param x
	 *            the specified <code>x</code> coordinate; <i>must be
	 *            non-negative</i>
	 * @param y
	 *            the specified <code>y</code> coordinate; <i>must be
	 *            non-negative</i>
	 */
	public HabitatCell(final int x, final int y) {
		if (x < 0) {
			throw new IllegalArgumentException(String.format(
					"Coordinate x = %d < 0.", x));
		}

		if (y < 0) {
			throw new IllegalArgumentException(String.format(
					"Coordinate y = %d < 0.", y));
		}
		
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the maximum food production rate of the current cell.
	 * 
	 * <p>
	 * Parameter usage II: This method was created to demonstrate the usage of
	 * parameters declared at the level of agents.
	 * </p>
	 * 
	 * @return the value of {@link #maximumFoodProductionRate}
	 * @since Model 5
	 * @see StupidModelContextBuilder#build(repast.simphony.context.Context)
	 * @field maximumFoodProductionRate
	 */
	@Parameter(displayName = "Cell maximum food production rate", usageName = "maximumFoodProductionRate")
	public double getMaximumFoodProductionRate() {
		return maximumFoodProductionRate;
	}

	/**
	 * Sets the maximum food consumption rate of the current bug.
	 * 
	 * @param maximumFoodProductionRate
	 *            the new value of {@link #maximumFoodProductionRate}; <i>must be
	 *            non-negative</i>
	 * @since Model 5
	 */
	public void setMaximumFoodProductionRate(double maximumFoodProductionRate) {
		if (maximumFoodProductionRate < 0) {
			throw new IllegalArgumentException(String.format(
					"Parameter maximumFoodProductionRate = %f < 0.",
					maximumFoodProductionRate));
		}
		
		this.maximumFoodProductionRate = maximumFoodProductionRate;
	}

	/**
	 * Returns the current food availability of this cell.
	 * 
	 * @return the <code>foodAvailability</code> of the cell; <i>a non-negative
	 *         value</i>
	 */
	public double getFoodAvailability() {
		return foodAvailability;
	}

	/**
	 * Sets the current food availability of this cell.
	 * 
	 * @param foodAvailability
	 *            the new <code>foodAvailability</code> value; <i>must be
	 *            non-negative</i>
	 */
	public void setFoodAvailability(final double foodAvailability) {
		if (foodAvailability < 0) {
			throw new IllegalArgumentException(String.format(
					"Parameter foodAvailability = %f < 0.", foodAvailability));
			
		}

		this.foodAvailability = foodAvailability;
	}

	/**
	 * Each time step, food availability is increased by food production. Food
	 * production is a random floating point number between zero and the maximum
	 * food production.
	 * 
	 * <p>
	 * Food production is scheduled before agent actions.
	 * </p>
	 */
	@ScheduledMethod(start = 1, interval = 1, priority = 1)
	public void growFood() {
		foodAvailability += RandomHelper.nextDoubleFromTo(0.0,
				maximumFoodProductionRate);

		final GridValueLayer foodValueLayer = (GridValueLayer) ContextUtils
				.getContext(this).getValueLayer(Constants.FOOD_VALUE_LAYER_ID);

		if (null == foodValueLayer) {
			throw new IllegalStateException(
					"Cannot locate food value layer with ID="
							+ Constants.FOOD_VALUE_LAYER_ID + ".");
		}

		foodValueLayer.set(getFoodAvailability(), x, y);
	}

	/**
	 * A {@link Bug} agent can consume food of the cell on which it is located
	 * at.
	 * 
	 * @param eatenFood
	 *            food to consume by the caller agent from this cell; <i>must be
	 *            non-negative and below the current
	 *            <code>foodAvailability</code></i>
	 */
	public void foodConsumed(final double eatenFood) {
		if (eatenFood < 0.0) {
			throw new IllegalArgumentException(String.format(
					"eatenFood = %f < 0.0", eatenFood));
		}

		if (eatenFood > foodAvailability) {
			throw new IllegalArgumentException(String.format(
					"eatenFood = %f > foodAvailability = %f", eatenFood,
					foodAvailability));
		}
		
	
			foodAvailability -= eatenFood;
	}

	
	 public final static class HabitatCellFoodAvailabilityComparator implements
     Comparator<GridCell<HabitatCell>> {

		 	@Override
		 	public int compare(final GridCell<HabitatCell> gc1,
             final GridCell<HabitatCell> gc2) {
		 		final HabitatCell cell = gc1.items().iterator().next();
		 		final HabitatCell bell = gc2.items().iterator().next();
		 		return -Double.compare(cell.foodAvailability, bell.foodAvailability);
		 		}
	 	}

	 
	 
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// Override default Java implementation just to have a nicer
		// representation
		return String.format(
				"HabitatCell @ location (%d, %d), foodAvailability=%f", x, y,
				foodAvailability);
	}

}
