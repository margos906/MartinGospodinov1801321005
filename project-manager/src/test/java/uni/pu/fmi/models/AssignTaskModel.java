package uni.pu.fmi.models;

import uni.pu.fmi.Participant;
import uni.pu.fmi.Task;
import uni.pu.fmi.services.ProjectManagementService;

public class AssignTaskModel {

	private ProjectManagementService projectManagementService;
	private Task selectedTask;
	private Participant selectedParticipant;
	
	public AssignTaskModel(ProjectManagementService projectManagementService) {
		this.projectManagementService = projectManagementService;
	}

	public void openAssignTaskScreen() {
		
	}

	public void selectTask(String taskName) {
		selectedTask = projectManagementService.getTaskByName(taskName);
	}

	public void selectParticipant(String firstName, String secondName) {
		selectedParticipant = projectManagementService.getParticipantByName(firstName, secondName);
	}

	public void assignTask() {
		projectManagementService.assignTaskToParticipant(selectedTask.getName(), selectedParticipant.getFirstName(), selectedParticipant.getSecondName());
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public Participant getSelectedParticipant() {
		return selectedParticipant;
	}
}
