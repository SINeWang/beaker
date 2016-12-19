package wang.yanjiong.beaker.vessels.cc.server;

import wang.yanjiong.beaker.vessels.cc.message.CompensationRequest;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public interface CompensationServer {


    CompensationRequest process(CompensationRequest request);

}
