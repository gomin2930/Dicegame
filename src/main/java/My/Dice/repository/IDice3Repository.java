package My.Dice.repository;

import My.Dice.domain.Player;

import java.util.Map;

// 리포지토리는 데이터베이스에 접근, 도메인 객체를 DB에 저장, 관리 등의 역할을 한다.
public interface IDice3Repository {

    // 플레이어 이름을 키로 사용하여 플레이어 정보 저장
    Player savePlayerName(String playerName, Player player);

    // 이름으로 플레이어 찾기
    Player findPlayer(String playerName);

    // setting 화면에서 입력한 플레이어 이름과 매핑된 기록 조회
    Map<String, Player> getPlayer();
}
