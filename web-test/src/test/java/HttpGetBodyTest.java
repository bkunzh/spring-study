import com.bkunzh.webtest.vo.ReturnObject;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/7/15
 */
public class HttpGetBodyTest {
    @Test
    public void httpTest() throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://localhost:80")
                .path("/pm/workorder/list");
//        builder.queryParam("status", "审批中");[{"key":"pmCode","value":"P15","equals":true,"description":"","enabled":true}]
//        builder.queryParam("status", URLEncoder.encode("审批中", "UTF-8"));
//        builder.queryParam("pmCode", "aa");
        URI targetUrl = builder.build().toUri();
        System.out.println(targetUrl);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "审批中");
        map.put("pmCode", "aa");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> formEntity = new HttpEntity<>(map, headers);

        // restTemplate get不支持body，但postman是可以的，可能约定get不包含body
        ReturnObject result = restTemplate.exchange(targetUrl, HttpMethod.POST, formEntity, ReturnObject.class).getBody();
        System.out.println(result);
    }
}
