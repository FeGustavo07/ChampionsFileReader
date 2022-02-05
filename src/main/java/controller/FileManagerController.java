package controller;

import service.DataProcessing;
import java.io.File;
import java.util.*;

public class FileManagerController {

    DataProcessing data = new DataProcessing();

    public void run() {
        data.read(data.getURI_SOURCE_FILE());
        data.fillsTeamTable();
        data.WriteEachTeamsFile();
        data.WriteClassificationFile();
        this.deleteFilesOption();
    }

    private void deleteFilesOption() {
        Scanner input = new Scanner(System.in);
        System.out.println("digite 1 para apagar os arquivos ou 2 para finalizar");
        System.out.print("#: ");
        int option = input.nextInt();

        if (option == 1) {
            File[] classification = new File(data.getURI_PATH_SAVE_CLASSIFICATION_FILE()).listFiles();
            File[] teams = new File(data.getURI_PATH_SAVE_TEAMS_FILE()).listFiles();
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
