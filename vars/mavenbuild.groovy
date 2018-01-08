def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        // Clean workspace before doing anything
        deleteDir()

        try {
            stage('Checkout') {
                checkout([
                    $class: 'GitSCM',
                    branches: "${config.branch}",
                    extensions: scm.extensions + [[$class: 'LocalBranch'], [$class: 'WipeWorkspace']],
                    userRemoteConfigs: [[url: "${config.scmUrl}"]],
                    doGenerateSubmoduleConfigurations: false
                ])
            }
            stage('checkout git') {
                steps {
                    checkout([$class: 'GitSCM', 
                        branches: [[name: '*/${config.branch}']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extensions: [[$class: 'CleanCheckout']], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [[credentialsId: '${config.credentialsId}', url: '${config.scmUrl}']]
                    ])
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
