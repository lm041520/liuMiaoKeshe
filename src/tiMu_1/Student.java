package tiMu_1;

import java.util.ArrayList;

public class Student{

    String number;
    String name; String age; String address;
    public  Student(){

    }

    public Student(String number, String name, String age, String address) {
        this.number=number;
        this.name=name;
        this.age=age;
        this.address=address;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "学生学号为:"+this.number+"学生姓名为:"+this.name+"学生年龄为:"+this.age+"学生地址为:"+this.address+"\n";
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
