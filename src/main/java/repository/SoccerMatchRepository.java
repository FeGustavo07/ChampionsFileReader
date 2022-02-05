package repository;

import entity.SoccerMatch;
import lombok.Getter;

import java.util.*;

public class SoccerMatchRepository {
    @Getter
    private final HashSet<SoccerMatch> allRegisters = new HashSet<>();

    public void addAll(HashSet<SoccerMatch> matches){
        allRegisters.addAll(matches);
    }

}
