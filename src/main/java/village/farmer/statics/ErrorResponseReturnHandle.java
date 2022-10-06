package village.farmer.statics;

import org.springframework.http.HttpStatus;

public class ErrorResponseReturnHandle {

    // Fail
    public static final String Auth_Verify_01 = "User not Found";
    public static final String Auth_Verify_02 = "Password Incorrect";
    public static final String Auth_Register_01 = "Username Duplicate";
    public static final String Auth_Register_02 = "Password Invalid";
    public static final String Auth_Register_03 = "Password not Match";
    public static final String Auth_Register_04 = "Mail Invalid";
    public static final String Internal_Err_Null_01 = "Credential is null";
    public static final String Internal_Err_Null_02 = "Role is null";

    // Success
    public static final String Auth_Verify_Success = "Login Success";
    public static final String Auth_Register_Success = "Register Success";

    public static HttpStatus getStatus (String msg) {
        switch (msg){
            case  Auth_Verify_Success:
                return HttpStatus.OK;
            case Auth_Register_Success:
                return HttpStatus.CREATED;
            case Auth_Verify_01 :
            case Auth_Verify_02 :
                return HttpStatus.UNAUTHORIZED;
            case Auth_Register_01:
            case Auth_Register_02:
            case Auth_Register_03:
            case Auth_Register_04:
                return HttpStatus.BAD_REQUEST;

            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
