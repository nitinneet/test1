package org.k9.safir

class Params {
  def config
  def script
  def params = "anand"

  Params(script,config) {
    this.config = config
    this.script = script
    this.params = params
  }

  void build() {
      return this.params
  }
}
