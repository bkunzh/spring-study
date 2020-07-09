package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bingkun_zhang
 * @date 2020/7/9
 */
public class StringTest {
    static char[] SEPARATORS = new char[] {'=', ':'};
    @Test
    public void t() {
//        String s = "(([\\S&&[^\\\\=:]]|\\\\.)*)(\\s*(\\s+|[=:])\\s*)(.*)";
//        System.out.println(s);
        final Pattern PROPERTY_PATTERN = Pattern
                .compile("(([\\S&&[^\\\\" + new String(SEPARATORS)
                        + "]]|\\\\.)*)(\\s*(\\s+|[" + new String(SEPARATORS)
                        + "])\\s*)(.*)");
        System.out.println(PROPERTY_PATTERN.pattern());
        Matcher matcher = PROPERTY_PATTERN.matcher("abcd.a=53aa");
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            System.out.println(matcher.group(matcher.group("g1")));
        }
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(4));
        System.out.println(matcher.group(5));
    }
}
