package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.model.*;
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
public class ApiController extends BaseController {
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

    @RequestMapping(value = "findPlanInfoList", method = RequestMethod.POST)
    public JsonResult findPlanInfoList(@Valid @RequestBody QueryListParam listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<PlanInfo> list = planService.findPlanInfoList(listParam.getPageIndex(), listParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping(value = "findPlanResultInfoList", method = RequestMethod.POST)
    public JsonResult findPlanResultInfoList(@Valid @RequestBody QueryListParam listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<PlanResultInfo> list = planResultService.findPlanResultInfoList(listParam.getPageIndex(), listParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping(value = "findInvestNumbersInfoList", method = RequestMethod.POST)
    public JsonResult findInvestNumbersInfoList(@Valid @RequestBody QueryListParam listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        List<PlanInvestNumberInfo> list = planInvestNumbersService.findInvestNumbersInfoList(listParam.getPageIndex(), listParam.getPageSize());
        jsonResult.setData(list);
        return jsonResult;
    }
}
