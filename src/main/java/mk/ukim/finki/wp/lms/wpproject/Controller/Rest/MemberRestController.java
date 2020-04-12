package mk.ukim.finki.wp.lms.wpproject.Controller.Rest;

import mk.ukim.finki.wp.lms.wpproject.Model.Member;
import mk.ukim.finki.wp.lms.wpproject.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/member")
public class MemberRestController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value = {"/", "/list"})
    public List<Member> all() {
        return memberService.getAll();
    }
}