import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;



public class ssdTestAPI {


    int status;


    public void getRequest(String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            JSONObject jsonObj = new JSONObject(content);
            int status = (Integer) jsonObj.get("status");
            this.status = status;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @Test
    public void testList() {
        getRequest("https://example.com");
        Assert.assertEquals(1, status);
    }


}




