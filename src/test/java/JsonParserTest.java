import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonParserTest {
    private final static int FIRST = 0;

    @Test
    void employeeFromJsonTest() {
        String json = "[{\"id\":1,\"firstName\":\"Ivan\",\"lastName\":\"Ivanov\",\"country\":\"Russia\",\"age\":30}]";
        Employee expected = new Employee(1L, "Ivan", "Ivanov", "Russia", 30);
        Employee actual = new CustomJsonParser().listFromJson(json)
                .get(FIRST);
        Assertions.assertAll("check_all_class_field",
                () -> Assertions.assertEquals(expected.getId(), actual.getId()),
                () -> Assertions.assertEquals(expected.getFirstName(), actual.getFirstName()),
                () -> Assertions.assertEquals(expected.getLastName(), actual.getLastName()),
                () -> Assertions.assertEquals(expected.getCountry(), actual.getCountry()),
                () -> Assertions.assertEquals(expected.getAge(), actual.getAge())
        );
    }

    @Test
    void employeeToJsonTest() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1L, "Ivan", "Ivanov", "Russia", 30));
        String expected = "[{\"id\":1,\"firstName\":\"Ivan\",\"lastName\":\"Ivanov\",\"country\":\"Russia\",\"age\":30}]";
        String actual = new CustomJsonParser().listToJson(employeeList);
        Assertions.assertEquals(expected, actual);
    }
}