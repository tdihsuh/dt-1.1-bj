package cn.com.cycredit.works.test;

import net.sf.json.JSONObject;

/**
 * Created by George on 2017/12/21.
 */
public class Test02 {
        public static void  main(String[] args){
            System.out.println(ifGood(15651));
            System.out.println(15651/10000%10);
            System.out.println(15651/1000%10);
            System.out.println(15651/10%10);
            System.out.println(15651/1%10);

        }
        public static boolean ifGood(int value){
                return value/10000%10==value/1%10 && value/1000%10==value/10%10;
        }
    }
