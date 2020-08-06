import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 把Robo3T的json格式转化为可以运行的js脚本，方便导出多条数据
 * @author bingkun_zhang
 * @date 2020/6/16
 */
public class Robo3T_2_Json_Array {
    static String CLASS_ROOT_PATH = Robo3T_2_Json_Array.class.getResource("/").getPath();
    @Test
    public void convert() throws IOException {
        String collectionName = "T_AccBookMigration";
        BufferedReader reader = FileUtil.getReader(CLASS_ROOT_PATH + "not_json_array.txt", "utf-8");
        StringBuilder result = new StringBuilder("db." + collectionName + ".insertMany(" + "[");
        int emptyCount = 0;
        String s;
        while ((s = reader.readLine()) != null) {
            if (s.startsWith("/")) {
                if (!"/* 1 */".equals(s)) {
                    result.append(",");
                }
            } else if (s.isEmpty()) {
                ++emptyCount;
            } else {
                result.append(s);
                result.append("\n");
            }
        }
        System.out.println("emptyCount=" + emptyCount);
        result.append("])");
        String outFilePath = CLASS_ROOT_PATH + "json_array_rs.js";
        FileUtil.writeString(result.toString(), outFilePath, "utf-8");
        System.out.println("输出到: " + outFilePath);
    }
}
