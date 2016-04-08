package bourdinroad;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;

class vueInscription extends JPanel{
	JButton creerCompte=new JButton("Creer compte");
	JButton connexion=new JButton("Formulaire de connexion");
	JPanel mainCadre=new JPanel();
	JLabel[] champForm=new JLabel[9];
	JTextField[] textForm=new JTextField[7];
	JComboBox serv;
	String recap,email,messError[],caract_ind[];
	GestionBD insc = new GestionBD();
	
	public vueInscription(){
		super();
		JPanel inscription=new JPanel();
		//inscription.setLayout(new GridBagLayout());
		
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Inscription");
		inscription.setBorder(borderCadre);
		mainCadre.add(inscription, "CadreCo");
		setLayout(new BorderLayout());
		add("Center",mainCadre);
		
		
		//Creation du formulaire
		champForm[0]=new JLabel("Nom :");
		textForm[0] = new JTextField(14);
		
		champForm[1]=new JLabel("Prenom :");
		textForm[1] = new JTextField(14);
		
		champForm[2]=new JLabel("Mobile :");
		textForm[2] = new JTextField(14);
		
		/*Creation de la liste deroulante avec les donnée de la table LIBELLE_SERVICES*/
		champForm[7]=new JLabel("Service :");
		serv = new JComboBox(insc.service().toArray());
		// redimensionne la taille de la liste
		serv.setPreferredSize(new Dimension(160,25));
		
		champForm[3]=new JLabel("Email :");
		textForm[3] = new JTextField(14);
		
		champForm[4]=new JLabel("Identifiant :");
		textForm[4] = new JTextField(14);
		
		champForm[5]=new JLabel("Mot de passe :");
		textForm[5] = new JPasswordField(14);
		
		champForm[6]=new JLabel("Comfirmation mot de passe:");
		textForm[6] = new JPasswordField(14);
		
		champForm[8]=new JLabel(" ");
		
		/*Ajout de ce composant au container en spécifiant une contrainte de type GridBagConstraints. */
		inscription.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    /*Nom*/
	    gbc.gridy=0;
	    gbc.gridx=0;
	    inscription.add(champForm[0], gbc);
	    gbc.gridy=0;
	    gbc.gridx=1;
	    inscription.add(textForm[0], gbc);
	    
	    /*Prenom*/
	    gbc.gridy=1;
	    gbc.gridx=0;
	    inscription.add(champForm[1], gbc);
	    gbc.gridy=1;
	    gbc.gridx=1;
	    inscription.add(textForm[1], gbc);
	    
	    /*Mobile*/
	    gbc.gridy=2;
	    gbc.gridx=0;
	    inscription.add(champForm[2], gbc);
	    gbc.gridy=2;
	    gbc.gridx=1;
	    inscription.add(textForm[2], gbc);
	    
	    /*Service*/
	    gbc.gridy=3;
	    gbc.gridx=0;
	    inscription.add(champForm[7], gbc);
	    gbc.gridy=3;
	    gbc.gridx=1;
	    inscription.add(serv, gbc);
	    
	    /*Email*/
	    gbc.gridy=4;
	    gbc.gridx=0;
	    inscription.add(champForm[3], gbc);
	    gbc.gridy=4;
	    gbc.gridx=1;
	    inscription.add(textForm[3], gbc);
	    
	    /*Identifiant*/
	    gbc.gridy=5;
	    gbc.gridx=0;
	    inscription.add(champForm[4], gbc);
	    gbc.gridy=5;
	    gbc.gridx=1;
	    inscription.add(textForm[4], gbc);
	    
	    /*Mot de passe*/
	    gbc.gridy=6;
	    gbc.gridx=0;
	    inscription.add(champForm[5], gbc);
	    gbc.gridy=6;
	    gbc.gridx=1;
	    inscription.add(textForm[5], gbc);
	    
	    /*Mot de passe de confirmation*/
	    gbc.gridy=7;
	    gbc.gridx=0;
	    inscription.add(champForm[6], gbc);
	    gbc.gridy=7;
	    gbc.gridx=1;
	    inscription.add(textForm[6], gbc);
	    
	    /*Saut de ligne avant les boutons*/
	    gbc.gridy=8;
	    gbc.gridx=0;
	    inscription.add(champForm[8], gbc);
	    
	    /*Boutons*/
	    gbc.gridy=9;
	    gbc.gridx=0;
	    inscription.add(creerCompte, gbc);
	    gbc.gridy=9;
	    gbc.gridx=1;
	    inscription.add(connexion, gbc);
	    
	    
		/*g.add(inscription);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		GererBouton gest = new GererBouton();
		creerCompte.addActionListener(gest);
		
	}
	
	final class GererBouton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(verif()){
				try {
					insc.inscription(serv.getSelectedIndex(),textForm[0].getText().toString(),textForm[1].getText().toString(),textForm[2].getText().toString(),textForm[3].getText().toString(),textForm[4].getText().toString(),textForm[5].getText().toString());
					
					recap = "Nom: "+ textForm[0].getText() +"\n"
						+ "Prenom: "+ textForm[1].getText() +"\n"
						+ "Mobile: "+ textForm[2].getText() +"\n"
						+ "Service: "+ serv.getSelectedItem() +"\n"
						+ "Email: "+ textForm[3].getText() +"\n"
						+ "Identifiant: "+ textForm[4].getText() +"\n"
						+ "Mot de passe: "+ textForm[5].getText() +"\n";
				JOptionPane.showMessageDialog(null,recap);
			} catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null,"problème");
			}}
			
		}
	}
	public boolean verif() {
		boolean vide = false;
		/*caractère indesirables*/
		caract_ind= new String[]{"&","'","~","`","^","°","%","$","*","!",":","?",")"};
		
		
		/*Instanciation des variables erreurs*/
		messError= new String []{"Veuillez saisir votre nom","Veuillez saisir votre Prenom","Veuillez saisir un numero de telephone valide","Veuillez saisir votre adresse email","Veuillez saisir votre identifiant","Veuillez saisir votre mot de passe","Veuillez confirmez votre mot de passe"};
		
		
		int nb_champs_vide=0;
		
		for(int i=0;i<6;i++){
			if (textForm[i].getText().toString().length()==0){
				nb_champs_vide++;
			}
		}
		/*probleme pour acceder au de prenom et de nom */
		/*Verification de la saisie du prenom*/
		if(nb_champs_vide>1){
			JOptionPane.showMessageDialog(null, "Veuillez saisir toutes vos informations");
			textForm[0].requestFocus();
			vide = true;
		}else {
			/*Boucle de verification que tous les champs soit rempli sinon on indique son message erreur*/
			for (int i=0;i<7;i++){
				if(textForm[i].getText().toString().length()==0){
					JOptionPane.showMessageDialog(null, messError[i]);
					textForm[i].setText("");
					textForm[i].requestFocus();
					vide = true;
				}
			} 
			/*Verification de la saisie du mobile*/
			if(textForm[2].getText().length()<10 || textForm[2].getText().length()>=11 ){
				JOptionPane.showMessageDialog(null, "Mobile incorrect");
				textForm[2].setText("");
				textForm[2].requestFocus();
				vide = true;
			}else{
				/*Verification de l'email si il contient bien @ et .*/
				email = textForm[3].getText().toString();
				if(email.matches("(.*)@(.*)")!= true && email.matches("(.*).(.*)") != true){
					JOptionPane.showMessageDialog(null, "Adresse email incorrect : \n @ ou . manquant!");
					textForm[3].setText(email);
					textForm[3].requestFocus();
					vide = true;
				}else {
					/*Verification de l'email si il ne contient pas de caractere indesirables*/
				
						 Pattern rfc2822 = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
					        if (rfc2822.matcher(email).matches() != true) {
					        	JOptionPane.showMessageDialog(null, "Adresse email incorrect!");
								textForm[3].requestFocus();
								textForm[3].setText(email);
								vide = true;
					        }else{
					        	/*Verification que les mots de passe sont egaux*/
					        	if (textForm[5].getText().toString().matches(textForm[6].getText().toString()) != true){
					        		JOptionPane.showMessageDialog(null, "Mots de passe non identiques!");
									textForm[5].requestFocus();
									textForm[5].setText("");
									vide = true;
					        	}
					        }
				}
			}
			
		}
		/*Renvoie l'inverse de vide si vide = false renvoie true*/
		return !vide;		
	}
}