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

// Define parameters dynamically
properties([
    parameters([
        // Define a choice parameter
        choice(
            choices: getOptions(), // Call the helper function to get options
            description: 'Select an option',
            name: 'SelectedOption'
        )
    ])
])

// Your scripted pipeline
pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                script {
                    echo "test"
                }
            }
        }
    }
}
