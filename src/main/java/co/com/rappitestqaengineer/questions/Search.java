package co.com.rappitestqaengineer.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Search implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        JsonPath responseBody = new JsonPath(lastResponse().asString());
        String value = responseBody.get("data.email").toString();
        int statusCode = lastResponse().getStatusCode();
        if (statusCode == 200){
            return value;
        }
        return null;
    }

    public static Search ok(){
        return new Search();
    }
}
