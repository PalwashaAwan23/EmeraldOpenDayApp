
public class Modules {
    private int ModuleID;
    private String ModuleName;
    private int Credits;
    
    
	public Modules(int ModuleID, String ModuleName, int Credits) {
	    // Constructor
        this.ModuleID = ModuleID;
        this.ModuleName = ModuleName;
        this.Credits = Credits;
	}
		    // Constructor

    // Getters and Setters
	public int getModuleID() {
		return ModuleID;
	}


	public void setModuleID(int ModuleID) {
		this.ModuleID = ModuleID;
	}


	public String getModuleName() {
		return ModuleName;
	}


	public void setModuleName(String ModuleName) {
		this.ModuleName = ModuleName;
	}


	public int getCredits() {
		return Credits;
	}


	public void setCredits(int Credits) {
		this.Credits = Credits;
	}

    // ToString method for debugging
    @Override
    public String toString() {
        return "Modules{" +
                ", ModuleID=" + ModuleID +
                ", ModuleName='" + ModuleName + '\'' +
                ", Credits=" + Credits +
                '}';
    }
	

}
