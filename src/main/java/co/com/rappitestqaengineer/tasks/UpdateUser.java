package co.com.rappitestqaengineer.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private String name;
    private String job;

    public UpdateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/2")
                .with(request -> request.header("Content-Type","application/json")
                  .body("{\n" +
                              "\"name\": \""+name+"\"," +
                              "\"job\":\""+job+"\""+
                          "}")
                )
         );
        lastResponse().print();
    }

    public static Performable info(String name, String job){
        return instrumented(UpdateUser.class,name,job);
    }
}
