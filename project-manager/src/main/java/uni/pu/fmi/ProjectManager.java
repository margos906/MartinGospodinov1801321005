package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class ProjectManager {

    
    /**
     * 
     */
    private ArrayList<Project> projects;

    /**
     * 
     */
    private ArrayList<Participant> participants;

    /**
     * 
     */
    private ArrayList<Task> tasks;

    /**
     * 
     */
    private Logger logger;

    /**
     * 
     */
    private Participant loggedUser;

    
    
    /**
     * Default constructor
     */
    public ProjectManager() {
    	this.projects = new ArrayList<Project>();
    	this.participants = new ArrayList<Participant>();
    	this.tasks = new ArrayList<Task>();
    	this.logger = new Logger();
    	this.loggedUser = new Participant();
    }
    
    
    
    /**
     * @param logger 
     * @return
     */
    public Logger getLogger() {
		return logger;
	}
    
    /**
     * @return
     */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	/**
     * @return
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }

    /**
     * @param projects 
     * @return
     */
    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    /**
     * @return
     */
    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    /**
     * @param participants 
     * @return
     */
    public void setParticipants(ArrayList<Participant> participants) {
    	this.participants = participants;
    }
	
    /**
     * @return
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * @param tasks 
     * @return
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * @param task 
     * @param int newStatus 
     * @return
     */
    public String changeTaskStatus(Task task, int newStatus) {
    	if(newStatus<0 || newStatus>3) {
    		return "Invalid status";
    	}
    	if(task.getStatus()==2) {
    		return "Task is done, unable to change status";
    	}
    	logger.log("Status of " + task.getName() + " was changed from " + task.getStatus() + " to " + newStatus);
    	task.setStatus(newStatus);
        return "Status changed successfully";
    }

    /**
     * @param task 
     * @return
     */
    public void assignTask(Task task, Project project) {
    	task.setBelongsToProject(project);
    	project.addTask(task);
    }

    /**
     * @param task 
     * @param participant 
     * @return
     */
    public void assignTaskToParticipant(Task task, Participant participant) {
        task.setAssignedTo(participant);
        participant.getTasksToDo().add(task);
    }

    /**
     * @param username 
     * @param password 
     * @return
     */
    public void login(String username, String password) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Participant getLoggedUser() {
        return loggedUser;
    }

    /**
     * @param subtask 
     * @param mainTask 
     * @return
     */
    public void addSubtask(Task subtask, Task mainTask) {
    	mainTask.getSubtasks().add(subtask);
    	subtask.setMainTask(mainTask);
    }

    /**
     * @param subproject 
     * @param mainProject 
     * @return
     */
    public void addSubproject(Project subproject, Project mainProject) {
        mainProject.getSubprojects().add(subproject);
        subproject.setMainProject(mainProject);
    }

}