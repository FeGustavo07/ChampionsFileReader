package enums;

import entity.TeamBoard;
import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum SoccerPontuationRules {
    VICTORY(1,3){
        public void setResult(TeamBoard board){
            int pontuation = board.getPontuation() + getPontuation();
            int victories = board.getVictories() + 1;
            board.setVictories(victories);
            board.setPontuation(pontuation);
        }
    },
    TIE(0,1) {
        public void setResult(TeamBoard board) {
            int pontuation = board.getPontuation() + getPontuation();
            int ties = board.getTies() + 1;
            board.setTies(ties);
            board.setPontuation(pontuation);
        }
    },
    DEFEAT(-1,0) {
        public void setResult(TeamBoard board) {
            int pontuation = board.getPontuation() + getPontuation();
            int defeats = board.getDefeats() + 1;
            board.setDefeats(defeats);
            board.setPontuation(pontuation);
        }
    };

    private final int compareCondition;
    private final int pontuation;

    private static final Map<Integer, SoccerPontuationRules> mapValues = new HashMap<>();

    static {
        for (SoccerPontuationRules enumType : SoccerPontuationRules.values()) {
            mapValues.put(enumType.compareCondition, enumType);
        }
    }

    SoccerPontuationRules(Integer compareCondition, Integer pontuation) {
        this.compareCondition = compareCondition;
        this.pontuation = pontuation;
    }

    public static SoccerPontuationRules getEnumTypeBy(int key){
        return mapValues.get(key);
    }

    public abstract void setResult(TeamBoard board);


}
