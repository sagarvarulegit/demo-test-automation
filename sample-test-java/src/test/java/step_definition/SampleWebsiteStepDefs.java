package step_definition;

import config.World;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SampleWebsiteStepDefs {

  private final World world;

  public SampleWebsiteStepDefs(World world) {
    this.world = world;
  }

  @When("I login with valid credentials")
  public void iLoginWithValidCredentials() {
    world
        .getLoginPO()
        .loginToApp(
            world.getTestData().get("username").toString(),
            world.getTestData().get("password").toString());
  }

  @Then("I should message {string}")
  public void iShouldMessage(String expect_msg) {
    Assert.assertEquals(expect_msg, world.getLoginPO().getMessage());
  }

  @When("I login with invalid credentials")
  public void iLoginWithInvalidCredentials() {
    world
        .getLoginPO()
        .loginToApp(
            world.getTestData().get("username").toString(),
            world.getTestData().get("password").toString());
  }

  @Given("I get data from Example")
  public void iGetDataFromExample(DataTable dataTable) {
    System.out.println("check this");
  }
}
