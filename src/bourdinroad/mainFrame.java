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
	
	/*Instanciation*/
	vueConnexion p1 = new vueConnexion();
	vueInscription p2 = new vueInscription();
	vueMenuAdmin p3 = new vueMenuAdmin();
	adminUtilisateurs p4 = new adminUtilisateurs();
	vuAddQuizz p5 = new vuAddQuizz();
	vueAddQR p6 = new vueAddQR();
	vueMenuUsers p7 = new vueMenuUsers();
	userUtilisateurs p8= new userUtilisateurs();
	AddQtoQ p9 = new AddQtoQ();
	vueRepQuizz p10 = new vueRepQuizz();
	vueSetQR p11 = new vueSetQR();
	vueQuizz p12 = new vueQuizz();
	
	/*Creation du card layout*/
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
		/*Ajout des ecouteurs pour changer de panel*/
		p1.connect.addActionListener(gestionnaire);
		p1.inscription.addActionListener(gestionnaire);
		p2.connexion.addActionListener(gestionnaire);
		p3.majAdmin.addActionListener(gestionnaire);
		p3.ajoutQuizz.addActionListener(gestionnaire);
		p5.leaveAddQuizz.addActionListener(gestionnaire);
		p3.creerQuestion.addActionListener(gestionnaire);
		p6.leaveAddQR.addActionListener(gestionnaire);
		p7.majUser.addActionListener(gestionnaire);
		p3.ajoutQuestion.addActionListener(gestionnaire);
		p7.repondreQuizz.addActionListener(gestionnaire);
		p3.modifQuestion.addActionListener(gestionnaire);
		p9.leave.addActionListener(gestionnaire);
		p4.leave.addActionListener(gestionnaire);
		p11.leave.addActionListener(gestionnaire);
		p10.goQuizz.addActionListener(gestionnaire);
		p3.deconnexion.addActionListener(gestionnaire);
		p7.deconnexion.addActionListener(gestionnaire);
	}
	
	
	//Methodes pour aller sur une carte
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
		p.add("majAdmin",p4);
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
	
	public void leavePannel(){
		p.add("leaveAddQuizz",p3);
		p.add("leaveAddQR",p3);
		p.add("leaveAddQtoQ", p3);
		p.add("leaveSetAdmin", p3);
		p.add("leaveSetQR", p3);
		carte.last(p);
	}
	
	public void goToMenuUsers(){
		p.add("menuUsers",p7);
		carte.next(p);
	}
	
	public void goToMajUser(){
		p.add("majUser",p8);
		carte.next(p);
	}
	
	public void goToAddQtoQ(){
		p.add("AddQtoQ",p9);
		carte.next(p);
	}

	public void goToRepQuizz(){
		p.add("vueRepQuizz",p10);
		carte.next(p);
	}
	
	public void goToSetQR(){
		p.add("SetQR",p11);
		carte.next(p);
	}
	
	public void goToQuizz(){
		p.add("Quizz",p12);
		carte.next(p);
	}
	
	public void deco() {
		p.add("deco",p1);
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
	    			  /*Verification si l'utilisateur est admin ou pas, on lui affecte le menu en concequences*/
	    			  boolean verifAdmin = p1.co.verifAdmin(p1.login.getText().toString(), p1.mdp.getText().toString());
	    			  if(verifAdmin == true){
	    				//JOptionPane.showMessageDialog( null,"Vous êtes connecté." );
		    			  goToMenuAdmin();
	    			  }else {
	    				  goToMenuUsers();
	    			  }  
	    		  }else{
	    			 JOptionPane.showMessageDialog( null,"L'authentification a échouée." );
	    		  }
	    	  }
	    	  if(event.getSource()==p1.inscription){
	    		  goToInscription();
	    	  }
	    	  if(event.getSource()==p2.connexion){
	    		  goToConnexion();
	    	  }
	    	  if(event.getSource()==p3.majAdmin){
	    		  goToMajAdmin();
	    	  }
	    	  if(event.getSource()==p3.ajoutQuizz){
	    		  goToAddQuizz();
	    	  }
	    	  if(event.getSource()==p5.leaveAddQuizz || event.getSource()==p6.leaveAddQR || event.getSource()==p9.leave 
	    			  || event.getSource()==p4.leave || event.getSource()==p11.leave){
	    		  leavePannel();
	    	  }
	    	  if(event.getSource()==p3.creerQuestion){
	    		  goToAddQR();
	    	  }
	    	  if(event.getSource()==p7.majUser){
	    		  goToMajUser();
	    	  }
	    	  if(event.getSource()==p3.ajoutQuestion){
	    		  goToAddQtoQ();
	    	  }
	    	  if(event.getSource()==p7.repondreQuizz){
	    		  goToRepQuizz();
	    	  }
	    	  if(event.getSource()==p3.modifQuestion){
	    		  goToSetQR();
	    	  }
	    	  if(event.getSource()==p10.goQuizz){
	    		  goToQuizz();
	    	  }
	    	  if(event.getSource()==p3.deconnexion || event.getSource()==p7.deconnexion){
	    		  deco();
	    	  }
	      }
	}

}
