import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.JSONArrayUtil;

@Slf4j
public class ArrayTest {

    private static String fileName = "src\\test\\java\\case\\";
    @Test
    public void test() {
        JSONArrayUtil.parseFile2Obj(fileName + "data.json", String.class);

    }
}
