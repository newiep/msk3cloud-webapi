package com.msk3cloud.kingdee.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author Rao
 * @Date 2022/09/08
 **/
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperateParam {

    /**
     * 创建者组织内码（非必录）
     */
    @JSONField(name = "CreateOrgId")
    private Integer createOrgId;
    /**
     * 单据编码集合，数组类型，格式：[No1,No2,...]（使用编码时必录）  No1 是字符串类型
     */
    @JSONField(name = "Numbers")
    private List<String> numbers;
    /**
     * 单据内码集合，字符串类型，格式："Id1,Id2,..."（使用内码时必录）
     */
    @JSONField(name = "Ids")
    private String ids;
    /**
     * 交互标志集合，字符串类型，分号分隔，格式："flag1;flag2;..."（非必录） 例如（允许负库存标识：STK_InvCheckResult）
     */
    @JSONField(name = "InterationFlags")
    private String interationFlags;
    /**
     * 是否允许忽略交互，布尔类型，默认true（非必录）
     */
    @JSONField(name = "IgnoreInterationFlag")
    private String ignoreInterationFlag;
    /**
     * 是否启用网控，布尔类型，默认false（非必录）
     */
    @JSONField(name = "NetworkCtrl")
    private String networkCtrl;
    /**
     * 是否检验单据关联运行中的工作流实例，布尔类型，默认false（非必录）
     */
    @JSONField(name = "IsVerifyProcInst")
    private String isVerifyProcInst;

    /**
     * 分录内码集合，逗号分隔（分录下推时必录） 注（按分录下推时，单据内码和编码不需要填,否则按整单下推）
     */
    @JSONField(name = "EntryIds")
    private String entryIds;


    /**
     * 转换规则内码，字符串类型（未启用默认转换规则时，则必录）
     */
    @JSONField(name = "RuleId")
    private String ruleId;

    /**
     * 目标单据类型内码，字符串类型（非必录）
     */
    @JSONField(name = "TargetBillTypeId")
    private String targetBillTypeId;

    /**
     * 目标组织内码，整型（非必录）
     */
    @JSONField(name = "TargetOrgId")
    private Integer targetOrgId;

    /**
     * 目标单据FormId，字符串类型，（启用默认转换规则时，则必录）
     */
    @JSONField(name = "TargetFormId")
    private String targetFormId;

    /**
     * 是否启用默认转换规则，布尔类型，默认false（非必录）
     */
    @JSONField(name = "IsEnableDefaultRule")
    private Boolean isEnableDefaultRule;

    /** 
     * 保存失败时是否暂存，布尔类型，默认false（非必录）  注（暂存的单据是没有编码的）
     */
    @JSONField(name = "IsDraftWhenSaveFail")
    private Boolean isDraftWhenSaveFail;

    /** 
     * 自定义参数，字典类型，格式："{key1:value1,key2:value2,...}"（非必录）  注（传到转换插件的操作选项中，平台不会解析里面的值）
     */
    @JSONField(name = "CustomParams")
    private Map<String, Object> customParams;

    /**
     * 转json
     * @return
     */
    public String toJson(){
        return JSON.toJSONString(this);
    }

}
