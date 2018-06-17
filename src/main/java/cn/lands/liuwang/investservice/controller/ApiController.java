package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.model.MaxProfit;
import cn.lands.liuwang.investservice.model.query.JsonResult;
import cn.lands.liuwang.investservice.model.query.JsonStatus;
import cn.lands.liuwang.investservice.model.query.QueryAwardParam;
import cn.lands.liuwang.investservice.service.AwardService;
import cn.lands.liuwang.investservice.service.InvestService;
import cn.lands.liuwang.investservice.service.MaxProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class ApiController {

    @Autowired
    AwardService awardService;

    @Autowired
    InvestService investService;

    @Autowired
    MaxProfitService maxProfitService;

    @RequestMapping(value = "/findAwardInfoList", method = RequestMethod.POST)
    public JsonResult findAwardInfoList(@Valid @RequestBody QueryAwardParam awardParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<AwardInfo> list = awardService.findAwardInfoList(awardParam.getPageIndex(), awardParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }
}
