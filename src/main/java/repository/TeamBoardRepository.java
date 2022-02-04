package repository;

import entity.TeamBoard;
import lombok.Getter;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;


public class TeamBoardRepository {

    @Getter
    private final List<TeamBoard> allBoards = new ArrayList<>();

    public void add(TeamBoard board){
        this.allBoards.add(board);
    }
}
