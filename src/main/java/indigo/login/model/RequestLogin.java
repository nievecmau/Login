package indigo.login.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestLogin {
    private String email = "";
    private String phone = "";
    private String password = "";
}
