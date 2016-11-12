package wang.yanjiong.beaker.combi.droplets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by WangYanJiong on 12/11/2016.
 */
public class Droplets {

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteClassName);
    }
}
