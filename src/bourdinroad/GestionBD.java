package bourdinroad;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionBD {
	private String login, mdp;
	
	DriverLoad driverload = new DriverLoad(); 

	//Vérification des identifiants lors de la connexion
	public boolean idConnect(String login, String mdp){
		ArrayList<String> liste = new ArrayList();
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("select LOGIN_USER from UTILISATEURS where LOGIN_USER='"+login+"' and PWD_USER='"+mdp+"';");
			if(rs.next()){
				liste.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(liste.toString()+"+++++++++++++"+liste);
		if(liste.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
	
	/*Fonction de recuperation de l'id de l'utilisateur connecter*/
	public int getIdConnect(String login, String mdp){
		int id = 0;
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("select ID_USER from UTILISATEURS where LOGIN_USER='"+login+"' and PWD_USER='"+mdp+"';");
			if (rs.first()){
				 id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	/*Fonction de Creation liste des services*/
	public ArrayList<String> service(){
		ArrayList<String> liste = new ArrayList();
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("select LIBELLE_SERVICES from SERVICES;");
			while(rs.next()){
				liste.add(rs.getString("LIBELLE_SERVICES"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}
	
	/*Fonction de Creation liste des utilisateur*/
	public ArrayList<String> utilisateurs(){
		ArrayList<String> liste = new ArrayList();
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("select nom_user, prenom_user from UTILISATEURS;");
			liste.add("--- Sélectionner un utilisateur ---");
			while(rs.next()){
				String chaineMaj = "";
				if(rs.getString("prenom_user") != ""){
					String prenom = rs.getString("prenom_user");
					chaineMaj=prenom.replaceFirst(".",(prenom.charAt(0)+"").toUpperCase());
				}
				String nom = ""+chaineMaj+" "+rs.getString("nom_user").toUpperCase()+"";
				liste.add(nom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return liste;
	}
	
	/*Fonction de creation de compte*/
	public void inscription(int num,String nom, String prenom, String mobile,String email,String id, String mdp){
		try {
			Statement st = driverload.getConnexion().createStatement();
			int rs = st.executeUpdate("insert into UTILISATEURS (ID_SERVICES,NOM_USER,PRENOM_USER,MOBILE,EMAIL,LOGIN_USER,PWD_USER) values ('"+num+"','"+nom+"','"+prenom+"','"+mobile+"','"+email+"','"+id+"','"+mdp+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Fonction de creation de quizz*/
	public void AddQuizz(String nomQuizz){
		try {
			Statement st = driverload.getConnexion().createStatement();
			int rs = st.executeUpdate("insert into QUIZZ (LIBELLE_QUIZZ) values ('"+nomQuizz+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /*Fonction de recupération du numéro de la question*/
	public int getNumQuest(String Q){
		int numQuest = 0;
		try{
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs1 = st.executeQuery("select ID_QUEST from QUESTIONS where LIBELLE_QUEST='"+Q+"';");
			if(rs1.first()) {
				numQuest = rs1.getInt(1);
			}
			//numQuest=13;
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numQuest;
	}
	
	//fonction de création des réponses
	public void AddR(int nQ, String RA, String RB, String RC, String RD, boolean JA, boolean JB, boolean JC, boolean JD){
		try {
			Statement st = driverload.getConnexion().createStatement();
			int JFA = 0, JFB = 0, JFC = 0, JFD = 0;
			if(JA == true) JFA = 1;
			if(JB == true) JFB = 1;
			if(JC == true) JFC = 1;
			if(JD == true) JFD = 1;
			//insertion de la question dans la base
			int rs2 = st.executeUpdate("insert into REPONSES (ID_QUEST, LIBELLE_REP, JUSTE) values ("+nQ+", '"+RA+"', "+JFA+");");
			int rs3 = st.executeUpdate("insert into REPONSES (ID_QUEST, LIBELLE_REP, JUSTE) values ("+nQ+", '"+RB+"', "+JFB+");");
			int rs4 = st.executeUpdate("insert into REPONSES (ID_QUEST, LIBELLE_REP, JUSTE) values ("+nQ+", '"+RC+"', "+JFC+");");
			int rs5 = st.executeUpdate("insert into REPONSES (ID_QUEST, LIBELLE_REP, JUSTE) values ("+nQ+", '"+RD+"', "+JFD+");");
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Fonction de creation de compte*/
	public void AddQR(String Q, String RA, String RB, String RC, String RD, boolean JA, boolean JB, boolean JC, boolean JD, String filename, String solution){
		int idImg = 0;
		int idSol = 0;
		try {
			Statement st = driverload.getConnexion().createStatement();
			//insertion de la question dans la base
			//Enregistre l'image et récupère le numéro afin d'enregistrer la question
			int rs1 = st.executeUpdate("insert into IMAGES (NOM_IMG, CHEMIN) values ('"+filename+"','"+filename+"');");
			ResultSet rs2 = st.executeQuery("select ID_IMG from IMAGES where NOM_IMG='"+filename+"';");
			if(rs2.first()) {
				idImg = rs2.getInt(1);
			}
			//Enregistrement de la solution et récupération de l'id de la solution pour enregistrer la question
			int rs3 = st.executeUpdate("insert into SOLUTIONS (LIBELLE_SOL) values ('"+solution+"');");
			ResultSet rs4 = st.executeQuery("select ID_SOL from SOLUTIONS where LIBELLE_SOL='"+solution+"';");
			if(rs4.first()) {
				idSol = rs4.getInt(1);
			}
			//insertion de la question dans la BDD
			int rs = st.executeUpdate("insert into QUESTIONS (LIBELLE_QUEST, ID_IMG, ID_SOL) values ('"+Q+"',"+idImg+","+idSol+");");
			int numQuest = getNumQuest(Q);
			AddR(numQuest, RA, RB, RC, RD, JA, JB, JC, JD);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Fonction de modification de compte*/
	public void modification(int id,int num,String nom, String prenom, String mobile,String email,String identifiant, String mdp,int admin){
		ArrayList<String> liste = new ArrayList();
		try {
			Statement st = driverload.getConnexion().createStatement();
			int rs = st.executeUpdate("update UTILISATEURS set ID_SERVICES='"+num+"' ,NOM_USER='"+nom+"',PRENOM_USER='"+prenom+"',MOBILE='"+mobile+"',EMAIL='"+email+"',LOGIN_USER='"+identifiant+"',PWD_USER='"+mdp+"',admin='"+admin+"' WHERE ID_USER='"+id+"' ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Fonction de verification admin*/
	public boolean verifAdmin(String login, String mdp){
		boolean res = false;
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("select ADMIN from UTILISATEURS where LOGIN_USER='"+login+"' and PWD_USER='"+mdp+"';");
			/*Verification que le champ admin est a 1*/
			if (rs.first()){
				int admin = rs.getInt(1);
				if(admin == 1){
					res = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	/*Recuperation des infos en fonction du choix dans la liste*/
	public ArrayList<String> getInfoUser(String nom, String prenom) {
		ArrayList<String> liste = new ArrayList();
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT `ID_SERVICES`, `NOM_USER`, `PRENOM_USER`, `MOBILE`, `EMAIL`, `LOGIN_USER`, `PWD_USER`, `ADMIN` FROM `UTILISATEURS` WHERE NOM_USER='"+nom+"',PRENOM_USER='"+prenom+"';");
			while(rs.next()){
				liste.add(rs.getString("ID_SERVICES").toString());
				liste.add(rs.getString("NOM_USER").toString());
				liste.add(rs.getString("PRENOM_USER").toString());
				liste.add(rs.getString("MOBILE").toString());
				liste.add(rs.getString("EMAIL").toString());
				liste.add(rs.getString("LOGIN_USER").toString());
				liste.add(rs.getString("PWD_USER").toString());
				liste.add(rs.getString("ADMIN").toString());	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
	}
	
	//Methode qui récupère les quizz
	public ArrayList<String> getQuizz(){
		ArrayList<String> liste = new ArrayList<>();
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT LIBELLE_QUIZZ FROM QUIZZ;");
			liste.add("--- Quizz ---");
			while(rs.next()){
				liste.add(rs.getString("LIBELLE_QUIZZ").toString());	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	//Methode de qui récupère les questions qui ne sont pas affectées à un quizz
	public ArrayList<String> getQuestion(){
		ArrayList<String> liste = new ArrayList<>();
		try {
			Statement st = driverload.getConnexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT LIBELLE_QUEST FROM `QUESTIONS` WHERE ID_QUIZZ = 0;");
			liste.add("--- Questions ---");
			while(rs.next()){
				liste.add(rs.getString("LIBELLE_QUEST").toString());	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	
	//Methode de qui récupère les questions
		public ArrayList<String> getAllQuestion(){
			ArrayList<String> liste = new ArrayList<>();
			try {
				Statement st = driverload.getConnexion().createStatement();
				ResultSet rs = st.executeQuery("SELECT LIBELLE_QUEST FROM `QUESTIONS`;");
				liste.add("--- Questions ---");
				while(rs.next()){
					liste.add(rs.getString("LIBELLE_QUEST").toString());	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return liste;
		}
	
	//Méthode qui affecte une question à un quizz
	public void updateIdQuizzToQuestion(String quizz, String question){
		int idQuest = 0;
		int idQuizz = 0;
		try {
			Statement st = driverload.getConnexion().createStatement();
			//récupere le numéro de la question choisie dans le formulaire
			ResultSet rs = st.executeQuery("SELECT ID_QUEST FROM `QUESTIONS` WHERE LIBELLE_QUEST = '"+question+"';");
			if(rs.first()){
				idQuest = rs.getInt(1);
			}
			System.out.println(idQuest);
			//récupère le numéro du quizz choisi dans le formulaire
			ResultSet rs1 = st.executeQuery("SELECT ID_QUIZZ FROM `QUIZZ` WHERE LIBELLE_QUIZZ = '"+quizz+"';");
			if(rs1.first()){
				idQuizz = rs1.getInt(1);
			}
			System.out.println(idQuizz);
			int rs2 = st.executeUpdate("update QUESTIONS set ID_QUIZZ = "+idQuizz+" where ID_QUEST = "+idQuest+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Méthode qui récupère les infos d'une question
		public String[] getQtoSet(String question){
			int idQuest = 0;
			String[] liste = {""};
			try {
				Statement st = driverload.getConnexion().createStatement();
				//récupere le numéro de la question choisie dans le formulaire
				ResultSet rs = st.executeQuery("SELECT ID_QUEST, LIBELLE_QUEST FROM `QUESTIONS` WHERE LIBELLE_QUEST = '"+question+"';");
				if(rs.first()){
					idQuest = rs.getInt(1);
					String[] liste1 = {rs.getString(1), rs.getString(2)};
					liste = liste1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return liste;
		}
		
		//Méthode qui récupère les infos des réponses
		public ArrayList<String> getRforQ(String numQuest){
			int idRep = 0;
			ArrayList<String> liste = new ArrayList();
			try {
				Statement st = driverload.getConnexion().createStatement();
				//récupere le numéro de la question choisie dans le formulaire
				ResultSet rs = st.executeQuery("SELECT ID_REP, LIBELLE_REP, JUSTE FROM `REPONSES` WHERE ID_QUEST = '"+numQuest+"';");
				while(rs.next()){
					liste.add(rs.getString("ID_REP").toString());
					liste.add(rs.getString("LIBELLE_REP").toString());
					liste.add(rs.getString("JUSTE").toString());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(liste);
			return liste;
		}
	
		public ArrayList<String> question(){
			ArrayList<String> liste = new ArrayList<>();
			try {
				Statement st = driverload.getConnexion().createStatement();
				ResultSet rs = st.executeQuery("SELECT CHEMIN,LIBELLE_QUEST, LIBELLE_REP, JUSTE,LIBELLE_SOL FROM IMAGES INNER JOIN QUESTIONS ON IMAGES.ID_IMG= QUESTIONS.ID_IMG INNER JOIN REPONSES ON REPONSES.ID_QUEST=QUESTION.ID_QUEST INNER JOIN SOLUTIONS.ID_SOL=QUESTIONS.ID_SOL INNER JOIN TENTATIVES ON TENTATIVES.ID_QUIZZ=QUIZZ.ID_QUIZZ WHERE ID_TENT=(SELECT MAX(ID_TENT) FROM TENTATIVES);");
				while(rs.next()){
					liste.add(rs.getString("CHEMIN").toString());
					liste.add(rs.getString("LIBELLE_QUEST").toString());
					liste.add(rs.getString("LIBELLE_REP").toString());
					liste.add(rs.getString("JUSTE").toString());
					liste.add(rs.getString("LIBELLE_SOL").toString());	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return liste;
		}
		
		public void ajoutTentative(String quizz,int id){
			int idQuizz = 0;
				try {
				Statement st = driverload.getConnexion().createStatement();
				//récupère le numéro du quizz dans la table tentative, pour cela on prend le dernier ID_TENT c'est a dire le max
				ResultSet rs = st.executeQuery("SELECT ID_QUIZZ FROM `QUIZZ` WHERE LIBELLE_QUIZZ = '"+quizz+"';");
				if(rs.first()){
					idQuizz = rs.getInt(1);
				}
				System.out.println(idQuizz);
				System.out.println(id);
				
				int rs1 = st.executeUpdate("insert into TENTATIVES (ID_QUIZZ, ID_USER) values ("+idQuizz+","+id+");");
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Méthode qui affecte une question à un quizz
		public void updateQuestAndRep(String id, String question, String repA, String repB, String repC, String repD, 
				String idRepA, String idRepB, String idRepC, String idRepD, int justeA, int justeB, int justeC, int justeD){
			int idQuest = 0;
			int idQuizz = 0;
			try {
				Statement st = driverload.getConnexion().createStatement();
				System.out.println(id+" "+question);
				System.out.println(idRepA+", "+idRepB+", "+idRepC+", "+idRepD);
				int rs = st.executeUpdate("update QUESTIONS set LIBELLE_QUEST = '"+question+"' where ID_QUEST = '"+id+"'");
				int rs1 = st.executeUpdate("update REPONSES set LIBELLE_REP = '"+repA+"', JUSTE = "+justeA+" where ID_REP = '"+idRepA+"'");
				int rs2 = st.executeUpdate("update REPONSES set LIBELLE_REP = '"+repB+"', JUSTE = "+justeB+" where ID_REP = '"+idRepB+"'");
				int rs3 = st.executeUpdate("update REPONSES set LIBELLE_REP = '"+repC+"', JUSTE = "+justeC+" where ID_REP = '"+idRepC+"'");
				int rs4 = st.executeUpdate("update REPONSES set LIBELLE_REP = '"+repD+"', JUSTE = "+justeD+" where ID_REP = '"+idRepD+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}