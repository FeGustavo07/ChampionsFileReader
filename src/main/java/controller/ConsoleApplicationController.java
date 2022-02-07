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
                System.out.print("# ");
                option = input.nextInt();
            } while (option != 1 && option != 2);
            if (option == 1) {
                this.run();
                String op;
                do {
                    System.out.println("Deseja salvar os arquivos? S ou N");
                    System.out.print("# ");
                    op = input.next();
                } while (!op.equalsIgnoreCase("S") && !op.equalsIgnoreCase("N"));
                String path;
                if (op.equalsIgnoreCase("S")){
                    System.out.print("Digite o caminho do diretório que irá receber os arquivos: ");
                    input.nextLine();
                    path = input.nextLine();

                    fileManagerController.writeEachTeamsFile(path);
                    fileManagerController.writeClassificationFile(path);

                    System.out.println();
                    System.out.println("Arquivos salvos com sucesso!");
                } else {
                    System.out.println();
                }
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
