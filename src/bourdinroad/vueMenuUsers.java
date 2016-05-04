package bourdinroad;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class vueMenuUsers extends JPanel{
	JPanel menuUser = new JPanel();
	JButton majUser = new JButton("Modification: Utilisateur");
	JButton repondreQuizz = new JButton("Repondre: Quizz");
	JButton voirStat = new JButton("Statistique: Afficher");
	JButton deconnexion = new JButton("Déconnexion");
	
	public vueMenuUsers(){
		
			JPanel cadreCo = new JPanel();
			//panel cadre
			Border borderCadre=BorderFactory.createTitledBorder(" Menu ");
			menuUser.setBorder(borderCadre);
			menuUser.add(majUser);
			menuUser.add(repondreQuizz);
			menuUser.add(voirStat);
			menuUser.add(deconnexion);
			menuUser .add(cadreCo, "CadreCo");
			setLayout(new BorderLayout());
			add("Center",menuUser );
				
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
			cadreCo.add(repondreQuizz,gbc1);
				
			//Voir les statistiques
			gbc1.gridy=2;
			gbc1.gridx=0;
			cadreCo.add(voirStat,gbc1);
			
			//Deconnexion
			gbc1.gridy=3;
			gbc1.gridx=0;
			cadreCo.add(deconnexion,gbc1);

			
			//g.add(mainCadre);
	}
	
	public JPanel getPanel(){
		return menuUser;
	}	
}


