package org.k9.safir

class Params {
  def config
  def script

  Params(script,config) {
    this.config = config
    this.script = script
  }

  void getBuild() {
      def x = "anand"
      return "x"
  }
}
