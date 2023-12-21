job("node js project var 2"){
    description("this project will clone node and build and push it to docker hub")
    scm {
        git('https://github.com/Urvesh05/simple_node_project.git','master') { node -> 
            node / gitConfigName('Urvesh05')
            node / gitConfigEmail('urveshgayakwad2@gmail.com')
        }
    }
    wrappers {
        nodejs('node 18')
            credentialsBinding {
                usernamePassword('USERNAME_DOC', 'PASS_DOC')
        }
    }
    steps {
        shell('npm install')
        shell('docker login -u ${USERNAME_DOC} -p ${PASS_DOC}')
        dockerBuildAndPublish {
            repositoryName('Urvesh05/simple_node_project')
            tag('${BUILD_NUMBER}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
        shell('docker logout')
    }
}