provider "aws" {
    version = "~> 2.16"
    shared_credentials_file = "~/.aws/credentials"
    profile = "terraform"
}