package spring_pr.com.day21.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor



public class JsonResponse<T> {

    private boolean success;
    private T data;
    private String error;
}

