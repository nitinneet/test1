package org.k9.scm

class Git implements Serializable {
  String branch
  def stages

  Git(stages) {
    this.branch = stages.env.branch
    this.stages = stages
  }

  def checkout() {
    stages.echo 'checking out code from scm..'
    //checkout scm here, ie. stages.checkout...
  }
}
