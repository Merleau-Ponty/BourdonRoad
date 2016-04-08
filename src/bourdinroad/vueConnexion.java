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
	JButton connexion = new JButton("Connexion");
	JButton inscription= new JButton("Formumlaire d'inscription");
	GestionBD co = new GestionBD();
	//vueMenuAdmin vuMenu = new vueMenuAdmin();
	
	public vueConnexion(){
		//#windowsbuilder
		super();
		/*setSize(largeur,hauteur);*/
		
		/*Container g=getContentPane();
		g.setLayout(new GridBagLayout());*/
		
		JPanel cadreCo = new JPanel();
		//panel cadre
		Border borderCadre=BorderFactory.createTitledBorder("Connexion");
		cadreCo.setBorder(borderCadre);
		cadreCo.add(labelLogin);
		cadreCo.add(labelMdp);
		cadreCo.add(login);
		cadreCo.add(mdp);
		cadreCo.add(connexion);
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
		cadreCo.add(connexion,gbc1);
				
		gbc1.gridy=4;
		gbc1.gridx=1;
		cadreCo.add(inscription,gbc1);
	
		//g.add(mainCadre);
		
		
	
	}
	

}
