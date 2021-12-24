import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: rp
 * Date: 03.06.21
 * Time: 17:43
 */
public class SenderJob implements Job, Serializable {
    private static final long serialVersionUID = 3602994919880612803L;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
