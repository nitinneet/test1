import static org.k9.scm.Git.*

def call(body) 
{

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        // Clean workspace before doing anything
        deleteDir()

        try {
            stage ('test') {
		checkout()
            }
            stage ('Setup') {
                git(url: "${config.giturl}", branch: "${config.branch}", credentialsId: "${config.credentialsId}")
            }
}
   
