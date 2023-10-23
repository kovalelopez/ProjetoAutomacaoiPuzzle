package iPuzzle.contatos;

import iPuzzle.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionaidade de Listar Contatos")
public class ListarContatos extends BasePage {
    WebDriver navegador;

    public ListarContatos(WebDriver navegador) {
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
        navegador.findElement(By.xpath("(//*[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-padding MuiListItem-button fuse-list-item css-1qrkt4x'])[2]")).click();
        navegador.findElement(By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-eaz53l > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.flex-col.flex-auto.h-full.MuiDrawer-paper.MuiDrawer-paperAnchorLeft.css-1fpbeqg > div > div.flex.flex-1.flex-col.min-h-0.css-mh0qts.ps > ul > ul.MuiList-root.MuiList-padding.open.css-1mxui7z > div > div > div > a:nth-child(1)")).click();
    }

    @AfterEach
    public void tearDown() {
        navegador.quit();
    }

    /*@Test
    @DisplayName("Validação do botões de Paginação")
    public void validarBotoesDePaginacao() throws InterruptedException {
        navegador.findElement(By.xpath("//*[@class='shrink-0 fill-current  MuiBox-root css-wjsm5w']")).click();
        navegador.findElement(By.xpath("(//*[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-padding MuiListItem-button fuse-list-item css-1qrkt4x'])[2]")).click();
        navegador.findElement(By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-eaz53l > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.flex-col.flex-auto.h-full.MuiDrawer-paper.MuiDrawer-paperAnchorLeft.css-1fpbeqg > div > div.flex.flex-1.flex-col.min-h-0.css-mh0qts.ps > ul > ul.MuiList-root.MuiList-padding.open.css-1mxui7z > div > div > div > a:nth-child(1)")).click();
        String titulo = navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-header > div > div > p")).getText();
        Assertions.assertEquals("Contatos", titulo);
        Thread.sleep(2000);
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[97\\%\\] > div.m-24.w-full.flex.items-center > nav > ul > li:nth-child(3) > button")).click();
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[97\\%\\] > div.m-24.w-full.flex.items-center > nav > ul > li:nth-child(4) > button")).click();
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[97\\%\\] > div.m-24.w-full.flex.items-center > nav > ul > li:nth-child(2) > button")).click();
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[97\\%\\] > div.m-24.w-full.flex.items-center > nav > ul > li:nth-child(5) > button")).click();
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[97\\%\\] > div.m-24.w-full.flex.items-center > nav > ul > li:nth-child(1) > button")).click();
    }*/

    @Test
    @DisplayName("Validação do campo de pesquisa")
    public void validarCampoDePesquisa() throws InterruptedException {
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-header > div > div > div > div > div > input")).sendKeys("noob");
        String userName = navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[100\\%\\].flex.flex-col > div.table-responsive.mb-12.shadow-\\[0px_2px_10px_0px_rgba\\(76\\,78\\,100\\,0\\.22\\)\\].rounded-6.w-\\[100\\%\\] > table > tbody > tr > th:nth-child(2) > p")).getText();
        Assertions.assertEquals("noobMaster69", userName);
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("Validação do Filtro de pesquisa")
    public void validarFiltroPesquisa() {
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-header > div > div > div > button")).click();
        navegador.findElement(By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-bzrhm4 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.MuiDrawer-paper.MuiDrawer-paperAnchorRight.css-1lf2bl8 > div > div.h-\\[100\\%\\].gap-28.flex.flex-col.justify-between.px-14.py-14 > button")).click();
    }

    @Test
    @DisplayName("Validação do Filtro utilizando o campo da data")
    public void validarFiltrodata() throws InterruptedException {
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-header > div > div > div > button")).click();
        navegador.findElement(By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-bzrhm4 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.MuiDrawer-paper.MuiDrawer-paperAnchorRight.css-1lf2bl8 > div > div.h-\\[100\\%\\].gap-28.flex.flex-col.justify-between.px-14.py-14 > div.MuiFormControl-root.MuiTextField-root.css-dlwbzx > div")).click();
        Thread.sleep(2000);
    }

    @Test
    @DisplayName("Validação de busca por filtro data")
    public void validarBuscaFiltroData() {
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-header > div > div > div > button")).click();
        navegador.findElement(By.cssSelector("")).click();
        navegador.findElement(By.id("Date")).sendKeys("03102023");
        navegador.findElement(By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-bzrhm4 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.MuiDrawer-paper.MuiDrawer-paperAnchorRight.css-1lf2bl8 > div > div.h-\\[100\\%\\].gap-28.flex.flex-col.justify-between.px-14.py-14 > div.flex.justify-around.mt-120.gap-20 > button.MuiButton-root.MuiButton-text.MuiButton-textInherit.MuiButton-sizeMedium.MuiButton-textSizeMedium.MuiButton-colorInherit.MuiButtonBase-root.bg-\\[\\#266284\\].text-\\[\\#F5F5F5\\].font-sans.font-700.leading-5.uppercase.text-10.px-\\[26px\\].py-\\[8px\\].tracking-wide.css-zr41vw")).click();
    }

    @Test
    @DisplayName("Validação do botão visualizar contato")
    public void validarBotaoVisualizarContato() throws InterruptedException {
        //navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[100\\%\\].flex.flex-col > div.table-responsive.mb-12.shadow-\\[0px_2px_10px_0px_rgba\\(76\\,78\\,100\\,0\\.22\\)\\].rounded-6.w-\\[100\\%\\] > table > tbody > tr:nth-child(1) > th:nth-child(6) > div > button:nth-child(1)")).click();
        //Thread.sleep(3000);
        navegador.findElement(By.cssSelector("#fuse-main > div > div > div > div > div > div.FusePageSimple-content.container.css-1aat207.ps > div.w-\\[100\\%\\].flex.flex-col > div.table-responsive.mb-12.shadow-\\[0px_2px_10px_0px_rgba\\(76\\,78\\,100\\,0\\.22\\)\\].rounded-6.w-\\[100\\%\\] > table > tbody > tr:nth-child(1) > th:nth-child(6) > div > button:nth-child(2)")).click();
        Thread.sleep(3000);
    }

}
