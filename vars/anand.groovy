import org.k9.*

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
      adm = new scm.Git.Git(this,config)
      adm.checkout()
    }

}
