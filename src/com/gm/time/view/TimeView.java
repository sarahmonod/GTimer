package com.gm.time.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gm.position.PositionX;
import com.gm.position.PositionY;
import com.gm.time.control.TimeCont;
import com.gm.time.model.TimeModl;

/**
 * @author gugusse
 * Window containing the panel itself containing a JLabel.
 */
@SuppressWarnings("serial")
public class TimeView extends JFrame implements Observer {
	/**
	 * Vertical alignment of the window.
	 */
	private PositionY y = PositionY.TOP;

	/**
	 * Horizontal alignment of the window.
	 */
	private PositionX x = PositionX.RIGHT;

	/**
	 * Label displaying the time.
	 */
	private JLabel lblTime;

	/**
	 * Setting up the basic properties of the window.
	 * @param control
	 * 			The controller that does all of the model actions.
	 */
	public TimeView(final TimeCont control) {
//		control.setShowSec(false);
		control.count();

		setResizable(false);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setContentPane(new JPanel());

		getContentPane().setBackground(Color.BLACK);

		lblTime = new JLabel("00:00:00");
		lblTime.setFont(new Font("Courier", Font.BOLD, 40));
		lblTime.setForeground(Color.WHITE);
		lblTime.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(lblTime, BorderLayout.CENTER);

		this.pack();
		// positions the window in the top right corner
		setPosition(y, x);
//		setSize(lblTime.getWidth(), 40);

		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
		getContentPane().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) { }

			@Override
			public void keyPressed(KeyEvent e) { }

			/**
			 * Modifies the position of the window.
			 * @param e
			 * 			The key released.
			 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				/* For arrows */
				case KeyEvent.VK_UP:
					y = y.getPrevious();
					break;
				case KeyEvent.VK_RIGHT:
					x = x.getNext();
					break;
				case KeyEvent.VK_DOWN:
					y = y.getNext();
					break;
				case KeyEvent.VK_LEFT:
					x = x.getPrevious();
					break;
				/* End of arrows */
				case KeyEvent.VK_P:
					if (control.isPaused()) {
						control.count();
						getContentPane().setBackground(Color.BLACK);
						lblTime.setForeground(Color.WHITE);
					}
					else {
						control.pause();
						getContentPane().setBackground(Color.GRAY);
						lblTime.setForeground(Color.BLACK);
					}
					break;
				case KeyEvent.VK_S:
					control.setShowSec(!control.showsSec());
					break;
				}
				setPosition(y, x);
			}
		});
	}

	/**
	 * Simple way of setting common locations.
	 * @param pY
	 * 			Vertical alignment.
	 * @param pX
	 * 			Horizontal alignment.
	 * @see PositionY
	 * @see PositionX
	 */
	public void setPosition(PositionY pY, PositionX pX) {
		Dimension screenS = Toolkit.getDefaultToolkit().getScreenSize();
		int x = 0, y = 0;
		switch (pX) {
		case LEFT:
			x = 0;
			break;
		case CENTER:
			x = screenS.width / 2 - getWidth() / 2;
			break;
		case RIGHT:
			x = screenS.width - getWidth();
			break;
		}
		switch (pY) {
		case TOP:
			y = getHeight() / 2; // Because of the navbar hiding
			break;
		case CENTER:
			y = screenS.height / 2 - getHeight() / 2;
			break;
		case BOTTOM:
			y = screenS.height - getHeight();
			break;
		}
		setLocation(x, y);
	}

	/**
	 * @param obs
	 * 			The observable element that was updated.
	 * @param updated
	 * 			Unused.
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object updated) {
		TimeModl m = (TimeModl) obs;
		lblTime.setText(obs.toString());
		if (m.getMinutes() >= 30 && m.getMinutes() % 2 == 0)
			lblTime.setForeground(Color.RED);
		else
			lblTime.setForeground(Color.WHITE);
	}
}
