package org.k9.safir

class Params implements Serializable {
  def config
  def script

  Params(script,config) {
    this.config = config
    this.script = script
    this.params = input ( id: 'params', parameters: [
      [$class: 'ChoiceParameterDefinition',name: 'CLUSTER_APP_DOMAIN',choices: 'ocp-master.infra.paas.gcp.com\n10.10.10.1.xip.io',description: ''],
      [$class: 'CredentialsParameterDefinition', credentialType: 'org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl', defaultValue: '', description: '',name: 'openShiftToken',required: true]
    ])
  }

  void build() {
      return this.params
  }
}
