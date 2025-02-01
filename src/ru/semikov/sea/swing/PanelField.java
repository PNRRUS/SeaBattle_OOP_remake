package ru.semikov.sea.swing;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

abstract public class PanelField extends JPanel implements ISubscriber {
	private static final long serialVersionUID = 1L;
	public GameModel model;

	public PanelField(GameModel model) {
		this.model = model;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);



			// ������ �������
		for(int i = 0; i < 11; i++) {
			g.drawLine(i*40, 0, i*40,400);
			g.drawLine(1,i*40, 400, i*40);
		}
		
		// ������ ��������
		for(int j = 0; j < 10; j++) {
			for(int i = 0; i < 10; i++) {
				paintElement(g, i, j);
			}
		}
		g.drawString("���� ������:  ", 20, 490);
		g.drawString("����� ������� ����������, �� ������� ����! ", 20, 610);
		g.drawString("�����, �������!", 20, 630);

	}

	/**
	 * ��������� ��������� ��������
	 */
	protected void paintElement(Graphics g, int i, int j) {
	}

	@Override
	public void update() {
		this.repaint();
	}
	
}
