package bourdinroad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverLoad {
	private Connection connexion;
	
	public DriverLoad(){
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		}
		catch(ClassNotFoundException e){
			 System.err.println(" Erreur de chargement du driver : "+ e) ;
		}
	}
	
	/*Permet de se connecter  a la BDD*/
	public Connection getConnexion(){
		try {
			connexion= DriverManager.getConnection("jdbc:mysql://172.20.251.13/BOURDONROAD","bourdonroad","bourdonroad");
			}
			catch(SQLException e)
			{
			 System.err.println(" Erreur de chargement du driver : "+ e) ;
			} 
		return connexion;
	}
}
