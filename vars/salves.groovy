def call (slave){

podTemplate(cloud: 'mcluster',label: 'anotherpod',  containers: [
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-7-alpine')
  ]) {
}


node('maven') {
openshift.withCluster( 'mcluster' ) {
    openshift.withProject( 'anand' ) {
        echo "Hello from project: ${openshift.project()}"
    }
}
}
}
