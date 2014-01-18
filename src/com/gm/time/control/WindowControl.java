package com.gm.time.control;

import com.gm.time.model.TimeModl;

/**
 * @author gugusse
 * The controler part: useless here, determines how to control.
 */
public class WindowControl extends TimeCont {
	/**
	 * Constructor.
	 * @param m
	 * 			Allows delegation towards the model, if the test is valid.
	 */
	public WindowControl(TimeModl model) {
		super(model);
	}

	/**
	 * The control method.
	 * @see TimeCont
	 */
	@Override
	public boolean isOk() {
		return true;
	}
}
