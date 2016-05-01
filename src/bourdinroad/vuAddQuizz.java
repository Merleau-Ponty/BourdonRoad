package bourdinroad;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bourdinroad.adminUtilisateurs.GererBouton;

public class vuAddQuizz extends JPanel {
	JPanel addQuizz = new JPanel();
	JLabel intro = new JLabel();
	JLabel intro1 = new JLabel();
	JLabel intro2 = new JLabel();
	JLabel labNomQuizz = new JLabel("Nom du Quizz :");
	JTextField nomQuizz = new JTextField(15);
	JButton save = new JButton("Enregistrer");
	JButton leaveAddQuizz = new JButton("Retour au Menu");
	
	GestionBD add = new GestionBD();
	
	public vuAddQuizz() {
	 	super();
	 	JPanel gestAddQuizz =new JPanel();
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Ajouter un Quizz");
		gestAddQuizz.setBorder(borderCadre);
		addQuizz.add(gestAddQuizz);
		setLayout(new BorderLayout());
		add("Center",addQuizz);
		
		String explication = "Saisissez le nom d'un nouveau quizz.";
		String explication1 = "Retournez au menu pour créer des questions";
		String explication2 = "et les ajouter au quizz.";
		intro.setText(explication);
		intro1.setText(explication1);
		intro2.setText(explication2);
		//gestAddQuizz.add(intro);
		
		gestAddQuizz.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    GridBagConstraints gbc1 = new GridBagConstraints();
		
	    gbc.gridy=0;
	    gbc.gridx=0;
	    gestAddQuizz.add(intro, gbc);
	    
	    gbc.gridy=1;
	    gbc.gridx=0;
	    gestAddQuizz.add(intro1, gbc);
	    
	    gbc.gridy=1;
	    gbc.gridx=1;
	    gestAddQuizz.add(intro2, gbc);
	    
	    gbc1.gridy=2;
	    gbc1.gridx=0;
	    gestAddQuizz.add(labNomQuizz, gbc1);
	    
	    gbc1.gridy=2;
	    gbc1.gridx=1;
	    gestAddQuizz.add(nomQuizz, gbc1);
	    
	    gbc1.gridy=3;
	    gbc1.gridx=0;
	    gestAddQuizz.add(save, gbc1);
	    
	    gbc1.gridy=4;
	    gbc1.gridx=0;
	    gestAddQuizz.add(leaveAddQuizz, gbc1);
	    
	    GererBouton gest = new GererBouton();
		save.addActionListener(gest);
	}
	
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()==save){
	    		  add.AddQuizz(nomQuizz.getText().toString());
	    	  }
	      }
	}
	
}
