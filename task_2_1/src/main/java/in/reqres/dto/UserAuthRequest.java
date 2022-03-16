package in.reqres.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserAuthRequest {
    @NonNull
    private String email;
    private String password;
}
