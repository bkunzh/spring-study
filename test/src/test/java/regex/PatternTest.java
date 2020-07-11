package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bingkun_zhang
 * @date 2020/7/9
 */
public class PatternTest {

    /*
    https://www.cnblogs.com/ljhdo/p/10678281.html
    在正则表达式中，分组编号是自动进行的。当使用圆括号表示分组时，从正则表达式的左边开始看，
    看到的第一个左括号 “(” 表示第一个分组，第二个 "(" 表示第二个分组，依次类推，
    需要注意的是，有一个隐含的全局分组（分组编号是0），就是整个正则表达式。
    默认情况下，正则表达式为每个分组自动分配一个组号，规则是：组号从1开始，从左向右，组号依次加1（base+1），
    例如，第一个分组的组号为1，第二个分组的组号为2，以此类推。

    (?:exp) ：分组，但不捕获该分组匹配到的文本
    无捕获分组没有名称，也没有编号，因此，无法引用无捕获分组，无捕获分组不会占用分组编号。
     */
    @Test
    public void group() {
        // \1 和第一个分组一样字符串，而不是一样模式
        String p = "([abc]{3})  2\\1 d";
        String p2 = "([abc]{3})  2([abc]{3}) d";

        Matcher matcher = Pattern.compile(p).matcher("aba  2aba d");
        System.out.println(matcher.groupCount());
        System.out.println(matcher.matches());
        System.out.println(matcher.group(1));
        System.out.println("aba  2abc d".matches(p));

        System.out.println("aba  2abc d".matches(p2));

        System.out.println("--------");
        Pattern p3 = Pattern.compile("(aa(bb)(cc)) \\1 (dd(?:ff)(ee))");
        String s2 = "aabbcc aabbcc ddffee";
        Matcher matcher3 = p3.matcher(s2);
        System.out.println(matcher3.matches());
        matcher3.reset(); // reset
//        System.out.println(matcher3.find()); // find
        if (matcher3.find()) {
            System.out.println(matcher3.group(1));
            System.out.println(matcher3.groupCount());
            System.out.println(matcher3.group(5));
        }

        System.out.println("-----");
        Pattern p4 = Pattern.compile("a[bc]{1,2}");
        String s4 = "abc ab tabb tab xxa 2 ac";
        Matcher matcher4 = p4.matcher(s4);
        int count = 0;
        while (matcher4.find()) {
            ++count;
            System.out.println(matcher4.group());
        }

        System.out.println("count = " + count);
//        matcher4.reset();
//        System.out.println(matcher4.find());

    }
}
