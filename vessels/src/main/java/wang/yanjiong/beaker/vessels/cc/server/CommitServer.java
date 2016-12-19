package wang.yanjiong.beaker.vessels.cc.server;

import wang.yanjiong.beaker.vessels.cc.message.CommitRequest;
import wang.yanjiong.beaker.vessels.cc.message.CommitResponse;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public interface CommitServer {


    CommitResponse process(CommitRequest request, CommitConsumer consumer);
}
