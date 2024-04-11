package accuweather.homeWorkSeminar3;

import io.restassured.http.Method;
import jdk.javadoc.doclet.Taglet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import location.Location ;
import weather.Weather ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

class ForecastsFiveDaysTest extends AccuweatherAbstractTest {

    @Test
    void testGetResponse() {
        Weather weather = given().queryParam("apikey", getApiKey()).pathParam("locationkey", 50)
                .when().get(getBaseUrl() + "/forecasts/v1/daily/5day/{locationkey}")
                .then().statusCode(200).time(lessThan(5000L))
                .extract().response().body().as(Weather.class);

        Assertions.assertEquals(5, weather.getDailyForecasts().size());
//        System.out.println(weather);
    }


    @Test
    void testgetLocations() {
        Map <String, String> mapQuery = new HashMap<>();

        mapQuery.put("apikey", getApiKey());
        mapQuery.put("q", "Samara");

        List <Location> list = given().queryParams(mapQuery)
                .when().get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then().statusCode(200)
                .extract().body().jsonPath().getList(".", Location.class);

        Assertions.assertAll(() -> Assertions.assertEquals(10, list.size()),
                () -> Assertions.assertEquals("Samarai", list.get(2).getLocalizedName()));
//        Assertions.assertEquals(10, list.size());
//        Assertions.assertEquals("Samari", list.get(2).getLocalizedName());

    }

    @Test
    void testgetLocations2() {
        Map<String, String> mapQuery = new HashMap<>();
        mapQuery.put("apikey", getApiKey());
        mapQuery.put("q", "Samara");
        List<Location> listLocations = given().queryParams(mapQuery)
                .when().request(Method.GET,getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then().statusCode(200)
                .extract().body().jsonPath().getList(".", Location.class);
        Assertions.assertAll(() -> Assertions.assertEquals(10, listLocations.size()),
                () -> Assertions.assertEquals("Samarai", listLocations.get(2).getLocalizedName()));

    }

}