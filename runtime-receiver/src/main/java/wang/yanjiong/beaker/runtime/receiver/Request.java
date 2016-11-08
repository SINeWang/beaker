package wang.yanjiong.beaker.runtime.receiver;

/**
 * Created by WangYanJiong on 11/8/16.
 */
public interface Request {

    RequestID getRequestID();

    Deadline getDeadline();
}
