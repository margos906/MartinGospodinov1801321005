package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.ChangeTaskStatusModel;
import uni.pu.fmi.services.ProjectManagementService;

public class changeTaskStatusSteps {
	
	public static ProjectManagementService projectManagementService = new ProjectManagementService();
	public static ChangeTaskStatusModel changeTaskStatusModel = new ChangeTaskStatusModel(projectManagementService);
	
	@Given("^Потребителят има задача с име \"([^\"]*)\"$")
	public void createTask(String taskName) throws Throwable {
		if(projectManagementService.getTaskByName(taskName)==null) {
			projectManagementService.createTask(taskName);
		}
	}

	@Given("^Задачата \"([^\"]*)\" има статус \"([^\"]*)\"$")
	public void setTaskStatusTo(String taskName, String taskStatus) throws Throwable {
		projectManagementService.changeTaskStatus(taskName, taskStatus);
	    assertEquals(taskStatus, projectManagementService.getTaskStatus(taskName));
	}

	@When("^Потребителят избира задача с име \"([^\"]*)\"$")
	public void selectTask(String taskName) throws Throwable {
	    changeTaskStatusModel.selectTask(taskName);
	}

	@When("^Променя статуса на \"([^\"]*)\"$")
	public void updateStatus(String newStatus) throws Throwable {
	    changeTaskStatusModel.updateStatus(newStatus);
	}

	@Then("^Потребителят получава съобщение \"([^\"]*)\"$")
	public void receiveMessage(String expectedMessage) throws Throwable {
	    assertEquals(expectedMessage, changeTaskStatusModel.getMessage());
	}

	@Given("^Логърът няма запазени съобщения$")
	public void clearLoggerMessages() throws Throwable {
	    projectManagementService.clearLoggerMessages();
	}

	@Then("^Броя на съобщенията в логъра е \"([^\"]*)\"$")
	public void checkLoggerMessages(String expectedAmountString) throws Throwable {
	    int expectedAmount = Integer.parseInt(expectedAmountString);
	    int actualAmount = changeTaskStatusModel.getLoggerMessagesSize();
	    assertEquals(expectedAmount, actualAmount);
	}

}
