package uni.pu.fmi.models;

import uni.pu.fmi.Project;
import uni.pu.fmi.services.ProjectManagementService;

public class CreateSubprojectModel {

	private ProjectManagementService projectManagementService;
	private Project selectedProject;
	private String subprojectName;
	
	public CreateSubprojectModel(ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	public void openAssignTaskScreen() {
		
	}

	public void selectMainProject(String projectName) {
		selectedProject = projectManagementService.getProjectByName(projectName);
	}
	
	public void createSubproject() {
		projectManagementService.createSubproject(subprojectName, selectedProject.getName());
	}

	public void setSubprojectName(String subprojectName) {
		this.subprojectName = subprojectName;
	}

	public int getSubprojectsAmount() {
		int amountSubprojects = selectedProject.getSubprojects().size();
	    return amountSubprojects;
	}
}
