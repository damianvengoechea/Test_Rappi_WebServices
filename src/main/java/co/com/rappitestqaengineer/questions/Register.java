package co.com.rappitestqaengineer.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Register implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        JsonPath responseBody = new JsonPath(lastResponse().asString());
        String value = responseBody.get("token").toString();
        int statusCode = lastResponse().getStatusCode();
            if (statusCode == 200) {
                return value;
            }
        return null;
    }

    public static Register ok(){
        return new Register();
    }
}
