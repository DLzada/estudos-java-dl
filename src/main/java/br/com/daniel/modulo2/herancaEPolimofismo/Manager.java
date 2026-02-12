package br.com.daniel.modulo2.herancaEPolimofismo;

public class Manager extends Employee{
    private  String Login;
    private String password;
    private String commission;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }
}
