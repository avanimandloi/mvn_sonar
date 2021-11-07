pipeline {

   agent any

            stages {

      stage('Git Checkout') {

         steps {

            git 'https://github.com/avanimandloi/mvn_sonar.git'
            slackSend message: 'Checkout Complete'

                        }

            }

            stage('Build') {

                        steps {

                              //withSonarQubeEnv('sonar') {

                                                sh '/usr/share/maven/bin/mvn clean verify sonar:sonar -Dmaven.test.skip=true'
                                                slackSend color: 'good', message: 'Build Success'

                                    //}

                        }

            }

            // seems some issue with quality gates in latest jenkins version so commented out

            /*stage("Quality Gate") {

            steps {

              timeout(time: 2, unit: 'MINUTES') {

                waitForQualityGate abortPipeline: true

              }

            }

          } */

            stage ('Artifact-Deployment') {

                        steps {

                                    sh '/usr/share/maven/bin/mvn clean deploy -Dmaven.test.skip=true'

                        }

            }

            stage ('Release') {

                        steps {

                                    sh 'export JENKINS_NODE_COOKIE=dontkillme ;nohup java -jar $WORKSPACE/target/*.jar &'
                                   
                        }

            }}
               
            post{
               always{
                     slackSend color: 'good',message: 'Hello there'
                  }
               }
            
           


}
