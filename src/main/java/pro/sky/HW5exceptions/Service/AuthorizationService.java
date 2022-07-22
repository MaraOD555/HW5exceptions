package pro.sky.HW5exceptions.Service;

import org.springframework.stereotype.Service;
import pro.sky.HW5exceptions.Exceptoins.WrongLoginException;
import pro.sky.HW5exceptions.Exceptoins.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorizationService {
    public String checkLogin(String login) throws WrongLoginException {
        if (login.isEmpty() || login.length() > 20) {
            throw new WrongLoginException();
        }
        if (!checkCorrectCharacters(login)) {
            throw new WrongLoginException();
        }
       return "Недопустимая комбинация логина!";
    }

    public String checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.isEmpty() || password.length() >= 20) {
            throw new WrongPasswordException();
        }
        if (!checkCorrectCharacters(password)) {
            throw new WrongLoginException();
        }
        if (!checkCorrectCharacters(confirmPassword)) {
            throw new WrongLoginException();
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
       }
        return "Недопустимая комбинация пароля!";
    }
    public static boolean checkCorrectCharacters (String set){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[_])"
                + "(?=\\S+$)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(set);
        return m.matches();
    }
}


        //String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";






