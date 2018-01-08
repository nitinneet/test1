import org.k9.*

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
      a = new scm.Git(this,config).checkout();
      b = new builder.Maven(this,config).build();
    }

}
