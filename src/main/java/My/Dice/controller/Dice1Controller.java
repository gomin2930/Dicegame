package My.Dice.controller;

import My.Dice.domain.Dice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Dice1Controller {

    @GetMapping("/dice1")
    public String Dice1(Model model) {

        // 주사위 생성
        Dice dice1 = new Dice();
        // 1~6까지의 랜덤 숫자 추출
        int randomNumber = (int)(Math.random()*6+1);
        // 추출된 랜덤 숫자 저장
        int diceNumber = randomNumber;
        // diceNumber 모델 속성 추가
        // diceNumber라는 이름을 통해 모델 데이터에 접근 가능
        model.addAttribute("diceNumber", diceNumber);

        return "myDice1/dice1";
    } // end Dice1
} // end class
