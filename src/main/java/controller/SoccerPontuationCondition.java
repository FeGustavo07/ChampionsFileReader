package controller;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SoccerPontuationCondition {
    VICTORY(1,3),
    TIE(0,1),
    DEFEAT(-1,0);

    private final Integer compareCondition;
    private final Integer pontuation;

    private static final Map<Integer,SoccerPontuationCondition> mapValues = new HashMap<>();

    static {
        for (SoccerPontuationCondition enumType : SoccerPontuationCondition.values()) {
            mapValues.put(enumType.compareCondition, enumType);
        }
    }

    SoccerPontuationCondition(Integer compareCondition, Integer pontuation) {
        this.compareCondition = compareCondition;
        this.pontuation = pontuation;
    }


}
