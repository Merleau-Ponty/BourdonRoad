package bourdinroad;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;

import bourdinroad.Ecran.GererBouton;

public class vueConnexion extends JPanel {
	JPanel mainCadre = new JPanel();
	JLabel labelLogin=new JLabel("Identifiant :");
	JLabel labelMdp=new JLabel("Mot de passe :");
	JTextField login=new JTextField(7);
	JPasswordField mdp=new JPasswordField(7);
	JButton connect = new JButton("Connexion");
	JButton inscription= new JButton("Formumlaire d'inscription");
	GestionBD co = new GestionBD();
	//vueMenuAdmin vuMenu = new vueMenuAdmin();
	
	public vueConnexion(){
		//#windowsbuilder
		super();
		
		JPanel cadreCo = new JPanel();
		//panel cadre
		Border borderCadre=BorderFactory.createTitledBorder("Connexion");
		cadreCo.setBorder(borderCadre);
		cadreCo.add(labelLogin);
		cadreCo.add(labelMdp);
		cadreCo.add(login);
		cadreCo.add(mdp);
		cadreCo.add(connect);
		cadreCo.add(inscription);
		mainCadre.add(cadreCo, "CadreCo");
		setLayout(new BorderLayout());
		add("Center",mainCadre);
		
		//Positionnement des composants dans le panel
		cadreCo.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		//Login
		gbc1.gridy=1;
		gbc1.gridx=0;
		cadreCo.add(labelLogin,gbc1);
		
		gbc1.gridy=1;
		gbc1.gridx=1;
		cadreCo.add(login,gbc1);
		
		//Mot de passe
		gbc1.gridy=2;
		gbc1.gridx=0;
		cadreCo.add(labelMdp,gbc1);

		gbc1.gridy=2;
		gbc1.gridx=1;
		cadreCo.add(mdp,gbc1);
		
		//Boutons
		gbc1.gridy=4;
		gbc1.gridx=0;
		cadreCo.add(connect,gbc1);
				
		gbc1.gridy=4;
		gbc1.gridx=1;
		cadreCo.add(inscription,gbc1);
	
		GererBouton gestionnaire = new GererBouton();
		connect.addActionListener(gestionnaire);
	}
	
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()==connect){
	    		  //vérification de la connexion
	    		  boolean verifCo = co.idConnect(login.getText().toString(), mdp.getText().toString());
	    		  if(verifCo == true){
	    			  JOptionPane.showMessageDialog( null,"Vous êtes connecté." );
	    		  }else{
	    			  JOptionPane.showMessageDialog( null,"L'authentification a échouée." );
	    		  }
	    		  //Les 2 sont remplis?
	    		  if(login.getText().toString().length()==0 && mdp.getText().toString().length()==0){
	    			  JOptionPane.showMessageDialog( null,"Veuillez saisir un identifiant et un mot de passe." );
	    		  }else{
	    			  //l'identifiant est remplis?
		    		  if(login.getText().toString().length()==0){
		    			  JOptionPane.showMessageDialog( null,"Veuillez saisir un identifiant." );
		    		  }else{
		    			  //le mod de passe est rempli?
		    			  if(mdp.getText().toString().length()==0){
			    			  JOptionPane.showMessageDialog( null,"Veuillez saisir un mot de passe.." );
			    		  }
		    		  }
	    		  }
	    	  }
	      }
	}

}
