
public class CareerInfo {
    private int CareerID;
    private String CareerName;
    private int StartingSalary;
    private int AverageSalary;
    
    
	public CareerInfo(int CareerID, String CareerName, int StartingSalary, int AverageSalary) {
		// TODO Auto-generated constructor stub
        this.CareerID = CareerID;
        this.CareerName = CareerName;
        this.StartingSalary = StartingSalary; 
        this.AverageSalary = AverageSalary;
		
	}


	public int getCareerID() {
		return CareerID;
	}


	public void setCareerID(int careerID) {
		CareerID = careerID;
	}


	public String getCareerName() {
		return CareerName;
	}


	public void setCareerName(String careerName) {
		CareerName = careerName;
	}


	public int getStartingSalary() {
		return StartingSalary;
	}


	public void setStartingSalary(int startingSalary) {
		StartingSalary = startingSalary;
	}


	public int getAverageSalary() {
		return AverageSalary;
	}


	public void setAverageSalary(int averageSalary) {
		AverageSalary = averageSalary;
	}


    // ToString method for debugging
    @Override
    public String toString() {
        return "CareerInfo{" +
                ", CareerID=" + CareerID +
                ", CareerName='" + CareerName + '\'' +
                ", StartingSalary=" + StartingSalary +
                ", AverageSalary=" + AverageSalary +
                '}';
    }



}
