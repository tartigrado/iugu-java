package com.iugu.model.generic;

import com.iugu.utils.KeyUtils;
import lombok.*;

import java.security.PrivateKey;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public final class SignedBody {
    private final String method;
    private final String endpoint;
    private final String body;
    private ZonedDateTime signedAt;
    private String signedMessage;

    String firstLine() {
        return method.toUpperCase() + "|" + endpoint;
    }

    String secondLine(String token) {
        return token + "|" + signedAtAsString();
    }

    String thirdLine() {
        return getBody();
    }

    public SignedBody sign(String token, PrivateKey privateKey) {
        setSignedAt(ZonedDateTime.now());
        setSignedMessage(KeyUtils.sign(
                String.join("\n", firstLine(), secondLine(token), thirdLine()),
                privateKey
        ));
        return this;
    }

    public String signedAtAsString() {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
                .format(Optional.ofNullable(getSignedAt()).orElseThrow(() -> new IllegalArgumentException("signedAt is required.")));
    }
}
