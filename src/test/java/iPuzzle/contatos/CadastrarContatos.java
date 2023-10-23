package iPuzzle.contatos;

import iPuzzle.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CadastrarContatos extends BasePage {

    public CadastrarContatos(WebDriver navegador) {
        super(navegador);
    }

}
