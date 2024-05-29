package My.Dice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Player {
    
    // 참가자 이름
    private String name;
    // 나온 주사위 숫자
    private int number = 0;
    // 주사위 숫자의 총합
    private int totalScore = 0;
    // 나온 주사위 숫자 기록
    private List<Integer> records = new ArrayList<>();

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
