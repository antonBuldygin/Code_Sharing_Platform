class User {

    private String login;
    private String firstName;
    private String lastName;

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "login=" + login + ",firstName=" + firstName + ",lastName=" + lastName;
    }

//    public static void main(String[] args) {
//        User user = new User("javagod","James","Gosling");
//        System.out.println(user);
//    }
}