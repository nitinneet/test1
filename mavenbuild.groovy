def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
        // Clean workspace before doing anything
        deleteDir()

        try {
            stage ('setup') {
                pom = load "lib/pom.groovy"
            }
            stage ('Build') {
                git(url: ${config.giturl})

                stage "Build"
                tools.configureMaven()
                sh("./mvnw spring-boot:run")
            }
        } catch (err) {
            currentBuild.result = 'FAILED'
            throw err
        }
    }
}





