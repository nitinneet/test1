package org.k9.scm
import com.cloudbees.groovy.cps.NonCPS
import jenkins.model.Jenkins

class Git implements Serializable {
  def config

  Git(config) {
    this.config = config
  }

  void checkout() {
    git(url: this.config.giturl, branch: this.config.branch)
  }
}
