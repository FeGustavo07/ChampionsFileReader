package service;

import com.fileManager.FileWriter;
import entity.SoccerMatch;
import entity.TeamTable;

import java.util.ArrayList;

public class FileWriterService {
    private final FileWriter writer = new FileWriter();

    public void writeTeamsFile(TeamTable table, String baseUri) {
        String fileType = ".txt";
        ArrayList<String> toWrite = new ArrayList<>();
        String fileName = String.format("%s%s%s", baseUri, table.getName(), fileType);

        for (SoccerMatch match : table.getMatches()) {
            String message = buildLine(match);
            toWrite.add(message);
        }

        writer.writeSeparateTeams(toWrite, fileName, baseUri);
    }

    private String buildLine(SoccerMatch match) {
        return String.format("%s;%s;%d;%d;%s",
                match.getClientName(),
                match.getOpponentName(),
                match.getClientScore(),
                match.getOpponentScore(),
                match.getDate().toString()
        );
    }

    public void writeTable(TeamTable board, String path) {
        String uri = path + "classification.txt";
        writer.writeChampionshipStandings(board.getformatedTextResult(), uri, path);
    }
}