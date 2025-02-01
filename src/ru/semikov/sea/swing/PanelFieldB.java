package ru.semikov.sea.swing;


import java.awt.Color;
import java.awt.Graphics;
import ru.semikov.sea.logic.*;

public class PanelFieldB extends PanelField {
	private static final long serialVersionUID = -1770790832677981438L;

	public PanelFieldB(GameModel model) {
		super(model);
	}

	private Color getColorByStateElement(ElementStates state) {
		switch (state) {
		case enBorder:
			return Color.blue;
		case enWater:
			return Color.blue;
		case enWell:
			return Color.blue;
		case enInjured:
			return Color.red;
		case enKilled:
			return Color.gray;
		case enMissed:
			return Color.darkGray;
		}
		
		return Color.blue;
		
	}
	
	@Override
	protected void paintElement(Graphics g, int i, int j) {
		ElementStates state = model.playerFiledB.GetElement(i, j);
		g.setColor(getColorByStateElement(state));
		
		if (state == ElementStates.enMissed) {
			g.setColor(Color.blue);
			g.fillRect(i*40+1, j*40+1, 39, 39);
			g.setColor(getColorByStateElement(state));
			g.fillRect(i*40+16, j*40+16, 8, 8);
		} else {
			g.fillRect(i*40+1, j*40+1, 39, 39);
		}
	}

}
