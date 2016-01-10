package jeu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Case extends JButton {

	private int valeur = 0;
	int margin = 10;

	public Case() {
		setFocusable(false);
		setFont(new Font("clear sans", 1, 80));
		setBorder(BorderFactory.createLineBorder(new Color(187, 173, 160), margin));
		updateCouleur();
	}

	public void setValeur(int v) {
		this.valeur = v;
		if (valeur != 0)
			setText("" + valeur);
		else
			setText("");
		updateCouleur();
	}

	public int getValeur() {
		return valeur;
	}

	public void updateCouleur() {

		if (valeur < 16)
			setForeground(new Color(0x776e65));
		else
			setForeground(new Color(0xf9f6f2));

		switch (valeur) {
		case 0:
			setBackground(new Color(0xcdc1b4));
			break;
		case 2:
			setBackground(new Color(0xeee4da));
			break;
		case 4:
			setBackground(new Color(0xede0c8));
			break;
		case 8:
			setBackground(new Color(0xf2b179));
			break;
		case 16:
			setBackground(new Color(0xf59563));
			break;
		case 32:
			setBackground(new Color(0xf67c5f));
			break;
		case 64:
			setBackground(new Color(0xf65e3b));
			break;
		case 128:
			setBackground(new Color(0xedcf72));
			break;
		case 256:
			setBackground(new Color(0xedcc61));
			break;
		case 512:
			setBackground(new Color(0xedc850));
			break;
		case 1024:
			setBackground(new Color(0xedc53f));
			break;
		case 2048:
			setBackground(new Color(0xedc22e));
			break;
		}

	}

}
