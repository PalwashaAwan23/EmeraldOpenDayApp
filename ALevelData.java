public class ALevelData extends QualificationData {
    // Constructor
    public ALevelData(int ALevelID, String maxGrade, String minGrade) {
        super(ALevelID, maxGrade, minGrade);
    } 

    // ToString method for debugging
    @Override
    public String toString() {
        return "ALevelData{" +
                "ALevelID=" + requirementID +
                ", maxGrade='" + MaxGrade + '\'' +
                ", minGrade='" + MinGrade + '\'' +
                '}';
    }
}