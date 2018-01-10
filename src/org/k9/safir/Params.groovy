package org.k9.safir

class Params {
  def config
  def script

  Params(script,config) {
    this.config = config
    this.script = script
  }

  void build() {
      def params = "anand"
      return params
  }
}
