package My.Dice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class DiceRecords {
    // 주사위의 숫자와 나온 숫자를 기록하기 위해 map 컬렉션을 사용
    // 주사위의 숫자(key), 해당 숫자가 나온 횟수(value)
    private Map<Integer, Integer> records;

}
