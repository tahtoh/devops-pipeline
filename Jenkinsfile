pipeline{
    agent{
        label "jenkins-agent"
    }
    tools{
        jdk "Java17"
        maven "Maven3"
    }
    stages{
        stage("CleanUp Workspace"){
            steps{
                cleanWs()
            }
        }
        stage("Checkout from SCM"){
            steps{
                git branch:'master', credentialsId:'github', url: 'https://github.com/tahtoh/devops-pipeline'
            }
        }
        stage("Build App"){
            steps{
                sh "mvn clean package"
            }
        }
        stage("Test App"){
            steps{
                sh "mvn test"
            }
        }
    }
}