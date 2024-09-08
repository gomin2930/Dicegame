package My.Dice.repository;

import My.Dice.domain.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class Dice3RepositoryImpl implements IDice3Repository {

    private static final Map<String, Player> dice3Repository = new HashMap<>();

    // 입력한 이름을 키로 사용하여 플레이어에 저장
    // 예시) player1 : 가나, player2 : 다라
    @Override
    public Player savePlayerName(String playerName, Player player) {
        return dice3Repository.put(playerName, player);
    }

    // 저장되어 있는 이름으로 플레이어 찾기
    @Override
    public Player findPlayer(String playerName) {
        return dice3Repository.get(playerName);
    }

    // 리포지토리에 저장되어 있는 플레이어별 플레이어의 모든 정보를 반환
    @Override
    public Map<String, Player> getPlayer() {
        return dice3Repository;
    }
}
