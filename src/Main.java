import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            reg("java_skypro_go123", "trololo", "trololo");
        }
        catch (WrongLoginException ex) {
            System.out.println("Недопустимый логин");
        }
        catch (WrongPasswordException ex) {
            System.out.println("Недопустимый пароль или не совпадает");
        }
    }

    private static void reg(String login, String password, String confirmPassword) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");        // Я так понял, у логина и пароля шаблон один

        if (!pattern.matcher(login).matches())
            throw new WrongLoginException();

        if (!pattern.matcher(password).matches())
            throw new WrongPasswordException();

        if (!password.equals(confirmPassword))
            throw new WrongPasswordException();

        System.out.println(login + " registered!");
    }
}