package bourdinroad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.BitSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bourdinroad.adminUtilisateurs.GererBouton;

public class AddQtoQ extends JPanel{
	JPanel addQtoQ = new JPanel();
	JLabel labQuizz = new JLabel("Saisissez le quizz: ");
	JLabel labQuestion = new JLabel("Saisissez la question: ");
	JLabel sautLigne = new JLabel("   ");
	JComboBox quizz, question;
	JButton save = new JButton("Enregistrer");
	JButton leave = new JButton("Retour au menu");
	
GestionBD bd = new GestionBD();
	
	public AddQtoQ() {
	 	super();
	 	JPanel gestAddQtoQ = new JPanel();
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Attribution de questions à un quizz");
		gestAddQtoQ.setBorder(borderCadre);
		addQtoQ.add(gestAddQtoQ);
		setLayout(new BorderLayout());
		add("Center",addQtoQ);
		
		gestAddQtoQ.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    //Alimentation de la liste de quizz et de question
	    quizz = new JComboBox(bd.getQuizz().toArray());
	    question = new JComboBox(bd.getQuestion().toArray());
	    
	    /*Saut de ligne*/
	    gbc.gridy=0;
	    gbc.gridx=0;
	    gestAddQtoQ.add(sautLigne, gbc);
	    
	    /*Saisir la question question*/
	    gbc.gridy=1;
	    gbc.gridx=0;
	    gestAddQtoQ.add(labQuizz, gbc);

	    gbc.gridy=1;
	    gbc.gridx=1;
	    gestAddQtoQ.add(quizz, gbc);
	    
	    /*Saut de ligne*/
	    gbc.gridy=2;
	    gbc.gridx=0;
	    gestAddQtoQ.add(sautLigne, gbc);
	    
	    
	    /*Saisir la question*/
	    gbc.gridy=3;
	    gbc.gridx=0;
	    gestAddQtoQ.add(labQuestion, gbc);

	    gbc.gridy=3;
	    gbc.gridx=1;
	    gestAddQtoQ.add(question, gbc);
	    
	    /*Saut de ligne*/
	    gbc.gridy=4;
	    gbc.gridx=0;
	    gestAddQtoQ.add(sautLigne, gbc);
	    
	    /*Sauvegarder*/
	    gbc.gridy=5;
	    gbc.gridx=0;
	    gestAddQtoQ.add(save, gbc);
	    
	    /*Retour*/
	    gbc.gridy=5;
	    gbc.gridx=1;
	    gestAddQtoQ.add(leave, gbc);
	    
	    GererBouton gest = new GererBouton();
		save.addActionListener(gest);
	    
	}
	
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()==save){
	    		  System.out.println(quizz.getSelectedItem());
	    		  System.out.println(question.getSelectedItem());
	    		  bd.updateIdQuizzToQuestion(quizz.getSelectedItem().toString(), question.getSelectedItem().toString());
	    		  JOptionPane.showMessageDialog( null,"La question a été ajoutée au quizz." );
	    	  }
	      }
	}

}