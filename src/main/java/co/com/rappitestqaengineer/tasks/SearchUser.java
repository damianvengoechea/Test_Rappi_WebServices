package co.com.rappitestqaengineer.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchUser implements Task {

    private int id;

    public SearchUser(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users/"+id+"")
        );
        lastResponse().print();
    }

    public static Performable info(int id) {
        return instrumented(SearchUser.class, id);
    }

}
