package org.k9.safir

class Params {
  def config
  def script

  Params(script,config) {
    this.config = config
    this.script = script
    this.params = "Anand Kumar"
  }

  void getBuild() {
      return this.params
  }
}
