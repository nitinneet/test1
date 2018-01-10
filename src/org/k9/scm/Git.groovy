package org.k9.scm
import org.k9.*

class Git implements Serializable {
  def config
  def script

  Git(script,config) {
    this.config = config
    this.script = script
  }

  void checkout(url=false, branch=false) {
    if (url != false) {
       this.giturl = url
       if (branch != false) {
           this.branch = branch
       }
    }
    if (this.config.giturl) {
       this.script.stage('Initialize') {
         this.script.git(url: this.config.giturl, branch: this.config.branch.trim())
       }
    } else {
        error "no URL found for git config --get remote.origin.url "
    } 
  }
}
