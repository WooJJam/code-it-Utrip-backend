package CodeIt.Ytrip.common.reponse;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class CommonApiResponseTest {

    @Test
    public void 공통_응답_생성() throws Exception {
        ResponseEntity<SuccessResponse<Object>> test = ResponseEntity.ok(SuccessResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), null));
        System.out.println("test = " + test);
    }

}
