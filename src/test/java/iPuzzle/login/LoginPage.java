package iPuzzle.login;

import iPuzzle.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private By localizadorDoCampoEmail = By.xpath("//*[@id=':r1:']");
    private By localizadorDoCampoSenha = By.xpath("//*[@id=':r2:']");
    private By localizadorDoBotaoEntrar = By.xpath("//*[@class='MuiButton-root MuiButton-contained MuiButton-containedInherit MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorInherit MuiButtonBase-root w-full mt-12 rounded-[34px] bg-[#266284] text-white font-500 leading-6 text-transform: uppercase tracking-wide css-1lidzvr']");
    private By localizadorDaImagemDaTelaDeLogin = By.xpath("//*[@class='w-[130px] self-center mb-32']");
    private By localizadorDaMensagemDeErro = By.xpath("//p[contains(text(), 'Credenciais incorretas.')]");
    private By localizadorDaMensagemSenhaNaoPodeSerVazia = By.id(":r2:-helper-text");
    private By localizadorDamensagemSenhaMuitoCurta = By.xpath("//*[contains(text(), 'Senha é muito curta - mínimo 6 caracteres.')]");
    private By localizadorDaMesagemInformeUmEmailValido = By.id(":r1:-helper-text");
    private By localizadorDamensagemDeEmailObrigatorio = By.id(":r1:-helper-text");
    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public void acessarPaginaIPuzzle() {
        navegador.get("https://hmg.ipuzzle.app/sign-in");
    }

    public <WebElement> org.openqa.selenium.WebElement validarImagemDaTelaDeLogin() {
        return navegador.findElement(localizadorDaImagemDaTelaDeLogin);
    }

    public void realizarLogin(String email, String senha) {
        navegador.findElement(localizadorDoCampoEmail).sendKeys(email);
        navegador.findElement(localizadorDoCampoSenha).sendKeys(senha);
        navegador.findElement(localizadorDoBotaoEntrar).click();
    }

    public void tentativaDeLoginComEmailInvalido(String emailInvalido, String senha) {
        navegador.findElement(localizadorDoCampoEmail).sendKeys(emailInvalido);
        navegador.findElement(localizadorDoCampoSenha).sendKeys(senha);
        navegador.findElement(localizadorDoBotaoEntrar).click();
    }

    public String validarTextoCredenciaisIncorretas() {
        return navegador.findElement(localizadorDaMensagemDeErro).getText();
    }

    public void tentativaDeLoginComSenhaInvalida(String email, String senhaInvalida) {
        navegador.findElement(localizadorDoCampoEmail).sendKeys(email);
        navegador.findElement(localizadorDoCampoSenha).sendKeys(senhaInvalida);
        navegador.findElement(localizadorDoBotaoEntrar).click();
    }

    public void tentativaDeLoginComCampoSenhaVazio(String email, String senha12) {
        navegador.findElement(localizadorDoCampoEmail).sendKeys(email);
        navegador.findElement(localizadorDoCampoSenha).sendKeys(senha12);
        navegador.findElement(localizadorDoCampoSenha).sendKeys(Keys.CONTROL + "a");
        navegador.findElement(localizadorDoCampoSenha).sendKeys(Keys.BACK_SPACE);
    }

    public String validarTextoSenhaNaoPodeSerVazia() {
        return navegador.findElement(localizadorDaMensagemSenhaNaoPodeSerVazia).getText();
    }

    public void tentativaDeLoginComSenhaMuitoCurta(String email, String senhaCurta) {
        navegador.findElement(localizadorDoCampoEmail).sendKeys(email);
        navegador.findElement(localizadorDoCampoSenha).sendKeys(senhaCurta);
    }

    public String validarTextoSenhaMuitoCurta() {
        return navegador.findElement(localizadorDamensagemSenhaMuitoCurta).getText();
    }

    public void validacaoDoCampoEmail(String emailInvalido) {
        navegador.findElement(localizadorDoCampoEmail).sendKeys(emailInvalido);
    }

    public String validarTextoInformeUmEmailValido() {
        return navegador.findElement(localizadorDaMesagemInformeUmEmailValido).getText();
    }

    public void validarObrigatoriedadeCampoEmail() {
        navegador.findElement(localizadorDoCampoEmail).sendKeys("a");
        navegador.findElement(localizadorDoCampoEmail).sendKeys(Keys.CONTROL + "a");
        navegador.findElement(localizadorDoCampoEmail).sendKeys(Keys.BACK_SPACE);
    }

    public String validarTextoEmailNaoPodeSerVazio() {
        return navegador.findElement(localizadorDamensagemDeEmailObrigatorio).getText();
    }

}
