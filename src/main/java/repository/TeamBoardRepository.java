package repository;

import entity.TeamBoard;
import lombok.Getter;

import java.util.HashSet;
import java.util.TreeSet;


public class TeamBoardRepository {

    @Getter
    private final HashSet<TeamBoard> allBoards = new HashSet<>();

    public void add(TeamBoard board) {
        this.allBoards.add(board);
    }
}
