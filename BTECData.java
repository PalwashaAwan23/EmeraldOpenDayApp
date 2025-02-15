public class BTECData extends QualificationData {
    // Constructor
    public BTECData(int BTECID, String maxGrade, String minGrade) {
        super(BTECID, maxGrade, minGrade);
    }

    // ToString method for debugging
    @Override
    public String toString() {
        return "BTECData{" +
                "BTECID=" + requirementID +
                ", maxGrade='" + MaxGrade + '\'' +
                ", minGrade='" + MinGrade + '\'' +
                '}';
    }
}