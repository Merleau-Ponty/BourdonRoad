package bourdinroad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bourdinroad.vueInscription.GererBouton;

public class adminUtilisateurs extends JPanel{
	JButton modifUser=new JButton("Modifier l'utilisateurs");
	JButton leave = new JButton("Retour au menu");
	JComboBox users,serv;
	JCheckBox admin;
	JLabel[] champForm=new JLabel[11];
	JTextField[] textForm=new JTextField[7];
	JPanel mainCadre=new JPanel();
	GestionBD insc = new GestionBD();
	String recap,email,messError[],caract_ind[], nom, prenom, tab_nom[];
	int adm=0;
	
	 public adminUtilisateurs() {
		 	super();
			JPanel gestUsers=new JPanel();
			//inscription.setLayout(new GridBagLayout());
			
			//bordure
			Border borderCadre=BorderFactory.createTitledBorder("Modification Utilisateur : Admin");
			gestUsers.setBorder(borderCadre);
			mainCadre.add(gestUsers, "CadreCo");
			setLayout(new BorderLayout());
			add("Center",mainCadre);
			//Creation du formulaire
			
			
			champForm[0]=new JLabel("Nom :");
			textForm[0] = new JTextField(14);
			
			
			champForm[1]=new JLabel("Prenom :");
			textForm[1] = new JTextField(14);
			
			
			champForm[2]=new JLabel("Mobile :");
			textForm[2] = new JTextField(14);
			
			
			champForm[3]=new JLabel("Email :");
			textForm[3] = new JTextField(14);
			
			champForm[4]=new JLabel("Identifiant :");
			textForm[4] = new JTextField(14);
			
			champForm[5]=new JLabel("Mot de passe :");
			textForm[5] = new JPasswordField(14);
			
			champForm[6]=new JLabel("Comfirmation mot de passe:");
			textForm[6] = new JPasswordField(14);
			
			/*Creation de la liste deroulante avec les donn�e de la table LIBELLE_SERVICES*/
			champForm[7]=new JLabel("Service :");
			serv = new JComboBox(insc.service().toArray());
			// redimensionne la taille de la liste
			serv.setPreferredSize(new Dimension(160,25));
			
			champForm[8]=new JLabel(" ");
			
			/*Creation de la liste deroulante avec les donn�e de la table Utilisateurs*/
			champForm[9]=new JLabel("Utilisateurs :");
			users = new JComboBox(insc.utilisateurs().toArray());
			// redimensionne la taille de la liste
			users.setPreferredSize(new Dimension(160,25));
			
			champForm[10]=new JLabel("Administrateur");
			admin= new JCheckBox();
			
			/*Ajout de ce composant au container en sp�cifiant une contrainte de type GridBagConstraints. */
			gestUsers.setLayout(new GridBagLayout());
		    GridBagConstraints gbc = new GridBagConstraints();
		    
		    /*Liste des utilisateurs*/
		    gbc.gridy=0;
		    gbc.gridx=0;
		    gestUsers.add(champForm[9], gbc);
		    gbc.gridy=0;
		    gbc.gridx=1;
		    gestUsers.add(users, gbc);
		    
		    /*Nom*/
		    gbc.gridy=1;
		    gbc.gridx=0;
		    gestUsers.add(champForm[0], gbc);
		    gbc.gridy=1;
		    gbc.gridx=1;
		    gestUsers.add(textForm[0], gbc);
		    
		    /*Prenom*/
		    gbc.gridy=2;
		    gbc.gridx=0;
		    gestUsers.add(champForm[1], gbc);
		    gbc.gridy=2;
		    gbc.gridx=1;
		    gestUsers.add(textForm[1], gbc);
		    
		    /*Mobile*/ 
		    gbc.gridy=3;
		    gbc.gridx=0;
		    gestUsers.add(champForm[2], gbc);
		    gbc.gridy=3;
		    gbc.gridx=1;
		    gestUsers.add(textForm[2], gbc);
		    
		    /*Service*/ 
		    gbc.gridy=4;
		    gbc.gridx=0;
		    gestUsers.add(champForm[7], gbc);
		    gbc.gridy=4;
		    gbc.gridx=1;
		    gestUsers.add(serv, gbc);
		    
		    /*Email*/ 
		    gbc.gridy=5;
		    gbc.gridx=0;
		    gestUsers.add(champForm[3], gbc);
		    gbc.gridy=5;
		    gbc.gridx=1;
		    gestUsers.add(textForm[3], gbc);
		    
		    /*Identifiant*/ 
		    gbc.gridy=6;
		    gbc.gridx=0;
		    gestUsers.add(champForm[4], gbc);
		    gbc.gridy=6;
		    gbc.gridx=1;
		    gestUsers.add(textForm[4], gbc);
		    
		    /*Mot de passe*/ 
		    gbc.gridy=7;
		    gbc.gridx=0;
		    gestUsers.add(champForm[5], gbc);
		    gbc.gridy=7;
		    gbc.gridx=1;
		    gestUsers.add(textForm[5], gbc);

		    /*Mot de passe de confirmation*/
		    gbc.gridy=8;
		    gbc.gridx=0;
		    gestUsers.add(champForm[6], gbc);
		    gbc.gridy=8;
		    gbc.gridx=1;
		    gestUsers.add(textForm[6], gbc);

		    /*Administrateur*/
		    gbc.gridy=9;
		    gbc.gridx=0;
		    gestUsers.add(champForm[10], gbc);
		    gbc.gridy=9;
		    gbc.gridx=1;
		    gestUsers.add(admin, gbc);
		    
		    /*Saut de ligne avant les boutons*/
		    gbc.gridy=10;
		    gbc.gridx=0;
		    gestUsers.add(champForm[8], gbc);
		    
		    /*Boutons*/
		    gbc.gridy=11;
		    gbc.gridx=0;
		    gestUsers.add(modifUser, gbc);
		    
		    /*Boutons*/
		    gbc.gridy=11;
		    gbc.gridx=1;
		    gestUsers.add(leave, gbc);
		    
		    GererBouton gest = new GererBouton();
			modifUser.addActionListener(gest);
			users.addMouseListener(gest);
	 }
	 
	 final class GererBouton implements ActionListener, MouseListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				if(admin.isSelected()){
				  	adm=1;
				  }
				/*if(verif()){
					try {
						insc.modification(serv.getSelectedIndex(),textForm[0].getText().toString(),textForm[1].getText().toString(),textForm[2].getText().toString(),textForm[3].getText().toString(),textForm[4].getText().toString(),textForm[5].getText().toString());
						
						recap = "Utilisateur modifier avec succes";
						JOptionPane.showMessageDialog(null,recap);
					} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"probl�me");
					}
				}*/
			}
			/*permet de remplir automatiquement les champs en fonction de l'utilisateur choisie dans la liste deroulante*/
			 @Override
				public void mouseExited(MouseEvent event) {
				// TODO Auto-generated method stub
					if(event.getSource()== users){
						System.out.println("On rentre bien dans le mouse clicked");
						int indice = users.getSelectedIndex();
						nom = users.getSelectedItem().toString();
						
						String[] parts = nom.split(" ");
						String lastWord = parts[parts.length-1];
						String firstWord = parts[parts.length-2];
						System.out.println(lastWord);
					
						ArrayList<String> list = insc.getInfoUser(firstWord,lastWord);
						
						/*On remplie les champs du formulaire*/
						textForm[0].setText(list.get(1));  /*Nom*/
						textForm[1].setText(list.get(2));   /*Prenom*/ 
						textForm[2].setText(list.get(3));   /*Mobile*/ 
						/*Le service*/
						String service = list.get(0);
						serv.setSelectedItem(service);
						textForm[3].setText(list.get(4));   /*email*/ 
						textForm[4].setText(list.get(5));   /*Identifiant*/ 
						textForm[5].setText(list.get(6));   /*mdp*/ 
						textForm[6].setText(list.get(6));   /*mdp confirmation*/ 
						/*Admin*/
						if(list.get(7).toString()=="1"){
							admin.setSelected(true);
						}
					}
				}
			@Override
			public void mouseClicked(MouseEvent event) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	}
	 
	 public boolean verif() {
			boolean vide = false;
			/*caract�re indesirables*/
			caract_ind= new String[]{"&","'","~","`","^","�","%","$","*","!",":","?",")"};
			
			
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
						textForm[i].requestFocus();
						vide = true;
					}
				} 
				/*Verification de la saisie du mobile*/
				if(textForm[2].getText().length()<10 || textForm[2].getText().length()>=11 ){
					JOptionPane.showMessageDialog(null, "Mobile incorrect");
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