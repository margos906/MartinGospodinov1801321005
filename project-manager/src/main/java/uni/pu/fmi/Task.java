package uni.pu.fmi;
import java.util.*;

/**
 * 0 = New
 * 1 = IN_PROGRESS
 * 2 = DONE
 * 3 = CANCELLED
 */
public class Task {

    /**
     * Default constructor
     */
    public Task() {
    	status = 0;
    	subtasks = new ArrayList<Task>();
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private ArrayList<Task> subtasks;

    /**
     * 
     */
    private Participant assignedTo;

    /**
     * 0 = New
     * 1 = IN_PROGRESS
     * 2 = DONE
     * 3 = CANCELLED
     */
    private int status;

    /**
     * 
     */
    private Project belongsToProject;

    /**
     * 
     */
    private ProjectManager projectManager;

    /**
     * 
     */
    private Task mainTask;


    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public ArrayList<Task> getSubtasks() {
        return subtasks;
    }

    /**
     * @param subtasks 
     * @return
     */
    public void setSubtasks(ArrayList<Task> subtasks) {
        this.subtasks = subtasks;
    }

    /**
     * @return
     */
    public Participant getAssignedTo() {
        return assignedTo;
    }

    /**
     * @param assignedTo 
     * @return
     */
    public void setAssignedTo(Participant assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * 0 = New
     * 1 = IN_PROGRESS
     * 2 = DONE
     * 3 = CANCELLED
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * 0 = New
     * 1 = IN_PROGRESS
     * 2 = DONE
     * 3 = CANCELLED
     * @param int newStatus 
     * @return
     */
    public void setStatus(int newStatus) {
    	this.status = newStatus;
    }
    
    /**
     * @return
     */
    public Project getBelongsToProject() {
        return belongsToProject;
    }

    /**
     * @param project 
     * @return
     */
    public void setBelongsToProject(Project project) {
        this.belongsToProject = project;
    }

    /**
     * @return
     */
    public Task getMainTask() {
        return mainTask;
    }

    /**
     * @param mainTask 
     * @return
     */
    public void setMainTask(Task mainTask) {
        this.mainTask = mainTask;
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