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
    }
    stages{
        stage("Checkout from SCM"){
            steps{
                git branch:'master', credentialsId:'github', url: 'https://github.com/tahtoh/devops-pipeline', 
            }
        }
    }
}