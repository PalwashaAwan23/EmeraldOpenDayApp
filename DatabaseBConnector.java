
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseBConnector {
	protected static final String USERNAME = "root";
    protected static final String PASSWORD = "leeya";   
	protected static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    
    private static Connection connection; 
    

	public static Connection getConnection() {
		try {
            // Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Establish the database connection
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);  
			// System.out.println("Connected to the database!");  
		} catch (ClassNotFoundException | SQLException e) {
            // Print error message if connection fails
			System.out.println("Failed to connect to the database!  ");
			e.printStackTrace();
		}
		return connection;
	}

	public static void disconnect() {
		try {
            // Check if the connection is open
			if (connection != null && !connection.isClosed()) {
                // Close the connection
				connection.close();
				System.out.println("Disconnected from the database!");
			}
		} catch (SQLException e) { 
            // Print error message if disconnection fails
			e.printStackTrace();
		}
	}


	// Checking if the database values exist
	public boolean  CheckCareerInfoExists(int CareerID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.CareerInfo WHERE CareerID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, CareerID);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking career infomation existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckHECDiplomaExists(int HEID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.HEDiploma WHERE HEID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, HEID);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking HE Diploma existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckCambrExDiplomaExists(int OCRCaID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.CambrExDip WHERE OCRCaID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, OCRCaID);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking OCR Cambridge L3 Technical Extended Diploma existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckBTECExDiplomaExists(int BTECID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.BTECExDipl WHERE BTECID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, BTECID);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking BTEC L3 Extended Diploma existence: " + e.getMessage());
            return false;
        }
	}
	public boolean CheckALevelRequirementExists(int ALevelID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.ALevel WHERE ALevelID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, ALevelID);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking ALevels record existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckCareerDegreesExists(int CareerDegreeID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.CareerDegree WHERE CareerDegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, CareerDegreeID); 
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking Career Degree existence: " + e.getMessage());
            return false;
        }
	}
	public boolean CheckModulesDegreesExists(int ModulesDegreeID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.ModuleDegree WHERE ModulesDegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
        	statement.setInt(1, ModulesDegreeID); 
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking Module Degree existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckCourseRequirementsExists(int RequiredID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.EntryRequirement WHERE RequiredID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
        	statement.setInt(1, RequiredID); 
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking Entry Requirements existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckDegreeDataExists(int DegreeID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.Degree WHERE DegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, DegreeID); 
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking Degree existence: " + e.getMessage());
            return false;
        }
	}

	public boolean CheckModulesExists(int ModuleID){
		String sql_statement = "SELECT * FROM OpenDayAppDatabase.Modules WHERE ModuleID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, ModuleID); 
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a row is found
            }
        } catch (SQLException e) {
            System.out.println("Error while checking Modules existence: " + e.getMessage());
            return false;
        }
	}

	// Removing in values to the specific tables 
	public void removeDegreeData(int DegreeID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.Degree WHERE DegreeID=?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, DegreeID);
            statement.executeUpdate();

            System.out.println("The degree has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }
	}

	public void removeEntryRequirements(int RequiredID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.EntryRequirement WHERE RequiredID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, RequiredID);
            statement.executeUpdate();

            System.out.println("The Entry Requirement has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }
	
	}

	public void removeModulesDegrees(int ModulesDegreeID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.ModulesDegree WHERE ModulesDegreeID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, ModulesDegreeID);
            statement.executeUpdate();

            System.out.println("The Modules Degree has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }
	
	}

	public void removeCareerDegrees(int CareerDegreeID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.CareerDegree WHERE CareerDegreeID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, CareerDegreeID);
            statement.executeUpdate();

            System.out.println("The Career Degree has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }
	
	}
	

	public void removeALevelRequirements(int ALevelID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.ALevel WHERE ALevelID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, ALevelID);
            statement.executeUpdate();

            System.out.println("The ALevel Degree has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }
	
	}

	public void removeBTECExDiploma(int BTECID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.BTECExDipl WHERE BTECID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, BTECID);
            statement.executeUpdate();

            System.out.println("The BTEC L3 Extended Diploma has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }
	
	}
	
	public void removeCambrExDiploma(int OCRCaID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.CambrExDip WHERE OCRCaID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, OCRCaID);
            statement.executeUpdate();

            System.out.println("The OCR Cambridge L3 Technical Extended Diploma a has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }	
		
	}
	
	public void removeHEDiploma(int HEID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.HEDiploma WHERE HEID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, HEID);
            statement.executeUpdate();

            System.out.println("The HE Diploma a has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }	
		
	}

	public void removeCareerInfo(int CareerID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.CareerInfo WHERE CareerID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, CareerID);
            statement.executeUpdate();

            System.out.println("The career information a has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }	
		
	}
	
	public void removeModules(int ModuleID){
		String sql_statement = "DELETE FROM OpenDayAppDatabase.Modules WHERE ModuleID =?";
        // deletes a competitor from the database based on competitorID
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)){
            statement.setInt(1, ModuleID);
            statement.executeUpdate();

            System.out.println("The modules information a has been deleted");

        } catch (SQLException e) {
            System.err.println(e);
        }	
		
	}

	// Adding into specific tables

	public void addHEDiploma(HEData HE){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.HEDiploma (HEID, MaxGrade, MinGrade) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, HE.getRequirementID());
            statement.setString(2, HE.getMaxGrade());
            statement.setString(3, HE.getMinGrade());
           
            statement.executeUpdate();

            System.out.println("The HE Diploma has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}

	public void addCambrExDiploma(CambridgeData cambrdata){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.CambrExDip (OCRCaID, MaxGrade, MinGrade) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, cambrdata.getRequirementID());
            statement.setString(2, cambrdata.getMaxGrade());
            statement.setString(3, cambrdata.getMinGrade());
           
            statement.executeUpdate();

            System.out.println("The OCR Cambridge L3 Technical Extended Diploma has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}

	public void addBTECExDiploma(BTECData btecs){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.BTECExDipl (BTECID, MaxGrade, MinGrade) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, btecs.getRequirementID());
            statement.setString(2, btecs.getMaxGrade());
            statement.setString(3, btecs.getMinGrade());
           
            statement.executeUpdate();

            System.out.println("The BTEC L3 Extended Diploma has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}

	public void addALevelRequirement(ALevelData alevels){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.ALevel (ALevelID, MaxGrade, MinGrade) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, alevels.getRequirementID());
            statement.setString(2, alevels.getMaxGrade());
            statement.setString(3, alevels.getMinGrade());
           
            statement.executeUpdate();

            System.out.println("The ALevel requirements has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}


	public void addCareerDegree(CareerDegree CCareer){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.CareerDegree (CareerDegreeID, Degree_DegreeID, CareerInfo_CareerID) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, CCareer.getCareerDegreeID());
            statement.setInt(2, CCareer.getDegree_DegreeID());
            statement.setInt(3, CCareer.getCareerInfo_CareerID());
           
            statement.executeUpdate();

            System.out.println("The career degree has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}

	public void addModulesDegrees(ModulesDegree modules){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.ModuleDegree (CareerDegreeID, Degree_DegreeID, Modules_ModuleID) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, modules.getModuleDegreeID());
            statement.setInt(2,modules.getDegree_DegreeID());
            statement.setInt(3, modules.getModules_ModuleID());
           
            statement.executeUpdate();

            System.out.println("The Module Degree has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}


	public void addEntryRequirement(EntryRequirement entry){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.EntryRequirement (RequiredID, UCASPoints, Degree_DegreeID, ALevel_ALevelID, BTECExDipl_BTECID, CambrExDip_OCRCaID, HEDiploma_HEID) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, entry.getRequiredID());
            statement.setInt(2,entry.getUCASPoints());
            statement.setInt(3, entry.getDegree_DegreeID());
            statement.setInt(4,entry.getALevel_ALevelID());
            statement.setInt(5, entry.getBTECExDipl_BTECID());
            statement.setInt(6, entry.getCambrExDip_OCRCaID());
            statement.setInt(7, entry.getHEDiploma_HEID());

           
            statement.executeUpdate();

            System.out.println("The entry requirement has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}


	public void addDegreeData(Degree degrees){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.Degree (DegreeID, DegreeName, UCASCode, CourseLength) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, degrees.getDegreeID());
            statement.setString(2,degrees.getDegreeName());
            statement.setString(3, degrees.getUCASCode());
            statement.setString(3, degrees.getCourseLength());
           
            statement.executeUpdate();

            System.out.println("The degree data has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}

	public void addCareerInfo(CareerInfo Career){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.CareerInfo (CareerID, CareerName, StartingSalary, AverageSalary) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, Career.getCareerID());
            statement.setString(2,Career.getCareerName());
            statement.setInt(3, Career.getStartingSalary());
            statement.setInt(3, Career.getAverageSalary());
           
            statement.executeUpdate();

            System.out.println("The career information has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
        
	}

	public void addModules(Modules Module){
		String sql_statement = "INSERT INTO OpenDayAppDatabase.CareerInfo (ModuleID, ModuleName, Credits) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
            statement.setInt(1, Module.getModuleID());
            statement.setString(2,Module.getModuleName());
            statement.setInt(3, Module.getCredits());
           
            statement.executeUpdate();

            System.out.println("The Modules information has been added to the database");
        } catch (SQLException e) {
            System.err.println(e);
        }
	}}

