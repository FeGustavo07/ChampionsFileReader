package repository;

import entity.TeamBoard;
import lombok.Getter;

import java.util.TreeSet;


public class TeamBoardRepository {
    @Getter
    private final TreeSet<TeamBoard> allBoards = new TreeSet<>();

    public void add(TeamBoard board) {
        this.allBoards.add(board);
    }
}
