package repository;

import entity.SoccerMatch;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class SoccerMatchRepository {
    @Getter
    private List<SoccerMatch> allRegisters = new ArrayList<>();

    public void addAll(List<SoccerMatch> matches){
        allRegisters.addAll(matches);
    }

}
