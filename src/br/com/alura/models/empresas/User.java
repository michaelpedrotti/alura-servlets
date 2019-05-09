package br.com.alura.models.empresas;

public class User {

    private String username;
    private String password;

    public String getUser() {
        return this.username;
    }

    public User setUser(String username) {
        this.username = username;
        return this;
    }

    public String getPass() {
        return this.password;
    }

    public User setPass(String password) {
        this.password = password;
        return this;
    }

    public boolean equals(String login, String senha) {
        if(!this.username.equals(login)) {
            return false;
        }

        if(!this.password.equals(senha)) {
            return false;
        }

        return true;
    }
    
    public static User newInstance(){
    	return new User();
    }
}