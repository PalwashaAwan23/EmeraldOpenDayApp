public class QualificationData {
    
    protected int requirementID;
    protected String MaxGrade;
    protected String MinGrade;

    // Constructor
    public QualificationData(int requirementID, String MaxGrade, String MinGrade) {
        this.requirementID = requirementID;
        this.MaxGrade = MaxGrade;
        this.MinGrade = MinGrade;
    }

    // Getters and Setters
    public int getRequirementID() {
        return requirementID;
    }

    public void setRequirementID(int requirementID) {
        this.requirementID = requirementID;
    }
 
    public String getMaxGrade() {
        return MaxGrade;
    }

    public void setMaxGrade(String MaxGrade) {
        this.MaxGrade = MaxGrade;
    }

    public String getMinGrade() {
        return MinGrade;
    }

    public void setMinGrade(String MinGrade) {
        this.MinGrade = MinGrade;
    }

    // ToString method for debugging
    @Override
    public String toString() {
        return "QualificationData{" +
                "requirementID=" + requirementID +
                ", MaxGrade='" + MaxGrade + '\'' +
                ", MinGrade='" + MinGrade + '\'' +
                '}';
    }
}


