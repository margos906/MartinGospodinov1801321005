package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.CreateSubtaskModel;
import uni.pu.fmi.services.ProjectManagementService;

public class createSubtaskSteps {

	public static ProjectManagementService projectManagementService = new ProjectManagementService();
	public static CreateSubtaskModel createSubtaskModel = new CreateSubtaskModel(projectManagementService);
	
	@Given("^Потребителят има задача \"([^\"]*)\" без подзадачи$")
	public void makeTaskWithoutSubtasks(String taskName) throws Throwable {
	    projectManagementService.createTask(taskName);
	    projectManagementService.removeSubtasks(taskName);
	}

	@When("^Потребителят избира главна задача \"([^\"]*)\"$")
	public void selectMainTask(String taskName) throws Throwable {
		createSubtaskModel.selectMainTask(taskName);
	}

	@When("^Потребителят задава име на подзадача \"([^\"]*)\"$")
	public void setSubtaskName(String subtaskName) throws Throwable {
	    createSubtaskModel.setSubtaskName(subtaskName);
	}

	@When("^Потребителят създава подзадача$")
	public void createSubtask() throws Throwable {
	    createSubtaskModel.createSubtask();
	}

	@Then("^Задача \"([^\"]*)\" има \"([^\"]*)\" подзадачи$")
	public void checkSubtasksAmount(String taskName, String expectedAmount) throws Throwable {
		int expectedSubtasks = Integer.parseInt(expectedAmount);
		createSubtaskModel.selectMainTask(taskName);
	    assertEquals(expectedSubtasks, createSubtaskModel.getSubtasksAmount());
	}

}
