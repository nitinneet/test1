import org.k9.*
import org.yaml.snakeyaml.Yaml
import hudson.model.*

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
      new Git(this,config).checkout()
    }

}
