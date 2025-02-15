public class HEData extends QualificationData {
    // Constructor
    public HEData(int BTECID, String maxGrade, String minGrade) {
        super(BTECID, maxGrade, minGrade);
    }

    // ToString method for debugging
    @Override
    public String toString() {
        return "HEData{" +
                "BTECID=" + requirementID +
                ", maxGrade='" + MaxGrade + '\'' +
                ", minGrade='" + MinGrade + '\'' +
                '}';
    }
}
