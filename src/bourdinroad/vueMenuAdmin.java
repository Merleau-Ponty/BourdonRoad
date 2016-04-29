package bourdinroad;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class vueMenuAdmin extends JPanel{
	JPanel menuAdmin = new JPanel();
	JLabel titretest = new JLabel("yop");
	JButton majUser = new JButton("Modifier utilisateur");
	JButton ajoutQuizz = new JButton("Ajouter un qizz");
	JButton voirStat = new JButton("Voir les statistique");
	JButton creerQuestion = new JButton("Creer une question");
	JButton modifQuestion = new JButton("Modifier une question");
	JButton ajoutQuestion = new JButton("Ajouter une question utilisateur");
	
	
	
	public vueMenuAdmin(){
		
			JPanel cadreCo = new JPanel();
			//panel cadre
			Border borderCadre=BorderFactory.createTitledBorder("menuAdmin");
			menuAdmin .setBorder(borderCadre);
			menuAdmin .add(majUser);
			menuAdmin .add(ajoutQuizz);
			menuAdmin .add(voirStat);
			menuAdmin .add(creerQuestion);
			menuAdmin .add(modifQuestion);
			menuAdmin .add(ajoutQuestion);
			menuAdmin .add(cadreCo, "CadreCo");
			setLayout(new BorderLayout());
			add("Center",menuAdmin );
				
			//Positionnement des composants dans le panel
			cadreCo.setLayout(new GridBagLayout());
			GridBagConstraints gbc1 = new GridBagConstraints();
				
			//modification utilisateur
			gbc1.gridy=1;
			gbc1.gridx=0;
			cadreCo.add(majUser,gbc1);
				
			// ajout d'un quizz
			gbc1.gridy=1;
			gbc1.gridx=1;
			cadreCo.add(ajoutQuizz,gbc1);
				
			//Voir les statistiques
			gbc1.gridy=2;
			gbc1.gridx=0;
			cadreCo.add(voirStat,gbc1);

			//Creer une question
			gbc1.gridy=2;
			gbc1.gridx=1;
			cadreCo.add(creerQuestion,gbc1);
				
			//modifier une question
			gbc1.gridy=4;
			gbc1.gridx=0;
			cadreCo.add(modifQuestion,gbc1);
			
			
			//Ajouter une question			
			gbc1.gridy=4;
			gbc1.gridx=1;
			cadreCo.add(ajoutQuestion,gbc1);
			
			//g.add(mainCadre);
	}
	
	public JPanel getPanel(){
		return menuAdmin;
	}
}
