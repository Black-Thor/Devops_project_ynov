#Providers Config
#terraform plan
#terraform apply --auto-approve
#terraform destroy --auto-approve


terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.35"
    }
  }
}

# Configure the AWS Provider
provider "aws" {
  profile = "default"
  region = "us-east-2"
  shared_credentials_file = "../../aws/credentials-ynov.txt"
}

