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
	
	/*Fonction de creation de compte*/
	public void AddQuizz(String nomQuizz){
		try {
			Statement st = driverload.getConnexion().createStatement();
			int rs = st.executeUpdate("insert into QUIZZ (LIBELLE_QUIZZ) values ('"+nomQuizz+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Fonction de modification de compte*/
	public void modification(String nomOri,int num,String nom, String prenom, String mobile,String email,String id, String mdp,int admin){
		ArrayList<String> liste = new ArrayList();
		try {
			Statement st = driverload.getConnexion().createStatement();
			int rs = st.executeUpdate("update UTILISATEURS set ID_SERVICES='"+num+"' ,NOM_USER='"+nom+"',PRENOM_USER='"+prenom+"',MOBILE='"+mobile+"',EMAIL='"+email+"',LOGIN_USER='"+id+"',PWD_USER='"+mdp+"',admin='"+admin+"' WHERE NOM_USER='"+nomOri+"' ;");
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
			if (rs.getByte("ADMIN")== 1){
			 res = true;
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
	
}