package IHM.MenuAPropos;

import Config.Variables;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TexteAPropos extends JTextPane {

    public TexteAPropos() {
        super();
        this.setText("Jeu réalisé dans le cadre du projet tutoré de DUT Informatique à l'IUT Nancy-Charlemagne.\n\nAuteur du sujet : Stephane Goria\n\nConcepteurs / Développeurs :"
                + "\n\tNicolas Lamblin\n\tGuillaume Launay\n\tValentin Nourdin\n\tAlexandre Pereira");
        this.setFont(Variables.POLICE);
        this.setEditable(false);
        this.setBackground(Variables.COULEUR_FOND);
        this.setForeground(Variables.COULEUR_BOUTONS);
        StyledDocument doc = this.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

    }
}