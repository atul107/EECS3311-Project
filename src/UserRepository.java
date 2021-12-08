import java.util.*;

public class UserRepository<username, employeeID> {
    HashMap<username, SystemUser> users;
    HashMap<Long, SystemAdmin> admins;
    String password;

    public UserRepository() {
        users = new HashMap<username, SystemUser>();
        admins = new HashMap<Long, SystemAdmin>();
        password = "";
    }
    //UserRepository maintains a HashMap of users. In addition, in its public methods are several query methods to validate the identity and login of a user.
    //UserRepository maintains a HashMap of users. In addition, in its public methods are query methods checkUsernameExists and checkEmailExists that will help enforce unique usernames and emails.


    boolean registerUser(SystemUser user) {
        if (checkUsernameExists(user.getId()) || checkEmailExists(user.getEmail())) {
            return false;
        }
        users.put((username) user.getId(), user);
        return true;
    }

    boolean registerAdmin() {
        SystemAdmin admin = new SystemAdmin();
        if (checkUsernameExists(admin.getId()) || checkEmailExists(admin.getEmail())) {
            return false;
        }
        admins.put(admin.getEmployeeID(), admin);
        return true;
    }

    boolean removeUser(String username) {
        if (checkUsernameExists(username)) {
            users.remove(username);
            return true;
        }
        return false;
    }

    boolean removeAdmin(SystemAdmin admin) {
        if (checkAdminExists(admin)) {
            admins.remove(admin.getEmployeeID());
            return true;
        }
        return false;
    }

    private boolean checkAdminExists(SystemAdmin admin) {
        return admins.containsKey(admin.getEmployeeID());
    }

    boolean checkUsernameExists(String username) {
        return users.containsKey(username);
    }

    boolean checkEmailExists(String email) {
        for (SystemUser user : users.values()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    boolean checkValidLogin(String username, String pass ){
        if(!users.containsKey(username)){
            return false;
        }
        if(!users.get(username).getPassword().equals(pass)){
            return false;
        }
        return true;
    }

    UserRepository getUserRepository() {
        return this;
    }

}