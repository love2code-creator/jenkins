pipeline {
    agent any

    parameters {
        string(
            name: 'SelectedOption',
            description: 'Select an option',
            defaultValue: '',
            // Use Groovy script to generate options dynamically
            // This will create a dropdown with dynamic options
            // based on the result of myMethod()
            choices: getOptions()
        )
    }

    stages {
        stage('Example') {
            steps {
                // Your pipeline steps here
                // You can use the selected option via ${params.SelectedOption}
            }
        }
    }
}

def getOptions() {
    def options = []
    // Call your method to generate options
    def methodResult = myMethod()
    // Assuming myMethod() returns a list of strings
    methodResult.each { option ->
        options.add(option)
    }
    return options.join('\n')
}

def myMethod() {
    // Your method implementation here
    // Should return a list of strings representing the options
    return ['Option1', 'Option2', 'Option3']
}
