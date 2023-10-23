package iPuzzle.inicialPage;

import iPuzzle.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicialPage extends BasePage {

    private By localizadorDoTextoGrowdevTeste = By.xpath("//*[@class='MuiTypography-root MuiTypography-body1 font-semibold flex css-reofpl']");
    private By localizadorDoMenuHamburguer = By.xpath("//*[@class='shrink-0 fill-current  MuiBox-root css-wjsm5w']");
    private By localizadorDoBotaoContatos = By.xpath("(//*[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-padding MuiListItem-button fuse-list-item css-1qrkt4x'])[2]");
    private By localizadorDoBotaoCadastrarContato = By.cssSelector("body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-eaz53l > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.flex-col.flex-auto.h-full.MuiDrawer-paper.MuiDrawer-paperAnchorLeft.css-1fpbeqg > div > div.flex.flex-1.flex-col.min-h-0.css-mh0qts.ps > ul > ul.MuiList-root.MuiList-padding.open.css-1mxui7z > div > div > div > a:nth-child(2) > div > span");
    public InicialPage(WebDriver navegador) {
        super(navegador);
    }

    public String validarTextoGrowdevTeste() {
        return navegador.findElement(localizadorDoTextoGrowdevTeste).getText();
    }

    public void abrirTelaCadastrarContato() {
        navegador.findElement(localizadorDoMenuHamburguer).click();
        navegador.findElement(localizadorDoBotaoContatos).click();
        navegador.findElement(localizadorDoBotaoCadastrarContato).click();
    }

}
