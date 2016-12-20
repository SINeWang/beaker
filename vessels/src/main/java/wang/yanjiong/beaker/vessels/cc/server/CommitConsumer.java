package wang.yanjiong.beaker.vessels.cc.server;

/**
 * Created by WangYanJiong on 12/19/16.
 */
public interface CommitConsumer {

    String getGroup();

    String getName();

    String getVersion();
}
