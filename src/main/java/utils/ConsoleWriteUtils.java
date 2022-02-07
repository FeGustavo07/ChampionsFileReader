package utils;

public class ConsoleWriteUtils {
    private ConsoleWriteUtils() throws Exception {
        throw new Exception("this class cannot be instantiated");
    }

    public static void succesDeletedFilesSucessMessage() {
        System.out.println();
        System.out.println("Arquivos deletados com sucesso!");
    }

    public static void succesWriteMessage() {
        System.out.println();
        System.out.println("Arquivos salvos com sucesso!");
    }

    public static void requestPathToSave() {
        System.out.print("Digite o caminho do diretório que irá receber os arquivos: ");
    }

    public static void requestSaveOrNot() {
        System.out.println("Deseja salvar os arquivos? S ou N");
        System.out.print("#: ");
    }

    public static void requestAValidOption() {
        System.out.println("Digite uma opção válida");
        System.out.print("#: ");
    }

    public static void requestInitialOption() {
        System.out.println();
        System.out.println("Digite 1 para converter um novo arquivo ou digite 2 para excluir arquivos existentes");
        System.out.println();
    }
}
