package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 값의 필드를 제외
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String resultCode;
    private String resultMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum) {
        setResultCode(codeEnum.getCode());
        setResultCode(codeEnum.getMessage());
    }

    public CommonResponse(T info) {
        setResultCode(CodeEnum.SUCCESS.getCode());
        setResultMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        setResultCode(codeEnum.getCode());
        setResultCode(codeEnum.getMessage());
        setInfo(info);
    }
}
