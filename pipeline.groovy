// Helper function to generate options dynamically
def getOptions() {
    def options = []
    // Call your method to generate options
    def methodResult = myMethod()
    // Assuming myMethod() returns a list of strings
    methodResult.each { option ->
        options.add(option)
    }
    return options
}

// Your method to generate options
def myMethod() {
    // Your method implementation here
    // Should return a list of strings representing the options
    return ['Option1', 'Option2', 'Option3']
}

// Define parameters dynamically using the environment directive
pipeline {
    agent any

    environment {
        // Define parameters dynamically based on the result of myMethod()
        // Convert the list of options to a comma-separated string
        OPTIONS_STRING = getOptions().join(',')
    }

    parameters {
        // Define a choice parameter using the environment variable
        choice(
            choices: "${env.OPTIONS_STRING}",
            description: 'Select an option',
            name: 'SelectedOption'
        )
    }

    stages {
        stage('Example') {
            steps {
                script {
                    echo "test again"
                }
            }
        }
    }
}
