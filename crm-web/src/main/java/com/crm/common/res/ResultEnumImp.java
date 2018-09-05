package com.crm.common.res;

public enum ResultEnumImp implements ResultEnum {

    OK(true, "", "成功"),

    SYSTEM_ERROR("500", " system error "), OPERATION_ERROR("OPERATION_ERROR", "操作失败"), RESUME_NOT_FOUND("RESUME_NOT_FOUND", "简历信息没有读到"), ILLEGAL_OPERATION(
            "ILLEGAL_OPERATION", "非法操作"),

    LOGIN_ACCOUNT_PASSWORD_MATCH("100001", "Login account and password do not match"), NOT_LOGIN_AUTHORITY("100002", " Not login authority "), LOGIN_ERROR(
            "100003", " Login error "), ACCOUNT_NOT_LOGIN("100004", "Account is not loggin"), NO_PERMISSION("100005", " 没有操作权限 "), TOKEN_ERROR("100101",
            " token is error "), TOKEN_NOT_AUTHORITY("100100", " token not authority "), ACCESS_TOKEN_EXPIRED(false, "15006", "登录已超时，请重新登录！"),

    LOAD_DATA_NOT_FOUND("LOAD_DATA_NOT_FOUND", "没有找到相关数据"), LOAD_DATA_NOT_FOUND_HEADHUNTER("LOAD_DATA_NOT_FOUND_HEADHUNTER", "没有找到相关的猎头数据"), LOAD_DATA_NOT_FOUND_POSITION(
            "LOAD_DATA_NOT_FOUND_POSITION", "没有找到相关的职位数据"), LOAD_DATA_NOT_FOUND_CANDIDATE("LOAD_DATA_NOT_FOUND_CANDIDATE", "没有找到相关的候选人数据"), DATA_IS_NOT(
            "DATA_IS_NOT", "数据为空"), ENTERPRISE_CONTRACT_DATA_IS_NOT("ENTERPRISE_CONTRACT_DATA_IS_NOT", "公司合同数据为空"), TOKEN_IS_NOT("TOKEN_IS_NOT", "token为空"), RESTFUL_NOT_FOUND(
            "RESTFUL_NOT_FOUND", "接口暂未开放或接口调整中"), RESTFUL_LOGOUT(true, "RESTFUL_LOGOUT", "成功退出"), DATA_IS_ADMIN("DATA_IS_ADMIN", "登陆用户不是管理员"), DATA_IS_EM(
            "DATA_IS_EN", "登陆用户不是EM"), DATA_IS_ROLE_IS_EMPTY("DATA_IS_ROLE_IS_EMPTY", "登陆用户没有角色"),

    EXISTS_USERCODE("EXISTS_USERCODE", "用户编号已存在"), EXISTS_EMIAL("EXISTS_EMIAL", "该邮箱已存在,请更换邮箱！"), NOT_EXISTS_EMIAL("NOT_EXISTS_EMIAL", "该邮箱不存在,请更换邮箱！"), EXISTS_MOBILE(
            "EXISTS_MOBILE", "该手机号已存在,请更换手机号！"), PLACEMENT_NOT_EXISTS("PLACEMENT_NOT_EXISTS", "成单不存在"), PAYTIME_NOT_EXISTS("PAYTIME_NOT_EXISTS", "付款时间不存在"), CONTRACT_NOT_EXISTS(
            "CONTRACT_NOT_EXISTS", "合同不存在"), PAYMENT_NOT_EXISTS("PAYMENT_NOT_EXISTS", "支付不存在"), ENTERPRISE_NOT_EXISTS("ENTERPRISE_NOT_EXISTS", "公司不存在"), FIXEDREWARDAMOUNT_IS_NULL(
            "FIXEDREWARDAMOUNT_IS_NULL", "请填写固定佣金！"), PERCENTAGENUMBRIC_IS_NULL("PERCENTAGENUMBRIC_IS_NULL", "请填写年薪比例！"), EXISTS_BUSINESS_DATA(
            "EXISTS_BUSINESS_DATA", "操作失败，当前用户下还有数据！"),

    CLUENAME_ISEXISTS("CLUENAME_ISEXISTS", "公司名称已存在！"), CLUE_INCOMPLETE("CLUE_INCOMPLETE", "资料不完整提交失败！"), CLUE_CITYPROVINCEISNULL("CLUE_CITYPROVINCEISNULL",
            "省市信息为空！"), CLUE_NAMEISNULL("CLUE_NAMEISNULL", "黄页名称为空！"), CLUE_NOTLINKMAN("CLUE_NOTLINKMAN", "不存在HR账号或联系人信息！"), CLUE_NOTCOMPLETELINKMAN(
            "CLUE_NOTCOMPLETELINKMAN", "不存在HR账号或完整信息的联系人,请检查联系人手机号、姓名！"), CLUE_NOTEXISTS("CLUE_NOTEXISTS", "黄页不存在或已转为线索！"), CLUE_SEAS_NOTEXISTS(
            "CLUE_NOTEXISTS", "该公海信息不存在！"),

    CONTACT_MOBILE_EXISTS("CONTACT_MOBILE_EXISTS", "联系人手机号已存在！"), CONTACT_EMAIL_EXISTS("CONTACT_EMAIL_EXISTS", "联系人邮箱已存在！"), PROFILE_NOT_EXISTS(
            "PROFILE_NOT_EXISTS", "不存在HR帐号"), PROFILE_IS_EXISTS("PROFILE_IS_EXISTS", "已存在HR帐号"), CONTRACT_IS_EXISTS("CONTRACT_NOT_EXISTS", "合同已存在"), ENTERPRISENAME_ISEXISTS(
            "ENTERPRISENAME_ISEXISTS", "客户名称已存在！"),

    /** 参数错误 **/
    PARAM_FAIL("PARAM_FAIL", "传入参数错误！"), PARAM_FAIL_PARAM_IS_NOT_EMPTY("PARAM_FAIL_PARAM_IS_NOT_EMPTY", "参数值不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_EMAIL(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_EMAIL", "参数值:email不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_PROMPT("PARAM_FAIL_PARAM_IS_NOT_EMPTY_PROMPT",
            "参数值:prompt不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_ID("PARAM_FAIL_PARAM_IS_NOT_EMPTY_ID", "参数值:id不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_INDEPENDENT(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_INDEPENDENT", "参数值:公司类型不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_ID_TYPE("PARAM_FAIL_PARAM_IS_NOT_EMPTY_ID_TYPE",
            "参数值:证件类型不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_ID_NUMBER("PARAM_FAIL_PARAM_IS_NOT_EMPTY_ID_NUMBER", "参数值:证件号码不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMPANT_NAME(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMPANT_NAME", "参数值:公司名称不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_MOBILE_PHONE(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_MOBILE_PHONE", "参数值:手机号码不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_PROVINCE("PARAM_FAIL_PARAM_IS_NOT_EMPTY_PROVINCE",
            "参数值:省份不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_CITY("PARAM_FAIL_PARAM_IS_NOT_EMPTY_CITY", "参数值:市不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_ADDRESS(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_ADDRESS", "参数值:街道不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_INTRODUCTION("PARAM_FAIL_PARAM_IS_NOT_EMPTY_INTRODUCTION",
            "参数值:公司介绍不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_INDUSTRY("PARAM_FAIL_PARAM_IS_NOT_EMPTY_INDUSTRY", "参数值:行业不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_CONTENT(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_CONTENT", "参数值:content不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMPANT_SCALE(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMPANT_SCALE", "参数值:公司规模不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_OBJ_ID("PARAM_FAIL_PARAM_IS_NOT_EMPTY_OBJ_ID",
            "参数值:objId不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_POSITION_ID("PARAM_FAIL_PARAM_IS_NOT_EMPTY_POSITION_ID", "参数值:positionId不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_HEADHUNTER_ID(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_HEADHUNTER_ID", "参数值:headhunterId不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_REJECTED_REASON(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_REJECTED_REASON", "参数值:rejectedReason不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_PRIORITY(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_PRIORITY", "参数值:priority不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_INTERVIEW_TYPE(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_INTERVIEW_TYPE", "参数值:interviewType不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_TYPE("PARAM_FAIL_PARAM_IS_NOT_EMPTY_TYPE",
            "参数值:type不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_STATUS("PARAM_FAIL_PARAM_IS_NOT_EMPTY_STATUS", "参数值:status不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPLOYER_ID(
            "PARAM_FAIL_PARAM_IS_NOT_EMPLOYER_ID", "参数值:employerId不能为空"), PARAM_FAIL_PARAM_IS_NOT_CONTACT("PARAM_FAIL_PARAM_IS_NOT_CONTACT", "参数值:contact不能为空"), PARAM_FAIL_PARAM_IS_NOT_CONTACT_PHONE(
            "PARAM_FAIL_PARAM_IS_NOT_CONTACT_PHONE", "参数值:contactPhone不能为空"), PARAM_FAIL_PARAM_IS_NOT_CONTACT_ADDRESS(
            "PARAM_FAIL_PARAM_IS_NOT_CONTACT_ADDRESS", "参数值:contactAddress不能为空"), PARAM_FAIL_PARAM_IS_NOT_PROPOSE_DATE_TIME(
            "PARAM_FAIL_PARAM_IS_NOT_PROPOSE_DATE_TIME", "参数值:proposeDateTime不能为空"), PARAM_FAIL_PARAM_IS_NOT_PS("PARAM_FAIL_PARAM_IS_NOT_PS", "参数值:ps不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_TERMINATED_REASON(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_TERMINATED_REASON", "参数值:terminatedReason不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_MODULE(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_MODULE", "参数值:module不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMMENT("PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMMENT",
            "参数值:comment不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_ALL_JOB_WALL("PARAM_FAIL_PARAM_IS_NOT_EMPTY_ALL_JOB_WALL", "参数值:allJobwall不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_PASSWORD(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_PASSWORD", "参数值:password不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_IDENTITY("PARAM_FAIL_PARAM_IS_NOT_EMPTY_IDENTITY",
            "参数值:identity不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMPANY_NAME("PARAM_FAIL_PARAM_IS_NOT_EMPTY_COMPANY_NAME", "参数值:companyName不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_NAME(
            "PARAM_FAIL_PARAM_IS_NOT_EMPTY_NAME", "参数值:name不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_POSITION_TITLE("PARAM_FAIL_PARAM_IS_NOT_EMPTY_POSITION_TITLE",
            "参数值:positionTitle不能为空"), PARAM_FAIL_PARAM_IS_NOT_EMPTY_TITLE("PARAM_FAIL_PARAM_IS_NOT_EMPTY_TITLE", "参数值:title不能为空"), PARAM_FAIL_PARAM_IS_NOT_ALL_EMPTY(
            "PARAM_FAIL_PARAM_IS_NOT_ALL_EMPTY", "必须传入一个参数"), PARAM_FAIL_IS_NOT_INTEGER("PARAM_FAIL_IS_NOT_INTEGER", "参数错误，参数值为整数类型"), PARAM_FAIL_IS_NOT_INTEGER_TIME(
            "PARAM_FAIL_IS_NOT_INTEGER_TIME", "参数错误，时间格式错误 例：System.currentTimeMillis()"), PARAM_FAIL_DATA_ALREADY_EXIST("PARAM_FAIL_DATA_ALREADY_EXIST",
            "添加数据失败!数据已经存在"), PARAM_FAIL_DATA_NOT_ALREADY_EXIST("PARAM_FAIL_DATA_NOT_ALREADY_EXIST", "数据不存在或者是非法数据"), EMAIL_IS_ALREADY_IN_USE(
            "EMAIL_IS_ALREADY_IN_USE", "邮箱已经被使用!"),

    VALIDATE_lINK_IS_NOT_VALID("VALIDATE_lINK_IS_NOT_VALID", "链接已失效，请重新找回密码!");

    /** 状态 **/
    private Boolean success;

    /** 错误码 **/
    private String errCode;

    /** 消息 **/
    private String message;

    /** 构造函数 默认false **/
    private ResultEnumImp(String errCode, String message) {
        this.success = false;
        this.errCode = errCode;
        this.message = message;
    }

    /** 构造函数 **/
    private ResultEnumImp(Boolean success, String errCode, String message) {
        this.success = success;
        this.errCode = errCode;
        this.message = message;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }
}
