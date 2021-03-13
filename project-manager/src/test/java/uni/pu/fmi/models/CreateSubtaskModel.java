package uni.pu.fmi.models;

import uni.pu.fmi.Task;
import uni.pu.fmi.services.ProjectManagementService;

public class CreateSubtaskModel {
	
	private ProjectManagementService projectManagementService;
	private Task selectedTask;
	private String subtaskName;
	
	public CreateSubtaskModel(ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	public void openAssignTaskScreen() {
		
	}

	public void selectMainTask(String taskName) {
		selectedTask = projectManagementService.getTaskByName(taskName);
	}
	
	public void createSubtask() {
		projectManagementService.createSubtask(subtaskName, selectedTask.getName());
	}

	public void setSubtaskName(String subtaskName) {
		this.subtaskName = subtaskName;
	}

	public int getSubtasksAmount() {
		int amountSubtasks = selectedTask.getSubtasks().size();
	    return amountSubtasks;
	}
}
