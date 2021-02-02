package part2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoodListController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goodList() {
        return "good-list";
    }

}
