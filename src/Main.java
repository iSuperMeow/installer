import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder log = new StringBuilder();
//        S:\Games
        List<String> names = Arrays.asList("src", "res", "savegames", "temp");
        List<String> src = Arrays.asList("main", "test");
        List<String> mainsFile = Arrays.asList("Main.java", "Utils.java");
        List<String> resDirs = Arrays.asList("drawables", "vectors", "icons");
        List<String> tempsFile = Arrays.asList("temp.txt");

        names.stream().forEach(s -> {
            new File("S:\\Games\\" + s).mkdir();
            log.append("Создана дирректория " + s + "\n");
        });
        src.stream().forEach(s -> {
            new File("S:\\Games\\src\\" + s).mkdir();
            log.append("Создана дирректория " + s + "\n");

        });

        mainsFile.stream().forEach(s -> {
            try {
                new File("S:\\Games\\src\\main", s).createNewFile();
                log.append("Создан файл " + s + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        resDirs.stream().forEach(s -> {
            new File("S:\\Games\\res\\" + s).mkdir();
            log.append("Создана дирректория " + s + "\n");

        });
        tempsFile.stream().forEach(s -> {
            try {
                new File("S:\\Games\\temp", s).createNewFile();
                log.append("Создан файл " + s + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        FileWriter fw = new FileWriter("S:\\Games\\temp\\temp.txt", false);
        fw.write(log.toString());
        fw.flush();    }
}