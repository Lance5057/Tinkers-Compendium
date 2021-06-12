#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        jdk "jdk8u292-b10"
    }
    stages {
        stage('Clean') {
            steps {
                echo 'Cleaning Project'
                sh 'chmod +x gradlew'
                sh './gradlew clean'
            }
        }
        stage('Build and Deploy') {
            steps {
                echo 'Building and Deploying to Maven'
                script {
                    if (env.BRANCH_NAME.contains("develop")) {
                        sh './gradlew build -Pbranch=SNAPSHOT uploadArchives'
                    } else if (env.BRANCH_NAME.contains("release")) {
                        sh './gradlew build uploadArchives'
                    } else {
                        sh './gradlew build -Pbranch=' + env.BRANCH_NAME + ' uploadArchives'
                    }
                }
            }
        }
    }
    post {
        always {
            archive 'build/libs/**.jar'
        }
    }
}
