package My.Dice.controller;

import My.Dice.domain.Dice;
import My.Dice.domain.Player;
import My.Dice.domain.PlayerDTO;
import My.Dice.service.IDice3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Dice3Controller {

    private final IDice3Service dice3Service;

    // playerDTO객체를 모델에 추가하여 사용자에게 플레이어 이름 입력폼 제공
    @GetMapping("/dice3")
    public String setting(@ModelAttribute("playerDTO") PlayerDTO playerDTO) {
        return "myDice3/dice3";
    }

    // 사용자가 제출한 폼 유효성 검사
    @PostMapping("/dice3")
    public String dice3(@Validated @ModelAttribute("playerDTO") PlayerDTO playerDTO,
                        BindingResult bindingResult) {

        // 실패시
        if(bindingResult.hasErrors()) {
            return "myDice3/dice3";
        }

        // 성공시
        String player1Name = playerDTO.getPlayer1Name();
        String player2Name = playerDTO.getPlayer2Name();

        dice3Service.setPlayerName(player1Name, player2Name);

        return "redirect:/dice3-game";
    }

    // 두 플레이어의 정보를 모델에 추가하여 게임 화면을 반환
    @GetMapping("/dice3-game")
    public String dice3(@ModelAttribute("player")Player player, Model model) {

        Player player1 = dice3Service.getPlayer("player1");
        Player player2 = dice3Service.getPlayer("player2");

       int scoreCheck = dice3Service.scoreCheck(player1, player2);

        model.addAttribute("player1", player1);
        model.addAttribute("player2", player2);
        model.addAttribute("scoreCheck", scoreCheck);

        return "myDice3/dice3-game";
    }


    // 플레이어가 주사위를 굴리면 랜덤으로 점수를 생성, 기록, 총점을 업데이트함.
    @GetMapping("/dice3-roll")
    public String dice3Roll() {

        Player player1 = dice3Service.getPlayer("player1");
        Player player2 = dice3Service.getPlayer("player2");

        int player1Number = (int)(Math.random() * 6 + 1);
        int player2Number = (int)(Math.random() * 6 + 1);

        player1.setNumber(player1Number);
        player2.setNumber(player2Number);

        player1.getRecords().add(player1Number);
        player2.getRecords().add(player2Number);

        int player1Score = player1.getRecords().stream().reduce(Integer::sum).get();
        int player2Score = player2.getRecords().stream().reduce(Integer::sum).get();

        player1.setTotalScore(player1Score);
        player2.setTotalScore(player2Score);

        return "redirect:/dice3-game";
    }
}
