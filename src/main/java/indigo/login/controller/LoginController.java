package indigo.login.controller;

import indigo.login.model.RequestLogin;
import indigo.login.model.ResponseLogin;
import indigo.login.service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Service")
public class LoginController {

    private final ILogin login;

    @Autowired
    public LoginController(ILogin login) {
        this.login = login;
    }

    @PostMapping(path = "/Login", produces = "application/json")
    public ResponseLogin Login(@RequestBody RequestLogin request) {
        ResponseLogin resplogin = null;
        try {
            resplogin = login.findUser(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resplogin;
    }
}
