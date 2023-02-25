package utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class utils {

    public static void doScroll(WebDriver driver, int heightPixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+heightPixel+")");
    }

    public static void waitForElement(WebDriver driver, WebElement webElement, int timeunit_sec){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeunit_sec));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static int generateRandomNumber(int min, int max){
        return  (int) Math.round(Math.random()*(max-min)+min);
    }
    public static void addJsonArray(String firstName, String lastName,String emp_id, String username, String password) throws IOException, ParseException {
        String fileName="./src/test/resources/UsersInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject userObj = new JSONObject();
        JSONArray jsonArray = (JSONArray) obj;
        userObj.put("firstname",firstName);
        userObj.put("lastname",lastName);
        userObj.put("empId",emp_id);
        userObj.put("username",username);
        userObj.put("password",password);
        jsonArray.add(userObj);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }
    public static String readJSONArray(int pos) throws IOException, ParseException {
        String fileName="./src/test/resources/UsersInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(pos);
        String empId = (String) json.get("empId");
        String firstname = (String) json.get("firstname");
        String lastname = (String) json.get("lastname");
        String fullname=firstname+" "+lastname;
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        return fullname;
    }
    public static String readJSONArray1(int pos) throws IOException, ParseException {
        String fileName="./src/test/resources/UsersInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(pos);
        String empId = (String) json.get("empId");
        String firstname = (String) json.get("firstname");
        String lastname = (String) json.get("lastname");
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        return empId;
    }
    public static String readUserName(int pos) throws IOException, ParseException {
        String fileName="./src/test/resources/UsersInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(pos);
        String empId = (String) json.get("empId");
        String firstname = (String) json.get("firstname");
        String lastname = (String) json.get("lastname");
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        return username;
    }
    public static String readPassword(int pos) throws IOException, ParseException {
        String fileName="./src/test/resources/UsersInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject json = (JSONObject) jsonArray.get(pos);
        String empId = (String) json.get("empId");
        String firstname = (String) json.get("firstname");
        String lastname = (String) json.get("lastname");
        String username = (String) json.get("username");
        String password = (String) json.get("password");
        return password;
    }
    public static void updateJSONList(int index, String key, String value) throws IOException, ParseException {
        String fileName="./src/test/resources/UsersInfo.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        jsonObject.put(key, value);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }


    public static void main(String args[]){
        System.out.println();
    }


}
