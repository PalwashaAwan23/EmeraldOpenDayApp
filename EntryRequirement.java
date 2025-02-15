public class EntryRequirement {
    // Variables 
    private int requiredID;
    private int UCASPoints;
    private int Degree_DegreeID;
    private int ALevel_ALevelID;
    private int BTECExDipl_BTECID;
    private int CambrExDip_OCRCaID;
    private int HEDiploma_HEID;

    // Constructor
    public EntryRequirement(int requiredID, int UCASPoints, int Degree_DegreeID, int ALevel_ALevelID, int BTECExDipl_BTECID, int CambrExDip_OCRCaID, int HEDiploma_HEID) {
        this.requiredID = requiredID;
        this.UCASPoints = UCASPoints;
        this.Degree_DegreeID = Degree_DegreeID;
        this.ALevel_ALevelID = ALevel_ALevelID;
        this.BTECExDipl_BTECID = BTECExDipl_BTECID;
        this.CambrExDip_OCRCaID = CambrExDip_OCRCaID; 
        this.HEDiploma_HEID = HEDiploma_HEID;
    }

    // Getters and Setters
    public int getRequiredID() {
        return requiredID;
    }

    public void setRequiredID(int requiredID) {
        this.requiredID = requiredID;
    }

    public int getUCASPoints() {
        return UCASPoints;
    }

    public void setUCASPoints(int UCASPoints) {
        this.UCASPoints = UCASPoints;
    }

    public int getDegree_DegreeID() {
        return Degree_DegreeID;
    }

    public void setDegree_DegreeID(int Degree_DegreeID) {
        this.Degree_DegreeID = Degree_DegreeID;
    }

    public int getALevel_ALevelID() {
        return ALevel_ALevelID;
    }

    public void setALevel_ALevelID(int ALevel_ALevelID) {
        this.ALevel_ALevelID = ALevel_ALevelID;
    }

    public int getBTECExDipl_BTECID() {
        return BTECExDipl_BTECID;
    }

    public void setBTECExDipl_BTECID(int BTECExDipl_BTECID) {
        this.BTECExDipl_BTECID = BTECExDipl_BTECID;
    }

    public int getCambrExDip_OCRCaID() {
        return CambrExDip_OCRCaID;
    }

    public void setCambrExDip_OCRCaID(int CambrExDip_OCRCaID) {
        this.CambrExDip_OCRCaID = CambrExDip_OCRCaID;
    }

    public int getHEDiploma_HEID() {
        return HEDiploma_HEID;
    }

    public void setHEDiploma_HEID(int HEDiploma_HEID) {
        this.HEDiploma_HEID = HEDiploma_HEID;
    }

    // ToString Method for Debugging
    @Override
    public String toString() {
        return "EntryRequirement{" +
                "requiredID=" + requiredID +
                ", UCASPoints=" + UCASPoints +
                ", Degree_DegreeID=" + Degree_DegreeID +
                ", ALevel_ALevelID=" + ALevel_ALevelID +
                ", BTECExDipl_BTECID=" + BTECExDipl_BTECID +
                ", CambrExDip_OCRCaID=" + CambrExDip_OCRCaID +
                ", HEDiploma_HEID=" + HEDiploma_HEID +
                '}';
    }
}
