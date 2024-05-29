package My.Dice.controller;

import My.Dice.domain.Dice;
import My.Dice.domain.DiceRecords;
import My.Dice.service.IDiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Dice2Controller {

    private final IDiceService diceService;

    @GetMapping("/dice2")
    public String Dice2(Model model) {
        // 주사위 생성
        Dice dice2 = new Dice();
        // 주사위 기록 생성
        DiceRecords diceRecords = new DiceRecords();

        // 1~6 랜덤 숫자 추출 및 저장
        int randomNumber = (int) (Math.random() * 6 + 1);
        dice2.setNumber(randomNumber);

        model.addAttribute("dice2", dice2);

        diceService.save(dice2);

        // 각 숫자별 나온 횟수 가져오기
        DiceRecords storageRecords = diceService.getRecords();
        model.addAttribute("diceRecords", storageRecords);

        return "myDice2/dice2";

    }
}
