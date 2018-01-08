import static org.k9.scm.Git

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()


echo("Compiling ${config.directory}")

    node {
          adm = new Git('123','abc')
          adm.checkout()
    }

//compileDirectory("${config.script}", "${config.directory}")
}
