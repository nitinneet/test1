import org.k9.*

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    Yaml parser = new Yaml()
    Map pipelineDefinition = parser.load(new File(pwd() + 'pipeline.yml').text)

    node {
      adm = new scm.Git(this,config)
      adm.checkout()
    }

}
