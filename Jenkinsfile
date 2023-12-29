pipeline{
    agent{
        label "jenkins-agent"
    }
    tools{
        jdk "Java17"
        maven "Maven3"
    }
    environment{
        IMAGE_TAG = "${env.BUILD_ID}"
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
        stage("Code Quality"){
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'jenkins-sonar-token') {
                        sh "mvn sonar:sonar"
                    }
                }
            }
        }
        stage("Quality Gate"){
            steps{
                script{
                    timeout(time: 10, unit: 'MINUTES') { 
                        def qg = waitForQualityGate() 
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }   
            }
        }
        stage("Deploy to registery"){
            steps{
                script{
                    withDockerRegistry([credentialsId: 'docker-jenkins', url: '']) {
                        def customImage = docker.build("tahtoh/devops:${env.BUILD_ID}");
                        customImage.push();
                    }
                }
            }
        }    
        stage("Trigger CD"){
            steps{
                    build job: 'gitops-complete-pipeline', wait: false, parameters: [string(name: 'IMAGE_TAG', value: "${IMAGE_TAG}")]
            }
        }   
    }
}