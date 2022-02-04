import entity.SoccerMatch;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    @Getter private List<SoccerMatch> allRegisters = new ArrayList<>();

    public void add(SoccerMatch match){
        allRegisters.add(match);
    }




}
