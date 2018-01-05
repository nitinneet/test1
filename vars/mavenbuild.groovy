def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        // Clean workspace before doing anything
        deleteDir()

        try {
            stage ('Setup') {
                git(url: "${config.giturl}")
            }
            stage ('Build') {  
                sh("${config.buildstep}")
            }
        } catch (err) {
            currentBuild.result = 'FAILED'
            throw err
        }
    }
}
