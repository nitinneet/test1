package org.k9.scm
import com.cloudbees.groovy.cps.NonCPS
import jenkins.model.Jenkins

class Git implements Serializable {
  def branch
  def scmurl

  Git(branch,scmurl) {
    this.branch = branch
    this.scmurl = scmurl
  }

  void checkout() {
    git(url: this.scmurl, branch: this.branch)
  }
}
