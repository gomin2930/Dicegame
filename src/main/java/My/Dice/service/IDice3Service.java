package My.Dice.service;

import My.Dice.domain.Player;

public interface IDice3Service {

    // 전달된 두 개의 이름을 플레이어의 이름으로 설정
    void setPlayerName(String player1Name, String player2Name);

    // 이름으로 해당 플레이어 정보 찾아서 반환
    Player getPlayer(String dice3Repository);

    // 두 플레이어의 점수를 비교하여 결과를 반환
    int scoreCheck(Player player1, Player player2);
}
