package com.gm.time.model;


/**
 * @author gugusse
 * Stores the time from which the Timer is constructed.
 * Refreshes every minute.
 */
public class MinuteCounter extends TimeModl {
	/**
	 * Sleeps for one minute and refreshes the time.
	 */
	@Override
	public void run() {
		super.retrieveState();
		while (true) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				super.saveState();
				break;
			}
			setChanged();
			notifyObservers();
		}
	}
}
