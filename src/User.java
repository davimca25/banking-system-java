public class User {
    private String name;
    private String cpf;

    public User(String name, String cpf) {
        if (!isValidCpf(cpf))
            throw new IllegalArgumentException("Invalid CPF");
        this.name = name;
        this.cpf = cpf;
    }
    private boolean isValidCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        return true;
    }
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    @Override
    public String toString() {
        return "Name: " + this.name + ", CPF: " + this.cpf;
    }

}

