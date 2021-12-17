package tiMu_5;

import jdk.jfr.StackTrace;

import java.io.*;
import java.util.Scanner;

public class fileHandle {

   /* 任务描述：在日常工作中，经常会遇到批量操作系统文件的事情，通常情况下，只能手动重复地完成批量文件的操作，这样很是费时费力。本案例要求编写一个文
   件管理器，实现文件的批量操作。
    技术要求：创建一个文件管理器类。通过File类的相关方法完成以下操作。

   /*（1）用户输入指令1，代表“指定关键字检索文件”，此时需要用户输入检索的目录和关键字，系统在用户指定的目录下检索出文件名中包含关键字的文件，并将其绝
    对路径展示出来。*/

    //  get AbsolutePath()  获取绝对路径
    public static void selectFile(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入文件目录：");
        String mulu=sc.nextLine();
        System.out.println("请输入要查询的文件的关键字：");
        String core=sc.nextLine();
        File file = new File(mulu);
        String[] list = file.list();
       // System.out.println("file为："+file);
        boolean flag=true;
        for (String a : list) {
            if(a.contains(core))//如果在次目录下包含次关键字  则输出其绝对路径
            {
                System.out.println("该文件存在，其绝对路径为：");
                File file1 = new File(file, a);
                System.out.println(file1);
                flag=false;
                break;
            }
        }
        if (flag) {
            System.out.println("该目录下没有改文件，请重新输入");
        }
    }


   /* (2）用户输入指令2，代表“指定后缀名检索文件”，此时需要用户输入检索的目录和后缀名（多个后缀名用逗号分隔），系统在用户指定的目录下检索出指定
    后缀名的文件，并将其绝对路径展示出来。*/
   public static void selectFileHou(){
       Scanner sc=new Scanner(System.in);
       System.out.println("请输入文件目录：");
       String mulu=sc.nextLine();
       System.out.println("请输入要查询的文件的后缀：");
       String hou=sc.nextLine();

       File file = new File(mulu);
       String[] list = file.list();//得到目录下所有文件的文件名
       //查询其后缀
       int flag=0;
       for (String a : list) {

           if(a.contains(hou))//如果在次目录下包含次关键字  则输出其绝对路径
           {   if(flag==0)
               System.out.println("该文件存在，其绝对路径为:");
               File file1 = new File(file, a);
               System.out.println(file1);
               flag++;
           }
       }
       if (flag==0) {
           System.out.println("该目录下没有该后缀的文件，请重新输入");
       }
   }


    //（3）用户输入指令3，代表“复制文件/目录”，此时需要用户输入源目录和目标目录，程序执行后会将源目录下的内容复制到目标目录下。
    public static void FileCopy(File srcFile, File aimFile) {
        File[] files = srcFile.listFiles();//得到文件目录下的所有文件  转换为File类型数组
        //遍历这个File数组，如果是目录的话则在目标文件下创建该目录
        for (int i = 0; i < files.length; i++) {//遍历这个File数组
            if (files[i].isDirectory())//判断这个文件是否是目录 如果是的话在目标文件下创建该目录
            {
                File creatFile = new File(aimFile.getAbsolutePath(), files[i].getName());//在目标文件的目录下创建显得目录
                creatFile.mkdirs();
                FileCopy(files[i], creatFile);//递归，如果是文件夹的话，再对这个文件夹进行复制
            } else if (files[i].isFile())//如果是文件的话，将次文件copy到目标文件目录下。
            {
                /*
                 * 在整个文件夹进行读取的是后，因为没有办法确定文件的类型是字节还是字符，所以按照字节进行读取，确保不会乱码。
                 * */
                //原文件是files[i]    目标文件是下面创建的这个，将源文件的数据读到目标文件即copy成功。
                FileInputStream fis = null;
                FileOutputStream fos = null;
                try {
                    File creatFile = new File(aimFile.getAbsolutePath(), files[i].getName());//在目标文件的目录下创建显得目录
                    creatFile.createNewFile();
                    //创建输入输出流对象
                    fis = new FileInputStream(files[i]);
                    fos = new FileOutputStream(creatFile);
                    //数据读入和写出操作
                    byte[] arss = new byte[1024];
                    int len;
                    while ((len = fis.read(arss)) != -1) {
                        fos.write(arss, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭流
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (fis != null)
                            fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void selectFileCopy(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入源文件目录：");
        String src=sc.nextLine();
        System.out.println("请输入复制文件的目标目录：");
        String aim=sc.nextLine();
        File filesrc = new File(src);
        File fileaim = new File(aim);//renameTo()
        FileCopy(filesrc,fileaim );
        System.out.println("复制成功，请您检查文件夹！！！");
    }



    // （4）用户输入指令4，代表“删除文件/目录”，此时需要用户输入需要删除掉的文件目录，程序执行后会将目录以及目录下的内容全部删除。

    public static void deleteFile( File mulu){
        File [] fileList = mulu.listFiles();//得到目录下所有文件的文件名
        for (int i = 0; i < fileList.length; i++) {//执行删除文件操作
             if(fileList[i].isFile()){//如果是文件直接删除
                 fileList[i].delete();
             }
              else  if(fileList[i].isDirectory()){//如果是文件夹递归
                    deleteFile(fileList[i]);
                    //空文件夹直接删除
                 fileList[i].delete();
             }
        }
        //再把主文件夹删除
        mulu.delete();
    }



    public static void FileDelete(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入想要删除的文件目录：");
        String mulu=sc.nextLine();
        File file = new File(mulu);
        deleteFile(file);
        System.out.println("删除成功，你已失去心爱的它-.- ");

    }


//    （5）用户输入指令5，代表“退出”，即退出该系统。


}
