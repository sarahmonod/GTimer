package com.gm.time.model;

import java.util.Observable;

/**
 * @author gugusse
 * Abstract model containing the main computing of the program.
 */
public abstract class TimeModl extends Observable implements Runnable {
	/**
	 * Saves the time at which the TimeCounter starts counting.
	 */
	private long beginning;

	/**
	 * States whether the model has been saved.
	 */
	private boolean isPaused = false;

	/**
	 * States whether the model should display seconds in toString.
	 */
	private boolean showSec = true;

	/**
	 * Thread counting how long it was instanciated.
	 */
	private Thread t;

	/**
	 * @return Whether the model should display seconds in toString.
	 */
	public boolean showsSec() {
		return showSec;
	}

	/**
	 * Set the showsSec() to a value.
	 * @param showSec
	 * 			States whether the model should display seconds in toString.
	 */
	public void setShowSec(boolean showSec) {
		this.showSec = showSec;
	}

	/**
	 * Starts counting for how long it was instanciated.
	 */
	public void count() {
		t = new Thread(this);
		t.start();
	}

	/**
	 * @return Number of milliseconds since the TimeCounter is constructed.
	 */
	public long getMillis() {
		return System.currentTimeMillis() - beginning;
	}

	/**
	 * @return Number of seconds since the TimeCounter is constructed.
	 */
	public int getSeconds() {
		return (int)getMillis() / 1000;
	}

	/**
	 * @return Number of minutes since the TimeCounter is constructed.
	 */
	public int getMinutes() {
		return getSeconds() / 60;
	}

	/**
	 * @return Number of hours since the TimeCounter is constructed.
	 */
	public int getHours() {
		return getMinutes() / 60;
	}

	/**
	 * Stops the counting to continue later.
	 */
	public void pause() {
		t.interrupt();
	}

	/**
	 * @return TODO
	 */
	public boolean isPaused() {
		return isPaused;
	}

	/**
	 * Creates a String describing the current state of the object.
	 * @return The formatted content.
	 * @see com.gm.time.TimeModel#getString()
	 */
	@Override
	public String toString() {
		return new String(String.format("%02d", getHours()   % 24) + ":"
						+ String.format("%02d", getMinutes() % 60)
		+ (showSec ? ":"+ String.format("%02d", getSeconds() % 60) : ""));
	}

	/**
	 * Saves for how long the timer was used before the pause.
	 */
	protected void saveState() {
		if (!isPaused()) {
			isPaused = true;
			beginning = -getMillis();
		}
	}

	/**
	 * Gets back for how long the timer was used before the pause.
	 */
	protected void retrieveState() {
		if (isPaused()) {
			beginning += System.currentTimeMillis();
			isPaused = false;
		}
		else
			beginning =  System.currentTimeMillis();
	}

	/**
	 * Method that refreshes the state of the object every part of time.
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public abstract void run();
}
