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
	GestionBD insc = new GestionBD();
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
		p1.connexion.addActionListener(gestionnaire);
		p1.inscription.addActionListener(gestionnaire);
		p2.connexion.addActionListener(gestionnaire);
	}
	
	public void goToInscription(){
		p.add("inscription",p2);
		carte.next(p);
	}
	
	public void goToConnexion(){
		System.out.println("goto");
		p.add("vConnexion",p1);
		carte.next(p);
	}
	
	public void goToMenuAdmin(){
		p.add("vMenuAdmin",p3);
		carte.next(p);
	}
	
	//  Traitement connexion
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()==p1.connexion){
	    		  //vérification de la connexion
	    		  boolean verifCo = p1.co.idConnect(p1.login.getText().toString(), p1.mdp.getText().toString());
	    		  if(verifCo == true){
	    			  //JOptionPane.showMessageDialog( null,"Vous êtes connecté." );
	    			  String login = p1.login.getText().toString();
	    			  String mdp= p1.mdp.getText().toString();
	    			  
	    			  if(insc.verifAdmin(login,mdp)){
	    				  vueMenuAdmin menuAdmin = new vueMenuAdmin();
	    			  }
	    			  vueMenuAdmin menuAdmin = new vueMenuAdmin();
	    		  }else{
	    			  JOptionPane.showMessageDialog( null,"L'authentification a échouée." );
	    		  }
	    		  //Les 2 sont remplis?
	    		  if(p1.login.getText().toString().length()==0 && p1.mdp.getText().toString().length()==0){
	    			  JOptionPane.showMessageDialog( null,"Veuillez saisir un identifiant et un mot de passe." );
	    		  }else{
	    			  //l'identifiant est remplis?
		    		  if(p1.login.getText().toString().length()==0){
		    			  JOptionPane.showMessageDialog( null,"Veuillez saisir un identifiant." );
		    		  }else{
		    			  //le mod de passe est rempli?
		    			  if(p1.mdp.getText().toString().length()==0){
			    			  JOptionPane.showMessageDialog( null,"Veuillez saisir un mot de passe.." );
			    		  }
		    		  }
	    		  }
	    	  }
	    	  if(event.getSource()==p1.inscription){
	    		  goToInscription();
	    	  }
	    	  if(event.getSource()==p2.connexion){
	    		  System.out.println("event");
	    		  goToConnexion();
	    	  }
	    	  
	      }
	}

}
