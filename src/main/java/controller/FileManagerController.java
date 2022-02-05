package controller;

import entity.SoccerMatch;
import entity.TeamBoard;
import exception.NotParsableLine;
import lombok.val;
import repository.SoccerMatchRepository;
import repository.TeamBoardRepository;
import service.FileReaderService;
import service.FileWriterService;

import java.io.File;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;


public class FileManagerController {

    private final String URI_SOURCE_FILE = "src/main/resources/santander811matchesResult.csv";
    private final String URI_PATH_SAVE_TEAMS_FILE = "src/main/resources/resultsByTeams/";
    private final String URI_PATH_SAVE_CLASSIFICATION_FILE = "src/main/resources/championshipStandings/";

    private final FileReaderService fileReaderService = new FileReaderService();
    private final FileWriterService fileWriterService = new FileWriterService();
    private final SoccerMatchRepository matchRepository = new SoccerMatchRepository();
    private final TeamBoardRepository teamBoardRepository = new TeamBoardRepository();

    public void run() {
        this.read(this.URI_SOURCE_FILE);
        this.fillsTeamTable();
        this.WriteEachTeamsFile();
        this.WriteClassificationFile();
        this.deleteFilesOption();
    }


    public void read(String path) {
        HashSet<SoccerMatch> matches = fileReaderService.read(path);
        this.matchRepository.addAll(matches);
    }

    public void fillsTeamTable() {
        val ordered = orderByDateAndName(matchRepository.getAllRegisters());
        val tableByClient = groupByClient(ordered);
        for (String key : tableByClient.keySet()) {
            TeamBoard board = new TeamBoard(key);
            for (SoccerMatch soccerMatch : tableByClient.get(key)) {
                board.add(soccerMatch);
            }
            this.teamBoardRepository.add(board);
        }
    }

    public void WriteEachTeamsFile() {
        teamBoardRepository.getAllBoards().forEach(
                value -> fileWriterService.writeTeamsFile(value, URI_PATH_SAVE_TEAMS_FILE)
        );
    }

    public void WriteClassificationFile() {
        val classification = orderByHighestPontuation(teamBoardRepository.getAllBoards());
        classification.forEach(
                board -> fileWriterService.writeBoard(board, URI_PATH_SAVE_CLASSIFICATION_FILE));
    }

    private TreeMap<String, List<SoccerMatch>> groupByClient(TreeSet<SoccerMatch> ordered) {
        return new TreeMap<>(
                ordered.stream().collect(groupingBy(match -> match.getClient().getName())));
    }


    private TreeSet<SoccerMatch> orderByDateAndName(HashSet<? extends SoccerMatch> toOrder) {
        return new TreeSet<>(toOrder);
    }

    private TreeSet<TeamBoard> orderByHighestPontuation(TreeSet<TeamBoard> toOrder) {
        TreeSet<TeamBoard> list = new TreeSet<>(Collections.reverseOrder());
        list.addAll(toOrder);
        return list;
    }

    private void deleteFilesOption() {
        Scanner input = new Scanner(System.in);
        System.out.println("digite 1 para apagar os arquivos ou 2 para finalizar");
        System.out.print("#: ");
        int option = input.nextInt();

        if (option == 1) {
            File[] classification = new File(URI_PATH_SAVE_CLASSIFICATION_FILE).listFiles();
            File[] teams = new File(URI_PATH_SAVE_TEAMS_FILE).listFiles();
            assert classification != null;
            for (File file : classification) {
                file.delete();
            }
            assert teams != null;
            for (File file : teams) {
                file.delete();
            }

        }

    }


}
