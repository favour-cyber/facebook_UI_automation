package Signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class SigninTest {
    private WebDriver driver;
    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://web.facebook.com/?stype=lo&jlou=AffUgiSg-2I9U6WFvWhUNetGoM76ZUEeFhUbTiB0MXD3qEbBSCIGK121gTiqxdZLRQn88diQy7Mqx7Hy-F9NuYZOOAAePWLC0yasj1zuRSKCzA&smuh=42323&lh=Ac-vz2MV0INa5fX5aFE");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("email")).sendKeys("iloriadenike5@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("favour2020");
        driver.findElement(By.name("login")).click ();
    }
    @Test(priority = 0)
    public void testSuccessfulSignin(){
        if (driver.getCurrentUrl ().contains ("https://web.facebook.com/?sk=welcome"))
            //Pass
            System.out.println ("The Page URL contains facebook.com");
        else
            //Fail
            System.out.println ("The Page URL does not contain facebook.com");
    }
    @Test(priority = 1)
    public void testLogout() throws InterruptedException {
        //click on the profile button
        driver.findElement (By.cssSelector ("#mount_0_0 > div > div:nth-child(1) > div.rq0escxv.l9j0dhe7.du4w35lb > div:nth-child(4) > div.ehxjyohh.kr520xx4.poy2od1o.b3onmgus.hv4rvrfc.n7fi1qx3 > div.du4w35lb.l9j0dhe7.byvelhso.rl25f0pe.j83agx80.bp9cbjyn > span > div > div.oajrlxb2.gs1a9yip.g5ia77u1.mtkw9kbi.tlpljxtp.qensuy8j.ppp5ayq2.goun2846.ccm00jje.s44p3ltw.mk2mc5f4.rt8b4zig.n8ej3o3l.agehan2d.sk4xxmp2.rq0escxv.nhd2j8a9.pq6dq46d.mg4g778l.btwxx1t3.pfnyh3mw.p7hjln8o.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.tgvbjcpo.hpfvmrgz.jb3vyjys.rz4wbd8a.qt6c0cv9.a8nywdso.l9j0dhe7.i1ao9s8h.esuyzwwr.f1sip0of.du4w35lb.lzcic4wl.abiwlrkh.p8dawk7l > img")).click ();
        Thread.sleep (2000);
        //click on the logout button
        driver.findElement (By.xpath ("//*[@id=\"mount_0_0\"]/div/div[1]/div[1]/div[2]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click ();
        //printout response based on status
        if(driver.getCurrentUrl ().contains ("https://web.facebook.com/?stype=lo&jlou=AffYfYcIShIK84QcP8XCBT4WZM QP2ek-7jhJQOvhJlPH5YEyHpQtdnDqKpIPd1YOR362EOBSCgQMfsEMyEixPDoBncMEP-QGIbiSpvs4Anqy_Q&smuh=42323&lh=Ac_kkeX-4QQtdJhTa0g"))
            //Pass
            System.out.println ("The Login page URL contains facebook.com/");
        else
            //Fail
            System.out.println ("The Login URL does not contain facebook.com/");
    }
    @Test(priority = 1)
    public void testNegativeLogin(){
        driver.findElement (By.id ("email")).sendKeys ("invalidemail.com");
        driver.findElement (By.id ("pass")).sendKeys ("favour2020");
        driver.findElement (By.xpath ("//*[@id=\"u_0_f\"]")).click ();
        String expectedErrorMessage = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
        String actualErrorMessage = driver.findElement(By.xpath ("//*[@id=\"email_container\"]/div[2]/a")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    public static void guru99() throws InterruptedException {
        SigninTest test = new SigninTest();
        test.setUp();
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}

