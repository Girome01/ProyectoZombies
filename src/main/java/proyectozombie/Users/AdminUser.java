package proyectozombie.Users;

public class AdminUser extends User{

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean confirmPassword(String pass){
        return pass.equals(this.password);
    }
}
