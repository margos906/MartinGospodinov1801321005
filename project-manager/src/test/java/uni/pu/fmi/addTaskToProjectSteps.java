package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.CreateTaskModel;
import uni.pu.fmi.services.ProjectManagementService;

public class addTaskToProjectSteps {
	
	public static ProjectManagementService projectManagementService = new ProjectManagementService();
	public static CreateTaskModel createTaskModel = new CreateTaskModel(projectManagementService);
	
	@Given("^Потребителят е на екрана за създаване на задача$")
	public void openTaskCreationScreen() throws Throwable {
	    createTaskModel.openTaskCreationScreen();
	}

	@Given("^Потребителят има проект \"([^\"]*)\"$")
	public void createProject(String projectName) throws Throwable {
	    projectManagementService.createProject(projectName);
	    createTaskModel.selectProject(projectName);
	}

	@When("^Потребителят премахва всички задачи$")
	public void removeTasksInProject() throws Throwable {
	    createTaskModel.removeTasksInSelectedProject();
	}

	@When("^Потребителят въвежда име на задача \"([^\"]*)\"$")
	public void inputTaskName(String taskName) throws Throwable {
	    createTaskModel.inputTaskName(taskName);
	}

	@When("^Потребителят въвежда име на проект \"([^\"]*)\" в който да е задачата$")
	public void inputProjectName(String projectName) throws Throwable {
	    createTaskModel.inputProjectName(projectName);
	}

	@When("^Натиска бутона за създаване на задача$")
	public void createTask() throws Throwable {
	    createTaskModel.clickCreateTaskButton();
	}

	@Then("^Броя задачите в проекта е \"([^\"]*)\"$")
	public void checkTasksAmount(String expectedAmount) throws Throwable {
		int expectedTasksAmount = Integer.parseInt(expectedAmount);
	    int actualAmount = createTaskModel.getTasksAmountInProject();
	    assertEquals(expectedTasksAmount, actualAmount);
	}
}
