require 'yaml'
require 'travis'

Travis.access_token = ENV['TRAVIS_API_TOKEN']

config = YAML.load_file('.travis.yml')

config["downstream"].each { |downstream|
  repository = Travis::Repository.find(downstream)
  repository.branch('master').restart
}
