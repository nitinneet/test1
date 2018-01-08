import org.k9.scm.Admin

def call(body) {

    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()


node {
  adm = new Admin(this)
  adm.setFolderDescription("python­projects","Description set withing Global Pipeline")
}


//compileDirectory("${config.script}", "${config.directory}")
}
