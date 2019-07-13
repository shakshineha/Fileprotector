package Work;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.sql.*;

public class HashFunc {
	private String input;
	
	HashFunc(String str){
		this.input=str;
	}
	
	public static String getSHAhelp(String input) {
		return getSHA(input);
	}
	
	private static String getSHA(String input) 
    { 
        try { 
            // Static getInstance method is called with hashing SHA 
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
            // digest() method called 
            // to calculate message digest of an input 
            // and return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            return hashtext; 
        }
        
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown"
                               + " for incorrect algorithm: " + e); 
  
            return null; 
        } 
    }
	
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		String usnm = System.getProperty("user.name");
		String pswd=s.next();
		HashFunc h=new HashFunc(pswd);
		String hashed_pswd = h.getSHAhelp(pswd);
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/db","root","password");  
			//here db is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select password from t1 where t1.username=usnm");  
			
			if(rs.equals(hashed_pswd)) {
				//grant accesss;
			}
			
			else {
				//show error
			}
			  
			con.close();  
			}catch(Exception e){ 
				System.out.println(e);
			}  
	}  
	
}
