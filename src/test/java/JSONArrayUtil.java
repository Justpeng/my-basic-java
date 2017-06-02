package java;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 02/23/2017-18:37
 */
public class JSONArrayUtil {
    public static  String pareseJsonFileToString (String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
            bufferedReader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static JSONArray parseStr2Object(String str) {
        final Integer[] num = {0};
        JSONArray jsonArray = JSONArray.parseArray(str);

        jsonArray.forEach(a->{
            JSONArray s = JSONArray.parseArray( a.toString());
            num[0] += (Integer) s.get(1);

        });
        System.out.println(num[0] );

        return jsonArray;
    }

    public static <T> T parseFile2Obj(String filePath,Class<T> clazz) {
        return parseStr2Object(pareseJsonFileToString(filePath)).toJavaObject(clazz);
    }

}
