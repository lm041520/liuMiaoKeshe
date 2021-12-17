package tiMu_5;

import java.util.Scanner;

public class fileHandleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------欢迎来到文件批量操作系统--------");
            System.out.println("1 指定关键字检索文件：请您输入检索的目录和关键字");
            System.out.println("2 指定后缀名检索文件：请您输入检索的目录和后缀名");
            System.out.println("3 复制文件/目录：请您输入源文件目录和目的文件目录");
            System.out.println("4 删除文件/目录：请输入删除文件的目录");
            System.out.println("5 退出系统");
            System.out.println("请输入你的选择：");
            int i = sc.nextInt();
            if (i == 1) {
                fileHandle.selectFile();
            } else if (i == 2) {
                fileHandle.selectFileHou();
            } else if (i == 3) {
                fileHandle.selectFileCopy();
            } else if (i == 4) {
                fileHandle.FileDelete();
            } else if (i == 5) {
                System.out.println("已退出系统，谢谢使用-.-");
                return;
            }
        }
    }
}