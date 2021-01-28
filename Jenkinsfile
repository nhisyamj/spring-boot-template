pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean package'
        sh 'mvn clean verify sonar:sonar'
//         jacoco()
//         withSonarQubeEnv 'sonarqubeDefault'
      }
    }

  }
}