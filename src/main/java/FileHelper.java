import java.io.*;

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

    public void writeFile(String text, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName) {
        try {
            new File(fileName).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        new File(fileName).delete();
    }
}