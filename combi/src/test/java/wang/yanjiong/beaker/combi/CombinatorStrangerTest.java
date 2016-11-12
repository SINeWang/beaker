package wang.yanjiong.beaker.combi;

import org.junit.Test;
import org.smartea.beaker.example.implement.frontdesk.WelcomeLabor;
import org.smartea.beaker.example.regulation.frontdesk.api.WelcomeRegulation;
import org.smartea.beaker.example.regulation.frontdesk.entity.IdentityCard;
import org.smartea.beaker.example.regulation.frontdesk.entity.Stranger;
import org.smartea.beaker.example.regulation.frontdesk.entity.Visitor;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;

import java.util.concurrent.*;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class CombinatorStrangerTest {


    @Test
    public void main() {

        Stranger stranger = new Stranger();
        IdentityCard identityCard = new IdentityCard();
        identityCard.setName("lisi");
        stranger.setIdentityCard(identityCard);


        NRCombinator combinator = new NRCombinator();

        combinator.addCubes(WelcomeRegulation.class, new WelcomeLabor());
        combinator.addDroplets(stranger);

        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Response> cs = new ExecutorCompletionService<Response>(threadPool);


        cs.submit(combinator);
        try {
            System.out.println(cs.take().get().getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
