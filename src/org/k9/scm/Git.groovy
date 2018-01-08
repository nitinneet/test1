package org.k9.scm
import com.cloudbees.groovy.cps.NonCPS

class Git implements Serializable {
  def branch
  def scmurl

  Git(branch,scmurl) {
    this.branch = branch
    this.scmurl = scmurl
  }

  def checkout() {
    stages.echo 'checking out code from scm..'
  }
}
