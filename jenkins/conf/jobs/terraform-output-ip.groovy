pipeline {
    agent any

    stages {

        stage ("terraform output ip") {
            steps {
                dir("/var/terraform/terraform-files/instances") { 
                    sh "pwd"
                    sh ('terraform output') 
                }

            }
        }
        
    }
}