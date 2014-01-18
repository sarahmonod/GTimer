package com.gm.time.control;

import com.gm.time.model.TimeModl;

/**
 * @author gugusse
 * Instanciates the correct controler.
 */
public class TimeContFactory {
	/**
	 * @return The regular controler.
	 */
	public static TimeCont getControl(TimeModl m) {
		return new WindowControl(m);
	}
}
