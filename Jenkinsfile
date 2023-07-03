pipeline {
    agent any
    tools {
        maven '3.9.3'
    }
    parameters {
        choice(
            choices: ['Maven', 'Gradle'],
            description: 'Choose the build tool',
            name: 'BUILD_TOOL'
        )
    }
    
    stages {
        /*stage('Checkout') {
            steps {
                // Checkout your source code from version control
                // Replace the repository URL and credentials as per your setup
                git(
                    branch: 'main',
                    credentialsId: 'your-git-credentials',
                    url: 'https://github.com/your-repo.git'
                )
            }
        }*/

        stage('Build') {
            steps {
                script {
                    // Determine the selected build tool
                    def buildTool = "${params.BUILD_TOOL}"

                    // Execute the build command based on the selected build tool
                    if (buildTool == 'Maven') {
                        sh "mvn clean install"
                    } else if (buildTool == 'Gradle') {
                        sh 'gradlew clean build'
                    } else {
                        error "Invalid build tool selected: ${buildTool}"
                    }
                }
            }
        }
    }
}
