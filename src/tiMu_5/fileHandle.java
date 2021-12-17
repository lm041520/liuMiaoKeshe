package tiMu_5;

import java.io.File;

public class fileHandle {

   /* 任务描述：在日常工作中，经常会遇到批量操作系统文件的事情，通常情况下，只能手动重复地完成批量文件的操作，这样很是费时费力。本案例要求编写一个文
   件管理器，实现文件的批量操作。
    技术要求：创建一个文件管理器类。通过File类的相关方法完成以下操作。

   /*（1）用户输入指令1，代表“指定关键字检索文件”，此时需要用户输入检索的目录和关键字，系统在用户指定的目录下检索出文件名中包含关键字的文件，并将其绝
    对路径展示出来。*/

    //  get AbsolutePath()  获取绝对路径
    public static void selectFile(String mulu,String core){
        File file = new File(mulu);
        String[] list = file.list();
        System.out.println("file为："+file);
        boolean flag=true;
        for (String a : list) {
            System.out.println(a);//endwith();
//            if (a.equals(core)) {
//                System.out.println(new File(mulu, core).getAbsolutePath());
//                flag = false;
//                break;
//            }
        }
        if (flag) {
            System.out.println("该目录下没有改文件，请重新输入");
        }
    }


   /* (2）用户输入指令2，代表“指定后缀名检索文件”，此时需要用户输入检索的目录和后缀名（多个后缀名用逗号分隔），系统在用户指定的目录下检索出指定
    后缀名的文件，并将其绝对路径展示出来。*/


    //（3）用户输入指令3，代表“复制文件/目录”，此时需要用户输入源目录和目标目录，程序执行后会将源目录下的内容复制到目标目录下。




    // （4）用户输入指令4，代表“删除文件/目录”，此时需要用户输入需要删除掉的文件目录，程序执行后会将目录以及目录下的内容全部删除。



//    （5）用户输入指令5，代表“退出”，即退出该系统。
    public static void main(String[] args) {
    String file="D:\\Git-space";
    String core="aaa.txt";
        selectFile(file,core);

   }

}
