package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import model.IBoard;
import view.GizmoBallView;

/**
 * Gizmoball - RunListener
 * Created by Group WJ2 on 14/02/2016.
 * Authors: J Baird, C Bean, N Stannage, U Akhtar, L Sakalauskas
 */
public class RunListener implements ActionListener {

	private Timer timer;
	private IBoard board;
	private GizmoBallView gbv;


	public RunListener(IBoard bm, GizmoBallView gbv) {
		this.board = bm;
		timer = new Timer(5, this);
		this.gbv = gbv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {

			board.tick();
		} else {
			switch (e.getActionCommand()) {
			case "Start":
				timer.start();
				break;
			case "Stop":
				timer.stop();
				break;
			case "Tick":
				board.tick();
				break;
			case "Exit":
				System.exit(0);
				break;
			case "Build Mode":
				gbv.switchMode();
				board.startHighlighting();
				timer.stop();
				break;
			}
		}
	}
}
