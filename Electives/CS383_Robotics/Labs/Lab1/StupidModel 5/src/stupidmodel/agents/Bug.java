/*
 * Version info:
 *     $HeadURL: https://cscs-repast-demos.googlecode.com/svn/richard/StupidModel/tags/2011_05_29_model_05/src/stupidmodel/agents/Bug.java $
 *     $LastChangedDate: 2011-07-15 11:28:54 +0200 (P, 15 júl. 2011) $
 *     $LastChangedRevision: 700 $
 *     $LastChangedBy: richard.legendi@gmail.com $
 */
package stupidmodel.agents;

import java.util.List;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameter;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;
import repast.simphony.util.SimUtilities;
import stupidmodel.StupidModelContextBuilder;
import stupidmodel.common.Constants;
import stupidmodel.common.SMUtils;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList; 



/**
 * Bug agent implementation for <i>StupidModel 1</i>.
 * 
 * <p>
 * Agents in this model are very simple: they can access their neihgbourhood at
 * a grid and move to a random position within sight range (that is a fixed
 * constant for now, see {@link Constants#BUG_VISION_RANGE}.
 * </p>
 * 
 * <p>
 * If there is no free cell around the agent, it cannot move, so it stays in its
 * current position.
 * </p>
 * 
 * @author Richard O. Legendi (richard.legendi)
 * @since 2.0-beta, 2011
 * @version $Id: Bug.java 700 2011-07-15 09:28:54Z richard.legendi@gmail.com $
 */
public class Bug implements Comparable<Bug> {

	/**
	 * Bugs have an instance variable for their size, which is initialized to
	 * 1.0.
	 * 
	 * @since Model 2
	 */
	private double size = 1.0;

	/**
	 * Maximum food consumption of the bug (set to <code>1.0</code> by default).
	 */
	private double maxConsumptionRate = 1.0;

	/**
	 * Creates a new instance of <code>Bug</code> associated with the specified
	 * {@link Grid}.
	 */
	public Bug() {
		super();
	}

	/**
	 * Returns a reference to the grid on which the agent is located at.
	 * 
	 * @return the <code>Grid</code> on which the agent is located; <i>cannot be
	 *         <code>null</code></i>
	 * @since Model 2
	 */
	public Grid<Object> getGrid() {
		@SuppressWarnings("unchecked")
		final Grid<Object> grid = (Grid<Object>) ContextUtils.getContext(this)
				.getProjection(Constants.GRID_ID);

		if (null == grid) {
			throw new IllegalStateException("Cannot locate grid in context.");
		}

		return grid;
	}

	/**
	 * Returns the size of the bug.
	 * 
	 * @return the size of the bug
	 * @since Model 2
	 */
	@Parameter(displayName = "Bug Size", usageName = "size")
	public double getSize() {
		return size;
	}

	/**
	 * Sets the size of the bug, <i>used for testing</i>.
	 * 
	 * @param size
	 *            the new size of the bug
	 * @since Model 2
	 */
	public void setSize(final double size) {
		if (size < 0) {
			throw new IllegalArgumentException(String.format(
					"Parameter size = %f < 0.", size));
		}

		this.size = size;
	}

	/**
	 * Returns the maximum food consumption rate of the current bug.
	 * 
	 * <p>
	 * Parameter usage II: This method was created to demonstrate the usage of
	 * parameters declared at the level of agents.
	 * </p>
	 * 
	 * @return the value of {@link #maxConsumptionRate}
	 * @since Model 5
	 * @see StupidModelContextBuilder#build(repast.simphony.context.Context)
	 * @field maxConsumptionRate
	 */
	@Parameter(displayName = "Bug maximum food consumption rate", usageName = "maxConsumptionRate")
	public double getMaxConsumptionRate() {
		return maxConsumptionRate;
	}

	/**
	 * Sets the maximum food consumption rate of the current bug.
	 * 
	 * @param maxConsumptionRate
	 *            the new value of {@link #maxConsumptionRate}; <i>must be
	 *            non-negative</i>
	 * @since Model 5
	 */
	public void setMaxConsumptionRate(final double maxConsumptionRate) {
		if (maxConsumptionRate < 0) {
			throw new IllegalArgumentException(String.format(
					"Parameter maxConsumptionRate = %f < 0.",
					maxConsumptionRate));
		}

		this.maxConsumptionRate = maxConsumptionRate;
	}

	/**
	 * Implementation of the agent activity in each turn.
	 * 
	 * <p>
	 * Using the annotation {@link ScheduledMethod} makes this
	 * <code>step()</code> method executed from the first simulation tick, and
	 * with specifying interval it is executed each tick afterwards.
	 * </p>
	 * 
	 * <p>
	 * Agents work in a very simple way: they gather their neighbourhood and
	 * check for empty locations. If any is found, one of them is randomly
	 * chosen and the agent is relocated to that location.
	 * </p>
	 */
	@ScheduledMethod(start = 1, interval = 1, priority = 0)
	public void step() {
		
		final Grid<Object> grid = getGrid();
        final GridPoint location = grid.getLocation(this);

        final List<GridCell<Bug>> bugNeighborhood = new GridCellNgh<Bug>(
				grid, location, Bug.class, Constants.BUG_VISION_RANGE,
				Constants.BUG_VISION_RANGE).getNeighborhood(false);

        final List<GridCell<Bug>> freeCells = SMUtils
				.getFreeGridCells(bugNeighborhood);

        if (freeCells.isEmpty()) {
			return;
		}
        
        final List<GridCell<HabitatCell>> habitatCells = getHabitatCellsForLocations(freeCells);
        
        Collections.sort(habitatCells,
                        new HabitatCell.HabitatCellFoodAvailabilityComparator());

        // The first element has the most available food, it is the optimal
        // target for displacement
        final GridCell<HabitatCell> chosenFreeCell = habitatCells.get(0);

        // We have our new GridPoint to move to, so relocate agent
        final GridPoint newGridPoint = chosenFreeCell.getPoint();
        grid.moveTo(this, newGridPoint.getX(), newGridPoint.getY());
		
    	
	}
        
	
	/*
        // Get a random free location within sight range
		final GridCell<Bug> chosenFreeCell = SMUtils.randomElementOf(freeCells);

		        
		// Get the grid location of this Bug
		//final GridPoint location = getGrid().getLocation(this);
        final GridPoint newGridPoint = chosenFreeCell.getPoint();
		grid.moveTo(this, newGridPoint.getX(), newGridPoint.getY());
		
		
		// We have a utility function that returns the filtered list of empty
		// GridCells objects
		
		// Model specifies if there is no empty location in vision range, the
		// Bug agent cannot move
		

		SimUtilities.shuffle(freeCells, RandomHelper.getUniform());

	//cut
	}

	private List<GridCell<HabitatCell>> getHabitatCellsForLocations(
            final List<GridCell<Bug>> freeCells) {
    final ArrayList<GridCell<HabitatCell>> ret = new ArrayList<GridCell<HabitatCell>>();
    final Grid<Object> grid = getGrid();

    // Iterate over the specified location with no associated Bug agents
    for (final GridCell<Bug> gridCell : freeCells) {
            final GridPoint point = gridCell.getPoint();

            // Query the HabitatCell of that location
            final List<GridCell<HabitatCell>> cells = new GridCellNgh<HabitatCell>(
                            grid, point, HabitatCell.class, 0, 0).getNeighborhood(true);

            ret.add(cells.get(0));
    }

    return ret;
}



*/
	
	private List<GridCell<HabitatCell>> getHabitatCellsForLocations(
			final List<GridCell<Bug>> freeCells) {
		assert (freeCells.equals(SMUtils.getFreeGridCells(freeCells))) : String
				.format("Parametet freeCells=%s should contain only empty cells.",
						freeCells);

		final ArrayList<GridCell<HabitatCell>> ret = new ArrayList<GridCell<HabitatCell>>();
		final Grid<Object> grid = getGrid();

		// Iterate over the specified location with no associated Bug agents
		for (final GridCell<Bug> gridCell : freeCells) {
			final GridPoint point = gridCell.getPoint();

			// Query the HabitatCell of that location
			final List<GridCell<HabitatCell>> cells = new GridCellNgh<HabitatCell>(
					grid, point, HabitatCell.class, 0, 0).getNeighborhood(true);

			assert (1 == cells.size()) : "One cell should exist on a grid cell, but found: "
					+ cells;
			ret.add(cells.get(0));
		}

		return ret;
	}

	/**
	 * Each time step, a bug grows by a fixed amount, <code>1.0</code>, and this
	 * action is scheduled after the <code>move()</code> action.
	 * 
	 * @since Model 2
	 */
	@ScheduledMethod(start = 1, interval = 1, priority = -1)
	public void grow() {
		size += foodConsumption();
		
		if (size < 70){			//long term goal in these if statements
			size += foodConsumption();
		}	
		
		else if (size >= 71){
			size+= foodConsumption()/2;
		}	
		
		else {} 
			
		//if (size > 100.0) {
           //RunEnvironment.getInstance().endRun();
	}
	

	/**
	 * Bug growth is modified so growth equals food consumption.
	 * 
	 * <p>
	 * Food consumption is equal to the minimum of <i>(a)</i> the bug's maximum
	 * consumption rate (set to <code>1.0</code>) and <i>(b)</i> the bug's
	 * cell's food availability.
	 * </p>
	 * 
	 * <p>
	 * In previous models, a bug grew by a fixed amount of size in each time
	 * step.
	 * </p>
	 * 
	 * @return the actual eaten food value between the specified bounds;
	 *         <i>non-negative, lower or equal to
	 *         <code>maxConsumptionRate</code> and <code>foodAvailable</code>
	 *         </i>
	 * @since Model 3
	 */
	private double foodConsumption() {
		final HabitatCell cell = getUnderlyingCell();
		final double foodAvailable = cell.getFoodAvailability();

		final double eatenFood = Math.min(maxConsumptionRate, foodAvailable);
		cell.foodConsumed(eatenFood);

		assert (eatenFood >= 0) : String.format(
				"Derived value of eatenFood = %f hould be >=0.", eatenFood);
		assert (eatenFood <= maxConsumptionRate);
		assert (eatenFood <= foodAvailable);

		return eatenFood;
	}

	/**
	 * Returns the cell on which this agents is currently located at.
	 * 
	 * <p>
	 * Also, it contains minor assertions and ensures invariants for the model:
	 * there should be exactly one cell for each agent, no more and no less. If
	 * either constraint is broken, an <code>IllegalStateException</code> is
	 * thrown.
	 * </p>
	 * 
	 * @return the cell on which the agent is currently located at;
	 *         <code>non-null</code>
	 * @since Model 3
	 */
	private HabitatCell getUnderlyingCell() {
		final GridPoint location = getGrid().getLocation(this);
		final Iterable<Object> objects = getGrid().getObjectsAt(
				location.getX(), location.getY());

		HabitatCell ret = null;

		for (final Object object : objects) {
			if (object instanceof HabitatCell) {
				final HabitatCell cell = (HabitatCell) object;
				if (ret != null) {
					throw new IllegalStateException(
							String.format(
									"Multiple cells defined for the same position;cell 1=%s, cell 2=%s",
									ret, cell));
				}

				ret = cell;
			}
		}

		if (null == ret) {
			throw new IllegalStateException(String.format(
					"Cannot find any cells for location %s", location));
		}

		return ret;
	}
	
	 @Override
     public int compareTo(final Bug other) {
             return -Double.compare(size, other.size);
     }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// This may happen when testing
		final String location = (ContextUtils.getContext(this) != null) ? getGrid()
				.getLocation(this).toString() : "[?, ?]";

		// Override default Java implementation just to have a nicer
		// representation
		return String.format("Bug @ location %s, size=%f", location, size);
	}

}
	