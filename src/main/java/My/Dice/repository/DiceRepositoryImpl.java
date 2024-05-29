package My.Dice.repository;

import My.Dice.domain.DiceRecords;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DiceRepositoryImpl implements IDiceRepository{

    private static final Map<Integer, Integer> diceRepository = new HashMap<>();

    // 리포지토리는 실제 데이터베이스에 접근하는 역할. 도메인 객체를 DB에 저장, 관리하는 역할을 함.
    // 도메인 클래스인 DiceRecords의 records를 리포지토리로 복사하는 과정
    @Override
    public void save(DiceRecords diceRecords) {
        Map<Integer, Integer> diceNumberRecords = diceRecords.getRecords();

        for(Integer key : diceNumberRecords.keySet()) {
            diceRepository.put(key, diceNumberRecords.get(key));
        }
    }

    // 리포지토리에 저장되어 있는 모든 주사위 기록을 가져와 diceRecords에 담아서 반환.
    @Override
    public DiceRecords findAll() {
        DiceRecords diceRecords = new DiceRecords();
        diceRecords.setRecords(diceRepository);

        return diceRecords;
    }
}
