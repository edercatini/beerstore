terraform {
  backend "s3" {
    bucket = "eder-catini-first-bucket"
    key = "terraform-state"
    region = "us-east-1"
    profile = "terraform"
  }
}