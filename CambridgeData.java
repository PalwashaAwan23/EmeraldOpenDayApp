public class CambridgeData extends QualificationData {
    // Constructor
    public CambridgeData(int OCRaID, String maxGrade, String minGrade) {
        super(OCRaID, maxGrade, minGrade);
    }

    // ToString method for debugging
    @Override
    public String toString() {
        return "CambridgeData{" +
                "OCRaID=" + requirementID +
                ", maxGrade='" + MaxGrade + '\'' +
                ", minGrade='" + MinGrade + '\'' +
                '}';
    }
}
