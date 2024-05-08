package indigo.login.model;

import lombok.Data;

@Data
public class ResponseLogin {
    private String statusCode;
    private String statusMessage;
    private Details details;
}
