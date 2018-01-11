#!/usr/bin/groovy
def call() {
  podTemplate(label: anand,
        containers: [
        	containerTemplate(
        		name: 'maven', 
        		image: 'maven:3.3.9-jdk-8-alpine'
        	)
        ]
  ) {
    body()
    }
}
