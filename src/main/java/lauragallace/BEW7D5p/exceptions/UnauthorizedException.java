package lauragallace.BEW7D5p.exceptions;

import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}