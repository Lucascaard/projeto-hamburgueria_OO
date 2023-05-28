package main.model;

public class Usuario extends Pessoa{
    
    private String login;
    private String password;

    
    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public Usuario(String nome, Integer CPF, String sexo, String login,
    String password) {
        super(nome, CPF, sexo);
        this.login = login;
        this.password = password;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
