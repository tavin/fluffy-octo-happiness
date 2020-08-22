import com.cloudbees.groovy.cps.NonCPS
import hudson.model.Result
import jenkins.model.CauseOfInterruption
import org.jenkinsci.plugins.workflow.steps.FlowInterruptedException

class ScriptAbort extends CauseOfInterruption {

    private String message

    ScriptAbort(String message) {
        this.message = message
    }

    String getShortDescription() {
        return message
    }
}

void call(String message) {
    withContext {
        throw new FlowInterruptedException(Result.ABORTED, new ScriptAbort(message))
    }
}
