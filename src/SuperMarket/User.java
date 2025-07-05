package SuperMarket;

public class User {
    private String userName;
    private String email;
    private String password;
    private boolean isAdmin;
    public User(String userName,String email,String password,boolean isAdmin){
        this.email=email;
        this.userName=userName;
        this.password=password;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
}
