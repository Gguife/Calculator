enum Operation {
    ADDITION("addition", "+") {
        @Override
        double execute(double a, double b) {
            return a + b;
        }
    },

    SUBTRACTION("subtraction",  "-") {
        @Override
        double execute(double a, double b) {
            return a - b;
        }
    },

    MULTIPLICATION("multiplication",  "*") {
        @Override
        double execute(double a, double b) {
            return a * b;
        }
    },

    DIVISION("division",  "/") {
        @Override
        double execute(double a, double b) {
            return a / b;
        }
    };

    final String name;
    final String operator;

    private Operation(String name, String operator) {
        this.name = name;
        this.operator = operator;
    }


    static String[] operations() {
        Operation[] operations = values();
        int qtd = operations.length;
        String[] operators = new String[qtd];
        for(int i = 0; i < qtd; i++){
            operators[i] = operations[i].operator;
        }

        return  operators;
    }

    static Operation perOperation(String operator) {
        for(Operation operation: values()) {
            if(operation.operator.equals(operator)) {
                return  operation;
            }
        }

        return null;
    }

    abstract double execute(double a, double b);
}
