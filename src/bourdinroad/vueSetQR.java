package bourdinroad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
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

public class vueSetQR extends JPanel{
	JPanel setQR = new JPanel();
	JLabel labListe = new JLabel("Choisissez la question: ");
	JLabel labQuest = new JLabel("Modifier la question: ");
	JLabel labRepA = new JLabel("Modifier la réponse A: ");
	JLabel labRepB = new JLabel("Modifier la réponse B: ");
	JLabel labRepC = new JLabel("Modifier la réponse C: ");
	JLabel labRepD = new JLabel("Modifier la réponse D: ");
	JLabel sautLigne = new JLabel("    ");
	JTextField question = new JTextField(22);
	JTextField RepA = new JTextField(22);
	JTextField RepB = new JTextField(22);
	JTextField RepC = new JTextField(22);
	JTextField RepD = new JTextField(22);
	JCheckBox justeA = new JCheckBox("juste");
	JCheckBox justeB = new JCheckBox("juste");
	JCheckBox justeC = new JCheckBox("juste");
	JCheckBox justeD = new JCheckBox("juste");
	JComboBox listeQuest;
	JButton save = new JButton("Enregistrer");
	JButton leave = new JButton("Retour au menu");
	JButton aff = new JButton("afficher");
	
	
	GestionBD bd = new GestionBD();
	
	public vueSetQR() {
	 	super();
	 	JPanel gestSetQR = new JPanel();
		//bordure
		Border borderCadre=BorderFactory.createTitledBorder("Modification de questions et réponses");
		gestSetQR.setBorder(borderCadre);
		setQR.add(gestSetQR);
		setLayout(new BorderLayout());
		add("Center",setQR);
		
		gestSetQR.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    //Alimentation de la liste de questions
	    listeQuest = new JComboBox(bd.getAllQuestion().toArray());
	    
	    gbc.gridy=0;
	    gbc.gridx=0;
	    gestSetQR.add(sautLigne, gbc);
	    
	    gbc.gridy=1;
	    gbc.gridx=0;
	    gestSetQR.add(labListe, gbc);
	    
	    gbc.gridy=1;
	    gbc.gridx=1;
	    gestSetQR.add(listeQuest, gbc);
	    
	    gbc.gridy=2;
	    gbc.gridx=0;
	    gestSetQR.add(aff, gbc);
	    
	    gbc.gridy=3;
	    gbc.gridx=0;
	    gestSetQR.add(sautLigne, gbc);
	    
	    gbc.gridy=4;
	    gbc.gridx=0;
	    gestSetQR.add(labQuest, gbc);
	    
	    gbc.gridy=4;
	    gbc.gridx=1;
	    gestSetQR.add(question, gbc);
	    
	    gbc.gridy=5;
	    gbc.gridx=0;
	    gestSetQR.add(labRepA, gbc);
	    
	    gbc.gridy=5;
	    gbc.gridx=1;
	    gestSetQR.add(RepA, gbc);
	    
	    gbc.gridy=5;
	    gbc.gridx=2;
	    gestSetQR.add(justeA, gbc);
	    
	    gbc.gridy=6;
	    gbc.gridx=0;
	    gestSetQR.add(labRepB, gbc);
	    
	    gbc.gridy=6;
	    gbc.gridx=1;
	    gestSetQR.add(RepB, gbc);
	    
	    gbc.gridy=6;
	    gbc.gridx=2;
	    gestSetQR.add(justeB, gbc);
	    
	    gbc.gridy=7;
	    gbc.gridx=0;
	    gestSetQR.add(labRepC, gbc);
	    
	    gbc.gridy=7;
	    gbc.gridx=1;
	    gestSetQR.add(RepC, gbc);
	    
	    gbc.gridy=7;
	    gbc.gridx=2;
	    gestSetQR.add(justeC, gbc);
	    
	    gbc.gridy=8;
	    gbc.gridx=0;
	    gestSetQR.add(labRepD, gbc);
	    
	    gbc.gridy=8;
	    gbc.gridx=1;
	    gestSetQR.add(RepD, gbc);
	    
	    gbc.gridy=8;
	    gbc.gridx=2;
	    gestSetQR.add(justeD, gbc);
	    
	    gbc.gridy=9;
	    gbc.gridx=0;
	    gestSetQR.add(save, gbc);
	    
	    gbc.gridy=9;
	    gbc.gridx=1;
	    gestSetQR.add(leave, gbc);
	    
	    GererBouton gest = new GererBouton();
		save.addActionListener(gest);
		aff.addActionListener(gest);
	}	
	
	final class GererBouton implements ActionListener {
	      // capture des evenements lies aux boutons
	      public void actionPerformed( ActionEvent event ){
	    	  String idQuest = "", idRepA = "", idRepB = "", idRepC = "", idRepD = "";
	    	  //Vérification du bouton cliqué
	    	  if(event.getSource()== aff){
	    		  String[] libQuest = bd.getQtoSet(listeQuest.getSelectedItem().toString());
	    		  ArrayList<String> list = bd.getRforQ(libQuest[0]);
	    		  idQuest = libQuest[0];
	    		  idRepA = list.get(0);
	    		  idRepB = list.get(3);
	    		  idRepC = list.get(6);
	    		  idRepD = list.get(9);
	    		  question.setText(libQuest[1]);
	    		  RepA.setText(list.get(1));
	    		  RepB.setText(list.get(4));
	    		  RepC.setText(list.get(7));
	    		  RepD.setText(list.get(10));
	    		  if(list.get(2).equals("1")){
	    			  justeA.setSelected(true);
	    		  }
	    		  if(list.get(5).equals("1")){
	    			  System.out.println("yep j'y rentre");
	    			  justeB.setSelected(true);
	    		  }
	    		  if(list.get(8).equals("1")){
	    			  justeC.setSelected(true);
	    		  }
	    		  if(list.get(11).equals("1")){
	    			  justeD.setSelected(true);
	    		  }
	    	  }
	    	  if(event.getSource()==save){
	    		  String[] libQuest = bd.getQtoSet(listeQuest.getSelectedItem().toString());
	    		  ArrayList<String> list = bd.getRforQ(libQuest[0]);
	    		  idQuest = libQuest[0];
	    		  idRepA = list.get(0);
	    		  idRepB = list.get(3);
	    		  idRepC = list.get(6);
	    		  idRepD = list.get(9);
	    		  int jA=0, jB=0, jC=0, jD=0;
	    		  if(justeA.isSelected()){
	    			  System.out.println("reponse A est juste");
	    			  jA = 1;
	    		  }else{
	    			  System.out.println("reponse A est fausse");
	    		  }
	    		  if(justeB.isSelected()){
	    			  System.out.println("reponse B est juste");
	    			  jB = 1;
	    		  }else{
	    			  System.out.println("reponse B est fausse");
	    		  }
	    		  if(justeC.isSelected()){
	    			  System.out.println("reponse C est juste");
	    			  jC = 1;
	    		  }else{
	    			  System.out.println("reponse C est fausse");
	    		  }
	    		  if(justeD.isSelected()){
	    			  System.out.println("reponse D est juste");
	    			  jD = 1;
	    		  }else{
	    			  System.out.println("reponse D est fausse");
	    		  }
	    		  bd.updateQuestAndRep(idQuest, question.getText(), RepA.getText(), RepB.getText(), RepC.getText(), RepD.getText(), 
	    					idRepA, idRepB, idRepC, idRepD, jA, jB, jC, jD);
	    	  }
	      }
	}
	
}