package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Logger {

    /**
     * Default constructor
     */
    public Logger() {
    	logMessages = new ArrayList<String>();
    }

    /**
     * 
     */
    private ArrayList<String> logMessages;

    /**
     * 
     */
    private ProjectManager projectManager;


    /**
     * @param message 
     * @return
     */
    public void log(String message) {
        logMessages.add(message);
    }

    /**
     * @return
     */
    public List<String> getLogMessages() {
    	return logMessages ;
    }

    /**
     * @param logMessages 
     * @return
     */
    public void setLogMessages(ArrayList<String> logMessages) {
        this.logMessages = logMessages;
    }

    /**
     * @return
     */
    public ProjectManager getProjectManager() {
        return projectManager;
    }

    /**
     * @param projectManager 
     * @return
     */
    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

}