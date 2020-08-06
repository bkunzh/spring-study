package env;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Ignore
public class EnvTest {
    private static final Logger log = LoggerFactory.getLogger(EnvTest.class);
    @Test
    public void envVal() {
        String s= System.getenv("java_home");
        String s2 = System.getenv("JAVA_HOME");
        System.out.println(s);
        System.out.println(s2);
        String fileDir = System.getenv("download_file_dir");
        System.out.println(fileDir);
        log.info("路径: " + fileDir);
    }
}
