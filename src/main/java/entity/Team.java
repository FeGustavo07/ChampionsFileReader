package entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Team {
    private String name;
    private Integer goals;
}
