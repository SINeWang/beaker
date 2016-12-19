package wang.yanjiong.beaker.vessels.cc.client;

import wang.yanjiong.beaker.vessels.cc.message.CompensationRequest;
import wang.yanjiong.beaker.vessels.cc.message.CompensationResponse;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public interface CompensationClient {


    CompensationResponse compensation(CompensationRequest request);
}
