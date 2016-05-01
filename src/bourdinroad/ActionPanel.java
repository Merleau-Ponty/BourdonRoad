package bourdinroad;

import bourdinroad.Ecran;
import javax.swing.JFrame;


public class ActionPanel {
	public static JFrame frame;
	
		public static void main(String[] args){
			//frame = new vueMenuAdmin("Bourdon Road",900,600);
			frame = new mainFrame("Bourdon Road",900,600);
			frame.setVisible(true);
		}
	}

