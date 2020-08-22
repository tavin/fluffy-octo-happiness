import hudson.model.Result

void call(String message) {
    currentBuild.getRawBuild().getExecutor().interrupt(Result.ABORTED)
}
