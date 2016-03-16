package rebellion.observer;

import java.awt.Color;

import rebellion.Cop;
import rebellion.Person;
import repast.simphony.visualizationOGL2D.DefaultStyleOGL2D;

/**
 * @author grace
 * Setup style (colors) for people and cops
 */

public class PersonStyleOLG2D extends DefaultStyleOGL2D {

	@Override
	public Color getColor(final Object agent) {
		if (agent instanceof Person) { // depends on person's behavior
			Person person = (Person) agent;
			return new Color(person.red, person.green, person.blue);
		} else if (agent instanceof Cop) { // blue
			return new Color(0x0, 0x0, 0xFF);
		}

		return super.getColor(agent);
	}
	
}
