import org.k9.scm.Git

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()


node {
  adm = new Git("${config.giturl}","${config.branch}")
  adm.checkout()
}


//compileDirectory("${config.script}", "${config.directory}")
}
