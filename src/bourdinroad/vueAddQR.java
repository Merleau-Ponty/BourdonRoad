package bourdinroad;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class vueAddQR extends JPanel{
	JPanel addQR = new JPanel();
	JLabel intro = new JLabel();
	JLabel intro1 = new JLabel();
	JLabel labRepA = new JLabel("Réponse A: ");
	JLabel labRepB = new JLabel("Réponse B: ");
	JLabel labRepC = new JLabel("Réponse C: ");
	JLabel labRepD = new JLabel("Réponse D: ");
	JLabel sautLigne = new JLabel("   ");
	JTextField question = new JTextField(22);
	JTextField repA = new JTextField(22);
	JTextField repB = new JTextField(22);
	JTextField repC = new JTextField(22);
	JTextField repD = new JTextField(22);
	JButton save = new JButton("Enregistrer");
	JButton leaveAddQuizz = new JButton("Retour au Menu");
	
	GestionBD add = new GestionBD();
	
	public vueAddQR() {
	 	super();
	 	JPanel gestAddQR = new JPanel();
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Créer une Question et ses Réponses");
		gestAddQR.setBorder(borderCadre);
		addQR.add(gestAddQR);
		setLayout(new BorderLayout());
		add("Center",addQR);
		
		String explication = "Saisissez la question.";
		String explication1 = "Saisissez les 4 réponses.";
		intro.setText(explication);
		intro1.setText(explication1);
		
		gestAddQR.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
		
	    gbc.gridy=0;
	    gbc.gridx=0;
	    gestAddQR.add(sautLigne, gbc);

	    
	    gbc.gridy=1;
	    gbc.gridx=0;
	    gestAddQR.add(intro, gbc);
	    
	    gbc.gridy=1;
	    gbc.gridx=1;
	    gestAddQR.add(question, gbc);
	    
	    gbc.gridy=2;
	    gbc.gridx=0;
	    gestAddQR.add(sautLigne, gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx=0;
	    gestAddQR.add(intro1, gbc);
	    
	    gbc.gridy=4;
	    gbc.gridx=0;
	    gestAddQR.add(labRepA, gbc);
	    
	    gbc.gridy=4;
	    gbc.gridx=1;
	    gestAddQR.add(repA, gbc);
	    
	    gbc.gridy=5;
	    gbc.gridx=0;
	    gestAddQR.add(labRepB, gbc);
	    
	    gbc.gridy=5;
	    gbc.gridx=1;
	    gestAddQR.add(repB, gbc);
	    
	    gbc.gridy=6;
	    gbc.gridx=0;
	    gestAddQR.add(labRepC, gbc);
	    
	    gbc.gridy=6;
	    gbc.gridx=1;
	    gestAddQR.add(repC, gbc);
	    
	    gbc.gridy=7;
	    gbc.gridx=0;
	    gestAddQR.add(labRepD, gbc);
	    
	    gbc.gridy=7;
	    gbc.gridx=1;
	    gestAddQR.add(repD, gbc);
	    
	    gbc.gridy=8;
	    gbc.gridx=0;
	    gestAddQR.add(sautLigne, gbc);
	    
	    gbc.gridy=9;
	    gbc.gridx=0;
	    gestAddQR.add(save, gbc);
	    
	    gbc.gridy=9;
	    gbc.gridx=1;
	    gestAddQR.add(leaveAddQuizz, gbc);
	}
}
