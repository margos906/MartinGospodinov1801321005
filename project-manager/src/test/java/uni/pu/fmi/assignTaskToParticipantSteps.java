package uni.pu.fmi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.AssignTaskModel;
import uni.pu.fmi.services.ProjectManagementService;

public class assignTaskToParticipantSteps {

	public static ProjectManagementService projectManagementService = new ProjectManagementService();
	public static AssignTaskModel assignTaskModel = new AssignTaskModel(projectManagementService);
	
	@Given("^Потребителят е на екрана за възлагане на задача$")
	public void openAssignTaskScreen() throws Throwable {
	    assignTaskModel.openAssignTaskScreen();
	}

	@Given("^Потребителят има задача \"([^\"]*)\"$")
	public void createTask(String taskName) throws Throwable {
		if(projectManagementService.getTaskByName(taskName)==null) {
			projectManagementService.createTask(taskName);
		}
	}

	@Given("^Потребителят има участник с имена \"([^\"]*)\" \"([^\"]*)\"$")
	public void createParticipant(String firstName, String secondName) throws Throwable {
		if(projectManagementService.getParticipantByName(firstName,secondName)==null) {
		    projectManagementService.createParticipant(firstName, secondName);
		}
	}

	@When("^Потребителят избира задача \"([^\"]*)\"$")
	public void selectTask(String taskName) throws Throwable {
	    assignTaskModel.selectTask(taskName);
	}

	@When("^Потребителят избира участник \"([^\"]*)\" \"([^\"]*)\"$")
	public void selectParticipant(String firstName, String secondName) throws Throwable {
	    assignTaskModel.selectParticipant(firstName, secondName);
	}

	@When("^Потребителят натиска бутона и възлага задачата на участника$")
	public void clickAssignTask() throws Throwable {
	    assignTaskModel.assignTask();
	}

	@Then("^Задачата е била възложена на избрания участник$")
	public void checkTaskAssigned() throws Throwable {
		Task task = assignTaskModel.getSelectedTask();
	    Participant participant = assignTaskModel.getSelectedParticipant();
	    assertTrue(task.getAssignedTo().equals(participant));
	}

	@Then("^Броя на задачите на участника е \"([^\"]*)\"$")
	public void checkTasksAmount(String expectedTasksAmount) throws Throwable {
		Participant participant = assignTaskModel.getSelectedParticipant(); 
		int tasksSize = participant.getTasksToDo().size();
		int tasksExpected = Integer.parseInt(expectedTasksAmount);
		assertEquals(tasksExpected, tasksSize);
	}
}
