package tiMu_9;

public class User  implements Runnable{
     String name;
     String lognName;
     String password;
     double money;
     String quTime;
     String cunTime;

    public String getCunTime() {
        return cunTime;
    }

    public void setCunTime(String cunTime) {
        this.cunTime = cunTime;
    }

    public String getQuTime() {
        return quTime;
    }

    public void setQuTime(String quTime) {
        this.quTime = quTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLognName() {
        return lognName;
    }

    public void setLognName(String lognName) {
        this.lognName = lognName;
    }

    @Override
    public void run() {

    }
}
