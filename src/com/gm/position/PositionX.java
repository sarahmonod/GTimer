package com.gm.position;

/**
 * @author gugusse
 * Enum of the different possible Horizontal positions of an element.
 * @see PositionY
 */
public enum PositionX {
	LEFT,
	CENTER,
	RIGHT;

	/**
	 * @return next element of the enum (if last calls then first returned)
	 */
	public PositionX getNext() {
		return ordinal() < PositionX.values().length - 1
				? PositionX.values()[ordinal() + 1]
				: PositionX.values()[0]; // back to the first one
	}

	/**
	 * @return previous element of the enum (if first calls then last returned)
	 */
	public PositionX getPrevious() {
		return ordinal() > 0
				? PositionX.values()[ordinal() - 1]
				// back to the last one
				: PositionX.values()[PositionX.values().length - 1];
	}
}