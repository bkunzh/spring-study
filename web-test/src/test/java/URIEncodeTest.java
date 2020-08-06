import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author bingkun_zhang
 * @date 2020/7/15
 */
public class URIEncodeTest {
    @Test
    public void test() {
        String s = "审批中";
        try {
            System.out.println(URLEncoder.encode(s, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
