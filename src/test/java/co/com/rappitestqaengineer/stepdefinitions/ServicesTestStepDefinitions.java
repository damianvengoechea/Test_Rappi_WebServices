package co.com.rappitestqaengineer.stepdefinitions;

import co.com.rappitestqaengineer.questions.Register;
import co.com.rappitestqaengineer.questions.Search;
import co.com.rappitestqaengineer.questions.Update;
import co.com.rappitestqaengineer.tasks.RegisterUser;
import co.com.rappitestqaengineer.tasks.SearchUser;
import co.com.rappitestqaengineer.tasks.UpdateUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ServicesTestStepDefinitions {

    private Actor damian = Actor.named("Damian");
    @Before
    public void prepareScenario(){
        damian.whoCan(CallAnApi.at("https://reqres.in"));
    }

    @When("^Damian registers on the page with (.*) and with password (.*)$")
    public void damianRegistersOnThePageEveHoltReqresInAndWithPasswordPistol(String mail, String pass) {
        damian.attemptsTo(RegisterUser.withData(mail, pass));
    }

    @Then("^user successfully created with token (.*)$")
    public void userSuccessfullyCreated(String token) {
        damian.should(seeThat("The token is", Register.ok(), equalTo(token)));
    }

    @When("^Damian performs an update with Name (.*) and Job (.*)$")
    public void damianPerformsAnUpdateWithNameDamianAndJobQAutomation(String name, String job) {
        damian.attemptsTo(UpdateUser.info(name, job));
    }

    @Then("^he see response update job (.*)$")
    public void heSeeResponseUpdate(String job) {
        damian.should(seeThat("The job is", Update.ok(),equalTo(job)));
    }

    @When("^Damian search a single user with (\\d+)$")
    public void damianSearchASingleUserWith(int id) {
        damian.attemptsTo(SearchUser.info(id));
    }


    @Then("^he should see the register the (.*)$")
    public void heShouldSeeTheRegisterTheJanetWeaverReqresIn(String mail) {
        damian.should(seeThat(Search.ok(),equalTo(mail)));
    }




}
