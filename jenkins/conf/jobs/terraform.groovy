pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { dir("/var/terraform/terraform-files/instances") { 
                sh "pwd" 
                }
          }
        }
        
        stage ("terraform init") {
            steps {
                dir("/var/terraform/terraform-files/instances") { 
                    sh "pwd" 
                    sh ('terraform init') 

                }
            }
        }
        stage ("terraform plan") {
            steps {
                dir("/var/terraform/terraform-files/instances") { 
                    sh "pwd"
                    sh ('terraform plan') 
                }

            }
        }
        
        stage ("terraform Action") {
            steps {
                dir("/var/terraform/terraform-files/instances") {
                    sh "pwd" 
                    echo "Terraform action is --> ${action}"
                    sh ('terraform ${action} --auto-approve') 
                }
                
           }
        }
    }
}