
public class Degree {
    private int DegreeID;
    private String DegreeName;
    private String UCASCode;
    private String CourseLength;


    // Constructor
    public Degree(int DegreeID, String DegreeName, String UCASCode, String CourseLength) {
        this.DegreeID = DegreeID;
        this.DegreeName = DegreeName;
        this.UCASCode = UCASCode;
        this.CourseLength = CourseLength;
 
    }

    // Getters and Setters
    public int getDegreeID() {
        return DegreeID;
    }

    public void setDegreeID(int DegreeID) {
        this.DegreeID = DegreeID;
    }

    public String getDegreeName() {
        return DegreeName;
    }

    public void setDegreeName(String DegreeName) {
        this.DegreeName = DegreeName;
    }

    public String getUCASCode() {
        return UCASCode;
    }

    public void setUCASCode(String UCASCode) {
        this.UCASCode = UCASCode;
    }

    public String getCourseLength() {
        return CourseLength;
    }

    public void setCourseLength(String CourseLength) {
        this.CourseLength = CourseLength;
    }


    // ToString method for debugging
    @Override
    public String toString() {
        return "Degree{" +
                "DegreeID=" + DegreeID +
                ", DegreeName='" + DegreeName + '\'' +
                ", UCASCode='" + UCASCode + '\'' +
                ", CourseLength='" + CourseLength + '\'' +
                '}';
    }
}