package recipe.exceptions;

import org.springframework.http.HttpStatus;

public interface ICustomException {
    HttpStatus getStatus();
}