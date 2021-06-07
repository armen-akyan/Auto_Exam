package Helpers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.openqa.selenium.JavascriptExecutor;
import setup.DriverSetUp;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ApiHelper {
    private static String generatedUsername = UUID.randomUUID().toString();
    private static String image_url = System.getProperty("user.dir") + File.separator + "src/main/picsArt.jpeg";
    private static String hashtag = "#test_pic";

    public static JsonObject createUser() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        //Request request = ((JavascriptExecutor) DriverSetUp.getDriver()).executeScript("window.localStorage.setItem('token','" + loginJson.get("auth_token") + "');");
        //((JavascriptExecutor) DriverSetUp.getDriver()).executeScript("window.localStorage.setItem('userInfo','" + loginJson + "');");
        //Response response = client.newCall(request).execute();
        //String jsonString = response.body().string();
        //return JsonParser.parseString(jsonString).getAsJsonObject();
        return null;
    }






}
