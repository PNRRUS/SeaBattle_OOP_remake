package ru.semikov.sea.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import ru.semikov.sea.logic.*;

public class ScoreField extends JPanel implements ISubscriber {
	private static final long serialVersionUID = 1L;
	private GameModel model;
	private int ships;

	public ScoreField(GameModel model) {
		this.model = model;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int[] m = new int[4];
		for(int i = 0; i < 0; i++) {
			m[i] = 0;
		}
		
		ships = 0;
		for(Ship ship : model.playerFiledB.ships) {
			if (ship.state != ShipStates.enKilled) {
				m[ship.size-1] ++;
				ships++;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < (i+1); j++) {
				g.setColor(Color.gray);
				g.fillRect(j*40+10, i*40+5, 39, 39);
			}
			g.setColor(Color.black);
			g.drawString(String.valueOf(m[i]), 180, i*40+30);
		}

		String st = "Alive: ".concat(String.valueOf(ships));
		g.drawString(st, 145, 190);

	}

	@Override
	public void update() {
		this.repaint();
	}

}
