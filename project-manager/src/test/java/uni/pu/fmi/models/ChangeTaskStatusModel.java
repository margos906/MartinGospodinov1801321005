package uni.pu.fmi.models;

import uni.pu.fmi.Logger;
import uni.pu.fmi.Task;
import uni.pu.fmi.services.ProjectManagementService;

public class ChangeTaskStatusModel {

	private ProjectManagementService projectManagementService;
	private Task selectedTask;
	private Logger logger;
	private String message;
	
	public ChangeTaskStatusModel(ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
		this.logger = projectManagementService.getLogger();
	}

	public void openAssignTaskScreen() {
		
	}

	public void selectTask(String taskName) {
		selectedTask = projectManagementService.getTaskByName(taskName);
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void updateStatus(String newStatus) {
		this.message = projectManagementService.changeTaskStatus(selectedTask.getName(), newStatus);
	}

	public String getMessage() {
		return message;
	}

	public int getLoggerMessagesSize() {
		return logger.getLogMessages().size();
	}
}
