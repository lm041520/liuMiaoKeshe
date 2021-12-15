package tiMu_1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDao {
    public static void findAllStudent(ArrayList<Student> array)//查看所有学生信息
    {
        if(array.size()==0)
        {
            System.out.println("学生暂时为空，请您先添加学生信息！");
        }
        else
        {
            for(Student st:array)
            {
                System.out.println(st.toString());
            }
        }
    }
    public static void addStudent(ArrayList<Student> array)//添加学生信息
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String number=sc.nextLine();
        System.out.println("请输入学生姓名：");
        String name=sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age=sc.nextLine();
        System.out.println("请输入学生地址：");
        String address=sc.nextLine();
        Student st=new Student(number,name,age,address);
        array.add(st);
        System.out.println(st.toString());
        System.out.println("添加学生成功！！！");
    }
    public static void deleteStudent(ArrayList<Student> array)//删除学生信息
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入删除学生的学号：");
        String number=sc.nextLine();
        for(int i=0;i<array.size();i++)
        {
            if(array.get(i).number.equals(number))
            {
                array.remove(i);
                System.out.println("已成功删除学号为："+number+"的学生。");
                break;
            }
            else  if(i==array.size())
            {
                System.out.println("删除错误，学号为"+number+"的学生不存在。");
            }
        }

    }
    public static void updateStudent(ArrayList<Student> array) //修改学生信息
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入修改学生的学号：");
        String number=sc.nextLine();
        for(int i=0;i<array.size();i++)
        {
            if(array.get(i).number.equals(number))
            {
                System.out.println("请输入修改信息的序号：\n1：修改学号\n2：修改姓名\n3：修改年龄\n4：修改地址\n5：修改全部信息");
                int index=sc.nextInt();
                if(index==1)
                {
                    System.out.println("请输入修改的学号值：");
                    String num=sc.nextLine();
                    array.get(i).number=num;
                    System.out.println("修改成功!!");
                }
                if(index==2)
                {
                    System.out.println("请输入修改的姓名值：");
                    array.get(i).name=sc.nextLine();
                    System.out.println("修改成功!!");
                }
                if(index==3)
                {
                    System.out.println("请输入修改的年龄值：");
                    array.get(i).age=sc.nextLine();
                    System.out.println("修改成功!!");
                }
                if(index==4){
                    System.out.println("请输入修改的地址值：");
                    array.get(i).address=sc.nextLine();
                    System.out.println("修改成功!!");
                }
                if(index==5){
                    System.out.println("请输入修改的学号值：");
                    array.get(i).number=sc.nextLine();
                    System.out.println("请输入修改的姓名值：");
                    array.get(i).name=sc.nextLine();
                    System.out.println("请输入修改的年龄值：");
                    array.get(i).age=sc.nextLine();
                    System.out.println("请输入修改的地址值：");
                    array.get(i).address=sc.nextLine();
                    System.out.println("修改成功!!");
                }
                break;
            }
            else if(i==array.size()-1)
            {
                System.out.println("修改错误，学号为"+number+"的学生不存在。");
            }

        }
    }
}
