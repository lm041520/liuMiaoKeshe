package tiMu_3;

import java.nio.channels.NonWritableChannelException;
import java.util.HashMap;
import java.util.Scanner;

public class translation {
    public static void main(String[] args) {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("hello", "你好");
        hs.put("china", "中国");
        System.out.println("hello");
        hs.put("love", "爱");
        hs.put("I", "我");
        hs.put("i", "我");
        hs.put("Hello", "你好");
        hs.put("Happy", "快乐");
        hs.put("everday", "每一天");
        hs.put("everday", "每一天");
        hs.put("everday", "每一天");
        hs.put("everday", "每一天");
        hs.put("everday", "每一天");
        Scanner sc= new Scanner(System.in);

        while(true)
        {
            System.out.println("请输入想要翻译的字符串：");
            String str=sc.nextLine();
            select(str, hs);
        }

    }
    private static void select(String w, HashMap<String, String> word) {
        //indexOf(String str)
        //get(Object key) ;
        char str[]=w.toCharArray();
        String key = "";
        String content="";
        boolean flage=true;
        for(int i=0;i<w.length();i++)
        {
            if(str[i]!=' ')
            {
                key=key+str[i];
            }else  if(str[i]==' ' )
            {
                //System.out.println(key);

                if(word.get(key)!=null){
                    content=content+word.get(key);
                }else{
                    flage=false;
                    break;
                }
                key="";
            }
            if(i==w.length()-1)
            {
                //System.out.println(key);
                //System.out.print(word.get(key));

                if(word.get(key)!=null){
                    content=content+word.get(key);
                }else{
                    flage=false;
                    break;
                }
            }
        }
        if(flage)
            System.out.println(content);
        else
            System.out.println("您所查询的句子，有单词未收录，请重新输入");
    }
}
