package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import data.DataYaml;
import org.junit.Assert;
import pages.*;

import java.util.HashMap;

public class UserSteps {

    private Home home = new Home();
    private MenuHome menu = new MenuHome();
    private UsersGrid usersGrid = new UsersGrid();
    private UsersCreate usersCreate = new UsersCreate();
    private UsersShow usersShow = new UsersShow();
    private UsersEdit usersEdit = new UsersEdit();


    @Dado("que o usuario esta no sistema Agapito Server")
    public void queOUsuarioEstaNoSistemaAgapitoServer() {
        home.openPage();
    }

    @E("o usuario escolhe o menu usuarios")
    public void oUsuarioEscolhoOMenuUsuarios() {
        menu.clickUsers();
    }

    @E("o usuario clica no botão novo usuario")
    public void oUsuarioClicaEmNovoUsuario() {
        usersGrid.clickNewUser();
    }

    @E("o usuario preenche o campo {string} com {string}")
    public void oUsuarioPreencheOCampoCom(String field, String value) {
        usersCreate.fillField(field, value);
    }

    @Quando("o usuario clicar em salvar")
    public void oUsuarioClicarEmSalvar() {
        usersCreate.clickSave();
        usersCreate.setLastUser(usersShow.getCode());
    }

    @Então("o usuario deveria ver a mensagem {string}")
    public void oUsuarioDeveriaVerAMensagem(String message) {
        Assert.assertEquals(message, usersShow.getNotice());
    }

    @E("o usuario clicar em voltar")
    public void oUsuarioClicarEmVoltar() {
        usersShow.clickBack();
    }

    @Quando("o usuario consultar o ultimo usuario cadastrado")
    public void oUsuarioConsultarOUltimoUsuarioCadastrado() {
        usersGrid.clickShowUser(usersCreate.getLastUser());
    }

    @Então("o usuario deveria ver {string} com {string}")
    public void oUsuarioDeveriaVerCom(String field, String value) throws InterruptedException {
        String act = usersShow.fillField(field);
        Assert.assertEquals(value, act);
    }

    @Quando("o usuario editar o ultimo usuario cadastrado")
    public void oUsuarioEditarOUltimoUsuarioCadastrado() {
        usersGrid.clickEditUser(usersCreate.getLastUser());
    }

    @E("o usuario preenche o campo {string} com {string} na Edição")
    public void oUsuarioPreencheOCampoComNaEdicao(String field, String value) {
        usersEdit.fillField(field, value);
    }

    @E("o usuario clicar em salvar na Edição")
    public void oUsuarioClicarEmSalvarNaEdicao() {
        usersEdit.clickSave();
    }

    @Quando("o usuario deleta o ultimo usuario cadastrado")
    public void oUsuarioDeletaOUltimoUsuarioCadastrado() {
        usersGrid.clickDeleteUser(usersCreate.getLastUser());
    }

    @E("o usuario confirma a deleção")
    public void oUsuarioConfirmaADelecao() {
        usersGrid.clickConfirmDelete();
    }

    @Então("o usuario não deveria ver o registro deletado")
    public void oUsuarioNaoDeveriaVerORegistroDeletado() {
        Assert.assertFalse(usersGrid.getShowButton(usersCreate.getLastUser()));
    }

    @E("que o usuario acabou de cadastrar o codigo {string}")
    public void queOUsuarioAcabouDeCadastrarOCodigo(String id) {
        usersCreate.setLastUser(id);
    }

    @Quando("o usuario criar um novo registro")
    public void oUsuarioCriarUmNovoRegistro() {
        HashMap map = new HashMap();
        map = DataYaml.getMapYamlValues("Academy","Usuario");

        usersGrid.clickNewUser();
        usersCreate.fillField("login", map.get("login").toString());
        usersCreate.fillField("nome completo", map.get("full_name").toString());
        usersCreate.fillField("email", map.get("email").toString());
        usersCreate.fillField("idade", map.get("age").toString());
        usersCreate.clickSave();

    }
}


