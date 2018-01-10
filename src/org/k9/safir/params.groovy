package org.k9.safir

class Params {
  def config
  def script

  Params(script,config) {
    this.config = config
    this.script = script
    this.params = this.script.input ( id: 'params', parameters: [
      [$class: 'ChoiceParameterDefinition',name: 'CLUSTER_APP_DOMAIN',choices: 'https://master.marthanda.in',description: ''],
      [$class: 'CredentialsParameterDefinition', credentialType: 'org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl', defaultValue: '', description: '',name: 'openShiftToken',required: true]
    ])
  }

  void getBuild() {
      return this.params
  }
}
