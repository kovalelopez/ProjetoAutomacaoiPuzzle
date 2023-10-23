package iPuzzle.tests;

import iPuzzle.inicialPage.InicialPage;
import iPuzzle.login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@DisplayName("Testes Automatizados da Funcionalidade de Login")
public class LoginTests {
    WebDriver navegador;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(navegador);
        loginPage.acessarPaginaIPuzzle();
    }

    @AfterEach
    public void tearDown() {
        navegador.quit();
    }

    @Test
    @DisplayName("Login de usuário com credenciais válidas")
    public void loginCredenciaisValidas() throws InterruptedException {
        LoginPage loginPage = new LoginPage(navegador);
        InicialPage inicialPage = new InicialPage(navegador);

        WebElement element = loginPage.validarImagemDaTelaDeLogin();
        boolean isDisplayed = element.isDisplayed();
        if (isDisplayed) {System.out.println("ok");}
        loginPage.realizarLogin("growdev@mail.com", "123456");
        Thread.sleep(6000);
        String userPage = inicialPage.validarTextoGrowdevTeste();
        Assertions.assertEquals("Growdev Teste", userPage);
    }

    @Test
    @DisplayName("Login de usuário com email inválido")
    public void loginEmailInvalido() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.tentativaDeLoginComEmailInvalido("teste@mail.com", "123456");
        String errorMessage = loginPage.validarTextoCredenciaisIncorretas();
        Assertions.assertEquals("Credenciais incorretas.", errorMessage);
    }

    @Test
    @DisplayName("Login de usuário com senha inválida")
    public void loginSenhaInvalida() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.tentativaDeLoginComSenhaInvalida("growdev@mail.com", "123457");
        String errorMessage = loginPage.validarTextoCredenciaisIncorretas();
        Assertions.assertEquals("Credenciais incorretas.", errorMessage);
    }

    @Test
    @DisplayName("Validação do campo obigatório de senha")
    public void validarCampoSenhaObrigatorio() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.tentativaDeLoginComCampoSenhaVazio("growdev@mail.com", "12");
        String errorMessagePassword = loginPage.validarTextoSenhaNaoPodeSerVazia();
        Assertions.assertEquals("Senha não pode ser vazia.", errorMessagePassword);
    }

    @Test
    @DisplayName("Validação de quantidade mínima de caracteres no campo de senha")
    public void validarQuantidadeMinimaCaracteresCampoSenha() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.tentativaDeLoginComSenhaMuitoCurta("growdev@mail.com", "12345");
        String limitedCharactersMsg = loginPage.validarTextoSenhaMuitoCurta();
        Assertions.assertEquals("Senha é muito curta - mínimo 6 caracteres.", limitedCharactersMsg);
    }

    @Test
    @DisplayName("Validação do campo email")
    public void validarFormatoParaCampoEmail() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.validacaoDoCampoEmail("a");
        String invalidEmail = loginPage.validarTextoInformeUmEmailValido();
        Assertions.assertEquals("Por favor informe um e-mail válido.", invalidEmail);
    }

    @Test
    @DisplayName("Validação da obrigatoriedade do campo Email")
    public void validarCampoEmailObrigatorio() {
        LoginPage loginPage = new LoginPage(navegador);

        loginPage.validarObrigatoriedadeCampoEmail();
        String requiredField = loginPage.validarTextoEmailNaoPodeSerVazio();
        Assertions.assertEquals("E-mail não pode ser vazio.", requiredField);
    }

}
