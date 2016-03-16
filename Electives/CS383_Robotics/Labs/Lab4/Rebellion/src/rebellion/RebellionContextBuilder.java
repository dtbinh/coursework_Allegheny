package rebellion;

import repast.simphony.context.Context;
import repast.simphony.context.DefaultContext;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.space.grid.RandomGridAdder;

/**
 * @author grace
 * Creating context for people and cops
 */

public class RebellionContextBuilder extends DefaultContext<Object> implements 
	ContextBuilder<Object> {


	@Override
	public Context<Object> build(final Context<Object> context) {

		context.setId(Constants.CONTEXT_ID);
		
		// get environment variables from GUI
		Parameters p = RunEnvironment.getInstance().getParameters();
		int gridWidth = (Integer)p.getValue("gridWidth");
		int gridHeight = (Integer)p.getValue("gridHeight");
		double iniPeopleDensity = (Double)p.getValue("iniPeopleDensity");
		double iniCopsDensity = (Double)p.getValue("iniCopsDensity");
		int visNeighbors = (Integer)p.getValue("visNeighbors");
		double govLegitimacy = (Double)p.getValue("govLegitimacy");
		int maxJailTerm = (Integer)p.getValue("maxJailTerm");
		
		// create space
		final ContinuousSpace<Object> space = ContinuousSpaceFactoryFinder
				.createContinuousSpaceFactory(null)
				.createContinuousSpace(
						Constants.SPACE_ID,
						context,
						new RandomCartesianAdder<Object>(),
						new repast.simphony.space.continuous.WrapAroundBorders(),
						gridWidth, gridHeight);

		// create grid
		final Grid<Object> grid = GridFactoryFinder
				.createGridFactory(null)
				.createGrid(
						Constants.GRID_ID,
						context,
						new GridBuilderParameters<Object>(
							new repast.simphony.space.grid.WrapAroundBorders(),
							new RandomGridAdder<Object>(),
							false,
							gridWidth, gridHeight));

		// make sure density are not greater than 1
		if ((iniPeopleDensity + iniCopsDensity) > 1) {
			System.out.println("Error: ini people and cops density sum > 1. " +
					"Cutting both density by half.");
			iniPeopleDensity /= 2;
			iniCopsDensity /= 2;
			System.out.println("New iniPeopleDensity "+iniPeopleDensity+
					" new iniCopsDensity "+iniCopsDensity);
		}
		
		// number of people and cops
		int peopleCount = (int) (gridWidth * gridHeight * iniPeopleDensity);
		int copsCount = (int) (gridWidth * gridHeight * iniCopsDensity);
		
		if (Constants.DEBUG) {
			System.out.println("grid size "+ gridWidth*gridHeight);
			System.out.println("people count "+peopleCount+" cops count "+copsCount);
		}
		
		// create people
		for (int i = 0; i < peopleCount; ++i) {
			Person person = new Person(grid, space, visNeighbors, maxJailTerm, govLegitimacy);
			context.add(person);
		}

		// create cops
		for (int i = 0; i < copsCount; ++i) {
			Cop cop = new Cop(grid, space, visNeighbors);
			context.add(cop);
		}

		// add all to context
		for (Object obj : context) {
			GridPoint pt = grid.getLocation(obj);
			grid.moveTo(obj, pt.getX(), pt.getY());
			//System.out.println(obj.toString());
		}

		// add coverage counter to context
		context.add(new CoverageCounter());
		
		return context;
	}
}
