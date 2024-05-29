package My.Dice.repository;

import My.Dice.domain.DiceRecords;

// 리포지토리는 데이터베이스에 접근, 도메인 객체를 DB에 저장, 관리 등의 역할을 한다.
public interface IDiceRepository {

    // 기록 저장
    void save(DiceRecords diceRecords);

    // 기록 조회
    DiceRecords findAll();

}
