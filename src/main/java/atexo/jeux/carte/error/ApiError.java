package atexo.jeux.carte.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    /**
     * Http Status Code
     */
    private String statusCode;

}
