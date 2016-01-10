package exec;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import jeu.Plateau;

@SuppressWarnings("serial")
public class Jeu extends JFrame {

	private Plateau p = new Plateau();

	private boolean actionEnCours = false;

	public Jeu() {

		setPreferredSize(new Dimension(800, 800));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ajouterListeners();

		add(p);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void ajouterListeners() {

		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ESCAPE) {
					System.exit(1);
				}

				if (!actionEnCours && !p.fini) {
					if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
						droite();
					}

					if (key == KeyEvent.VK_Q || key == KeyEvent.VK_LEFT) {
						gauche();
					}

					if (key == KeyEvent.VK_Z || key == KeyEvent.VK_UP) {
						haut();
					}

					if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
						bas();
					}
				}
			}

		});
	}

	public void droite() {
		actionEnCours = true;

		for (int y = 0; y < 4; y++) {
			for (int x = 3; x >= 0; x--) {
				if (p.getCase(x, y).getValeur() != 0) {
					if (p.dansPlateau(x + 1, y)) {
						if (p.caseVide(x + 1, y)) {
							p.getCase(x + 1, y).setValeur(p.getCase(x, y).getValeur());
							p.getCase(x, y).setValeur(0);
							x += 2;
						} else if (p.memeValeur(x, y, x + 1, y)) {
							p.getCase(x + 1, y).setValeur(p.getCase(x, y).getValeur() * 2);
							p.getCase(x, y).setValeur(0);
						}
					}
				}
			}
		}

		p.genererCase();
		actionEnCours = false;
	}

	public void gauche() {
		actionEnCours = true;

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (p.getCase(x, y).getValeur() != 0) {
					if (p.dansPlateau(x - 1, y)) {
						if (p.caseVide(x - 1, y)) {
							p.getCase(x - 1, y).setValeur(p.getCase(x, y).getValeur());
							p.getCase(x, y).setValeur(0);
							x -= 2;
						} else if (p.memeValeur(x, y, x - 1, y)) {
							p.getCase(x - 1, y).setValeur(p.getCase(x, y).getValeur() * 2);
							p.getCase(x, y).setValeur(0);
						}
					}
				}
			}
		}

		p.genererCase();
		actionEnCours = false;
	}

	public void haut() {
		actionEnCours = true;

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (p.getCase(x, y).getValeur() != 0) {
					if (p.dansPlateau(x, y - 1)) {
						if (p.caseVide(x, y - 1)) {
							p.getCase(x, y - 1).setValeur(p.getCase(x, y).getValeur());
							p.getCase(x, y).setValeur(0);
							y -= 2;
						} else if (p.memeValeur(x, y, x, y - 1)) {
							p.getCase(x, y - 1).setValeur(p.getCase(x, y).getValeur() * 2);
							p.getCase(x, y).setValeur(0);
						}
					}
				}
			}
		}

		p.genererCase();
		actionEnCours = false;
	}

	public void bas() {
		actionEnCours = true;

		for (int x = 3; x >= 0; x--) {
			for (int y = 3; y >= 0; y--) {
				if (p.getCase(x, y).getValeur() != 0) {
					if (p.dansPlateau(x, y + 1)) {
						if (p.caseVide(x, y + 1)) {
							p.getCase(x, y + 1).setValeur(p.getCase(x, y).getValeur());
							p.getCase(x, y).setValeur(0);
							y += 2;
						} else if (p.memeValeur(x, y, x, y + 1)) {
							p.getCase(x, y + 1).setValeur(p.getCase(x, y).getValeur() * 2);
							p.getCase(x, y).setValeur(0);
						}
					}
				}
			}
		}

		p.genererCase();
		actionEnCours = false;
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Jeu();
			}
		});
	}

}
