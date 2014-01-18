package com.gm.time.control;

import com.gm.time.model.TimeModl;

/**
 * @author gugusse
 * Abstract controler: makes sure the TimeModl is doing everything correctly.
 */
public abstract class TimeCont {
	/**
	 * Delegation of the model so the model only acts when valid.
	 */
	private TimeModl model;

	/**
	 * Parameter of one of the TimeModl method.
	 */
	protected boolean showSec;

	/**
	 * Constructs the object.
	 * @param model
	 * 			Used to delegate.
	 */
	public TimeCont(TimeModl model) {
		this.model = model;
	}

	/**
	 * @return Whether the model should display seconds in toString.
	 */
	public boolean showsSec() {
		return model.showsSec();
	}

	/**
	 * TODO
	 */
	public void count() {
		if (isOk())
			model.count();
	}

	/**
	 * TODO
	 */
	public void pause() {
		if (isOk())
			model.pause();
	}

	/**
	 * @return TODO
	 */
	public boolean isPaused() {
		return model.isPaused();
	}

	/**
	 * Set the showsSec() to a value.
	 * @param showSec
	 * 			States whether the model should display seconds in toString.
	 */
	public void setShowSec(boolean showSec) {
		this.showSec = showSec;
		if(isOk())
			model.setShowSec(showSec);
	}

	/**
	 * Controls all arguments before every method.
	 */
	public abstract boolean isOk();
}
