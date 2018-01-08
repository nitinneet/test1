package org.k9.scm
import com.cloudbees.groovy.cps.NonCPS
import jenkins.model.Jenkins

class Git implements Serializable {
  def config
  def script

  Git(script,config) {
    this.config = config
    this.script = script
  }

  void checkout() {
    this.script.stage('Initialize') {
      this.script.git(url: this.config.giturl, branch: this.config.branch)
    }
  }
}
