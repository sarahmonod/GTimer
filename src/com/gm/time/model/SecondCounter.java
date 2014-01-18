package com.gm.time.model;


/**
 * @author gugusse
 * Stores the time from which the Timer is constructed.
 * Refreshes every second.
 */
public class SecondCounter extends TimeModl {
	/**
	 * Sleeps for one second and refreshes the time.
	 */
	@Override
	public void run() {
		super.retrieveState();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				super.saveState();
				break;
			}
			setChanged();
			notifyObservers();
		}
	}
}
