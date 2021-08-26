package com.disneyPlusTests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginDisneyPlusTests {

    @Test
    public void shouldLoggerUser() {

        isChrome();
        open("https://www.disneyplus.com/pt-br");
        $(".nav-initial .wrapper a").shouldHave(text("Entrar")).click();

        $("#email").setValue("johnwick@gmail.com");
        $("button[data-gv2elementkey]").click();

        $("#password").setValue("johnwick@pencil");
        $("button[name=dssLoginSubmit]").click();
    }

    @Test
    public void incorrectPassword() {

        isChrome();
        open("https://www.disneyplus.com/pt-br");
        $(".nav-initial .wrapper a").shouldHave(text("Entrar")).click();

        $("#email").setValue("johnwick@gmail.com");
        $("button[data-gv2elementkey]").click();

        $("#password").setValue("johnwick@pencil");
        $("button[name=dssLoginSubmit]").click();

        $("div[data-testid=text-input-error]").shouldHave(text("Senha incorreta. Digite novamente. Se o " +
                "problema continuar, selecione \"Esqueceu a senha?\" e faça a redefinição (código de erro 14)."));

    }

    @Test
    public void userNotFound() {

        isChrome();
        open("https://www.disneyplus.com/pt-br");
        $(".nav-initial .wrapper a").shouldHave(text("Entrar")).click();

        $("#email").setValue("notfound@gmail.com");
        $("button[data-gv2elementkey]").click();

        $("button[data-testid=modal-secondary-button]").shouldHave(text("Assinar"));

    }

    @Test
    public void emailRequired() {

        isChrome();
        open("https://www.disneyplus.com/pt-br");
        $(".nav-initial .wrapper a").shouldHave(text("Entrar")).click();

        $("#email").setValue("");
        $("button[data-gv2elementkey]").click();

        $("div[data-testid=text-input-error]").shouldHave(text("Houve um problema na criação da conta. " +
                " Volte a digitar seu e-mail e senha e tente novamente. Se o problema continuar, entre em contato " +
                " com o Suporte do Disney+ (código de erro 6)."));

    }

    @Test
    public void passwordRequired() {

        isChrome();
        open("https://www.disneyplus.com/pt-br");
        $(".nav-initial .wrapper a").shouldHave(text("Entrar")).click();

        $("#email").setValue("johnwick@gmail.com");
        $("button[data-gv2elementkey]").click();

        $("#password").setValue("");
        $("button[name=dssLoginSubmit]").click();

        $("div[data-testid=text-input-error]").shouldHave(text("Houve um problema na criação da conta. " +
                " Volte a digitar seu e-mail e senha e tente novamente. Se o problema continuar, entre em contato " +
                " com o Suporte do Disney+ (código de erro 6)."));

    }
}
