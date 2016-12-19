package wang.yanjiong.beaker.vessels.cc.client;

import wang.yanjiong.beaker.vessels.cc.message.CommitRequest;
import wang.yanjiong.beaker.vessels.cc.message.CommitResponse;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public interface CommitClient {


    CommitResponse commit(CommitRequest request, CommitProvider provider);
}
