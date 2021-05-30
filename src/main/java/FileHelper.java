import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
     String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }

    public void writeFile(String json, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
