package repository;

import entity.TeamTable;
import lombok.Getter;

import java.util.TreeSet;


public class TeamTableRepository {
    @Getter
    private final TreeSet<TeamTable> allTables = new TreeSet<>();

    public void add(TeamTable board) {
        this.allTables.add(board);
    }
}
