package uni.pu.fmi.services;

import java.util.ArrayList;
import java.util.HashMap;

import uni.pu.fmi.Logger;
import uni.pu.fmi.Participant;
import uni.pu.fmi.Project;
import uni.pu.fmi.ProjectManager;
import uni.pu.fmi.Task;

public class ProjectManagementService {
	
	private ProjectManager projectManager;
	private HashMap<String, Integer> taskStatuses;
	private HashMap<Integer, String> taskStatusesReverse;
	private String lastTaskStatusChangeMessage;
	
	public ProjectManagementService() {
		this.projectManager = new ProjectManager();

		taskStatuses = new HashMap<String, Integer>();
		taskStatuses.put("NEW", 0);
		taskStatuses.put("IN_PROGRESS", 1);
		taskStatuses.put("DONE", 2);
		taskStatuses.put("CANCELLED", 3);

		taskStatusesReverse = new HashMap<Integer, String>();
		taskStatusesReverse.put(0, "NEW");
		taskStatusesReverse.put(1, "IN_PROGRESS");
		taskStatusesReverse.put(2, "DONE");
		taskStatusesReverse.put(3, "CANCELLED");
	}
	
	public void addTaskInProjectManager(Task task) {
		ArrayList<Task> projectManagerTasks = projectManager.getTasks();
		projectManagerTasks.add(task);
		projectManager.setTasks(projectManagerTasks);
	}
	
	public void addProjectInProjectManager(Project project) {
		ArrayList<Project> projectManagerProjects = projectManager.getProjects();
		projectManagerProjects.add(project);
		projectManager.setProjects(projectManagerProjects);
	}
	
	public void addParticipantInProjectManager(Participant participant) {
		ArrayList<Participant> projectManagerParticipants = projectManager.getParticipants();
		projectManagerParticipants.add(participant);
		projectManager.setParticipants(projectManagerParticipants);
	}
	
	public void addDefaultTask() {
		Task task = new Task();
		task.setName("DefaultTask");
		if(getTaskByName("DefaultTask")==null) {
			addTaskInProjectManager(task);
		}
	}

	public void addDefaultProject() {
		Project project = new Project();
		project.setName("DefaultProject");
		if(getProjectByName("DefaultProject")==null) {
			addProjectInProjectManager(project);
		}
	}
	
	public void addDefaultParticipant() {
		Participant participant = new Participant();
		participant.setFirstName("Default");
		participant.setSecondName("Participant");
		if(getParticipantByName("Default", "Participant")==null) {
			addParticipantInProjectManager(participant);
		}
	}

	public Task getTaskByName(String name) {
		for (Task task : projectManager.getTasks()) {
			if(name.equals(task.getName())) {
				return task;
			}
		}
		return null;
	}

	public Task getTaskByNameInProject(String taskName, String projectName) {
		Project project = getProjectByName(projectName);
		for (Task task : project.getTasks()) {
			if(taskName.equals(task.getName())) {
				return task;
			}
		}
		return null;
	}

	public Project getProjectByName(String name) {
		for (Project project : projectManager.getProjects()) {
			if(name.equals(project.getName())) {
				return project;
			}
		}
		return null;
	}
	
	public Participant getParticipantByName(String firstName) {
		for (Participant participant : projectManager.getParticipants()) {
			if(firstName.equals(participant.getFirstName())) {
				return participant;
			}
		}
		return null;
	}
	
	public Participant getParticipantByName(String firstName, String secondName) {
		for (Participant participant : projectManager.getParticipants()) {
			if(firstName.equals(participant.getFirstName()) && secondName.equals(participant.getSecondName())) {
				return participant;
			}
		}
		return null;
	}

	public void createTask(String name) {
		Task task = new Task();
		task.setName(name);
		addTaskInProjectManager(task);
	}
	
	public void createTask(String taskName, String projectName) {
		Task task = new Task();
		task.setName(taskName);
		addTaskInProjectManager(task);
		Project project = getProjectByName(projectName);
		projectManager.assignTask(task, project);
	}
	
	public void createSubtask(String subtaskName, String mainTaskName) {
		Task task = new Task();
		task.setName(subtaskName);
		
		Task mainTask = getTaskByName(mainTaskName);
		
		projectManager.addSubtask(task, mainTask);
	}
	
	public void removeSubtasks(String mainTaskName) {
		Task task = getTaskByName(mainTaskName);
		ArrayList<Task> tasks = new ArrayList<Task>();
		task.setSubtasks(tasks);
	}
	
	public void assignTaskToParticipant(String taskName, String participantFirstName, String participantSecondName) {
		Task task = getTaskByName(taskName);
		Participant participant = getParticipantByName(participantFirstName, participantSecondName);
		projectManager.assignTaskToParticipant(task, participant);
	}
	
	public String changeTaskStatus(String taskName, String newStatus) {
		Task task = getTaskByName(taskName);
		lastTaskStatusChangeMessage = projectManager.changeTaskStatus(task, taskStatuses.get(newStatus));
		return lastTaskStatusChangeMessage;
	}
	
	public String getTaskStatus(String taskName) {
		Task task = getTaskByName(taskName);
		return taskStatusesReverse.get(task.getStatus());
	}
	
	public void createProject(String projectName) {
		Project project = new Project();
		project.setName(projectName);
		addProjectInProjectManager(project);
	}
	
	public void createSubproject(String subprojectName, String mainProjectName) {
		Project project = new Project();
		project.setName(subprojectName);
		addProjectInProjectManager(project);
		
		Project mainProject = getProjectByName(mainProjectName);
		
		projectManager.addSubproject(project, mainProject);
	}
	
	public void removeSubprojects(String projectName) {
		Project project = getProjectByName(projectName);
		ArrayList<Project> projects = new ArrayList<Project>();
		project.setSubprojects(projects);
	}
	
	public void createParticipant(String firstName) {
		Participant participant = new Participant();
		participant.setFirstName(firstName);
		addParticipantInProjectManager(participant);
	}
	
	public void createParticipant(String firstName, String secondName) {
		Participant participant = new Participant();
		participant.setFirstName(firstName);
		participant.setSecondName(secondName);
		addParticipantInProjectManager(participant);
	}
	
	public int getTasksAmountInProject(String projectName) {
		Project projectToCheck = getProjectByName(projectName);
		return projectToCheck.getTasks().size();
	}
	
	public void removeProjectTasks(String projectName) {
		Project project = getProjectByName(projectName);
		ArrayList<Task> tasks = new ArrayList<Task>();
		project.setTasks(tasks);
	}
	
	public void removeProjectByName(String name) {
		Project projectToRemove = getProjectByName(name);
		projectManager.getProjects().remove(projectToRemove);
	}
	
	public void clearLoggerMessages() {
		Logger logger = projectManager.getLogger();
		ArrayList<String> logMessages = new ArrayList<String>();
		logger.setLogMessages(logMessages);
	}
	
	public Logger getLogger() {
		return projectManager.getLogger();
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public String getLastTaskStatusChangeMessage() {
		return lastTaskStatusChangeMessage;
	}

	public void setLastTaskStatusChangeMessage(String lastTaskStatusChangeMessage) {
		this.lastTaskStatusChangeMessage = lastTaskStatusChangeMessage;
	}
	
	
}
