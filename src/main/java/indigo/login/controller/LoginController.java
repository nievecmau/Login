package indigo.login.controller;

import indigo.login.model.RequestLogin;
import indigo.login.model.ResponseLogin;
import indigo.login.service.ILogin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/Service")
public class LoginController {

    private final ILogin login;

    @PostMapping(path = "/Login", produces = "application/json")
    public ResponseLogin Login(@RequestBody RequestLogin request) {
        ResponseLogin resplogin;
        try {
            resplogin = login.findUser(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resplogin;
    }
}
