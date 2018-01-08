package org.k9.scm
import com.cloudbees.groovy.cps.NonCPS
import jenkins.model.Jenkins

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

  @NonCPS
  void setFolderDescription(folder, description) {
    def f = Jenkins.instance.getItemByFullName(folder)
    f.setDescription(description)
  }
}


