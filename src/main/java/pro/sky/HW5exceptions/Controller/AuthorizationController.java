package pro.sky.HW5exceptions.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HW5exceptions.Exceptoins.WrongLoginException;
import pro.sky.HW5exceptions.Exceptoins.WrongPasswordException;
import pro.sky.HW5exceptions.Service.AuthorizationService;

@RestController
public class AuthorizationController {
    private static AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/greeting")
    public String showRequest() {
        return "Привет, следующий шаг это логин и пароль"; // формат вывода всегда в контроллере
    }

    @GetMapping("/request")
    public String authorization(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        try {
             return authorizationService.checkLogin(login) +
                    authorizationService.checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
             e.printStackTrace();
            return "Недопустимая комбинация логина!";
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return "Недопустимая комбинация пароля!";
        }
        //return "Успешная авторизация";
    }

}









