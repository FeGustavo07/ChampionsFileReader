package enums;

import entity.TeamTable;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SoccerPontuationRules {
    VICTORY(1, 3) {
        public void setResult(TeamTable table) {
            int pontuation = table.getPontuation() + getPontuation();
            int victories = table.getVictories() + 1;
            table.setVictories(victories);
            table.setPontuation(pontuation);
        }
    },
    TIE(0, 1) {
        public void setResult(TeamTable table) {
            int pontuation = table.getPontuation() + getPontuation();
            int ties = table.getTies() + 1;
            table.setTies(ties);
            table.setPontuation(pontuation);
        }
    },
    DEFEAT(-1, 0) {
        public void setResult(TeamTable table) {
            int pontuation = table.getPontuation() + getPontuation();
            int defeats = table.getDefeats() + 1;
            table.setDefeats(defeats);
            table.setPontuation(pontuation);
        }
    };

    private static final Map<Integer, SoccerPontuationRules> mapValues = new HashMap<>();

    static {
        for (SoccerPontuationRules enumType : SoccerPontuationRules.values()) {
            mapValues.put(enumType.compareCondition, enumType);
        }
    }

    private final int compareCondition;
    private final int pontuation;

    SoccerPontuationRules(Integer compareCondition, Integer pontuation) {
        this.compareCondition = compareCondition;
        this.pontuation = pontuation;
    }

    public static SoccerPontuationRules getEnumTypeBy(int key) {
        return mapValues.get(key);
    }

    public abstract void setResult(TeamTable table);


}
