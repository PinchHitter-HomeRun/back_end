package com.toyproj.pinchhitterhomerun.controller;

import com.toyproj.pinchhitterhomerun.exception.MemberException;
import com.toyproj.pinchhitterhomerun.entity.ResponseResult;
import com.toyproj.pinchhitterhomerun.service.MemberService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    MemberService memberService;

    @ApiOperation("생년월일로 아이디 찾기")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "사용자 이름", required = true, dataType = "String"),
            @ApiImplicitParam(name = "birthDay", value = "사용자 생년월일(yymmdd)", required = true, dataType = "String")
    })
    @ResponseBody
    @GetMapping
    public ResponseResult<String> findLoginId(@RequestParam("name") String name,
                                              @RequestParam("birth_day") String birthDay) {
        final var findLoginId = memberService.findLoginId(name, birthDay);

        return new ResponseResult<>(findLoginId);
    }

    @ApiOperation("아이디 사용가능 여부 체크")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestId", value = "사용할 아이디(이메일)", required = true, dataType = "String")
    })
    @ResponseBody
    @PostMapping("/{requestId}")
    public ResponseResult<Boolean> checkAvailableId(@PathVariable("requestId") String requestId) {
        final var result = memberService.isAvailable(requestId);

        return new ResponseResult<>(result);
    }

}
