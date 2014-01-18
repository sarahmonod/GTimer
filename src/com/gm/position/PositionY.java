package com.gm.position;

/**
 * @author gugusse
 * Enum of the different possible Vertical positions of an element.
 * @see PositionX
 */
public enum PositionY {
	TOP,
	CENTER,
	BOTTOM;

	/**
	 * @return next element of the enum (if last calls then first returned)
	 */
	public PositionY getNext() {
		return ordinal() < PositionY.values().length - 1
				? PositionY.values()[ordinal() + 1]
				: PositionY.values()[0]; // back to the first one
	}

	/**
	 * @return previous element of the enum (if first calls then last returned)
	 */
	public PositionY getPrevious() {
		return ordinal() > 0
				? PositionY.values()[ordinal() - 1]
				// back to the last one
				: PositionY.values()[PositionY.values().length - 1];
	}
}
