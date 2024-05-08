package indigo.login.service.implement;

import indigo.login.entity.ProfileData;
import indigo.login.model.RequestLogin;
import indigo.login.model.ResponseLogin;
import indigo.login.repository.ProfileDataRepository;
import indigo.login.service.ILogin;
import indigo.login.utils.AesUtil128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class LoginService implements ILogin {

    private final ProfileDataRepository data;

    @Autowired
    public LoginService(ProfileDataRepository data){
        this.data = data;
    }

    @Override
    public ResponseLogin findUser(RequestLogin request) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        ResponseLogin login = new ResponseLogin();

        if (!request.getEmail().isEmpty() || !request.getPhone().isEmpty()) {
            Optional<ProfileData> userData = Optional.empty();
            String pass = AesUtil128.aesEncry(request.getPassword());

            if (!request.getEmail().isEmpty()) {
                userData = data.findByEmail(request.getEmail());
            } else if (!request.getPhone().isEmpty()) {
                userData = data.findByPhone(request.getPhone());
            }

            if (userData.isPresent() && userData.get().getPassword_user().contentEquals(pass)) {
                login.setStatusMessage("");
                login.setStatusCode("000");
            } else {
                login.setStatusMessage("");
                login.setStatusCode("100");
            }

            return login;
        }

        login.setStatusCode("200");
        return login;
    }


}
