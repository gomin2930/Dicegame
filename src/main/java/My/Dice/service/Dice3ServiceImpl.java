package My.Dice.service;

import My.Dice.domain.Player;
import My.Dice.repository.IDice3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Dice3ServiceImpl implements IDice3Service {

    private final IDice3Repository dice3Repository;

    // 게임 시작 전, 플레이어의 이름을 저장
    // 전달된 플레이어 이름으로 Player 객체를 생성하여 각각 player1, player2라는 키로 리포지토리에 저장
    @Override
    public void setPlayerName(String player1Name, String player2Name) {

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        dice3Repository.savePlayerName("player1", player1);
        dice3Repository.savePlayerName("player2", player2);
    }

    // 전달받은 player 키를 통해 해당 플레이어에 정보를 가져옴
    @Override
    public Player getPlayer(String player) {
        return dice3Repository.findPlayer(player);
    }

    // 두 플레이어의 총점을 비교하여 결과를 반환
    @Override
    public int scoreCheck(Player player1, Player player2) {

        int totalScore1 = player1.getTotalScore();
        int totalScore2 = player2.getTotalScore();

        // 플레이어1의 점수가 높으면 1을 반환
        if(totalScore1 >= 36 || totalScore2 >= 36) {
            if(totalScore1 > totalScore2) {
                return 1;
            }
            // 플레이어2의 점수가 높으면 2를 반환
            if(totalScore1 < totalScore2) {
             return 2;
            }
            // 두 점수가 같은 경우 3 반환
            return 3;
        }
        
        // 36점을 넘기는 플레이어 없을 경우 0 반환
        return 0;
    }
}
