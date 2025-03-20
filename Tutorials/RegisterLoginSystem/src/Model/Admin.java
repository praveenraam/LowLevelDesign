package Model;

import Model.ENUM.Role;

import java.util.ArrayList;

public class Admin extends UserAbsClass{
    private static ArrayList<Admin> adminList = new ArrayList<>();
    public Admin(String email, String password) {
        super(adminList.size()+1, email, password, Role.ADMIN);
        adminList.add(this);
    }

    public static ArrayList<Admin> getAdminList() {
        return adminList;
    }
}
