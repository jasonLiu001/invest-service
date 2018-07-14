package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.model.*;
import cn.lands.liuwang.investservice.model.query.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lottery")
public class ApiController extends BaseController {
    @RequestMapping(value = "/findAwardInfoList", method = RequestMethod.POST)
    public JsonResult findAwardInfoList(@Valid QueryListBase listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<AwardInfo> list = awardService.findAwardInfoList(listParam.getPageIndex(), listParam.getPageSize());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "findInvestInfoList", method = RequestMethod.POST)
    public JsonResult findInvestInfoList(@Valid QueryListBeforeTime queryListBeforeTime, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<InvestInfo> list = investService.findInvestInfoList(queryListBeforeTime.getPageIndex(), queryListBeforeTime.getPageSize(), queryListBeforeTime.getPlanType(), queryListBeforeTime.getBeforeTimeStr());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }

        return jsonResult;
    }

    @RequestMapping(value = "findPlanInfoList", method = RequestMethod.POST)
    public JsonResult findPlanInfoList(@Valid QueryListBase listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<PlanInfo> list = planService.findPlanInfoList(listParam.getPageIndex(), listParam.getPageSize(), listParam.getPlanType());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "findPlanResultInfoList", method = RequestMethod.POST)
    public JsonResult findPlanResultInfoList(@Valid QueryListBase listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<PlanResultInfo> list = planResultService.findPlanResultInfoList(listParam.getPageIndex(), listParam.getPageSize(), listParam.getPlanType());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "findInvestNumbersInfoList", method = RequestMethod.POST)
    public JsonResult findInvestNumbersInfoList(@Valid QueryListBase listParam, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<PlanInvestNumberInfo> list = planInvestNumbersService.findInvestNumbersInfoList(listParam.getPageIndex(), listParam.getPageSize(), listParam.getPlanType());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "getInvestInfoByPeriod", method = RequestMethod.POST)
    public JsonResult getInvestInfoByPeriod(@Valid QueryInvestInfo queryInvestInfo, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            InvestInfo investInfo = investService.getInvestInfoByPeriod(queryInvestInfo.getPlanType(), queryInvestInfo.getPeriod());
            jsonResult.setData(investInfo);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "findInvestInfoListBeforeTime", method = RequestMethod.POST)
    public JsonResult findInvestInfoListBeforeTime(@Valid QueryListBeforeTime queryListBeforeTime, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<InvestInfo> list = investService.findInvestInfoListBeforeTime(queryListBeforeTime.getPageIndex(), queryListBeforeTime.getPageSize(), queryListBeforeTime.getPlanType(), queryListBeforeTime.getBeforeTimeStr());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "getAllSettings", method = RequestMethod.GET)
    public JsonResult getAllSettings() {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<SettingsInfo> list = settingsService.getAllSettings();
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "updateSettingsByKey", method = RequestMethod.POST)
    public JsonResult updateSettingsByKey(@Valid SettingsInfo settingsInfo, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            boolean result = settingsService.updateSettingsByKey(settingsInfo);
            jsonResult.setData(result);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "getSettingsByKey", method = RequestMethod.GET)
    public JsonResult getSettingsByKey(String settingKey) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            SettingsInfo settingsInfo = settingsService.getSettingsByKey(settingKey);
            jsonResult.setData(settingsInfo);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/findInvestInfoListProfit", method = RequestMethod.POST)
    public JsonResult findInvestInfoListProfit(@Valid QueryListProfit queryListProfit, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<ProfitInfo> list = investService.findInvestInfoListProfit(queryListProfit.getPageIndex(), queryListProfit.getPageSize(), queryListProfit.getPlanType(), queryListProfit.getFixedProfit(), ProfitType.getProfitTypeByKey(queryListProfit.getProfitType()));
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }
}
