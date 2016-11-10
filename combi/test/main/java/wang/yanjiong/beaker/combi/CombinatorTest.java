package wang.yanjiong.beaker.combi;

/**
 * Created by WangYanJiong on 10/11/2016.
 */
public class CombinatorTest {

    public static void main(String[] args) {
        CombinatorTest test = new CombinatorTest();
        test.testCombinator();
    }

    public void testCombinator(){
        Combinator combinator = new Combinator();
        combinator
                .addCubes(AnnotatedClass.class)
                .addDroplets("aaaaa");
        new Thread(combinator).start();


    }
}
