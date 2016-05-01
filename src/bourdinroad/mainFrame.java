package bourdinroad;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bourdinroad.Ecran.GererBouton;

public class mainFrame extends JFrame {
	JPanel p = new JPanel();
	
	vueConnexion p1 = new vueConnexion();
	vueInscription p2 = new vueInscription();
	vueMenuAdmin p3 = new vueMenuAdmin();
	adminUtilisateurs p4 = new adminUtilisateurs();
	vuAddQuizz p5 = new vuAddQuizz();
	vueAddQR p6 = new vueAddQR();
	vueMenuUsers p7 = new vueMenuUsers();
	
	CardLayout carte = new CardLayout();
	
	public mainFrame(String titre,int largeur,int hauteur) {
		super(titre);
		setSize(largeur,hauteur);
		
		//Instantiation du conteneur
		Container g=getContentPane();
		g.setLayout(new GridBagLayout());
		p.setLayout(carte);
		p.add("vConnexion",p1);
		g.add(p);
		
		GererBouton gestionnaire = new GererBouton();
		p1.connect.addActionListener(gestionnaire);
		p1.inscription.addActionListener(gestionnaire);
		p2.connexion.addActionListener(gestionnaire);
		p3.majUser.addActionListener(gestionnaire);
		p3.ajoutQuizz.addActionListener(gestionnaire);
		p5.leaveAddQuizz.addActionListener(gestionnaire);
		p3.ajoutQuestion.addActionListener(gestionnaire);
		
	}
	
	public void goToInscription(){
		p.add("inscription",p2);
		carte.next(p);
		
	}
	
	public void goToConnexion(){
		p.add("vConnexion",p1);
		carte.next(p);
		
	}
	
	public void goToMenuAdmin(){
		p.add("menuAdmin",p3);
		carte.next(p);
		
	}
	
	public void goToMajAdmin(){
		p.add("majUser",p4);
		carte.next(p);
	}	
	
	public void goToAddQuizz(){
		p.add("addQuizz",p5);
		carte.next(p);
	}
	
	public void goToAddQR(){
		p.add("addQR",p6);
		carte.next(p);
	}
	
	public void leaveAddQuizz(){
		p.add("leaveAddQuizz",p3);
		carte.next(p);
	}
	public void goToMenuUsers(){
		p.add("menuUsers",p7);
		carte.next(p);
	}
	
	//  Traitement connexion
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()==p1.connect){
	    		  //vérification de la connexion
	    		  boolean verifCo = p1.co.idConnect(p1.login.getText().toString(), p1.mdp.getText().toString());
	    		  if(verifCo == true){
	    			  //JOptionPane.showMessageDialog( null,"Vous êtes connecté." );
	    			  goToMenuAdmin();
	    		  }else{
	    			  /*JOptionPane.showMessageDialog( null,"L'authentification a échouée." );*/
	    			  goToMenuUsers();
	    		  }
	    	  }
	    	  if(event.getSource()==p1.inscription){
	    		  goToInscription();
	    	  }
	    	  if(event.getSource()==p2.connexion){
	    		  System.out.println("event");
	    		  goToConnexion();
	    	  }
	    	  if(event.getSource()==p3.majUser){
	    		  System.out.println("event");
	    		  goToMajAdmin();
	    	  }
	    	  if(event.getSource()==p3.ajoutQuizz){
	    		  System.out.println("event");
	    		  goToAddQuizz();
	    	  }
	    	  if(event.getSource()==p5.leaveAddQuizz){
	    		  System.out.println("event");
	    		  leaveAddQuizz();
	    	  }
	    	  if(event.getSource()==p3.ajoutQuestion){
	    		  System.out.println("event");
	    		  goToAddQR();
	    	  }
	      }
	}

}
