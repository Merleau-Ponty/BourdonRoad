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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bourdinroad.adminUtilisateurs.GererBouton;

public class vueAddQR extends JPanel{
	JPanel addQR = new JPanel();
	JLabel intro = new JLabel();
	JLabel intro1 = new JLabel();
	JLabel labRepA = new JLabel("Réponse A: ");
	JLabel labRepB = new JLabel("Réponse B: ");
	JLabel labRepC = new JLabel("Réponse C: ");
	JLabel labRepD = new JLabel("Réponse D: ");
	JLabel labPhoto = new JLabel("Choisissez une image (Obligatoire)");
	JLabel sautLigne = new JLabel("   ");
	JLabel labSol = new JLabel("Saisissez la Solution: ");
	JFileChooser photo = new JFileChooser();
	JTextField question = new JTextField(22);
	JTextField repA = new JTextField(22);
	JTextField repB = new JTextField(22);
	JTextField repC = new JTextField(22);
	JTextField repD = new JTextField(22);
	JTextField solution = new JTextField(22);
	JButton save = new JButton("Enregistrer");
	JButton leaveAddQR = new JButton("Retour au Menu");
	JCheckBox repJA = new JCheckBox("Juste");
	JCheckBox repJB = new JCheckBox("Juste");
	JCheckBox repJC = new JCheckBox("Juste");
	JCheckBox repJD = new JCheckBox("Juste");
	
	GestionBD add = new GestionBD();
	
	public vueAddQR() {
	 	super();
	 	JPanel gestAddQR = new JPanel();
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Créer une Question et ses Réponses");
		gestAddQR.setBorder(borderCadre);
		addQR.add(gestAddQR);
		setLayout(new BorderLayout());
		add("Center",addQR);
		
		String explication = "Saisissez la question.";
		String explication1 = "Saisissez les 4 réponses.";
		intro.setText(explication);
		intro1.setText(explication1);
		
		gestAddQR.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    
		/*Saut de ligne*/
	    gbc.gridy=0;
	    gbc.gridx=0;
	    gestAddQR.add(sautLigne, gbc);

	    /*Explication*/
	    gbc.gridy=1;
	    gbc.gridx=0;
	    gestAddQR.add(intro, gbc);
	    
	    /*Question*/
	    gbc.gridy=1;
	    gbc.gridx=1;
	    gestAddQR.add(question, gbc);
	    
	    /*Saut de ligne*/
	    gbc.gridy=2;
	    gbc.gridx=0;
	    gestAddQR.add(sautLigne, gbc);
	    
	    /*libelle photo*/
	    gbc.gridy=3;
	    gbc.gridx=0;
	    gestAddQR.add(labPhoto, gbc);
	    
	    /*photo*/
	    gbc.gridy=3;
	    gbc.gridx=1;
	    gestAddQR.add(photo, gbc);
	    
	    /*Explication 2*/
	    gbc.gridy=4;
	    gbc.gridx=0;
	    gestAddQR.add(intro1, gbc);
	    
	    /*libelle reponse A*/
	    gbc.gridy=5;
	    gbc.gridx=0;
	    gestAddQR.add(labRepA, gbc);
	    
	    /*Reponse A*/
	    gbc.gridy=5;
	    gbc.gridx=1;
	    gestAddQR.add(repA, gbc);
	    
	    /*Case a cocher*/
	    gbc.gridy=5;
	    gbc.gridx=2;
	    gestAddQR.add(repJA, gbc);
	    
	    /*libelle reponse B*/
	    gbc.gridy=6;
	    gbc.gridx=0;
	    gestAddQR.add(labRepB, gbc);
	    
	    /*reponse B*/
	    gbc.gridy=6;
	    gbc.gridx=1;
	    gestAddQR.add(repB, gbc);
	    
	    /*case a cocher B*/
	    gbc.gridy=6;
	    gbc.gridx=2;
	    gestAddQR.add(repJB, gbc);
	    
	    /*libelle reponse C*/
	    gbc.gridy=7;
	    gbc.gridx=0;
	    gestAddQR.add(labRepC, gbc);
	    
	    /*reponse C*/
	    gbc.gridy=7;
	    gbc.gridx=1;
	    gestAddQR.add(repC, gbc);
	    
	    /*case a cocher C*/
	    gbc.gridy=7;
	    gbc.gridx=2;
	    gestAddQR.add(repJC, gbc);
	    
	    /*libelle reponse D*/
	    gbc.gridy=8;
	    gbc.gridx=0;
	    gestAddQR.add(labRepD, gbc);
	    
	    /*reponse D*/
	    gbc.gridy=8;
	    gbc.gridx=1;
	    gestAddQR.add(repD, gbc);
	    
	    /*case a cocher D*/
	    gbc.gridy=8;
	    gbc.gridx=2;
	    gestAddQR.add(repJD, gbc);
	    
	    /*libelle solution*/
	    gbc.gridy=9;
	    gbc.gridx=0;
	    gestAddQR.add(labSol, gbc);
	    
	    /*texte solution*/
	    gbc.gridy=9;
	    gbc.gridx=1;
	    gestAddQR.add(solution, gbc);
	    
	    /*Saut de ligne*/
	    gbc.gridy=10;
	    gbc.gridx=0;
	    gestAddQR.add(sautLigne, gbc);
	    
	    /*Sauvegarder*/
	    gbc.gridy=11;
	    gbc.gridx=0;
	    gestAddQR.add(save, gbc);
	    
	    /*Quitter*/
	    gbc.gridy=11;
	    gbc.gridx=1;
	    gestAddQR.add(leaveAddQR, gbc);
	    
	    GererBouton gest = new GererBouton();
		save.addActionListener(gest);
	}
	
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()==save){
	    		  boolean justeA=false, justeB=false, justeC=false, justeD=false;
	    		  if(repJA.isSelected()){
	    			  System.out.println("reponse A est juste");
	    			  justeA = true;
	    		  }else{
	    			  System.out.println("reponse A est fausse");
	    		  }
	    		  if(repJB.isSelected()){
	    			  System.out.println("reponse B est juste");
	    			  justeB = true;
	    		  }else{
	    			  System.out.println("reponse B est fausse");
	    		  }
	    		  if(repJC.isSelected()){
	    			  System.out.println("reponse C est juste");
	    			  justeC = true;
	    		  }else{
	    			  System.out.println("reponse C est fausse");
	    		  }
	    		  if(repJD.isSelected()){
	    			  System.out.println("reponse D est juste");
	    			  justeD = true;
	    		  }else{
	    			  System.out.println("reponse D est fausse");
	    		  }
	    		  
	    		  String filename = photo.getSelectedFile().getAbsolutePath();
	    		  System.out.println(filename);
	    		  
	    		  add.AddQR(question.getText().toString(), repA.getText().toString(),repB.getText().toString(), repC.getText().toString(), repD.getText().toString(), justeA, justeB, justeC, justeD, filename, solution.getText().toString());
	    		  JOptionPane.showMessageDialog( null,"Enregistrement effectué. Vous pouvez enregistrer une nouvelle question." );
	    		  question.setText("");
	    		  repA.setText("");
	    		  repB.setText("");
	    		  repC.setText("");
	    		  repD.setText("");
	    		  solution.setText("");
	    		  photo.setDialogTitle("");
	    		  repJA.setSelected(false);
	    		  repJB.setSelected(false);
	    		  repJC.setSelected(false);
	    		  repJD.setSelected(false);
	    	  }
	      }
	}
	
}