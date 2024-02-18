def myMethod() {
    // Your method implementation here
    // Should return a list of strings representing the options
    return ['Option1', 'Option2', 'Option3']
}

def options = myMethod()

properties([
    parameters([
        [$class: 'ChoiceParameter',
         choiceType: 'PT_SINGLE_SELECT',
         description: 'Select an option',
         filterLength: 1,
         name: 'SelectedOption',
         script: [
             $class: 'GroovyScript',
             fallbackScript: [
                 classpath: [],
                 sandbox: false,
                 script: 'return ["Error"]'
             ],
             script: [
                 classpath: [],
                 sandbox: false,
                 script: "return ${options.inspect()}"
             ]
         ]]
    ])
])

pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                // Your pipeline steps here
                // You can use the selected option via ${params.SelectedOption}
            }
        }
    }
}
