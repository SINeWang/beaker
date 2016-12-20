package wang.yanjiong.beaker.vessels.cc.client.http11;

import wang.yanjiong.beaker.vessels.cc.client.CommitProvider;

import java.net.URI;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public interface URLResolver {

    URI getURIByCommitProvider(CommitProvider provider);
}
