package wang.yanjiong.beaker.cube.id.combi.receiver;

/**
 * Created by WangYanJiong on 11/8/16.
 */
public class Receiver {

    public Receipt receive(Request request) {
        return new Receipt() {
            public ReceiptID getReceiptID() {
                return null;
            }

            public ReceiverID getReceiverID() {
                return null;
            }
        };
    }
}
