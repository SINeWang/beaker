package wang.yanjiong.beaker.combi;

import org.junit.Test;
import org.smartea.beaker.example.implement.frontdesk.WelcomeLabor;
import org.smartea.beaker.example.regulation.frontdesk.api.WelcomeRegulation;
import org.smartea.beaker.example.regulation.frontdesk.entity.Visitor;
import wang.yanjiong.beaker.combi.cubes.basic.api.Response;

import java.util.concurrent.*;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class CombinatorTest {


    @Test
    public void main() {

        Visitor visitor = new Visitor();
        visitor.setName("zhangsan");


        NRCombinator combinator = new NRCombinator();

        combinator.addCubes(WelcomeRegulation.class, new WelcomeLabor());
        combinator.addDroplets(visitor);

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
