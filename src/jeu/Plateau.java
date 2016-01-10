package jeu;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Plateau extends JPanel {

	private Random r = new Random();

	private Case[][] contenu = new Case[4][4];

	public boolean fini = false;

	public Plateau() {
		setLayout(new GridLayout(4, 4));
		setBorder(BorderFactory.createLineBorder(new Color(187, 173, 160), 10));

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				contenu[x][y] = new Case();
			}
		}

		int x1 = r.nextInt(4);
		int y1 = r.nextInt(4);

		int x2 = r.nextInt(4);
		while (x2 == x1) {
			x2 = r.nextInt(4);
		}
		int y2 = r.nextInt(4);
		while (y2 == y1) {
			y2 = r.nextInt(4);
		}

		contenu[x1][y1].setValeur(2);
		contenu[x2][y2].setValeur(2 + 2 * r.nextInt(2));

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				add(contenu[x][y]);
			}
		}
	}

	public Case getCase(int x, int y) {
		return contenu[x][y];
	}

	public boolean dansPlateau(int x, int y) {
		return (x >= 0 && x < 4 && y >= 0 && y < 4);
	}

	public boolean caseVide(int x, int y) {
		if (dansPlateau(x, y)) {
			return (contenu[x][y].getValeur() == 0);
		} else {
			return false;
		}
	}

	public boolean memeValeur(int x1, int y1, int x2, int y2) {
		return contenu[x1][y1].getValeur() == contenu[x2][y2].getValeur();
	}

	public int compteurCases() {
		int nombreCases = 0;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (getCase(x, y).getValeur() != 0) {
					nombreCases++;
					if (getCase(x, y).getValeur() == 2048) {
						System.out.println("Gagné !");
						fini = true;
						break;
					}
				}
			}
		}
		return nombreCases;
	}

	public void genererCase() {

		if (compteurCases() == 16) {
			System.out.println("Perdu");
			fini = true;
		} else {
			boolean ajoute = false;

			while (!ajoute) {
				int x = r.nextInt(4);
				int y = r.nextInt(4);
				if (getCase(x, y).getValeur() == 0) {
					contenu[x][y].setValeur(2);
					ajoute = true;
				}
			}
		}
	}
}
