package bourdinroad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bourdinroad.adminUtilisateurs.GererBouton;

public class vueRepQuizz extends JPanel{
	
	JLabel[] champForm = new JLabel[9];
	JTextField[] textForm=new JTextField[7];
	JCheckBox[] rep = new JCheckBox[4];
	JComboBox quizz;
	JButton goQuizz=new JButton("Acceder au Quizz");
	JPanel mainCadre = new JPanel(); 
	GestionBD insc = new GestionBD();
	vueConnexion co = new vueConnexion();
	
	
	public vueRepQuizz() {

		 	super();
			JPanel repQuizz=new JPanel();
			//inscription.setLayout(new GridBagLayout());
			
			//bordure
			Border borderCadre=BorderFactory.createTitledBorder("Repondre a un Quizz : Utilisateur");
			repQuizz.setBorder(borderCadre);
			mainCadre.add(repQuizz, "CadreCo");
			setLayout(new BorderLayout());
			add("Center",mainCadre);
			
			
			//Creation du formulaire
			
			/*Creation de la liste deroulante avec les donnée de la table QUIZZ*/
			champForm[0]=new JLabel("Quizz :");
			quizz = new JComboBox(insc.getQuizz().toArray());
			// redimensionne la taille de la liste
			quizz.setPreferredSize(new Dimension(160,25));
			
			
			
			champForm[8]=new JLabel(" ");
			
			
			
			
			/*Ajout de ce composant au container en spécifiant une contrainte de type GridBagConstraints. */
			repQuizz.setLayout(new GridBagLayout());
		    GridBagConstraints gbc = new GridBagConstraints();
		    
		    //Creation du formulaire
		    /*Liste des Quizz*/
		    gbc.gridy=0;
		    gbc.gridx=0;
		    repQuizz.add(champForm[0], gbc);
		    gbc.gridy=0;
		    gbc.gridx=1;
		    repQuizz.add(quizz, gbc);
		    
		    /*Saut de ligne*/
		    gbc.gridy=1;
		    gbc.gridx=0;
		    repQuizz.add(champForm[8], gbc);
		    
		    /*Bouton pour aller au quizz*/
		    gbc.gridy=2;
		    gbc.gridx=0;
		    repQuizz.add(goQuizz, gbc);
		    
		    GererBouton gest = new GererBouton();
		    goQuizz.addActionListener(gest);
	}
	
	 final class GererBouton implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				 if(event.getSource()==goQuizz){
					 /*recuperation de l'id du quizz pour recuperer les question asocier*/
					String nomQuizz =  (String) quizz.getSelectedItem();
					System.out.println("login: "+ co.login.getText());
					//int id = insc.getIdConnect(p1.login.getText().toString(), p1.mdp.getText().toString());
					//System.out.println(id);
					//insc.ajoutTentative(nomQuizz, id);
				 }
			}
		}
}
