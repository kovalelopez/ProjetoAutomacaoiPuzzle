package iPuzzle.tests;

import iPuzzle.inicialPage.InicialPage;
import iPuzzle.login.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade de Cadastrar Contatos")
public class CadastrarContatosTests {

    WebDriver navegador;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(navegador);
        InicialPage inicialPage = new InicialPage(navegador);

        loginPage.acessarPaginaIPuzzle();
        loginPage.realizarLogin("growdev@mail.com", "123456");
        inicialPage.abrirTelaCadastrarContato();


        navegador.findElement(By.xpath("//*[@class='shrink-0 fill-current  MuiBox-root css-wjsm5w']")).click();
        navegador.findElement(By.xpath("(//*[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-padding MuiListItem-button fuse-list-item css-1qrkt4x'])[2]")).click();
        navegador.findElement(By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-eaz53l > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.flex-col.flex-auto.h-full.MuiDrawer-paper.MuiDrawer-paperAnchorLeft.css-1fpbeqg > div > div.flex.flex-1.flex-col.min-h-0.css-mh0qts.ps > ul > ul.MuiList-root.MuiList-padding.open.css-1mxui7z > div > div > div > a:nth-child(2) > div > span")).click();

    }

    @AfterEach
    public void tearDown() {
        navegador.quit();
    }



    @Test
    @DisplayName("Cadastrar contato com informacoes válidas")
    public void cadastroContatoValido() {
        navegador.findElement(By.id("mui-component-select-group")).click();
        navegador.findElement(By.cssSelector("#menu-group > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiMenu-paper.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-1826ohv > ul > li:nth-child(1)")).click();
        navegador.findElement(By.id(":r4:")).sendKeys("teste001");
        navegador.findElement(By.id(":r5:")).sendKeys("990909090");
        navegador.findElement(By.id(":r6:")).sendKeys("teste001@email.com");
        navegador.findElement(By.id(":r7:")).sendKeys("9757000");
        navegador.findElement(By.id(":r8:")).sendKeys("Rua do Migué");
        navegador.findElement(By.id(":r9:")).sendKeys("001");
        navegador.findElement(By.id(":ra:")).sendKeys("casa");
        navegador.findElement(By.id(":rb:")).sendKeys("Peida");
        navegador.findElement(By.id(":rc:")).sendKeys("Livratop");
        navegador.findElement(By.id(":rd:")).sendKeys("RS");
        navegador.findElement(By.id(":re:")).sendKeys("Brasil");
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.flex-row-reverse.gap-20 > button.MuiButton-root.MuiButton-contained.MuiButton-containedInherit.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorInherit.MuiButtonBase-root.w-160.rounded-28.bg-\\[\\#266284\\].text-white.css-voray4")).click();

    }

    @Test
    @DisplayName("Validação de aviso de informacoes ja existentes no campo Nome e sobrenome")
    public void validacaoDeInformacoesExistentesNoCampoNome() {
        navegador.findElement(By.id("mui-component-select-group")).click();
        navegador.findElement(By.cssSelector("#menu-group > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiMenu-paper.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-1826ohv > ul > li:nth-child(1)")).click();
        navegador.findElement(By.id(":r4:")).sendKeys("teste001");
        navegador.findElement(By.id(":r5:")).sendKeys("990909090");
        navegador.findElement(By.id(":r6:")).sendKeys("teste001@email.com");
        navegador.findElement(By.id(":r7:")).sendKeys("9757000");
        navegador.findElement(By.id(":r8:")).sendKeys("Rua do Migué");
        navegador.findElement(By.id(":r9:")).sendKeys("001");
        navegador.findElement(By.id(":ra:")).sendKeys("casa");
        navegador.findElement(By.id(":rb:")).sendKeys("Peida");
        navegador.findElement(By.id(":rc:")).sendKeys("Livratop");
        navegador.findElement(By.id(":rd:")).sendKeys("RS");
        navegador.findElement(By.id(":re:")).sendKeys("Brasil");
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.flex-row-reverse.gap-20 > button.MuiButton-root.MuiButton-contained.MuiButton-containedInherit.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorInherit.MuiButtonBase-root.w-160.rounded-28.bg-\\[\\#266284\\].text-white.css-voray4")).click();
        String errorMessage = navegador.findElement(By.cssSelector("#\\:r5\\:-helper-text")).getText();
        Assertions.assertEquals("Usuário com este telefone já existe.", errorMessage);
    }

    @Test
    @DisplayName("Validacao de mensagem de quantidade minima de caracteres no campo de Nome e Sobrenome")
    public void validarMensagemDeQuantidadeMinimaDeCaracteresCampoNome() {
        navegador.findElement(By.id("mui-component-select-group")).click();
        navegador.findElement(By.cssSelector("#menu-group > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiMenu-paper.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-1826ohv > ul > li:nth-child(1)")).click();
        navegador.findElement(By.id(":r4:")).sendKeys("te");
        navegador.findElement(By.id(":r5:")).sendKeys("990909090");
        navegador.findElement(By.id(":r6:")).sendKeys("teste001@email.com");
        navegador.findElement(By.id(":r7:")).sendKeys("9757000");
        navegador.findElement(By.id(":r8:")).sendKeys("Rua do Migué");
        navegador.findElement(By.id(":r9:")).sendKeys("001");
        navegador.findElement(By.id(":ra:")).sendKeys("casa");
        navegador.findElement(By.id(":rb:")).sendKeys("Peida");
        navegador.findElement(By.id(":rc:")).sendKeys("Livratop");
        navegador.findElement(By.id(":rd:")).sendKeys("RS");
        navegador.findElement(By.id(":re:")).sendKeys("Brasil");
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.flex-row-reverse.gap-20 > button.MuiButton-root.MuiButton-contained.MuiButton-containedInherit.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorInherit.MuiButtonBase-root.w-160.rounded-28.bg-\\[\\#266284\\].text-white.css-voray4")).click();
        String errorMessage = navegador.findElement(By.id(":r4:-helper-text")).getText();
        Assertions.assertEquals("Nome é muito curto.", errorMessage);
    }

    @Test
    @DisplayName("Validação de aviso de informacoes ja existentes no campo Email")
    public void validacaoDeInformacoesExistentesNoCampoEmail() {
        navegador.findElement(By.id("mui-component-select-group")).click();
        navegador.findElement(By.cssSelector("#menu-group > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiMenu-paper.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-1826ohv > ul > li:nth-child(1)")).click();
        navegador.findElement(By.id(":r4:")).sendKeys("teste01");
        navegador.findElement(By.id(":r5:")).sendKeys("99909090");
        navegador.findElement(By.id(":r6:")).sendKeys("teste001@email.com");
        navegador.findElement(By.id(":r7:")).sendKeys("9757000");
        navegador.findElement(By.id(":r8:")).sendKeys("Rua do Migué");
        navegador.findElement(By.id(":r9:")).sendKeys("001");
        navegador.findElement(By.id(":ra:")).sendKeys("casa");
        navegador.findElement(By.id(":rb:")).sendKeys("Peida");
        navegador.findElement(By.id(":rc:")).sendKeys("Livratop");
        navegador.findElement(By.id(":rd:")).sendKeys("RS");
        navegador.findElement(By.id(":re:")).sendKeys("Brasil");
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.flex-row-reverse.gap-20 > button.MuiButton-root.MuiButton-contained.MuiButton-containedInherit.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorInherit.MuiButtonBase-root.w-160.rounded-28.bg-\\[\\#266284\\].text-white.css-voray4")).click();
        String errorMessage = navegador.findElement(By.id(":r6:-helper-text")).getText();
        Assertions.assertEquals("Usuário com este email já existe.", errorMessage);
    }

    @Test
    @DisplayName("Cadastro de contato com status Inativo")
    public void validarBotaoDeStatusDoContato() {
        navegador.findElement(By.id("mui-component-select-group")).click();
        navegador.findElement(By.cssSelector("#menu-group > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation1.MuiMenu-paper.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-1826ohv > ul > li:nth-child(1)")).click();
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.justify-between.w-full > div:nth-child(2) > div > div > span")).click();
        navegador.findElement(By.id(":r4:")).sendKeys("testeStatus");
        navegador.findElement(By.id(":r5:")).sendKeys("990909091");
        navegador.findElement(By.id(":r6:")).sendKeys("testestatus@email.com");
        navegador.findElement(By.id(":r7:")).sendKeys("9757000");
        navegador.findElement(By.id(":r8:")).sendKeys("Rua do Migué");
        navegador.findElement(By.id(":r9:")).sendKeys("001");
        navegador.findElement(By.id(":ra:")).sendKeys("casa");
        navegador.findElement(By.id(":rb:")).sendKeys("Peida");
        navegador.findElement(By.id(":rc:")).sendKeys("Livratop");
        navegador.findElement(By.id(":rd:")).sendKeys("RS");
        navegador.findElement(By.id(":re:")).sendKeys("Brasil");
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.flex-row-reverse.gap-20 > button.MuiButton-root.MuiButton-contained.MuiButton-containedInherit.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorInherit.MuiButtonBase-root.w-160.rounded-28.bg-\\[\\#266284\\].text-white.css-voray4")).click();
    }

    @Test
    @DisplayName("Validação do botão Cancelar")
    public void validarBotaoCancelar() throws InterruptedException {
        Thread.sleep(3000);
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > form > div.flex.flex-row-reverse.gap-20 > button.MuiButton-root.MuiButton-contained.MuiButton-containedInherit.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-colorInherit.MuiButtonBase-root.w-160.rounded-28.border-solid.border-1.bg-white.text-\\[\\#7BAAC5\\].css-1lidzvr")).click();
        Thread.sleep(3000);
        String titulo = navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-header > div > div > p")).getText();
        Assertions.assertEquals("Contatos", titulo);
    }

}
