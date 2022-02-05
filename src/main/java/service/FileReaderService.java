package service;

import com.fileManager.FileReader;
import entity.SoccerMatch;
import exception.NotParsableLine;
import lombok.Getter;
import lombok.val;
import java.time.LocalDate;
import java.util.HashSet;


@Getter
public class FileReaderService {

    private final FileReader fileReader = new FileReader();

    public HashSet<SoccerMatch> read(String uri) {
        val fileResult = fileReader.handleFile(uri);
        HashSet<SoccerMatch> listResult = new HashSet<>();

        for (String[] line : fileResult) {
            try {
                SoccerMatch match = SoccerMatch.builder()
                        .client(line[0], Integer.parseInt(line[2]))
                        .opponent(line[1], Integer.parseInt(line[3]))
                        .date(LocalDate.parse(line[4]))//, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        .build();
                listResult.add(match);
            } catch (NumberFormatException e) {
                NotParsableLine error = new NotParsableLine("Line not Parsable");
                error.getErrorMessage();
            }

        }
        return listResult;
    }
}
