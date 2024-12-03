package ru.semikov.sea.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Контроллер главного окна
 */
public class GameController implements ActionListener {
	public GameModel model;
	public GameView view;

	public GameController(GameView view, GameModel model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * обработчик выбора меню
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// *** команда: новая игра
		if (cmd == "New game") { 	
				model.newGame();
		}
		// **** Команда: About
		if (cmd == "About") {
			System.out.println("About");
//			Dialog dia = new Dialog(view, "test");
//			dia.setVisible(true);
//			dia.addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyPressed(KeyEvent arg0) {
//					super.keyPressed(arg0);
//					if (arg0.getKeyCode() == 27) {
//						dia.setVisible(false);
//					}
//				}
//			})
		}
		// *** команда: выход из игры
		if (cmd == "Exit") {	
			System.exit(0);
		}
	}

	/**
	 * обработчик клика мышки
	 * @param arg0
	 */
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX() / 15;
		int y = arg0.getY() / 15;
		model.doShotByOpponent(x, y);
	}

}
