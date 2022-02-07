package controller;

import java.io.File;
import java.util.Scanner;

import static utils.ConsoleWriteUtils.*;

public class ConsoleApplicationController {

    private final String URI_PATH_SAVE_TEAMS_FILE = "src/main/resources/resultsByTeams/";
    private final String URI_PATH_SAVE_CLASSIFICATION_FILE = "src/main/resources/championshipStandings/";

    FileManagerController fileManagerController = new FileManagerController();

    public void chooseOptions() {
        Scanner input = new Scanner(System.in);
        requestInitialOption();
        int option;
        do {
            requestAValidOption();
            option = input.nextInt();
        } while (option != 1 && option != 2);
        if (option == 1) {
            this.run();
            String saveOrNot;
            do {
                requestSaveOrNot();
                saveOrNot = input.next();
            } while (!saveOrNot.equalsIgnoreCase("S") && !saveOrNot.equalsIgnoreCase("N"));
            String path;
            if (saveOrNot.equalsIgnoreCase("S")) {
                requestPathToSave();
                input.nextLine();
                path = input.nextLine();

                fileManagerController.writeEachTeamsFile(path);
                fileManagerController.writeClassificationFile(path);

                succesWriteMessage();
            } else {
                System.out.println();
            }
        } else {
            deleteFilesOption();
            succesDeletedFilesSucessMessage();
        }
    }


    public void run() {
        fileManagerController.readFile(getFilePath());
        fileManagerController.writeEachTeamsFile(URI_PATH_SAVE_TEAMS_FILE);
        fileManagerController.writeClassificationFile(URI_PATH_SAVE_CLASSIFICATION_FILE);
    }

    private String getFilePath() {
        String path;
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Digite o caminho do arquivo: ");
        path = input.nextLine();
        return path;
    }

    public void deleteFilesOption() {
        File[] classification = new File(URI_PATH_SAVE_CLASSIFICATION_FILE).listFiles();
        File[] teams = new File(URI_PATH_SAVE_TEAMS_FILE).listFiles();

        assert classification != null;
        for (File file : classification) {
            boolean delete = file.delete();
            if (delete) {
                System.out.println(file.getName() + " File was deleted");
            }
        }

        assert teams != null;
        for (File file : teams) {
            boolean delete = file.delete();
            if (delete) {
                System.out.println(file.getName() + " File was deleted");
            }
        }

    }

}


