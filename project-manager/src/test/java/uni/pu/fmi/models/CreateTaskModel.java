package uni.pu.fmi.models;

import uni.pu.fmi.Project;
import uni.pu.fmi.services.ProjectManagementService;

public class CreateTaskModel {

	private ProjectManagementService projectManagementService;
	private String taskName;
	private String projectName;
	private Project selectedProject;
	
	public CreateTaskModel(ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	public void openTaskCreationScreen() {
		
	}

	public void selectProject(String projectName) {
		selectedProject = projectManagementService.getProjectByName(projectName);
	}

	public void removeTasksInSelectedProject() {
		projectManagementService.removeProjectTasks(selectedProject.getName());
	}

	public void inputTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void inputProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void clickCreateTaskButton() {
		projectManagementService.createTask(taskName, projectName);
	}

	public int getTasksAmountInProject() {
		return selectedProject.getTasks().size();
	}
	
}
