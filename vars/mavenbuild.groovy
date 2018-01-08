def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        // Clean workspace before doing anything
        deleteDir()

        try {
            stage('checkout git') {
                steps {
    git poll: false, changelog: false, url: 'https://github.com/spring-projects/spring-petclinic.git', branch: 'master'
    load script 
                }
            }
            stage ('Build') {  
                sh("${config.buildstep}")
            }
            stage ('Test Cases') {
                sh "echo 'Test Cases Started'"
            }
            stage ('Deploy') {
                sh "echo 'Starting deploy'"
                sleep "${config.sleep}"
            }
        } catch (err) {
            currentBuild.result = 'FAILED'
            throw err
        }
    }
}
