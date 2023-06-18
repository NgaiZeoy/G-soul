package cn.com.gamersoul.entity;

public class NewUser {
    String username;
    String mem_phone;
    String password;
    String verify_code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    public void setMem_phone(String mem_phone) {
        this.mem_phone = mem_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "username='" + username + '\'' +
                ", mem_phone='" + mem_phone + '\'' +
                ", password='" + password + '\'' +
                ", verify_code='" + verify_code + '\'' +
                '}';
    }
}
