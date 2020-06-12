package co.com.rappitestqaengineer.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private String mail;
    private String pass;

    public RegisterUser(String mail, String pass) {
        this.mail = mail;
        this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/register")
                        .with(request -> request.header("Content-Type","application/json")
                                .body("{\n" +
                                        "\"email\": \""+mail+"\"," +
                                        "\"password\":\""+pass+"\""+
                                        "}")
                        )
        );
        lastResponse().print();
    }

    public static Performable withData(String mail, String pass){
        return instrumented(RegisterUser.class, mail, pass);
    }

}
