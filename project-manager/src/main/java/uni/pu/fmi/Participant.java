package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Participant {

    /**
     * Default constructor
     */
    public Participant() {
    	tasksToDo = new ArrayList<Task>();
    }

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String firstName;

    /**
     * 
     */
    private String secondName;

    /**
     * 
     */
    private Boolean leader;

    /**
     * 
     */
    private ArrayList<Task> tasksToDo;

    /**
     * 
     */
    private ProjectManager projectManager;

    

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username 
     * @return
     */
    public void setUsername(String username) {
    	this.username = username;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName 
     * @return
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName 
     * @return
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return
     */
    public Boolean getLeader() {
        return leader;
    }

    /**
     * @param leader 
     * @return
     */
    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    /**
     * @return
     */
    public ArrayList<Task> getTasksToDo() {
        return tasksToDo;
    }

    /**
     * @param tasks 
     * @return
     */
    public void setTasksToDo(ArrayList<Task> tasks) {
        this.tasksToDo = tasks;
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