import java.util.*;
import java.sql.*;

public class ChatBotService {
    private DataFetcher dataFetcher;

    public ChatBotService() {
        dataFetcher = new DataFetcher();
    }

    public String handleUserQuery(String queryType, int degreeID) {
        switch (queryType.toLowerCase()) {
            case "degree":
                Degree degree = dataFetcher.getDegreeInfo(degreeID);
                return degree != null ? degree.toString() : "Degree not found.";
            case "jobs":
                List<JobsDegree> jobs = dataFetcher.getJobsForDegree(degreeID);
                return jobs.isEmpty() ? "No job information available." : jobs.toString();
            case "modules":
                List<ModulesDegree> modules = dataFetcher.getModulesForDegree(degreeID);
                return modules.isEmpty() ? "No modules found." : modules.toString();
            case "requirements":
                // need to change the entry requirement design
                EntryRequirement req = dataFetcher.getRequirementsForDegree(degreeID);
                return req != null ? req.toString() : "No course requirements available.";
            default:
                return "Invalid option. Please choose from degree, jobs, modules, or requirements.";
        }
    }
}
