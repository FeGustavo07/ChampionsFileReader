import com.fileManager.FileWriter;
import entity.SoccerMatch;
import repository.SoccerMatchRepository;
import service.FileReaderService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Main {


    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        SoccerMatchRepository repository = new SoccerMatchRepository();

        List<SoccerMatch> matches = fileReaderService.read("src/main/resources/brasileirao2020.csv");
        repository.addAll(matches);


        // Ordenação da lista
        repository.getAllRegisters().sort(
                Comparator.comparing(SoccerMatch::getDate)
                        .thenComparing(SoccerMatch::getOpponent)
        );

        // Separação por times
        ArrayList<SoccerMatch> table = new ArrayList<>(repository.getAllRegisters());

        Map<String, List<SoccerMatch>> tableByClient = table.stream().collect(groupingBy(SoccerMatch::getClient));

//        tPorClient.forEach((team, history) -> {
//            System.out.println();
//            System.out.println("Team: " + team);
//            System.out.println();
//            for (SoccerMatch match : history) {
//                System.out.println(match);
//            }
//        });

        // Criando lista do time
        List<SoccerMatch> corinthians = tableByClient.get("Corinthians");

        System.out.println(corinthians);

//        System.out.println(repository.getAllRegisters());
//        System.out.println(LocalDate.parse("1995-10-12"));

    }
}
