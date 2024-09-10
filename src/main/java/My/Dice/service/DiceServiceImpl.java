package My.Dice.service;

import My.Dice.domain.Dice;
import My.Dice.domain.DiceRecords;
import My.Dice.repository.IDiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements IDiceService{

    private final IDiceRepository diceRepository;

    // 파라미터로 dice 객체를 받아 dice 객체에 저장된 주사위 기록을 처리한다.
    @Override
    public void save(Dice dice) {
        // 주사위의 숫자와 모든 주사위 기록을 가져온다.
        int number = dice.getNumber();
        DiceRecords diceRecords = diceRepository.findAll();

        // 주사위 기록을 저장하는 맵을 가져와 만약 맵이 비어있으면 초기화한다.
        // 주사위 결과가 나올 때마다 값을 증가시킨다.
        Map<Integer, Integer> diceNumberRecords = diceRecords.getRecords();

        if(diceNumberRecords.isEmpty()) {
            for(int i = 1; i < 7; i++) {
                diceNumberRecords.put(i, 0);
            }
        }
        diceNumberRecords.put(number, diceNumberRecords.get(number)+1);
        diceRecords.setRecords(diceNumberRecords);

        diceRepository.save(diceRecords);

    }

    // 저장된 모든 주사위 기록을 가져와서 반환한다.
    @Override
    public DiceRecords getRecords() {
        return diceRepository.findAll();
    }

    // 저장된 주사위 기록 초기화
    @Override
    public void reset(DiceRecords diceRecords) {
        diceRecords.getRecords().clear();
    }
}
