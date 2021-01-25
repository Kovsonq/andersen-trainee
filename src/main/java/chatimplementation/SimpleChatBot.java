package chatimplementation;

import java.util.Random;
import java.util.regex.Pattern;

public class SimpleChatBot {
    Random random = new Random();
    String[] hello = {"Hi", "Привет", "Здорова!"};
    String[] bye = {"Пока", "Давай", "Всего доброго"};
    String[] common = {"не хочу болтать, когда не понимаю", "поподробнее", "плохая связь... потом поболтаем"};

    Pattern helloPattern = Pattern.compile("(\\w*)привет(\\w*)");
    Pattern byePattern = Pattern.compile("(\\w*)пока(\\w*)");

    public String sayInReturn(String clientMessage){

        String answer="...";

        String inMessage = String.join(" ", clientMessage.toLowerCase().split("[ {,|.}?]+"));
        if (helloPattern.matcher(inMessage).find()){
            return hello[random.nextInt(hello.length)];
        } else if (byePattern.matcher(inMessage).find()) {
            return answer = bye[random.nextInt(bye.length)];
        } else return answer = common[random.nextInt(common.length)];

    }
}
