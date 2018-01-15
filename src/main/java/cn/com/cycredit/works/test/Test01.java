package cn.com.cycredit.works.test;

import net.sf.json.JSONObject;

/**
 * Created by George on 2017/12/21.
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        JSONObject valueJsonObject = JSONObject.fromObject("{'name':'','gender':'man','age':12}");
        String name =(String) valueJsonObject.get("name");
        System.out.println(str2Hex("李新虎"));

        try {
            String decode = hex2String("\\xE9\\x83\\x91\\xE5\\xB7\\x9E\\xE5\\x90\\x8D\\xE6\\x99\\xAF\\xE9\\x81\\xAE\\xE9\\x98\\xB3\\xE6\\x8A\\x80\\xE6\\x9C\\xAF\\xE6\\x9C\\x89\\xE9\\x99\\x90\\xE5\\x85\\xAC\\xE5\\x8F\\xB8");
            System.out.println(decode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String hex2String(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        s = s.replace("\\", "");
        s = s.replace("x", "");
        s = s.replace("X", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
    public static String str2Hex(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }
}
