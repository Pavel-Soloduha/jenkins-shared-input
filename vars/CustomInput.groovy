def addInput() {
  def list = sh returnStdout: true, script: "ls"
  def choice_params_list = []
  list.split("\n").each { str ->
    println str
    choice_params_list.add(str.trim().toString())
  }
  String[] choice_params_array = choice_params_list.toArray()
        
  def input_data = input id: '123213213', message: 'dafd', parameters: [
      booleanParam(defaultValue: false, description: '1234', name: 'ert'),
      booleanParam(defaultValue: true, description: '2345', name: 'edc'),
      new ChoiceParameterDefinition("choice_1", choice_params_array, "Example")
    ]

  input_data.each { key ->
    println key
  }
}
