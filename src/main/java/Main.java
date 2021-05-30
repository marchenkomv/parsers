import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileHelper fileHelper = new FileHelper();
        CustomJsonParser jsonParser = new CustomJsonParser();
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String jsonFile = "data.json";
        List<Employee> csvList = new CSVparser().parseCSV(columnMapping, "data.csv");
        String jsonFromCsv = jsonParser.listToJson(csvList);
        fileHelper.writeFile(jsonFromCsv, jsonFile);

        List<Employee> xmlList = new XMLparser().parseXML("data.xml");
        String jsonFromXml = jsonParser.listToJson(xmlList);
        fileHelper.writeFile(jsonFromXml, "data2.json");

        String json = fileHelper.readFile(jsonFile);
        for (Employee employee : jsonParser.parseJson(json)) {
            System.out.println(employee);
        }
    }
}
