package rebellion;

import java.util.List;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.SimUtilities;

/**
 * @author grace
 * Cop class
 */
public class Cop {
	
	private int visNeighbors; // neighborhood visibility
	private Grid <Object> grid;
	private ContinuousSpace<Object> space;
	
	public Cop(Grid<Object> grid, ContinuousSpace<Object> space, 
			int visNeighbors) {
		this.grid = grid;
		this.space = space;
		this.visNeighbors = visNeighbors;
	}
	
	/*
	 * Step
	 */
	@ScheduledMethod(start = 1, interval = 1, priority = 0)
	public void step() {

		GridPoint location = grid.getLocation(this);
		
		// look for active people in the area
		List<GridCell<Person>> peopleNeighborhood = new GridCellNgh<Person>(
			grid, location, Person.class, visNeighbors,
			visNeighbors).getNeighborhood(false);

		// shuffle to pick random person
		SimUtilities.shuffle(peopleNeighborhood, RandomHelper.getUniform());
		
		// arrest an active person
		for (GridCell<Person> pcell : peopleNeighborhood) {
			Object obj = grid.getObjectAt(pcell.getPoint().getX(), pcell.getPoint().getY());
			if (obj instanceof Person) {
				Person p = (Person) obj;
				if (p.active == true) {
					//System.out.println("jailed");
					p.active = false;
					p.jailTerm = RandomHelper.nextIntFromTo(0, p.MAX_JAIL_TERM);
				}
			}
		}
		
		// pick an empty cell to move to
		List<GridCell<Person>> freeCells = SMUtils
			.getFreeGridCells(peopleNeighborhood);
		
		if (freeCells.isEmpty()) {
			return;
		}
		
		SimUtilities.shuffle(freeCells, RandomHelper.getUniform());
		GridCell<Person> chosenFreeCell = SMUtils.randomElementOf(freeCells);
		
		GridPoint newGridPoint = chosenFreeCell.getPoint();
		grid.moveTo(this, newGridPoint.getX(), newGridPoint.getY());
		
	}
	
	/*
	 * overrid for debugging purpose
	 */
	@Override
	public String toString() {
		String location = grid.getLocation(this).toString();
		return String.format("Cop @ location %s", location);
	}
}
