package com.gm.time.model;

/**
 * @author gugusse
 * Instanciates the correct model.
 */
public class TimeModlFactory {
	/**
	 * @return The MinuteCounter model.
	 */
	public static TimeModl getMinuteCounter() {
		return new MinuteCounter();
	}

	/**
	 * @return The SecondCounter model.
	 */
	public static TimeModl getSecondCounter() {
		return new SecondCounter();
	}
}
