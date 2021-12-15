package tiMu_1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student st1=new Student("001","liumiao", "18", "郑州");
        ArrayList<Student> array=new ArrayList<>();
        array.add(st1);
        while (true)
        { System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 查看所有学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出系统");
            System.out.println("请输入你的选择：");
            int i=sc.nextInt();
            if(i==1)
            {
                StudentDao.findAllStudent(array);
            }
            else if(i==2)
            {
                StudentDao.addStudent(array);
            }
            else if(i==3)
            {
                StudentDao.deleteStudent(array);
            }
            else if(i==4)
            {
                StudentDao.updateStudent(array);
            }
            else if(i==5)
            {
                System.out.println("已退出系统，谢谢使用-.-");
                return ;
            }

        }
    }

}
