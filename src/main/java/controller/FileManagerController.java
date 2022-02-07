package controller;

import lombok.Getter;
import service.DataProcessorService;
import java.io.File;
import java.util.Scanner;

@Getter
public class FileManagerController {

    private final String URI_PATH_SAVE_TEAMS_FILE = "src/main/resources/resultsByTeams/";
    private final String URI_PATH_SAVE_CLASSIFICATION_FILE = "src/main/resources/championshipStandings/";

    private final DataProcessorService data = new DataProcessorService();


    public String getFilePath() {
        String path;
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Digite o caminho do arquivo: ");
        path = input.nextLine();
        return path;
    }

    public void readFile(String path) {
        this.data.read(path);
    }

    public void writeEachTeamsFile(String uri) {
        data.WriteEachTeamsFile(uri);
    }

    public void writeClassificationFile(String uri) {
        data.WriteClassificationFile(uri);
    }

    public void deleteFilesOption() {
            File[] classification = new File(URI_PATH_SAVE_CLASSIFICATION_FILE).listFiles();
            File[] teams = new File(URI_PATH_SAVE_TEAMS_FILE).listFiles();
            assert classification != null;
            for (File file : classification) {
                file.delete();
            }
            assert teams != null;
            for (File file : teams) {
                file.delete();
            }

        }

    }

