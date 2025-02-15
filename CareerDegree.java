public class CareerDegree {
    private int CareerDegreeID;
    private int Degree_DegreeID;
    private int CareerInfo_CareerID;

    // Constructor
    public CareerDegree(int CareerDegreeID, int Degree_DegreeID, int CareerInfo_CareerID) {
        this.CareerDegreeID = CareerDegreeID;
        this.Degree_DegreeID = Degree_DegreeID;
        this.CareerInfo_CareerID = CareerInfo_CareerID;

    }   
    
    
    // Getters and Setters
	public int getCareerDegreeID() {
		return CareerDegreeID;
	}

	public void setCareerDegreeID(int careerDegreeID) {
		CareerDegreeID = careerDegreeID;
	}


	public int getDegree_DegreeID() {
		return Degree_DegreeID;
	}


	public void setDegree_DegreeID(int Degree_DegreeID) {
		this.Degree_DegreeID = Degree_DegreeID;
	}


	public int getCareerInfo_CareerID() {
		return CareerInfo_CareerID;
	}


	public void setCareerInfo_CareerID(int CareerInfo_CareerID) {
		this.CareerInfo_CareerID = CareerInfo_CareerID;
	}


    // ToString method for debugging
    @Override
    public String toString() {
        return "CareerDegree{" +
                "CareerDegreeID=" + CareerDegreeID +
                ", Degree_DegreeID=" + Degree_DegreeID +
                ", CareerInfo_CareerID=" + CareerInfo_CareerID +

                '}';
    }
    
    

}
