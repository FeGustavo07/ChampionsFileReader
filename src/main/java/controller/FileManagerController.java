package controller;

import service.DataProcessorService;

import java.io.File;
import java.util.Scanner;

public class FileManagerController {

    private final String URI_SOURCE_FILE = "src/main/resources/matchesResult.csv";
    private final String URI_PATH_SAVE_TEAMS_FILE = "src/main/resources/resultsByTeams/";
    private final String URI_PATH_SAVE_CLASSIFICATION_FILE = "src/main/resources/championshipStandings/";

    private final DataProcessorService data = new DataProcessorService();

    public void run() {
        readFile(URI_SOURCE_FILE);
        writeEachTeamsFile(URI_PATH_SAVE_TEAMS_FILE);
        writeClassificationFile(URI_PATH_SAVE_CLASSIFICATION_FILE);
        this.deleteFilesOption();
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


    private void deleteFilesOption() {
        Scanner input = new Scanner(System.in);
        System.out.println("digite 1 para apagar os arquivos ou 2 para finalizar");
        System.out.print("#: ");
        int option = input.nextInt();

        if (option == 1) {
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


}
