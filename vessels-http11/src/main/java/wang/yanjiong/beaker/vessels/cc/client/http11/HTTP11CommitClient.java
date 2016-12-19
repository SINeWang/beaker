package wang.yanjiong.beaker.vessels.cc.client.http11;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import wang.yanjiong.beaker.vessels.cc.client.CommitClient;
import wang.yanjiong.beaker.vessels.cc.client.CommitProvider;
import wang.yanjiong.beaker.vessels.cc.message.CommitRequest;
import wang.yanjiong.beaker.vessels.cc.message.CommitResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public class HTTP11CommitClient implements CommitClient {


    public CommitResponse commit(CommitRequest request, CommitProvider provider) {

        CloseableHttpClient httpclient = HttpClients.createDefault();


        HttpPost httpPost = new HttpPost("http://targethost/login");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        try {
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
