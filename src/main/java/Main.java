import entity.SoccerMatch;
import repository.SoccerMatchRepository;
import service.FileReaderService;

import java.time.LocalDate;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        SoccerMatchRepository repository = new SoccerMatchRepository();

        List<SoccerMatch> matches = fileReaderService.read("src/main/resources/brasileirao2020.csv");
        repository.addAll(matches);

        System.out.println(repository.getAllRegisters());
        System.out.println(LocalDate.parse("1995-10-12"));

    }
}
