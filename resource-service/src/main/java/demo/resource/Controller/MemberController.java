package demo.resource.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    @GetMapping("/")
    public String justCall() {
        log.info("call MemberController!");
        return "justCall";
    }

    @GetMapping("/member")
    public String getMember() {
        log.info("call MemberController!");
        return "member1";
    }
}
