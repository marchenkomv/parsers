import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class CustomJsonParser {
    public List<Employee> parseJson(String json) {
        List<Employee> staff = new ArrayList<>();
        try {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(json);
            for (Object oneJson: jsonArray) {
                staff.add (new GsonBuilder().create()
                        .fromJson(oneJson.toString(), Employee.class));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public String listToJson(List<Employee> list) {
        return new GsonBuilder().create()
                .toJson(list, new TypeToken<List<Employee>>() {
                }.getType());
    }
}
