package wang.yanjiong.beaker.combi.cubes.basic;

import java.util.Date;

/**
 * Created by WangYanJiong on 11/11/16.
 */
public abstract class Action {


    private final String commitId;

    private final String id;

    private final Date dateTime = new Date();

    public Action(Commit commit) {
        this.commitId = commit.getId();
        this.id = null;
    }

    public String getId(){
        return id;
    }

    public Date getDateTime(){
        return dateTime;
    }

    public String getCommitId(){
        return commitId;
    }
}
