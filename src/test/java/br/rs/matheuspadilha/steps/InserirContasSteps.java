package br.rs.matheuspadilha.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class InserirContasSteps {
    
    private WebDriver driver;
    
    @Dado("^que eu desejo adicionar uma conta$")
    public void queEuDesejoAdicionarUmaConta() throws Throwable {
        /* Acessando site */
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/drivers/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
        
        /* Realizando login */
        driver.findElement(By.id("email")).sendKeys("userTeste@email.com");
        driver.findElement(By.id("senha")).sendKeys("password");
        driver.findElement(By.xpath("//button[.='Entrar']")).click();
    
        /* Verificando texto pagina inicial */
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Teste!", texto);
    
        /* Acessando menu contas e submenu adicionar */
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
    }
    
    @Quando("^adiciono a conta \"([^\"]*)\"$")
    public void adicionoAConta(String arg1) throws Throwable {
        /* Adicionando conta */
        driver.findElement(By.id("nome")).sendKeys(arg1);
        
        /* Clicando em salvar */
        driver.findElement(By.xpath("//button[.='Salvar']")).click();
    }
    
    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() throws Throwable {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/drivers/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
    }
    
    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String arg1) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }
    
    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String arg1) throws Throwable {
      driver.findElement(By.id("senha")).sendKeys(arg1);
    }
    
    @Quando("^seleciono entrar$")
    public void selecionoEntrar() throws Throwable {
       driver.findElement(By.xpath("//button[.='Entrar']")).click();
    }
    
    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Teste!", texto);
    }
    
    @Quando("^seleciono Contas$")
    public void selecionoContas() throws Throwable {
        driver.findElement(By.linkText("Contas")).click();
    }
    
    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() throws Throwable {
        driver.findElement(By.linkText("Adicionar")).click();
    }
    
    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) throws Throwable {
        driver.findElement(By.id("nome")).sendKeys(arg1);
    }
    
    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() throws Throwable {
        driver.findElement(By.xpath("//button[.='Salvar']")).click();
    }
    
    @Então("^a conta é inserida com sucesso$")
    public void aContaÉInseridaComSucesso() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
    
    @Então("^sou notificado que o nome da conta é obrigatório$")
    public void souNotificadoQueONomeDaContaÉObrigatório() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Informe o nome da conta", texto);
    }
    
    @Então("^sou notificado que já existe uma conta com esse nome$")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
    }
    
    @Então("^recebo a mensagem \"([^\"]*)\"$")
    public void receboAMensagem(String arg1) throws Throwable {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);
    }
    
    @After(order = 1)
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/"+ cenario.getId() +".jpg"));
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
    
    @After(order = 0)
    public void fecharBrowser() {
        driver.quit();
    }
}

