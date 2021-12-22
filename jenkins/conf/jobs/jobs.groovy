#!groovy
println('---------------------------------------------------------------------------Import Job CI/sb3t')
def pipelineScript = new File('/var/jenkins_config/jobs/sb3t_wrapper.groovy').getText("UTF-8")

pipelineJob('CI/sb3t_wrapper'){
    description("Build .jar file from sb3t repository , from master branch")
    parameters {
        stringParam {
            name('BRANCH')
            defaultValue('master')
            description("branch to pull")
            trim(false)
        }
        booleanParam {
            name('SKIP_TEST')
            defaultValue(true)
            description("Skip test")
        }
        choice {
            name('VERSION_TYPE')
            choices(['SNAPSHOT', 'RELEASE'])
            description('Version type between snapshot and release')
        }
        stringParam {
            name('VERSION')
            defaultValue('1.0')
            description("version of the project")
            trim(false)
        }
    }
    definition{
        cps {
            script(pipelineScript)
            sandbox()
        }
    }
}