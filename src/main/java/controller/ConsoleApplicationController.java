package controller;

import java.util.Scanner;

public class ConsoleApplicationController {

    FileManagerController fileManagerController = new FileManagerController();

    public void chooseOptions() {
        Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Digite 1 para converter um novo arquivo ou digite 2 para excluir arquivos existentes");
            System.out.println();
            int option;
            do {
                System.out.println("Digite uma opção válida");
                System.out.print("#: ");
                option = input.nextInt();
            } while (option != 1 && option != 2);
            if (option == 1) {
                this.run();
            } else {
                fileManagerController.deleteFilesOption();
                System.out.println();
                System.out.println("Arquivos deletados com sucesso!");
           }
    }

    public void run() {
        fileManagerController.readFile(fileManagerController.getFilePath());
        fileManagerController.writeEachTeamsFile(fileManagerController.getURI_PATH_SAVE_TEAMS_FILE());
        fileManagerController.writeClassificationFile(fileManagerController.getURI_PATH_SAVE_CLASSIFICATION_FILE());
    }


}
