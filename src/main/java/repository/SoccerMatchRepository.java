package repository;

import entity.SoccerMatch;
import lombok.Getter;

import java.util.*;

public class SoccerMatchRepository {
    @Getter
    private final List<SoccerMatch> allRegisters = new ArrayList<>();

    public void addAll(List<SoccerMatch> matches){
        allRegisters.addAll(matches);
    }

}
