package co.com.rappitestqaengineer.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Update implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        JsonPath responseBody = new JsonPath(lastResponse().asString());
        String value = responseBody.get("job").toString();
        int statusCode = lastResponse().getStatusCode();
        if (statusCode == 200) {
            return value;
        }
        return null;
    }

    public static Update ok(){
        return new Update();
    }
}
