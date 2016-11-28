require 'yaml'
require 'travis'

Travis.access_token = ENV['TRAVIS_API_TOKEN']

is_snapshot = ENV['PROJECT_VERSION'] =~ /.*SNAPSHOT/
is_master = ENV['TRAVIS_BRANCH'] == 'master'
not_pull_request = ENV['TRAVIS_PULL_REQUEST'] == 'false'

if is_snapshot and is_master and not_pull_request
  config = YAML.load_file('.travis.yml')

  config["downstream"].each { |downstream|
    repository = Travis::Repository.find(downstream)
    repository.branch('master').restart
  }
end
