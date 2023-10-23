package iPuzzle.locais;

import iPuzzle.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@DisplayName("Testes automatizados da funcionaidade de Cadastrar Locais")
public class CadastrarLocais extends BasePage {
    WebDriver navegador;

    public CadastrarLocais(WebDriver navegador) {
        super(navegador);
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        navegador.get("https://hmg.ipuzzle.app/sign-in");
        navegador.findElement(By.xpath("//*[@id=':r1:']")).sendKeys("growdev@mail.com");
        navegador.findElement(By.xpath("//*[@id=':r2:']")).sendKeys("123456");
        navegador.findElement(By.xpath("//*[@class='MuiButton-root MuiButton-contained MuiButton-containedInherit MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorInherit MuiButtonBase-root w-full mt-12 rounded-[34px] bg-[#266284] text-white font-500 leading-6 text-transform: uppercase tracking-wide css-1lidzvr']"))
                    .click();
        navegador.findElement(By.xpath("//*[@class='shrink-0 fill-current  MuiBox-root css-wjsm5w']")).click();
    }

    @AfterEach
    public void tearDown() {
        navegador.quit();
    }
}
