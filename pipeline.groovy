pipeline {
    agent any

    parameters {
        choice(
            name: 'SelectedOption',
            description: 'Select an option',
            defaultValue: '',
            // Using a script block to dynamically generate options
            choices: [
                // Execute a Groovy script to generate options dynamically
                script: {
                    def options = []
                    // Call your method to generate options
                    def methodResult = myMethod()
                    // Assuming myMethod() returns a list of strings
                    methodResult.each { option ->
                        options.add(option)
                    }
                    return options
                }
            ]
        )
    }

    stages {
        stage('Example') {
            steps {
                // Your pipeline steps here
                // You can use the selected option via ${params.SelectedOption}
                script{
                    echo "myexecution"
                }
            }
        }
    }
}

def myMethod() {
    // Your method implementation here
    // Should return a list of strings representing the options
    return ['Option1', 'Option2', 'Option3']
}
