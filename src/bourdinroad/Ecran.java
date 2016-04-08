package bourdinroad;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

class Ecran extends JFrame
{
	JButton[] but=new JButton[2];
	JPanel boutons=new JPanel();
	JLabel image=new JLabel();
	Vector<String> listeImages=new Vector<String>();
	int pos=0,taille;
	// pos sera la position courante dans leVector (cf image visible)
	// taille permettra de s'adapter en fonction du nombre d'images disponibles
	
	
	public Ecran(String titre,int largeur,int hauteur)
	{
		super(titre);
		setSize(largeur,hauteur);
		Container g=getContentPane();
		g.setLayout(new BorderLayout());
		boutons.setLayout(new GridLayout(3,2));
		
		/*
		listeImages.add("C:\\Users\\JCC\\Pictures\\CaptureHair.png");
		listeImages.add("C:\\Users\\JCC\\Pictures\\CaptureUML1.PNG");
		listeImages.add("C:\\Users\\JCC\\Pictures\\CapturePassmark1.PNG");
		listeImages.add("C:\\Users\\JCC\\Pictures\\CapturePassmark2.PNG");
		*/
		
		//ci-dessous les images sont stock�es dans le dossier bin du projet
		// NB : ou directement dans Project
		listeImages.add("Photo_Q131.jpg");
		listeImages.add("Photo_Q166.jpg");
		listeImages.add("Photo_Q190.jpg");
		listeImages.add("Photo_Q195.jpg");
		
		// r�cup�ration du nombred'images
		taille=listeImages.size();
		
		// cr�atin des 2 boutons
		but[0]=new JButton("Question pr�c�dente");
		boutons.add(but[0]);
		but[1]=new JButton("Question suivante");
		boutons.add(but[1]);
		
		//JTextArea texte=new JTextArea();
		//JPanel image=new JPanel();
		
		image.setIcon(new javax.swing.ImageIcon(getClass().getResource("Photo_Q131.jpg")));
		//g.add(texte,BorderLayout.CENTER);
		g.add(image,BorderLayout.CENTER);
		g.add(boutons,BorderLayout.EAST);
		
		GererBouton gestionnaire = new GererBouton();
	    // association des �couteurs d'�v�nements aux boutons
	    but[0].addActionListener(gestionnaire);
		but[1].addActionListener(gestionnaire);
	    
	    }
		
		//  Traitement des images
		final class GererBouton implements ActionListener {

		      // capture des �v�nements li�s aux boutons
		      public void actionPerformed( ActionEvent event ) 
		      {
		    	if(event.getSource()==but[0])	
		    		
		    		  {
		    			
		    		 	  System.out.println("recule");  	 
		    		 	  pos--;
		    		 	  if(pos<0){
		    				  pos++;
		    				  JOptionPane.showMessageDialog( null,
			    			            "impossible de reculer, il faut aller de l'avant, svp!" );
		    				  // autre option : faire pos=taille-1
		    				  // pour red�marrer par la fin
		    			  }
		    		 	 image.setIcon(new javax.swing.ImageIcon(getClass().getResource(listeImages.get(pos))));
		    		  
		    	  }
		    	else
		    		if(event.getSource()==but[1])	
		    		 {
		    			  pos++;
		    			  if(pos==taille){
		    				  pos--;
		    				  JOptionPane.showMessageDialog( null,
			    			            "pas d'autre image de ce c�t� ci, il faut revenir en arri�re, svp!" );
		    				// autre option : faire pos=0
		    				// pour red�marrer par le d�but
		    			  }
		    			  System.out.println("avance");  
		    			  image.setIcon(new javax.swing.ImageIcon(getClass().getResource(listeImages.get(pos))));
			    		  
		    		 }
		    	
		   }  // fin de la classe interne GererBouton
		} 
	

	
}


