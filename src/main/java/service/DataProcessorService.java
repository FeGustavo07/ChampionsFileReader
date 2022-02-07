package service;


import entity.SoccerMatch;
import entity.TeamTable;
import enums.SoccerPontuationRules;
import lombok.val;
import repository.SoccerMatchRepository;
import repository.TeamTableRepository;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;


public class DataProcessorService {

    private final FileReaderService fileReaderService = new FileReaderService();
    private final FileWriterService fileWriterService = new FileWriterService();

    private final SoccerMatchRepository matchRepository = new SoccerMatchRepository();
    private final TeamTableRepository teamTableRepository = new TeamTableRepository();


    public void read(String path) {
        HashSet<SoccerMatch> matches = fileReaderService.read(path);
        this.matchRepository.addAll(matches);
        this.fillsTeamTable();
        setResults();
    }


    public void WriteEachTeamsFile(String uri) {
        teamTableRepository.getAllTables().forEach(
                value -> fileWriterService.writeTeamsFile(value, uri)
        );
    }

    public void WriteClassificationFile(String uri) {
        val classification = orderByHighestPontuation(teamTableRepository.getAllTables());
        classification.forEach(
                board -> fileWriterService.writeTable(board, uri));
    }

    private void fillsTeamTable() {
        val ordered = orderByDateAndName(matchRepository.getAllMatches());
        val tableByClient = groupByClient(ordered);
        for (String key : tableByClient.keySet()) {
            TeamTable board = new TeamTable(key);
            for (SoccerMatch soccerMatch : tableByClient.get(key)) {
                board.add(soccerMatch);
            }
            this.teamTableRepository.add(board);
        }
    }

    private void setResults() {
        HashSet<SoccerMatch> allMatches = this.matchRepository.getAllMatches();
        TreeSet<TeamTable> allBoards = teamTableRepository.getAllTables();

        allMatches.forEach(
                match -> {

                    Integer clientScore = match.getClientScore();
                    Integer opponentScore = match.getOpponentScore();

                    TeamTable clientTable = new TeamTable();
                    TeamTable opponentTable = new TeamTable();

                    for (TeamTable table : allBoards) {
                        if (Objects.equals(table.getName(), match.getClientName())) {
                            clientTable = table;
                        }
                        if (Objects.equals(table.getName(), match.getOpponentName())) {
                            opponentTable = table;
                        }
                    }
                    int clientResult = clientScore.compareTo(opponentScore);
                    int opponentResult = opponentScore.compareTo(clientScore);

                    SoccerPontuationRules.getEnumTypeBy(clientResult)
                            .setResult(clientTable);

                    SoccerPontuationRules.getEnumTypeBy(opponentResult)
                            .setResult(opponentTable);
                }
        );
    }

    private TreeMap<String, List<SoccerMatch>> groupByClient(TreeSet<SoccerMatch> listToOrder) {
        return new TreeMap<>(
                listToOrder.stream().collect(groupingBy(SoccerMatch::getClientName)));
    }


    private TreeSet<SoccerMatch> orderByDateAndName(HashSet<SoccerMatch> toOrder) {
        return new TreeSet<>(toOrder);
    }

    private TreeSet<TeamTable> orderByHighestPontuation(TreeSet<TeamTable> toOrder) {
        TreeSet<TeamTable> list = new TreeSet<>(Collections.reverseOrder());
        list.addAll(toOrder);
        return list;
    }


}
