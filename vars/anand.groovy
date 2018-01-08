import org.k9.scm.Git

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()


node {
  ado = new Git("${config.giturl}","${config.branch}")
  ado.checkout()
}


//compileDirectory("${config.script}", "${config.directory}")
}
