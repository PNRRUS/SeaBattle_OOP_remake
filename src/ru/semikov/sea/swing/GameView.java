package ru.semikov.sea.swing;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GameView extends JFrame {
	private static final long serialVersionUID = 1L;

	private GameModel model;
	private GameController controller;
	
	private JMenuItem mntmNewGame;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private PanelFieldA panelPlayerA;
	private PanelFieldB panelPlayerB;
	private ScoreField panelScore;
	
	/**
	 * Создание представления главной формы
	 * @param model - модель главной формы
	 */
	public GameView(GameModel model) {
		this.model = model;
		buildUI();
		this.model.register(panelPlayerA);
		this.model.register(panelPlayerB);
		this.model.register(panelScore);
		this.controller=new GameController(this, model);
		attachController();
	}

	/**
	 * обновляем данные на форме
	 */
	public void update() {
		panelPlayerA.repaint();
		panelPlayerB.repaint();
		panelScore.repaint();
		System.out.println("view update");
	}

	/**
	 * добавление слушателей формы и направляем их на контроллер 
	 */
	public void attachController() {
		mntmAbout.addActionListener(controller);
		mntmNewGame.addActionListener(controller);
		mntmExit.addActionListener(controller);
		panelPlayerB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				controller.mousePressed(arg0);
			}
		});
	}

	/**
	 * построение интерфейса пользователя
	 */
	private void buildUI() {
		this.setTitle("SeaBattle");
		this.setResizable(false);
		this.setBounds(0, 0, 1500, 999);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);



		panelPlayerA = new PanelFieldA(model);
		panelPlayerA.setBounds(0, 31, 400, 400);
		this.getContentPane().add(panelPlayerA);
		
		panelPlayerB = new PanelFieldB(model);
		panelPlayerB.setBounds(500, 31, 400, 400);
		this.getContentPane().add(panelPlayerB);
		
		panelScore = new ScoreField(model);
		
		panelScore.setBounds(1000, 31, 200, 200);
		panelScore.setBackground(new Color(225, 225, 255));
		this.getContentPane().add(panelScore);

		Icon imageIcon = new ImageIcon("C:/Hemul_JAVA/SeaBattle_remake/src/ru/semikov/sea/swing/Radar.gif");
		JLabel label = new JLabel(imageIcon);this.getContentPane().add(label);
		label.setBounds(650, 450, 200, 200);
		label.setLocation(650,450);
		label.repaint();

		Icon imageIcon1 = new ImageIcon("C:/Hemul_JAVA/SeaBattle_remake/src/ru/semikov/sea/swing/256.jpg");
		JLabel label1 = new JLabel(imageIcon1);this.getContentPane().add(label1);
		label1.setBounds(750, 450, 1500, 999);
		label1.setLocation(0,0);
		label.repaint();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 90, 31);
		this.getContentPane().add(menuBar);
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		mntmNewGame = new JMenuItem("New game");
		mnGame.add(mntmNewGame);
		
		JMenuItem mntmProperties = new JMenuItem("Properties");
		mnGame.add(mntmProperties);

		mntmExit = new JMenuItem("Exit");
		mnGame.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);



	}


}
