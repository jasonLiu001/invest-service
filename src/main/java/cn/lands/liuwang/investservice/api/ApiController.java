package cn.lands.liuwang.investservice.api;

import cn.lands.liuwang.investservice.controller.BaseController;
import cn.lands.liuwang.investservice.model.*;
import cn.lands.liuwang.investservice.model.query.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lottery")
public class ApiController extends BaseController {
    @RequestMapping(value = "findAwardInfoList", method = RequestMethod.POST)
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

    @RequestMapping(value = "findInvestTotalInfoList", method = RequestMethod.POST)
    public JsonResult findInvestTotalInfoList(@Valid QueryListBeforeTime queryListBeforeTime, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<InvestTotalInfo> list = investTotalService.findInvestTotalInfoList(queryListBeforeTime.getPageIndex(), queryListBeforeTime.getPageSize(), queryListBeforeTime.getPlanType(), queryListBeforeTime.getBeforeTimeStr());
            jsonResult.setData(list);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "findAllInvestTotalInfoList", method = RequestMethod.POST)
    public JsonResult findAllInvestTotalInfoList(@Valid QueryListBase queryListBase, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<InvestTotalListInfo> resultList = new ArrayList<InvestTotalListInfo>();
            List<InvestTotalInfo> plan01List = investTotalService.findInvestTotalInfoList(queryListBase.getPageIndex(), queryListBase.getPageSize(), 1, null);
            List<InvestTotalInfo> plan02List = investTotalService.findInvestTotalInfoList(queryListBase.getPageIndex(), queryListBase.getPageSize(), 2, null);
            List<InvestTotalInfo> plan03List = investTotalService.findInvestTotalInfoList(queryListBase.getPageIndex(), queryListBase.getPageSize(), 3, null);
            List<InvestTotalInfo> plan04List = investTotalService.findInvestTotalInfoList(queryListBase.getPageIndex(), queryListBase.getPageSize(), 4, null);
            //期号列表
            List<String> periodList = plan01List.stream().map(InvestTotalInfo::getPeriod).collect(Collectors.toList());
            periodList.forEach(period -> {
                InvestTotalListInfo info = new InvestTotalListInfo();
                info.setPeriod(period);
                info.setInvestTotalInfos(new ArrayList<InvestTotalInfo>());

                //方案1
                plan01List.forEach(plan01 -> {
                    if (plan01.getPeriod().equals(period)) {
                        info.getInvestTotalInfos().add(plan01);
                    }
                });
                //方案2
                plan02List.forEach(plan02 -> {
                    if (plan02.getPeriod().equals(period)) {
                        info.getInvestTotalInfos().add(plan02);
                    }
                });
                //方案3
                plan03List.forEach(plan03 -> {
                    if (plan03.getPeriod().equals(period)) {
                        info.getInvestTotalInfos().add(plan03);
                    }
                });
                //方案4
                plan04List.forEach(plan04 -> {
                    if (plan04.getPeriod().equals(period)) {
                        info.getInvestTotalInfos().add(plan04);
                    }
                });
                resultList.add(info);
            });
            jsonResult.setData(resultList);
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

    @RequestMapping(value = "getInvestTotalInfoByPeriod", method = RequestMethod.POST)
    public JsonResult getInvestTotalInfoByPeriod(@Valid QueryInvestInfo queryInvestInfo, BindingResult bindingResult) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            InvestTotalInfo investTotalInfo = investTotalService.getInvestTotalInfoByPeriod(queryInvestInfo.getPlanType(), queryInvestInfo.getPeriod());
            jsonResult.setData(investTotalInfo);
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

    @RequestMapping(value = "findInvestInfoListProfit", method = RequestMethod.POST)
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

    @RequestMapping(value = "updateNextPeriodOpenNumber", method = RequestMethod.POST, consumes = {"application/*"})
    public JsonResult updateNextPeriodOpenNumber(String period, int updateStatus) {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        jsonResult.setData(new AwardInfo());
        try {
            List<AwardInfo> awardInfoList = awardService.getAwardInfoList();
            Optional<AwardInfo> optionalAwardInfo = awardInfoList.stream()
                    .filter(a -> a.getPeriod().equals(period))
                    .peek(System.out::println)
                    .findFirst();

            if (optionalAwardInfo.isPresent()) {
                AwardInfo latestAwardInfo = optionalAwardInfo.get();
                latestAwardInfo.setUpdateStatus(updateStatus);
                jsonResult.setData(latestAwardInfo);
                awardService.saveAwardInfo(latestAwardInfo);
            }

        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            jsonResult.setData(new AwardInfo());
            logger.error(ex);
        }
        return jsonResult;
    }

    @RequestMapping(value = "getOpenNumberList", method = RequestMethod.GET)
    public JsonResult getOpenNumberList() {
        JsonResult jsonResult = new JsonResult(JsonStatus.OK, JsonStatus.OK.getName());
        try {
            List<AwardInfo> awardInfoList = awardService.getAwardInfoList();
            jsonResult.setData(awardInfoList);
        } catch (Exception ex) {
            jsonResult.setStatus(JsonStatus.FAILED);
            jsonResult.setMessage(ex.getMessage());
            logger.error(ex);
        }
        return jsonResult;
    }
}
