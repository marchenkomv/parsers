import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XMLparserTest {
    private final static String TEST_FILE = "testFile.xml";
    private final static int FIRST = 0;
    private static FileHelper fileHelper = new FileHelper();

    @BeforeAll
    static void beforeAll() {
        fileHelper.createFile(TEST_FILE);
        String fileText = "<staff>\n" +
                "    <employee>\n" +
                "        <id>1</id>\n" +
                "        <firstName>Ivan</firstName>\n" +
                "        <lastName>Ivanov</lastName>\n" +
                "        <country>Russia</country>\n" +
                "        <age>30</age>\n" +
                "    </employee>\n" +
                "</staff>";
        fileHelper.writeFile(fileText, TEST_FILE);
    }

    @AfterAll
    static void afterAll() {
        fileHelper.deleteFile(TEST_FILE);
    }

    @Test
    public void testParseXML() {
        Employee expected = new Employee(1L, "Ivan", "Ivanov", "Russia", 30);
        Employee actual = new XMLparser().parseXML(TEST_FILE)
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