public class ModulesDegree {
    private int moduleDegreeID;
    private int Degree_DegreeID;
    private int Modules_ModuleID;

    // Constructor
    public ModulesDegree(int moduleDegreeID, int Degree_DegreeID, int Modules_ModuleID) {
        this.moduleDegreeID = moduleDegreeID;
        this.Degree_DegreeID = Degree_DegreeID;
        this.Modules_ModuleID = Modules_ModuleID;
    }

    // Getters and Setters
    public int getModuleDegreeID() {
        return moduleDegreeID;
    }

    public void setModuleDegreeID(int moduleDegreeID) {
        this.moduleDegreeID = moduleDegreeID; 
    }

    public int getDegree_DegreeID() {
        return Degree_DegreeID;
    }

    public void setDegree_DegreeID(int Degree_DegreeID) {
        this.Degree_DegreeID = Degree_DegreeID;
    }

    public int getModules_ModuleID() {
        return Modules_ModuleID;
    }

    public void setModules_ModuleID(int Modules_ModuleID) {
        this.Modules_ModuleID = Modules_ModuleID;
    }



    // ToString method for debugging
    @Override
    public String toString() {
        return "ModuleDegree{" +
                "moduleDegreeID=" + moduleDegreeID +
                ", moduleDegreeID=" + moduleDegreeID +
                ", Modules_ModuleID=" + Modules_ModuleID +
                '}';
    }
}
