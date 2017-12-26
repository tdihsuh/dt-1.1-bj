package works.test;

import net.sf.json.JSONObject;

/**
 * Created by George on 2017/12/21.
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        JSONObject valueJsonObject = JSONObject.fromObject("{'name':'','gender':'man','age':12}");
        String name =(String) valueJsonObject.get("name");
        System.out.println(name);
    }
}
