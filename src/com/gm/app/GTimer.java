package com.gm.app;

import com.gm.time.control.TimeCont;
import com.gm.time.control.TimeContFactory;
import com.gm.time.model.TimeModlFactory;
import com.gm.time.model.TimeModl;
import com.gm.time.view.TimeView;

/**
 * @author gugusse
 * Main gui class used to display the window.
 */
public class GTimer {

	/**
	 * Entry of the program.
	 * @param args
	 * 			Unused.
	 */
	public static void main(String[] args) {
		System.setProperty("com.apple.mrj.application.apple.menu.about.name"
				, "GTimer");
		TimeModl model   = TimeModlFactory.getSecondCounter();
		TimeCont control = TimeContFactory.getControl(model);
		TimeView view    = new TimeView(control);
		model.addObserver(view);
		view.setVisible(true);
	}
}
