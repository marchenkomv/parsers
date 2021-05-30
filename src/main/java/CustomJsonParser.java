import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class CustomJsonParser {
    public List<Employee> listFromJson(String json) {
        return new GsonBuilder().create()
                .fromJson(json, new TypeToken<List<Employee>>(){}.getType());
    }

    public String listToJson(List<Employee> list) {
        return new GsonBuilder().create()
                .toJson(list, new TypeToken<List<Employee>>(){}.getType());
    }
}
