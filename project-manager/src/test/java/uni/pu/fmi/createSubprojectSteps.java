package uni.pu.fmi;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.pu.fmi.models.CreateSubprojectModel;
import uni.pu.fmi.services.ProjectManagementService;

public class createSubprojectSteps {
	
	public static ProjectManagementService projectManagementService = new ProjectManagementService();
	public static CreateSubprojectModel createSubprojectModel = new CreateSubprojectModel(projectManagementService);
	
	@Given("^Потребителят има проект \"([^\"]*)\" без подпроекти$")
	public void makeProjectWithoutSubprojects(String projectName) throws Throwable {
	    projectManagementService.createProject(projectName);
	    projectManagementService.removeSubprojects(projectName);
	}

	@When("^Потребителят избира главен проект \"([^\"]*)\"$")
	public void selectMainProject(String projectName) throws Throwable {
	    createSubprojectModel.selectMainProject(projectName);
	}

	@When("^Потребителят създава подпроект$")
	public void createSubproject() throws Throwable {
	    createSubprojectModel.createSubproject();
	}

	@When("^Потребителят задава име на подпроект \"([^\"]*)\"$")
	public void setSubprojectName(String subprojectName) throws Throwable {
	    createSubprojectModel.setSubprojectName(subprojectName);
	}

	@Then("^Проект \"([^\"]*)\" има \"([^\"]*)\" подпроекта$")
	public void checkSubprojectsAmount(String mainProjectName, String expectedAmount) throws Throwable {
		int expectedSubprojects = Integer.parseInt(expectedAmount);
	    assertEquals(expectedSubprojects, createSubprojectModel.getSubprojectsAmount());
	}
}
