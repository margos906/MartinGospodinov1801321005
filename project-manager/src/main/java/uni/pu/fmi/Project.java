package uni.pu.fmi;
import java.util.*;

/**
 * 
 */
public class Project {

    /**
     * Default constructor
     */
    public Project() {
    	this.subprojects = new ArrayList<Project>();
    	this.tasks = new ArrayList<Task>();
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private ArrayList<Project> subprojects;

    /**
     * 
     */
    private ArrayList<Task> tasks;

    /**
     * 
     */
    private Project mainProject;

    /**
     * 
     */
    private ProjectManager projectManager;

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
    public ArrayList<Project> getSubprojects() {
        return subprojects;
    }

    /**
     * @param subprojects 
     * @return
     */
    public void setSubprojects(ArrayList<Project> subprojects) {
        this.subprojects = subprojects;
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
    
    public void addTask(Task task) {
    	this.tasks.add(task);
    }
    
    /**
     * @return
     */
    public Project getMainProject() {
        return mainProject;
    }

    /**
     * @param subprojects 
     * @return
     */
    public void setMainProject(Project project) {
        this.mainProject = project;
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