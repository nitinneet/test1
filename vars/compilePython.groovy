//import static eu.inuits.PythonCompiler.*


def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
  
    echo("Compiling ${config.directory}")
}
