
import java.sql.Connection;
public class Main{

	
    public static void main(String[] args){
        //Code to get the data from the database
        // Will be attached to Android Studio for the user 
        System.out.println(" Proceeding with the program.");

    	// Check if database connection works
   //    System.out.println("Testing database connection...");
        Connection connection = DatabaseBConnector.getConnection(); 
        if (connection != null) {
            System.out.println("Database connected successfully! Proceeding with the program.");
        } else {
            System.out.println("Failed to connect to the database. Please check your configuration.");
            return;
        }
    }

}


