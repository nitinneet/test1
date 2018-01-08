package org.k9.scm

class Git implements Serializable {
  String branch
  def scmurl

  Git(branch,scmurl) {
    this.branch = branch
    this.scmurl = scmurl
  }

  def checkout() {
    stages.echo 'checking out code from scm..'
  }
}
