/*
 * Version info:
 *     $HeadURL: https://cscs-repast-demos.googlecode.com/svn/richard/StupidModel/tags/2011_05_29_model_05/src/stupidmodel/observer/FoodValueLayerStyleOGL.java $
 *     $LastChangedDate: 2011-07-15 11:28:54 +0200 (P, 15 júl. 2011) $
 *     $LastChangedRevision: 700 $
 *     $LastChangedBy: richard.legendi@gmail.com $
 */
package stupidmodel.observer;

import java.awt.Color;

import repast.simphony.valueLayer.ValueLayer;
import repast.simphony.visualizationOGL2D.ValueLayerStyleOGL;
import stupidmodel.agents.HabitatCell;

/**
 * A simple custom color implementation for {@link HabitatCell} food production
 * values.
 * 
 * <p>
 * A cell's color on the display is shaded to reflect the food available on
 * them: it shades from black (when available food is zero) to green (when food
 * is <code>1</code> or greater).
 * </p>
 * 
 * @author rlegendi
 * @author Richard O. Legendi (richard.legendi)
 * @since 2.0-beta, 2011
 * @since Model 3
 * @version $Id: FoodValueLayerStyleOGL.java 183 2011-05-29 17:09:27Z
 *          richard.legendi@gmail.com $
 */
public class FoodValueLayerStyleOGL implements ValueLayerStyleOGL {

	/** The <code>ValueLayer</code> object to reflect its values. */
	protected ValueLayer layer = null; // Protected to access from the same
										// package for testing

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * We keep a reference for the specified <code>ValueLayer</code> instance.
	 * </p>
	 * 
	 * @param layer
	 *            {@inheritDoc}; <i>cannot be <code>null</code></i>
	 * @see repast.simphony.visualizationOGL2D.ValueLayerStyleOGL#init(repast.simphony.valueLayer.ValueLayer)
	 */
	@Override
	public void init(final ValueLayer layer) {
		if (null == layer) {
			throw new IllegalArgumentException(
					"Parameter layer cannot be null.");
		}

		if (this.layer != null) {
			throw new IllegalStateException(
					String.format("Food value layer should not be reinitialized with a new ValueLayer instance."));
		}

		this.layer = layer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Returns the default value (<code>15.0f</code>) that is used by the
	 * wizards when a new display is created.
	 * </p>
	 * 
	 * @see repast.simphony.visualizationOGL2D.ValueLayerStyleOGL#getCellSize()
	 */
	@Override
	public float getCellSize() {
		return 15.0f;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Returns a modified color value for a cell. Bit tricky, though, contains a
	 * minor hex-magic to determine the actual color value.
	 * </p>
	 * 
	 * @see repast.simphony.visualizationOGL2D.ValueLayerStyleOGL#getColor(double[])
	 */
	@Override
	public Color getColor(final double... coordinates) {
		final double food = layer.get(coordinates);

		if (food < 0) {
			throw new IllegalStateException(
					String.format(
							"A cell's food availability property should be non-negative, but its current value is %f.",
							food));
		}

		final int strength = (int) Math.min(200 * food, 255);
		return new Color(0, strength, 0); // 0x000000 - black,
											// 0x00FF00 - green
	}
}
