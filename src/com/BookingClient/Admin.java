package src.com.BookingClient;

// Unused admin class (functionality was planned)
public class Admin extends User{
    public Admin(String name, String username, String emailAddress, String password) {
        super(name, username, emailAddress, password);
        this.setAccountType(AccountType.ADMIN);
    }
}
