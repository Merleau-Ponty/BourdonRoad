package bourdinroad;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bourdinroad.vueAddQR.GererBouton;

public class vueQuizz extends JPanel{
	
	JLabel[] champForm = new JLabel[9];
	JLabel image=new JLabel();
	JLabel[] textForm=new JLabel[7];
	JCheckBox[] rep = new JCheckBox[4];
	JButton qSuivante=new JButton("Question Suivante");
	JButton terminer=new JButton("Valider le test");
	int pos=0,taille;
	//JLabel labSol = new JLabel("La Solution: ");
	JPanel mainCadre = new JPanel(); 
	GestionBD insc = new GestionBD();
	
	public vueQuizz() {
		super();
		JPanel quizz=new JPanel();
		
		
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Repondre a un Quizz : Utilisateur");
		quizz.setBorder(borderCadre);
		mainCadre.add(quizz, "CadreCo");
		setLayout(new BorderLayout());
		add("Center",mainCadre);
		
		champForm[1]=new JLabel("");
		textForm[1]=new JLabel("...");
		
		/*Reponse*/
		champForm[2]=new JLabel("A: ");
		textForm[2] = new JLabel("...");
		rep[0] = new JCheckBox();
		
		
		champForm[3]=new JLabel("B: ");
		textForm[3] = new JLabel("...");
		rep[1] = new JCheckBox();
		
		champForm[4]=new JLabel("C: ");
		textForm[4] = new JLabel("...");
		rep[2] = new JCheckBox();
		
		champForm[5]=new JLabel("D: ");
		textForm[5] = new JLabel("...");
		rep[3] = new JCheckBox();
		
		textForm[6]=new JLabel("...");
		
		champForm[8]=new JLabel(" ");
		
		/*Ajout de ce composant au container en spécifiant une contrainte de type GridBagConstraints. */
		quizz.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    GridBagConstraints gbc1 = new GridBagConstraints();
	    
	    //image.setIcon(new javax.swing.ImageIcon(getClass().getResource("Photo_Q131.jpg")));
	    gbc.gridy=1;
	    gbc.gridx=0;
	    quizz.add(image, gbc);
	    
	    //Espace
	    gbc.gridy=2;
	    gbc.gridx=0;
	    quizz.add(champForm[8], gbc);
	    
	    /*Question*/
	    gbc.gridy=3;
	    gbc.gridx=0;
	    quizz.add(textForm[1], gbc);
	    
	    //Espace
	    gbc.gridy=4;
	    gbc.gridx=0;
	    quizz.add(champForm[8], gbc);
	    
	    gbc1.gridy=5;
	    gbc1.gridx=0;
	    quizz.add(champForm[2], gbc1);
	    
	    gbc1.gridy=5;
	    gbc1.gridx=1;
	    quizz.add(textForm[2], gbc1);
	    
	    gbc1.gridy=5;
	    gbc1.gridx=2;
	    quizz.add(rep[0], gbc1);
	    
	    gbc1.gridy=5;
	    gbc1.gridx=3;
	    quizz.add(champForm[3], gbc1);
	    
	    gbc1.gridy=5;
	    gbc1.gridx=4;
	    quizz.add(textForm[3], gbc1);
	    
	    gbc1.gridy=5;
	    gbc1.gridx=5;
	    quizz.add(rep[1], gbc1);
	    
	    gbc1.gridy=6;
	    gbc1.gridx=0;
	    quizz.add(champForm[4], gbc1);
	    
	    gbc1.gridy=6;
	    gbc1.gridx=1;
	    quizz.add(textForm[4], gbc1);
	    
	    gbc1.gridy=6;
	    gbc1.gridx=2;
	    quizz.add(rep[2], gbc1);
	    
	    gbc1.gridy=6;
	    gbc1.gridx=3;
	    quizz.add(champForm[5], gbc1);
	    
	    gbc1.gridy=6;
	    gbc1.gridx=4;
	    quizz.add(textForm[5], gbc1);
	    
	    gbc1.gridy=6;
	    gbc1.gridx=5;
	    quizz.add(rep[3], gbc1);
	    
	    /*gbc.gridy=9;
	    gbc.gridx=0;
	    quizz.add(labSol, gbc);
	    
	    gbc.gridy=9;
	    gbc.gridx=1;
	    quizz.add(textForm[6], gbc);*/
	    
	    
	    gbc.gridy=10;
	    gbc.gridx=0;
	    quizz.add(champForm[8], gbc);
	    
	    /*Question suivante*/
	    gbc.gridy=11;
	    gbc.gridx=0;
	    quizz.add(qSuivante, gbc);
	    
	    /*Terminer*/
	    gbc.gridy=11;
	    gbc.gridx=1;
	    quizz.add(terminer, gbc);
	    
	    
	    
	    GererBouton gest = new GererBouton();
		qSuivante.addActionListener(gest);
		terminer.addActionListener(gest);

	}
	final class GererBouton implements ActionListener {
		// capture des ï¿½vï¿½nements liï¿½s aux boutons
	      public void actionPerformed( ActionEvent event ) {
	    	if(event.getSource()==qSuivante){
	    		System.out.println("Question suivante"); 
	    		ArrayList<String> list = insc.question();
	    		image.setIcon(new javax.swing.ImageIcon(getClass().getResource(list.get(0))));
	    		textForm[1].setText(list.get(1));
	    		textForm[2].setText(list.get(2));
	    		textForm[3].setText(list.get(3));
	    		textForm[4].setText(list.get(4));
	    		textForm[4].setText(list.get(5));
	    		 pos++;
   			  if(pos==taille){
   				  pos--;
   				  JOptionPane.showMessageDialog( null,"Quizz terminer, veuiller cliquer sur le bouton terminer!" );
   			  } 
   			/*Chargement de la question suivante*/
	    		
	    	}
	    	if(event.getSource()==terminer){
	    		/*Envoie du resultat dans la table tentatives et retour au menu de choix*/
	    	}
	      }
	}
}
