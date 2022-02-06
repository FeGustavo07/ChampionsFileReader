package service;

import com.fileManager.FileReader;
import dto.SoccerMatchDTO;
import entity.SoccerMatch;
import exception.NotParsableLine;
import lombok.Getter;
import lombok.val;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;


@Getter
public class FileReaderService {

    private final FileReader fileReader = new FileReader();

    public HashSet<SoccerMatch> read(String uri) {
        SoccerMatchDTO template = new SoccerMatchDTO();
        val fileResult = fileReader.readFileWithTemplate(template,uri);
        HashSet<SoccerMatch> listResult = new HashSet<>();

        for (SoccerMatchDTO dto : fileResult) {
            try {
                SoccerMatch match = SoccerMatch.builder()
                        .client(dto.getClientName(), Integer.parseInt(dto.getClientScore()))
                        .opponent(dto.getOpponentName(), Integer.parseInt(dto.getOpponentScore()))
                        .date(LocalDate.parse(dto.getDate()))
                        .build();
                listResult.add(match);

            } catch (NumberFormatException e) {
                NotParsableLine error = new NotParsableLine("Line not Parsable");
                error.getErrorMessage();
            } catch (DateTimeParseException e) {
                NotParsableLine date = new NotParsableLine("Date Format");
                date.getErrorMessage();
            }

        }
        return listResult;
    }
}
