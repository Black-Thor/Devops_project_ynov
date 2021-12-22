#!groovy

pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'maven'
    }
    environment {
        TEST = 'TEST'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '100'))
    }

    stages {
        stage('Git clone') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/Ozz007/sb3t'
            }
        }


        stage('Compiling') {
            steps {
                    sh 'mvn compile'
            }
        }
        stage('Testing'){
            when {
            expression { params.SKIP_TESTS == false }
            }
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                script {
                    sh 'mvn package'
                }
            }
        }

        stage('Verify') {
               when {
            expression { params.SKIP_TESTS == false }
            }
            steps {
                sh 'mvn verify'
            }
        }


        stage('Package version ') {
            steps {
                sh "mvn versions:set -DnewVersion=${params.VERSION}-${params.VERSION_TYPE}"
                sh "mvn clean package  -DskipTests=${params.SKIP_TESTS}"
            }
        }

        stage('archive') {
            steps {
                archiveArtifacts(artifacts: '**/*.jar', followSymlinks: false)
            }
        }

    }
}


