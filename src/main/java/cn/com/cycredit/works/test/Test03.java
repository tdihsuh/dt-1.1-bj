package cn.com.cycredit.works.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by George on 2017/12/21.
 */
public class Test03 {
        public static void  main(String[] args){
            System.out.println(ifGood());
        }
        public static Map ifGood(){
            Map resultMap = new HashMap<String,Integer>();
            for(int x=1;x<=36/4;x++){
                for(int y=1;y<=36/3;y++){
                    int z = 36-x-y;
                    if(z%2==0 && (x*4+y*3+z/2==36)){
                        resultMap.put("man",x);
                        resultMap.put("woman",y);
                        resultMap.put("kids",z);
                        break;
                    }
                }
            }
            return resultMap;
        }
    }
