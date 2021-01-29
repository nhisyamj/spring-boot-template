pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean package'
        sh 'mvn clean verify sonar:sonar -Dsonar.host.url=http://sonarqubeserver:9000'
//         jacoco()
//         withSonarQubeEnv 'sonarqubeDefault'
      }
    }

  }
}