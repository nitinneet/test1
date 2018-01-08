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
            stage ('Test Cases') {
                sh "echo 'Test Cases Started'"
            }
            stage ('Deploy') {
                sh "echo 'Starting deploy'"
                sleep "${config.sleep}"
            }
            stage('Build') {
                sh 'mvn -B -V -U -e clean package'
            }
            stage('Archive') {
                junit allowEmptyResults: true, testResults: '**/target/**/TEST*.xml'
            }
        } catch (err) {
            currentBuild.result = 'FAILED'
            throw err
        }
    }
}
