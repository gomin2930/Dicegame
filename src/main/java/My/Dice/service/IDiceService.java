package My.Dice.service;

import My.Dice.domain.Dice;
import My.Dice.domain.DiceRecords;

public interface IDiceService {

    // 각 숫자별로 나온 횟수를 저장 및 기록.
    // 예시) 1: 2번 등..
    void save(Dice dice);

    // 각 숫자별로 나온 횟수를 가져옴.
    DiceRecords getRecords();
}
