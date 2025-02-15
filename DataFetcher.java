import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataFetcher {
    protected static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "leeya";
    private static Connection connection; 
    
    public DataFetcher(){

    }
    
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

    public EntryRequirement getRequirementsForDegree(int degreeID) {
        String query = """
                SELECT cr.RequiredID, cr.UCASPoints, cr.ALevel_ALevelID, cr.BTECExDipl_BTECID, 
                    cr.CambrExDip_OCRCaID, cr.HEDiploma_HEID 
                FROM OpenDayAppDatabase.EntryRequirement cr 
                WHERE cr.Degree_DegreeID = ?
                """;
        
        EntryRequirement requirement = null;
        try (PreparedStatement sqlStatement = connection.prepareStatement(query)) {
            sqlStatement.setInt(1, degreeID);
            ResultSet result = sqlStatement.executeQuery();
    
            if (result.next()) {
                int requirementID = result.getInt("RequiredID");
                int ucasPoints = result.getInt("UCASPoints");
                int aLevelID = result.getInt("ALevel_ALevelID");
                int btecID = result.getInt("BTECExDipl_BTECID");
                int cambridgeID = result.getInt("CambrExDip_OCRCaID");
                int hecID = result.getInt("HEDiploma_HEID");

                requirement = new EntryRequirement(requirementID,
                        ucasPoints, degreeID, aLevelID, btecID, cambridgeID, hecID);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return requirement;
    }

    public List<ModulesDegree> getModulesForDegree(int degreeID) {
        List<ModulesDegree> modulesList = new ArrayList<>();
        String query = "SELECT * FROM OpenDayAppDatabase.ModuleDegree WHERE Degree_DegreeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int moduleDegreeID = result.getInt("JobDegreeID");
                int moduleID = result.getInt("Modules_ModuleID");

                // Create ModulesDegree object and add to list
                ModulesDegree module = new ModulesDegree(moduleDegreeID, degreeID, moduleID);
                modulesList.add(module);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modulesList;
    }

    public Modules getModuleInfoForDegree(int degreeID) {
        String query = "SELECT * FROM OpenDayAppDatabase.Modules WHERE ModuleID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int moduleID = result.getInt("ModuleID");
                String moduleName = result.getString("ModuleName");
                int credits = result.getInt("Credits");


                Modules module = new Modules(
                        moduleID, moduleName, credits
                );
                return module;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CareerDegree> getCareerIDForDegree(int degreeID) {
        List<CareerDegree> jobList = new ArrayList<>();
        String query = "SELECT * FROM OpenDayAppDatabase.CareerDegree WHERE Degree_DegreeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int careerDegreeID = result.getInt("CareerDegreeID");
                int degreeIDValue = result.getInt("Degree_DegreeID");
                int careerID = result.getInt("CareerInfo_CareerID");

                CareerDegree job = new CareerDegree(
                        careerDegreeID,
                        degreeIDValue,
                        careerID
                );
                jobList.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobList;
    }

    public CareerInfo getCareerInfoForDegree(int degreeID) {
        String query = "SELECT * FROM OpenDayAppDatabase.CareerInfo WHERE CareerID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int careerID = result.getInt("CareerID");
                String careerName = result.getString("CareerName");
                int StartingSalary = result.getInt("StartingSalary");
                int AverageSalary = result.getInt("AverageSalary");

                CareerInfo job = new CareerInfo(
                        careerID,
                        careerName,
                        StartingSalary,
                        AverageSalary
                );
                return job;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Degree getDegreeInfo(int degreeID){
        String query = "SELECT * FROM OpenDayAppDatabase.Degree WHERE DegreeID = ?";
        try (PreparedStatement sqlStatement = connection.prepareStatement(query)){
            sqlStatement.setInt(1, degreeID);
            ResultSet result = sqlStatement.executeQuery();
            if (result.next()) {
                Degree degree = new Degree(
                    result.getInt("DegreeID"),
                    result.getString("DegreeName"),
                    result.getString("UCASCode"),
                    result.getString("CourseLength")
                );
                return degree;
                
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private ALevelData getALevelData(int degreeID){
        String sqlQuery = "SELECT * FROM OpenDayAppDatabase.ALevel WHERE DegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new ALevelData(
                        result.getInt("ALevelID"),
                        result.getString("MaxGrade"),
                        result.getString("MinGrade")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private BTECData getBTECExDiplData(int degreeID){
        String sqlQuery = "SELECT * FROM OpenDayAppDatabase.BTECExDipl WHERE DegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new BTECData(
                        result.getInt("BTECID"),
                        result.getString("MaxGrade"),
                        result.getString("MinGrade")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private HEData getHEDiplimaData(int degreeID){
        String sqlQuery = "SELECT * FROM OpenDayAppDatabase.HEDiploma WHERE DegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new HEData(
                        result.getInt("HEID"),
                        result.getString("MaxGrade"),
                        result.getString("MinGrade")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private CambridgeData getCambrDiplData(int degreeID){
        String sqlQuery = "SELECT * FROM OpenDayAppDatabase.CambrExDip WHERE DegreeID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            statement.setInt(1, degreeID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new CambridgeData(
                        result.getInt("OCRCaID"),
                        result.getString("MaxGrade"),
                        result.getString("MinGrade")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
