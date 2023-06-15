import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {

    public Admin(String name) {
        super(name, "admin");
    }

    public Admin(String name, String username, String password) {
        super(name, "admin", username, password);
    }

    private boolean isUsernameAvailable(String username) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("users.csv"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String existingUsername = parts[2];
                    if (existingUsername.equals(username)) {
                        return false; // Username already exists
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users from the file: " + e.getMessage());
        }
        return true; // Username is available
    }

    public void addUser(User user) {
        if (isUsernameAvailable(user.getUsername())) {
            List<String> lines = new ArrayList<>();
            lines.add(user.getId() + "," + user.getName() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getRoll()
                    + "," + user.getAccountStatus());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv", true))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error adding user to the file: " + e.getMessage());
            }
        } else {
            System.out.println("Username '" + user.getUsername() + "' already exists. Please choose a different username.");
        }
    }

    public void viewUsers() {
        List<User> users = UserService.getUsers();
        for(User user: users){
            System.out.println(user.toString());
        }
    }

    public void setUserAccountStatus(User user,boolean status) {
        user.accountLocked = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", roll='" + super.getRoll() + '\'' +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", accountStatus='" + super.accountLocked + '\'' +
                '}';
    }
}
