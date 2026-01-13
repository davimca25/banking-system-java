public class User {
    private String name;
    private String cpf;

    public User(String name, String cpf) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else if (name.length() < 3) {
            throw new IllegalArgumentException("Name too short");
        } else if ((!name.matches("[A-Za-zÀ-ÿ ]+")))
            throw new IllegalArgumentException("Name must contain only letters.");
        if (!isValidCpf(cpf))
            throw new IllegalArgumentException("Invalid CPF");
        this.name = name;
        this.cpf = cpf;
    }
    private boolean isValidCpf(String cpf) {
        if (cpf.length() != 11) {
            return false;
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

