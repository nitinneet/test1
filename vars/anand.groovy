import static org.k9.scm.Git

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()


echo("Compiling ${config.directory}")

    node {
          one = new Git('123','abc')
          one.checkout()
    }

//compileDirectory("${config.script}", "${config.directory}")
}
