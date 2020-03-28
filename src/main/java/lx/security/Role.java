package lx.security;

import org.apache.commons.lang3.StringUtils;

public class Role {

    public static final String adminRole = "ROLE_ADMIN";
    public static final String guestRole = "ROLE_GUEST";

    public static Boolean containIn(String role){
        boolean admin = StringUtils.equals(adminRole, role);
        if(admin){
            return true;
        }
        boolean guest = StringUtils.equals(guestRole, role);
        if(guest){
            return true;
        }
        return false;

    }

}
