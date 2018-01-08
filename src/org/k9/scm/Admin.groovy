package eu.inuits
import com.cloudbees.groovy.cps.NonCPS
class Admin implements Serializable {
def seedFullName = "seed"
def script
Admin(script) {
this.currentJobValidation(script)
this.script = script
}
@NonCPS
void currentJobValidation(script){
def name = \
script.currentBuild.rawBuild.project.fullName
assert name == this.seedFullName : "DENIED"
}
}
