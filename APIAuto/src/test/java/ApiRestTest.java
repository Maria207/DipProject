import org.junit.Before;
import io.restassured.RestAssured;

public class ApiRestTest {

    private static final String BASE_URL = "http://www.wkda.de/papi/";
    private static final String BASE_SERVICE = "/v1/car-types";

    protected static final String MANUFACTURE = BASE_SERVICE + "/manufacturer";
    protected static final String MAIN_TYPES_ENDPOINT = BASE_SERVICE + "/main-types?manufacturer={manufacturer}";
    protected static final String BUILT_DATES = BASE_SERVICE + "/built-dates?manufacturer={manufacturer}&main-type={mainType}";
    protected static final String MANUFACTURER_DETAILS = BASE_SERVICE + "/main-types-details?manufacturer={manufacturer}&main-type={mainType}&built-date={builtYear}&body-type={bodyType}";

    protected static final String MANUFACTURER_KEY = "manufacturer";
    protected static final String MANUFACTURER_DEFAULT_VALUE = "107";
    protected static final String MAIN_TYPE_KEY = "main-type";
    protected static final String MAIN_TYPE_DEFAULT_VALUE = "Bentley";

    protected static final int HTTP_OK = 200;











}
