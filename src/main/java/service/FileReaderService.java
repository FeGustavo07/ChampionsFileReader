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
        val fileResult = fileReader.readFileWithTemplate(template, uri);
        HashSet<SoccerMatch> listResult = new HashSet<>();

        for (SoccerMatchDTO dto : fileResult) {
            try {
                SoccerMatch match = dtoToEntity(dto);
                listResult.add(match);
            } catch (NumberFormatException e) {
                NotParsableLine error = new NotParsableLine("Line not Parsable");
                System.err.println(error.getMessage());
                error.getErrorMessage();
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }
        return listResult;
    }

    private SoccerMatch dtoToEntity(SoccerMatchDTO dto) {
        return SoccerMatch.builder()
                .clientName(dto.getClientName())
                .clientScore(Integer.parseInt(dto.getClientScore()))
                .opponentName(dto.getOpponentName())
                .opponentScore(Integer.parseInt(dto.getOpponentScore()))
                .date(LocalDate.parse(dto.getDate()))
                .build();
    }
}
