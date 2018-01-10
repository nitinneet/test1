package org.k9.safir

class Params {
  def config
  def script
  def params

  Params(script,config) {
    this.config = config
    this.script = script
    this.params = "anand kumar"

/*
    this.params = this.script.parameters {
        string(defaultValue: "TEST", description: 'What environment?', name: 'userFlag')
        choice(choices: 'US-EAST-1\nUS-WEST-2', description: 'What AWS region?', name: 'region')
    }
    this.params = this.script.input ( id: 'params', parameters: [
      [$class: 'ChoiceParameterDefinition',name: 'CLUSTER_APP_DOMAIN',choices: 'https://master.marthanda.in',description: ''],
      [$class: 'CredentialsParameterDefinition', credentialType: 'org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl', defaultValue: '', description: '',name: 'openShiftToken',required: true]
    ])
*/
  }

  void build() {
      return this.params
  }
}
