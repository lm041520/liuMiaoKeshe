package tiMu_7;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class WordNumber {


    public   static void word()  {
       Scanner sc=new Scanner(System.in);
       System.out.println("请输入统计单词文件的路径");
       String src=sc.next();
       System.out.println("请输入单词统计后存放的路径");
       String aim=sc.next();
       File srcfile=new File(src);
       File aimfile=new File(aim);
       //字节输入流
        InputStream is= null;
        try {
            is = new FileInputStream(srcfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //转换流  字节——>字符
       InputStreamReader fis=new InputStreamReader(is);
       //缓存流
       BufferedReader bf=new BufferedReader(fis);

       TreeMap map=new TreeMap<String, Integer>();

        try {
            String str;
            while ((str=bf.readLine())!=null){  //读一行  得到的是每一行的单词数组
                String []arr=str.split(",|\\.|;|!|《|》|//?|\\s+|？|‘|。|’");
                for (String a:arr){
                    //System.out.println(a);
                    if(map.get(a)==null)//判断   如果这个单词没有被统计过的话就将单词数设置为1
                    {
                        map.put(a,1);
                    }
                    else {           //否则 ，如果这个单词被统计过，就再原来值的基础上++
                        int number= (int) map.get(a);
                        number++;
                        map.put(a,number);
                    }
                }
            }
            FileOutputStream fis2=new FileOutputStream(aim);
            OutputStreamWriter ow = new OutputStreamWriter(fis2);
            map.forEach((key, value) -> {  //遍历整个map  将 每对键值写入到目标文件-.-
                //System.out.println(key + ":" + value);
                try {
                    ow.write(key + ":" + value+"\n");//写入文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            ow.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关流
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("统计完毕，请注意查看目标文件哦-.-");
   }


}
