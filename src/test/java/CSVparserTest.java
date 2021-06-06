import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CSVparserTest {
    private final static String TEST_FILE = "testFile.csv";
    private final static int FIRST = 0;
    private static FileHelper fileHelper = new FileHelper();

    @BeforeAll
    static void beforeAll() {
        fileHelper.createFile(TEST_FILE);
        fileHelper.writeFile("1,Ivan,Ivanov,Russia,30", TEST_FILE);
    }

    @AfterAll
    static void afterAll() {
        fileHelper.deleteFile(TEST_FILE);
    }

    @Test
    public void testParseCSV() {
        Employee expected = new Employee(1L, "Ivan", "Ivanov", "Russia", 30);
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        Employee actual = new CSVparser().parseCSV(columnMapping, TEST_FILE)
                .get(FIRST);
        Assertions.assertAll("check_all_class_fields",
                () -> Assertions.assertEquals(expected.getId(), actual.getId()),
                () -> Assertions.assertEquals(expected.getFirstName(), actual.getFirstName()),
                () -> Assertions.assertEquals(expected.getLastName(), actual.getLastName()),
                () -> Assertions.assertEquals(expected.getCountry(), actual.getCountry()),
                () -> Assertions.assertEquals(expected.getAge(), actual.getAge())
        );
    }
}