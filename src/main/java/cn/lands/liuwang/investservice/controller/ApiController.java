package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.model.InvestInfo;
import cn.lands.liuwang.investservice.model.MaxProfitInfo;
import cn.lands.liuwang.investservice.model.query.JsonResult;
import cn.lands.liuwang.investservice.model.query.JsonStatus;
import cn.lands.liuwang.investservice.model.query.QueryListParam;
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
    public JsonResult findAwardInfoList(@Valid @RequestBody QueryListParam listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<AwardInfo> list = awardService.findAwardInfoList(listParam.getPageIndex(), listParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping(value = "findInvestInfoList", method = RequestMethod.POST)
    public JsonResult findInvestInfoList(@Valid @RequestBody QueryListParam listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<InvestInfo> list = investService.findInvestInfoList(listParam.getPageIndex(), listParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping(value = "findMaxProfitInfoList", method = RequestMethod.POST)
    public JsonResult findMaxProfitInfoList(@Valid @RequestBody QueryListParam listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<MaxProfitInfo> list = maxProfitService.findMaxProfitInfoList(listParam.getPageIndex(), listParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }
}
